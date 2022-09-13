package guru.springfamework.controllers;


import guru.springfamework.domain.Customer;
import guru.springfamework.domain.CustomerList;
import guru.springfamework.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerList getListofCustomers() {
        return new CustomerList(customerService.getAllCustomers());

    }

    @GetMapping({"{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Customer createNewCustomer(@RequestBody Customer customer) {
        return customerService.createNewCustomer(customer);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.saveCustomer(id, customer);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus
    public Customer patchCostumer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.patchCustomer(id, customer);
    }


    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);

    }


}