package de.dailab.vsdt.trafo.text.export.stages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This is a pseudo-abstract superclass for all kinds of text / documentation
 * generation helper classes. It provides a number of methods, some derived
 * from StringBuilder, but also some methods implicating some form of logical
 * mark-up, e.g. beginItemize and appendItem.  While this class will produce
 * some basic text files, with a bit Wiki-like mark-up, subclasses might e.g.
 * implement these methods so they produce HTML or TeX mark-up.
 * 
 * While this class shares some methods and principles with StringBuilder it
 * does not inherit from this class to restrict the user on some of the methods
 * and to provide a more compact interface.
 *  
 * @author kuester
 */
public class TextBuilder {

	public static final String NL= System.getProperty("line.separator");
	public static final String INDENT= "\t";

	/** StringBuffer holding the actual text */ 
	protected StringBuffer buffer;
	
	/** level of indentation */
	protected int indentationLevel= 0;
	
	/** (file) name for this builder */
	protected String name;
	
	/**
	 * Create new TextBuilder
	 */
	public TextBuilder() {
		buffer= new StringBuffer();
	}

	/**
	 * @return	the extension files of this format should be stored with
	 */
	public String getFileExtension() {
		return ".txt";
	}
	
	/**
	 * Save the content of the TextBuilder in a way appropriate for the content
	 * in a file with the given filename in the given directory.  The Extension
	 * is taken from the method {@link #getFileExtension()}.  If the file or
	 * the directory do not exist, they are created.  Existing files may be 
	 * overwritten in the process.
	 *  
	 * @param directory		absolute path of directory where to save the file
	 * @param filename		name of the file to save, without extension
	 * @throws IOException
	 */
	public void saveAs(String directory, String filename) throws IOException {
		File file= new File(directory, filename + getFileExtension());
		if (! file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		file.createNewFile();
		FileWriter writer= new FileWriter(file);
		writer.write(getText());
		writer.close();
	}
	
	/**
	 * @return	the text already inserted into this TextBuilder (including mark-up)
	 */
	public String getText() {
		return buffer.toString();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/*
	 * Adding text elements
	 */
	
	/**
	 * Simply add some unformatted text
	 * @see StringBuilder#append(String)
	 */
	public final TextBuilder append(String s) {
		buffer.append(escape(s));
		return this;
	}
	
	/**
	 * Simply add some unformatted text followed by a new line
	 * @see StringBuilder#append(String)
	 */
	public final TextBuilder appendLine(String s) {
		append(s);
		newLine();
		return this;
	}
	
	/**
	 * Insert a Line Break and restore indentation. Change indentation by delta_indent.
	 */
	public final TextBuilder newLine(int delta_indent) {
		indentationLevel+= delta_indent;
		buffer.append(NL).append(getIndentationSpace());
		return this;
	}
	
	/**
	 * Insert a Line Break and restore indentation.
	 */
	public final TextBuilder newLine() {
		return newLine(0);
	}
	
	/**
	 * Insert some title of a given level. Level 0 is the top level title, level
	 * 1 is a sub title, and so on. If anchor is not null, it is used as a label
	 * or ID for the header, so it can be used as a target for hyperlinks.
	 */
	public TextBuilder appendTitle(String title, int level, String anchor) {
		newLine();
		String s= "=";
		for (int i=0; i<level; i++) {
			s+= "=";
		}
		buffer.append(s).append(title).append(s);
		newLine();
		return this;
	}
	
	/*
	 * Document structure and organization
	 */
	
	/**
	 * Append a File header, if needed.
	 */
	public TextBuilder appendHeader(String title) {
		return this;
	}
	
	/**
	 * Append a File footer, if needed.
	 */
	public TextBuilder appendFooter() {
		return this;
	}

	/**
	 * Start a new Block (if supported), e.g. by adding indentation.
	 */
	public TextBuilder beginBlock() {
		newLine(+1);
		return this;
	}
	
	/**
	 * End a block
	 */
	public TextBuilder endBlock() {
		newLine(-1);
		return this;
	}

	/**
	 * Start an itemization
	 */
	public TextBuilder beginItemize() {
		newLine(+1);
		return this;
	}
	
	/**
	 * End an itemization
	 */
	public TextBuilder endItemize() {
		newLine(-1);
		return this;
	}

	/**
	 * Add an item (should be called only when in an itemization)
	 */
	public TextBuilder appendItem(String s) {
		buffer.append("* ").append(s);
		newLine();
		return this;
	}
	
	/**
	 * Start a Table
	 */
	public TextBuilder beginTable() {
		newLine(+1);
		return this;
	}
	
	/**
	 * End a Table
	 */
	public TextBuilder endTable() {
		newLine(-1);
		return this;
	}

	/**
	 * Add a table line (should be called only when in a table)
	 */
	public TextBuilder appendTableLine(String... cells) {
		for (String cell : cells) {
			buffer.append(cell + "\t");
		}
		newLine();
		return this;
	}
	
	/**
	 * Add a reference to an image.
	 */
	public TextBuilder appendImage(String path, String label) {
		buffer.append("[ ").append(path).append(" | ").append(label).append(" ]");
		newLine();
		return this;
	}

	/**
	 * Return the string wrapped in some code-mark-up
	 */
	public String code(String s) {
		return s;
	}
	
	/**
	 * Return the string wrapped in some enum-literal-mark-up
	 */
	public String type(Enum<?> e) {
		return e.name();
	}
	
	/**
	 * Return the string wrapped in some mark-up for names
	 */
	public String name(String s) {
		return s;
	}
	
	/**
	 * Return the string wrapped in some mark-up for documentation tags
	 */
	public String doc(String s) {
		return s;
	}
	
	/**
	 * Return the string wrapped in a reference to the given anchor
	 */
	public String ref(String s, String anchor) {
		return s;
	}
	
	protected String getIndentationSpace() {
		StringBuffer b= new StringBuffer();
		for (int i=0; i<indentationLevel; i++) {
			b.append(INDENT);
		}
		return b.toString();
	}
	
	/**
	 * Escape special characters, if necessary
	 */
	protected String escape(String s) {
		return s;
	}
	
}
