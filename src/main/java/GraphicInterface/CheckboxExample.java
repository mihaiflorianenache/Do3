package GraphicInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxExample extends JFrame
{
    private JLabel label = new JLabel();
    private JLabel one=new JLabel();
    private JLabel two=new JLabel();
    private JLabel selectFavoriteMountains=new JLabel();
    private JButton finish=new JButton();
    private JButton start=new JButton();
    private JCheckBox checkBoxOne=new JCheckBox();
    private JCheckBox checkBoxTwo=new JCheckBox();
    private JComboBox comboBox;
    private JButton favoriteMountains=new JButton();

    private void createComponent(final CheckboxExample checkBoxExample){
        checkBoxExample.setTitle("CheckBox Example");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400,100);

        one.setBounds(5,50,80,20);
        one.setText("One");
        checkBoxExample.add(one);

        two.setBounds(5,70,80,20);
        two.setText("Two");
        checkBoxExample.add(two);

        final String mountains[]={"Anzi","Alpi","Pontici","Taurus","Verhoiansk","Kerski","Kolama"};
        comboBox=new JComboBox(mountains);
        comboBox.setBounds(50,110,230,30);
        SelectMountains selectMountains=new SelectMountains();
        comboBox.addItemListener(selectMountains);

        //selectFavoriteMountains.setBounds();

        favoriteMountains.setBounds(50,110,230,30);
        favoriteMountains.setText("Select your favorite mountains");
        favoriteMountains.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                favoriteMountains.setVisible(false);
                checkBoxExample.add(comboBox);
            }
        });

        start.setBounds(50,110,180,30);
        start.setText("Start");
        checkBoxExample.add(start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                checkBoxOne.setEnabled(true);
                checkBoxTwo.setEnabled(true);
                start.setVisible(false);
            }
        });

        finish.setBounds(50,110,180,30);
        finish.setText("Finish");
        finish.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(checkBoxExample,"Ready");
            }
        });

        checkBoxOne.setBounds(30,50,17,17);
        checkBoxOne.setText("One");
        checkBoxOne.setEnabled(false);

        checkBoxTwo.setBounds(30,70,17,17);
        checkBoxTwo.setText("Doi");
        checkBoxTwo.setEnabled(false);

        checkBoxOne.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(checkBoxOne.isSelected()) {
                    label.setText("One");
                }
                if(checkBoxOne.isSelected()==false){
                    if(checkBoxTwo.isSelected()){
                        label.setText("Two");
                    }
                    else{
                        label.setText("");
                        checkBoxOne.setEnabled(false);
                        checkBoxTwo.setEnabled(false);
                        checkBoxExample.add(favoriteMountains);
                    }
                }
            }
        });

        checkBoxTwo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(checkBoxTwo.isSelected()) {
                    label.setText("Two");
                }
                if(checkBoxTwo.isSelected()==false) {
                    if (checkBoxOne.isSelected()) {
                        label.setText("One");
                    }
                    else{
                        label.setText("");
                        checkBoxOne.setEnabled(false);
                        checkBoxTwo.setEnabled(false);
                        checkBoxExample.add(favoriteMountains);
                    }
                }
            }
        });

        checkBoxExample.add(label);
        checkBoxExample.add(checkBoxOne);
        checkBoxExample.add(checkBoxTwo);
        checkBoxExample.setSize(400,400);
        checkBoxExample.setLayout(null);
        checkBoxExample.setVisible(true);
    }

    class SelectMountains implements ItemListener{
        public void itemStateChanged(ItemEvent event){
            int i;
            //if(comboBox.getSelectedItem()
        }
    }

    public static void main(String args[])
    {
        CheckboxExample checkBoxExample=new CheckboxExample();
        checkBoxExample.createComponent(checkBoxExample);
    }
}