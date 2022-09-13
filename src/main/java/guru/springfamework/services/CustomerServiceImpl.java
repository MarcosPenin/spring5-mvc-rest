package guru.springfamework.services;

import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Customer createNewCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Customer saveCustomer(Long id, Customer customer) {
        return customerRepository.save(customer);
    }
    @Override
    public Customer patchCustomer(Long id, Customer entryCustomer) {

        return customerRepository.findById(id).map(customer -> {

            if(entryCustomer.getFirstname() != null){
                customer.setFirstname(entryCustomer.getFirstname());
            }

            if(entryCustomer.getLastname() != null){
                customer.setLastname(entryCustomer.getLastname());
            }

            Customer returnDto = customerRepository.save(customer);


            return returnDto;

        }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

}
