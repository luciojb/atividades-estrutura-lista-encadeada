package implementacao;

import listas.ListaSimples;

public class Exercicio1 {
	
	public static void main(String[] args){
		ListaSimples l = new ListaSimples();
		
		for (int i = 1; i<15; i++){
			l.inserirInicio(i*2);
		}
		
		l.inserirInicio(4);
		l.inserirInicio(4);
		l.inserirInicio(2);
		l.inserirInicio(2);
		
		l.mostraLista();
		
		System.out.println(l.retornaPropriedadesLista(l.inicio, 2));
	}
}
