package implementacao;

import listas.ListaDuplamenteEncadeadaCircular;

public class Exercicio8 {

	public static void main(String[] args) {
		ListaDuplamenteEncadeadaCircular l = new ListaDuplamenteEncadeadaCircular();
		
		for (int i = 1; i<10; i++){
			l.inserirInicio(i*2);
		}
		
		l.inserirQualquerPosicao(4, 3);
		l.inserirQualquerPosicao(4, 5);
		l.inserirQualquerPosicao(2, 7);
		
		l.mostraLista();
		
		
		
	}

}
