public class TestLogicalSentence{
	public static void main(String[] args){
		// create instance of LogicalSentence
		LogicalSentence statement = new LogicalSentence();
		// set the sentence string
		String sentence = "a94=92048hfhj";
		//print out whether or not the sentence is simple
		System.out.println(statement.Simple(sentence));
		// define truthArray[]
		boolean[] truthArray = {true, false};
		// print out statement
		if(statement.Valid(truthArray)){
			System.out.println("Is string valid: " + statement.Valid(truthArray));
		} else if(statement.Unsatisfiable(truthArray)){
			System.out.println("Is string unsatisfiable: " + statement.Unsatisfiable(truthArray));
		} else {
			System.out.println("Is string contingent: " + statement.Contingent(truthArray));
		}
	}
}
