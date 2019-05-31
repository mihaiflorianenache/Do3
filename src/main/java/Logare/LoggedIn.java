package Logare;

import Domain.Users;
import Service.UsersService;

import javax.swing.*;
import java.sql.SQLException;

public class LoggedIn {

    /*Sign Up*/

    private Users users=new Users();
    private UsersService usersService=new UsersService();

    private void createCredentials(JFrame frame) throws SQLException {
        frame.setTitle("Sign Up");
        boolean againUsername=false;
        boolean againPassword=false;

        insertUsername(frame,againUsername);
        insertPassword(frame,againPassword);
        insertCredentials(frame);
    }


    private void insertUsername(JFrame frame,boolean againUsername) throws SQLException {
        JOptionPane.showMessageDialog(frame,"Your username can contains uppercase letters, lowercase letters and digits");
        checkUsername(frame,againUsername);
        if(againUsername==true){
            insertCredentials(frame);
        }
    }

    private void checkUsername(JFrame frame,boolean againUsername) throws SQLException {
        String username=JOptionPane.showInputDialog(frame,"Enter your username");
        int i;
        int numberSpace=0;
        if(username!=null) {
            for (i = 0; i < username.length(); i++) {
                if (username.charAt(i) == ' ' || username.charAt(i) == '\t') {
                    numberSpace++;
                }
            }
        }

        //pt OK
        if(username!=null && !username.equals("") && numberSpace!=username.length() && !username.contains(" ")){
            users.setUsername(username.trim());
        }

        //pt Cancel
        if(username==null || username.equals("") || numberSpace==username.length() || username.contains(" ")) {
            JOptionPane.showMessageDialog(frame, "You must insert and validate a username");
            insertUsername(frame,againUsername);
        }
    }

    private void insertPassword(JFrame frame,boolean againPassword) throws SQLException {
        JPasswordField passwordField=new JPasswordField();
        String options[]=new String[]{"OK","Cancel"};
        JOptionPane.showMessageDialog(frame,"Your password can contains uppercase letters, lowercase letters and digits");
        int option=JOptionPane.showOptionDialog(frame,passwordField,"Password", JOptionPane.NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[1]);
        boolean choice=false;

        againPassword(option,choice,passwordField,frame,againPassword,options);

        if(againPassword==true){
            insertCredentials(frame);
        }
    }

    private void againPassword(int option,boolean choice,JPasswordField passwordField,JFrame frame,boolean againPassword,String options[]) throws SQLException {
        //OK
        while(option==0){
            choice=false;
            char password[]=passwordField.getPassword();
            int i;
            for(i=0;i<password.length;i++) {
                if((password[i]< (int) 'a' || password[i]> (int) 'z')&&(password[i]< (int) 'A' || password[i]> (int) 'Z')&&(password[i]< (int) '0' || password[i]> (int) '9')) {
                    choice=true;
                    JOptionPane.showMessageDialog(frame, "Your password can contains only uppercase letters, lowercase letters and digits", "Alert", JOptionPane.WARNING_MESSAGE);
                    passwordField.setText("");
                    option=JOptionPane.showOptionDialog(frame,passwordField,"Password", JOptionPane.NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[1]);
                    break;
                }
            }
            if(String.valueOf(password).equals("")){
                choice=true;
                JOptionPane.showMessageDialog(frame,"Your password can contains only uppercase letters, lowercase letters and digits","Alert", JOptionPane.WARNING_MESSAGE);
                option=JOptionPane.showOptionDialog(frame,passwordField,"Password", JOptionPane.NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[1]);
            }
            if(choice==false) {
                JOptionPane.showMessageDialog(frame,"Your password contains valid characters");
                users.setPassword(String.valueOf(password));
                break;
            }
        }

        //Cancel
        if(option==1){
            JOptionPane.showMessageDialog(frame, "You must insert and validate a password", "Alert", JOptionPane.WARNING_MESSAGE);
            insertPassword(frame,againPassword);
        }
    }

    private void insertCredentials(JFrame frame) throws SQLException {
        for(Users users:usersService.getUsers()){
            if(this.users.getUsername().equals(users.getUsername())){
                JOptionPane.showMessageDialog(frame, "This user exists. Create other user.", "Error", JOptionPane.ERROR_MESSAGE);
                insertUsername(frame,true);
            }

            if(this.users.getPassword().equals(users.getPassword())){
                JOptionPane.showMessageDialog(frame, "This password exists. Create other password.", "Error", JOptionPane.ERROR_MESSAGE);
                insertPassword(frame,true);
            }
        }
        System.out.println("gata");
        usersService.insertUser(users);
    }

    private int doYouHaveAccount(){
        JFrame frame=new JFrame();
        String options[]=new String[]{"Yes","No"};
        JLabel label=new JLabel();
        label.setText("Do you have a account ?");
        int option=JOptionPane.showOptionDialog(frame,label,"", JOptionPane.NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[1]);
        return option;
    }

    public static void main(String args[]) throws SQLException {
        LoggedIn loggedIn=new LoggedIn();
        JFrame frame=new JFrame();
        int haveAccount=loggedIn.doYouHaveAccount();
        if(haveAccount==1) {
            loggedIn.createCredentials(frame);
        }
        else{
            loggedIn.loggedIn(frame);
        }
    }

    /*Logged In*/

    private void loggedIn(JFrame frame){
        insertPersonalUsername(frame);
        insertPersonalPassword(frame);
    }

    private void insertPersonalUsername(JFrame frame){
        String username=JOptionPane.showInputDialog(frame,"Enter your username");
    }

    private void insertPersonalPassword(JFrame frame){

    }
}
