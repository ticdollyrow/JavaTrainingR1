package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private final Socket socket;
    private final Server server;
    private final DataInputStream input;
    private final DataOutputStream output;
    private  String nick;

    public ClientHandler(Socket socket, Server server){
        this.socket = socket;
        this.server = server;
        try {
            this.input = new DataInputStream(this.socket.getInputStream());
            this.output = new DataOutputStream(this.socket.getOutputStream());
        }catch (IOException io){
            throw new RuntimeException(io);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    authenticate();
                    readMessages();
                }finally {
                    closeConnection();
                }
            }
        }).start();
    }

    private void closeConnection() {
        try {
            if(input != null) {
                input.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(output != null){
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(socket != null){
            try {
                server.unsubscribe(this);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNick() {
        return nick;
    }


    private void authenticate(){
        while (true){
            try {
                String str = input.readUTF();
                if(str.startsWith("/auth")){
                    final String[] clientInfo = str.split(" ");
                    String login = clientInfo[1];
                    String pass = clientInfo[2];
                    final String nickByLoginAndPassword = server.getAuthService().getNickByLoginAndPassword(login, pass);
                    if(nickByLoginAndPassword != null){
                        if(server.isNickExist(nickByLoginAndPassword)){
                            sendMessage("NickIsAlreadyExist");
                            continue;
                        }
                        nick = nickByLoginAndPassword;
                        sendMessage("/authOk " + nick);
                        server.addConnectedClient(this);
                        break;
                    }else{
                        sendMessage("ErrorData");
                    }

                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void readMessages(){
        while(true){
            try {
                final String str = input.readUTF();
                if("/end".equals(str)){
                    return;
                }
                sendMessage(nick + ": " + str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sendMessage(String message){
        try {
            output.writeUTF(message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
