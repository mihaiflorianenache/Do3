package GraphicInterface;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class TableExample {
    //la table nu se pune setLayout(null)
    private JTable table;

    private void createComponents(){
        JFrame frame=new JFrame();
        frame.setTitle("Table");

        String data[][]={{"One","Two","Three"},{"Four","Five","Six"},{"Seven","Eight","Nine"}};
        String column[]={"First","Second","Third"};

        table=new JTable(data,column);
        ListSelectionModel select= table.getSelectionModel();
        SelectValue selectValue=new SelectValue();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(selectValue);

        JScrollPane scrollPane=new JScrollPane(table);
        frame.add(scrollPane);

        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        TableExample tableExample=new TableExample();
        tableExample.createComponents();
    }

    class SelectValue implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent event) {
            int callValueChanged=0;
            if (callValueChanged < 1) {
                int rows[] = table.getSelectedRows();
                int columns[] = table.getSelectedColumns();
                int i, j;
                String data = null;
                for (i = 0; i < rows.length; i++) {
                    for (j = 0; j < columns.length; j++) {
                        data = (String) table.getValueAt(rows[i], columns[i]);
                    }
                }
                System.out.println("You have selected: " + data);
                callValueChanged++;
            }
        }
    }
}
