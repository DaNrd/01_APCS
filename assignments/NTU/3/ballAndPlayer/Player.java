public class Player {
    private int number;
    private float x;
    private float y;
    private float z;

    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.z = 0.0f;
    }

    public void move(float xDisp, float yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    public void jump(float zDisp) {
        this.z += zDisp;
    }

    public boolean near(Ball ball) {
        float xDiff = ball.getX() - this.x;
        float yDiff = ball.getY() - this.y;
        float zDiff = ball.getZ() - this.z;
        double diag = Math.sqrt(xDiff*xDiff+yDiff+yDiff);
        double distance = Math.sqrt(diag*diag+zDiff+zDiff);
        if(distance<8) {
            return true;
        } else {
            return false;
        }
    }

    public void kick(Ball ball) {
        if(this.near(ball)) {
            //todo
        }
    }
}