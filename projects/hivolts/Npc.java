public class Npc {
    int xpos;
    int ypos;

    public Npc(int x, int y){
        xpos = x;
        ypos = y;
    }

    public void npcMove() {
          if (Math.abs(GameFrame.x - xpos) > Math.abs(GameFrame.y - ypos)){ // if horiz dist greater than ver dist
            if(GameFrame.x > xpos){ // if mho is left of player
              xpos++; // move right
            } else if(GameFrame.x < xpos){ // if mho is right of player
              xpos--; // move left
            }
          } else if (Math.abs(GameFrame.x - xpos) < Math.abs(GameFrame.y - ypos)){ // if vert dist greater than horiz dist
            if(GameFrame.y > ypos){ // if mho is under player
              ypos++; // move up
            } else if(GameFrame.y < ypos){ // if mho is above player
              ypos--; // move down
            }
          } else if (Math.abs(GameFrame.x - xpos) == Math.abs(GameFrame.y - ypos)){ // if mho is diagonal from player
            if(GameFrame.x > xpos && GameFrame.y > ypos){ // if below to left
              xpos++; // move right
              ypos++; // move up
            } else if(GameFrame.x < xpos && GameFrame.y > ypos){ // if blow right
              xpos--; // move left
              ypos++; // move up
            } else if(GameFrame.x > xpos && GameFrame.y < ypos){ // if above left
              xpos++; // move right
              ypos--; // move down
            } else if(GameFrame.x < xpos && GameFrame.y < ypos){ // if above right
              xpos--; // move left
              ypos--; // move down
            }
        }
        if (GameFrame.objectLoc[xpos][ypos] != 0){ // if mho is on fence, go to (0,0) (it will hide behind the fence there and stay there)
          xpos = 0;
          ypos = 0;
        }
    }
}
