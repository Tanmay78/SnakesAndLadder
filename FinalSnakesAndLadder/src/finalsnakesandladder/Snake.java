package finalsnakesandladder;

public class Snake {
    private int initPos;
    private int finalPos;
    Snake(int initPos,int finalPos)
    {
        this.initPos=initPos;
        this.finalPos=finalPos;
    }

    public int getInitPos() {
        return initPos;
    }

    public int getFinalPos() {
        return finalPos;
    }
}
