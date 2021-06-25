package CtCi.Recursion_and_Dynamic_Programming;

public class PaintFill {
    public enum Color {
        BLACK, WHITE, RED, YELLOW, GREEN
    }

    public static String PrintColor(Color c) {
		switch(c) {
		case BLACK:
			return "B";
		case WHITE:
			return "W";
		case RED:
			return "R";
		case YELLOW:
			return "Y";
		case GREEN:
			return "G";
		}
		return "X";
	}
	
	public static void PrintScreen(Color[][] screen) {
		for (int r = 0; r < screen.length; r++) {
			for (int c = 0; c < screen[0].length; c++) {
				System.out.print(PrintColor(screen[r][c]));
			}
			System.out.println();
		}
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

    public static boolean paintFill(Color[][] screen, int x, int y, Color newColor) {
        if (screen == null || newColor == null || screen[y][x] == newColor) {
            return false;
        }
        return paintFillRecursive(screen, x, y, newColor, screen[y][x]);
    }

    private static boolean paintFillRecursive(Color[][] screen, int x, int y, Color newColor, Color oldColor) {
        if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) {
            return false;
        }

        if (screen[y][x] == oldColor) {
            screen[y][x] = newColor;
            paintFillRecursive(screen, x - 1, y, newColor, oldColor);
            paintFillRecursive(screen, x + 1, y, newColor, oldColor);
            paintFillRecursive(screen, x, y - 1, newColor, oldColor);
            paintFillRecursive(screen, x, y + 1, newColor, oldColor);
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 10;
		Color[][] screen = new Color[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				screen[i][j] = Color.BLACK;
			}			
		}
		for (int i = 0; i < 100; i++) {
			screen[randomInt(N)][randomInt(N)] = Color.GREEN;
		}
		PrintScreen(screen);
		paintFill(screen, 2, 2, Color.WHITE);
		System.out.println();
		PrintScreen(screen);
    }
}
