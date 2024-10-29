package xiangqi;

import java.util.Calendar;

public class User {
    
    private String username;
    private String password;
    private Calendar regdate;
    private int points;
    public Games[] logs;
    
    public User(String name, String pass){
        this.username=name;
        this.password=pass;
        this.regdate=Calendar.getInstance();
        this.points=0;
        logs=new Games[10];
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Calendar getRegdate() {
        return regdate;
    }

    public int getPoints() {
        return points;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPoints() {
        this.points += 3;
    }

    public Games[] getLog() {
        return logs;
    }
    
    public void addlog(Games log){
        for (int i = 0; i < logs.length; i++) {
            if(logs[i]==null){
                logs[i]=log;
                break;
            }
        }
    }
    
}
