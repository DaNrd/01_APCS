import java.util.regex.Pattern;
public class LogicalSentence{
	// functions
	public String Simple(String sentence){
		//System.out.println(sentence);
		if(sentence.length() == 1){
			return "type: simple";
		} else {
			for(int i=0; i<sentence.length(); i++){
				if(Character.isWhitespace(sentence.charAt(i)) || (LegalChar(sentence.charAt(i)) == false)){
					return "not simple";
				} else {
				}
			}
			return "type: simple";
		}
	}
	// checks if character is legal (A-Z, a-z, 0-9)
	public boolean LegalChar(char piece){
		String pieceStr = String.valueOf(piece);
		if(Character.isLetter(piece) || Pattern.compile( "[0-9]" ).matcher( pieceStr ).find()){
			return true;
		} else{
			return false;
		}
	}
	// test for vaid
	public boolean Valid(boolean[] truthArray){
		for(int i=0; i<truthArray.length; i++){
			if(truthArray[i] == false){
				return false;
			} else {
			}
		}
		return true;
	}
	// test for unsatisfiable
	public boolean Unsatisfiable(boolean[] truthArray){
		for(int i=0; i<truthArray.length; i++){
			if(truthArray[i] == true){
				return false;
			} else {
			}
		}
		return true;
	}
	// test for contingent
	public boolean Contingent(boolean[] truthArray){
		if(Valid(truthArray)){
			return false;
		} else if(Unsatisfiable(truthArray)){
			return false;
		} else {
			return true;
		}
	}
}
