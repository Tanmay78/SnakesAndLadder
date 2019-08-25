package finalsnakesandladder;

import java.util.ArrayList;

public class SNLCollection {
    ArrayList<Snake> snakeArr = new ArrayList<>();
    ArrayList<Ladder> ladderArr = new ArrayList<>();
    void addSnake(Snake s)
    {
        snakeArr.add(s);
    }
    void addLadder(Ladder l)
    {
        ladderArr.add(l);
    }
    Snake getSnake(int i)
    {
        return snakeArr.get(i);
    }
    Ladder getLadder(int i)
    {
        return ladderArr.get(i);
    }
    int Lsize()
    {
        return ladderArr.size();
    }
    int Ssize()
    {
        return snakeArr.size();
    }
}
