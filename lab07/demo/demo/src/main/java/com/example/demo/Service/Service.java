package com.example.demo.Service;

import com.example.demo.controllers.CustomerController;
import com.example.demo.model.Converter.CustomerConventer;
import com.example.demo.model.Customer;
import com.example.demo.model.DTO.CustomerDTO;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

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

        List<Customer> customers = setCustomers();
        List<CustomerDTO> dtoCustom = conventer.entityToDTO(customers);
        conventer.setSpent(dtoCustom);
        return dtoCustom.stream().sorted(Comparator.comparing(CustomerDTO::getSpent).reversed()).limit(10).collect(Collectors.toList());
    }

    public List<CustomerDTO> getTop10MovieManiacs() {
        List<Customer> customers = setCustomers();
        List<CustomerDTO> dtoCustom = conventer.entityToDTO(customers);
        conventer.setWatched(dtoCustom);
        return dtoCustom.stream().sorted(Comparator.comparing(CustomerDTO::getWatched).reversed()).limit(10).collect(Collectors.toList());
    }

    private List<Customer> setCustomers() {
        List<Customer> customList = new ArrayList<>();
        for (int i = 1; i < repository.count(); i++){
            customList.add(repository.getById(i));
        }
        return customList;
    }
}
