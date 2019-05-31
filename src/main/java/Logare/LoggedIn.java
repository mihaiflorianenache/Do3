package Logare;

import Domain.Users;
import Service.UsersService;

import javax.swing.*;
import java.sql.SQLException;

public class LoggedIn {

    LoggedIn() throws SQLException {
        JFrame frame=new JFrame();
        frame.setTitle("Sign Up");

        //insertUsername(frame);
        insertPassword(frame);
    }


    private void insertUsername(JFrame frame) throws SQLException {
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
        if(username!=null && !username.equals("") && numberSpace!=username.length()){
            insertIntoDatabase(username.trim());
        }

        //pt Cancel
        if(username==null || username.equals("") || numberSpace==username.length())
            System.out.println("You must insert and validate a username");
    }


    private void insertPassword(JFrame frame){
        JPasswordField passwordField=new JPasswordField();
        String options[]=new String[]{"OK","Cancel"};
        JOptionPane.showMessageDialog(frame,"Your password can contains uppercase letters, lowercase letters and digits");
        int option=JOptionPane.showOptionDialog(frame,passwordField,"Password", JOptionPane.NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[1]);

        //OK
        if(option==0){
            System.out.println(passwordField.getPassword());
        }

        //Cancel
        if(option==1){
            System.out.println("gresit");
        }
    }

    private void insertIntoDatabase(String username) throws SQLException {
        Users users=new Users();
        UsersService usersService=new UsersService();
        usersService.insertUser(username);
    }

    public static void main(String args[]) throws SQLException {
        new LoggedIn();
    }
}
