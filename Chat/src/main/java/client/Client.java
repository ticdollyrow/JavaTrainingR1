package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 8190;

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public void openConnection(){

        try{
            socket = new Socket("localhost", PORT);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> listenServer())
                    .start();

        }catch (IOException e){
            e.getStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            dataOutputStream.writeUTF(message);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void closeConnection(){
        if(dataInputStream !=null){
            try {
                dataInputStream.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }

        if(dataOutputStream != null){
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }

        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void listenServer(){
        try {
            while (true) {
                String strFromServer = dataInputStream.readUTF();
                System.out.println("Server " + strFromServer );
                if (strFromServer.equalsIgnoreCase("/end")) {
                    System.out.println("End OpenConnection");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
    }
}
