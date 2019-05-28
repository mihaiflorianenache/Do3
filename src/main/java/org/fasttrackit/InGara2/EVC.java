package org.fasttrackit.InGara2;

import org.fasttrackit.InGara.TrainGO;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class EVC {

    public static void main(String[] args){
        org.fasttrackit.InGara.EVC evc=new org.fasttrackit.InGara.EVC();
        evc.connectServerController();
    }

    private void connectServerController(){
        try {
            InetAddress IP = InetAddress.getByName("localhost");
            Socket socketEVC = new Socket(IP,1902);
            sendRequestToServerController(socketEVC);
        }catch(Exception exception){
            System.out.println("EVC can not communicate with Server Controller because of the error "+exception.getMessage());
        }
    }

    private void sendRequestToServerController(Socket socketEVC){
        try {
            ObjectOutputStream outServerController = new ObjectOutputStream(socketEVC.getOutputStream());
            TrainGO trainGO = new TrainGO("IC", 531);
            System.out.println("EVC send request to Server Controller regard of train's departure");
            outServerController.writeObject(trainGO);
            outServerController.flush();
        }catch(Exception exception){
            System.out.println("EVC can not send request to Server Controller because of the error "+exception.getMessage());
        }
    }
}
