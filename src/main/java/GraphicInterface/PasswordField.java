package GraphicInterface;
/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PasswordField extends JFrame{

    int numberPushButton=0;
    int numberPushCheckBox=0;
    char password[];
    String text;
    String buttonText;

    JPasswordField value=new JPasswordField();
    JButton button=new JButton("See password");
    JTextField textField=new JTextField();
    JCheckBox checkBoxButton=new JCheckBox();
    JLabel labelButton=new JLabel("Deactivate button");

    MenuBar menuBar=new MenuBar();
    Menu file=new Menu("File");
    MenuItem save=new MenuItem("Save");
    MenuItem open=new MenuItem("Open");
    MenuItem exit=new MenuItem("Exit");

    public static void main(String[] args){
        PasswordField passwordField=new PasswordField();
        passwordField.createElements(passwordField);
    }

    private void createElements(PasswordField passwordField){
        passwordField.setTitle("Password field example");
        value.setBounds(20,100,180,30);
        button.setBounds(20,140,180,30);
        textField.setBounds(20,100,180,30);
        checkBoxButton.setBounds(210,138,50,50);
        labelButton.setBounds(260,138,50,30);
        EventCheckBox eventCheckBox=new EventCheckBox();
        checkBoxButton.addItemListener(eventCheckBox);

        EventButton eventButton=new EventButton();
        button.addActionListener(eventButton);
        passwordField.add(value);
        passwordField.add(button);
        passwordField.add(checkBoxButton);
        passwordField.add(labelButton);
        passwordField.setSize(500,500);
        passwordField.setLayout(null);
        passwordField.setVisible(true);

        Save ssave=new Save();
        save.addActionListener(ssave);

        file.add(save);
        file.add(open);
        file.add(exit);
        menuBar.add(file);
        passwordField.setMenuBar(menuBar);
    }

    class EventButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            numberPushButton++;
            if(numberPushButton%2!=0) {
                password = value.getPassword();
                int i;
                String parola = "";
                for (i = 0; i < password.length; i++) {
                    parola = parola.concat(String.valueOf(password[i]));
                }
                textField.setText(parola);
                passwordField.remove(value);
                passwordField.add(textField);
                buttonText=event.getActionCommand();
                //of course that text is "See Password" but I want to exercise getActionCommand()
                if(buttonText.equals("See password")) {
                    button.setText("Hide Password");
                    passwordField.setTitle("Text field example");
                }
            }
            else{
                text=textField.getText();
                value.setText(text);
                passwordField.remove(textField);
                passwordField.add(value);
                buttonText=event.getActionCommand();
                if(buttonText.equals("Hide Password")){
                    button.setText("See password");
                    passwordField.setTitle("Password field example");
                }
            }
        }
    }

    class EventCheckBox implements ItemListener{
        public void itemStateChanged(ItemEvent event){
            numberPushCheckBox++;
            if(numberPushCheckBox%2!=0) {
                button.setEnabled(false);
            }
            else
                button.setEnabled(true);
        }
    }

    private void salvare(String file)  {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File(file)));
            printWriter.println(textField.getText());
            printWriter.close();
        }catch(Exception e)
        {

        }
    }

    class Save implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String save = ((MenuItem)event.getSource()).getLabel();//save="save"
            if(save.equals("save")){
                FileDialog fileDialog=new FileDialog(PasswordField.this,"Save", FileDialog.SAVE);
               // fileDialog.setVisible(true);
                //salvare(fileDialog.getDirectory()+fileDialog.getFile());
            }
        }
    }
}
 */
