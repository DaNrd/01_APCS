public class Main {
  public static void main(String[] args){
    PhysicsFrame particle = new PhysicsFrame();
    double[] eq = particle.getEquations();
    double time0 = eq[eq.length-1];
    particle.setVisible(true);
    while(time0<(System.currentTimeMillis())){
      particle.calcLoc(eq);
    }
  }
}
