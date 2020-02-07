public class PcopTwoTree {
    PcopTwoTree leftSubTree;
    PcopTwoTree rightSubTree;
    int rootValue;

    PcopTwoTree(int rootValue) {
        this.rootValue = rootValue;
    }

    public void insert(int value) {
        if (value < rootValue){
            if (leftSubTree == null) {
                leftSubTree = new PcopTwoTree(value);
            } else {
                leftSubTree.insert(value);
            }
        } else {
            if (rightSubTree == null) {
                rightSubTree = new PcopTwoTree(value);
            } else {
                rightSubTree.insert(value);
            }
        }
    }

    public ArrayList returnSortedList() {

    }
}