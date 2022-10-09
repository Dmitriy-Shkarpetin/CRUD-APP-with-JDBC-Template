package ru.origin.myproject1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.origin.myproject1.dao.PersonDAO;
import ru.origin.myproject1.models.Person;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if(personDAO.getPersonBySurname(person.getSurname()).isPresent())
            errors.rejectValue("surname","", "Человек с такой фамилией уже существует");

        if(personDAO.getPersonByName(person.getName()).isPresent())
            errors.rejectValue("name", "", "Человек с таким именем уже существует");

        if(personDAO.getPersonByMiddleName(person.getMiddleName()).isPresent())
            errors.rejectValue("middleName", "", "Человек с таким отчеством уже существует");
    }
}
