package model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User implements Serializable {
	private String name;
	private String pass;
	@Override
	public String toString() {
		return String.format("name:%s pass:%s",this.name,this.pass);
	}

	@Override
	public boolean equals(Object o) {
		if(o == this)return true;
		if(o==null)return false;
		if(!(o instanceof User))return false;
		User user = (User)o;
		if(this.name.equals(user.getName())) {
			return false;
		}
		if(this.pass.equals(user.getPass())) {
			return false;
		}
		return true;
	}
}
