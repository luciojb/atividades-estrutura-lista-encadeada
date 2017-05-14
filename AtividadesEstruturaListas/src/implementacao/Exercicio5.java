package implementacao;

import listas.ListaSimples;

public class Exercicio5 {

	public static void main(String[] args) {
		ListaSimples l = new ListaSimples();
		
		for (int i = 1; i<15; i++){
			l.inserirFim(i*2);
		}
		
		l.mostraLista();
		
		l.mostraListaRercursivo(l.inicio);

	}
}
