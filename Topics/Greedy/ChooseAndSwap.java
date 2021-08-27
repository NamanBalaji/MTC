package Topics.Greedy;

public class ChooseAndSwap {
    public static String modString(String str){
        int[] indexMap = new int[123];
        int i = 0;
        int j = 0;
        for(i = 0; i<123; i++){
            indexMap[i] = -1;
        }
        int n = str.length();
        for(i=0; i<n;i++){
            if(indexMap[str.charAt(i)] == -1){
                indexMap[str.charAt(i)]  = i;
            }
        }

        boolean flag = false;
        for(i=0; i<n; i++){
            for(j = 97; j<str.charAt(i); j++){
                if(indexMap[j]>indexMap[str.charAt(i)]){
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }

        char c1 = str.charAt(i);
        char c2 = (char)j;

        String res = "";
        for(i = 0; i<n; i++){
            if(str.charAt(i) == c1){
                res += c2;
            } else if(str.charAt(i) == c2){
                res += c1;
            } else{
                res += str.charAt(i);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        String q = "ccad";
        System.out.println(modString(q));
    }
}
