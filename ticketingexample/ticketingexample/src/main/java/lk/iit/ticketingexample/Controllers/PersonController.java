package lk.iit.ticketingexample.Controllers;

import lk.iit.ticketingexample.Database.PersonRepository;
import lk.iit.ticketingexample.Models.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/test")
    public String test() {
        return "API works correctly";
    }

    @PostMapping("/add-person")
    public String addPerson(@RequestHeader HttpHeaders headers) {
        final String firstname = String.valueOf(headers.getFirst("First-Name"));
        final String lastname = String.valueOf(headers.getFirst("Last-Name"));
        final String email = String.valueOf(headers.getFirst("Email"));
        Person person = new Person(firstname, lastname, email);
        personRepository.save(person);
        return "Added " + firstname + " " + lastname + " " + email;
    }

    @GetMapping("/get-person")
    public List<Person> getPerson(@RequestHeader HttpHeaders headers) {
        return personRepository.findAll();
    }
}
