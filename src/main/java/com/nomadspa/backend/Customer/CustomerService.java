package com.nomadspa.backend.Customer;
import jakarta.transaction.Transactional;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class CustomerService {
    private final CustomerRepository CustomerRepository;
    @Autowired
    public CustomerService(CustomerRepository CustomerRepository) {
        this.CustomerRepository = CustomerRepository;
    }
    public List<Customer> getCustomer(){
        return CustomerRepository.findAll();
    }

    public void addNewCustomer(Customer customer){
        Optional<Customer> customerByPhoneNumber = CustomerRepository
                .findCustomerByPhoneNumber(customer.getPhoneNumber());
        if(customerByPhoneNumber.isPresent()){
            throw new IllegalStateException("Phone number Taken");
        }
        CustomerRepository.save(customer);
    }
    public void deleteCustomer(Long customerId) {
        boolean exists = CustomerRepository.existsById(customerId);
        if(!exists){
            throw new IllegalStateException(
                    "customer with id" + customerId + " does not exists");
        }
        CustomerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(Long customerId, String name, String phoneNumber) {
        Customer customer = CustomerRepository.findById(customerId).
                orElseThrow(() -> new IllegalStateException(
                        "student with id" + customerId + "does not exist"));

        if (name != null && !name.isEmpty() && !Objects.equals(customer.getName(), name)) {
            customer.setName(name);
        }
        if (phoneNumber != null && !phoneNumber.isEmpty() && !Objects.equals(customer.getPhoneNumber(), phoneNumber)) {
            Optional<Customer> studentOptional = CustomerRepository.findCustomerByPhoneNumber(phoneNumber);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            customer.setPhoneNumber(phoneNumber);
        }

    }
}
