package CtCi.Arrays_and_Strings;

class StringCompression{
    public static int countCompress(String str){
        int countConsecutive = 0;
        int countCompression = 0;
        for(int i=0; i<str.length(); i++){
            countConsecutive++;
            if(i+1>=str.length() || str.charAt(i)!= str.charAt(i+1)){
                countCompression = 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return countCompression;
    }

    public static String compress(String str){
        int finalLength = countCompress(str);
        if(finalLength>=str.length()) return str;
        int countConsecutive = 0;
        StringBuffer compressedString = new StringBuffer(finalLength);
        for(int i=0; i<str.length(); i++){
            countConsecutive++;
            if(i+1>=str.length() || str.charAt(i)!= str.charAt(i+1)){
               compressedString.append(str.charAt(i));
               compressedString.append(countConsecutive);
               countConsecutive = 0;
            }
        }
        return compressedString.toString();
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
		System.out.println(str);
		System.out.println(compress(str));
    }
}