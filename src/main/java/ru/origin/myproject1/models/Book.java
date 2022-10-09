package ru.origin.myproject1.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int id;

    @NotEmpty(message = "Поле 'название' не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название должно содержать от 2 до 100 символов длиной")
    private String name;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Поле 'автор' должно содержать от 2 до 100 символов длиной")
    private String author;

    @Min(value = 1800, message = "Год издания книги должен быть от 1800 г.")
    private int year_of_publication;

    public Book(){
    }

    public Book(int id, String name, String author, int year_of_publication) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year_of_publication = year_of_publication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }
}
