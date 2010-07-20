package de.dailab.vsdt.trafo.jiaciv.export;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;

import de.dailab.jadltools.model.xmlbind.ActModel;
import de.dailab.jadltools.model.xmlbind.BindModel;
import de.dailab.jadltools.model.xmlbind.ConditionalModel;
import de.dailab.jadltools.model.xmlbind.FormulaModel;
import de.dailab.jadltools.model.xmlbind.JADLFileModel;
import de.dailab.jadltools.model.xmlbind.LoggingModel;
import de.dailab.jadltools.model.xmlbind.PlanelementCallModel;
import de.dailab.jadltools.model.xmlbind.ReceiveSpeechactModel;
import de.dailab.jadltools.model.xmlbind.ScriptModel;
import de.dailab.jadltools.model.xmlbind.ScriptbodyModel;
import de.dailab.jadltools.model.xmlbind.SendSpeechactModel;
import de.dailab.jadltools.model.xmlbind.SeqExecutionModel;
import de.dailab.jadltools.model.xmlbind.StepModel;
import de.dailab.jadltools.model.xmlbind.StringModel;
import de.dailab.jadltools.model.xmlbind.TermModel;
import de.dailab.jadltools.model.xmlbind.TruthModel;
import de.dailab.jadltools.model.xmlbind.UnbindModel;
import de.dailab.jadltools.model.xmlbind.ValueModel;
import de.dailab.jadltools.model.xmlbind.VarDeclListModel;
import de.dailab.jadltools.model.xmlbind.VarDeclModel;
import de.dailab.jadltools.model.xmlbind.VarModel;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.trafo.jiaciv.util.JiacVisitorConstants;
import de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression;

/**
 * This class provides some methods for creating various JIAC elements.
 * This class is used to reduce code duplication and to provide an easier
 * understanding of the visitor and the rules.
 * 
 * @author tkuester
 */
public class JiacMappingAssistant implements JiacVisitorConstants {

	/**reference back on the visitor, for logging and getting some mapped elements*/
	private Bpmn2JiacElementMapping visitor= null;
	
	/**
	 * Constructor
	 * 
	 * @param visitor	the visitor creating this assistant
	 */
	public JiacMappingAssistant(Bpmn2JiacElementMapping visitor) {
		this.visitor= visitor;
	}
	
	
	/**
	 * Create new ActModel with the given name. This method automatically creates some default
	 * "true" precondition and effect and sets the execution type to "script".
	 * 
	 * @param name	the action element's name
	 * @return		new action element
	 */
	public ActModel createActModel(String name) throws JAXBException {
		ActModel actModel= jadlFac.createActModel();
		actModel.setName(name);
		actModel.setExectype("script");
		TruthModel truthModel= jadlFac.createTruthModel();
		truthModel.setValue("true");
		actModel.setPrecondition(truthModel);
		truthModel= jadlFac.createTruthModel();
		truthModel.setValue("true");
		actModel.getEffect().add(truthModel);
		return actModel;
	}
	
	/**
	 * Create a new logging model with the given message.
	 * 
	 * @param message	the message to log
	 * @param level		the log level: -1: none, 0: error, 1: warn, 2 info, 3: debug
	 * @return			logging model
	 */
	public LoggingModel createLogModel(String message, String level) throws JAXBException {
		LoggingModel logModel= jadlFac.createLoggingModel();
		StringModel stringModel= jadlFac.createStringModel();
		stringModel.setString(message);
		logModel.setMessage(stringModel);
		logModel.setLevel(level);
		return logModel;
	}
	
