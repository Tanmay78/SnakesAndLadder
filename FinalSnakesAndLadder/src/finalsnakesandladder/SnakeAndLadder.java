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


public class SnakeAndLadder extends JFrame implements ActionListener{
   PlayerCollection pc;
    
    SNLCollection snl = new SNLCollection();
    JLabel lblPlayer2 = new JLabel("Computer");
    JLabel lblPlayer1;
    JLabel show;
    JButton btnPlay = new JButton("Play");
    JButton min = new JButton("Min Moves");
    JButton newGame = new JButton("New Game");

    JLabel lblPlayerNo2 = new JLabel("");
    JLabel lblPlayerNo1 = new JLabel("");

    JLabel lblPlayerPos2 = new JLabel("");
    JLabel lblPlayerPos1 = new JLabel("");

    /*HashMap<Integer,Integer> ladder = new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> snake = new HashMap<Integer,Integer>();
*/
    int playerCount1 = 1;
    int playerCount2 = 1;

    int w=15,h=15;
    int x=0,y=0;

    StringBuffer playerList2 = null;
    StringBuffer playerList1 = new StringBuffer();

    Random dies = new Random();

    public SnakeAndLadder(PlayerCollection pc)  throws Throwable{
        super("SnakeAndLadder");
        this.pc=pc;
        lblPlayer1 = new JLabel(pc.getplayer(0).getname());
        setLayout(null);
        
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setBounds(0, 0, 780, 580);
        JLabel background=new JLabel(new ImageIcon("bord2.jpg"));
        background.setBounds(0, -10, 550, 570);
        add(background);
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
        btnPlay.setBounds(620, 200, 60, 30);
        add(btnPlay);

        lblPlayer1.setBounds(580,250,60,30);
        add(lblPlayer1);

        lblPlayer2.setBounds(580, 300, 60, 30);
        add(lblPlayer2);


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

        newGame.setBounds(590, 350, 120, 30);
        add(newGame);
        coinPosition(1,playerCount2);
        lblPlayerPos2.setBounds(x, y, w, h);
        lblPlayerPos2.setOpaque(true);
        lblPlayerPos2.setBackground(Color.RED);
        background.add(lblPlayerPos2);

        coinPosition(2,playerCount1);
        lblPlayerPos1.setBounds(x, y, w, h);
        lblPlayerPos1.setOpaque(true);
        lblPlayerPos1.setBackground(Color.BLUE);
        background.add(lblPlayerPos1);

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
        btnPlay.addActionListener(this);


    }
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            playerCount1 = 1;
            playerCount2 = 1;
            coinPosition(1,playerCount2);
            lblPlayerPos2.setBounds(x, y, w, h);
            coinPosition(2,playerCount1);
            lblPlayerPos1.setBounds(x, y, w, h);
            lblPlayerNo1.setText("");
            lblPlayerNo2.setText("");
            btnPlay.setVisible(true);
            show.setText(" ");
            repaint();
        } else if (e.getSource() == btnPlay) {
            playerList2 = new StringBuffer();

            int playAgain = playDies(2);
            coinPosition(2,playerCount1);
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
            coinPosition(2,playerCount1);
            lblPlayerPos1.setBounds(x, y, w, h);
            repaint();
            if(playerCount1 == 100) {
                btnPlay.setVisible(false);
                JOptionPane.showMessageDialog(this,pc.getplayer(0).getname()+" wins");
                dispose();
                        Exit ex = new Exit();
                        ex.setVisible(true);
                      
            } else if(playAgain == 0) {
                playerList1 = new StringBuffer();
                do {
                    playAgain = playDies(1);
                    coinPosition(1,playerCount2);
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
                    coinPosition(1,playerCount2);
                    lblPlayerPos2.setBounds(x, y, w, h);
                    repaint();
                    if(playerCount2 == 100) {
                        btnPlay.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Computer wins");
                        dispose();
                        Exit ex = new Exit();
                        ex.setVisible(true);
                      
                        break;
                    }

                } while(playAgain == 1);
            }

        }
    }

    private int playDies(int player) {
        int playAgain = 0;
        int diesResult = 0;
        while(diesResult == 0) {
            diesResult = dies.nextInt(7);
        }
        if(player == 2){
            playerList1.append(String.valueOf(diesResult));
            playerList1.append(",");
            lblPlayerNo1.setText(playerList1.toString());
            if(playerCount1+diesResult <= 100) {
                playerCount1 = playerCount1+diesResult;
                if(diesResult == 1 || diesResult == 5 || diesResult == 6) {
                    playAgain = 1;
                }
            }
        } else {
            playerList2.append(String.valueOf(diesResult));
            playerList2.append(",");
            lblPlayerNo2.setText(playerList2.toString());
            if(playerCount2+diesResult <= 100) {
                playerCount2 = playerCount2+diesResult;
                if(diesResult == 1 || diesResult == 5 || diesResult == 6) {
                    playAgain = 1;
                }
            }
        }
        return playAgain;
    }

    private void coinPosition(int compOrYou, int count) {

        int xpos = count%10;
        int ypos = count/10;
        if(xpos == 0) {
            xpos = 10;
            ypos = ypos-1;
        }
        if(compOrYou == 1) {
            x = 5 + (xpos*55) - 55;
        } else {
            x = 25 + (xpos*55) - 55;
        }
        y = 540 - (ypos*57);
    }
}
