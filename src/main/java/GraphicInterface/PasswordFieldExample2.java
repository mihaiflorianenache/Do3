package GraphicInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PasswordFieldExample2 extends JFrame {

    private char passwordValue[];
    private String textValue="";
    private int pushButton=0;

    private JPasswordField passwordField = new JPasswordField();
    private JButton button = new JButton("See password");
    private JTextField textField = new JTextField();
    private JCheckBox checkBoxButton = new JCheckBox();
    private JCheckBox checkBoxTextPassword=new JCheckBox();
    private JLabel labelCheckBoxButton=new JLabel();
    private JLabel labelCheckBoxTextPassword=new JLabel();

    public static void main(String args[]) {
        PasswordFieldExample2 passwordFieldExample = new PasswordFieldExample2();
        passwordFieldExample.createElements(passwordFieldExample);
    }

    private void createElements(final PasswordFieldExample2 passwordFieldExample) {
        passwordFieldExample.setTitle("Password field example2");
        passwordField.setBounds(100, 100, 181, 30);

        button.setBounds(100, 140, 180, 30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //I can see password's value
                pushButton++;
                if (pushButton % 2 != 0) {
                    passwordValue = passwordField.getPassword();
                    int i;
                    if(pushButton>1){
                        //VERY IMPORTANT
                        textValue="";
                    }
                    for (i = 0; i < passwordValue.length; i++) {
                        textValue = textValue.concat(String.valueOf(passwordValue[i]));
                    }
                    passwordField.setText("");
                    passwordFieldExample.remove(passwordField);
                    passwordFieldExample.add(textField);
                    textField.setText(textValue);
                    button.setText("Hide password");
                    passwordFieldExample.setTitle("Text field example2");
                    labelCheckBoxButton.setText("Deactivate text field");
                    labelCheckBoxTextPassword.setText("Deactivate "+"'"+"hide password"+"'"+" button");
                } else {
                    textValue = textField.getText();
                    textField.setText("");
                    passwordFieldExample.remove(textField);
                    passwordFieldExample.add(passwordField);
                    passwordField.setText(textValue);
                    button.setText("See password");
                    passwordFieldExample.setTitle("Password field example2");
                    labelCheckBoxButton.setText("Deactivate password field");
                    labelCheckBoxTextPassword.setText("Deactivate "+"'"+"see password"+"'"+" button");
                }

                /***********************************************************************************************************/

                //checkbox-ul pentru a activa/dezactiva campul de vizualizare sau nevizualizare al parolei este activat
                //si se da click pe buton
                if(checkBoxTextPassword.isSelected() && button.getText().equals("See password")){
                    passwordField.setEnabled(false);
                    labelCheckBoxButton.setText("Activate password field");
                }
                else
                {
                    if(checkBoxTextPassword.isSelected() && button.getText().equals("Hide password")){
                        textField.setEnabled(false);
                        labelCheckBoxButton.setText("Activate text field");
                    }
                }

                /**********************************************************************************************************/

                //checkbox-ul pentru a activa/dezactiva campul de vizualizare sau nevizualizare al parolei este dezactivat
                //si se da click pe buton
                if(checkBoxTextPassword.isSelected()==false && button.getText().equals("See password")){
                    passwordField.setEnabled(true);
                    labelCheckBoxButton.setText("Deactivate password field");
                }
                else
                {
                    if(checkBoxTextPassword.isSelected()==false && button.getText().equals("Hide password")){
                        textField.setEnabled(true);
                        labelCheckBoxButton.setText("Deactivate text field");
                    }
                }
            }
        });

        textField.setBounds(100,100,181,30);

        checkBoxButton.setBounds(290, 155, 17, 17);
        checkBoxTextPassword.setBounds(290,114,17,17);

        checkBoxButton.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent event){
                if(checkBoxButton.isSelected()){
                    button.setEnabled(false);
                    if(button.getText().equals("See password")){
                        labelCheckBoxTextPassword.setText("Activate "+"'"+"see password"+"'"+" button");
                    }
                    else{
                        labelCheckBoxTextPassword.setText("Activate "+"'"+"hide password"+"'"+" button");
                    }
                }
                else{
                    button.setEnabled(true);
                    if(button.getText().equals("See password")){
                        labelCheckBoxTextPassword.setText("Deactivate "+"'"+"see password"+"'"+" button");
                    }
                    else{
                        labelCheckBoxTextPassword.setText("Deactivate "+"'"+"hide password"+"'"+" button");
                    }
                }
            }
        });

        checkBoxTextPassword.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent event){
                if(checkBoxTextPassword.isSelected()){
                    if(button.getText().equals("See password")){
                        passwordField.setEnabled(false);
                        labelCheckBoxButton.setText("Activate password field");
                    }
                    else{
                        textField.setEnabled(false);
                        labelCheckBoxButton.setText("Activate text field");
                    }
                }
                else{
                    if(button.getText().equals("See password")){
                        passwordField.setEnabled(true);
                        labelCheckBoxButton.setText("Deactivate password field");
                    }
                    else{
                        textField.setEnabled(true);
                        labelCheckBoxButton.setText("Deactivate text field");
                    }
                }
            }
        });

        labelCheckBoxButton.setBounds(310,109,200,30);
        labelCheckBoxTextPassword.setBounds(310,150,200,30);

        labelCheckBoxButton.setText("Deactivate password field");
        labelCheckBoxTextPassword.setText("Deactivate "+"'"+"see password"+"'"+" button");

        passwordFieldExample.add(passwordField);
        passwordFieldExample.add(button);
        passwordFieldExample.add(checkBoxButton);
        passwordFieldExample.add(checkBoxTextPassword);
        passwordFieldExample.add(labelCheckBoxButton);
        passwordFieldExample.add(labelCheckBoxTextPassword);
        passwordFieldExample.setSize(550, 500);
        passwordFieldExample.setLayout(null);
        passwordFieldExample.setVisible(true);
    }
}
