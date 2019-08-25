package finalsnakesandladder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Random;


public class SnakeAndLadder2 extends JFrame implements ActionListener{
   PlayerCollection pc;
    SNLCollection snl = new SNLCollection();
    JButton btnPlay1 ;
    JButton btnPlay2 ;
    JButton btnPlay3 ;
    JButton newGame = new JButton("Restart");

    JLabel lblPlayerNo2 = new JLabel("");
    JLabel lblPlayerNo1 = new JLabel("");
    JLabel lblPlayerNo3 = new JLabel("");

    JLabel lblPlayerPos2 = new JLabel("");
    JLabel lblPlayerPos1 = new JLabel("");
    JLabel lblPlayerPos3 = new JLabel("");
    JLabel show;
    JButton min = new JButton("Min Moves");
    int playerCount1 = 1;
    int playerCount2 = 1;
    int playerCount3 = 1;

    int w=15,h=15;
    int x=0,y=0;

    StringBuffer playerList3 = null;
    StringBuffer playerList2 = null;
    StringBuffer playerList1 = new StringBuffer();

    Random dice = new Random();
    int play = 0;

    public SnakeAndLadder2(PlayerCollection pc)  throws Throwable{
        super("SnakeAndLadder");
        this.pc=pc;
        btnPlay1 = new JButton(pc.getplayer(0).getname());
        btnPlay2 = new JButton(pc.getplayer(1).getname());
        btnPlay3 = new JButton(pc.getplayer(2).getname());
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 780, 580);
        JLabel background=new JLabel(new ImageIcon("bord2.jpg"));
        background.setBounds(0, -10, 550, 570);
        add(background);

