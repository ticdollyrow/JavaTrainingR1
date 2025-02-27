package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    private static final int PORT = 8190;

    public AuthService getAuthService() {
        return authService;
    }

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
                System.out.println();
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

        try(final ServerSocket serverSocket = new ServerSocket(PORT)){
            while (true){
                final Socket clientSocket = serverSocket.accept();
                final ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                
            }
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
    }

    public boolean isNickExist(String nick){
        for(ClientHandler client: clientHandlers){
            if(client.getNick().equals(nick)){
                return true;
            }
        }
        return false;
    }

    public void addConnectedClient(ClientHandler client){
        clientHandlers.add(client);
    }

    public void unsubscribe(ClientHandler client){
        clientHandlers.remove(client);
    }

}
