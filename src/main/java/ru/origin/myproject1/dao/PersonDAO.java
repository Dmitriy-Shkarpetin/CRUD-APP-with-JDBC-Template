package ru.origin.myproject1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.origin.myproject1.models.Book;
import ru.origin.myproject1.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(surname, name, middleName, year_of_birth) VALUES(?, ?, ?, ?)", person.getSurname(), person.getName(), person.getMiddleName(),
                person.getYear_of_birth());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET surname=?, name=?, middleName=?, year_of_birth=? WHERE id=?", updatedPerson.getSurname(),
                updatedPerson.getName(), updatedPerson.getMiddleName(), updatedPerson.getYear_of_birth(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public Optional<Person> getPersonBySurname(String surname) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE surname = ?", new Object[]{surname},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public Optional<Person> getPersonByName(String name) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE name = ?", new Object[]{name},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public Optional<Person> getPersonByMiddleName(String middleName) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE middleName = ?", new Object[]{middleName},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public List<Book> getBooksByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }
}
