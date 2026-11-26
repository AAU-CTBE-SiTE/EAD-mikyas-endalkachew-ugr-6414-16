package com.site.customer.repository;

import com.site.customer.model.CustomerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository
        extends MongoRepository<CustomerModel, String> {
}