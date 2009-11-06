package de.dailab.vsdt.trafo.bpel.export.rules;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivity;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFlow;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TProcess;
import org.xmlsoap.schemas.ws._2003._03.business.process.TScope;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSequence;
import org.xmlsoap.schemas.ws._2003._03.business.process.TWhile;

import de.dailab.vsdt.trafo.base.AbstractRule;
import de.dailab.vsdt.trafo.base.AbstractWrapper;

/**
 * Singleton Sequence Rule
 * 
 * PATTERN: A Sequence containing only one child element
 * 
 * EFFECT: The sequences will be replaced with its singleton child
 */
public class SingletonSequenceRule extends AbstractRule {
	
	protected TSequence _sequence= null;

	public static final int SEQUENCE= 0;
	
	/**
	 * Default constructor.
	 */
	public SingletonSequenceRule(EObject root) {
		super(root,"Singleton Sequence Rule");
	}
	
	@Override
	protected void resetVars() {
		_sequence= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}

	@Override
	protected void apply() {
		if (! _sequence.getActivity().isEmpty()) {
			// replace sequence with it's content (exactly one child element
			TActivity childAct= (TActivity) _sequence.getActivity().getValue(0);
			EObject contObj= _sequence.eContainer();
			if (contObj instanceof TActivityContainer) {
				TActivityContainer container= (TActivityContainer) contObj;
				container.setActivity(childAct);
			}
			if (contObj instanceof TActivityOrCompensateContainer) {
				TActivityOrCompensateContainer container= (TActivityOrCompensateContainer) contObj;
				container.setActivity(childAct);
			}
			if (contObj instanceof TFlow) {
				TFlow container= (TFlow) contObj;
				// in case of flow the index is irrelevant
				container.addActivity(-1, childAct);
			}
			if (contObj instanceof TOnMessage) {
				TOnMessage container= (TOnMessage) contObj;
				container.setActivity(childAct);
			}
			if (contObj instanceof TProcess) {
				TProcess container= (TProcess) contObj;
				container.setActivity(childAct);
			}
			if (contObj instanceof TScope) {
				TScope container= (TScope) contObj;
				container.setActivity(childAct);
			}
			if (contObj instanceof TSequence) {
				// actually, this case should be handled by the FlattenSequenceRule anyway
				TSequence container= (TSequence) contObj;
				container.addActivity(container.getActivityIndex(_sequence), childAct);
			}
			if (contObj instanceof TWhile) {
				TWhile container= (TWhile) contObj;
				container.setActivity(childAct);
			}
		}
		// remove sequence
		deleteFromOwner(_sequence);
	}
	
	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_sequence=	(TSequence)	matches.get(SEQUENCE);
	}
	
	/**
	 * wrapper for the rule
	 */
	class RuleWrapper extends AbstractWrapper {
		
		protected ProcessPackage bpel= ProcessPackage.eINSTANCE;
		
		@Override
		public void initLHSVariables() {
			addVariableType(bpel.getTSequence(), lhsVariables); // SEQUENCE
			
			//reduce domains
			for (Iterator<EObject> iter = lhsVariables.get(SEQUENCE).getDomain().iterator(); iter.hasNext();) {
				TSequence sequence= (TSequence) iter.next();
				
				if (sequence.getActivity().size() > 1) {
					// has more than one children
					iter.remove();
				}
			}
		}

		@Override
		protected void initNACVariables() {
		}
	}
	
}