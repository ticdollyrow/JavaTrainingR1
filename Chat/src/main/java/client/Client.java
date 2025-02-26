package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 8190;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try( Socket socket = new Socket("localhost", PORT);
             final DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             final DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        ) {

            // Поток для чтения сообщений от сервера
            new Thread(() -> {
                try {
                    while (true) {
                        String serverMessage = dataInputStream.readUTF();
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Отправка сообщений на сервер
            new Thread(() -> {
                try {
                    while (true) {
                        final String s = scanner.nextLine();
                        if(s.equals("end")){
                            break;
                        }
                        dataOutputStream.writeUTF(s);
                    }
                }catch (IOException exception){
                    exception.printStackTrace();
                }
            }).start();


        }catch(IOException exception){
            exception.printStackTrace();
        }finally {

        }
    }
}
