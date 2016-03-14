import java.util.Scanner;

public class GameOfLife {

	private int[][] tab = new int[10][10];
	private Scanner scanner = new Scanner(System.in);
	private IEngine engine = new GameOfLifeEngine(tab);

	public void getPresetCells() {
		int amountOfInputs = scanner.nextInt();

		for (int i = 0; i < amountOfInputs; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			tab[x][y] = 1;
		}
	}

	private void setTab(int[][] tab, int i, int j) {
		tab[i][j] = 1;
	}

	private void unsetTab(int[][] tab, int i, int j) {
		tab[i][j] = 0;
	}

	public void getTab(int[][] tab) {
		this.tab = tab;
	}

	public int[][] live() {
		int[][] newTab = new int[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int neighbours = engine.getNeighbourhood(i, j);
				if (neighbours < 2)
					unsetTab(newTab, i, j);
				else if ((neighbours == 2 || neighbours == 3) && tab[i][j] == 1)
					setTab(newTab, i, j);
				else if (neighbours > 3 && tab[i][j] == 1)
					unsetTab(newTab, i, j);
				else if (neighbours == 3 && tab[i][j] == 0)
					setTab(newTab, i, j);

			}
		}
		return newTab;
	}

	@Override
	public String toString() {
		String result = "";

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				result += tab[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}

	public static void main(String[] args) {
		GameOfLife gol = new GameOfLife();
		gol.getPresetCells();
		Scanner scanner = new Scanner(System.in);
		System.out.println(gol.toString());
		String exit = "";
		
		while (!exit.equals("Exit")) {
			gol.getTab(gol.live());
			System.out.println(gol.toString());
			exit = scanner.next();
		}
		
		scanner.close();
	}

}
