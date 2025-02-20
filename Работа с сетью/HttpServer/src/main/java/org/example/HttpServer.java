package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) {
        try(final ServerSocket serverSocket = new ServerSocket(8080)){
            while (true){
                final Socket accept = serverSocket.accept();
                final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                final PrintWriter printWriter = new PrintWriter(accept.getOutputStream());

                while (!bufferedReader.ready()){
                    ;
                }
                while (bufferedReader.ready()){
                    System.out.println(bufferedReader.readLine());
                }
                printWriter.println("HTTP/1.1 200 OK");
                printWriter.flush();

            }
        }catch (IOException io){
            io.getStackTrace();
        }
    }
}
