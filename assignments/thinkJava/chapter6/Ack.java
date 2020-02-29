public class Ack {

    public static void main(String[] args) {
        System.out.println(ack(1, 2));
    }

    public static int ack(int m, int n) {
        if(m==0){
            return n+1;
        } else if(n==0 && m>0) {
            return ack(m-1,1);
        } else {
            return ack(m-1, ack(m,n-1));
        }
    }

}