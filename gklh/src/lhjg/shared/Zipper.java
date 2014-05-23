package lhjg.shared;

import java.util.List;

public class Zipper {
	// attributes
	public String[]  title;
	public String[]  description;
	public String[] categories;
	public String[] isFilledOut;
	
	public String[][]  zippedList;

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}
	
	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public String[] getTitle() {
		return title;
	}

	public void setTitle(String[]  title) {
		this.title = title;
	}
	
	public String[] getIsFilledOut() {
		return isFilledOut;
	}
	
	public void setIsFilledOut(String[] isFilledOut) {
		this.isFilledOut = isFilledOut;
	}
	

	public String[][] getZippedList() {
		return zippedList;
	}

	public void setZippedList(String[][]  zippedList) {
		this.zippedList = zippedList;
	}
	
	public Zipper(Form form) {
		//Wrapping Categories

		//String[] CategoryBuilder = new String[form.getCategories().length];
		//for(int index = 0; index < form.getCategories().length; index++){
			//CategoryBuilder[index] = form.getCategories()[index].getTitle();
			
		//}
	
		//this.setCategories(CategoryBuilder);
		
		//Wrapping Description
		
		//Wrapping Title
		String[] TitleArray = {form.getTitle()};
		this.setTitle(TitleArray);
		
		//Wrapping isFilledOut
		String isFilledOutString = BooleanToString(form.isFilledOut());
		String[] isFilledOutArray = {isFilledOutString};
		this.setIsFilledOut(isFilledOutArray);
	}
	public String BooleanToString(Boolean isFilledOut){
		if (isFilledOut){
			return "True";
			}
		else{
			return "False";
		}
	}
	
	public Boolean StringToBoolean(String isFilledOut){
		if (isFilledOut == "True"){
			return true;
		}
		else{
			return false;
		}

	}



	public Form unZip() {
		// get stuff from attributes
		//Form unzippedForm = new Form(this.getTitle()[0]);
		//unzippedForm.setFilledOut(StringToBoolean(this.getIsFilledOut()[0]));
		//Screwed up on the Categories, I need to be able to subcategories and subcategories and subsubcategories etc... only am getting the categories
		//unzippedForm.setCategories();
		//need to somehow be able to store all of the sub categories so that we can get them later
		return null;
	}

}
