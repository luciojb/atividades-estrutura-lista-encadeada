package listas;

import nodos.Produto;

public class ListaCircularProduto {
	public Produto inicio = null, fim = null, aux = null, anterior = null;
	
	public void inserirInicio(int cod, int qnt, double preco){
		Produto prod = new Produto();
		prod.cod = cod;
		prod.quantidade = qnt;
		prod.preco = preco;
		
		if (inicio == null){
			//Vazia, inicio e fim recebem o elemento
			inicio = prod;
			fim = prod;
			fim.prox = inicio;
		} else {
			//A lista contém elementos, e o novo elemento será inserido no inicio da lista
			prod.prox = inicio;
			inicio = prod;
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
				System.out.println(aux.toString()+"\n");
				aux = aux.prox;
			}while(aux != inicio);
		}
	}
	
	
	public void inserirFim(int cod, int qnt, double preco){
		Produto prod = new Produto();
		prod.cod = cod;
		prod.quantidade = qnt;
		prod.preco = preco;
		
		if (inicio == null){
			//Vazia, inicio e fim recebem o elemento
			inicio = prod;
			fim = prod;
			fim.prox = inicio;
		} else {
			//A lista contém elementos, e o novo elemento será inserido no fim da lista
			
			fim.prox = prod;
			fim = prod;
			fim.prox = inicio;
		}
	}
	
	public void removerNodo(int cod){
		int ocorrencias = 0;
		if(inicio == null){
			System.out.println("Lista Vazia");
		} else {
			aux = inicio;
			anterior = null;
			do {
				if (aux.cod == cod){
					ocorrencias++;
					if (inicio == fim){
						inicio = null;
					}
					if(aux == inicio){
						inicio = aux.prox;
						fim.prox = inicio;
						aux = inicio;
					} else if(aux == fim){
						fim = anterior;
						fim.prox = inicio;
						aux = inicio;
					} else {
						anterior.prox = aux.prox;
						aux = aux.prox;
					}
				} else {
					anterior = aux;
					aux = aux.prox;
				}
			}while (aux != inicio);
		}
		if (ocorrencias == 0){
			System.out.println("Produto não encontrado.");
		} else {
			System.out.println("Removidos "+ocorrencias+" produtos de codigo "+cod+".");
		}
	}
	
	public int contarNodos(){
		int ocorrencias = 0;
		if(inicio != null){
			aux = inicio;
			ocorrencias++;
			while(aux.prox != null){
				aux = aux.prox;
				ocorrencias++;
			}
		}
		return ocorrencias;
	}
	
	public int calculaAltura(int posicao){
		int indice = 0;
		if(inicio != null){
			aux= inicio;
			while(aux.prox != null && indice != posicao){
				aux = aux.prox;
				indice++;
			}
		}
		int tamanho = contarNodos()-indice;
		return tamanho<0?0:tamanho;
	}
	
	public void aplicaDesconto(double porcentagem){
		if(inicio != null){
			aux = inicio;
			do {
				aux.preco*=(1-porcentagem/100);
				aux = aux.prox;
			}while(aux != inicio && aux != null);
		}		
		aux = null;
	}
	
	public void mostraEstoque(){
		if (inicio != null){
			StringBuilder sb = new StringBuilder();
			System.out.println("Mostrando o estoque dos produtos com quantidade maior que 100 da lista:");
			aux = inicio;
			do{
				if (aux.quantidade>100){
					sb.append("Cod = ").append(aux.cod).append(" e quantidade =").append(aux.quantidade).append("\n");
				}
				aux = aux.prox;
			}while(aux != inicio);
			System.out.println(sb.toString());
		} else {
			System.out.println("Não há estoque para mostrar! ");
		}
	}
}
