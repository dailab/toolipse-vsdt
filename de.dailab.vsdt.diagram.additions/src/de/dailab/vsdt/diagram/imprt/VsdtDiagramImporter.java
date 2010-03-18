package de.dailab.vsdt.diagram.imprt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;

import de.dailab.vsdt.BusinessProcessSystem;

public class VsdtDiagramImporter {

	private final List<Resource> sources;

	private final Resource target;

	private final boolean layout;

	private final boolean merge;

	private final boolean backup;

	private final List<String> warnings;

	private final List<String> errors;

	public VsdtDiagramImporter(List<Resource> from, Resource to,
			boolean backup, boolean layout, boolean merge) {
		this.sources = from;
		this.target = to;
		this.backup = backup;
		this.layout = layout;
		this.merge = merge;
		this.warnings = new ArrayList<String>();
		this.errors = new ArrayList<String>();
	}

	public List<String> getWarnings() {
		return warnings;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void doImport() throws Exception {

		// create backup of target file?
		if (backup) {
			createBackup(target);
		}

		// get target BPS and 
		BusinessProcessSystem targetBps= null;
		Diagram targetDiagramRoot= null;
		for (EObject content : target.getContents()) {
			if (content instanceof BusinessProcessSystem) {
				targetBps= (BusinessProcessSystem) content;
			}
			if (content instanceof Diagram 
					&& "Vsdt_meta".equals(((Diagram) content).getType())) {
				targetDiagramRoot= (Diagram) content;
			}
		}
		
		// iterate over source files
		for (Resource resource : sources) {

			// iterate over file contents
			for (Iterator<EObject> i = resource.getContents().iterator(); i.hasNext(); ) {
				EObject content = i.next();
				
				// import BPS from source files
				if (content instanceof BusinessProcessSystem) {
					BusinessProcessSystem otherBps= (BusinessProcessSystem) content;
					targetBps.getBusinessProcesses().addAll(otherBps.getBusinessProcesses());
					targetBps.getParticipants().addAll(otherBps.getParticipants());
					targetBps.getImplementations().addAll(otherBps.getImplementations());
					targetBps.getMessages().addAll(otherBps.getMessages());
				}
				
				// import layout information
				if (layout) {
					if (content instanceof Diagram) {
						Diagram diagram = (Diagram) content;
						// import BPMN diagrams
						if ("Vsdt".equals(diagram.getType())) {
							i.remove();
							target.getContents().add(diagram);
						}
						// merge Meta diagrams
						if ("Vsdt_meta".equals(diagram.getType())) {
							targetDiagramRoot.getPersistedChildren().addAll(diagram.getPersistedChildren());
							targetDiagramRoot.getPersistedEdges().addAll(diagram.getPersistedEdges());
						}
					}
				}
			}
		}

		// save target file
		target.save(null);
	}

	protected void createBackup(Resource resource) {
		String path = resource.getURI().path();
		try {
			File f1 = new File(path);
			File f2 = new File(path + ".bak");
			InputStream in = new FileInputStream(f1);
			OutputStream out = new FileOutputStream(f2);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			
			in.close();
			out.close();
			System.out.println("Created backup of file '" + path +"'.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
