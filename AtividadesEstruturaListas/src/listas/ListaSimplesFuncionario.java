package listas;

import nodos.Funcionario;

public class ListaSimplesFuncionario {
private Funcionario inicio = null, fim = null, aux = null, anterior = null;
	
	public void inserirInicio(String nome, double salario){
		Funcionario novo = new Funcionario();
		novo.nome = nome;
		novo.salario = salario;
		
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
	
	public void inserirOrdenando(String nome, double salario){
		Funcionario novo = new Funcionario();
		novo.nome = nome;
		novo.salario = salario;
		if (inicio == null){
			//Vazia, inicio e fim recebem o elemento
			inicio = novo;
			fim = novo;
			novo.prox = null;
		} else {
			aux=inicio;
			if (novo.salario<inicio.salario){
				inserirInicio(novo.nome, novo.salario);
			} else if (novo.salario>fim.salario){
				inserirFim(novo.nome, novo.salario);
			} else {
				boolean encontrou = false;
				do{
					anterior = aux;
					aux = aux.prox;
					if (novo.salario<aux.salario){
						anterior.prox = novo;
						novo.prox = aux;
						encontrou = true;
					}
				
				}while(aux.prox != null && !encontrou);
			}
		}
	}
	
	public void mostraLista(){
		if (inicio == null){
			System.out.println("Lista Vazia!");
		} else {
			System.out.println("Mostrando toda a lista:");
			aux = inicio;
			while(aux!=null){
				System.out.println(aux.toString()+"\n");
				aux = aux.prox;
			}
		}
	}
	
	
	public void inserirFim(String nome, double salario){
		Funcionario novo = new Funcionario();
		novo.nome = nome;
		novo.salario = salario;
		
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
	
	private ListaSimplesFuncionario retornaMaiores(){
		ListaSimplesFuncionario maiores = new ListaSimplesFuncionario(); 
		if (inicio == null){
			return maiores;
		} else {
			aux = inicio;
			double maior = aux.salario;
			while (aux.prox != null){
				aux = aux.prox;
				if (aux.salario>maior){
					maior = aux.salario;
				}
			}
			aux = inicio;
			do{
				if (aux.salario==maior){
					maiores.inserirFim(aux.nome, aux.salario);
				}
				aux = aux.prox;
			}while (aux != null);
		}
		return maiores;
	}
	
	public void mostraMaiores(){
		ListaSimplesFuncionario maiores = retornaMaiores();
		aux = maiores.inicio;
		if (aux == null){
			System.out.println("Lista Vazia!");
		} else {
			System.out.println("Funcionarios com maior salario :");
			while(aux!=null){
				System.out.println(aux.toString()+"\n");
				aux = aux.prox;
			}
		}
	}
	
	public double mediaSalarial(){
		double soma = 0;
		if (inicio == null){
			return soma;
		} else {
			aux = inicio;
			
			while (aux.prox != null){
				soma+=aux.salario;
				aux = aux.prox;
				
			}
		}
		
		return soma/contarNodos();
	}
	
	public void retornaMaiores(double sal){
		int maiores = 0;
		if (inicio == null){
			System.out.println("Lista Vazia!!!");
		} else {
			aux = inicio;
			
			while (aux.prox != null){
				if (aux.salario>sal)
					maiores++;
				aux = aux.prox;
			}
			if (maiores == 0){
				System.out.println("Nenhum funcionario satisfez.");
			} else {
				System.out.println("Número de funcionarios com salario acima do valor passado ="+maiores);
			}
		}
	}
}
