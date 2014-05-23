package lhjg.client;

import java.util.List;

import lhjg.shared.Form;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EasyGraderServiceAsync {

	void submitFormToServer(Form form, AsyncCallback<String> callback);
	void getFormsFromServer(AsyncCallback<List<Form>> callback);
	void getLogOutUrl(AsyncCallback<String> callback);
	void isUserLoggedIn(AsyncCallback<Boolean> callback);
	void setAppBaseURL(String homeURL, AsyncCallback<String> callback);

}
