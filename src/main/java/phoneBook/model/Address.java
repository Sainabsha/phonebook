
package phoneBook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "ADDRESS_TABLE")
public class Address implements Serializable {

	@Id
	@Column(name = "mobile")
	private int mobile;
	private String addressline;
	private String city;
	private int pincode;
	
	
	@OneToOne
	@JoinColumn(name = "mobile")
	private Profile profile;

	public Address() {

	}

	public Address(int mobile, String addressline, String city, int pincode, Profile profile) {
		this.mobile = mobile;
		this.addressline = addressline;
		this.city = city;
		this.pincode = pincode;
		this.profile = profile;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getAddressline() {
		return addressline;
	}

	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Address [ mobile = "+mobile+ ", addressline=" + addressline + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
