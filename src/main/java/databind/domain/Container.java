package databind.domain;

public class Container {

	private int id;
	
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Container [id=" + id + ", user=" + user + "]";
	}
	
}
