package model.registor;

import java.util.List;

import model.User;

public class RegisterUserLogic {
  public boolean execute(List<User> userList,User user) {
	  if(userList==null) {
		  return true;
	  }else {
		  for(User rUser:userList) {
			  //userでequalsのoverride...
			  if(rUser.getName().equals(user.getName())){
				  if(rUser.getPass().equals(user.getPass())) {
					  return false;
				  }
			  }
		  }
		  return true;
	  }
  }
}