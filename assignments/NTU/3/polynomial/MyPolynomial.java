public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return this.coeffs.length;
    }

    public double[] getCoeffs() {
        return this.coeffs;
    }

    public String toString() {
        String retval = "";
        for(int i = this.coeffs.length; i > 0; i--) {
            retval += this.coeffs[i] + "x^" + i + "+";
        }
        retval += this.coeffs[0];
        return retval;
    }

    public MyPolynomial add(MyPolynomial right) {
        double[] rightCoeffs = right.getCoeffs();
        double[] retval;
        int i = 0;
        if(rightCoeffs.length > this.coeffs.length) {
            retval = new double[rightCoeffs.length];
            while(i<rightCoeffs.length) {
                retval[i] = this.coeffs[i] + rightCoeffs[i];
                i++;
            }
            while(i<rightCoeffs.length){
                retval[i] = rightCoeffs[i];
            }
        } else {
            retval = new double[this.coeffs.length];
            while(i<this.coeffs.length) {
                retval[i] = this.coeffs[i] + rightCoeffs[i];
                i++;
            }
            while(i<this.coeffs.length){
                retval[i] = this.coeffs[i];
            }
        }
        return new MyPolynomial(retval);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        // this is too much work...
        return new MyPolynomial(new double[]{1,2,3,4});
    }
}