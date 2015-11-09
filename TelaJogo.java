import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.sun.glass.events.MouseEvent;
import com.sun.prism.Image;

public class TelaJogo extends JFrame implements ActionListener {
	Botao[] botoes = new Botao[4];
	int vetAux[] = new int[8];
	int vetCorR[] = new int[8];
	public static JPanel jogo;
	public static Random gerador = new Random();

	JFrame frameJogo = new JFrame();

	public TelaJogo() {

		frameJogo.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frameJogo.setLocation(150, 150);
		frameJogo.setSize(240, 390);
		frameJogo.setResizable(false);
		frameJogo.setVisible(true);

		jogo = new JPanel(new FlowLayout());
		frameJogo.add(jogo);

		for (int cont = 0; cont < botoes.length; cont++) {
			botoes[cont] = new Botao();
			botoes[cont].setBorder(new LineBorder(Color.LIGHT_GRAY));
			botoes[cont].setPreferredSize(new Dimension(120, 50));
			jogo.add(botoes[cont]);
			botoes[cont].addActionListener(this);
		}

		botoes[0].setText("Azul");
		botoes[0].setBackground(Color.BLUE);
		botoes[0].setForeground(Color.WHITE);
		botoes[1].setText("Vermelho");
		botoes[1].setBackground(Color.RED);
		botoes[2].setText("Verde");
		botoes[2].setBackground(Color.GREEN);
		botoes[3].setText("Amarelo");
		botoes[3].setBackground(Color.yellow);
	}

	public void Jogada(int corR) {
		int contRJ = 0;
		vetCorR[contRJ] = corR;
		contRJ++;
	}

	public void ComparaJogada(int corR, int corP) {
		int cont = 0;
		boolean acertou = true;
		if (vetCorR[cont] == vetAux[cont]) {
			Jogada(GeraJogada());
		}else{
			acertou = false;
			// criar metodo NovoJogo()
		}
		cont++;
	}

	public int GeraJogada() {
		int jogada = gerador.nextInt(3);
		return jogada;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botoes[0]) {
			botoes[0].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					botoes[0].setBackground(Color.black);
				}

				public void mouseReleased(MouseEvent e) {
					botoes[0].setBackground(Color.blue);
				}
			});
			Jogada(0);
		}
		if(e.getSource() == botoes[1]){
			// mudar icone/botao ao clicar
			Jogada(1);
		}
		if(e.getSource() == botoes[2]){
			// mudar icone/botao ao clicar
			Jogada(2);
		}
		if(e.getSource() == botoes[3]){
			// mudar icone/botao ao clicar
			Jogada(3);
		}
	}

	public static void main(String[] args) {
		new TelaJogo();
	}
}
