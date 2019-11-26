import java.util.regex.Pattern;
public class Legal {
	// initial function
	public boolean IsLegal(String sentence0){
		for(int i=0; i<sentence0.length(); i++){
			if(Character.isWhitespace(sentence0.charAt(i))){
				if(LegalChar(sentence0.charAt(i-1)) || LegalLetter(sentence0.charAt(i+1)) || (sentence0.charAt(i+1) == '~') || (sentence0.charAt(i-1) == '~')){
					if((sentence0.charAt(i+1) == '~') || (sentence0.charAt(i+1) == '=') || (sentence0.charAt(i+1) == '<') || (sentence0.charAt(i-1) == '=') || (sentence0.charAt(i+1) == '>')){
						i++;
					} else {
						System.out.println("fails split test because of no operator between terms");
						return false;
					}
				} else {
					System.out.println("fails split test because of space between two operators");
					return false;
				}
			} else{
				i++;
			}
		}
		System.out.println("pass split test");
		return(NoWhiteSpace(sentence0));
	}
	// removes whitespace from string
	public boolean NoWhiteSpace(String sentence0){
		String sentence1 = "";
		for (int i = 0; i < sentence0.length(); i++){
		   if(Character.isWhitespace(sentence0.charAt(i)) == true){
				i++;
			} else {
				sentence1 += sentence0.charAt(i);
			}
		 }
 		System.out.println("pass Remove Whitespace");
		return(LastCharTest(sentence1));
	}
	// checks if last character is legal
	public boolean LastCharTest(String sentence8){
		if(LegalChar(sentence8.charAt(sentence8.length()-1))){
			System.out.println("Pass LastCharTest");
			return(IsFirstLowerCase(sentence8));
		} else {
			System.out.println("fails lastCharTest (the last character was invalid or opperator)");
			return false;
		}
	}
	// makes sure first letter is lowercase
	public boolean IsFirstLowerCase(String sentence1){
		if(Character.isLetter(sentence1.charAt(0))){
			if (Character.isLowerCase(sentence1.charAt(0)) == true)
			{
				System.out.println("Pass lowerCase");
			  return(IsSingleSimple(sentence1));
			} else {
				System.out.println("fails lowercase (first character is capitalized)");
				return false;
			}
		} else {
			System.out.println("abstain lowerCase (for not as first character)");
			return(IsSingleSimple(sentence1));
		}
	}
	// checks for simple sentence
	public boolean IsSingleSimple(String sentence2){
		if(sentence2.length() == 1){
			System.out.println("Pass singleSimple");
			return true;
		} else {
			System.out.println("Pass singleSimple");
			return(IsLongSimple(sentence2));
		}
	}
	// checks for long simple sentence
	public boolean IsLongSimple(String sentence3){
		for (int i = 0; i < sentence3.length(); i++){
		    if(LegalChar(sentence3.charAt(i))){
					System.out.println("Pass longSimple");
					return true;
				} else {
					i++;
				}
		  }
		System.out.println("Pass longSimple");
		return(LegalNot(sentence3));
	}
	// checks for legal use of '~'
	public boolean LegalNot(String sentence4){
		for (int i = 0; i < sentence4.length(); i++){
				if(sentence4.charAt(sentence4.length()-1) != '~'){
					if((sentence4.charAt(i) == '~') && LegalChar(sentence4.charAt(i+1)) && Character.isLowerCase(sentence4.charAt(i+1)) || (sentence4.charAt(i+1) == '~')){
						i++;
					} else {
						System.out.println("fail legalNot for having char after ~ be uppercase or invalid or opperator other than ~");
						return false;
					}
				} else {
					System.out.println("fail legalNot because last character is ~");
					return false;
				}
		  }
		System.out.println("Pass legalNot");
		return(LegalAnd(sentence4));
	}
	// checks for legal use of '&'
	public boolean LegalAnd(String sentence5){
		for (int i = 0; i < sentence5.length(); i++){
				if(sentence5.charAt(sentence5.length()-1) != '&'){
					if(sentence5.charAt(i) == '&'){
						if(Character.isLowerCase(sentence5.charAt(i+1)) && Character.isLetter(sentence5.charAt(i+1)) && LegalChar(sentence5.charAt(i-1)) || (sentence5.charAt(i+1) == '~')){
							i++;
						} else {
							System.out.println("fail legalAnd for not starting next constant with lowercase or ~");
							return false;
						}
					} else {
						i++;
					}
				} else {
					System.out.println("fail because last char is &");
					return false;
				}
		  }
		System.out.println("Pass legalAnd");
		return(LegalOr(sentence5));
	}
	// checks for legal use of '|'
	public boolean LegalOr(String sentence6){
		for (int i = 0; i < sentence6.length(); i++){
				if(sentence6.charAt(sentence6.length()-1) != '|'){
					if(sentence6.charAt(i) == '&'){
						if(Character.isLowerCase(sentence6.charAt(i+1)) && Character.isLetter(sentence6.charAt(i+1)) && LegalChar(sentence6.charAt(i-1)) || (sentence6.charAt(i+1) == '~') || (sentence6.charAt(i-1) == '~')){
							i++;
						} else {
							System.out.println("fail legalOr for not starting next constant with lowercase or ~");
							return false;
						}
					} else {
						i++;
					}
				} else {
					System.out.println("fail because last char is |");
					return false;
				}
		  }
		System.out.println("Pass LegalOr");
		return(LegalImplies(sentence6));
	}
	// checks if legal '=>'
	public boolean LegalImplies(String sentence7){
		for (int i = 0; i < sentence7.length(); i++){
				if(sentence7.charAt(sentence7.length()-1) != '='){
					if(sentence7.charAt(i) == '='){
						if((Character.isLetter(sentence7.charAt(i+1)) && Character.isLowerCase(sentence7.charAt(i+1))) || (sentence7.charAt(i+1) == '>') || (sentence7.charAt(i+1) == '~')){
							i++;
						} else if(LegalChar(sentence7.charAt(i-1)) || (sentence7.charAt(i-1) == '<')) {
							i++;
						} else {
							System.out.println("fail legalOr for not starting next constant with lowercase or ~");
							return false;
						}
					} else {
						i++;
					}
				} else {
					System.out.println("fail because last char is = or > or <");
					return false;
				}
		  }
		System.out.println("Pass legalImplies");
		return true;
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
	// checks if character is lowercase letter
	public boolean LegalLetter(char piece){
		if(Character.isLetter(piece) || Character.isLowerCase(piece)){
			return true;
		} else{
			return false;
		}
	}
}