	/**
	 * Map the given list of assignments, if any, and put them in a sequence together with the given script element.
	 * 
	 * @param scriptBodyModel	some existing script body model
	 * @param assignments		a list of assignments, e.g. of a process or a flow object
	 * @return					the SBM if the list was empty, otherwise a sequence with the assignments and the SBM 
	 * @throws JAXBException
	 */
	public ScriptbodyModel addAssignmentMappings(ScriptbodyModel scriptBodyModel, List<Assignment> assignments) throws JAXBException {
		if (assignments.isEmpty()) {
			return scriptBodyModel;
		} else {
			//create wrapping sequence for the activity and its assignments
			SeqExecutionModel seqModel= jadlFac.createSeqExecutionModel();
			
			//get assignments for the flow objects, which are mapped to bind models, each wrapped in a step model
			List<StepModel> startAssigns= createAssignsFromList(assignments, AssignTimeType.START);
			List<StepModel> endAssigns= createAssignsFromList(assignments, AssignTimeType.END);
			
			//build sequence
			seqModel.getSteps().addAll(startAssigns);
			if (scriptBodyModel != null) {
				if (scriptBodyModel instanceof SeqExecutionModel) {
					SeqExecutionModel seq2 = (SeqExecutionModel) scriptBodyModel;
					seqModel.getSteps().addAll(seq2.getSteps());
				} else {
					seqModel.getSteps().add(scriptBodyModel);
				}
			}
			seqModel.getSteps().addAll(endAssigns);
			
			return seqModel;
		}
	}
	
	/**
	 * Create a new StepModel holding a bind or unbind statement, depending on the given TermModel.
	 * 
	 * @param varModel		variable to assign expression to
	 * @param termModel		the term to bind to the variable or null to create a unbind
	 * @return				the newly created stepModel holding a bind or unbind
	 */
	public StepModel createAssign(VarModel varModel, TermModel termModel) throws JAXBException {
		//create wrapping step model
		StepModel stepModel= jadlFac.createStepModel();
		if (termModel != null) {
			//create bind model
			BindModel bindModel= jadlFac.createBindModel();
			bindModel.setVar(varModel);
			bindModel.setValue(termModel);
			stepModel.setBind(bindModel);
		} else {
			//create unbind model
			UnbindModel unbindModel= jadlFac.createUnbindModel();
			unbindModel.setVar(varModel);
			stepModel.setUnbind(unbindModel);
		}
		return stepModel;
	}
	
	/**
	 * Iterates the given list of assignments and creates a bind/unbind statement for each assignment
	 * with the given assign time type. The bind/unbinds are then wrapped in stepModels and put in the list.
	 *  
	 * @param assignments	list with all the BPMN assignments	
	 * @param assignTime	include assignments with this assignTime (if null, include all)
	 * @return				the assignment or null, if the assign is empty
	 */
	public List<StepModel> createAssignsFromList(List<Assignment> assignments, AssignTimeType assignTime) throws JAXBException {
		List <StepModel> assigns= new ArrayList<StepModel>();
		for (Iterator<Assignment> iter = assignments.iterator(); iter.hasNext();) {
			Assignment assignment= iter.next();
			if (assignTime == null || assignment.getAssignTime() == assignTime) {
				VarModel varModel= createVarModel(assignment.getTo());
				TermModel termModel= JiacMiniParser.parseTerm(assignment.getFrom());
				StepModel assign= createAssign(varModel, termModel);
				assigns.add(assign);
			}
		}
		return assigns;
	}
	
