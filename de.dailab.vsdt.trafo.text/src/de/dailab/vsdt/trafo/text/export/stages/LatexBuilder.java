package de.dailab.vsdt.trafo.text.export.stages;

/**
 * This class extends the TextBuilder with special Latex mark-up. The resulting
 * files will have a simple yet expressive Latex mark-up.  This particular
 * transformation is a bit tricky due to the many escape characters.
 * 
 * TODO indentation of block structure
 * TODO fix umlauts
 * 
 * @author kuester
 */
public class LatexBuilder extends TextBuilder {

	@Override
	public String getFileExtension() {
		return ".tex";
	}
	
	@Override
	public TextBuilder appendHeader(String title) {
		buffer.append("\\documentclass{article}");
		newLine();
		buffer.append("\\usepackage[utf8]{inputenc}");
		newLine();
		buffer.append("\\begin{document}");
		newLine();
		return this;
	}
	
	@Override
	public TextBuilder appendFooter() {
		buffer.append("\\end{document}");
		return this;
	}
	
	@Override
	public TextBuilder appendTitle(String title, int level, String anchor) {
		newLine();
		switch (level) {
		case 0:
			buffer.append("\\title{" + title + "}");
			buffer.append("\\maketitle");
			break;
		case 1:
			buffer.append("\\section*{" + title + "}");
			break;
		case 2:
			buffer.append("\\subsection*{" + title + "}");
			break;
		case 3:
			buffer.append("\\subsubsection*{" + title + "}");
		default:
			buffer.append("\\paragraph*{" + title + "}");
		}
		if (anchor != null) {
			buffer.append("\\label{" + anchor+ "}");
		}
		newLine();
		return this;
	}
	
	@Override
	public TextBuilder beginItemize() {
		buffer.append("\\begin{itemize}");
		newLine(+1);
		return this;
	}

	@Override
	public TextBuilder appendItem(String s) {
		buffer.append("\\item ").append(s);
		newLine();
		return this;
	}
	
	@Override
	public TextBuilder endItemize() {
		newLine(-1);
		buffer.append("\\end{itemize}");
		newLine();
		return this;
	}
	
	@Override
	public String name(String s) {
		return "\\emph{" + s + "}";
	}
	
	@Override
	public String doc(String s) {
		return "\\emph{" + s + "}";
	}
	
	@Override
	public String type(Enum<?> e) {
		return "\\textsc{" + e.name().toLowerCase() + "}";
	}
	
	@Override
	public String code(String s) {
		return "\\texttt{" + s + "}";
	}
	
	@Override
	public String ref(String s, String anchor) {
		// TODO Auto-generated method stub
		return super.ref(s, anchor);
	}
	
	@Override
	protected String escape(String s) {
		return s.replace("�", "\\\"a").replace("�", "\\\"o")
				.replace("�", "\\\"u").replace("�", "\\\"A")
				.replace("�", "\\\"O").replace("�", "\\\"U")
				.replace("#", "\\#").replace("%", "\\%")
				.replace("&", "\\&").replace("_", "\\_");
	}

}
