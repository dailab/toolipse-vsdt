package de.dailab.vsdt.trafo.text.export.stages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class extends the TextBuilder with special HTML mark-up. The resulting
 * files will have a simple yet expressive HTML mark-up.
 * 
 * @author kuester
 */
public class HtmlBuilder extends TextBuilder {
	
	public static final String CSS_FILENAME = "bpmn2text.css";

	@Override
	public String getFileExtension() {
		return ".html";
	}
	
	@Override
	public void saveAs(String directory, String filename) throws IOException {
		super.saveAs(directory, filename);
		// save CSS file as 'CSS_FILENAME'
		File file= new File(directory, CSS_FILENAME);
		file.createNewFile();
		FileWriter writer= new FileWriter(file);
		writer.write(getCss());
		writer.close();
	}

	@Override
	public TextBuilder appendHeader(String title) {
		buffer.append("<?xml version=\"1.0\"?>");
		buffer.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">").append(NL).append("\t<head>").append(NL);
		buffer.append("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />").append(NL);
		buffer.append("\t\t<link href=\"" + CSS_FILENAME + "\" rel=\"stylesheet\" type=\"text/css\" />").append(NL);
		buffer.append("\t\t<title>").append(title).append("</title>").append(NL);
		buffer.append("\t</head>").append(NL).append("\t<body>").append(NL);
		indentationLevel+= 2;
		return this;
	}
	
	@Override
	public TextBuilder appendFooter() {
		buffer.append("</body>").append(NL).append("</html>");
		indentationLevel-= 2;
		return this;
	}
	
	@Override
	public TextBuilder appendTitle(String title, int level) {
		newLine();
		buffer.append("<h" + (level+1) + ">");
		buffer.append(title);
		buffer.append("</h" + (level+1) + ">");
		newLine();
		return this;
	}
	
	@Override
	public TextBuilder beginItemize() {
		buffer.append("<ul>");
		indentationLevel++;
		newLine();
		return this;
	}

	@Override
	public TextBuilder appendItem(String s) {
		buffer.append("<li>").append(s).append("</li>");
		newLine();
		return this;
	}
	
	@Override
	public TextBuilder endItemize() {
		indentationLevel--;
		newLine();
		buffer.append("</ul>");
		newLine();
		return this;
	}
	
	@Override
	public TextBuilder beginBlock() {
		buffer.append("<div class='gen_block'>");
		indentationLevel++;
		newLine();
		return this;
	}
	
	@Override
	public TextBuilder endBlock() {
		indentationLevel--;
		newLine();
		buffer.append("</div>");
		newLine();
		return this;
	}

	@Override
	public String name(String s) {
		return "<em>" + s + "</em>";
	}
	
	@Override
	public String doc(String s) {
		return createSpan(s, "gen_doc");
	}
	
	@Override
	public String type(Enum e) {
		return createSpan(e.name().toLowerCase(), "gen_type");
	}
	
	@Override
	public String code(String s) {
		return createSpan(s, "gen_code");
	}

	/**
	 * @param s				Some String
	 * @param css_class		Some CSS class name
	 * @return				Span with given class holding the given string
	 */
	protected final String createSpan(String s, String css_class) {
		StringBuffer b= new StringBuffer();
		b.append("<span class='").append(css_class).append("'>");
		b.append(s);
		b.append("</span>");
		return b.toString(); 
	}
	
	/**
	 * @return	Return the CSS style to be used for the HTML output.
	 */
	protected String getCss() {
		StringBuffer b= new StringBuffer();
		b.append("h1, h2, h3, h4 { font-family: sans-serif }").append(NL);
		b.append("#diagram { width: 100% }").append(NL);
		b.append(".gen_block { border-left: solid thin gray; margin: 0 0 .5em .5em; padding-left: .5em; }").append(NL);
		b.append(".gen_doc { color: gray }").append(NL);
		b.append(".gen_code { font-family: monospace }").append(NL);
		b.append(".gen_type { font-variant:small-caps }").append(NL);
		return b.toString();
	}

}
