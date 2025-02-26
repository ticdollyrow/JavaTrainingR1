package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    private static final int PORT = 8190;
    private final AuthService authService;
    private final List<ClientHandler> clientHandlers;

    public Server(){
        this.clientHandlers = new ArrayList<>();
        this.authService = new AuthService() {
            @Override
            public String getNickByLoginAndPassword(String login, String password) {
                final UserData userData1 = userData.get(login);
                if( userData1 != null && userData1.password.equals(password)){
                    return userData1.nick;
                } else{
                    return null;
                }
            }

            private Map<String,UserData> userData;
            {
                userData = new HashMap<>();
                for(int i = 0; i < 3; i++){
                   userData.put("login"+i, new UserData("login"+i, "pass"+1, "nick"+i));
                }
            }

            private class UserData{
                String login;
                String password;
                String nick;

                UserData(String login, String password, String nick){
                    this.login = login;
                    this.password = password;
                    this.nick = nick;
                }
            }
        };
    }

    public static void main(String[] args) {

        Socket clientSocket = null;
        try(final ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server ......");

            clientSocket = serverSocket.accept();
            final DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            final DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            while (true) {

                final String s = dataInputStream.readUTF();
                System.out.println(s);

                dataOutputStream.writeUTF("Message - " + s);
            }

        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
