package DataClassManagment;


import java.util.Arrays;
import java.util.Vector;

public class BookData {
    public static final String[] BOOK_ATTRIBUTES = {
            "Author", "Title", "Publisher", "Publication year", "Number Of pages"
    };

    private Vector<Book> bookCollection;

    public BookData() {
        bookCollection = FileController.loadAllBooksDataFromFile();
    }

    public void addNewBook(Book newBook) {
        bookCollection.add(newBook);
        FileController.addBookToFile(newBook);
    }

    public void deleteBook(String[] attributesOfBookToErase) {
        for (Book book : bookCollection) {
            if (Arrays.deepEquals(convertBookDataToStringArray(book), attributesOfBookToErase)) {
                bookCollection.remove(book);
                break;
            }
        }
        FileController.updateFileAfterDeleting(bookCollection);
    }

    public String[] convertBookDataToStringArray(Book book) {
        String[] bookDataArray = new String[5];
        bookDataArray[0] = book.getAuthor();
        bookDataArray[1] = book.getTitle();
        bookDataArray[2] = book.getPublisher();
        bookDataArray[3] = Integer.toString(book.getPublicationYear());
        bookDataArray[4] = Integer.toString(book.getNumberOfPages());

        return bookDataArray;
    }

    public String[][] convertBookDataToTableFormat() {
        String[][] tableData = new String[bookCollection.size()][5];

        for (int idx = 0; idx < bookCollection.size(); idx++) {
            tableData[idx] = convertBookDataToStringArray(bookCollection.elementAt(idx));
        }
        return tableData;
    }

    public Vector<Book> getBookCollection() {
        return bookCollection;
    }
}
