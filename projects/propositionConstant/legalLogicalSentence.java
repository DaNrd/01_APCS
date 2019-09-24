public IsLegal(String sentence0){
	String sentance1 = "";
	for (int i = 0; i < sentance0.length(); i++){
	    if(Character.isWhitespace(sentance0.charAt(i) == true){
				return false;
			} else {
				sentance1 += sentance0.charAt(i);
			}
			return sentance1;
	  }
	IsLowercase(sentence0);
}

public IsLowercase(String sentence1){
	var first = sentance1.charAt(0);
	if (first === first.toLowerCase() && first !== first.toUpperCase())
	{
	  IsSimple(sentence1)
	}
} else {
	return false;
}

public IsSimple(String sentence1){
	if(sentance1.length == 1){
		return true;
	} else {
		IsComplex(sentence1)
	}
}
