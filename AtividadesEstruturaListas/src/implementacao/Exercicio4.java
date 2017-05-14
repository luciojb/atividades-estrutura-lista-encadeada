package implementacao;

import listas.ListaSimples;

public class Exercicio4 {

	public static void main(String[] args) {
		ListaSimples l, l2;
		l= new ListaSimples();
		l2 = new ListaSimples();
		
		for (int i = 1; i<15; i++){
			l.inserirInicio(i*2);
		}
		
		l.inserirInicio(6);
		
		for (int i = 1; i<15; i++){
			l2.inserirFim(i*3);
		}
		
		l2.inserirInicio(6);
		
		System.out.println("Mostrando o primeiro conjunto: \n");
		l.mostraLista();
		System.out.println("Mostrando o segundo conjunto: \n");
		l2.mostraLista();
		
		ListaSimples uniao = l.uniao(l, l2);
		ListaSimples interseccao = l.interseccao(l, l2);
		ListaSimples diferenca= l.diferenca(l, l2);
		
		System.out.println("Mostrando a uniao entre os dois conjuntos: \n");
		uniao.mostraLista();
		
		System.out.println("Mostrando a interseccao entre os dois conjuntos: \n");
		interseccao.mostraLista();
		
		System.out.println("Mostrando a diferenca entre os dois conjuntos: \n");
		diferenca.mostraLista();

		

	}

}
