package com.galvanize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void bookFormattedNameReturnsCorrectly() {
        Author author = new Author();
        author.setFirstName("Eric");
        author.setLastName("Evans");
        Publisher publisher = new Publisher();
        publisher.setName("Addison-Wesley");
        publisher.setCity("New York");
        Book book = new Book();
        book.setTitle("Domain-Driven Design");
        book.setYear(2004);
        book.setAuthor(author);
        book.setPublisher(publisher);

        String expected = "Domain-Driven Design (2004)\n" +
                "Written by Evans, Eric\n" +
                "Published by Addison-Wesley, New York";
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + book.getFormattedName());
        assertEquals(expected, book.getFormattedName());
    }
}