        btnPlay1.setBounds(580,250,80,30);
        add(btnPlay1);
        min.setBounds(590, 150, 120, 30);
        add(min);
        min.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show=new JLabel("4");
                show.setBounds(650, 110,60,30);
                add(show);
            }
            });
        btnPlay2.setBounds(580, 300, 80, 30);
        add(btnPlay2);

        btnPlay3.setBounds(580,350,80,30);
        add(btnPlay3);
        
        lblPlayerNo1.setBounds(660, 250, 60, 30);

        lblPlayerNo1.setOpaque(true);
        lblPlayerNo1.setBackground(Color.BLUE);
        lblPlayerNo1.setForeground(Color.GREEN);
        add(lblPlayerNo1);

        lblPlayerNo2.setBounds(660, 300, 60, 30);
        
        lblPlayerNo2.setOpaque(true);
        lblPlayerNo2.setBackground(Color.RED);
        lblPlayerNo2.setForeground(Color.GREEN);
        add(lblPlayerNo2);

        lblPlayerNo3.setBounds(660,350,60,30);
        
        lblPlayerNo3.setOpaque(true);
        lblPlayerNo3.setBackground(Color.BLACK);
        lblPlayerNo3.setForeground(Color.WHITE);
        add(lblPlayerNo3);
        
        newGame.setBounds(590, 400, 120, 30);
        add(newGame);
        coinPosition(2,playerCount2);
        lblPlayerPos2.setBounds(x, y, w, h);
        lblPlayerPos2.setOpaque(true);
        lblPlayerPos2.setBackground(Color.RED);
        background.add(lblPlayerPos2);

        coinPosition(1,playerCount1);
        lblPlayerPos1.setBounds(x, y, w, h);
        lblPlayerPos1.setOpaque(true);
        lblPlayerPos1.setBackground(Color.BLUE);
        background.add(lblPlayerPos1);

        coinPosition(3,playerCount3);
        lblPlayerPos3.setBounds(5, 515, w, h);
        lblPlayerPos3.setOpaque(true);
        lblPlayerPos3.setBackground(Color.BLACK);
        background.add(lblPlayerPos3);
        repaint();

        snl.addSnake(new Snake(25,5));
        snl.addSnake(new Snake(34,1));
        snl.addSnake(new Snake(47,19));
        snl.addSnake(new Snake(65,52));
        snl.addSnake(new Snake(87,57));
        snl.addSnake(new Snake(91,61));
        snl.addSnake(new Snake(99,69));
        snl.addLadder(new Ladder(3,51));
        snl.addLadder(new Ladder(6,27));
        snl.addLadder(new Ladder(20,70));
        snl.addLadder(new Ladder(36,55));
        snl.addLadder(new Ladder(63,95));
        snl.addLadder(new Ladder(68,98));
        newGame.addActionListener(this);
        btnPlay1.addActionListener(this);
        btnPlay2.addActionListener(this);
        btnPlay3.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            play=0;
            playerCount1 = 1;
            playerCount2 = 1;
            playerCount3 = 1;
            coinPosition(1,playerCount2);
            lblPlayerPos2.setBounds(x, y, w, h);
            coinPosition(2,playerCount1);
            lblPlayerPos1.setBounds(x, y, w, h);
            coinPosition(3,playerCount3);
            lblPlayerPos3.setBounds(5, 515, w, h);
            lblPlayerNo1.setText("");
            lblPlayerNo2.setText("");
            lblPlayerNo3.setText("");
            btnPlay1.setVisible(true);
            btnPlay2.setVisible(true);
            btnPlay3.setVisible(true);
            show.setText(" ");
            repaint();
        }  
       if(play==0&& (e.getSource() == btnPlay1)) {
                playerList1 = new StringBuffer();
                    while(play == 0)
                    {
                        play = playDice(1);
                    coinPosition(1,playerCount1);
                    lblPlayerPos1.setBounds(x, y, w, h);
                    repaint();
                    for(int i=0;i<snl.Lsize();i++) {
                        if (playerCount1 == snl.getLadder(i).getInitPos())
                        {
                            playerCount1 = snl.getLadder(i).getFinalPos();
                            break;
                        }
                    }
                    for(int i=0;i<snl.Ssize();i++) {
                        if (playerCount1 == snl.getSnake(i).getInitPos())
                        {
                            playerCount1 = snl.getSnake(i).getFinalPos();
                            break;
                        }
                    }
                    coinPosition(1,playerCount1);
                    lblPlayerPos1.setBounds(x, y, w, h);
                    repaint();
                    if(playerCount1 == 100) {
                        btnPlay1.setVisible(false);
                        btnPlay2.setVisible(false);
                        btnPlay3.setVisible(false);
                        JOptionPane.showMessageDialog(this,  pc.getplayer(0).getname()+" "+ "wins");
                        dispose();
                        Exit ex = new Exit();
                        ex.setVisible(true);
                      
                      
                    }
                    }
       }
              if (play==1 && e.getSource() == btnPlay2) {
                  
            playerList2 = new StringBuffer();
            while(play==1)
            {
                 play = playDice(2);
            coinPosition(2,playerCount2);
            lblPlayerPos2.setBounds(x, y, w, h);
            repaint();
            for(int i=0;i<snl.Lsize();i++) {
                if (playerCount2 == snl.getLadder(i).getInitPos())
                {
                    playerCount2 = snl.getLadder(i).getFinalPos();
                    break;
                }
            }
            for(int i=0;i<snl.Ssize();i++) {
                if (playerCount2 == snl.getSnake(i).getInitPos())
                {
                    playerCount2 = snl.getSnake(i).getFinalPos();
                    break;
                }
            }
            coinPosition(2,playerCount2);
            lblPlayerPos2.setBounds(x, y, w, h);
            repaint();
            if(playerCount2 == 100) {
                btnPlay3.setVisible(false);
                btnPlay2.setVisible(false);
                btnPlay1.setVisible(false);
                JOptionPane.showMessageDialog(this, pc.getplayer(1).getname()+" "+ "wins");
                dispose();
                        Exit ex = new Exit();
                        ex.setVisible(true);
                      
            } 
            }
             }
            if (play==2 && e.getSource() == btnPlay3) {
                  
            playerList3 = new StringBuffer();
            while(play==2)
            {
                 play = playDice(3);
            coinPosition(3,playerCount3);
            lblPlayerPos3.setBounds(x, y, w, h);
            repaint();
            for(int i=0;i<snl.Lsize();i++) {
                if (playerCount3 == snl.getLadder(i).getInitPos())
                {
                    playerCount3 = snl.getLadder(i).getFinalPos();
                    break;
                }
            }
            for(int i=0;i<snl.Ssize();i++) {
                if (playerCount3 == snl.getSnake(i).getInitPos())
                {
                    playerCount3 = snl.getSnake(i).getFinalPos();
                    break;
                }
            }
            coinPosition(3,playerCount3);
            lblPlayerPos3.setBounds(x, y, w, h);
            repaint();
            if(playerCount3 == 100) {
                btnPlay3.setVisible(false);
                btnPlay2.setVisible(false);
                btnPlay1.setVisible(false);
                JOptionPane.showMessageDialog(this, pc.getplayer(2).getname()+" "+ "wins");
                dispose();
                        Exit ex = new Exit();
                        ex.setVisible(true);
                      
            } 
            }
             }
              }

        
    private int playDice(int player) {
        int play= 0;
        
        int diceResult = 0;
        while(diceResult == 0) {
            diceResult = dice.nextInt(7);
        }
        if(player== 1){
            playerList1.append(String.valueOf(diceResult));
            playerList1.append(",");
            lblPlayerNo1.setText(playerList1.toString());
            if(playerCount1+diceResult <= 100) {
                playerCount1 = playerCount1+diceResult;
                play = 1;
                if(diceResult == 6) {
                    play = 0;
                }
            }
        } else if(player ==2) {
            playerList2.append(String.valueOf(diceResult));
            playerList2.append(",");
            lblPlayerNo2.setText(playerList2.toString());
            if(playerCount2+diceResult <= 100) {
                playerCount2 = playerCount2+diceResult;
                play = 2;
                if(diceResult == 6) {
                    play = 1;
                }
            }
        }
        else if(player ==3)
        {
            playerList3.append(String.valueOf(diceResult));
            playerList3.append(",");
            lblPlayerNo3.setText(playerList3.toString());
            if(playerCount3+diceResult <= 100) {
                playerCount3 = playerCount3+diceResult;
                play = 0;
                if(diceResult == 6) {
                    play = 2;
                }
            }
        }
        return play;
    }

    private void coinPosition(int  P1orP2, int count) {

        int xpos = count%10;
        int ypos = count/10;
        if(xpos == 0) {
            xpos = 10;
            ypos = ypos-1;
        }
        if( P1orP2 == 2) {
            x = 5 + (xpos*55) - 55;
        } else if( P1orP2 == 1){
            x = 25 + (xpos*55) - 55;
        }
        else if(P1orP2==3)
        {
            x = 5 + (xpos*55) - 55;
        }
        y = 540 - (ypos*57);
    }
}
