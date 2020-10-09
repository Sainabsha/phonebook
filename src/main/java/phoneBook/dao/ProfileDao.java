package phoneBook.dao;

import java.util.List;

import phoneBook.model.Profile;

public interface ProfileDao {
	
    boolean addContact(Profile profile);
    
    List<Profile> getContact();
	
	List<Profile> getContactbyName(String name);
	
	List<Profile> getContactByCategory(String category);

	boolean removeContact(int mobile);
	
	Profile getContactByNumber(int mobile);

	boolean updateContact(Profile profile);	

}
