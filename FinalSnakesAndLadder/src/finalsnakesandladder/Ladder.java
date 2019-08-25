package finalsnakesandladder;

public class Ladder {
    private int initPos;
    private int finalPos;
    Ladder(int initPos,int finalPos)
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
