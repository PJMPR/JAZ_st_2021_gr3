package com.example.demo.controllers;

import com.example.demo.Service.Service;
import com.example.demo.model.Converter.CustomerConventer;
import com.example.demo.model.Customer;
import com.example.demo.model.DTO.CustomerDTO;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    public CustomerController(Service service) {
        this.service = service;
    }
    private Service service;


//    @GetMapping
//    @RequestMapping("{id}")
//    public ResponseEntity get(@PathVariable("id") int id){
//        Timestamp t = Timestamp.valueOf("2021-01-10 00:00:00");
//        return ResponseEntity.ok(repository.getById(id)
//                .getRentalsByCustomerId()
//                .stream()
//                .map(x->x.getLastUpdate())
//                .collect(Collectors.toList()));
//    }

    @GetMapping
    @RequestMapping("/ranking/bySpentMoney")
    public ResponseEntity<List<CustomerDTO>> TopTenRichestClients(){

        return new ResponseEntity<List<CustomerDTO>>(service.getTop10(), HttpStatus.OK);
    }
}
