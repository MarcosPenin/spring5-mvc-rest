package guru.springfamework.controllers;


import guru.springfamework.domain.Customer;
import guru.springfamework.domain.CustomerList;
import guru.springfamework.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerList> getListofCustomers() {

        return new ResponseEntity<CustomerList>(new CustomerList(customerService.getAllCustomers()),
                HttpStatus.OK);

    }

    @GetMapping({"{id}"})
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.createNewCustomer(customer),
                HttpStatus.CREATED);
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.saveCustomer(id, customer),
                HttpStatus.OK);
    }


}