	/**
	 * Create a VarModel from a BPMN Property.
	 * 
	 * @param property	some property
	 * @return			variable model with same name
	 */
	public VarModel createVarModel(Property property) throws JAXBException {
		VarModel varModel= null;
		if (property != null) {
			varModel= jadlFac.createVarModel();
			varModel.setVariable(property.getName());
		}
		return varModel;
	}
	
	
	/**
	 * Creates a new Variable Declaration Model and adds it to the Script's variables.
	 * If a variable with the same name already exists the variable is not created,
	 * instead the existing variable is returned.
	 * 
	 * @param name			variable name
	 * @param type			variable type
	 * @param initValue		variable initial value (or null)
	 * @param scriptModel	the script declaring the variables
	 * @param noDuplicate	do not create variable, if variable with same name already exists
	 * @return				the variable
	 */
	public VarDeclModel createVariable(String name, String type, ValueModel initValue, ScriptModel scriptModel, boolean noDuplicate) throws JAXBException {
		//get variable declarations list
		VarDeclListModel varDeclListModel= scriptModel.getLocalVars();
		if (varDeclListModel == null) {
			varDeclListModel= jadlFac.createVarDeclListModel();
			scriptModel.setLocalVars(varDeclListModel);
		}
		//look for variable with same name
		if (noDuplicate) {
			for (Iterator iter = varDeclListModel.getVariable().iterator(); iter.hasNext();) {
				VarDeclModel element = (VarDeclModel) iter.next();
				if (element.getName().equals(name)) {
					return element;
				}
			}
		}
		//create, insert and return variable
		VarDeclModel varDeclModel= jadlFac.createVarDeclModel();
		varDeclModel.setName(name);
		varDeclModel.setType(type);
		varDeclModel.setInitvalue(initValue);
		varDeclListModel.getVariable().add(varDeclModel);
		return varDeclModel;
	}
	
	
	/**
	 * Map some BPMN element's properties set. For each property a new variable declaration is added to
	 * the script's variable declarations list.
	 * 
	 * @param properties	list of BPMN properties
	 * @param scriptModel	script to hold the resulting variables
	 */
	public void visitProperties(List<Property> properties, ScriptModel scriptModel) throws JAXBException {
		for (Iterator<Property> iter = properties.iterator(); iter.hasNext();) {
			//create variable and insert into script's variable list
			Property property= iter.next();
			createVariable(property.getName(),property.getType(),null,scriptModel,true);
		}
	}
	
	
	/**
	 * Create a new JADL block structure according to the given gateway type.
	 * 
	 * @param fork	some forking gateway
	 * @return		a JIAC block structure
	 */
//	@Deprecated
//	public ScriptbodyModel createBlockStructure(Gateway fork, Gateway merge) throws JAXBException {
//		//default: block
//		ScriptbodyModel block= jadlFac.createParExecutionModel();
//		if (fork != null) {
//			if (fork.getGatewayType() == GatewayType.XOR_DATA_LITERAL ) {
//				//create branch model
//				StepModel stepModel= jadlFac.createStepModel();
//				BranchModel branchModel= jadlFac.createBranchModel();
//				branchModel.setType("branch");
//				stepModel.setBranch(branchModel);
//				block= stepModel;
//				
//				ConditionalModel condModel= createPlainConditional(fork.getName() + "_conditional", fork);
//				visitor.mapConditionalModel(fork, condModel);
//				
//				branchModel.setPlanelement(createPlanelementCallModel(condModel.getName()));
//			}
//			if (fork.getGatewayType() == GatewayType.XOR_EVENT_LITERAL ) {
//				//todo (branch (receive)) (what to do with timer event after the XOR_event_gateway?)
//				
//				AltExecutionModel altModel= jadlFac.createAltExecutionModel();
//				block= altModel;
//			}
//			if (fork.getGatewayType() == GatewayType.OR_LITERAL ) {
//				//create par of alts with seq with eval (this is done via rules)
//			}
//			if (fork.getGatewayType() == GatewayType.COMPLEX_LITERAL ) {
//				//complex gateway??? no mapping (par)
//			}
//		} else if (merge != null) {
//			if (merge.getGatewayType() == GatewayType.AND_LITERAL) {
//				//keep par
//			}
//			if (merge.getGatewayType() == GatewayType.XOR_DATA_LITERAL ||
//					merge.getGatewayType() == GatewayType.OR_LITERAL) {
//				block= jadlFac.createAltExecutionModel();
//			}
//		}
//		return block;
//	}
	
