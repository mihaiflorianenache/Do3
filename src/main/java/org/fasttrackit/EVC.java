package org.fasttrackit;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class EVC {
    public static void main(String args[]){
        try{
            InetAddress IP= InetAddress.getByName("localhost");
            Socket socket =new Socket(IP,1900);

            EVC evc=new EVC();
            evc.sendCoordinatesToBalise(socket);
            evc.receiveMovementAuthorityFromBalise(socket);
            evc.sendConfirmationReceivingMovementAuthorityToBalise(socket);
        }catch(Exception exception){
            System.out.println("EVC can not communicate with Balise because of the error "+exception.getMessage());
        }
    }

    private void sendCoordinatesToBalise(Socket socket){
        try {
            ObjectOutputStream outBalise = new ObjectOutputStream(socket.getOutputStream());
            Coordinates coordinates = new Coordinates(1, 1);
            System.out.println("EVC is sending coordinates to Balise");
            outBalise.writeObject(coordinates);
            outBalise.flush();
        }catch(Exception exception){
            System.out.println("EVC can not sending data to Balise because of the error "+exception.getMessage());
        }
    }

    private void receiveMovementAuthorityFromBalise(Socket socket){
        try {
            ObjectInputStream inBalise = new ObjectInputStream(socket.getInputStream());
            System.out.println("EVC is receiving from Balise " + inBalise.readObject());
        }catch(Exception exception){
            System.out.println("EVC can not receiving data to Balise because of the error "+exception.getMessage());
        }
    }

    private void sendConfirmationReceivingMovementAuthorityToBalise(Socket socket){
        try {
            ObjectOutputStream outBalise = new ObjectOutputStream(socket.getOutputStream());
            ConfirmationDataToBalise confirmationDataToBalise = new ConfirmationDataToBalise("EVC received movement authority from balise");
            System.out.println("EVC send confirmation to balise regard of receiving movement authority");
            outBalise.writeObject(confirmationDataToBalise);
            outBalise.flush();
        }catch(Exception exception){
            System.out.println("EVC can not send confirmation to balise because of the error "+exception.getMessage());
        }
    }
}

