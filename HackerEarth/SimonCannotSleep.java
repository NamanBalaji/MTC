package HackerEarth;

import java.util.Scanner;

public class SimonCannotSleep {

    public static void scs(String time){
        String splitTime[]=time.split(":");
        String hours=splitTime[0];
        String minutes=splitTime[1];
        System.out.println(calculateOverlap(Integer.parseInt(hours), Integer.parseInt(minutes)));
    }

    public static int calculateOverlap(int hours, int minutes) {
        if(hours == 0 && minutes == 0) {
            return 1;
        }
        int totalMins = (hours*60) + minutes;
        int sureOverlap = (totalMins/60) - 1;
        int extraMinutes = totalMins - hours*60;
        if(hours <=12){
            sureOverlap++;
        }
        if(extraMinutes > hours*5) {
            return sureOverlap + 1;
        } 
        return sureOverlap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();    
        scs(time);
        sc.close();
    }
}
