package CtCi.Recursion_and_Dynamic_Programming.TowerOfHanoi;

public class TowerOfHanoi {
    public static void moveDisks(int n, Tower origin, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, origin, buffer, destination);
            moveTop(origin, destination);
            moveDisks(n - 1, buffer, destination, origin);
        }
    }

    /* We teach it how to move 1 disk. Therefore it can recursively move n disks */
    private static void moveTop(Tower origin, Tower destination) {
        Integer disk = origin.pop();
        destination.push(disk);
        System.out.println("Move disk " + disk + " from Tower " + origin.towerNum + " to Tower " + destination.towerNum);
    }

    public static void main(String[] args) {
        int numTowers = 3;
        int numDisks = 4; // can make this bigger
        Tower[] towers = new Tower[numTowers];
        for (int i = 0; i < numTowers; i++) {
            towers[i] = new Tower(i); // don't forget. We have to do this too!
        }
        for (int i = numDisks; i > 0; i--) {
            towers[0].push(i);
        }
        moveDisks(numDisks, towers[0], towers[2], towers[1]);
    }
}
