package MainFrameClass;

import MainFrameClass.ControlPanel.ControlPanel;
import MainFrameClass.TablePanel.TablePanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    private ControlPanel controlPanel;
    private TablePanel tablePanel;

    public MainFrame(String[][] tableData){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(1280,720));
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,2));

        controlPanel = new ControlPanel();
        tablePanel = new TablePanel(tableData);

        add(controlPanel);
        add(tablePanel);

        setVisible(true);
    }

    public void addRow(String[] bookDataArray) {
        tablePanel.addRow(bookDataArray);
    }

    public void deleteRow() {
        tablePanel.deleteRow();
    }

    public String[] getSelectedBookData() {
        return tablePanel.getSelectedBookData();
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public String getTxtFieldSearchByInput() {
        return controlPanel.getTxtFieldSearchByInput();
    }

    public int getComboBoxSearchBySelectedArg() { return controlPanel.getComboBoxSearchBySelectedAttribute(); }

    public void resetSelection() { tablePanel.clearRowSelection(); }

    public void selectRow(String bookToCheckAttribute, int idx) { tablePanel.selectRow(bookToCheckAttribute, idx); }

}
