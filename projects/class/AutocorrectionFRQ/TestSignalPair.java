public class TestSignalPair {
   public static void main(String[] args) {

            double[] b = {3,1,4,1};

            double[] a = {.5,2,.1,1.5};

            double[] nts = {0,1,0,0};



            SignalPair sP = new SignalPair(a,b);



            System.out.println("The max circular offset match is at " + sP.maxAutoCorrelate());


            double[] c = {0,1,0,0};

            double[] d = {0,0,0,1};

            SignalPair sP2 = new SignalPair(c,d);


            System.out.println("The next max circular offset match is at " + sP2.maxAutoCorrelate());


            SignalPair sP3 = new SignalPair(nts,b);


            System.out.println("The next max circular offset match is at " + sP3.maxAutoCorrelate());

        }

}