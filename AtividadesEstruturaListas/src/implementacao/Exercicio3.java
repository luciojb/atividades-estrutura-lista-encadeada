package implementacao;

import listas.ListaDuplamenteEncadeada;

public class Exercicio3 {

	public static void main(String[] args) {
		ListaDuplamenteEncadeada l = new ListaDuplamenteEncadeada();
		
		for (int i = 1; i<15; i++){
			l.inserirInicio(i<<2*2);
		}
		
		
		l.mostraLista();
		
		System.out.println(l.calculaMaiorMenor());
	}
}
