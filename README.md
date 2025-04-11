# Visual Service Design Tool

Copyright 2007-2022 DAI-Labor, TU Berlin

* Main Contributor: Tobias Küster
* Further contributions by: Marcus Voß, Petrus S. Tan, Michael Burkhardt


## Short Description

The Visual Service Design Tool (VSDT) is a [BPMN](https://en.wikipedia.org/wiki/BPMN)-Editor 
that can be used for automatically creating executable code for various target languages,
most notably different flavours of JIAC agents, but also BPEL, or just plain english text.

The first version of the VSDT was developed in 2007 during the diploma thesis of Tobias Küster
and has since then been extended upon in the context of various research projects at DAI-Labor.


## Getting Started

The VSDT is implemented as an Eclipse plugin, meaning that you have to use the [Eclipse](http://www.eclipse.org/)
IDE for developing and running it.  The latest version of Eclipse the VSDT has been tested with is 
Eclipse 2023-12. Correct working on newer version can not be guaranteed.

### Running the VSDT (as developer)

1. Download the Eclipse Installer and Install Eclipse (which version does not really matter, "Eclipse for Java Developers" works fine)
2. Import the modules in this repository (`vsdt/de.dailab.vsdt.*`) into your Eclipse workspace
3. Import additional plugin projects from other repositories:
    * `common/de.dailab.common.swt` and `*.gmf`
    * `jadl/de.dailab.jiactng.jadlpp` (optional)
    * `jiac/de.dailab.jiactng.nodeplugin` (optional)
4. The VSDT consists of several different modules, not all might be needed. If you still have missing dependencies for some, check the list in the Redmine Wiki (see Documentation) whether you really need those, and close them if you don't.
5. Install the GMF Tooling and ATL Plugins into Eclipse (from the Eclipse marketplace menu)
6. Once everything compiles without error, right-click on any of the VSDT modules and select _Run as_ -> _Eclipse Application_
    * A new Eclipse runtime will start from within your current Eclipse runtime, being equipped with all the plugins currently opened in the workspace, including the VSDT
    * Import the `examples` project and open one of the examples, e.g. in the `demo` folder, to see if everything works
    * A detailled description of how to use the VSDT can be found in the VSDT Manual (see Documentation)

Note: Currently, VSDT does not work well with a dark UI theme, so best switch to a light theme before starting Eclipse. You can select a light theme in Window -> Preferences -> General -> Appearance.

### Contributing to the VSDT

Just a few pointer where to look in case you want to make certain additions or changes:

* The BPMN meta model is defined in an EMF Ecore file in `de.dailab.vsdt/model`, as are the GMF files used to configure and generate the basic graphical editor. Please consult an EMF/GMF tutorial to learn how to modify those.
* The editor code is distributed to a few modules. The generated code (with a few modifications) is located in `de.dailab.vsdt.diagram/src`; everything that has been modified has a `@generated NOT` annotation and can thus be easily found. The `customsrc` directory in the same module holds classes that are inseparable from the basic editor, but are entirely custom-made, such as the figures, and some dialogs needed to edit non-visual elements. The modules `de.dailab.vsdt.diagram.additions` contains several features and usability improvements that are not essential to the editor.
* Extending the structure transformation (how subgraphs are mapped to loops, if/else, etc.) is found in the `de.dailab.vsdt.trafo.strucbpmn` module, as a series of graph transformation rules. Those rules are implemented in plain Java and based on the Eclipse EMT framework.
* For adding a transformation to another target language, it is usually not necessary to extend the structure mapping. The best approach to this is to just copy one of the existing transformation modules, e.g. the `de.dailab.vsdt.trafo.agentbeans` module, and modify it as needed. Usually, the bulk of the transformation code is found the the `*ElementMapping` class; other commonly found classes are `*Validator`, `*ExportWrapper`, `*ResultSaver`, etc., each corresponding to one of the stages in the transformation.