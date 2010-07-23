package de.dailab.vsdt.trafo.base.util;

import java.io.CharArrayWriter;
import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.WriterAppender;

/**
 * Just a simple class to collect logged events and error messages, delegating
 * to a logging framework while providing some additional functionality.
 * 
 * @author tkuester
 */
public class TrafoLog {
	
	public static final String PATTERN= "%d [%t] %-5p %c - %m%n";
	
	private static CharArrayWriter writer= new CharArrayWriter();
	
	/**the logger instance*/
	private static Logger logger= Logger.getLogger(TrafoLog.class.getSimpleName());
	static {
		ConsoleAppender consoleAppender= new ConsoleAppender(new PatternLayout(PATTERN));
		logger.addAppender(consoleAppender);
		WriterAppender wa= new WriterAppender(new PatternLayout(PATTERN),writer);
		logger.addAppender(wa);
	}

	/**file appender for the log file*/
	private static RollingFileAppender fileAppender= null;
	
	/**whether errors occurred during the transformation*/
	private static boolean hasErrors= false;
	/**whether warnings occurred during the transformation*/
	private static boolean hasWarning= false;
	
	/**
	 * add a file appender for a logging file
	 * 
	 * @param filename		name/path of the logging file
	 */
	public static void addFileAppender(String filename) {
		try {
			fileAppender= new RollingFileAppender(new PatternLayout(PATTERN), filename);
			fileAppender.setAppend(false);
			fileAppender.setMaxBackupIndex(3);
			logger.addAppender(fileAppender);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * remove file appender and reset hasErrors and hasWarnings
	 */
	public static void reset() {
		if (fileAppender != null) {
			logger.removeAppender(fileAppender);
			fileAppender.close();
		}
		writer.reset();
		hasErrors= false;
		hasWarning= false;
	}
	
	/**
	 * set logging level
	 */
	public static void setLogLevel(String level) {
		logger.setLevel(Level.toLevel(level));
	}
	
	/**
	 * log trace message
	 * 
	 * @param message	the message to be logged
	 */
	public static void trace(String message) {
		logger.trace(message);
	}
	
	/**
	 * log debug message
	 * 
	 * @param message	the message to be logged
	 */
	public static void debug(String message) {
		logger.debug(message);
	}
	
	/**
	 * log info message
	 * 
	 * @param message	the message to be logged
	 */
	public static void info(String message) {
		logger.info(message);
	}
	
	/**
	 * log not-yet-implemented-warning message
	 * 
	 * @param message	the message to be logged
	 */
	public static void nyi(String message) {
		warn("Not Yet Implemented: " + message);
	}
	
	/**
	 * log warning message and set hasWarnings to true
	 * 
	 * @param message	the message to be logged
	 */
	public static void warn(String message) {
		hasWarning= true;
		logger.warn(message);
	}
	
	/**
	 * log error message and set hasErrors to true
	 * 
	 * @param message	the message to be logged
	 */
	public static void error(String message) {
		hasErrors= true;
		logger.error(message);
	}
	
	/**
	 * log fatal message and set hasErrors to true
	 * 
	 * @param message	the message to be logged
	 */
	public static void fatal(String message, Throwable t) {
		hasErrors= true;
		logger.fatal(message,t);
	}
	
	public static boolean hasWarnings() {
		return hasWarning;
	}
	
	public static boolean hasErrors() {
		return hasErrors;
	}
	
	public static String getBufferedMessages() {
		return writer.toString();
	}
	
}
