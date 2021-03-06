package org.liveSense.jcr.explorer.client.ui;

import org.liveSense.jcr.explorer.client.JcrExplorer;
import org.liveSense.jcr.explorer.client.callback.CRUDServiceCallback;
import org.liveSense.jcr.explorer.client.callback.NewBooleanCallback;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.SubmitValuesHandler;
import com.smartgwt.client.widgets.form.fields.SubmitItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

/**
 * 
 * @author James Pickup
 *
 */
public class Details {
	private final TabSet nodeDetailsTabSet = new TabSet();
	public static TextItem pathTxt = new TextItem();
	public static TextItem nameTxt = new TextItem();
	public static TextItem primaryType = new TextItem();

	private final SubmitItem renameSubmitItem = new SubmitItem("rename");
	public static MixinNodeTypes mixinNodeTypes;
	
	public static SubmitItem addNodeSubmitItem = new SubmitItem("addNode");
	public static SubmitItem addPropertySubmitItem = new SubmitItem("addProperty");
	public static SubmitItem addMixinTypeSubmitItem = new SubmitItem("addMixinType");


	public TabSet createDetails(JcrExplorer jackrabbitExplorer) {
		mixinNodeTypes = new MixinNodeTypes(jackrabbitExplorer);
		nodeDetailsTabSet.setWidth100();
		nodeDetailsTabSet.setHeight100();
		Tab nodeDetailsTab = new Tab();
		nodeDetailsTab.setTitle("Node Details");

		//Go to path input and button
		final DynamicForm goToForm = new DynamicForm();
		goToForm.setID("goToForm");
		pathTxt.setName("PathItem");
		pathTxt.setTitle("&nbsp;Path");
		pathTxt.setWidth(500);
		pathTxt.setStartRow(true);
		pathTxt.setEndRow(false);
		pathTxt.setRequired(true);
		
		mixinNodeTypes.setWidth100();
		mixinNodeTypes.setHeight(24);
		mixinNodeTypes.setTitle("&nbsp;Mixin&nbsp;Types");

		SubmitItem pathSubmitItem = new SubmitItem("go");
		pathSubmitItem.setTitle("Go");
		pathSubmitItem.setWidth(100);
		pathSubmitItem.setEndRow(true);
		pathSubmitItem.setStartRow(false);
		goToForm.setNumCols(3);
		
		class GoToSubmitValuesHandler implements SubmitValuesHandler {
			private final JcrExplorer jackrabbitExplorer;
			public GoToSubmitValuesHandler(JcrExplorer jackrabbitExplorer) {
				this.jackrabbitExplorer = jackrabbitExplorer;
			}
			@Override
			public void onSubmitValues(com.smartgwt.client.widgets.form.events.SubmitValuesEvent event) {
				if (goToForm.validate()) {
					if (null == pathTxt.getValue() || pathTxt.getValue().toString().equals("")) {
						SC.warn("Path field is empty", new NewBooleanCallback());
						goToForm.validate();
					} else {
						jackrabbitExplorer.navigateTo(pathTxt.getValue().toString());
					}
				}
			}
		};
		goToForm.setSaveOnEnter(true);
		goToForm.addSubmitValuesHandler(new GoToSubmitValuesHandler(jackrabbitExplorer));
		goToForm.setItems(pathTxt, pathSubmitItem);

		//rename input and button
		final DynamicForm renameForm = new DynamicForm();
		renameForm.setID("renameForm");
		renameForm.setNumCols(3);
		nameTxt.setName("NameItem");
		nameTxt.setTitle("Name");
		nameTxt.setWidth(500);
		nameTxt.setDisabled(true);
		nameTxt.setStartRow(true);
		nameTxt.setEndRow(false);
		nameTxt.setRequired(true);
		renameSubmitItem.setDisabled(true);
		renameSubmitItem.setTitle("Rename Node");
		renameSubmitItem.setWidth(100);
		renameSubmitItem.setStartRow(false);
		renameSubmitItem.setEndRow(true);

		class RenameSubmitValuesHandler implements SubmitValuesHandler {
			private final JcrExplorer jackrabbitExplorer;
			public RenameSubmitValuesHandler(JcrExplorer jackrabbitExplorer) {
				this.jackrabbitExplorer = jackrabbitExplorer;
			}
			@Override
			public void onSubmitValues(com.smartgwt.client.widgets.form.events.SubmitValuesEvent event) {
				if (renameForm.validate()) {
					SC.confirm("Are you sure you want to rename node to "
							+ nameTxt.getValue().toString(), new BooleanCallback() {
								@Override
								public void execute(Boolean value) {
									if (value != null && !value.equals("")) {
										String path = JcrExplorer.cellMouseDownTreeGrid
												.getSelectedRecord().getAttribute("path");
										JcrExplorer.showLoadingImg();
										JcrExplorer.service.renameNode(path, nameTxt.getValue()
												.toString(), new CRUDServiceCallback(jackrabbitExplorer, path, null));
									} else {
										return;
									}
								}
							});
				}
			}
		};
		renameForm.setSaveOnEnter(true);
		renameForm.addSubmitValuesHandler(new RenameSubmitValuesHandler(jackrabbitExplorer));
		renameForm.setItems(nameTxt, renameSubmitItem);

		DynamicForm primaryTypeForm = new DynamicForm();
		primaryTypeForm.setID("primaryTypeForm");
		primaryTypeForm.setNumCols(2);
		primaryType.setName("PrimaryType");
		primaryType.setTitle("&nbsp;Primary&nbsp;Type");
		primaryType.setWidth(500);
		primaryType.setDisabled(true);
		primaryType.setStartRow(true);
		primaryType.setEndRow(true);
		primaryTypeForm.setItems(primaryType);
		primaryTypeForm.setSaveOnEnter(false);

		//Add node and Add property buttons
		DynamicForm addNewFormSubmitForm = new DynamicForm();
		addNewFormSubmitForm.setNumCols(4);
		addNodeSubmitItem.setTitle("Add Node");
		addNodeSubmitItem.setWidth(100);
		addNodeSubmitItem.setDisabled(true);
		addNodeSubmitItem.setStartRow(true);
		addNodeSubmitItem.setEndRow(false);
		class AddNodeButtonHandler implements ClickHandler {
			JcrExplorer jackrabbitExplorer = null;
			AddNodeButtonHandler(JcrExplorer jackrabbitExplorer) {
				this.jackrabbitExplorer = jackrabbitExplorer;
			}
			@Override
			public void onClick(ClickEvent event) {
				new AddNewNode().addNewNodeBox(jackrabbitExplorer);
			}
		};
		addNodeSubmitItem.addClickHandler(new AddNodeButtonHandler(jackrabbitExplorer));
		addPropertySubmitItem.setTitle("Add Property");
		addPropertySubmitItem.setWidth(100);
		addPropertySubmitItem.setDisabled(true);
		class AddPropertyButtonHandler implements ClickHandler {
			JcrExplorer jackrabbitExplorer = null;
			AddPropertyButtonHandler(JcrExplorer jackrabbitExplorer) {
				this.jackrabbitExplorer = jackrabbitExplorer;
			}
			@Override
			public void onClick(ClickEvent event) {
				new EditProperty().editPropertyBox(jackrabbitExplorer, null, true);
			}
		};
		addPropertySubmitItem.addClickHandler(new AddPropertyButtonHandler(jackrabbitExplorer));
		addPropertySubmitItem.setStartRow(false);
		addPropertySubmitItem.setEndRow(false);

		addMixinTypeSubmitItem.setTitle("Add Mixin Type");
		addMixinTypeSubmitItem.setWidth(100);
		addMixinTypeSubmitItem.setDisabled(true);
		addMixinTypeSubmitItem.setStartRow(false);
		addMixinTypeSubmitItem.setEndRow(true);
		class AddMixinButtonHandler implements ClickHandler {
			JcrExplorer jackrabbitExplorer = null;
			AddMixinButtonHandler(JcrExplorer jackrabbitExplorer) {
				this.jackrabbitExplorer = jackrabbitExplorer;
			}
			@Override
			public void onClick(ClickEvent event) {
				Details.mixinNodeTypes.addMixinTypeBox(jackrabbitExplorer);
			}
		};
		addMixinTypeSubmitItem.addClickHandler(new AddMixinButtonHandler(jackrabbitExplorer));

		
		VStack vStack = new VStack();
		vStack.setTop(10);
		addNewFormSubmitForm.setItems(addNodeSubmitItem, addPropertySubmitItem, addMixinTypeSubmitItem);
		addNewFormSubmitForm.setAlign(Alignment.RIGHT);
		HStack addNewButtonsHStack = new HStack();
		addNewButtonsHStack.addMember(addNewFormSubmitForm);
		addNewButtonsHStack.setWidth(50);
		addNewButtonsHStack.setHeight(20);
		vStack.setWidth100();
		vStack.setHeight(140);
		vStack.addMember(goToForm);
		vStack.addMember(renameForm);
		vStack.addMember(primaryTypeForm);
		vStack.addMember(mixinNodeTypes);
		HStack spacerHStack = new HStack();
		spacerHStack.setHeight(20);
		vStack.addMember(spacerHStack);
		vStack.addMember(addNewButtonsHStack);
		nodeDetailsTab.setPane(vStack);
		nodeDetailsTabSet.setTabs(nodeDetailsTab, new SearchTab().searchTab(jackrabbitExplorer), new ManageNodeTypes().nodeTypeTab());
		return nodeDetailsTabSet;
	}
}
