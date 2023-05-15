package semicolon.africa.votersApp.repositories;

import semicolon.africa.votersApp.model.Address;

import java.util.List;
public interface AddressRepository {
    Address findById(String id);
    List<Address> findAll();
    Address save(Address address);
    void deleteById(String id);
}
