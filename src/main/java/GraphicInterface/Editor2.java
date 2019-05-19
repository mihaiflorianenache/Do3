package GraphicInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Editor2 extends JFrame{
    MenuBar menuBar;
    Menu menuF;
    Menu menuT;
    MenuItem save;
    JTextField textField;

    private void createComponents(Editor2 editor2){

        textField=new JTextField();
        textField.setBounds(50,100,100,130);

        menuBar=new MenuBar();
        menuF=new Menu("File");
        save=new MenuItem("Save");
        save.addActionListener(new A());

        menuF.add(save);
        menuBar.add(menuF);
        editor2.setMenuBar(menuBar);
        editor2.add(textField);
        editor2.setVisible(true);
        editor2.setSize(500,500);
        editor2.setLayout(null);
    }

    private void save(String path){
        try{
            PrintWriter printWriter=new PrintWriter(new FileWriter(new File(path)));
            printWriter.println();
            printWriter.close();
        }catch(Exception exception){

        }
    }

    class A implements ActionListener{
        public void actionPerformed(ActionEvent event){
            FileDialog fileDialog=new FileDialog(Editor2.this,"save",FileDialog.SAVE);
            fileDialog.setVisible(true);
            save(fileDialog.getDirectory()+fileDialog.getFile());
        }
    }

    public static void main(String[] args){
        Editor2 editor2=new Editor2();
        editor2.createComponents(editor2);
    }
}
