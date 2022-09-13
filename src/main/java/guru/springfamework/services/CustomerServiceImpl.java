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
}
