package com.example.demo.model;

import com.example.demo.DTOModel.RentalDTO;

import java.util.Collection;

public class Rental {
    Collection<RentalDTO> rentalDTOS;

    public Collection<RentalDTO> getRentalDTOS() {
        return rentalDTOS;
    }

    public void setRentalDTOS(Collection<RentalDTO> rentalDTOS) {
        this.rentalDTOS = rentalDTOS;
    }
}
