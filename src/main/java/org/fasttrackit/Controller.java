package org.fasttrackit;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Controller {
    public static void main(String args[]){
        try {
            InetAddress IP = InetAddress.getByName("localhost");
            Socket socket= new Socket(IP, 1900);

            Controller controller = new Controller();
            controller.sendDataToBalise(socket);
            controller.receiveDataFromBalise(socket);
        }catch(Exception exception){
            System.out.println("Controller can not communicate with balise because of the error "+exception.getMessage());
        }
    }

    private void sendDataToBalise(Socket socket){
        try {
            ObjectOutputStream outBalise = new ObjectOutputStream(socket.getOutputStream());
            StateLine stateLine = new StateLine("Who is state line ?");
            System.out.println("Controller asks balise regard of state line");
            outBalise.writeObject(stateLine);
            outBalise.flush();
        }catch(Exception exception){
            System.out.println("Controller can not send data to balise becaise of the error "+exception.getMessage());
        }
    }

    private void receiveDataFromBalise(Socket socket){
        try {
            ObjectInputStream inBalise = new ObjectInputStream(socket.getInputStream());
            System.out.println("Controller received from balise "+inBalise.readObject());
        }catch(Exception exception){
            System.out.println("Controller can not receive data from balise because of the error "+exception.getMessage());
        }
    }
}
