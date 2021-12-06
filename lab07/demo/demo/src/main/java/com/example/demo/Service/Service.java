package com.example.demo.Service;

import com.example.demo.controllers.CustomerController;
import com.example.demo.model.Converter.CustomerConventer;
import com.example.demo.model.Customer;
import com.example.demo.model.DTO.CustomerDTO;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {

    private CustomerRepository repository;
    private CustomerConventer conventer;

    @Autowired
    public Service(CustomerRepository repository, CustomerConventer conventer) {
        this.repository = repository;
        this.conventer = conventer;
    }


    public List<CustomerDTO> getTop10() {
        List<Customer> customList = repository.top10Customers();
        List<CustomerDTO> dtoCustom = conventer.entityToDTO(customList);
        return dtoCustom;
    }
}
