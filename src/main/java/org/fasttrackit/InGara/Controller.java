package org.fasttrackit.InGara;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//Server Controller
public class Controller {

    public static void main(String[] args) throws InterruptedException {
        Controller controller=new Controller();
        controller.serverController();
    }

    private void serverController() throws InterruptedException {
        //EVC evc=new EVC();
        ClientController clientController=new ClientController();
        //evc.start();
        //evc.join();
        clientController.start();
    }

    private void connectClientController(){
        try {
            InetAddress IP = InetAddress.getByName("localhost");
            ServerSocket serverSocketServerController = new ServerSocket(1903);
            Socket socketServerController = serverSocketServerController.accept();
           // receiveRequestFromClientController(socketServerController);
        }catch(Exception exception){
            System.out.println("Server controller can not connect with client controller because of the error "+exception.getMessage());
        }
    }

    private void receiveRequestFromClientController(Socket socketServerController){
        try {
            ObjectInputStream inServerController = new ObjectInputStream(socketServerController.getInputStream());
            System.out.println("Server controller received from client controller " + inServerController.readObject());
        }catch(Exception exception){
            System.out.println("Server controller can not receive request from client controller because of the error "+exception.getMessage());
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
                connectClientController();
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
