package CtCi.Recursion_and_Dynamic_Programming;

public class BooleanEvaluation {
    public static int booleanEvaluation(String expression, boolean result) {
        String operand = "";
        String operator = "";
        for(int index = 0; index < expression.length(); index ++){
            if(index%2  == 0) operand += expression.charAt(index);
            else operator += expression.charAt(index);
        }

        System.out.println(operand);
        System.out.println(operator);
        int n = operand.length();
        int[][] dp1 = new int[n][n];
        int[][] dp0 = new int[n][n];

        for(int g=0; g<n; g++){
            for(int i=0, j=g; j<n; i++, j++){
                if(g==0) {
                    char ch = operand.charAt(i);
                    if(ch == '1'){
                        dp1[i][j] = 1;
                        dp0[i][j] = 0;
                    } else{
                        dp1[i][j] = 0;
                        dp0[i][j] = 1;
                    }
                } else {
                    for(int k = 0; k < j; k++){
                        char op = operator.charAt(k);
                        int l1c =  dp1[i][k];
                        int r1c = dp1[k+1][j];
                        int l0c =  dp0[i][k];
                        int r0c = dp0[k+1][j];
                        
                        if(op  == '&'){
                            dp1[i][j] += l1c*r1c;
                            dp0[i][j] += l0c*r1c + l1c*r0c + l0c*r0c;
                        } else if(op == '|'){
                            dp1[i][j] += l1c*r1c + l0c*r1c + l1c*r0c;
                            dp0[i][j] += l0c*r0c;
                        } else{
                            dp1[i][j] += l1c*r0c + l0c*r1c;
                            dp0[i][j] += l0c*r0c + l1c*r1c;
                        }
                    }
                }
            }
        }
        if(result) return dp1[0][n-1];
        return dp0[0][n-1];
    }
    public static void main(String[] args) {
        System.out.format("# of ways to parenthesize %s to be %s = %d\n", "0&0&0&1^1|0", true, booleanEvaluation("0&0&0&1^1|0", true));
    }
}
