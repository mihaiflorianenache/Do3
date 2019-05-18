package GraphicInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PasswordField {

    int numberPushButton=0;
    int numberPushCheckBox=0;
    char password[];
    String text;
    String buttonText;

    JFrame jf=new JFrame("Password field example");
    JPasswordField value=new JPasswordField();
    JButton button=new JButton("See password");
    JTextField textField=new JTextField();
    JCheckBox checkBoxButton=new JCheckBox();

    MenuBar menuBar=new MenuBar();
    Menu file=new Menu("File");
    MenuItem save=new MenuItem("Save");
    MenuItem open=new MenuItem("Open");
    MenuItem exit=new MenuItem("Exit");

    public void createElements(){
        value.setBounds(20,100,180,30);
        button.setBounds(20,140,180,30);
        textField.setBounds(20,100,180,30);
        checkBoxButton.setBounds(210,138,50,50);
        EventCheckBox eventCheckBox=new EventCheckBox();
        checkBoxButton.addItemListener(eventCheckBox);

        EventButton eventButton=new EventButton();
        button.addActionListener(eventButton);
        jf.add(value);
        jf.add(button);
        jf.add(checkBoxButton);
        jf.setSize(500,500);
        jf.setLayout(null);
        jf.setVisible(true);

        Save ssave=new Save();
        save.addActionListener(ssave);

        file.add(save);
        file.add(open);
        file.add(exit);
        menuBar.add(file);
        jf.setMenuBar(menuBar);
    }

    public static void main(String[] args){
        PasswordField passwordField=new PasswordField();
        passwordField.createElements();
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
                jf.remove(value);
                jf.add(textField);
                buttonText=event.getActionCommand();
                //of course that text is "See Password" but I want to exercise getActionCommand()
                if(buttonText.equals("See password")) {
                    button.setText("Hide Password");
                    jf.setTitle("Text field example");
                }
            }
            else{
                text=textField.getText();
                value.setText(text);
                jf.remove(textField);
                jf.add(value);
                buttonText=event.getActionCommand();
                if(buttonText.equals("Hide Password")){
                    button.setText("See password");
                    jf.setTitle("Password field example");
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

    class Save implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String save = ((MenuItem)event.getSource()).getLabel();//save="save"
            if(save.equals("save")){
                FileDialog fileDialog=new FileDialog(Editor.this,);
            }
        }
    }
}
