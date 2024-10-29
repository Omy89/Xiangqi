package xiangqi;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Frame extends JFrame{
    
    CardLayout cardlayout;
    JPanel cardpanel;
            
    public Frame(){
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Xiangqi");
        setResizable(false);
        
        //paneles
        cardlayout = new CardLayout();
        cardpanel = new JPanel(cardlayout);
        
        LoginPanel loginPanel = new LoginPanel(cardlayout, cardpanel);
        RegisterPanel registerPanel = new RegisterPanel(cardlayout, cardpanel);
        MainPanel mainPanel = new MainPanel(cardlayout, cardpanel);
        MenuPanel menupanel = new MenuPanel(cardlayout, cardpanel);
        VersusPanel vspanel= new VersusPanel(cardlayout, cardpanel);
        RankingPanel rankingpanel=new RankingPanel(cardlayout, cardpanel);
        AccountPanel accountpanel=new AccountPanel(cardlayout, cardpanel);
        LogsPanel logspanel=new LogsPanel(cardlayout, cardpanel);
        
        
        cardpanel.add(mainPanel, "main");
        cardpanel.add(loginPanel, "login");
        cardpanel.add(registerPanel, "register");
        cardpanel.add(menupanel, "menu");
        cardpanel.add(vspanel, "versus");
        cardpanel.add(rankingpanel, "ranking");
        cardpanel.add(accountpanel,"account");
        cardpanel.add(logspanel,"logs");
        
        add(cardpanel);
        
        cardlayout.show(cardpanel, "main");
        
        
        setVisible(true);
    }
}
