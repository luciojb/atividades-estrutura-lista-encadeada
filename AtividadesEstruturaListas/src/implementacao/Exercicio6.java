package implementacao;

import listas.ListaDuplamenteEncadeada;

public class Exercicio6 {

	public static void main(String[] args) {
		ListaDuplamenteEncadeada l, l2;
		l= new ListaDuplamenteEncadeada();
		l2 = new ListaDuplamenteEncadeada();
		
		for (int i = 1; i<15; i++){
			l.inserirFim(i*2);
		}
		
		for (int i = 1; i<15; i++){
			l2.inserirFim(i*3);
		}
		
		System.out.println("Mostrando a primeira lista: \n");
		l.mostraLista();
		System.out.println("Mostrando a segunda lista: \n");
		l2.mostraLista();
		
		ListaDuplamenteEncadeada juncao = new ListaDuplamenteEncadeada();
		juncao.juntaOrdenaListas(l, l2);
		
		System.out.println("Mostrando Resultado, ordenado: \n");
		juncao.mostraLista();

	}

}
