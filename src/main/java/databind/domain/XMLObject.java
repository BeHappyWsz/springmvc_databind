package databind.domain;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement(name="user")
public class XMLObject {
	private int id;
	
	private String name;

	public int getId() {
		return id;
	}

	@XmlElement(value="id")
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement(value="name")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "XMLObject [id=" + id + ", name=" + name + "]";
	}
	
}
