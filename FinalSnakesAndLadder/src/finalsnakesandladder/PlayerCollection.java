package finalsnakesandladder;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iiita
 */
public class PlayerCollection {
    private ArrayList<Player> pc= new ArrayList<Player>();
    public void add(Player p){
        pc.add(p);
    }
    public Player getplayer(int i){
        return pc.get(i);
    }
    public int getsize(){
        return pc.size();
    }    
}
