Visual Service Design Tool
==========================

Short Description
-----------------
The Visual Service Design Tool (VSDT) is a [BPMN](https://en.wikipedia.org/wiki/BPMN)-Editor 
that can be used for automatically creating executable code for various target languages,
most notably different flavours of JIAC agents, but also BPEL, or just plain english text.

The first version of the VSDT was developed in 2007 during the diploma thesis of Tobias Kuester
and has since then been extended upon in the context of various research projects at DAI-Labor.


Getting Started
---------------
The VSDT is implemented as an Eclipse plugin, meaning that you have to use the [Eclipse](http://www.eclipse.org/)
IDE for developing and running it.  The latest version of Eclipse the VSDT has been tested with is 
[Eclipse Neon](http://www.eclipse.org/neon/). Correct working on newer version can not be guaranteed.

### Running the VSDT (as developer)
1. If you haven't yet, install the GMF (Graphical Modeling Framework) and XText SDKs into your Eclipse (go to _Help_ -> _Install new software..._)
2. Check out the modules in this directory (`vsdt/de.dailab.vsdt.*`) into your Eclipse workspace
3. Check out additional plugins from other directories:
  * `common/de.dailab.common.swt` and `*.gmf`
  * `jadl/de.dailab.jiactng.jadlpp` (optional)
  * `jiac/de.dailab.jiactng.nodeplugin` (optional)
4. The VSDT consists of several different modules, not all might be needed. If you still have missing dependencies for some, check the list in the Redmine Wiki (see Documentation) whether you really need those, and close them if you don't.
5. Once everything compiles without error, right-click on any of the VSDT modules and select _Run as_ -> _Eclipse Application_
  * A new Eclipse runtime will start from within your current Eclipse runtime, being equipped with all the plugins currently opened in the workspace, including the VSDT
  * A detailled description of how to use the VSDT can be found in the VSDT Manual (see Documentation)

### Contributing to the VSDT
Just a few pointer where to look in case you want to make certain additions or changes:

* The BPMN meta model is defined in an EMF Ecore file in `de.dailab.vsdt/model`, as are the GMF files used to configure and generate the basic graphical editor. Please consult an EMF/GMF tutorial to learn how to modify those.
* The editor code is distributed to a few modules. The generated code (with a few modifications) is located in `de.dailab.vsdt.diagram/src`; everything that has been modified has a `@generated NOT` annotation and can thus be easily found. The `customsrc` directory in the same module holds classes that are inseparable from the basic editor, but are entirely custom-made, such as the figures, and some dialogs needed to edit non-visual elements. The modules `de.dailab.vsdt.diagram.additions` contains several features and usability improvements that are not essential to the editor.
* Extending the structure transformation (how subgraphs are mapped to loops, if/else, etc.) is found in the `de.dailab.vsdt.trafo.strucbpmn` module, as a series of graph transformation rules. Those rules are implemented in plain Java and based on the Eclipse EMT framework.
* For adding a transformation to another target language, it is usually not necessary to extend the structure mapping. The best approach to this is to just copy one of the existing transformation modules, e.g. the `de.dailab.vsdt.trafo.agentbeans` module, and modify it as needed. Usually, the bulk of the transformation code is found the the `*ElementMapping` class; other commonly found classes are `*Validator`, `*ExportWrapper`, `*ResultSaver`, etc., each corresponding to one of the stages in the transformation.


Developers
----------
* Tobias Kuester <tobias.kuester@dai-labor.de>

Documentation
-------------
* [JIAC Website](http://www.jiac.de/development-tools/jiac-toolipse/visual-service-design-tool/)
* [VSDT Manual](https://cvs.dai-labor.de/jiac/toolipse3/trunk/doc/vsdt_manual)
* [DAI-Wiki (obsolete)](https://wiki.dai-labor.de/ClusterSET:VSDT)
* [Redmine Wiki](https://redmine.dai-labor.de/redmine/projects/jiac-tools-und-toolipse/wiki/VSDT)
