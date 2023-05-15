package semicolon.africa.votersApp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import semicolon.africa.votersApp.model.Address;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BvasAddressRepositoryImpl implements AddressRepository{
    @Autowired
    AddressRepository addressRepository;
//    List<Address> addressList = new ArrayList<>();

    @Override
    public Address findById(String id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address save(Address address) {
        Address newAddress = new Address();
        newAddress.setId(address.getId());
        newAddress.setHouseNumber(address.getHouseNumber());
        newAddress.setStreet(address.getStreet());
        newAddress.setTown(address.getTown());
        newAddress.setLocalGovernmentArea(address.getLocalGovernmentArea());
        newAddress.setState(address.getState());
        Address savedAddress = addressRepository.save(address);
        return savedAddress;
    }

    @Override
    public void deleteById(String id) {
        addressRepository.deleteById(id);

    }
}
