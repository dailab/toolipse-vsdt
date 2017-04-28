package de.dailab.jiactng.sema2.planning.util;

import de.dailab.jiactng.owlsdescription.ServiceDescription;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.SWRLRule;

import java.util.*;

/**
 * Created by borchert on 11.05.2015.
 */
public class GroundedRatedServiceDescription extends RatedServiceDescription {

    //List of individual bindings, corresponding to the order of sd.getProcess().getInputParameters();
    private List<OWLNamedIndividual> inputBinding = new ArrayList<>();
    private Map<OWLClass, Set<OWLNamedIndividual>> inputBindingClassMapping = new HashMap<>();

    private Set<SWRLRule> preparedPreconditions = null;
    private Set<SWRLRule> preparedEffects = null;
    private Set<OWLAxiom> effectAxioms = null;
    private Set<OWLAxiom> preconditionAxioms = null;

    public GroundedRatedServiceDescription(ServiceDescription sd){
        super(sd);
    }

    public List<OWLNamedIndividual> getInputBinding() {
        return inputBinding;
    }

    public void setInputBinding(List<OWLNamedIndividual> inputBinding) {
        this.inputBinding = inputBinding;
    }

    public Map<OWLClass, Set<OWLNamedIndividual>> getInputBindingClassMapping() {
        return inputBindingClassMapping;
    }

    public void setInputBindingClassMapping(Map<OWLClass, Set<OWLNamedIndividual>> inputBindingClassMapping) {
        this.inputBindingClassMapping = inputBindingClassMapping;
    }

    public void addInputBinding( OWLClass cl , OWLNamedIndividual ind){
        Set<OWLNamedIndividual> inds = this.inputBindingClassMapping.get(cl);
        if( inds == null){
            inds = new HashSet<>();
        }
        inds.add(ind);
        this.inputBinding.add(ind);
    }

    public Set<SWRLRule> getPreparedPreconditions() {
        return preparedPreconditions;
    }

    public void setPreparedPreconditions(Set<SWRLRule> preparedPreconditions) {
        this.preparedPreconditions = preparedPreconditions;
    }

    public Collection<SWRLRule> getPreparedEffects() {
        return preparedEffects;
    }

    public void setPreparedEffects(Set<SWRLRule> preparedEffects) {
        this.preparedEffects = preparedEffects;
    }

    public void setEffectAxioms(Set<OWLAxiom> axioms){this.effectAxioms = axioms;}

    public Set<OWLAxiom> getEffectAxioms(){return this.effectAxioms;}

    public Set<OWLAxiom> getPreconditionAxioms() {
        return preconditionAxioms;
    }

    public void setPreconditionAxioms(Set<OWLAxiom> preconditionAxioms) {
        this.preconditionAxioms = preconditionAxioms;
    }
}
