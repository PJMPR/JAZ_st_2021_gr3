package com.example.demo.model.Converter;

import com.example.demo.model.Customer;
import com.example.demo.model.DTO.CustomerDTO;
import com.example.demo.model.DTO.PaymentDTO;
import com.example.demo.model.DTO.RentalDTO;
import com.example.demo.model.Payment;
import com.example.demo.model.Rental;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerConventer {

    public CustomerDTO entityToDTO(Customer customer){

        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(customer.getCustomerId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setPaymentsByCustomerId(entityPaymentToDTO(customer.getPaymentsByCustomerId()));
        dto.calculatePayments();
        return dto;
    }

    public List<CustomerDTO>  entityToDTO(List<Customer> customer){
        return customer.stream().map(x->entityToDTO(x)).collect(Collectors.toList());
    }

//    public Customer dtoToENTITY(CustomerDTO dto){
//
//        Customer customer = new Customer();
//        customer.setCustomerId(dto.getCustomerId());
//        customer.setFirstName(dto.getFirstName());
//        customer.setLastName(dto.getLastName());
//        return customer;
//    }

//    public List<Customer>  dtoToENTITY(List<CustomerDTO> dto){
//        return dto.stream().map(x->dtoToENTITY(x)).collect(Collectors.toList());
//    }

    public PaymentDTO entityPaymentToDTO (Payment payment){
        PaymentDTO dto = new PaymentDTO();
        dto.setAmount(payment.getAmount());
        return dto;
    }
    public List<PaymentDTO> entityPaymentToDTO (Collection<Payment> payments){
        return payments.stream().map(x->entityPaymentToDTO(x)).collect(Collectors.toList());
    }

    public RentalDTO entityRentaltoDTO(Rental rental){
        RentalDTO dto = new RentalDTO();
        // cos
        return dto;
    }


}
