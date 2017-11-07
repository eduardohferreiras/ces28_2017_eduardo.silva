package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import presenter.IBoardView;
import presenter.Presenter;

public class ConsoleView implements IBoardView, Observer {
	
	private int[][] tabela;
	private String userInput = new String();
	int sizex = 0, sizey = 0;
	Scanner scanner = new Scanner(System.in);
	
	
	@Override
	public void update(Observable o, Object arg) {
		Presenter _p = (Presenter) o;
		_p.updateView(this);
		printTable();
	}
	
	private void printTable() {
		for(int i = 0; i < sizex; i++) {
			for(int j = 0; j < sizey; j++) {
				System.out.print(tabela[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
	
	Presenter _p;
	
	public String getUserInput()
	{
		return userInput;
	}

	public void setUserInput()
	{
		userInput = scanner.next();
	}
	
	@Override
	public void bindTo(Presenter p) {
		// TODO Auto-generated method stub
		_p = p;
	}

	@Override
	public void resizeBoardSizeInCellsTo(int xCells, int yCells) {
		sizex = xCells; sizey = yCells;
	}

	@Override
	public void changeCell(int x, int y, int state) {
		tabela[x][y] = state;
	}

	public void init()
	{
		tabela = new int[100][100];
		System.out.println("Welcome to the Okno console view!\n\nTo exit, type /exit;\nTo print next table, type /next.");
	}

	public void nextText() {
		_p.nextClicked();
		
	}
}
