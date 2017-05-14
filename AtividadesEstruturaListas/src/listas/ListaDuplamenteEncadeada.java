package listas;


import nodos.NodoDuplo;

public class ListaDuplamenteEncadeada {
	private NodoDuplo inicio = null, fim = null, aux = null;
	
	public void inserirInicio(int num){
		NodoDuplo novo = new NodoDuplo();
		novo.num = num;
		
		if (inicio == null){
			//Vazia, inicio e fim recebem o elemento
			inicio = novo;
			fim = novo;
			novo.prox = null;
			novo.ant = null;
		} else {
			//A lista contém elementos, e o novo elemento será inserido no inicio da lista
			novo.prox = inicio;
			inicio.ant=novo;
			novo.ant=null;
			inicio = novo;
		}
		System.out.println("Valor inserido com sucesso! ");
	}
	
	public void mostraLista(){
		if (inicio == null){
			System.out.println("Lista Vazia!");
		} else {
			System.out.println("Mostrando toda a lista:");
			aux = inicio;
			while(aux != null){
				System.out.println("Num: "+aux.num+";\n");
				aux =  aux.prox;
			}
		}
	}
	
	public void inserirFim(int num){
		NodoDuplo novo = new NodoDuplo();
		novo.num = num;
		
		if (inicio == null){
			//Vazia, inicio e fim recebem o elemento
			inicio = novo;
			fim = novo;
			novo.prox = null;
			novo.ant = null;
		} else {
			//A lista contém elementos, e o novo elemento será inserido no fim da lista
			fim.prox = novo;
			novo.ant = fim;
			novo.prox = null;
			fim = novo;
		}
		System.out.println("Iserido com sucesso!!");
	}
	
	//Lembrando que se tem index 0
	public void inserirOrdenando(int num){
		NodoDuplo nd = new NodoDuplo();
		nd.num = num;
		if (inicio == null){
			//Vazia, inicio e fim recebem o elemento
			inicio = nd;
			fim = nd;
			nd.prox = null;
			nd.ant = null;
		} else {
			nd.prox = null;
			nd.ant = null;
			aux=inicio;
			if (nd.num<inicio.num){
				inserirInicio(nd.num);
			} else if (nd.num>fim.num){
				inserirFim(nd.num);
			} else {
				boolean encontrou = false;
				do{
					aux = aux.prox;
					if (nd.num<aux.num){
						nd.ant = aux.ant;
						aux.ant.prox = nd;
						nd.prox = aux;
						aux.ant = nd;
						encontrou = true;
					}
				
				}while(aux.prox != null && !encontrou);
			}
		}
	}
		
	public void juntaOrdenaListas(ListaDuplamenteEncadeada l1, ListaDuplamenteEncadeada l2){
		
		NodoDuplo aux = new NodoDuplo();
		if (l1.inicio != null){
			 aux = l1.inicio;
			do{
				inserirFim(aux.num);
				aux = aux.prox;
			} while(aux != null);
		}
		if(l2.inicio != null){
			aux = l2.inicio;
			do{
				inserirOrdenando(aux.num);
				aux = aux.prox;
			}while(aux != null);
		}
	}
	
	public void removerNodo(int num){
		int ocorrencias = 0;
		if(inicio == null){
			System.out.println("Lista Vazia");
		} else {
			aux = inicio;
			while (aux != null) {
				if (aux.num == num){
					ocorrencias++;
					if(aux == inicio){
						inicio =  aux.prox;
						if(inicio != null){
							inicio.ant = null;
						}
						inicio.ant = null;
						aux = inicio;
					} else if(aux == fim){
						fim = fim.ant;
						fim.prox = null;
						aux = null;
					} else {
						aux.ant.prox = aux.prox;
						aux.prox.ant = aux.ant;
						aux.ant = null;
						aux =  aux.prox;
					}
				} else {
					aux = aux.prox;
				}
			}
		}
		if (ocorrencias == 0){
			System.out.println("Número não encontrado.");
		} else {
			System.out.println("Removidos "+ocorrencias+" números "+num+".");
		}
	}
	
	public String calculaMaiorMenor(){
		NodoDuplo aux;
		int menor, maior, soma = 0, contador = 0;
		if(inicio != null){
			aux = inicio;
			menor = inicio.num;
			maior = inicio.num;
			while(aux != null){
				if (aux.num > maior)
					maior = aux.num;
				else if (aux.num < menor)
					menor = aux.num;
				soma+=aux.num;
				aux = aux.prox;
				contador++;
			}
			return ("Maior = "+maior+" e menor = "+menor+";\n"
					+"Média = "+soma/contador);
		}
		return ("Lista vazia");
	}
	
	public boolean saoListasIdenticas(ListaDuplamenteEncadeada l1, ListaDuplamenteEncadeada l2){
		
		NodoDuplo aux1 = l1.inicio;
		NodoDuplo aux2 = l2.inicio;
		try{
			do {
				if (aux1.num != aux2.num){
					return false;
				} 
				aux1 = aux1.prox;
				aux2 = aux2.prox;
			}while(aux1 != null || aux2 != null);
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}
}