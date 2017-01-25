package de.dailab.vsdt.vxl.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Custom Exception type raised by the VxlParser. This can wrap 
 * multiple individual parsing errors into one throwable exception.
 *
 * @author kuester
 */
public class VxlParseException extends Throwable {
	
	private static final long serialVersionUID = 7998366745798352696L;
	
	private ArrayList<Entry> _errors = new ArrayList<Entry>();
	
	public void addException(int line, int column, String message) {
		_errors.add(new Entry(line, column, message));
	}
	
	public List<Entry> getExceptions() {
		return Collections.unmodifiableList(_errors);
	}
	
	@Override
	public String getMessage() {
		return toString();
	}
	
	@Override
	public String toString() {
		Iterator<Entry> i = _errors.iterator();
		if (!i.hasNext()) {
			return "[]";
		}
		else {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			sb.append(_errors.size());
			sb.append(" errors: ");
			for(;;) {
				Entry e = i.next();
				sb.append("Entry[");
				sb.append(e._line);
				sb.append(',');
				sb.append(e._column);
				sb.append(',');
				sb.append(e._message);
				sb.append(']');
				
				if (! i.hasNext()) {
					return sb.append(']').toString();
				}
				sb.append(", ");
			}
		}
	}
	
	/**
	 * Wrapper for a single parsing error
	 *
	 * @author kuester
	 */
	private class Entry {
		
		final int _line;
		final int _column;
		final String _message;
		
		protected Entry(int line, int column, String message) {
			_line = line;
			_column = column;
			_message = message;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("line: " + _line);
			sb.append("@"+_column);
			sb.append(":"+_message);
			return sb.toString();
		}
	}

}