	/**
	 * Create a simple conditional model with the given name.
	 * The first formula is given in the second parameter, the second formula is always true.
	 * The conditional is automatically inserted into the flowobject's process' jadlFile.
	 * If the given formula is null then a "unknown" is inserted instead.
	 * 
	 * @param name			the conditonal's name
	 * @param flowObject	some FlowObject (to resolve the JadlFile via it's process
	 * @param formula		first formula
	 * @return				conditional
	 */
	public ConditionalModel createSimpleConditional(String name, FlowObject flowObject, FormulaModel formula) throws JAXBException {
		//case 1: formula given as parameter
		if (formula == null) {
			formula= jadlFac.createTruthModel();
			((TruthModel) formula).setValue("unknown");
		}
		
		//case 2: true (taken if the parameter formula does not apply)
		TruthModel truthModel= jadlFac.createTruthModel();
		truthModel.setValue("true");
		
		ConditionalModel conditionalModel= createPlainConditional(name, flowObject);
		conditionalModel.getFormula().add(formula);
		conditionalModel.getFormula().add(truthModel);
		return conditionalModel;
	}
	
	/**
	 * Create and insert new plain conditional. The conditional is inserted in the given 
	 * flowobject's process' jadlFile.
	 * 
	 * @param name			name for the conditional
	 * @param flowObject	some FlowObject (to resolve the JadlFile via it's process
	 * @return				new empty conditional
	 * @throws JAXBException
	 */
	public ConditionalModel createPlainConditional(String name, FlowObject flowObject) throws JAXBException {
		ConditionalModel conditionalModel= jadlFac.createConditionalModel();
		conditionalModel.setName(name);
		
		JADLFileModel jadlFile= (JADLFileModel) visitor.getWrapper().getMapping(flowObject.getPool());
		jadlFile.getConditional().add(conditionalModel);
		
		return conditionalModel;
	}
	
	
	/**
	 * Create PlanElement call model
	 * 
	 * @param name	the name of the PlanElement to call
	 * @return		new plan element call model
	 * @throws JAXBException
	 */
	public PlanelementCallModel createPlanelementCallModel(String name) throws JAXBException {
		PlanelementCallModel peCall= jadlFac.createPlanelementCallModel();
		peCall.setPlanelement(name);
		return peCall;
	}
	
	/**
	 * Create send speech-act model
	 * TODO add additional parameters
	 * 
	 * @param name			the name
	 * @param jadlFileModel	JADL file to insert the speech-act into
	 * @return				new send speech-act model
	 * @throws JAXBException
	 */
	public SendSpeechactModel createSendSpeechact(String name, JADLFileModel jadlFileModel) throws JAXBException {
		SendSpeechactModel send= jadlFac.createSendSpeechactModel();
		send.setName(name);
		
		jadlFileModel.getSendSpeechact().add(send);
		return send;
	}
	
	/**
	 * Create receive speech-act model
	 * TODO add additional parameters
	 * 
	 * @param name			the name
	 * @param jadlFileModel	JADL file to insert the speech-act into
	 * @return				new receive speech-act model
	 * @throws JAXBException
	 */
	public ReceiveSpeechactModel createReceiveSpeechact(String name, JADLFileModel jadlFileModel) throws JAXBException {
		ReceiveSpeechactModel receive= jadlFac.createReceiveSpeechactModel();
		receive.setName(name);
		
		jadlFileModel.getReceiveSpeechact().add(receive);
		return receive;
	}
	
	/**
	 * Create a simple log info model
	 * 
	 * @param message	message to log
	 * @return			log info
	 * @throws JAXBException
	 */
	public StepModel createLogInfo(String message) throws JAXBException {
		StepModel stepModel= jadlFac.createStepModel();
		stepModel.setLogging(createLogModel(message,"info"));
		return stepModel;
	}
	
	public String getCondition(Expression expression) {
		if (expression == null) {
			return null;
		}
		if (expression instanceof DisjunctiveExpression) {
			DisjunctiveExpression disjunctive = (DisjunctiveExpression) expression;
			StringBuffer buff= new StringBuffer();
			for (int i=0; i<disjunctive.getExpressions().size(); i++) {
				if (i > 0) {
					buff.append(" or ");
					buff.append("( ");
					buff.append(disjunctive.getExpressions().get(i));
					buff.append(" )");
				}
			}
			return buff.toString();
		} else {
			return expression.getExpression();
		}
	}
}
