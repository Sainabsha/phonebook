package phoneBook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import phoneBook.model.Address;
import phoneBook.model.Profile;

@Repository
@Transactional
public class ProfileDaoImp implements ProfileDao {
	
	private SessionFactory sessionFactory;

	@Autowired
	public ProfileDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean addContact(Profile profile) {
		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			currentSession.save(profile);
			currentSession.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

		return true;
		
	}

	@Override
	public List<Profile> getContact() {
		
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Profile");
		List<Profile> contactList = query.list();
		currentSession.flush();
		return contactList;
	}

	@Override
	public List<Profile> getContactbyName(String name) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Profile p where p.name = :name");
		query.setParameter("name", name);
		List<Profile> profile = query.list();
		return profile;
		
	}

	@Override
	public List<Profile> getContactByCategory(String category) {
		
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Profile p where p.category = :catg");
		query.setParameter("catg", category);
		List<Profile> profile = query.list();
		return profile;

	}

	@Override
	public Profile getContactByNumber(int mobile) {
		
		Session currentSession = this.sessionFactory.getCurrentSession();
		Profile profile =currentSession.get(Profile.class, mobile);
		return profile;

	}




	@Override
	public boolean removeContact(int mobile) {
		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			Profile profile = currentSession.get(Profile.class, mobile);
			currentSession.delete(profile);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;


	}

	@Override
	public boolean updateContact(Profile profile) {
				try {
					Session currentSession = this.sessionFactory.getCurrentSession();
					Profile profile1 = currentSession.get(Profile.class, profile.getMobile());
                    profile1.setName(profile.getName());
                    profile1.setEmail(profile.getEmail());
                    profile1.setCategory(profile.getCategory());
                    profile1.setAddress(profile.getAddress());
					Address address1 = currentSession.get(Address.class, profile.getMobile());
                    address1.setAddressline(profile.getAddress().getAddressline());
                    address1.setCity(profile.getAddress().getCity());
                    address1.setPincode(profile.getAddress().getPincode());
		            currentSession.flush();
				} catch (HibernateException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}


	


	}

