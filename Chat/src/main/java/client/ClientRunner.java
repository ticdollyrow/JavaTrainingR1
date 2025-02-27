package client;

import java.util.Scanner;

public class ClientRunner {
    public static void main(String[] args) {
        final Client Client = new Client();
        Client.openConnection();
        String s = "Message";
        Client.sendMessage(s);

        final Scanner scanner = new Scanner(System.in);
        while (! "/end".equals(s)){
            Client.sendMessage(s);
            s = scanner.nextLine();
            System.out.println("Client " + s);
        }

        Client.sendMessage(s);
    }
}
