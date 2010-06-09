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
		newLine();
		buffer.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">");
		newLine(+1);
		buffer.append("<head>");
		newLine(+1);
		buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		newLine();
		buffer.append("<link href=\"" + CSS_FILENAME + "\" rel=\"stylesheet\" type=\"text/css\" />");
		newLine();
		buffer.append("<title>").append(title).append("</title>");
		newLine(-1);
		buffer.append("</head>");
		newLine();
		buffer.append("<body>");
		newLine(+1);
		return this;
	}
	
	@Override
	public TextBuilder appendFooter() {
		newLine(-1);
		buffer.append("</body>");
		newLine(-1);
		append("</html>");
		return this;
	}
	
	@Override
	public TextBuilder appendTitle(String title, int level, String anchor) {
		newLine();
		String id = anchor != null ? " id=\"" + anchor + "\"" : "";
		buffer.append("<h" + (level+1) + id + ">");
		buffer.append(title);
		buffer.append("</h" + (level+1) + ">");
		newLine();
		return this;
	}
	
	@Override
	public TextBuilder beginItemize() {
		newLine();
		buffer.append("<ul>");
		newLine(+1);
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
		newLine(-1);
		buffer.append("</ul>");
		newLine();
		return this;
	}
	
	@Override
	public TextBuilder beginTable() {
		newLine();
		buffer.append("<table class=\"gen_details\">");
		newLine(+1);
		return this;
	}

	@Override
	public TextBuilder appendTableLine(String... cells) {
		buffer.append("<tr>");
		newLine(+1);
		for (String cell : cells) {
			buffer.append("<td>").append(cell).append("</td>");
			newLine();
		}
		newLine(-1);
		buffer.append("</tr>");
		newLine();
		return this;
	}
	
	@Override
	public TextBuilder endTable() {
		newLine(-1);
		buffer.append("</table>");
		newLine();
		return this;
	}
	
	@Override
	public TextBuilder beginBlock() {
		newLine();
		buffer.append("<div class='gen_block'>");
		newLine(+1);
		return this;
	}
	
	@Override
	public TextBuilder endBlock() {
		newLine(-1);
		buffer.append("</div>");
		newLine();
		return this;
	}

	@Override
	public TextBuilder appendImage(String path, String label) {
		buffer.append("<img class=\"gen_diagram\" src=\"").append(path).append("\">");
		newLine();
		if (label != null) {
			buffer.append("<em>" + label + "</em>");
			newLine();
		}
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
	
	@Override
	public String ref(String s, String anchor) {
		return "<a href=\"#" + anchor + "\">" + s + "</a>";
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
		b.append(".gen_block { border-left: solid thin gray; margin: 0 0 .5em .5em; padding-left: .5em; }").append(NL);
		b.append(".gen_doc { color: gray }").append(NL);
		b.append(".gen_code { font-family: monospace }").append(NL);
		b.append(".gen_type { font-variant:small-caps }").append(NL);
		
		b.append(".gen_diagram { width: 100% }").append(NL);
		b.append(".gen_details { width: 100% }").append(NL);
		b.append(".gen_details tr td { background: #ddd; padding: 2pt; }").append(NL);
		b.append(".gen_details tr td:first-child { background: #fff; font-weight: bold; width: 200pt }").append(NL);
		
		return b.toString();
	}

}
