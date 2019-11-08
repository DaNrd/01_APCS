public class PositionList{ //shuffles list of open positions to create randomized list
    Position[] list = new Position[0];

    public PositionList(){

    }

    public void add(Position positionToBeAdded){
        Position[] newList = new Position[list.length + 1]; //Creates new list with length one greater
        for(int i = 0; i < list.length; i++){ // Copies old list
            newList[i] = list[i];
        }
        newList[list.length] = positionToBeAdded; // Adds extra position
        list = newList; // Sets list to be modified Position[]
    }

    public void shuffle(){ //loops
        for(int i = 0; i < list.length; i++) {
            int j = randInt(i, list.length - 1);
            swapPositions(i, j);
        }
    }

    public void swapPositions(int i, int j) { //helper method to shuffle; swaps two random positions in listOfOpenPositions
        Position temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public int randInt(int low, int high) {
        int x = (int)(Math.random() * (double)(high - low) + (double)low); //Converted to doubles to multiple with Math.random()
        return x;
    }

    public Position get(int index){
        return list[index];
    }

    public void clear(){
        list = new Position[0];
    }
}