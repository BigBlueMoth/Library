package SecondFrameClass;

import DataClassManagment.BookData;
import MainFrameClass.TablePanel.TablePanel;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BoxLayout.Y_AXIS;

public class SecondFrame extends JFrame {
    private final Dimension textFieldDim = new Dimension(250, 25);

    private JPanel contentPane;
    private JLabel[] labels;
    private JTextField[] textFields;
    private  JButton btnAddBook;
    private JButton btnBack;

    public SecondFrame(TablePanel tablePanel){
        labels = new JLabel[5];
        textFields = new JTextField[5];


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(200,400));
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        add(contentPane);

        for (int idx=0; idx<5 ;idx++){
            labels[idx] = new JLabel(BookData.BOOK_ATTRIBUTES[idx] + ":");
            textFields[idx] = new JTextField();
            textFields[idx].setMaximumSize(textFieldDim);
            textFields[idx].setAlignmentX(labels[idx].getX());
        }

        btnAddBook = new JButton("Add Book");
        btnAddBook.addActionListener(new SecondFrameController.AddBtnListener(tablePanel));
        btnBack = new JButton("Back");
        btnBack.addActionListener(new SecondFrameController.BackBtnListener());

        addComponents();
        setVisible(true);

    }

    private void addComponents(){
        contentPane.add(Box.createRigidArea(new Dimension(0,20)));
        for (int idx=0; idx<5 ;idx++)  {
            contentPane.add(Box.createVerticalGlue());
            JPanel linePanel = new JPanel(new GridLayout(2,1));
            linePanel.add(labels[idx]);
            linePanel.add(textFields[idx]);
            contentPane.add(linePanel);
            contentPane.add(Box.createRigidArea(new Dimension(0,10)));
        }

        JPanel linePanel = new JPanel(new GridLayout(1,2));
        linePanel.add(btnAddBook);
        linePanel.add(btnBack);
        contentPane.add(linePanel);

    }

    public String[] getUserInput(){
        String[] userInput = new String[5];
        for (int idx=0; idx<5; idx++){
            userInput[idx] = textFields[idx].getText();
        }
        return userInput;
    }

    public void resetInputFields() {
        for (JTextField textField: textFields){
            textField.setText("");

         }
    }


}

