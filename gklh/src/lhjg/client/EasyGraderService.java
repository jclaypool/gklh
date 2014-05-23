package lhjg.client;

import java.util.List;

import lhjg.shared.Form;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("easygraderservice") 
public interface EasyGraderService extends RemoteService {
	public String submitFormToServer(Form form);
	public List<Form> getFormsFromServer();
	public Boolean isUserLoggedIn();
	public String getLogOutUrl();
	public String setAppBaseURL(String homeURL);
	public String deleteFormFromDB(Form form); 
}
