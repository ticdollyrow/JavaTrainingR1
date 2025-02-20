package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        Socket socket = null;
        try(final ServerSocket serverSocket = new ServerSocket(8189)){
            // ожидаем подключение
            socket = serverSocket.accept();
            System.out.println("Client");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while(true){
                    String s = dataInputStream.readUTF();
                    if(s.equals("/end")){
                        System.out.println("Close Connection");
                        dataOutputStream.writeUTF( s );
                        break;
                    }
                    dataOutputStream.writeUTF("echo " + s );
            }

        } catch ( IOException e){
            e.printStackTrace();
        }
    }
}
