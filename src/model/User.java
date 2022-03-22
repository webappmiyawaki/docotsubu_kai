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
		return String.format("name:%s pass:%",this.name,this.pass);
	}
}
