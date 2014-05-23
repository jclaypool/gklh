package lhjg.server;

import java.util.List;

import lhjg.client.EasyGraderService;
import lhjg.shared.Form;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.api.users.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class EasyGraderServiceImpl extends RemoteServiceServlet implements
		EasyGraderService {
	public String submitFormToServer(Form Form) {
		EasyGraderModel.submitFormToServer(Form);
		return null;
	}

	@Override
	public List<Form> getFormsFromServer() {

		return EasyGraderModel.getFormsFromServer();

	}
	
	public String getLogOutUrl(){
		UserService userService = UserServiceFactory.getUserService();
		return userService.createLogoutURL("../Welcome.html");
	}

	public String setAppBaseURL(String homeURL){
		EasyGraderModel.setAppBaseURL(homeURL);
		return null;
	}

	public Boolean isUserLoggedIn() {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		return new Boolean(user!=null);
	}

	@Override
	public String deleteFormFromDB(Form form) {
		// TODO Auto-generated method stub
		return null;
	}


}
