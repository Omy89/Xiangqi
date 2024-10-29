package xiangqi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Users {

    static User LoggedUser = null;
    static User[] UserList = new User[17];
    static int counter = 0;

    //constructor
    public Users() {
    }

    //funciones
    public boolean adduser(String username, String password) {
        if (searchuser(username) == null) {
            for (int i = 0; i < UserList.length; i++) {
                if (UserList[i] == null) {
                    UserList[i] = new User(username, password);
                    LoggedUser = UserList[i];
                    counter++;
                    return true;
                }
            }
        }
        return false;
    }

    public static int getCounter() {
        return counter;
    }

    public User searchuser(String username) {
        for (User u : UserList) {
            if (u != null && u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public boolean login(String nombreusuario, String contra) {
        User u = searchuser(nombreusuario);
        if (u != null && u.getUsername().equals(nombreusuario) && u.getPassword().equals(contra)) {
            LoggedUser = u;
            return true;
        }
        return false;
    }

    public boolean inicioSesion(String username, String password) {
        User u = searchuser(username);
        if (u != null) {
            if (u.getPassword().equals(password)) {
                LoggedUser = u;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean changepass(String pass, String newpass) {
        if (LoggedUser.getPassword().equals(pass)) {
            LoggedUser.setPassword(newpass);
            return true;
        }
        return false;
    }

    public void logout() {
        LoggedUser = null;
    }

    public void refil(User[] user) {
        int contador = 0;
        for (int i = 0; i < UserList.length; i++) {
            if (UserList[i] != null) {
                if (!UserList[i].equals(LoggedUser)) {
                    user[contador] = UserList[i];
                }
            }
        }
    }

    public void pointgiver(User user) {
        User point = searchuser(user.getUsername());
        point.setPoints();
    }

    public User getLoggedUser() {
        return LoggedUser;
    }

    public void ranking(User[] user) {
    for (int i = 0; i < UserList.length - 1; i++) {
        for (int j = 0; j < UserList.length - 1 - i; j++) {
            if (UserList[j] != null && UserList[j + 1] != null) {
                if (UserList[j].getPoints() < UserList[j + 1].getPoints()) {
                    // Intercambiar usuarios si el siguiente tiene más puntos
                    User temp = UserList[j];
                    UserList[j] = UserList[j + 1];
                    UserList[j + 1] = temp;
                }
            }
        }
    }
    for (int i = 0; i < UserList.length; i++) {
        user[i] = UserList[i];
    }
}
}
