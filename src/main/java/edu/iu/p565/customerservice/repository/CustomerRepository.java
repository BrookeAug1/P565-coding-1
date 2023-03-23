package edu.iu.p565.customerservice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import edu.iu.p565.customerservice.model.Customer;

@Repository
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll(){
        return customers;
    }
    public int create(Customer c){
        int id = customers.size()+1;
        c.setId(id);
        customers.add(c);
        return id;
    }
    public void update(Customer customer, int id){
        Customer x = getCustomerById(id);
        if (x!= null){
            x.setName(customer.getName());
            x.setEmail(customer.getEmail());
        }
    }

    private Customer getCustomerById(int id) {
        return customers.stream().filter(x -> x.getId()==id).findAny().orElse(null);
    }
    public void delete(int id){
        Customer x = getCustomerById(id);
        if (x!=null)
            customers.remove(x);
    }
}
