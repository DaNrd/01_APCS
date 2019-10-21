import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.lang.Math;

public class GameFrame extends JComponent{
    //GameFrame written by Aaron and Josh (methods written and edited to the point
    //where it doesnt make sense to attribute any one part to on author.
    //Checked by Ivory
    public static int x = 1; // x loc of player on 12 by 12 grid
    public static int y = 1; // y loc of player on 12 by 12 grid
    public double scale; // for resizeability
    public static int mhoCount = 12; // number of mho to spawn
    public static int fenceCount = 20; // number of inner fences to spawn
    public static int[][] objectLoc = new int[12][12]; // "playable" grid
    public static Npc[] npcLoc = new Npc[mhoCount]; // *magic*
    public int score; // for message
    public int roundNum; // for message
    public String message = "Round: " + roundNum + " Score: " + score; // for win / lose message
    public boolean alive = true; // keeps track of whether or not the player is alive
    public boolean reset = false; // whether or not to reset game
    private int deadMho;
    public void init(){ // called when game starts
        reset = false;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                objectLoc[i][j] = 0; // resets whole grid
            }
        }
        if (alive == true){ // when round completes and player is still alive
            roundNum++; // increase the round number by 1
        } else { // when round completes and player is dead
            roundNum = 0; // reset round counter
            score = 0; // reset score
        }
        message = "Round: " + roundNum + " Score: " + score; // for win / lose message
        x = 1; // reset player x pos
        y = 1; // reset player y pos
        alive = true; // reset alive value
        objectLoc[1][1] = -1; // prevents fence / mho from spawn on player
        spawnFence();
        spawnMho();
        objectLoc[1][1] = 0; // sets (1,1) back to a playable square
    }

    public void spawnFence(){ // spawns fences
        for(int i=0; i<fenceCount; i++){ // runs as many times as there are inner fences
            while(true){
                int gridPosx = (int) (10 * Math.random()); // rand x
                int gridPosy = (int) (10 * Math.random()); // rand y
                if(objectLoc[gridPosx][gridPosy] == 0){ // if the space is available
                    objectLoc[gridPosx][gridPosy] = 1; // set space to fence
                    break;
                }
            }
        }
        // boundries
        for (int i=0; i<12; i++) { // sets borders to fences
            objectLoc[0][i] = 1; // left border
            objectLoc[11][i] = 1; // right border
            objectLoc[i][0] = 1; // top border
            objectLoc[i][11] = 1; // bottom border
        }
    }

    public void spawnMho(){ // spawns mhos
        for(int i = 0; i < mhoCount; i++){ // runs as many times as there are mhos
            while(true){
                int gridPosx = (int) (10 * Math.random()); // rand x
                int gridPosy = (int) (10 * Math.random()); // rand y
                if(objectLoc[gridPosx+1][gridPosy+1] == 0){ // if (x,y) is open square
                    Npc name = new Npc(gridPosx+1, gridPosy +1); // new npc instance
                    npcLoc[i] = name; // assign location values
                    break;
                }
            }
        }
    }

    public void updateFrameSize() { // resize (similar to flag)
        if(getWidth()>getHeight()){
            scale = getHeight()/14;
        } else {
            scale = getWidth()/14;
        }
    }

    public void paintComponent(Graphics g) { // paint things!
        super.paintComponent(g);

        //Paints npcs
        g.setColor(Color.RED);
        for(int i = 0; i < npcLoc.length; i++){
            if(npcLoc[i].alive){
                g.fillOval((int) (scale*(npcLoc[i].xpos+1.05)), (int) (scale*(npcLoc[i].ypos+1.05)), (int) (0.9*scale), (int) (0.9*scale));
            }
        }

        // walls and borders
        for(int i=0; i<12; i++){
            for(int n=0; n<12; n++){
                if(objectLoc[i][n] == 1){
                    g.setColor(Color.GRAY);
                    g.fillRect((int) ((scale*(i+1))+(0.05*scale)), (int) ((scale*(n+1))+(0.05*scale)), (int) (0.9*scale), (int) (0.9*scale));
                }
            }
        }

        // player
        g.setColor(Color.BLUE);
        g.fillOval((int) scale*(x+1), (int) scale*(y+1), (int) scale, (int) scale);

        // message
        g.setColor(Color.BLACK);
        g.drawString(message, 25, 25);
    }

    public void moveRight() {
        x = x + 1;
        findNpcs();
    }

    public void moveLeft() {
        x = x - 1;
        findNpcs();
    }

    public void moveDown() {
        y = y + 1;
        findNpcs();
    }

    public void moveUp() {
        y = y - 1;
        findNpcs();
    }
    public void moveUpRight() {
        x = x + 1;
        y = y - 1;
        findNpcs();
    }

    public void moveUpLeft() {
        x = x - 1;
        y = y - 1;
        findNpcs();
    }

    public void moveDownRight() {
        y = y + 1;
        x = x + 1;
        findNpcs();
    }

    public void moveDownLeft() {
        y = y + 1;
        x = x - 1;
        findNpcs();
    }

    public void stay(){
        findNpcs();
    }

    public void jump(){ // moves player randomly but never on to fence
        x = (int) (10 * Math.random());
        y = (int) (10 * Math.random());
        while (objectLoc[x][y] == 1) { // this is the never on a fence part
            x = (int) (10 * Math.random());
            y = (int) (10 * Math.random());
        }
        checkWin();
    }

    public void findNpcs() { // npc moves and check how many npcs died
        int oldDeadMho;
        if(deadMho != npcLoc.length){ //Still playing same round
            oldDeadMho = deadMho;
        } else { // New round started
            oldDeadMho = 0;
        }
        deadMho = 0;
        for(int i = 0; i < npcLoc.length; i++) {
            if (npcLoc[i].alive){
                npcLoc[i].npcMove(); // moves the npcs in order
            }
            if (!npcLoc[i].alive){
                deadMho++; // adds to dead mho round
            }
        }
        score += roundNum * (deadMho - oldDeadMho); // calculates score based of how many mhos died and on what round
        checkWin();
    }

    public void checkWin(){ // check if player is on mho or fence or if all mhos are dead
        for(int i = 0; i < npcLoc.length; i++) {
            if ((npcLoc[i].xpos == x && npcLoc[i].ypos == y) || objectLoc[x][y] == 1){
                alive = false; // kills player
                break;
            }
        }
        // messages
        if (mhosDead()){ // if all mhos are dead
            String s = "";
            if (roundNum > 1){
                s = "s"; // for adding "s" to "round" if roundNum > 1
            }
            message = "Congrats! You have passed " + roundNum + " round" + s + " and have " + score + " points! Press any button to keep going!";
            reset = true;
        } else if (alive == false){ // if you are dead
            message = "You Lost :( You died on round number " + roundNum + " with " + score + " points. Press any button to restart!";
            reset = true;
        } else { // if still alive and still mhos
            message = "Round: " + roundNum + " Score: " + score;
            alive = true;
            reset = false;
        }
        repaint();
    }

    public boolean mhosDead(){ // if all mhos are dead, go to next round
        boolean retval = true;
        for(int i = 0; i < npcLoc.length; i++){
            if(npcLoc[i].alive){
                retval = false;
                break;
            }
        }
        return retval;
    }
}
