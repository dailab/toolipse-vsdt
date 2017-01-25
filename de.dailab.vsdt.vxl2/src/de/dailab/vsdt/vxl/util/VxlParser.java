package de.dailab.vsdt.vxl.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import de.dailab.vsdt.vxl.VxlStandaloneSetup;
import de.dailab.vsdt.vxl.vxl.VxlTerm;
import de.dailab.vsdt.vxl.vxl.VxlVariable;

/**
 * This is a simple implementation for parsing JADL++ code. This parser is using EMF Resource and 
 * ResourceSet. Two use cases are covered by this parser; parse JADL++ source code into a 
 * JADL++ model and serialize a JADL++ model into JADL++ source code. 
 * 
 * @author Michael Burkhardt
 * @author kuester
 */
public class VxlParser {
		
	/** resource set, for creating new XText resources */
	private final XtextResourceSet xtextResourceSet;
	
	/** recently parsed or serialized resource, holding e.g. information on parse error */
	private Resource resource = null;
	
	/** Singleton instance */
	private static VxlParser INSTANCE;

	/** Workaround for problem with existing resources, since Eclipse Juno 4.2.1 */
	private int resourceCounter = 0;
	
	/**
	 * Create Parser instance
	 */
	public static VxlParser getInstance() {
		if (INSTANCE == null) {
			INSTANCE= new VxlParser();
		}
		return INSTANCE;
	}
	
	private VxlParser() {
		Injector injector = new VxlStandaloneSetup().createInjectorAndDoEMFRegistration();
		xtextResourceSet = injector.getInstance(XtextResourceSet.class);
		xtextResourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	}

	/**
	 * 
	 * @param code
	 * @return
	 * @throws VxlParseException
	 */
	public VxlTerm parse(String code) throws VxlParseException {
		VxlParseException jpe = new VxlParseException();
		try {
			// create and load dummy resource using XText
			String dummyURL = "platform:/resource/dummy" + resourceCounter++ + ".vxl";
			URI uri = org.eclipse.emf.common.util.URI.createURI(dummyURL);
			resource = xtextResourceSet.createResource(uri);
			resource.load(new ByteArrayInputStream(code.getBytes()), xtextResourceSet.getLoadOptions());
			for (Diagnostic warn : resource.getWarnings()) {
				jpe.addException(warn.getLine(), warn.getColumn(), warn.getMessage());
			}
			for (Diagnostic err : resource.getWarnings()) {
				jpe.addException(err.getLine(), err.getColumn(), err.getMessage());
			}
		} catch (IOException e) {
			jpe.addException(0, 0, e.getMessage());
			throw jpe;
		}
		if (resource.getErrors().size() > 0) {
			throw jpe; 
		}
		return (VxlTerm) resource.getContents().get(0);
	}

	/**
	 * 
	 * @param term
	 * @return
	 * @throws VxlParseException
	 */
	public String serialize(VxlTerm term) throws VxlParseException {
		VxlParseException jpe = new VxlParseException();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		resource = xtextResourceSet.getResource(term.eResource().getURI(), true);
		try {
			resource.save(bos, xtextResourceSet.getLoadOptions());
			for(Diagnostic warn : resource.getWarnings()) {
				jpe.addException(warn.getLine(), warn.getColumn(), warn.getMessage());
			}
			for(Diagnostic err : resource.getWarnings()) {
				jpe.addException(err.getLine(), err.getColumn(), err.getMessage());
			}
		} catch (IOException e) {
			jpe.addException(0, 0, e.getMessage());
			throw jpe;
		}
		if (resource.getErrors().size() > 0) {
			throw jpe; 
		}
		return bos.toString();
	}

	/**
	 * 
	 * @return
	 */
	public List<Diagnostic> getWarnings() {
		return resource.getWarnings();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Diagnostic> getErrors() {
		return resource.getErrors();
	}
	
	/**
	 * Check whether there are any variables which's names are not contained in the 
	 * given list of allowed names.
	 *  
	 * @param allowedVariableNames	List of allowed variable names (no patterns but actual names)
	 * @return						List of variables which's names are not in the List 
	 */
	public List<VxlVariable> getUnknownVariables(List<String> allowedVariableNames) {
		List<VxlVariable> unknownVars= new ArrayList<VxlVariable>();
		for (VxlVariable var : getVariables()) {
			boolean valid= false;
			for (String s : allowedVariableNames) {
				valid |= var.getName() != null && var.getName().equals(s);
			}
			if (! valid) {
				unknownVars.add(var);
			}
		}
		return unknownVars;
	}
	
	/**
	 * @return		All Variables contained in the parsed Expression.
	 */
	public List<VxlVariable> getVariables() {
		try {
			VxlTerm term= (VxlTerm) resource.getContents().get(0);
			return getVariables(term);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * @return		All Variables contained in the given Object
	 */
	private List<VxlVariable> getVariables(EObject object) {
		List<VxlVariable> variables= new ArrayList<VxlVariable>();
		if (object instanceof VxlVariable) {
			variables.add((VxlVariable) object);
		} else {
			for (TreeIterator<EObject> i= object.eAllContents(); i.hasNext(); ) {
				variables.addAll(getVariables(i.next()));
			}
		}
		return variables;
	} 
	
}
