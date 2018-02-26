package com.galvanize;

public class Book {

    private String bookTitle;
    private int bookYear;
    private String authorFirstName;
    private String authorLastName;
    private String publisherName;
    private String publisherCity;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookName) {
        this.bookTitle = bookName;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherCity() {
        return publisherCity;
    }

    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }

    public String getFormattedPublisherName() {
        return String.format("%s, %s", publisherName, publisherCity);
    }

    public String getFormattedAuthorName() {
        return String.format("%s, %s", authorLastName, authorFirstName);
    }

    public String getFormattedBookName() {
        return String.format(
                "%s (%s)\nWritten by %s\nPublished by %s",
                bookTitle,
                bookYear,
                getFormattedAuthorName(),
                getFormattedPublisherName()
        );
    }
}
