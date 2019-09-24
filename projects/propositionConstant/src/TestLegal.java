public class TestLegal{
	public static void main(String[] args){
		// call instance of LogicalSentence()
    Legal statement = new Legal();
    // test if sentance is logical
		String sentence = "p84849393hgfndsl =>ab";
		System.out.println("sentence is: " + sentence);
    System.out.println(statement.IsLegal(sentence));
	}
}
