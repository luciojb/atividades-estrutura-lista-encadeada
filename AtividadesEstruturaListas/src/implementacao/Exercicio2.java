package implementacao;

import listas.ListaCircularProduto;

public class Exercicio2 {
	
	public static void main(String[] args){
		ListaCircularProduto l = new ListaCircularProduto();
		
		for (int i = 1; i<15; i++){
			l.inserirInicio(i, i*10 + i*3, i*121<<2);
		}
		
		l.mostraLista();
		l.aplicaDesconto(20);
		System.out.println("\nLista depois dos descontos: \n");
		l.mostraLista();
		l.mostraEstoque();
		
	}
	
}
