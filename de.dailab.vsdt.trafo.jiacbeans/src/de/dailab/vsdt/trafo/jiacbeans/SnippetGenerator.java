package de.dailab.vsdt.trafo.jiacbeans;

import java.util.Map;

import jiacbeans.CodeElement;
import jiacbeans.IfThenElse;
import jiacbeans.Method;
import jiacbeans.Parallel;
import jiacbeans.Runner;
import jiacbeans.Script;
import jiacbeans.Sequence;
import jiacbeans.TryCatch;
import jiacbeans.Variable;
import jiacbeans.While;

/**
 * This class collects the various methods for generating code snippets, which
 * were formerly scattered to several toJavaCode() and toString() methods of
 * the individual classes.
 * 
 * @author kuester
 */
public class SnippetGenerator {

	private static final String NL = Util.NL;
	
	/**
	 * Generate Java Code from given Script
	 * 
	 * @param object		some Script object
	 * @param indent		auto-indent the generated code?
	 * @return				corresponding Java code snippet
	 */
	public static String scriptToCode(Script object, boolean indent) {
		String code = null;
		if (object instanceof CodeElement) {
			code = codeElementToCode((CodeElement) object);
		}
		if (object instanceof IfThenElse) {
			code = ifThenElseToCode((IfThenElse) object);
		}
		if (object instanceof Parallel) {
			code = parallelToCode((Parallel) object);
		}
		if (object instanceof Runner) {
			code = runnableToCode((Runner) object);
		}
		if (object instanceof Sequence) {
			code = sequenceToCode((Sequence) object);
		}
		if (object instanceof TryCatch) {
			code = tryCatchToCode((TryCatch) object);
		}
		if (object instanceof While) {
			code = whileToCode((While) object);
		}
		if (code != null && indent) {
			code = Util.indent(code);
		}
		return code;
	}

	/**
	 * Create Java code according to given element
	 */
	private static String codeElementToCode(CodeElement element) {
		return element.getCode();
	}

	/**
	 * Create Java if-then-else block from given element
	 */
	private static String ifThenElseToCode(IfThenElse element) {
		String code = "";
		code += "if (" + element.getCondition() + ") {" + NL;
		if (element.getThenBranch() != null) {
			code += scriptToCode(element.getThenBranch(), true);
		}
		code += "}";
		if (element.getElseBranch() != null) {
			code += " else {" + NL;
			code += scriptToCode(element.getElseBranch(), true);
			code += "}";
		}
		return code;
	}

	/**
	 * Create, start and join Java threads according to given element
	 */
	private static String parallelToCode(Parallel element) {
		int counter = 0;
		String result  = "";
		for (Script branch : element.getBranches()) {
			counter++;
			String branchName = element.getBranchPrefix() + "_branch" + counter;
			result += "Thread " + branchName + " = new Thread() {" + NL;
			result += "\t public void run() {" + NL;
			result += Util.indent(scriptToCode(branch, true));
			result += "\t}" + NL;
			result += "};" + NL;
		}
		int started = 0;
		while (started < counter) {
			started++;
			result += element.getBranchPrefix() + "_branch" + started + ".start();" + NL;
		}
		started = 0;
		result += "try {" + NL;
		while (started < counter) {
			started++;
			result += "\t" + element.getBranchPrefix() + "_branch" + started + ".join();" + NL;
		}
		result += "} catch(InterruptedException e) {}";
		return result;
	}

	/**
	 * Create Java thread definition from given element
	 */
	private static String runnableToCode(Runner element) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("Thread %s = new Thread(new Runnable() {", element.getVariableName())).append(NL);
		buffer.append("\tpublic void run() {").append(NL);
		buffer.append(Util.indent(scriptToCode(element.getRunContent(), true)));
		buffer.append("\t}").append(NL);
		buffer.append("});");
		return buffer.toString();
	}

	/**
	 * Create semicolon-separated sequence of Java statements from given element
	 */
	private static String sequenceToCode(Sequence element) {
		String result = "";
		for (Script script : element.getScripts()) {
			result += scriptToCode(script, false) + NL;
		}
		return result;
	}

	/**
	 * Create Java try-catch block from given element
	 */
	private static String tryCatchToCode(TryCatch element) {
		String result = "try {" + NL;
		if (element.getTry() != null) {
			result += scriptToCode(element.getTry(), true);
		}
		for (Map.Entry<String, Script> entry : element.getCatches().entrySet()) {
			result += "} catch (" + entry.getKey() + " e) {" + NL;
			Script content = entry.getValue();
			if (content != null) {
				result += scriptToCode(content, true);
			}
		}
		result += "}";
		if (element.getFinally() != null) {
			result += "finally {" + NL;
			result += scriptToCode(element.getFinally(), true);
			result += "}";
		}
		return result;
	}

	/**
	 * Create Java while loop from given element
	 */
	private static String whileToCode(While element) {
		String result = "while (" + element.getCondition() + ") {" + NL;
		if (element.getContent() != null) {
			result += scriptToCode(element.getContent(), true);
		}
		result += "}";
		return result;
	}
	
	/**
	 * Create Java method declaration from given method element
	 * 
	 * @param element	some method object
	 * @return			Java code for method declaration and body
	 */
	public static String methodToCode(Method element) {
		String params = Util.join(element.getParameters(), ", ", new Util.ObjToStrFunction<Variable>() {
			public String toString(Variable o) {
				return o.getType() + " " + o.getName();
			}
		});
		String exceptions= element.getThrows().isEmpty() ? "" : 
				" throws " + Util.join(element.getThrows(), ", ", null);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("%s %s %s(%s)%s {",
				element.getVisibility(), element.getReturnType(),
				element.getName(), params, exceptions)).append(NL);
		if (element.getContent() != null) {
			buffer.append(scriptToCode(element.getContent(), true));
		}
		buffer.append("}");
		return buffer.toString();
	}


}
