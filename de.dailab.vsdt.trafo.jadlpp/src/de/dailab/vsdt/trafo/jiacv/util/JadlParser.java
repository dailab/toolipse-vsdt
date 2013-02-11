package de.dailab.vsdt.trafo.jiacv.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import de.dailab.jiactng.JadlStandaloneSetup;
import de.dailab.jiactng.jadl.Agent;
import de.dailab.jiactng.jadl.ontology.JadlParseException;

/**
 * This is a simple implementation for parsing JADL++ code. This parser is using EMF Resource and 
 * ResourceSet. Two use cases are covered by this parser; parse JADL++ source code into a 
 * JADL++ model and serialize a JADL++ model into JADL++ source code. 
 * @author Michael Burkhardt
 * @author kuester
 */
public class JadlParser {
	
	private Resource resource = null;
	private final XtextResourceSet xtextResourceSet;

	private int resourceCounter = 0;
	
	private static JadlParser INSTANCE= null;
	
	public static JadlParser getInstance() {
		if (INSTANCE == null) {
			INSTANCE= new JadlParser();
		}
		return INSTANCE;
	}
	
	
	private JadlParser() {
		Injector injector = new JadlStandaloneSetup().createInjectorAndDoEMFRegistration();
		xtextResourceSet = injector.getInstance(XtextResourceSet.class);
		xtextResourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.FALSE);
	}
	
	public List<Diagnostic> getWarnings() {
		return resource.getWarnings();
	}
	
	public List<Diagnostic> getErrors() {
		return resource.getErrors();
	}

	/**
	 * 
	 * @param jadlSourceCode
	 * @return
	 * @throws JadlParseException
	 */
	public Agent parse(String jadlSourceCode) throws JadlParseException {
		JadlParseException jpe = new JadlParseException();
		try {
			String dummyURL = "platform:/resource/dummy" + resourceCounter++ + ".jadl";
			URI jadlURI = org.eclipse.emf.common.util.URI.createURI(dummyURL);
			resource = xtextResourceSet.createResource(jadlURI);
			resource.load(new ByteArrayInputStream(
					jadlSourceCode.getBytes()), 
					xtextResourceSet.getLoadOptions());
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
		return (Agent) resource.getContents().get(0);
	}
	
	/**
	 * 
	 * @param eo
	 * @return
	 * @throws JadlParseException
	 */
	public String serialize(Agent eo) throws JadlParseException {
		
//		JadlParseException jpe = new JadlParseException();
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		resource = xtextResourceSet.getResource(jadlURI, true);
//		try {
//			resource.save(bos, xtextResourceSet.getLoadOptions());

		JadlParseException jpe = new JadlParseException();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String dummyURL = "platform:/resource/dummy" + resourceCounter++ + ".jadl";
		URI jadlURI = org.eclipse.emf.common.util.URI.createURI(dummyURL);
		resource = xtextResourceSet.createResource(jadlURI);
		resource.getContents().add(eo);
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
	
}
