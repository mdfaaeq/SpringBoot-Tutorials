package lk.iit.ticketingexample.Database;

import lk.iit.ticketingexample.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
