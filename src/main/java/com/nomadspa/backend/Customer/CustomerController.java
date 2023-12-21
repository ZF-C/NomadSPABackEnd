package com.nomadspa.backend.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="api/v1/Customer")
public class CustomerController {
    private final CustomerService CustomerService;

    @Autowired
    public CustomerController(com.nomadspa.backend.Customer.CustomerService customerService) {
        CustomerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomer(){
        return CustomerService.getCustomer();
    }
    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer){
        CustomerService.addNewCustomer(customer);
    }
    @DeleteMapping(path = "{customerId}")


    public void deleteCustomer(
            @PathVariable("customerId") Long customerId){
        CustomerService.deleteCustomer(customerId);
    }
    @PutMapping(path = "{customerId}")
    public void updateCustomer(@PathVariable("customerId") Long customerId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String phoneNumber){
        CustomerService.updateCustomer(customerId,name,phoneNumber);

    }
}
