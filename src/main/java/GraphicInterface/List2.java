package GraphicInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class List2 {

    private JList graphicList;

    public static void main(String[] args){
        List2 list=new List2();
        list.addComponent();
    }

    private void addComponent(){
        JFrame frame=new JFrame();
        frame.setTitle("Graphic List");

        JLabel label=new JLabel();
        label.setBounds(50,30,150,15);

        JLabel labelScrollBar=new JLabel();
        labelScrollBar.setBounds(50,200,100,300);

        JButton button=new JButton();
        button.setText("Push");
        button.setBounds(50,120,100,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(graphicList.getSelectedIndex()!=-1){
                    label.setText("You selected "+graphicList.getSelectedValue());
                    //OPTIUNI SCOASE IN EVIDENTA: QUESTION_MESSAGE, WARNING_MESSAGE, ERROR_MESSAGE, YES_NO_OPTION, OK_OPTION, YES_OPTION, HEIGHT, WIDTH, INFORMATION_MESSAGE, NO_OPTION, YES_NO_CANCEL_OPTION, OK_CANCEL_OPTION, WHEN_FOCUSED
                    JOptionPane.showMessageDialog(frame,label.getText());
                    JOptionPane.showMessageDialog(frame,"Bingo","Alert",JOptionPane.WARNING_MESSAGE);
                    String name=JOptionPane.showInputDialog(frame,"Enter your name");
                    JOptionPane.showConfirmDialog(frame,"Are you sure ?");
                    JOptionPane.showMessageDialog(frame,name);
                }
            }
        });

        DefaultListModel<String> defaultListModel=new DefaultListModel<>();
        defaultListModel.addElement("Cluj");
        defaultListModel.addElement("Bihor");
        defaultListModel.addElement("Maramures");

        graphicList=new JList(defaultListModel);
        graphicList.setBounds(50,50,80,60);

        JScrollBar scrollBar=new JScrollBar();
        scrollBar.setBounds(50,160,30,30);
        scrollBar.addAdjustmentListener(new AdjustmentListener(){
            public void adjustmentValueChanged(AdjustmentEvent event){

            }
        });

        frame.add(button);
        frame.add(label);
        frame.add(graphicList);
        frame.add(scrollBar);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
