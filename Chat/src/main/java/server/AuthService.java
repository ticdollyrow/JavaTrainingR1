package server;

import java.lang.invoke.StringConcatFactory;

public interface AuthService {
    String getNickByLoginAndPassword(String login, String password);
}
