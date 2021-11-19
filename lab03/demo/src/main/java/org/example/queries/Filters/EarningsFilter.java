package org.example.queries.Filters;

import org.example.model.Person;

import java.util.List;

public class EarningsFilter implements Filter {
    double incomeFrom;
    double incomeTo;

    public EarningsFilter(double incomeFrom, double incomeTo) {
        this.incomeFrom = incomeFrom;
        this.incomeTo = incomeTo;
    }



    @Override
    public List<Person> filter(List<Person> persons) {
        if (incomeFrom != 0 || incomeTo !=0) {
            if (incomeFrom !=0 && incomeTo==0){
                return  persons.stream().filter(person -> person.getIncome() >= incomeFrom)
                        .toList();
            }
            return persons.stream().filter(person -> person.getIncome() >= incomeFrom)
                    .filter(person -> person.getIncome() <= incomeTo).toList();

        }
        return persons;
    }
}
