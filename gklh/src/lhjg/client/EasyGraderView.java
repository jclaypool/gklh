package lhjg.client;

import java.util.ArrayList;
import java.util.List;

import lhjg.shared.Category;
import lhjg.shared.CategoryGradeType;
import lhjg.shared.Form;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EasyGraderView {
	private EasyGrader control;

	public void setControl(EasyGrader control) {
		this.control = control;
	}

	public EasyGrader getControl() {
		return control;
	}

	public void viewWelcomePage() {
		RootPanel root = RootPanel.get();
		root.clear();
		VerticalPanel vPanel = new VerticalPanel();
		root.add(vPanel);
		
		List<Category> categories = new ArrayList ();
		categories.add(new Category("How awesome is Sergio"));
		categories.add(new Category("Sergio's grade in life"));
		final Form f = new Form("Sergio's form", categories);
		f.setCategories(categories);
		
		
		//create a VIEW CONTACTS button
		Button submitFormButton = new Button();
		submitFormButton.setText("Push form to Server");
		vPanel.add(submitFormButton);
		
		Button getFormsFromServer = new Button();
		getFormsFromServer.setText("Get form from server");
		vPanel.add(getFormsFromServer);
		
		Button deleteFormFromServer = new Button();
		deleteFormFromServer.setText("delete form from server");
		vPanel.add(deleteFormFromServer);
		
		submitFormButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				control.handleDeleteRequest(f);
				
			}
			
		});
		
		submitFormButton.addClickHandler(new ClickHandler(){
		
			
			@Override
			public void onClick(ClickEvent event) {
				control.submitFormToServer(f);
				
			}
			
		});
		
		getFormsFromServer.addClickHandler(new ClickHandler(){
		
			
			@Override
			public void onClick(ClickEvent event) {
				control.getFormsFromServer();
				
			}
			
		});
		
		
		
	}
	
	public void setWindow(String url) {
		Window.Location.replace(url);
	}
}
