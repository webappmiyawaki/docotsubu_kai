package model.registor;

import java.util.ArrayList;
import java.util.List;

import model.User;

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
	public void setRegistorUserList(List<User> userList) {
		this.registorUserList=userList;
	}
	public List<User> getRegistorUserList(){
		return this.registorUserList;
	}
}
