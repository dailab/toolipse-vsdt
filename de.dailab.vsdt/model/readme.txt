vsdt.ecore
	This is the BPMN meta model used by the Visual Service Design Tool. The
	model has been created based on BPMN 1.0 in 2006 and gradually transitioned
	to BPMN 1.1 and 2.0 later on. 
	
vsdt.genmodel
	This is the generator model for vsdt.ecore, specifying implementations
	details such as package names, editor configuration, serialization, etc.

vsdt.gmfgraph
	This is the graphical model for the VSDT. Note that this is in fact only a
	collection of references, while the actual definitions are implemented as
	classes, which is easier to tweak and to debug than if one had to regenerate
	the graphical editor each time one changes a figure.

vsdt.gmftool
	This is the tooling model defining the items the BPMN editor's palette.
	
vsdt.gmfmap
	This is the mapping model, connecting figures, tools, and model elements to
	a hierarchy of nodes and links to be drawn in the BPMN editor. This model
	also declares a number of constraints, most of which are implemented as Java
	methods.

vsdt.gmfgen
	This is the generator model for the BPMN diagram editor, which specifies
	some implementation specific details (paths, class names, etc.), most of
	which is generated and needs not to be touched.

vsdt_meta.gmftool
	This is the tooling model defining the items the 'Meta' editor's palette.
	
vsdt_meta.gmfmap
	This is the mapping model, for the 'Meta' editor, which is used to connect
	the several BPMN diagrams with a use case like 'diagram of diagrams'.

vsdt_meta.gmfgen
	The 'Meta' editor's generator model, in which the connection of the two
	diagram editor is specified.

vsdt2.ecore
	This is another variant of the BPMN meta model, not used in the VSDT. It is
	a reduced version of the VSDT meta model, used solely to think about how the
	BPMN meta model could look, usability and implementation issues aside.
