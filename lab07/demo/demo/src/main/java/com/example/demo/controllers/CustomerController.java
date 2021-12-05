package com.example.demo.controllers;
import com.example.demo.DTOModel.CustomerDTO;
import com.example.demo.model.Spent;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.results.CustomerStats;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {
    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    private final CustomerRepository repository;
    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    private final List<CustomerDTO> customerDTOList = new ArrayList<>();
    private final List<Spent> spent = new ArrayList<>();

    public void setCustomers(){
        if(customerDTOList.isEmpty()){
            for (int i = 1; i < repository.count(); i++) {
                customerDTOList.add(mapper.map(repository.getById(i), CustomerDTO.class));
            }
            setSpent();
        }
    }

    public void setSpent(){
        if(spent.isEmpty()){
            for (int i = 1; i < repository.count(); i++) {
                spent.add(mapper.map(repository.getById(i), Spent.class));
            }
        }
    }

    @GetMapping("customers/ranking/bySpentMoney")
    public ResponseEntity<List<CustomerStats>> giveTopTenCustomersBySpentMoney(){
        setCustomers();

        List<CustomerStats> info = new ArrayList<>();
        for (int i = 0; i < repository.count() - 1; i++) {
            info.add(new CustomerStats(customerDTOList.get(i), spent.get(i)));
        }

        return ResponseEntity.ok(info.stream()
                .sorted(Comparator.comparing(CustomerStats::getSpent).reversed())
                .limit(10).collect(Collectors.toList()));
    }

}
