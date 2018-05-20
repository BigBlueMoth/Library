package DataClassManagment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

public class FileController {
    private static String FILE_PATH = "C:\\Users\\stalm\\Documents\\repos 2\\Book\\src\\Books";


    private static String convertBookDataToFileFormat(Book book) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(book.getAuthor() + "|");
        stringBuilder.append(book.getTitle() + "|");
        stringBuilder.append(book.getPublisher() + "|");
        stringBuilder.append(Integer.toString(book.getPublicationYear()) + "|");
        stringBuilder.append(Integer.toString(book.getNumberOfPages()));
        return stringBuilder.toString();
    }

    private static Book convertLineToBook(String line) {
        String[] bookAttributes = line.split("[|+]");
        return new Book(bookAttributes);

    }

    private static void clearFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            bufferedWriter.append("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addBookToFile(Book book) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bufferedWriter.append(convertBookDataToFileFormat(book) + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateFileAfterDeleting(Vector<Book> updatedBookCollection) {
        clearFile();
        for (Book book : updatedBookCollection) {
            addBookToFile(book);
        }
    }


    public static Vector<Book> loadAllBooksDataFromFile() {
        Vector<Book> res = new Vector<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.add(convertLineToBook(line));

            }
        } catch (Exception e) {
            e.printStackTrace();

        } return res;
    }


}