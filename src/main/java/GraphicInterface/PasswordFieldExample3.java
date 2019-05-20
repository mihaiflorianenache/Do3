package GraphicInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;

public class PasswordFieldExample3 extends JFrame {

    //cu meniu

    private char passwordValue[];
    private String textValue="";
    private int pushButton=0;
    private String saveHardDisk;

    /***********************************************************************************************************************/

    //elementele legate de meniu

    private MenuBar menuBar=new MenuBar();
    private Menu menu=new Menu();
    private MenuItem save=new MenuItem();
    private MenuItem open=new MenuItem();

    /***********************************************************************************************************************/

    //elementele fizice din pagina

    private JPasswordField passwordField = new JPasswordField();
    private JButton button = new JButton("See password");
    private JTextField textField = new JTextField();
    private JCheckBox checkBoxButton = new JCheckBox();
    private JCheckBox checkBoxTextPassword=new JCheckBox();
    private JLabel labelCheckBoxButton=new JLabel();
    private JLabel labelCheckBoxTextPassword=new JLabel();

    public static void main(String args[]) {
        PasswordFieldExample3 passwordFieldExample = new PasswordFieldExample3();
        passwordFieldExample.createElements(passwordFieldExample);
    }

    private void createElements(final PasswordFieldExample3 passwordFieldExample) {

        /****************************************************************************************************************/

        //elementele fizice
        //si functionalitatea acestora din interfata

        passwordFieldExample.setTitle("Password field example3");
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
                    passwordFieldExample.setTitle("Text field example3");
                    labelCheckBoxButton.setText("Deactivate text field");
                    labelCheckBoxTextPassword.setText("Deactivate "+"'"+"hide password"+"'"+" button");
                } else {
                    textValue = textField.getText();
                    textField.setText("");
                    passwordFieldExample.remove(textField);
                    passwordFieldExample.add(passwordField);
                    passwordField.setText(textValue);
                    button.setText("See password");
                    passwordFieldExample.setTitle("Password field example3");
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

        /****************************************************************************************************************/

        //elementele legate de meniu

        menu.setLabel("File");
        save.setLabel("Save");

        passwordFieldExample.setMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(save);
        menu.add(open);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){

                //se deschide fereastra cu ajutorul careia putem selecta locatia de pe hard disk
                //in care sa salvam date

                FileDialog fileDialog=new FileDialog(PasswordFieldExample3.this,"Save password",FileDialog.SAVE);
                fileDialog.setVisible(true);
                System.out.println("fileDialog.getDirectory()= "+fileDialog.getDirectory());
                System.out.println("fileDialog.getFile()= "+fileDialog.getFile());

                //metoda "save" se apeleaza
                //dupa ce apas pe butonul save din FileDialog
                save(fileDialog.getDirectory()+fileDialog.getFile());
            }
        });

        open.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                FileDialog fileDialog =new FileDialog(PasswordFieldExample3.this,"Open file",FileDialog.LOAD);
                fileDialog.setVisible(true);
                open(fileDialog.getDirectory()+fileDialog.getFile());
            }
        });
    }

    private void save(String directoryNameFileForSave){
        try{
            PrintWriter printWriter=new PrintWriter(new FileWriter(new File(directoryNameFileForSave)));
            if(button.getText().equals("See password")) {
                int i;
                //obligatoriu saveHardDisk se initializeaza cu null la fiecare apel al functiei save
                saveHardDisk="";
                for(i=0;i<passwordField.getPassword().length;i++) {
                    saveHardDisk=saveHardDisk.concat(String.valueOf(passwordField.getPassword()[i]));
                }
                printWriter.println(saveHardDisk);
            }
            else{
                saveHardDisk=textField.getText();
                printWriter.println(saveHardDisk);
            }
            printWriter.close();
        }catch(IOException exception)
        {
            System.out.println("Password can not be save because of the error "+exception.getMessage());
        }
    }

    private void open(String directoryNameFileForOpen){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(directoryNameFileForOpen)));

        }catch(FileNotFoundException exception){
            System.out.println("File can not be load because of the error "+exception.getMessage());
        }
    }
}
