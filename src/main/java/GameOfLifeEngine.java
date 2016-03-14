
public class GameOfLifeEngine implements IEngine {

	private int[][] tab = new int [10][10];
	
	public GameOfLifeEngine(int[][] tab) {
		this.tab = tab;
	}
	
	public int getNeighbourhood(int i, int j) {
		int neighbours = 0;

		if (i == 0 && j == 0)
			neighbours = checkUpperLeft(i, j);
		else if (i == 9 && j == 0)
			neighbours = checkUpperRight(i, j);
		else if (i > 0 && j == 0)
			neighbours = checkUpperSection(i, j);
		else if (i == 0 && j == 9)
			neighbours = checkLowerLeft(i, j);
		else if (i == 9 && j < 9)
			neighbours = checkRightSection(i, j);
		else if (i == 0 && j < 9)
			neighbours = checkLeftSection(i, j);
		else if (i == 9 && j == 9) 
			neighbours = checkLowerRight(i,j);
		 else if (i > 0 && j == 9) 
			 neighbours = checkLowerSection(i, j);
		else 
			neighbours = checkCenter(i, j);
		
		return neighbours;
	}

	private int checkUpperLeft(int i, int j) {
		int neighbours = 0;
		if (tab[i + 1][j] == 1)
			neighbours++;
		if (tab[i + 1][j + 1] == 1)
			neighbours++;
		if (tab[i][j + 1] == 1)
			neighbours++;
		return neighbours;
	}

	private int checkUpperRight(int i, int j) {
		int neighbours = 0;
		if (tab[i][j + 1] == 1)
			neighbours++;
		if (tab[i - 1][j + 1] == 1)
			neighbours++;
		if (tab[i - 1][j] == 1)
			neighbours++;
		return neighbours;
	}

	private int checkUpperSection(int i, int j) {
		int neighbours = 0;
		if (tab[i - 1][j] == 1)
			neighbours++;
		if (tab[i + 1][j] == 1)
			neighbours++;
		if (tab[i - 1][j + 1] == 1)
			neighbours++;
		if (tab[i][j + 1] == 1)
			neighbours++;
		if (tab[i + 1][j + 1] == 1)
			neighbours++;
		return neighbours;
	}

	private int checkLowerLeft(int i, int j) {
		int neighbours = 0;
		if (tab[i][j - 1] == 1)
			neighbours++;
		if (tab[i + 1][j - 1] == 1)
			neighbours++;
		if (tab[i + 1][j] == 1)
			neighbours++;
		return neighbours;
	}

	private int checkRightSection(int i, int j) {
		int neighbours = 0;
		if (tab[i][j - 1] == 1)
			neighbours++;
		if (tab[i - 1][j - 1] == 1)
			neighbours++;
		if (tab[i - 1][j] == 1)
			neighbours++;
		if (tab[i - 1][j + 1] == 1)
			neighbours++;
		if (tab[i][j + 1] == 1)
			neighbours++;
		return neighbours;
	}

	private int checkLeftSection(int i, int j) {
		int neighbours = 0;
		if (tab[i][j - 1] == 1)
			neighbours++;
		if (tab[i + 1][j - 1] == 1)
			neighbours++;
		if (tab[i + 1][j] == 1)
			neighbours++;
		if (tab[i + 1][j + 1] == 1)
			neighbours++;
		if (tab[i][j + 1] == 1)
			neighbours++;
		return neighbours;
	}
	
	private int checkLowerRight(int i, int j) {
		int neighbours = 0;
		if (tab[i - 1][j - 1] == 1)
			neighbours++;
		if (tab[i][j - 1] == 1)
			neighbours++;
		if (tab[i - 1][j] == 1)
			neighbours++;
		return neighbours;
	}
	
	private int checkLowerSection(int i, int j) {
		int neighbours = 0;
		if (tab[i - 1][j - 1] == 1)
			neighbours++;
		if (tab[i][j - 1] == 1)
			neighbours++;
		if (tab[i + 1][j - 1] == 1)
			neighbours++;
		if (tab[i - 1][j] == 1)
			neighbours++;
		if (tab[i + 1][j] == 1)
			neighbours++;
		return neighbours;
	}
	
	private int checkCenter(int i, int j) {
		int neighbours = 0;
		if (tab[i - 1][j - 1] == 1)
			neighbours++;
		if (tab[i][j - 1] == 1)
			neighbours++;
		if (tab[i + 1][j - 1] == 1)
			neighbours++;
		if (tab[i - 1][j] == 1)
			neighbours++;
		if (tab[i + 1][j] == 1)
			neighbours++;
		if (tab[i - 1][j + 1] == 1)
			neighbours++;
		if (tab[i][j + 1] == 1)
			neighbours++;
		if (tab[i + 1][j + 1] == 1)
			neighbours++;
		return neighbours;
	}
	
}
