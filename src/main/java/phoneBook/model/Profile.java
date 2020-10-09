package phoneBook.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_TABLE")
public class Profile implements Serializable {
	@Id
	@Column(name = "mobile")
	private int mobile;
	private String name;
	private String email;
	private String category;

	@OneToOne(mappedBy = "profile")
	@JoinColumn(name = "mobile")
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
  	}

	public Profile() {

	}

	public Profile(int mobile, String name, String email, String category, Address  address) {
		this.mobile = mobile;
		this.name = name;
		this.email = email;
		this.category = category;
		this.address = address;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Contacts [mobile=" + mobile + ", email=" + email + ", name=" + name + ", category=" + category + "]";
	}

}
