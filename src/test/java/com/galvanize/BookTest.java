package com.galvanize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void bookFormattedNameReturnsCorrectly() {
        Book book = new Book();
        book.setAuthorFirstName("Eric");
        book.setAuthorLastName("Evans");
        book.setBookTitle("Domain-Driven Design");
        book.setBookYear(2004);
        book.setPublisherName("Addison-Wesley");
        book.setPublisherCity("New York");

        String expected = "Domain-Driven Design (2004)\n" +
                "Written by Evans, Eric\n" +
                "Published by Addison-Wesley, New York";

        assertEquals(expected, book.getFormattedBookName());
    }
}
