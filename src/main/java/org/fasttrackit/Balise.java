package org.fasttrackit;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Balise {

    private ServerSocket serverSocket;
    private Socket socket;

    public static void main(String[] args){
        Balise balise=new Balise();
        balise.startCommunication();
    }

    private void startCommunication(){
        try {
            CallConnectionToEVC callConnectionToEVC = new CallConnectionToEVC();
            CallConnectionToController callConnectionToController = new CallConnectionToController();

            callConnectionToEVC.start();
            callConnectionToEVC.join();
            callConnectionToController.start();
        }catch(InterruptedException exception){
            System.out.println("Balise can not wait to finish communicate with EVC because of the error "+exception.getMessage());
        }
    }

    class CallConnectionToEVC extends Thread{
        public void run(){
            connectionToEVC();
        }
    }

    class CallConnectionToController extends Thread{
        public void run(){
            connectionToController();
        }
    }

    /************************************************************************************************************************/

    //communication with EVC

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

    private void phisicalConnectionEVC() {
        receiveCoordinatesFromEVC();
        sendMovementAuthorityToEVC();
        receiveConfirmationReceivingMovementAuthorityFromEVC();
    }

    private void connectionToEVC(){
        try {//balise is linking at EVC
            serverSocket = new ServerSocket(1900);
            socket = serverSocket.accept();
            phisicalConnectionEVC();
        }catch(Exception exception){
            System.out.println("Balise can not communicate with EVC because of the error "+exception.getMessage());
        }
    }

    /*****************************************************************************************************************************/

    //communication with controller

    private void receiveDataFromController(){
        try{
            ObjectInputStream inController=new ObjectInputStream(socket.getInputStream());
            System.out.println("Balise received from controller "+inController.readObject());
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

    private void phisicalConnectionController(){
        receiveDataFromController();
        sendDataToController();
    }

    private void connectionToController(){
        try {
            serverSocket = new ServerSocket(1901);
            socket = serverSocket.accept();
            phisicalConnectionController();
        }catch(Exception exception){
            System.out.println("Balise can not communicate with controller because of the error "+exception.getMessage());
        }
    }
}
