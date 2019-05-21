package GraphicInterfaceBaliseControllerEVC;

import javax.swing.*;

public class Balise extends JFrame {

    private JTextArea textAreaEVC=new JTextArea();
    private JTextArea textAreaController=new JTextArea();
    private JButton startCommunicationEVC=new JButton();
    private JButton startCommunicationController=new JButton();

    public static void main(String[] args){
        Balise balise=new Balise();
        balise.createComponents(balise);
    }

    private void createComponents(Balise balise){
        balise.setTitle("Balise");
        textAreaEVC.setBounds(50,50,100,100);
       textAreaController.setBounds(50,180,100,100);

        //balise.add(textAreaEVC);
        balise.add(textAreaController);
        balise.setVisible(true);
        balise.setLayout(null);
        balise.setSize(500,500);
    }
}
