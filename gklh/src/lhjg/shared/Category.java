package lhjg.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class Category implements Serializable {
		private static final long serialVersionUID = 1l;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;
	
	@Persistent
	private String title = "no title";
	@Persistent
	
	/*private CategoryGradeType type;
	@Persistent
	@Unowned*/
	private List<Category> subcategories = new ArrayList<Category>();
	
	public Category() {}

	public Category(String title){
		setTitle(title);
		//setType(type);
	}
	
	
	public String toString(){
		//StringBuffer buffer = new StringBuffer();
		return "\t- "+this.title;
	}
	
	//Getters/setters
	public List<Category> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Category> subcategories) {
		this.subcategories = subcategories;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/*public CategoryGradeType getType() {
		return type;
	}

	public void setType(CategoryGradeType type) {
		this.type = type;
	}*/
	
	public void addCategory(Category c) {
		this.subcategories.add(c);
	}

	
	
}
