package GraphicInterface;

import javax.swing.JOptionPane;
public class AccountTypeDemo {
    public enum AccountType{Administrator,Student,Staff,Guest};
    public static void main(String args[]){
        //Daca selectezi de 4 ori aceeasi optiune ai iesit din functie (ai pierdut)
        AccountType[] choices={AccountType.Administrator,AccountType.Student,AccountType.Staff,AccountType.Guest};
        AccountType select=(AccountType)JOptionPane.showInputDialog(null,"Select your account type",
                "Account type", JOptionPane.INFORMATION_MESSAGE,null,choices,choices[0]);

        int nrAdministrator=0;
        int nrStudent=0;
        int nrStaff=0;
        int nrGuest=0;

        while(select!=null) {
            switch (select) {
                case Administrator:
                    JOptionPane.showMessageDialog(null, "Welcome Administrator");
                    nrAdministrator++;
                    if(nrAdministrator<4)
                        break;
                    else
                        return;
                case Student:
                    JOptionPane.showMessageDialog(null, "Welcome Student");
                    nrStudent++;
                    if(nrStudent<4)
                        break;
                    else
                        return;
                case Staff:
                    JOptionPane.showMessageDialog(null, "Welcome Staff");
                    nrStaff++;
                    if(nrStaff<4)
                        break;
                    else
                        return;
                case Guest:
                    JOptionPane.showMessageDialog(null, "Welcome Guest");
                    nrGuest++;
                    if(nrGuest<4)
                        break;
                    else
                        return;
            }
            select=(AccountType)JOptionPane.showInputDialog(null,"Select your account type","Account type",
                    JOptionPane.INFORMATION_MESSAGE,null,choices,choices[3]);
        }

        //JOptionPane.showMessageDialog(null,"good bye");
    }
}
