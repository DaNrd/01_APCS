public class MyPolymonial {
    private double[] coeffs;

    public MyPolymonial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return this.coeffs.length;
    }

    public double[] getCoeffs() {
        return this.coeffs;
    }

    public String toString() {
        for(int i = this.coeffs.length; i > 0; i--) {
            System.out.print(this.coeffs[i] + "x^" + i + "+");
        }
        System.out.print(this.coeffs[0]);
    }

    public MyPolymonial add(MyPolymonial right) {
        double[] rightCoeffs = right.getCoeffs();
        double[] retval;
        int i = 0;
        if(rightCoeffs.length > this.coeffs.length) {
            retval = new double[rightCoeffs.length];
            for(i<rightCoeffs.length; i++) {
                retval[i] = this.coeffs[i] + rightCoeffs[i];
            }
            while(i<rightCoeffs.length){
                retval[i] = rightCoeffs[i];
            }
        } else {
            for(i<this.coeffs.length; i++) {
                retval[i] = this.coeffs[i] + rightCoeffs[i];
            }
            while(i<this.coeffs.length){
                retval[i] = this.coeffs[i];
            }
        }
        return new MyPolymonial(retval);
    }

    public MyPolynomial multiply(MyPolymonial right) {
        // todo (idk how)
    }
}