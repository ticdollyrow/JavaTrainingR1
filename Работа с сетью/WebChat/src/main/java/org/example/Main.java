package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final EchoClient echoClient = new EchoClient();
        echoClient.openConnection();
        String s = "Message";
        echoClient.sendMessage(s);

        final Scanner scanner = new Scanner(System.in);
        while (! "/end".equals(s)){
            echoClient.sendMessage(s);
            s = scanner.nextLine();
            System.out.println("Client " + s);
        }

        echoClient.sendMessage(s);
    }
}