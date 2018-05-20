package DataClassManagment;

public class Book {
    private String author;
    private String title;
    private String publisher;
    private int publicationYear;
    private int numberOfPages;


    public Book(String bookAttributes[]) {
        author = bookAttributes[0];
        title = bookAttributes[1];
        publisher = bookAttributes[2];
        publicationYear = Integer.parseInt(bookAttributes[3]);
        numberOfPages = Integer.parseInt(bookAttributes[4]);
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

}
