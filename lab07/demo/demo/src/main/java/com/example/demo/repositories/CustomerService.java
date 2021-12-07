package com.example.demo.repositories;

import com.example.demo.DTOModel.CustomerDTO;
import com.example.demo.DTOModel.PaymentDTO;
import com.example.demo.DTOModel.RentalDTO;
import com.example.demo.model.MonthRents;
import com.example.demo.model.YearRents;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerService {

    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    private final List<CustomerDTO> customerDTOList = new ArrayList<>();
    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerDTO> setCustomers() {
        if (customerDTOList.isEmpty()) {
            for (int i = 1; i < repository.count(); i++) {
                CustomerDTO customer = mapper.map(repository.getById(i), CustomerDTO.class);
                setSpentToCustomer(customer);
                setWatchedToCustomer(customer);
                customerDTOList.add(customer);
            }
        }
        return customerDTOList;
    }

    public void setSpentToCustomer(CustomerDTO customerDTO) {
        customerDTO.setSpent(customerDTO.getCustomerPayments()
                .stream().map(PaymentDTO::getAmount)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add));
    }

    public void setWatchedToCustomer(CustomerDTO customerDTO) {
        customerDTO.setWatched(customerDTO.getCustomerPayments().size());
    }


    public  List<RentalDTO> getRentsInYear(CustomerDTO customerDTO, int year){
        return  customerDTO.getCustomerRentals()
                .stream()
                .filter(r -> r.getRentalDate().toLocalDateTime().getYear() == year)
                .collect(Collectors.toList());
    }

    public YearRents getRentsByMonth(CustomerDTO customerDTO, int year){
        List<MonthRents> monthRents = new ArrayList<>();
        IntStream.rangeClosed(1,12).forEach(i ->  monthRents.add(new MonthRents(i,
                (int) getRentsInYear(customerDTO, year).stream().filter(r -> r.getRentalDate().getMonth() == i).count())));

        YearRents yearRents = new YearRents();
        yearRents.setMonthRents(monthRents);

        return yearRents;
    }
}
