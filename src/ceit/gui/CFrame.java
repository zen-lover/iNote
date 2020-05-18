package ceit.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CFrame extends JFrame implements ActionListener {

    private CMainPanel mainPanel;

    private JMenuItem newItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;


    public CFrame(String title) {
        super(title);

        initMenuBar(); //create menuBar

        initMainPanel(); //create main panel
    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu jmenu = new JMenu("File");

        newItem = new JMenuItem("New");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        newItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        jmenu.add(newItem);
        jmenu.add(saveItem);
        jmenu.add(exitItem);

        menuBar.add(jmenu);
        setJMenuBar(menuBar);
    }

    private void initMainPanel() {
        mainPanel = new CMainPanel();
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem) {
            mainPanel.addNewTab();
        } else if (e.getSource() == saveItem) {
            mainPanel.saveNote();
        } else if (e.getSource() == exitItem) {
            int tabSize = mainPanel.getTabbedPane().getTabCount();
            for (int i=0; i<tabSize; i++){
                mainPanel.getTabbedPane().setSelectedIndex(i);
                mainPanel.saveNote();
            }
            System.exit(0);
        } else {
            System.out.println("Nothing detected...");
        }
    }
}
