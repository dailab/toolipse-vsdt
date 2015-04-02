package de.dailab.vsdt.vsdtagents.sema;


/**
 * Class providing some helper methods for ontology handling.
 * 
 * XXX Not sure how to handle this best. We need a whole bunch more imports.
 * Just add owlsGenerator with all dependencies (incl. JIAC and OWLS-Desc.)
 * into NodePlugin? This would work, but where should it end? Or abandon the
 * whole "distributed with JIAC" idea and just put the import-to-VSDT action
 * into the owlsEditor-Plugin? when it will need GMF dependencies...
 *
 * @author kuester
 */
public class OntoUtils {

//	protected final OWLOntologyManager ONTO_MANAGER = OWLSFactory.getOWLOntologyManager();
//
//	private ServiceDescription reloadOntology(ServiceDescription service) {
//		
//		ServiceDescription newService= OWLSFactory.loadOntology(service.getIRI());
//		
//		OWLOntologyManager managerTemp = OWLSFactory.getOWLOntologyManager();
//		OWLOntology onto = managerTemp.getOntology(IRI.create(newService.getIRI()));
//		for (OWLOntology ontology: managerTemp.getDirectImports(onto)) {
//			ONTO_MANAGER.loadOntology(ontology.getOntologyID().getOntologyIRI());
//		}
//		return newService;
//	}
	
}
