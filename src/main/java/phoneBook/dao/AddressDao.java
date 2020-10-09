
  package phoneBook.dao;
  
  import java.util.List;
  
  import phoneBook.model.Address;
  
  public interface AddressDao {
  
  boolean addAddress(Address address);
  
  Address getAddress(int mobile);
  
  boolean removeAddress(int mobile);
  
  boolean updateAddress(Address address);
  
  List<Address> getAddressByCategory(String category);
  
  List<Address> getAddresses();
  
  }
 