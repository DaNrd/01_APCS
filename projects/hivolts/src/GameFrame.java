import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.lang.*;
import javax.swing.*;
import javax.sound.sampled.*;

public class GameFrame extends JComponent {
    /**
    GameFrame written by Aaron and Josh (methods written and edited to the point
    where it doesn't make sense to attribute any one part to on author.
    Edited by Ivory
    Additional Animations added by Jasmine
     **/

    //booleans
    public boolean roundOver = false; // whether or not to roundOver game
    public boolean validJump = false; // check if jump is valid
    public boolean titleScreen = true; // controls painting of title screen
    public boolean storyScreen = false; // controls painting of storyScreen
    public boolean controlsScreen = false; // controls painting of controls screen
    public boolean creditsScreen = false; // controls painting of creditsScreen
    public boolean animImage = true; // controls which image is displayed (version 1 or 2)
    public boolean music = true; // toggle for music

    // images
    public Image MhoFront = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoFront1.png"));
    public Image MhoRight = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoRight1.png"));
    public Image MhoLeft = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoLeft1.png"));
    public Image MhoBack = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoBack1.png"));
    public Image MhoEat = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoEat1.png"));
    public Image CharFront = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerFront1.png"));
    public Image CharRight = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerRight1.png"));
    public Image CharLeft = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerLeft1.png"));
    public Image CharBack = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerBack1.png"));
    public Image CharWin = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerCheer1.png"));
    public Image Fence = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("fence1.png"));

    //tweakable generalized parameters
    static public int mhoCount = 12; // number of mho to spawn
    public int fenceCount = 20; // number of inner fences to spawn
    public static int boardWidth = 12; // width of playable board (number of spaces wide)
    public static int boardHeight = 12; // height of playable board (number of spaces high)

    //statistics counters
    public int score; // score counter
    public int roundNum; // round number counter
    public int moveCount = 0; // move counter
    public String message = "Round: " + roundNum + " Score: " + score; // for win / lose message

    // other stuff
    public double scale; // for resizeability
    public BoardPiece[][] objectLocations = new BoardPiece[boardWidth][boardHeight]; // "playable" grid
    public Mho[] mhoMoveArray = new Mho[mhoCount]; // mhos
    public PositionList openPositionList = new PositionList(); // open positions
    public Player playerInstance = new Player();
    public Color COOLBLUE = new Color(0x67E0F4);
    public Color BLINKBLUE = new Color(0x67E0F4);
    public Color GROUND = new Color(0x323639);
    public Color BACKGROUND = new Color(0x131415);
    public int jumpx = 0; // x loc of player before a jump
    public int jumpy = 0; // y loc of player before a jump
    public Clip clip; // sound
    public int rotate = 0;
    public int playerDirection = 0;

    public void init() { // called when game starts
        roundOver = false;
        titleScreen = false;
        moveCount = 0;
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                objectLocations[i][j] = null; // roundOvers whole grid
            }
        }
        if (playerInstance.alive) { // when round completes and player is still alive
            roundNum++; // increase the round number by 1
        } else { // when round completes and player is dead
            roundNum = 1; // roundOver round counter
            score = 0; // roundOver score
        }
        message = "Round: " + roundNum + " Score: " + score; // for win / lose message
        validJump = false;
        getNewListOfOpenPositions();  //generates new randomized list of positions
        spawnFence(); //new randomized display of fences
        spawnMho(); //new randomized display of mhos
        spawnPlayer(); // roundOver player x and y pos (new randomized position)
        setBlankSpaces();
        playerInstance.alive = true; // roundOver alive value
    }

    public void drawBackground(Graphics g){ //Draws a black background
        g.setColor(BACKGROUND);
        g.fillRect(0, 0, (int) (scale * scale), (int) (scale * scale));
    }

    public void drawTitleScreenTitle(Graphics g){
        g.setColor(COOLBLUE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, (int) (scale * 2.5)));
        g.drawString("HiVolts!", (int) scale * 3, (int) scale * 3);
    }

    public void drawIntroCharacters(Graphics g){ //Draws sprites for Title Screen
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(CharRight, (int) scale * 1, (int) scale * 5, (int) scale * 4, (int) scale * 4, this);
        g2.drawImage(Fence, (int) scale * 5, (int) scale * 5, (int) scale * 4, (int) scale * 4, this);
        g2.drawImage(MhoLeft, (int) scale * 9, (int) scale * 5, (int) scale * 4, (int) scale * 4, this);
    }

    public void drawNextScreenControls(Graphics g){ //Tells user to press a key to continue
        g.setColor(BLINKBLUE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, (int) (scale * 1)));
        g.drawString("Press any key to continue:", (int) (scale * 2), (int) (scale * 12.5));
    }

    public void drawTitleScreen(Graphics g){
        if(titleScreen == true) {
            drawBackground(g);
            drawTitleScreenTitle(g);
            drawIntroCharacters(g);
            drawNextScreenControls(g);
            g.setFont(new Font("TimesRoman", Font.PLAIN, (int)(scale*0.5)));
            g.drawString("Or press c for credits:", (int) (scale*5), (int)(scale * 13.5));
        }
    }

    public void drawStoryScreen(Graphics g){
        if(storyScreen == true){
            drawBackground(g);
            g.setColor(COOLBLUE); //
            g.setFont(new Font("TimesRoman", Font.PLAIN, (int) (scale * 2.5)));
            g.drawString("Story:", (int) (scale * 4.5), (int) scale * 2); //Title of Story screen
            drawStorySpeech(g);
            drawTurntable(g); //Rotating sprites
            drawNextScreenControls(g);
        }
    }

    public void drawTurntable(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(rotate == 0){
            g2.drawImage(CharFront,0, (int) scale * 6, (int) scale * 4, (int) scale * 4, this);
            g2.drawImage(MhoFront, (int) (scale * 11), (int) scale * 6, (int) scale * 4, (int) scale * 4, this);
        } else if(rotate == 1){
            g2.drawImage(CharRight,0, (int) scale * 6, (int) scale * 4, (int) scale * 4, this);
            g2.drawImage(MhoLeft, (int) (scale * 11), (int) scale * 6, (int) scale * 4, (int) scale * 4, this);
        } else if(rotate == 2){
            g2.drawImage(CharBack,0, (int) scale * 6, (int) scale * 4, (int) scale * 4, this);
            g2.drawImage(MhoBack, (int) (scale * 11), (int) scale * 6, (int) scale * 4, (int) scale * 4, this);
        } else if(rotate == 3){
            g2.drawImage(CharLeft,0, (int) scale * 6, (int) scale * 4, (int) scale * 4, this);
            g2.drawImage(MhoRight, (int) (scale * 11), (int) scale * 6, (int) scale * 4, (int) scale * 4, this);
        }
    }

    public void drawInstructionScreenTitle(Graphics g){
        g.setColor(COOLBLUE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, (int) (scale * 1.5)));
        g.drawString("Controls:", (int) (scale*4), (int) (scale * 1.5));
    }

    public void drawRoundOver(Graphics g){
        if(roundOver == true){ //roundOver true when round over
            drawBackground(g);
            g.setColor(COOLBLUE);
            g.setFont(new Font("TimesRoman", Font.PLAIN, (int) (scale * 1.5)));
            Graphics2D g2 = (Graphics2D) g;
            if(playerInstance.alive == true){
                g.drawString("You Won!", (int) (scale*3.5), (int) (scale * 1.5));
                g2.drawImage(CharWin, (int) scale * 5, (int) scale * 5, (int) scale * 4, (int) scale * 4, this);
                g.setColor(BLINKBLUE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, (int)(scale)));
                g.drawString("Press any button to continue:", (int) (scale*1.5), (int)(scale * 12));
            } else {
                g.drawString("You Died!", (int) (scale*4), (int) (scale * 1.5));
                g2.drawImage(MhoEat, (int) scale * 5, (int) scale * 5, (int) scale * 4, (int) scale * 4, this);
                g.setColor(BLINKBLUE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, (int)(scale)));
                g.drawString("Press any button to restart:", (int) (scale*2), (int)(scale * 12));
            }
            g.setColor(COOLBLUE);
            g.setFont(new Font("TimesRoman", Font.PLAIN, (int)(scale*0.5)));
            g.drawString(message, (int)(3*scale), (int)(3*scale));
            g.drawString("Press Esc to go back to the Main Menu:", (int) (scale*3), (int)(scale * 13.5));
        }
    }

    public void drawCreditsScreen(Graphics g){
        if(creditsScreen == true){
            drawBackground(g);
            g.setColor(COOLBLUE);
            g.setFont(new Font("TimesRoman", Font.PLAIN, (int) (scale * 2.5)));
            g.drawString("HiVolts!", (int) scale * 3, (int) scale * 3);
            g.setFont(new Font("TimesRoman", Font.PLAIN, (int) (scale)));
            g.drawString("Game Design:", (int)(scale * 1.5), (int) (scale * 5.5));
            g.drawString("Graphics:", (int)(scale * 8), (int) (scale * 5.5));
            g.drawString("Music:", (int)(scale * 8), (int) (scale * 8.75));
            g.setFont(new Font("TimesRoman", Font.PLAIN, (int) (scale * 0.5)));
            g.drawString("Joshua Athayde", (int)(scale * 1.5), (int) (scale * 6.25));
            g.drawString("Aaron Campbell", (int)(scale * 1.5), (int) (scale * 7));
            g.drawString("Jasmine Kapadia", (int)(scale * 1.5), (int) (scale * 7.75));
            g.drawString("Ivory Tang", (int)(scale * 1.5), (int) (scale * 8.5));
            g.drawString("Aanika Akkaraju", (int)(scale * 8), (int) (scale * 6.25));
            g.drawString("Aaron Campbell", (int)(scale * 8), (int) (scale * 7));
            g.drawString("Henry Jurney", (int)(scale * 8), (int) (scale * 9.5));
            g.setColor(BLINKBLUE);
            g.setFont(new Font("TimesRoman", Font.PLAIN, (int)(scale*0.5)));
            g.drawString("Press Esc to go back to the Main Menu:", (int) (scale*3), (int)(scale * 13.5));
        }
    }

    public void drawStorySpeech(Graphics g){
        g.setFont(new Font("TimesRoman", Font.PLAIN, (int) (scale * 0.5)));
        g.drawString("You are a brave adventurer on", (int) (scale * 4), (int) (scale * 3.5));
        g.drawString("an unknown planet! While", (int)(scale * 4), (int) (scale * 4.25));
        g.drawString("exploring you discover a new", (int)(scale * 4), (int) (scale * 5));
        g.drawString("species: the mho! Unfortunately,", (int) (scale * 4), (int) (scale * 5.75));
        g.drawString("as you approach they begin to", (int) (scale * 4), (int) (scale * 6.5));
        g.drawString("attack. As you run away, you", (int) (scale * 4), (int) (scale * 7.25));
        g.drawString("get lost in a maze of electric", (int) (scale * 4), (int) (scale * 8));
        g.drawString("fences. Seeing as you are unarmed,", (int) (scale * 4), (int) (scale * 8.75));
        g.drawString("you realize that the only way to", (int) (scale * 4), (int) (scale * 9.5));
        g.drawString("survive is to lead the mhos on to", (int) (scale * 4), (int) (scale * 10.25));
        g.drawString("the electric fences...", (int) (scale * 4), (int) (scale * 11));
    }

    public void drawControls(Graphics g){
        g.setFont(new Font("TimesRoman", Font.PLAIN, (int) (scale * 0.4)));
        g.drawString("W : move up", (int)(scale * 5), (int) (scale * 3));
        g.drawString("A : move left", (int)(scale * 5), (int) (scale * 3.75));
        g.drawString("S : move down", (int)(scale * 5), (int) (scale * 4.5));
        g.drawString("D : move right", (int)(scale * 5), (int) (scale * 5.25));
        g.drawString("Q : move up and to the left", (int)(scale * 5), (int) (scale * 6));
        g.drawString("E : move up and to the right", (int)(scale * 5), (int) (scale * 6.75));
        g.drawString("Z : move down and to the left", (int)(scale * 5), (int) (scale * 7.5));
        g.drawString("C : move down and to the right", (int)(scale * 5), (int) (scale * 8.25));
        g.drawString("S : stay (skip turn)", (int)(scale * 5), (int) (scale * 9));
        g.drawString("J : jump to random square (may be mho)", (int)(scale * 5), (int) (scale * 9.75));
        g.drawString("M : toggle music", (int)(scale * 5), (int) (scale * 10.5));

    }

    public void drawPressKeyToBegin(Graphics g){
        g.setColor(BLINKBLUE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, (int) (scale * 1)));
        g.drawString("Press any key to begin:", (int) (scale * 3), (int) (scale * 13));
    }

    public void drawControlsPage(Graphics g){
        if(controlsScreen == true){
            drawBackground(g);
            drawInstructionScreenTitle(g);
            drawTurntable(g);
            drawControls(g);
            drawPressKeyToBegin(g);
        }
    }

    public void playThemeMusic(){ // called in Hivolts.initializeHivolts, plays theme song
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("themeSong.wav"));

            // create clip reference
            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // open audioInputStream to the clip
            clip.start();
        }
        catch(UnsupportedAudioFileException ex) {
            System.out.println("Error with playing sound, UnsupportedAudioFileException.");
            ex.printStackTrace();
        } catch(IOException ex){
            System.out.println("Error with playing sound, IOException.");
            ex.printStackTrace();
        } catch(LineUnavailableException ex){
            System.out.println("Error with playing sound, LineUnavailableException.");
            ex.printStackTrace();
        }
    }

    public void toggleMusic(){
        if(music == true){
            clip.stop();
            music = false;
        } else {
            clip.start();
            music = true;
        }
    }

    public void getNewListOfOpenPositions(){ //adds the 10-by-10 inner grid positions to an arraylist (not 12-by-12 so you don't have to check for outer fence position when spawning mho or player or inner fence)
        openPositionList.clear();
        for (int a = 1; a < boardWidth-1; a++) {
            for (int b = 1; b < boardHeight-1; b++) {
                openPositionList.add(new Position(a,b));
            }
        }
        openPositionList.shuffle(); //shuffles the positions so that they are in random order
    }

    public void spawnMho() { // spawns mhos
        //sets first few randomized positions in listOfOpenPositions to mhos
        for (int i = 0; i < mhoCount; i++) { // runs as many times as there are mhos
            Mho newMho = new Mho(openPositionList.get(i).x, openPositionList.get(i).y); // new Mho instance
            mhoMoveArray[i] = newMho; // assign location values
            objectLocations[newMho.x][newMho.y] = newMho;
        }
    }

    public void spawnFence() { // spawns fences
        //sets next few randomized positions in listOfOpenPositions to fences
        for (int i = mhoCount; i < fenceCount + mhoCount; i++) { // runs as many times as there are inner fences
            Fence newFence = new Fence(openPositionList.get(i).x, openPositionList.get(i).y); // new npc instance
            objectLocations[newFence.x][newFence.y] = newFence;
        }
        // boundaries
        for (int i = 0; i < 12; i++) { // sets borders to fences
            objectLocations[0][i] = new Fence(0, i); // left border
            objectLocations[boardWidth-1][i] = new Fence(11, i); // right border
            objectLocations[i][0] = new Fence(i, 0); // top border
            objectLocations[i][boardHeight-1] = new Fence(i, 11); // bottom border
        }
    }

    public void spawnPlayer() { // spawns mhos
        //sets next position in listOfOpenPositions to player's initial position
        int nextOpenPosition = fenceCount + mhoCount; //next open position in list of randomized grid positions
        playerInstance.initPlayer(openPositionList.get(nextOpenPosition).x, openPositionList.get(nextOpenPosition).y);
        objectLocations[playerInstance.x][playerInstance.y] = playerInstance;
    }

    public void setBlankSpaces(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                if(objectLocations[i][j] == null){
                    objectLocations[i][j] = new BlankSpace();
                }
            }
        }
    }

    public void updateFrameSize() { // resize (similar to flag)
        if (getWidth() > getHeight()) {
            scale = getHeight() / 14;
        } else {
            scale = getWidth() / 14;
        }
    }

    private double pos2Coord(int pos) {
        return scale * (pos + 1);
    }

    private void drawPlayer(Graphics g) {  //draws player
        final double px = pos2Coord(playerInstance.x), py = pos2Coord(playerInstance.y);
        Graphics2D g2 = (Graphics2D) g;
        if(playerDirection == 0) {
            g2.drawImage(CharFront, (int)px, (int)py, (int)scale, (int)scale, this);
        } else if(playerDirection == 1){
            g2.drawImage(CharRight, (int)px, (int)py, (int)scale, (int)scale, this);
        } else if(playerDirection == 2){
            g2.drawImage(CharLeft, (int)px, (int)py, (int)scale, (int)scale, this);
        } else {
            g2.drawImage(CharBack, (int)px, (int)py, (int)scale, (int)scale, this);
        }
    }

    public void drawMho(Graphics g, int x, int y) {
        final double px = pos2Coord(x), py = pos2Coord(y);
        Graphics2D g2 = (Graphics2D) g;
        if(Math.abs(playerInstance.x-x) < Math.abs(playerInstance.y-y)){
            if(playerInstance.y>y){
                g2.drawImage(MhoFront, (int)px, (int)py, (int)scale, (int)scale, this);
            } else {
                g2.drawImage(MhoBack, (int)px, (int)py, (int)scale, (int)scale, this);
            }
        } else {
            if(playerInstance.x>x){
                g2.drawImage(MhoRight, (int)px, (int)py, (int)scale, (int)scale, this);
            } else if(playerInstance.x<x) {
                g2.drawImage(MhoLeft, (int)px, (int)py, (int)scale, (int)scale, this);
            } else {
                g2.drawImage(MhoBack, (int)px, (int)py, (int)scale, (int)scale, this);
            }
        }
    }

    private void jumpAnimation(Graphics g) {
        final int ONE_SECOND = 1000;
        if (!validJump)
            return;
        final double px = pos2Coord(jumpx), py = pos2Coord(jumpy);
        final Color fadedBlue = new Color(0, 0, 255, 128);
        g.setColor(fadedBlue);
        g.fillOval((int) px, (int) py, (int) scale, (int) scale);
        final Timer timer = new Timer(ONE_SECOND, actionEvent -> {
            g.setColor(getBackground());
            g.fillOval((int) px, (int) py, (int) scale, (int) scale);
            repaint();
            validJump = false;
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void paintComponent(Graphics g) { // paint things!
        super.paintComponent(g);
        if(titleScreen == true || controlsScreen == true || creditsScreen == true || storyScreen == true){
            drawTitleScreen(g);
            drawControlsPage(g);
            drawCreditsScreen(g);
            drawStoryScreen(g);
        } else {
            //draws black background
            drawBackground(g);

            //draws floor
            drawGameBoard(g);

            //draws gameboard and pieces
            drawAllMhos(g);
            drawWallsAndBorders(g);
            jumpAnimation(g);
            drawPlayer(g);
            drawMessage(g);

            //"level up!! when player finishes a round"
            if (allMhosDead()) {
                drawRoundOver(g);
            } else if (playerInstance.alive){
                drawMoveCount(g);
            } else if (playerInstance.alive == false){
                drawRoundOver(g);
            }
        }
    }

    public void timerAction(){
        if(BLINKBLUE == COOLBLUE){
            BLINKBLUE = BACKGROUND;
        } else {
            BLINKBLUE = COOLBLUE;
        }
        switchSprites();
        if(rotate == 3){
            rotate = 0;
        } else {
            rotate++;
        }
    }

    public void switchSprites(){
        if(animImage == true){
            MhoFront = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoFront1.png"));
            MhoRight = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoRight1.png"));
            MhoLeft = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoLeft1.png"));
            MhoBack = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoBack1.png"));
            MhoEat = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoEat1.png"));
            CharFront = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerFront1.png"));
            CharRight = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerRight1.png"));
            CharLeft = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerLeft1.png"));
            CharBack = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerBack1.png"));
            CharWin = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerCheer1.png"));
            Fence = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("fence1.png"));
        } else {
            MhoFront = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoFront2.png"));
            MhoRight = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoRight2.png"));
            MhoLeft = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoLeft2.png"));
            MhoBack = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoBack2.png"));
            MhoEat = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("mhoEat2.png"));
            CharFront = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerFront2.png"));
            CharRight = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerRight2.png"));
            CharLeft = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerLeft2.png"));
            CharBack = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerBack2.png"));
            CharWin = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("playerCheer2.png"));
            Fence = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("fence2.png"));
        }
        animImage=!animImage;
    }

    public void drawGameBoard(Graphics g){
        g.setColor(GROUND);
        g.fillRect((int)scale, (int)scale, (int)(boardWidth*scale), (int)(boardHeight*scale));
    }

    private void drawMoveCount(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, (int) ((int)scale * 0.45)));
        g.setColor(COOLBLUE);
        g.drawString("Moves: " + moveCount, (int)(8*scale),(int)(0.75*scale));
    }

    private void drawMessage(Graphics g) { //prints message of round and score value
        g.setColor(COOLBLUE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, (int)(scale*0.5)));
        g.drawString(message, (int)(1*scale), (int)(0.75*scale));
        if(roundOver == true){
            if(playerInstance.alive == false){
                g.drawString("Press any button to restart!", (int) (scale), (int)(scale * 13.5));
            } else {
                g.drawString("Press any button to continue!", (int) (scale), (int)(scale * 13.5));
            }
        }
    }

    private void drawWallsAndBorders(Graphics g) {
        for (int i = 0; i < 12; i++) {
            for (int n = 0; n < 12; n++) {
                if (objectLocations[i][n] instanceof Fence) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.drawImage(Fence, (int)(scale*(i+1)), (int)(scale*(n+1)), (int)scale, (int)scale, this);
                }
            }
        }
    }

    private void drawAllMhos(Graphics g) {
        for (int i = 0; i < mhoMoveArray.length; i++) {
            if (mhoMoveArray[i].alive) {
                drawMho(g, mhoMoveArray[i].x, mhoMoveArray[i].y);
            }
        }
    }

    public void updateGameState(){ //updates all counts
        int deadMho = 0;
        if(playerInstance.alive) {
            for (int i = 0; i < mhoMoveArray.length; i++) {
                if (mhoMoveArray[i].alive) {
                    objectLocations = mhoMoveArray[i].moveMho(objectLocations); // moves the npcs in order
                }
                if (!mhoMoveArray[i].alive) {
                    deadMho++; // adds to dead mho round
                }
            }
        }
        score = roundNum * (roundNum - 1) * 6 + deadMho * roundNum;
        playerInstance.checkIfAlive(objectLocations);
        setMessage();
        repaint();
    }

    public void setMessage() {
        if (allMhosDead()) { // if all mhos are dead
            String s = "";
            if (roundNum > 1) {
                s = "s"; // for adding "s" to "round" if roundNum > 1
            }
            message = "Congrats! You have passed " + roundNum + " round" + s + " and have " + score + " points!";
            roundOver = true;
        } else if (playerInstance.alive == false) { // if you are dead
            message = "You reached round number " + roundNum + " with " + score + " points.";
            roundOver = true;
        } else { // if still alive and still mhos
            message = "Round: " + roundNum + " Score: " + score;
            playerInstance.alive = true;
            roundOver = false;
        }
    }

    public boolean allMhosDead() { // if all mhos are dead, go to next round
        boolean retval = true;
        for (int i = 0; i < mhoMoveArray.length; i++) {
            if (mhoMoveArray[i].alive) {
                retval = false;
                break;
            }
        }
        return retval;
    }

}