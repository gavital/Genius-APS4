/**************************************
 * Menu para escolha do módulo do jogo
 **************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MenuModuloJogo extends JFrame implements ActionListener {

	// declaração de variaveis
	public JLabel jlDificuldade;
	public JButton btModulos[] = new JButton[5];
	public JPanel jpTotalModulo, jpTituloModulo, jpCentroModulo;

	// criando o frame para o menu
	JFrame frameModuloJogo = new JFrame("Level");

	// método construtor;
	public MenuModuloJogo() {

		// titulo janela
		super("Dificuldade");

		// configurando o frame
		frameModuloJogo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frameModuloJogo.setLocation(300, 200);
		frameModuloJogo.setSize(250, 320);
		frameModuloJogo.setResizable(false);
		frameModuloJogo.setVisible(true);

		// configurando layouts dos JPanels
		jpTotalModulo = new JPanel(new BorderLayout());
		jpTituloModulo = new JPanel(new FlowLayout());
		jpCentroModulo = new JPanel(new FlowLayout());

		frameModuloJogo.add(jpTotalModulo);
		jpTotalModulo.add(jpTituloModulo, BorderLayout.NORTH);
		jpTotalModulo.add(jpCentroModulo, BorderLayout.CENTER);

		jlDificuldade = new JLabel("Escolha o jogo");
		jpTituloModulo.add(jlDificuldade);

		for (int cont = 1; cont < btModulos.length; cont++) {
			btModulos[cont] = new Botao();
			btModulos[cont].setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
			btModulos[cont].setPreferredSize(new Dimension(220, 60));
			jpCentroModulo.add(btModulos[cont]);
			btModulos[cont].addActionListener(this);
		}
		
		btModulos[4].setPreferredSize(new Dimension(80, 30));

		btModulos[1].setText("REPITA A SEQUÊNCIA");
		btModulos[2].setText("CRIE SUA PRÓPRIA SEQUÊNCIA");
		btModulos[3].setText("SEQUÊNCIA COM TEMPO LIMITADO");
		btModulos[4].setText("VOLTAR");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btModulos[1]) {
			// implementar new Jogo();
			// frameModuloJogo.dispose();
		}
		if (e.getSource() == btModulos[2]) {
			// implementar new Jogo();
			// frameModuloJogo.dispose();
		}
		if (e.getSource() == btModulos[3]) {
			frameModuloJogo.dispose();
			new SequenciaTempo();
		}
		if (e.getSource() == btModulos[4]){
			frameModuloJogo.dispose();
			new Menu();
		}
	}

}
