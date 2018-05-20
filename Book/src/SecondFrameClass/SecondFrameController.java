package SecondFrameClass;

import DataClassManagment.BookData;
import DataClassManagment.Book;
import MainFrameClass.TablePanel.TablePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondFrameController {
    private static SecondFrame secondFrame;
    private static BookData bookData;


    public SecondFrameController(BookData bookData, TablePanel tablePanel) {
        secondFrame = new SecondFrame(tablePanel);
        this.bookData = bookData;
    }

    public static class BackBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) { secondFrame.dispose(); }
    }

    public static class AddBtnListener implements ActionListener {
        private static TablePanel tablePanel;

        public AddBtnListener(TablePanel tablePanel) {
            this.tablePanel = tablePanel;
        }

        public void actionPerformed(ActionEvent e) {
            String[] bookDataArray = secondFrame.getUserInput();
            if (isInputCorrect(bookDataArray)) {
                bookData.addNewBook(new Book(bookDataArray));
                tablePanel.addRow(bookDataArray);
                secondFrame.resetInputFields();

            }

        }


        private boolean isInputCorrect(String[] bookDataArray) {
            for (int idx = 0; idx < 5; idx++) {
                if (bookDataArray[idx].isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "Can't Empty Input!",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            for (int idx = 3; idx < 5; idx++) {
                for (char sign : bookDataArray[idx].toCharArray()) {
                    if (sign < 48 || sign > 57) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "You must give number in 2 last field",
                                "Input Error",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
            }
            return true;


        }

    }
}
