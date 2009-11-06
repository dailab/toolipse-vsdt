package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import starter.AbstractProcessStarter;
import starter.EnergySavingProcessStarter;
import starter.LightAlarmProcessStarter;

/**
 * Servlet implementation class for Servlet: RuleActivationServlet
 */
@SuppressWarnings("serial")
public class RuleActivationServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	
	public static final String ACTION_INIT= "init";
	public static final String ACTION_DEPLOY= "deploy";
	public static final String ACTION_START= "start";
	public static final String ACTION_STOP= "stop";
	public static final String ACTION_RESET= "reset";
	public static final String ACTION_RELOAD= "reload";
	
	public static final String pathToPropertiesFile= "../conf/ProcessStarter.properties";
	
	/** known process starters */
	protected List<AbstractProcessStarter> processStarters= new ArrayList<AbstractProcessStarter>();
	
	public RuleActivationServlet() {
		super();
		AbstractProcessStarter.logDelimeter= "<br>";
		processStarters.add(new EnergySavingProcessStarter(pathToPropertiesFile));
		processStarters.add(new LightAlarmProcessStarter(pathToPropertiesFile));
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer buffer= new StringBuffer();
		int processID= -1;
		AbstractProcessStarter starter= null;

		// get parameters
		String parRuleID= request.getParameter("ruleID");
		String parState= request.getParameter("state");
		String parRuleName= request.getParameter("ruleName");
		String parAction= request.getParameter("action");
		
		// display header
		buffer.append("<html><head><title>Rule Activation Servlet</title></head><body>");
		buffer.append("<h2>Rule Activation Servlet</h2>");
		buffer.append("<h3>Parameters</h3>");
		buffer.append("<ul>" +
				"<li><b>ruleID : int</b> --- ID of the Rule to operate</li>" +
				"<li><b>ruleName:String</b> --- Name of the Rule to operate</li>" +
				"<li><b>state: {1|0}</b> --- Desired State for the selected Rule (1=on, 0=off)</li>" +
				"<li><b>action: {init|deploy|start|stop|reset|reload}</b> --- Action to invoke for the selected Rule</li>" +
				"</ul>");
		buffer.append("Either RuleID or RuleName are needed for selecting the Rule<br>" +
				"Either State or Action are required for stating, stopping etc. the Rule");
		
		// display process selection buttons
		buffer.append("<h3>Rules</h3>");
		buffer.append("<ul>");
		for (AbstractProcessStarter s : processStarters) {
			buffer.append(getHtmlProcessButton(s.getProcessName()));
		}
		buffer.append("</ul>");
		
		// get process starter
		try {
			starter= getStarterByID(Integer.parseInt(parRuleID));
		} catch (Exception e) {
			starter= getStarterByName(parRuleName);
		}
		if (starter != null) {
			processID= starter.getProcessID();
			buffer.append("<b>Selected Rule:</b> " + starter.getProcessName() + ", ID: " + starter.getProcessID());
		} else {
			buffer.append("<i>No Rule selected</i>");
			buffer.append("</body></html");
			response.getWriter().write(buffer.toString());
			return;
		}
		
		// evaluate action
		if (ACTION_INIT.equals(parAction)) {
			starter.init();
		}
		if (ACTION_DEPLOY.equals(parAction)) {
			starter.deploy();
		}
		if (ACTION_START.equals(parAction) || "1".equals(parState)) {
			starter.start();
		}
		if (ACTION_STOP.equals(parAction) || "0".equals(parState)) {
			starter.stop();
		}
		if (ACTION_RESET.equals(parAction)) {
			starter.reset();
		}
		if (ACTION_RELOAD.equals(parAction)) {
			starter.reloadProperties();
		}

		// display action buttons
		buffer.append("<h3>Actions</h3>");
		buffer.append("<ul>");
		buffer.append(getHtmlActionButton(processID, "init", "Initialize the required Web Services"));
		buffer.append(getHtmlActionButton(processID, "deploy", "Deploy the Rule to the SHEA GUI, send Notification"));
		buffer.append(getHtmlActionButton(processID, "start", "Start the Rule"));
		if (starter.isStoppable()) {
			buffer.append(getHtmlActionButton(processID, "stop", "Stop the Rule"));
		}
		buffer.append(getHtmlActionButton(processID, "reset", "Reset the involved Webservices, remove Rule from SHEA GUI"));		
		buffer.append(getHtmlActionButton(processID, "reload", "Reload Properties, i.e. Webservice endpoints and parameters"));		
		buffer.append("</ul>");
		
		buffer.append("<h3>Logged Messages</h3>");
		buffer.append(starter.getLog().toString());
		
		buffer.append("</body></html");
		response.getWriter().write(buffer.toString());
	}

	private String getHtmlProcessButton(String ruleName) {
		return "<li><a href=\"?ruleName="+ruleName+"\">"+ruleName+"</a></li>";
	}
	
	private String getHtmlActionButton(int processID, String action, String description) {
		return "<li><a href=\"?ruleID="+processID+"&action="+action+"\">"+action+"</a>: "+description+"</li>";
	}
	
	private AbstractProcessStarter getStarterByID(int id) {
		for (AbstractProcessStarter starter : processStarters) {
			if (starter.getProcessID() == id) {
				return starter;
			}
		}
		return null;
	}
	
	private AbstractProcessStarter getStarterByName(String name) {
		for (AbstractProcessStarter starter : processStarters) {
			if (starter.getProcessName().equals(name)) {
				return starter;
			}
		}
		return null;
	}

}