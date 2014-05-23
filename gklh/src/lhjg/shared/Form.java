package lhjg.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.IdentityType;

import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Form implements Serializable{
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;
	@Persistent
	private java.util.List<Category> categories = new ArrayList<Category>();
	@Persistent
	private boolean isFilledOut = false;
	@Persistent
	private String person = "nobody";
	@Persistent
	private String title = "no title";

	public Form() {}

	public Form(String title, List<Category> categories) {
		setCategories(categories);
		setTitle(title);
		setFilledOut(false);
	}
	
	public void print() {
		StringBuffer printString = new StringBuffer(title + "\n");
		for(Category category: this.categories){
			printString.append(category.toString() + "\n");
		}
		System.out.println(printString.toString());
	}

	// Getters and setters

	public String getId() {
		return id;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> newCategories) {
		this.categories = newCategories;
	}

	public String getPerson() {
		return person;
	}

	public void setFilledOut(boolean isFilledOut) {
		this.isFilledOut = isFilledOut;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public boolean isFilledOut() {
		return isFilledOut;
	}

	public static void main(String[] args) {
		List<Category> categories = new ArrayList ();
		categories.add(new Category("How awesome is Sergio"));
		categories.add(new Category("Sergio's grade in life"));
		final Form f = new Form("Sergio's form", categories);
		f.setCategories(categories);
		f.print();

	}

}
