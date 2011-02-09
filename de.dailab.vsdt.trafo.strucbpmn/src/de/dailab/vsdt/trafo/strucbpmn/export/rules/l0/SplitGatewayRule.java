package de.dailab.vsdt.trafo.strucbpmn.export.rules.l0;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.strucbpmn.export.AbstractVsdtRule;

/**
 * Split Gateway Rule
 * 
 * With this rule gateways with both multiple incoming and outgoing sequence
 * flows are split in two gateways, one with multiple incoming, the other with 
 * multiple outgoing sequence flows. This rule is necessary for facilitating the
 * Block Rule. After the application of this rule each gateway is either a 
 * forking gateway or a merging gateway.
 * 
 * PATTERN: a gateway with both multiple incoming and outgoing sequence flows
 * 
 * EFFECT: a second gateway is created and inserted before the exiting gateway. 
 * the incoming sequence flows are redirected to the first gateway. the gateways 
 * are connected with a plain sequence flow.
 */
public class SplitGatewayRule extends AbstractVsdtRule {
	
	public static final int GATEWAY= 0;
	
	@Override
	protected void excecute(List<EObject> matches){
		Gateway _gateway=	(Gateway)	matches.get(GATEWAY);
		
		//create gateway2
		FlowObjectContainer container= _gateway.getParent();
		Gateway gateway2= VsdtFactory.eINSTANCE.createGateway();
		gateway2.setParent(container);
		
		//change names
		String name= _gateway.getName();
		_gateway.setName(name + SUFFIX_FORK);
		gateway2.setName(name + SUFFIX_MERGE);
		
		//redirect incoming sequences
		gateway2.getIncomingSeq().addAll(_gateway.getIncomingSeq());

		//create sequence flow
		BusinessProcessDiagram bpd= _gateway.getPool().getParent();
		SequenceFlow seqFlow= VsdtFactory.eINSTANCE.createSequenceFlow();
		bpd.getConnections().add(seqFlow);
		
		//connect gateways
		seqFlow.setName(gateway2.getName() + "_to_" + _gateway.getName());
		seqFlow.setSource(gateway2);
		seqFlow.setTarget(_gateway);
	}
	
	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, bpmn.getGateway()); // GATEWAY
		
		//reduce domains
		for (Iterator<EObject> iter = lhsVariables.get(GATEWAY).getDomain().iterator(); iter.hasNext();) {
			boolean ok= true;
			Gateway gateway= (Gateway) iter.next();
			
			//both >1 incoming and outgoing sequences
			ok &= gateway.getIncomingSeq().size() > 1 && 
					gateway.getOutgoingSeq().size() > 1;
								
			if (!ok) {
				iter.remove();
			}
		}
	}

	@Override
	protected void initNACVariables() {
	}
	
}