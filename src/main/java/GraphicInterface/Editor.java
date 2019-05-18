package GraphicInterface;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;


public class Editor extends JFrame
{
    MenuBar mb;
    Menu f;
    Menu t;
    MenuItem s,o,e;
    JTextArea ta;

    Editor()
    {
        mb = new MenuBar();
        f = new Menu("File");

        s = new MenuItem("Save");
        o = new MenuItem("Open");
        e = new MenuItem("Exit");

        s.addActionListener(new A());
        o.addActionListener(new A());
        e.addActionListener(new A());

        mb.add(f);
        f.add(s);
        f.add(o);
        f.add(e);

        setMenuBar(mb);

        ta = new JTextArea();
        add(ta);

        setSize(500,400);
        setVisible(true);
    }

    void save(String f)
    {
        try
        {
            PrintWriter pw = new PrintWriter(
                    new FileWriter(new File(f)));
            pw.println(ta.getText());
            pw.close();
        }catch(Exception e)
        {

        }

    }

    void open(String f)
    {
        try
        {
            ta.setText("");
            BufferedReader bf =
                    new BufferedReader(
                            new FileReader(new File(f)));
            String l = "";
            l = bf.readLine();
            while (l!=null)
            {
                ta.append(l+"\n");
                l = bf.readLine();
            }
        }catch(Exception e){}
    }

    class A implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String t = ((MenuItem)e.getSource()).getLabel();
            if(t.equals("Save")){
                FileDialog d = new FileDialog(Editor.this,"Incarca f",FileDialog.SAVE);
                d.setVisible(true);
                save(d.getDirectory()+d.getFile());
            }

            if (t.equals("Open"))
            {
                FileDialog d = new FileDialog(Editor.this,"Incarca f",FileDialog.LOAD);
                d.setVisible(true);
                open(d.getDirectory()+d.getFile());
            }

        }
    }

    public static void main(String args[])
    {
        new Editor();
    }
}
