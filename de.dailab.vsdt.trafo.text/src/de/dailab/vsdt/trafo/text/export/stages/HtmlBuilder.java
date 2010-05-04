package de.dailab.vsdt.trafo.text.export.stages;

/**
 * This class extends the TextBuilder with special HTML mark-up. The resulting
 * files will have a simple yet expressive HTML mark-up.
 * 
 * @author kuester
 */
public class HtmlBuilder extends TextBuilder {

	@Override
	public String getFileExtension() {
		return ".html";
	}
	
	@Override
	public TextBuilder appendHeader(String title) {
		buffer.append("<html><head>");
		buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		buffer.append("<title>").append(title).append("</head><body>");
		return this;
	}
	
	@Override
	public TextBuilder appendFooter() {
		buffer.append("</body></html>");
		return this;
	}
	
	@Override
	public TextBuilder appendTitle(String title, int level) {
		buffer.append(NL).append(getIndentationSpace());
		buffer.append("<h" + (level+1) + ">");
		buffer.append(title);
		buffer.append("</h" + (level+1) + ">");
		buffer.append(NL).append(getIndentationSpace());
		return this;
	}
	
	@Override
	public TextBuilder newLine() {
		buffer.append("<br>");
		buffer.append(NL).append(getIndentationSpace());
		return this;
	}
	
	@Override
	public TextBuilder beginItemize() {
		buffer.append("<ul>");
		indentationLevel++;
		buffer.append(NL).append(getIndentationSpace());
		return this;
	}

	@Override
	public TextBuilder appendItem(String s) {
		buffer.append("<li>").append(s).append("</li>");
		buffer.append(NL).append(getIndentationSpace());
		return this;
	}
	
	@Override
	public TextBuilder endItemize() {
		indentationLevel--;
		buffer.append(NL).append(getIndentationSpace());
		buffer.append("</ul>");
		buffer.append(NL).append(getIndentationSpace());
		return this;
	}
	
	@Override
	public TextBuilder beginBlock() {
		buffer.append("<div style='border-left:solid thin; margin-left: .5em; padding-left: .5em'>");
		indentationLevel++;
		buffer.append(NL).append(getIndentationSpace());
		return this;
	}
	
	@Override
	public TextBuilder endBlock() {
		indentationLevel--;
		buffer.append(NL).append(getIndentationSpace());
		buffer.append("</div>");
		buffer.append(NL).append(getIndentationSpace());
		return this;
	}

	@Override
	public String name(String s) {
		return "<em>" + s + "</em>";
	}
	
	@Override
	public String doc(String s) {
		return "<span style='color:gray'>" + s + "</span>";
	}
	
	@Override
	public String type(Enum e) {
		StringBuffer b= new StringBuffer();
		b.append("<span style='font-variant:small-caps'>");
		b.append(e.name().toLowerCase());
		b.append("</span>");
		return b.toString(); 
	}
	
	@Override
	public String code(String s) {
		StringBuffer b= new StringBuffer();
		b.append("<span style='font-family:courier'>");
		b.append(s);
		b.append("</span>");
		return b.toString();
	}

}
