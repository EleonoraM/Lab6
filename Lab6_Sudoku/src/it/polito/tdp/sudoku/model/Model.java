package it.polito.tdp.sudoku.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	private List<Cella> celle;

	private int[][] matrix;

	public void solveSudoku() {
		celle = new LinkedList<>();

		int contatore = 0;
		// trasformare ogni cella [i][j] in un oggetto cella
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Cella c = new Cella(i, j, matrix[i][j], contatore);
				contatore++;
				celle.add(c);
			}
		}
		// System.out.println(celle);
		recursiveSolution(0, celle);

	}

	private List<Cella> celleSoluzione;

	private void recursiveSolution(int i, List<Cella> celle2) {
		if (i == 81) {
			this.celleSoluzione = new LinkedList<>();
			int cod=0;
			for(Cella c: celle2) {
				this.celleSoluzione.add(new Cella(c.getRiga(),c.colonna,c.getNumero(), cod++));
			}
			return;
		}
		Cella c = celle2.get(i);
		
		// SOLO SE IL NUMERO DELLA CELLA STEP-ESIMA==0
		if (c.getNumero() == 0) {
			for (int j = 1; j <= 9; j++) {
				if (numeroLecito(j, celle2, i)) {
					// IMPOSTA UN NUMERO DA 1 A 9 NELLA CELLA STEP-ESIMA,E LO
					// RIMPIAZZA NELLA LISTA DELLE CELLE
					c.setNumero(j);
					// NON SERVE // celle2.set(i, c);
					// RICHIAMO RICORSIONE
					recursiveSolution(i + 1, celle2);
					// BACKTRACKING
					// MEGLIO COME SOTTO: // celle2.get(i).setNumero(0);
					c.setNumero(0);
				}
			}
		} else {
			// poiché c.getNumero() != 0, in questa posizione NON devo fare ricerca, passo subito alla successiva
			recursiveSolution(i+1, celle2);
		}
	}

	private boolean numeroLecito(int j, List<Cella> celle2, int i) {
		// se sulla riga di celle2 non c e un altro numero uguale
		Cella attuale = celle2.get(i);
		for (Cella c : celle2) {
			if (!attuale.equals(c) && c.getNumero() != 0) {
				if (c.getRiga() == attuale.getRiga()) {
					if (c.getNumero() == j )
						return false;
				}
				if (c.getColonna() == attuale.getColonna()) {
					if (c.getNumero() == j )
						return false;
				}
				if (attuale.stessoQuadrato(c) && c.getNumero() == j)
					return false;
				// se sulla colonna di celle2 non c e un altro numero uguale
				// se nel quadrato di celle2 non c e un altro numero uguale

			}
		}
		return true;
	}

	public void setMatrix(int[][] board) {
		this.matrix = board;
	}

	public List<Cella> getCelle() {

		return celleSoluzione;
	}

}
