package de.dailab.vsdt.diagram.imprt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

public class VsdtDiagramImporter {
	
	private final List<Resource> from;
	
	private final Resource to;
	
	private final boolean layout;
	
	private final boolean merge;
	
	private final boolean backup;
	
	private final List<String> warnings;
	
	private final List<String> errors;

	public VsdtDiagramImporter(List<Resource> from, Resource to, boolean backup, boolean layout, boolean merge) {
		this.from = from;
		this.to = to;
		this.backup= backup;
		this.layout = layout;
		this.merge= merge;
		this.warnings= new ArrayList<String>();
		this.errors= new ArrayList<String>();
	}
	
	public List<String> getWarnings() {
		return warnings;
	}
	
	public List<String> getErrors() {
		return errors;
	}

	
	public void doImport() throws Exception {
		
		System.out.println(to);
		
		// TODO create backup of target file
		
		// iterate over source files
		for (Resource resource : from) {
			// TODO import from source file into target file

			System.out.println(resource);
			
		}
		
		// TODO save target file
		
	}
	
}
