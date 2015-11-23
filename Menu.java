/***************************************************
 * Classe do menu principal do jogo
 * Função: 
 * 1) Integrar todas as janelas
 * 2) Implementar tela do menu com as opções:
 * 	- Jogar
 * 	- Opções
 * 	- Ranking
 * 	- Ajuda
 * 
 * PRECISA IMPLEMENTAR PANIC MODE
 ***************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Menu extends JFrame implements ActionListener {

	// declaração de variaveis
	private static final long serialVersionUID = 1L;
	private JPanel jpTotalMenu, jpCentralMenu, jpLateral, jpLateral2, jpTopMenu;
	private JLabel jlNome, jlRodape;
	private Botao[] botao = new Botao[7];

	// criando o frame para o menu
	public JFrame frameMenu = new JFrame("Menu");

	// método construtor;
	public Menu() {

		// titulo
		super("Tela Menu");

		// configurando o frame
		frameMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frameMenu.setLocation(150, 150);
		frameMenu.setSize(240, 390);
		frameMenu.setResizable(false);
		frameMenu.setVisible(true);

		// configurando layouts dos JPanels
		jpTotalMenu = new JPanel(new BorderLayout());
		jpCentralMenu = new JPanel(new FlowLayout());
		jpLateral = new JPanel(new GridLayout(4, 1)); // tirar
		jpLateral2 = new JPanel(new GridLayout(4, 1)); // tirar
		jpTopMenu = new JPanel(new FlowLayout());

		// adicionando JPanels no frame
		frameMenu.add(jpTotalMenu);
		jpTotalMenu.add(jpCentralMenu, BorderLayout.CENTER);
		jpTotalMenu.add(jpLateral, BorderLayout.EAST);
		jpTotalMenu.add(jpLateral2, BorderLayout.WEST);
		jpTotalMenu.add(jpTopMenu, BorderLayout.NORTH);

		// area NORTH do frameMenu
		jlNome = new JLabel("GENIUS - APS 4o SEMESTRE");
		jpTopMenu.add(jlNome);
		jlNome.setHorizontalAlignment(SwingConstants.CENTER);

		// area CENTER do frameMenu
		// adicionando os botões do menu
		for (int cont = 1; cont < botao.length; cont++) {
			botao[cont] = new Botao();
			botao[cont].setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
			botao[cont].setPreferredSize(new Dimension(120, 50));
			jpCentralMenu.add(botao[cont]);
			botao[cont].addActionListener(this);
		}

		// colocando nome nos botões
		botao[1].setText("JOGAR");
		botao[2].setText("OPÇÕES");
		botao[3].setText("RANKING");
		botao[4].setText("AJUDA");
		botao[5].setText("SAIR");

		// panic button - tem que arrumar
		botao[6].setBorder(null);
		botao[6].setPreferredSize(new Dimension(3, 80));
		jpLateral2.add(botao[6]);

		// rodape
		jlRodape = new JLabel("Have fun =)");
		jpTotalMenu.add(jlRodape, BorderLayout.SOUTH);
		jlRodape.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botao[1]) {
			new MenuModuloJogo();
			frameMenu.dispose();
		}
		if (e.getSource() == botao[2]) {
			new Opcoes();
			frameMenu.dispose();
		}
		if (e.getSource() == botao[3]) {
			new Ranking();
			frameMenu.dispose();
		}
		if (e.getSource() == botao[4]) {
			new TelaAjuda();
			frameMenu.dispose();
		}
		if (e.getSource() == botao[5]) {
			System.exit(0);
		}
		if (e.getSource() == botao[6]) {
		}
	}
}