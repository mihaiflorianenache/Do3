package GraphicInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordFieldExample extends JFrame {

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
        PasswordFieldExample passwordFieldExample = new PasswordFieldExample();
        passwordFieldExample.createElements(passwordFieldExample);
    }

    private void createElements(final PasswordFieldExample passwordFieldExample) {
        passwordFieldExample.setTitle("Password field example");
        passwordField.setBounds(100, 100, 181, 30);

        button.setBounds(100, 140, 180, 30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                } else {
                    textValue = textField.getText();
                    textField.setText("");
                    passwordFieldExample.remove(textField);
                    passwordFieldExample.add(passwordField);
                    passwordField.setText(textValue);
                    button.setText("See password");
                }
            }
        });

        textField.setBounds(100,100,181,30);
        checkBoxButton.setBounds(290, 155, 17, 17);
        checkBoxTextPassword.setBounds(290,114,17,17);
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
