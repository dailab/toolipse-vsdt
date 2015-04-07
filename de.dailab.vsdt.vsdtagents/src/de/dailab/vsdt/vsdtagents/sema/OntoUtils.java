package de.dailab.vsdt.vsdtagents.sema;

import java.util.Iterator;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLNamedObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.SWRLArgument;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLClassAtom;
import org.semanticweb.owlapi.model.SWRLDataPropertyAtom;
import org.semanticweb.owlapi.model.SWRLLiteralArgument;
import org.semanticweb.owlapi.model.SWRLObjectPropertyAtom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLVariable;

import de.dailab.jiactng.owlsGenerator.OWLSFactory;
import de.dailab.jiactng.owlsdescription.ServiceDescription;


/**
 * Class providing some helper methods for ontology handling.
 * 
 * XXX Not sure how to handle this best. We need a whole bunch more imports.
 * Just add owl-s-generator with all dependencies (incl. JIAC and OWLS-Desc.)
 * into NodePlugin? This would work, but where should it end? Or abandon the
 * whole "distributed with JIAC" idea and just put the import-to-VSDT action
 * into the owlsEditor-Plugin? when it will need GMF dependencies. Or try to
 * find a way to do the dependency handling via Eclipse-bultin features or
 * OSGI? Probably the best in the long-run, but no clear idea how...
 *
 * @author kuester
 */
public class OntoUtils {

	/**
	 * This method is used to reconstruct a service description after some information,
	 * particularly precondition and effect, have been lost due to serialization and
	 * de-serialization. This is done using OWL-S-Generator's OWLSFactory, reloading
	 * the ontology from its IRI.
	 * 
	 * @param service	de-serialized service description
	 * @return			same service description, re-loaded from IRI will all information
	 * @throws OWLOntologyCreationException
	 */
	public static ServiceDescription reloadOntology(ServiceDescription service) throws OWLOntologyCreationException {
		IRI iri = IRI.create(service.getIRI());
		OWLOntologyManager manager = OWLSFactory.getOWLOntologyManager();
		for (OWLOntology ontology: manager.getDirectImports(manager.getOntology(iri))) {
			manager.loadOntology(ontology.getOntologyID().getOntologyIRI());
		}
		return OWLSFactory.loadOntology(iri);
	}
	
	/**
	 * Create human-readable string representation from SWRL rule
	 * 
	 * Code taken from de.dailab.jiactng.owlseditor.util.SWRLRuleUtil
	 * 
	 * @param rule	some SWRL rule
	 * @return		human-readable string
	 */
	public static String formatSwrlRule(SWRLRule rule) {
		StringBuilder builder = new StringBuilder();
		
		if (rule.getBody().size() == 0) {
			builder.append("null");
		} else {
			for (Iterator<SWRLAtom> iterator = rule.getBody().iterator(); iterator.hasNext(); ) {
				builder.append(formatSWRLAtom(iterator.next()));
				if (iterator.hasNext()) {
					builder.append(" & ");
				}
			}
		}
		builder.append(" -> ");
		if (rule.getHead().size() == 0) {
			builder.append("null");
		} else {
			for (Iterator<SWRLAtom> iterator = rule.getBody().iterator(); iterator.hasNext(); ) {
				builder.append(formatSWRLAtom(iterator.next()));
				if (iterator.hasNext()) {
					builder.append(" & ");
				}
			}
		}
		return builder.toString();
	}
	
	/**
	 * Create human-readable string representation from SWRL atom
	 * 
	 * Code taken from de.dailab.jiactng.owlseditor.util.SWRLRuleUtil
	 * 
	 * @param rule	some SWRL atom
	 * @return		human-readable string
	 */
	private static String formatSWRLAtom(SWRLAtom atom) {
		StringBuilder builder = new StringBuilder();
		try {
			if (atom instanceof SWRLClassAtom || 
					atom instanceof SWRLDataPropertyAtom || 
					atom instanceof SWRLObjectPropertyAtom) {
				builder.append(((OWLNamedObject) atom.getPredicate()).getIRI().getFragment());
			}
		} catch (ClassCastException e) {
			builder.append(atom.toString());
		}
		builder.append("(");
		for (Iterator<SWRLArgument> iterator = atom.getAllArguments().iterator(); iterator.hasNext(); ) {
			SWRLArgument argument = iterator.next();
			try {
				if (argument instanceof SWRLVariable) {
					builder.append("?" + ((SWRLVariable) argument).getIRI().getFragment());
				} else if (argument instanceof SWRLLiteralArgument) {
					builder.append(((SWRLLiteralArgument) argument).getLiteral().getLiteral());
				} else {
					builder.append(argument.toString());
				}
			} catch (ClassCastException e) {
				builder.append(argument.toString());
			}
			if (iterator.hasNext()) {
				builder.append(", ");
			}
		}
		builder.append(")");
		return builder.toString();
	}
}
