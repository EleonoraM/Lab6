package it.polito.tdp.sudoku.model;

public class Cella {
int riga;
int colonna;
int numero;
int codice;

public Cella(int riga, int colonna, int numero, int codice) {
	this.riga = riga;
	this.colonna = colonna;
	this.numero = numero;
	this.codice = codice;
}

public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}

public int getRiga() {
	return riga;
}

public int getColonna() {
	return colonna;
}

@Override
public String toString() {
	return "Cella numero " +codice+", riga "+riga +", colonna "+ colonna + ", numero=" + numero+"\n" ;
}

public boolean stessaRiga (Cella altra){
	if ( this.riga==altra.getRiga())
		return true;
	return false;
}
public boolean stessaColonna (Cella altra){
	if ( this.colonna==altra.getColonna())
		return true;
	return false;
}
public boolean stessoQuadrato (Cella altra){
	if (this.riga<=2 && altra.riga<=2){
		if ((this.colonna<=2&&altra.colonna<=2)||
				((this.colonna>2&&this.colonna<=5)&&(altra.colonna>2&&altra.colonna<=5))||
				((this.colonna>5 &&this.colonna<=8)&&(altra.colonna>5&&altra.colonna<=8)))
			return true;
	}
		if(this.riga>2&&this.riga<=5&& altra.riga>2&&altra.riga<=5){
			if ((this.colonna<=2&&altra.colonna<=2)||
					((this.colonna>2&&this.colonna<=5)&&(altra.colonna>2&&altra.colonna<=5))||
					((this.colonna>5 &&this.colonna<=8)&&(altra.colonna>5&&altra.colonna<=8)))
				return true;
			}

			if (this.riga>5&&this.riga<=8&&altra.riga>5&&altra.riga<=8){
				if ((this.colonna<=2&&altra.colonna<=2)||
						((this.colonna>2&&this.colonna<=5)&&(altra.colonna>2&&altra.colonna<=5))||
						((this.colonna>5&&this.colonna<=8)&&(altra.colonna>5&&altra.colonna<=8)))
					return true;
				}
			return false;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + codice;
	result = prime * result + colonna;
	result = prime * result + numero;
	result = prime * result + riga;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cella other = (Cella) obj;
	if (codice != other.codice)
		return false;
	if (colonna != other.colonna)
		return false;
	if (numero != other.numero)
		return false;
	if (riga != other.riga)
		return false;
	return true;
}

}
