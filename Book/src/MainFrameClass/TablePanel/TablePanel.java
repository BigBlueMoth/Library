package MainFrameClass.TablePanel;

import DataClassManagment.BookData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Comparator;

public class TablePanel extends JPanel {
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JTable bookTable;

    public TablePanel(String[][] bookDataInTableFormat){
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(bookDataInTableFormat, BookData.BOOK_ATTRIBUTES);

        TableRowSorter sorter = new TableRowSorter(tableModel);


        class IntComparator implements Comparator{
            public int compare (Object o1, Object o2){
                Integer arg1 = Integer.parseInt((String)o1);
                Integer arg2 = Integer.parseInt((String)o2);

                return arg1.compareTo(arg2);

            }

            public boolean equals(Object o2){
                return this.equals(o2);
            }

        }

        class StringComparator implements Comparator{
            public int compare (Object o1, Object o2){
                String arg1 = (String) o1;
                String arg2 = (String) o2;

                return arg1.toLowerCase().compareTo(arg2.toLowerCase());
                }

            public boolean equals(Object o2){
                return this.equals(o2);
            }

        }

        sorter.setComparator(0, new StringComparator());
        sorter.setComparator(1, new StringComparator());
        sorter.setComparator(2, new StringComparator());
        sorter.setComparator(3, new IntComparator());
        sorter.setComparator(4, new IntComparator());

        bookTable = new JTable(tableModel);
        bookTable.setRowSorter(sorter);
        bookTable.setAutoCreateRowSorter(false);

        scrollPane = new JScrollPane(bookTable);
        add(scrollPane, BorderLayout.CENTER);

    }

    public void addRow(String[] bookDataArray) {tableModel.addRow(bookDataArray);}


    public void deleteRow(){
        int rowToDelete = bookTable.convertRowIndexToModel(bookTable.getSelectedRow());
        tableModel.removeRow(rowToDelete);

    }


    public String[] getSelectedBookData(){
        int selectedRow = bookTable.convertRowIndexToModel(bookTable.getSelectedRow());
        String[] bookAttributes = new String[5];
        for (int idx=0; idx<5; idx++) {
            bookAttributes[idx] = (String) tableModel.getValueAt(selectedRow, idx);
        }
        return bookAttributes;
    }

    public void clearRowSelection(){
        bookTable.getSelectionModel().clearSelection();
    }

    public void selectRow(String bookToSelectAttribute, int attrColumnIdx){
        for (int idx=0; idx<tableModel.getRowCount(); idx++) {
            if(tableModel.getValueAt(idx,attrColumnIdx ).equals(bookToSelectAttribute)) {
                int rowToSelect = bookTable.convertRowIndexToModel(idx);
                bookTable.getSelectionModel().setSelectionInterval(rowToSelect, rowToSelect);
            }
        }
    }
}





























