public class MyComplex {
    private double real;
    private double imag;

    public MyComplex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return this.real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return this.imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public String toString() {
        return "("+real+" + "+imag+"i)";
    }

    public boolean isReal() {
        if(imag == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isImaginary() {
        if(real == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(double real, double imag) {
        if(this.real == real && this.imag == imag) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(MyComplex another) {
        return another.equals(this.real, this.imag);
    }

    public double magnitude() {
        return Math.sqrt(real*real + imag*imag);
    }

    public double argument() {
        return Math.atan2(real, imag);
    }

    public MyComplex add(MyComplex right) {
        this.real += right.getReal();
        this.imag += right.getImag();
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        double real = this.real + right.getReal();
        double imag = this.imag + right.getImag();
        return new MyComplex(real, imag);
    }

    public MyComplex subtract(MyComplex right) {
        this.real -= right.getReal();
        this.imag -= right.getImag();
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        double real = this.real - right.getReal();
        double imag = this.imag - right.getImag();
        return new MyComplex(real, imag);
    }

    public MyComplex multuply(MyComplex right) {
        return new MyComplex(this.real*right.getReal()-this.imag*right.getImag(), this.real*right.getImag()+this.imag*right.getReal());
    }

    public MyComplex divide(MyComplex right) {
        double denom = right.getReal()*right.getReal()+right.getImag()*right.getImag();
        this.real = right.getReal();
        this.imag = right.getImag();
        return multuply(new MyComplex(this.real/denom,this.imag/denom));
    }

    public MyComplex conjugate(MyComplex right) {
        this.imag = -1*right.getImag();
        return this;
    }
}