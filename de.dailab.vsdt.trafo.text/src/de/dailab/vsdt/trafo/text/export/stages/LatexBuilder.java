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
		appendLine("\\documentclass{article}");
		appendLine("\\usepackage[utf8]{inputenc}");
		appendLine("\\usepackage{graphicx}");
		appendLine("\\begin{document}");
		return this;
	}
	
	@Override
	public TextBuilder appendFooter() {
		appendLine("\\end{document}");
		return this;
	}
	
	@Override
	public TextBuilder appendTitle(String title, int level, String anchor) {
		newLine();
		switch (level) {
		case 0:
			appendLine("\\title{" + title + "}");
			appendLine("\\maketitle");
			break;
		case 1:
			appendLine("\\section*{" + title + "}");
			break;
		case 2:
			appendLine("\\subsection*{" + title + "}");
			break;
		case 3:
			appendLine("\\subsubsection*{" + title + "}");
		default:
			appendLine("\\paragraph*{" + title + "}");
		}
		if (anchor != null) {
			// FIXME problem with underscores ('_')
//			buffer.append("\\label{" + anchor + "}");
//			newLine();
		}
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
		appendLine("\\item " + s);
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
	public TextBuilder appendImage(String path, String label) {
		appendLine("\\begin{figure}");
		appendLine("\t\\includegraphics[width=\\textwidth]{" + path + "}");
		appendLine("\t\\caption{" + label + "}");
		appendLine("\\end{figure}");
		return this;
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
