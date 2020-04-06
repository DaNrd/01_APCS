public class LinearDataset {
    public static void main(String[] args) {
        createDataset(100, 2, 10);
    }

    public static void createDataset(double max, double slope, double intercept) {
        for(int i = 0; i < max; i++) {
            System.out.println(slope * i + intercept);
        }
    }
}