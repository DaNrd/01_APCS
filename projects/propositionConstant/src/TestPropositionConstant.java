public class TestPropositionConstant {
  public static void main(String[] args){
    // create new instance of PropositionConstant called testpc
    PropositionConstant testpc = new PropositionConstant();
    // set the name value of testpc
    testpc.setValue("p", true);
    if(testpc.truthValue == true){
      System.out.println(testpc.name + " passes");
    }else{
      System.out.println(testpc.name + " fails");
    }
  }
}
