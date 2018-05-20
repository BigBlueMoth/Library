package MainFrameClass;

import DataClassManagment.BookData;
import SecondFrameClass.SecondFrameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController {
    private static MainFrame mainFrame;
    private static BookData bookData;

    public MainFrameController(BookData bookData){
        this.bookData = bookData;
        mainFrame = new MainFrame(bookData.convertBookDataToTableFormat());

    }
    public static class addBtnListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {new SecondFrameController(bookData, mainFrame.getTablePanel());}
    }

    public static class deleteBtnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            bookData.deleteBook(mainFrame.getSelectedBookData());
            mainFrame.deleteRow();
        }
    }

    public static class txtFieldSearchByListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String bookAttr = mainFrame.getTxtFieldSearchByInput();
            int colIdx =mainFrame.getComboBoxSearchBySelectedArg();
            for (int idx = 0; idx < bookData.getBookCollection().size(); idx++) {
                String[]bookToCheckAttributes=
                        bookData.convertBookDataToStringArray(bookData.getBookCollection().elementAt(idx));

                if(bookToCheckAttributes[colIdx].contains(bookAttr)){
                    mainFrame.resetSelection();
                    mainFrame.selectRow(bookToCheckAttributes[colIdx], colIdx);

               }
            }
        }
    }

}
