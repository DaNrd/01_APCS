public class Interface{
	public void extractFirstParen(String a){
		String retval = "";
		int openParen = -1;
		int closeParen = -1;
		for(int i=0; i<a.length(); i++){
			if(closeParen == -1 && a.charAt(i) == '('){
				openParen = i;
			} else if(openParen != -1 && a.charAt(i) == ')'){
				closeParen = i;
				break;
			}
		}
		for(int i=openParen+1; i<closeParen; i++){
			retval += a.charAt(i);
		}
		System.out.println(retval);
	}
	public void substituteAll(String a, String b, String c){
		String retval = "";
		int length = a.length();
		for(int i=0; i<length;){
			if(a.charAt(i) == b.charAt(0)){
				boolean same = true;
				for(int n=0; n<b.length(); n++){
					if(a.charAt(i+n) != b.charAt(n)){
						same = false;
						retval += a.charAt(i);
					}
				}
				if(same == true){
					retval += c;
					i+=2;
				}
			} else {
				retval += a.charAt(i);
			}
			i++;
		}
		System.out.println(retval);
	}
}
