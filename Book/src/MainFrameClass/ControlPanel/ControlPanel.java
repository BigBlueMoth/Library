package MainFrameClass.ControlPanel;

import DataClassManagment.Book;
import DataClassManagment.BookData;
import MainFrameClass.MainFrameController;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel{
    private JButton btnAddBook;
    private JButton btnDeleteBook;
    private JLabel lblSearchBy;
    private JComboBox comboBoxSearchBy;
    private JTextField txtFieldSearchBy;
    private JCheckBox checkBoxShowAbove;
    private JCheckBox checkBoxShowBelow;
    private JTextField showBelowOrAboveTextField;


    public ControlPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        btnAddBook = new JButton("Add new Book");
        btnAddBook.addActionListener(new MainFrameController.addBtnListener());

        btnDeleteBook = new JButton("Delte Book");
        btnDeleteBook.addActionListener(new MainFrameController.deleteBtnListener());

        lblSearchBy = new JLabel("Search by" ,SwingConstants.LEFT);
        lblSearchBy.setAlignmentX(Component.LEFT_ALIGNMENT);

        comboBoxSearchBy = new JComboBox(BookData.BOOK_ATTRIBUTES);

        txtFieldSearchBy = new JTextField();
        txtFieldSearchBy.addActionListener(new MainFrameController.txtFieldSearchByListener());

        checkBoxShowAbove = new JCheckBox("Show Above");
        checkBoxShowBelow = new JCheckBox("Show Below");

        showBelowOrAboveTextField = new JTextField();

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(2,1));

        btnPanel.add(btnAddBook);
        btnPanel.add(btnDeleteBook);

        JPanel searchByPanel = new JPanel();
        searchByPanel.setLayout(new GridLayout(4,1));
        searchByPanel.add(lblSearchBy);
        searchByPanel.add(comboBoxSearchBy);
        searchByPanel.add(txtFieldSearchBy);

        JPanel showInterval = new JPanel();
        showInterval.setLayout(new GridLayout(3,1));
        showInterval.add(checkBoxShowAbove);
        showInterval.add(checkBoxShowBelow);
        showInterval.add(showBelowOrAboveTextField);


        add(btnPanel);
        add(Box.createVerticalGlue());
        add(searchByPanel);
        add(Box.createVerticalGlue());
        add(showInterval);
        add(Box.createVerticalGlue());


    }

    public String getTxtFieldSearchByInput(){
        return txtFieldSearchBy.getText();
    }
    public int getComboBoxSearchBySelectedAttribute(){
        return comboBoxSearchBy.getSelectedIndex();
    }
}
