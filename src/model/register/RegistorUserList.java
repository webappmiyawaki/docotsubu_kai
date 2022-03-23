package model.register;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import model.User;

@Getter
@Setter
public class RegistorUserList {
	List<User> rul;

	public RegistorUserList(){
		this.rul = new ArrayList<User>();
	}
}
