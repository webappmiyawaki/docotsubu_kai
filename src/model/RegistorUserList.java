package model;

import java.util.ArrayList;
import java.util.List;

public class RegistorUserList {
	private List<User> registorUserList;
	private boolean isUserExists;


	public void setIsExistsUser(boolean b) {
		this.isUserExists=b;
	}
	public boolean getIsExistsUser() {
		return this.isUserExists;
	}

	public RegistorUserList(){
		this.registorUserList= new ArrayList<>();
		this.isUserExists=false;
	}
	public void setRegistorUserList(User user) {
		registorUserList.add(user);
	}
	public List<User> getRegistorUserList(){
		return this.registorUserList;
	}
}
