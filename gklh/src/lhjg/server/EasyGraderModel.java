package lhjg.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import lhjg.shared.Category;
import lhjg.shared.Form;

public class EasyGraderModel {

	static final PersistenceManagerFactory pmf = PMF.get();

	static String appBaseURL = "";

	public static void submitFormToServer(Form Form) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Form.flatten();
		try {
			pm.currentTransaction().begin();
			pm.makePersistent(Form);
			pm.currentTransaction().commit();
		} finally {
			if (pm.currentTransaction().isActive())
				pm.currentTransaction().rollback();
			if (!pm.isClosed())
				pm.close();
		}
	}

	public static List<Form> getFormsFromServer() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(Form.class);

		List<Form> forms = (List<Form>) query.execute();

		List<Form> returnForms = new ArrayList<Form>();
		for (Form form : forms) {
			Form newForm = new Form(form.getTitle(), form.getCategories());
			returnForms.add(newForm);
		}
		return (java.util.List<Form>) pm.detachCopyAll(forms);
	}

	public static void deletePost(Form form) {
		PersistenceManager pm = pmf.getPersistenceManager();
		// Keep alterations in a Transaction, so records are locked until done
		try {
			pm.currentTransaction().begin();
			// Find the object in the datastore that matches the
			// class and ID of the post. Then, delete it.
			pm.deletePersistent(pm.getObjectById(Form.class, form.getId()));
			pm.currentTransaction().commit();
		} finally {
			if (pm.currentTransaction().isActive())
				pm.currentTransaction().rollback();
			if (!pm.isClosed())
				pm.close();
		}
	}

	// Getters and setters of globally needed values
	public static void setAppBaseURL(String url) {
		EasyGraderModel.appBaseURL = url;
	}

	public static String getAppBaseURL() {
		return EasyGraderModel.appBaseURL;
	}

}
