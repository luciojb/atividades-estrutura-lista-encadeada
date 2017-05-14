package listas;

import nodos.Nodo;

public class ListaSimples {
	public Nodo inicio = null, fim = null, aux = null, anterior = null;
	
	public void inserirInicio(int num){
		Nodo novo = new Nodo();
		novo.num = num;
		
		if (inicio == null){
			//Vazia, inicio e fim recebem o elemento
			inicio = novo;
			fim = novo;
			novo.prox = null;
		} else {
			//A lista contém elementos, e o novo elemento será inserido no inicio da lista
			novo.prox = inicio;
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
			while(aux!=null){
				System.out.println("Num: "+aux.num+";\n");
				aux = aux.prox;
			}
		}
	}
	
	public void mostraListaRercursivo(Nodo inicio){
		if (inicio == null){
			System.out.println("Lista Vazia!");
		} else {
			System.out.println("Mostrando toda a lista ao contrário:\n");
			System.out.println(retornaListaRecursivo(inicio));
		}
	}
	
	private String retornaListaRecursivo(Nodo inicio){
		if (inicio == null){
			return "";
		} else {
			String mostraLista = ("Num = "+inicio.num+";\n");
			return retornaListaRecursivo(inicio.prox)+mostraLista;
		}
	}
	
	
	public void inserirFim(int num){
		Nodo novo = new Nodo();
		novo.num = num;
		
		if (inicio == null){
			//Vazia, inicio e fim recebem o elemento
			inicio = novo;
			fim = novo;
			novo.prox = null;
		} else {
			//A lista contém elementos, e o novo elemento será inserido no fim da lista
			fim.prox = novo;
			fim = novo;
			fim.prox = null;
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
	
	public String retornaPropriedadesLista(Nodo inicio, int valor){
		StringBuilder sb = new StringBuilder();
		 return sb.append(contarNodos(inicio))
		.append("Recursivo = ")
		.append(contarNodosRecursivo(inicio, 0))
		.append("\n")
		.append(retornaVezesPosicao(inicio, valor))
		.append(retornaMaiores(inicio, valor)).toString();
		
	}
	
	private String contarNodos(Nodo inicio){
		Nodo aux;
		int contador = 0;
		if(inicio != null){
			aux = inicio;
			contador++;
			while(aux.prox != null){
				aux = aux.prox;
				contador++;
			}
		}
		return ("Total de nodos na Lista: "+contador+"\n");
	}
	
	private int contarNodosRecursivo(Nodo inicio, int contador){		
		if (inicio == null)
			return contador;
		else{
			return contarNodosRecursivo(inicio.prox, ++contador);
		}
	}
	
	private String retornaVezesPosicao(Nodo inicio, int valor){
		StringBuilder sb = new StringBuilder();
		Nodo aux;
		int contador = 0, ocorrencias = 0;
		if(inicio != null){
			aux = inicio;
				
			do{
				if (aux.num == valor){
					sb.append("Posicao de ").append(aux.num).append(" = ").append(contador).append(" com index inicial = 0 (zero) ").append("\n");
					ocorrencias++;
				}
				contador++;
				aux = aux.prox;
			} while(aux != null);
		}
		sb.append("Total de ocorrencias = ").append(ocorrencias).append("\n");
		return sb.toString();
	}
	
	private String retornaMaiores(Nodo inicio, int valor){
		StringBuilder sb = new StringBuilder();
		Nodo aux;
		int ocorrencias = 0;
		if(inicio != null){
			aux = inicio;
			if (aux.num > valor)
				ocorrencias++;
				
			while(aux.prox != null){
				aux = aux.prox;
				if (aux.num > valor){
					ocorrencias++;
				}
			}
		}
		sb.append("Total de números maiores que ").append(valor).append(" = ").append(ocorrencias).append("\n");
		return sb.toString();
	}
	
	
	public ListaSimples uniao(ListaSimples cj1, ListaSimples cj2){
		ListaSimples resultado = new ListaSimples();
		Nodo aux = new Nodo();
		if (cj1.inicio != null){
			 aux = cj1.inicio;
			do{
				resultado.inserirFim(aux.num);
				aux = aux.prox;
			} while(aux != null);
		}
		aux =  new Nodo();
		if(cj2.inicio != null){
			aux = cj2.inicio;
			do{
				if (! estaNoPrimeiroConjunto(aux.num, resultado.inicio))
					resultado.inserirFim(aux.num);
				aux = aux.prox;
			} while(aux != null);
		}
		return resultado;
	}
	
	public ListaSimples interseccao(ListaSimples cj1, ListaSimples cj2){
		ListaSimples resultado = new ListaSimples();
		Nodo aux;
		if(cj2.inicio != null){
			aux = cj2.inicio;
			do{
				if (estaNoPrimeiroConjunto(aux.num, cj1.inicio) && ! estaNoPrimeiroConjunto(aux.num, resultado.inicio))
					resultado.inserirFim(aux.num);
				aux = aux.prox;
			} while(aux != null);
		}
		return resultado;
	}
	
	public ListaSimples diferenca(ListaSimples cj1, ListaSimples cj2){
		ListaSimples resultado = new ListaSimples();
		Nodo aux;
		if(cj1.inicio != null){
			aux = cj1.inicio;
			do{
				if (naoEstaNoSegundoConjunto(aux.num, cj2.inicio))
					resultado.inserirFim(aux.num);
				aux = aux.prox;
			} while(aux != null);
		}
		return resultado;
	}
	
	private boolean estaNoPrimeiroConjunto(int valor, Nodo inicioPrimeiroNodo){
		if(inicioPrimeiroNodo != null){
			Nodo aux = inicioPrimeiroNodo;
			do{
				if (aux.num == valor){
					return true;
				}
				aux = aux.prox;
			} while(aux != null);
		}
		return false;
	}
	
	private boolean naoEstaNoSegundoConjunto(int valor, Nodo inicioSegundoNodo){
		if(inicioSegundoNodo != null){
			Nodo aux = inicioSegundoNodo;
			do{
				if (aux.num == valor){
					return false;
				}
				aux = aux.prox;
			} while(aux != null);
		}
		return true;
	}
}
