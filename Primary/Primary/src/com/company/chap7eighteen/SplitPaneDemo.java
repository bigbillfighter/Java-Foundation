package com.company.chap7eighteen;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class SplitPaneDemo implements ListSelectionListener {
    private JLabel pricture;
    private JList list;
    private JSplitPane splitPane;
    private final String[] names = {"Bird.gif", "Cat.gif", "Dog.gif", "dukeWaveRed.gif",
            "Pig.gif", "Rabbit.gif", "stickerface.gif"};

    public SplitPaneDemo(){
        list = new JList(names);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        JScrollPane listScrollPane = new JScrollPane(list);

        ImageIcon firstImage = new ImageIcon("./doc/images/"+(String)names[0]);
        pricture = new JLabel(firstImage);
        pricture.setPreferredSize(new Dimension(firstImage.getIconWidth(), firstImage.getIconHeight()));
        JScrollPane pictureScrollPane = new JScrollPane(pricture);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScrollPane, pictureScrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);

        Dimension minimumSize = new Dimension(100, 50);
        listScrollPane.setMinimumSize(minimumSize);
        pictureScrollPane.setMinimumSize(minimumSize);

        splitPane.setPreferredSize(new Dimension(400, 200));
    }



    public JList getImageList(){
        return list;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()) return;

        JList theList = (JList)e.getSource();
        if(theList.isSelectionEmpty()){
            pricture.setIcon(null);
        }else{
            int index = theList.getSelectedIndex();
            ImageIcon newImage = new ImageIcon("./doc/images/"+(String)names[index]);
            pricture.setIcon(newImage);
            pricture.setPreferredSize(new Dimension(newImage.getIconWidth(), newImage.getIconHeight()));
            pricture.revalidate();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SplitPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SplitPaneDemo splitPaneDemo = new SplitPaneDemo();
        frame.getContentPane().add(splitPaneDemo.getSplitPane());
        frame.pack();
        frame.setVisible(true);
    }
}
