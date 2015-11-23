import java.util.ArrayList;
import java.util.Random;

public class ModulosJogo {
	public int cont = 0;
	public int contRJ = 0;
	public boolean acertou = true;
	public int vetAux[];
	public int vetCorR[];
	ArrayList<Integer> vetRepSeq = new ArrayList<Integer>();
	ArrayList<Integer> vetJogador = new ArrayList<Integer>();
	public static Random gerador = new Random();

	public ModulosJogo(int tamanhoVet) {
		//
		vetAux = new int[tamanhoVet];
		vetCorR = new int[tamanhoVet];
	}

	// caso jogador escolha modo repita a sequencia, usar arraylist (nao tem tamanho definido)
	public ModulosJogo() {
	}

	// a cada jogada, chamar esse metodo para armazenar a sequencia apertada pelo jogador
	public void jogada(int corR) {
		if (acertou == true) {
			vetCorR[contRJ] = corR;
			contRJ++;
		} else {
			contRJ = 0;
		}

	}

	// a cada jogada, chamar esse método para comparar se a sequencia do jogador é igual
	public void comparaJogada(int corR, int corP) {
		if (vetCorR[cont] == vetAux[cont]) {
			jogada(geraJogada());
		} else {
			acertou = false;
			cont = 0;
			// criar metodo novoJogo()
		}
		cont++;
	}

	public void comparaJogadaArray(int corR, int corP) {
		if (vetJogador.get(cont) == vetRepSeq.get(cont)) {
			jogada(geraJogada());
		} else {
			acertou = false;
			cont = 0;
			// criar metodo novoJogo();
		}
	}

	public void exibeVetor() {
		for (int i = 0; i < vetCorR.length; i++) {
			System.out.println(vetCorR[i]);
		}
	}

	public void exibeVetorArray() {
		for (int i = 0; i < vetRepSeq.size(); i++) {
			System.out.println(vetRepSeq.get(i));
		}
	}

	// gera uma nova cor aleatoria
	public int geraJogada() {
		int jogada = gerador.nextInt(3);
		return jogada;
	}

}
