
package xiangqi;

import java.util.Calendar;

public class Games {
    
    User player;
    User opponent;
    boolean won;
    Calendar date;
    
    public Games(User player, User opp, boolean status){
       this.player=player;
       opponent=opp;
       boolean won=status; 
       date=Calendar.getInstance();
    }

    public User getPlayer() {
        return player;
    }

    public User getOpponent() {
        return opponent;
    }

    public boolean isWon() {
        return won;
    }

    public Calendar getDate() {
        return date;
    }
}
