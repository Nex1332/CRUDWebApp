package de.maksym.crud.repository;

import de.maksym.crud.models.*;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
