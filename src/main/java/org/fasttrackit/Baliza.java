package org.fasttrackit;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Baliza {

    private ServerSocket serverSocket;
    private Socket socket;

    private void init(){
        try {
            serverSocket = new ServerSocket(1900);
            while (true) {
                socket = serverSocket.accept();
                communication();
            }
        }catch(Exception exception){
            System.out.println("Balise can not communicate with EVC or client controller because of the error "+exception.getMessage());
        }
    }

    private void communication(){
        try {
            CommunicationEVC communicationEVC=new CommunicationEVC();
            CommunicationController communicationController=new CommunicationController();

            communicationEVC.start();
            communicationEVC.join();
            communicationController.start();
        }catch(InterruptedException exception){
            System.out.println("Balise can not wait to finish communicate with EVC because of the error "+exception.getMessage());
        }
    }

    private void receiveCoordinatesFromEVC(){
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Balise received " + in.readObject());
        }catch(Exception exception){
            System.out.println("Balise can not receive coordinates from EVC because of the error "+exception.getMessage());
        }
    }

    private void sendMovementAuthorityToEVC(){
        try {
            MovementAuthority movementAuthority = new MovementAuthority(100, 20, 60);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Balise is sending movement authority to EVC");
            out.writeObject(movementAuthority);
            out.flush();
        }catch(Exception exception){
            System.out.println("Balise can not sending movement authority to EVC because of the error "+exception.getMessage());
        }
    }

    private void receiveConfirmationReceivingMovementAuthorityFromEVC(){
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Balise received " + in.readObject());
        }catch(Exception exception){
            System.out.println("Balise can not receive confirmation regard of receiving movement authority from EVC because of the error "+exception.getMessage());
        }
    }

    class CommunicationEVC extends Thread{
        public void run(){
            try {
                receiveCoordinatesFromEVC();
                sendMovementAuthorityToEVC();
                receiveConfirmationReceivingMovementAuthorityFromEVC();
            }catch(Exception exception){
                System.out.println("Balise can not receive data because of the error "+exception.getMessage());
            }
        }
    }

    /***************************************************************************************************************************/

    private void receiveDataFromController(){
        try{
            ObjectInputStream inController=new ObjectInputStream(socket.getInputStream());
            System.out.println("Balise received from controller "+inController);
        }catch(Exception exception){
            System.out.println("Balise can not receive data from controller because of the error "+exception.getMessage());
        }
    }

    private void sendDataToController(){
        try {
            ObjectOutputStream outController = new ObjectOutputStream(socket.getOutputStream());
            StateLine stateLine=new StateLine("The railway is occupied");
            System.out.println("Balise send data to controller");
            outController.writeObject(stateLine);
            outController.flush();
        }catch(Exception exception){
            System.out.println("Balise can not send data to controller because of the error "+exception.getMessage());
        }
    }

    class CommunicationController extends Thread{
        public void run(){
            receiveDataFromController();
            sendDataToController();
        }
    }

    public static void main(String[] args){
        Baliza balise=new Baliza();
        balise.init();
    }
}