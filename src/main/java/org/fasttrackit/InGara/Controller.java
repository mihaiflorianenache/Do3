package org.fasttrackit.InGara;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Controller {

    public static void main(String[] args){
        Controller controller=new Controller();
        controller.serverController();
    }

    private void serverController(){
        EVC evc=new EVC();
        ClientController clientController=new ClientController();
        clientController.start();
        evc.start();
    }

    private void connectClientController(){
        try {
            InetAddress IP = InetAddress.getByName("localhost");
            ServerSocket serverSocketServerController = new ServerSocket(1903);
            Socket socketServerController = serverSocketServerController.accept();
        }catch(Exception exception){
            System.out.println("Server controller can not connect with client controller because of the error "+exception.getMessage());
        }
    }

    private void connectEVC(){
        try {
            InetAddress IP = InetAddress.getByName("localhost");
            ServerSocket serverSocketServerController = new ServerSocket(1902);
            Socket socketServerController = serverSocketServerController.accept();
            receiveRequestFromEVC(socketServerController);
        }catch(Exception exception){
            System.out.println("Server controller can not communicate with EVC because of the error "+exception.getMessage());
        }
    }

    private void receiveRequestFromEVC(Socket socketServerController){
        try {
            ObjectInputStream inEVC = new ObjectInputStream(socketServerController.getInputStream());
            System.out.println("Server controller received: " + inEVC.readObject());
        }catch(Exception exception){
            System.out.println("Server controller can not receive request from EVC because of the error "+exception.getMessage());
        }
    }

    class ClientController extends Thread{
        private Socket socketClientController;
        private InetAddress IP;
        public void run(){
            try {
                IP = InetAddress.getByName("localhost");
                socketClientController = new Socket(IP, 1903);
                sendRequestServerController(socketClientController);
            }catch(Exception exception){
                System.out.println("Client controller can not communicate with Server controller because of the error "+exception.getMessage());
            }
        }

        private void sendRequestServerController(Socket socketClientController){
            try {
                ObjectOutputStream outServerController = new ObjectOutputStream(socketClientController.getOutputStream());
                TrainWantsToGo trainWantsToGo = new TrainWantsToGo("Is a train who want go ?");
                outServerController.writeObject(trainWantsToGo);
                outServerController.flush();
            }catch(Exception exception){
                System.out.println("Client controller can not communicate with server controller because of the error "+exception.getMessage());
            }
        }
    }

    class EVC extends Thread{
        public void run() {
            connectEVC();
        }
    }
}
