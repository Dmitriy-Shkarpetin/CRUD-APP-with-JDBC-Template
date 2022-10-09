package ru.origin.myproject1.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private int id;

    @NotEmpty(message = "Поле 'фамилия' не должно быть пустым")
    @Size(min = 2, max = 50, message = "Фамилия должна содержать от 2 до 50 символов длиной")
    private String surname;

    @NotEmpty(message = "Поле 'имя' не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно содержать от 2 до 30 символов длиной")
    private String name;

    @NotEmpty(message = "Поле 'отчество' не должно быть пустым")
    @Size(min = 2, max = 50, message = "Отчество должно содержать от 2 до 50 символов длиной")
    private String middleName;

    @Min(value = 1800, message = "Год рождения должен быть от 1800 г.")
    private int year_of_birth;

    public Person() {
    }

    public Person(int id, String surname, String name, String middleName, int year_of_birth) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.year_of_birth = year_of_birth;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }
}
