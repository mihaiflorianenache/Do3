package GraphicInterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckboxTest {

    private Label label1, label2;
    private Checkbox one,two,three;
    private JFrame frame=new JFrame();

    private void initializare() {
        label1 = new Label("Componente :", Label.CENTER);
        label1.setBackground(Color.orange);
        label2 = new Label("");
        label2.setBackground(Color.lightGray);

        one = new Checkbox("One");
        two = new Checkbox("Two");
        three = new Checkbox("Three");

        frame.add(label1);
        frame.add(label2);
        frame.add(one);
        frame.add(two);
        frame.add(three);
        frame.setSize(200, 200);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        CheckboxTest checkboxTest=new CheckboxTest();
        checkboxTest.initializare();
    }
}
