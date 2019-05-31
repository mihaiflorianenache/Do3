package GraphicInterface;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class TableExample2 {
    public static void main(String[] args) throws SQLException {
        JFrame frame=new JFrame();
        NumberService numberService=new NumberService();
        frame.setTitle("Table");

        String head[]={"Numar"};
        String body[][]={};

        /*for(Numar numar:numberService.getNumber()){
            numar.getNumber();
        }*/

        
        JTable table=new JTable(body,head);
        JScrollPane scrollPane=new JScrollPane(table);
        frame.add(scrollPane);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
