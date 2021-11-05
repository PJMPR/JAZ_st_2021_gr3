package org.example.queries.Filters;
import org.example.model.Person;
import java.util.List;

public class AgeFilter implements Filter{
    int from;
    int to;

    public AgeFilter(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public List<Person> filter(List<Person> persons) {
        if (from != 0 || to !=0) {
            if (from !=0 && to==0){
                return persons.stream().filter(person -> person.getAge() >= from).toList();
            }
            return persons.stream().filter(person -> person.getAge() >= from).toList()
                    .stream().filter(person -> person.getAge() <= to).toList();
        }
        else {
            return persons;
        }
    }
}