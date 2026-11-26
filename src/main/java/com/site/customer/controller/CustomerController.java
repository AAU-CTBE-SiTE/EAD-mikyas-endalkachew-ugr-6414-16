package com.site.customer.controller;

import com.site.customer.model.CustomerModel;
import com.site.customer.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public CustomerModel createCustomer(@RequestBody CustomerModel customer) {
        return customerRepository.save(customer);
    }

    @GetMapping
    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public CustomerModel getCustomerById(@PathVariable String id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));
    }

    @PutMapping("/{id}")
    public CustomerModel updateCustomer(
            @PathVariable String id,
            @RequestBody CustomerModel customer) {

        CustomerModel existing = customerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));

        existing.setName(customer.getName());
        existing.setEmail(customer.getEmail());

        return customerRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable String id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }

        customerRepository.deleteById(id);
        return "Customer deleted successfully";
    }
}