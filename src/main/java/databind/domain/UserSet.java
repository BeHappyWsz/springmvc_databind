package databind.domain;

import java.util.HashSet;
import java.util.Set;

public class UserSet {
	
	private Set<User> users ;
	
	public UserSet() {
		users = new HashSet<User>(16);
		users.add(new User());
		users.add(new User());
	}
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "UserSet [users=" + users + "]";
	}
	
}
