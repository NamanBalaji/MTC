package Topics.Greedy;

public class DieHard {
    static int fire = 0; 
    static int water = 1; 
    static int air = 2;

    static int maxSurvival = 0;

    public static int survivalTime(int health, int armor){
        if(health <=0 || armor <=0) return 0;
        helper(health, armor, 0, 0);
        helper(health, armor, 1, 0);
        helper(health, armor, 2, 0);
        return maxSurvival;
    }

    public static void helper(int health, int armor, int region, int time){
        if(health <=0 || armor <= 0){
            maxSurvival  = Math.max(maxSurvival, time-1);   
            return;
        }

        if(region == 1){
            health -= 5;
            armor -= 10; 
            helper(health, armor, 2, time++);
            helper(health, armor, 0, time++);
        } else if(region == 2){
            health += 3;
            armor  += 2;
            helper(health, armor, 0, time++);
            helper(health, armor, 1, time++);
        } else{
            health -= 20;
            armor += 5; 
            helper(health, armor, 1, time++);
            helper(health, armor, 2, time++);
        }
    }

    public static void main(String[] args) {
        System.out.println(survivalTime(20, 8));
    }
}
