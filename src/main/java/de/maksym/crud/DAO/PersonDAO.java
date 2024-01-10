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

        people.add(new Person(++PEOPLE_COUNT, "Ivan", 41, "ivanzhenat33goda@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Fox", 45, "foxhyesos@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Pavel", 22, "pavelparguzin32@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Artem", 14, "artemhyi132@gmail.com"));
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

    public void update(int id, Person editPerson){
        Person updatedPerson = show(id);

        updatedPerson.setName(editPerson.getName());
        updatedPerson.setAge(editPerson.getAge());
        updatedPerson.setEmail(editPerson.getEmail());
    }
}
