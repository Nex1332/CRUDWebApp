package de.maksym.crud.DAO;

import de.maksym.crud.models.Person;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Cat"));
        people.add(new Person(++PEOPLE_COUNT, "Dog"));
        people.add(new Person(++PEOPLE_COUNT, "Fox"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void remove(String personName){
        people.removeIf(person -> Objects.equals(person.getName(), personName));
    }
}
