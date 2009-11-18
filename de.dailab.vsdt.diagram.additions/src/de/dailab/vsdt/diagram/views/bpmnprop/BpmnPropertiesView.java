package de.dailab.vsdt.diagram.views.bpmnprop;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import de.dailab.common.swt.views.AbstractStructuredViewerView;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.diagram.actions.OrganizePropertiesAction;

/**
 * This view provides insight in the Properties in the scope of the BPMN
 * element currently selected in the active VSDT editor. Further, on double-
 * clicking properties the full-featured properties dialog is opened. 
 * 
 * @author kuester
 */
public class BpmnPropertiesView extends AbstractStructuredViewerView {
	
	private Table table;
	
	public static final String NAME_COLUMN	= "Name";
	public static final String TYPE_COLUMN	= "Type";
	public static final String OWNER_COLUMN	= "Owner";
	public static final String[] COLUMN_NAMES = new String[] {NAME_COLUMN, TYPE_COLUMN, OWNER_COLUMN,};

	public void createPartControl(Composite composite) {
		
		// Create a composite to hold the children
		GridData gridData = new GridData (GridData.HORIZONTAL_ALIGN_FILL | GridData.FILL_BOTH);
		composite.setLayoutData (gridData);

		// Set numColumns to 3 for the buttons 
		GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = 4;
		composite.setLayout (layout);

		// Create the table 
		createTable(composite);
		
		Object input= getViewSite().getWorkbenchWindow().getActivePage();
		
		// Create the TableViewer
		viewer = new TableViewer(table);
		viewer.setUseHashlookup(true);
		viewer.setContentProvider(new BpmnPropertiesViewContentProvider());
		viewer.setLabelProvider(new BpmnPropertiesViewLabelProvider());
		viewer.setInput(input);
		viewer.setSorter(new BpmnPropertiesViewSorter(-1));
		((TableViewer)viewer).setColumnProperties(COLUMN_NAMES);
		super.createPartControl(composite);
	}
	
	@Override
	protected void makeActions() {
		//do nothing
	}
	
	@Override
	protected void updateActionEnablement() {
		// no actions to update
	}
	
	@Override
	protected void performDoubleClick() {
		Object selected= getSelectedElement();
		if (selected instanceof Property) {
			Property property= (Property) selected;
			new OrganizePropertiesAction().run(property.eContainer());
		}
	}
	
	/**
	 * Create the Table
	 */
	private Table createTable(Composite parent) {
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | 
					SWT.FULL_SELECTION | SWT.HIDE_SELECTION;
		table = new Table(parent, style);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 3;
		table.setLayoutData(gridData);		
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn column;
		// column with property name
		column = new TableColumn(table, SWT.LEFT, 0);
		column.setText(NAME_COLUMN);
		column.setWidth(150);
		column.addSelectionListener(
				new SorterSelectionAdapter(BpmnPropertiesViewSorter.CRITERION_NAME));
		// 3rd column with property type
		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText(TYPE_COLUMN);
		column.setWidth(100);
		column.addSelectionListener(
				new SorterSelectionAdapter(BpmnPropertiesViewSorter.CRITERION_TYPE));
		// column with property owner 
		column = new TableColumn(table, SWT.LEFT, 2);
		column.setText(OWNER_COLUMN);
		column.setWidth(200);
		column.addSelectionListener(
				new SorterSelectionAdapter(BpmnPropertiesViewSorter.CRITERION_OWNER));
		return table;
	}

	/**
	 * This class helps dynamically setting the sorter for the viewer
	 * when clicking on one of the columns.
	 * 
	 * @author kuester
	 */
	protected class SorterSelectionAdapter extends SelectionAdapter{
		int criterion= -1;
		public SorterSelectionAdapter(int criterion) {
			this.criterion= criterion;
		}
		public void widgetSelected(SelectionEvent e) {
			viewer.setSorter(new BpmnPropertiesViewSorter(criterion));
		}
	}
}