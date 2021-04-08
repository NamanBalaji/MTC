package CtCi.Arrays_and_Strings;

public class URLify {
    public static String urlify(String s, int len){
        char[] trueString = s.toCharArray();
        int whiteSpaces = 0;
        int counter =0;

        for (int i=0; i<len; i++){
            if(trueString[i] == ' ') whiteSpaces++;
        }
        
        int URLength = (len + (whiteSpaces*3)) - whiteSpaces;
        char[] URL = new char[URLength];
        for (int i=0; i<len; i++){
            if(trueString[i]==' '){
                URL[counter] = '%';
                URL[counter+1] = '2';
                URL[counter+2] = '0';
                counter = counter+3;
            }
            else{
                URL[counter] = trueString[i];
                counter++;
            }
        }
        return String.valueOf(URL);
    }

    public static int findLastCharacter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				return i;
			}
		}
		return -1;
	}

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        int trueLength = findLastCharacter(str.toCharArray());
        String URL = urlify(str, trueLength+1);
        System.out.println(URL);
    }
}
