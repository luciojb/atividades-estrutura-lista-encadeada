package implementacao;

import listas.ListaSimplesFuncionario;

public class Exercicio9 {

	public static void main(String[] args) {
		ListaSimplesFuncionario l = new ListaSimplesFuncionario();
		
		for (int i = 1; i<9; i++){
			l.inserirOrdenando("Nome"+i, i<<2+4<<2);
		}
		
		l.inserirOrdenando("Mateus", 1243.32);
		l.inserirOrdenando("Lucio", 1543.32);
		
		l.mostraLista();
		
		l.mostraMaiores(); 

	}

}
