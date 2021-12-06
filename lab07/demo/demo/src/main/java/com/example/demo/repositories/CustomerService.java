package com.example.demo.repositories;

import com.example.demo.DTOModel.CustomerDTO;
import com.example.demo.DTOModel.PaymentDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class CustomerService {

    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    private final List<CustomerDTO> customerDTOList = new ArrayList<>();
    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerDTO> setCustomers(){
        if(customerDTOList.isEmpty()){
            for (int i = 1; i < repository.count(); i++) {

                CustomerDTO customer = mapper.map(repository.getById(i), CustomerDTO.class);

                customer.setSpent(customer.getCustomerPayments()
                                .stream().map(PaymentDTO::getAmount)
                                .reduce(BigDecimal.valueOf(0), BigDecimal::add));

                customerDTOList.add(customer);
            }
        }
        return customerDTOList;
    }
}
