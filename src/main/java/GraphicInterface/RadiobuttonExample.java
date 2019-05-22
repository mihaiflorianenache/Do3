package GraphicInterface;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadiobuttonExample extends JFrame{

    private JRadioButton radioButtonOne=new JRadioButton();
    private JRadioButton radioButtonTwo=new JRadioButton();
    private ButtonGroup buttonGroup=new ButtonGroup();

    private void createComponent(final RadiobuttonExample radiobuttonExample){

        radioButtonOne.setText("One");
        radioButtonOne.setBounds(10,10,70,20);
        radioButtonOne.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(radioButtonOne.isSelected()) {
                    JOptionPane.showMessageDialog(radiobuttonExample, "You selected One");
                }
            }
        });

        radioButtonTwo.setText("Two");
        radioButtonTwo.setBounds(10,40,70,20);
        radioButtonTwo.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(radioButtonTwo.isSelected()) {
                    JOptionPane.showMessageDialog(radiobuttonExample, "You selected Two");
                }
            }
        });

        buttonGroup.add(radioButtonOne);
        buttonGroup.add(radioButtonTwo);

        radiobuttonExample.add(radioButtonOne);
        radiobuttonExample.add(radioButtonTwo);
        radiobuttonExample.setSize(500,500);
        radiobuttonExample.setLayout(null);
        radiobuttonExample.setVisible(true);
    }

    public static void main(String[] args){
        RadiobuttonExample radiobuttonExample=new RadiobuttonExample();
        radiobuttonExample.createComponent(radiobuttonExample);
    }
}
