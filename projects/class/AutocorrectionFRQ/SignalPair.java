import java.util.*;
public class SignalPair {
    public double[] sig1;
    public double[] sig2;

    public SignalPair(double[] sig1, double[] sig2) {
        this.sig1 = sig1;
        this.sig2 = sig2;
    }

    public double correlate(double[] cor1, double[] cor2) {
        double retval = 0;
        for(int i = 0; i < cor1.length; i++) {
            retval += cor1[i] * cor2[i];
        }
        return retval;
    }

    public double maxAutoCorrelate() {
        double[] retval = new double[2]; // to store {index,value}
        for(int i = 0; i < sig1.length; i++) {
            double auto1 = sig1; // temp variable to be offset without affecting the objects fields
            for(int j=0; j<i; j++) { // offset based on index
                auto1 = offset(auto1);
            }
            double temp = correlate(auto1,auto2);
            if(temp > retval[1]) { // see if the value of this correlate > last largest value
                retval[0] = i;
                retval[1] = temp;
            }
        }
        return retval[0];
    }

    public double[] offset(double[] signal) {
        double[] retval = new double[signal.length]; // to prevent modifying fields
        retval[0] = signal[signal.length - 1]; // first = last
        for(int i = signal.length - 1; i > 0; i--) { // loop and replace vars
            retval[i] = signal[i-1];
        }
        return retval;
    }

    public String toString() {
        return "SignalPair[{sig1=" + sig1 + ",sig2=" + sig2 + "}]";
    }
}