package listas;

import nodos.NodoDuplo;

public class ListaDuplamenteEncadeadaCircular {
	private NodoDuplo inicio = null, fim = null, aux = null;
	
	public void inserirInicio(int num){
		NodoDuplo novo = new NodoDuplo();
		novo.num = num;
		
		if (inicio == null){
			//Vazia, inicio e fim recebem o elemento
			inicio = novo;
			fim = novo;
			fim.prox = inicio;
			fim.ant = inicio;
			inicio.ant = inicio;
			inicio.prox = inicio;
		} else {
			//A lista contém elementos, e o novo elemento será inserido no inicio da lista
			novo.prox = inicio;
			inicio.ant = novo;
			novo.ant = fim;
			inicio = novo;
			fim.prox = inicio;
		}
		System.out.println("Valor inserido com sucesso! ");
	}
	
	public void mostraLista(){
		if (inicio == null){
			System.out.println("Lista Vazia!");
		} else {
			System.out.println("Mostrando toda a lista:");
			aux = inicio;
			do{
				System.out.println("Num: "+aux.num+";\n");
				aux = aux.prox;
			}while(aux != inicio);
		}
	}
	
	
	public void inserirFim(int num){
		NodoDuplo novo = new NodoDuplo();
		novo.num = num;
		
		if (inicio == null){
			//Vazia, inicio e fim recebem o elemento
			inicio = novo;
			fim = novo;
			fim.prox = inicio;
			fim.ant = inicio;
			inicio.ant = inicio;
			inicio.prox = inicio;
		} else {
			//A lista contém elementos, e o novo elemento será inserido no fim da lista
			
			fim.prox = novo;
			fim.prox.ant = fim; 
			fim = novo;
			fim.prox = inicio;
			inicio.ant = fim;
		}
	}
	
	public void inserirQualquerPosicao(int num, int pos){
		NodoDuplo aux;
		int contador = 0;
		if (pos<contarNodos()){
			if(inicio == null || pos==0){
				inserirInicio(num);
			} else if (pos == contarNodos()-1){
				inserirFim(num);
			} else {
				aux = inicio;
				while(aux.prox != inicio && contador!=pos){
					aux = aux.prox;
					contador++;
					if (contador==pos){
						NodoDuplo nd = new NodoDuplo();
						nd.num = num;
						nd.ant = aux.ant;
						aux.ant.prox = nd;
						nd.prox = aux;
						aux.ant = nd;
					}
				}
			}
		} else {
			System.out.println("Index inválido.");
		}
	}
	
	public void removerNodo(int num){
		int ocorrencias = 0;
		int tamanho = contarNodos();
		int percorrido = 0;
		if(inicio == null){
			System.out.println("Lista Vazia");
		} else {
			aux = inicio;
			do {
				percorrido++;
				if (aux.num == num){
					ocorrencias++;
					if (inicio == fim){
						inicio = null;
						fim = null;
					}
					if(aux == inicio){
						inicio = aux.prox;
						inicio.ant = fim;
						fim.prox = inicio;
						aux = aux.prox;
					} else if(aux == fim){
						fim = fim.ant;
						fim.prox = inicio;
						inicio.ant = fim;
					} else {
						aux.ant.prox = aux.prox;
						aux.prox.ant = aux.ant;
						aux.ant = null;
						aux =  aux.prox;
					}
				} else {
					aux = aux.prox;
				}
			}while (percorrido<=tamanho);
		}
		if (ocorrencias == 0){
			System.out.println("Número não encontrado.");
		} else {
			System.out.println("Removidos "+ocorrencias+" números "+num+".");
		}
	}
	
	public int retornaMaiorNodo(){
		int maiorNodo=0;
		if (inicio != null){
			aux = inicio;
			maiorNodo=aux.num;
			do{
				if (aux.num>maiorNodo){
					maiorNodo = aux.num;
				}
				aux = aux.prox;
			}while(aux != inicio);
		}
		return maiorNodo;
	}
	
	public int contarNodos(){
		int ocorrencias = 0;
		if(inicio != null){
			aux = inicio;
			ocorrencias++;
			while(aux.prox != inicio){
				aux = aux.prox;
				ocorrencias++;
			}
		}
		return ocorrencias;
	}
	
}
