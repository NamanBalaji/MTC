package CtCi.Arrays_and_Strings;

public class OneAway {
    public static boolean oneAway(String s1, String s2){
        if(Math.abs(s1.length()-s2.length())>1) return false;
        boolean isChanged = false;
        for(int i=0, j=0; i<s1.length()&&j<s2.length(); i++, j++){
            if(s1.charAt(i)!=s2.charAt(j)){
                if(isChanged) return false;

                if(s1.length()<s2.length()){
                    j--;
                }
                else if(s1.length()>s2.length()){
                    i--;
                }
                isChanged = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "pae";
		String b = "pale";
		boolean isOneEdit = oneAway(a, b);
		System.out.println(a + ", " + b + ": " + isOneEdit);
    }
}
