
package phoneBook.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import phoneBook.model.Address;
import phoneBook.model.Profile;

@Repository

@Transactional
public class AddressDaoImpl implements AddressDao {

	private SessionFactory sessionFactory;

	@Autowired
	public AddressDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			currentSession.save(address);
			currentSession.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	@Override 
	public Address getAddress(int mobile) { 
		// TODO Auto-generate method stub 
		return null; 
		}

	@Override public boolean removeAddress(int mobile) { 
		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			Address address = currentSession.get(Address.class, mobile);
			currentSession.delete(address);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
   }



	@Override public List<Address> getAddressByCategory(String category) { 
		// TODO Auto-generated method stub 
		return null; 
		}

	@Override 
	public List<Address> getAddresses() { 
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Address");
		List<Address> addressList = query.list();
		currentSession.flush();
		return addressList;
		
	}

	
	@Override
	public boolean updateAddress(Address address) {
				try {
					Session currentSession = this.sessionFactory.getCurrentSession();
					currentSession.update(address);
					currentSession.flush();
				} catch (HibernateException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}


}
