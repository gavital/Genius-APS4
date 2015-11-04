/*******************************************************
 * Menu do módulo Repita a sequencia com tempo limitado
 *******************************************************/

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

public class SequenciaTempo extends JFrame implements ActionListener {
	// declarando as variaveis
	public JLabel jlSeqTempo;
	public JButton btTempo[] = new JButton[6];
	public JPanel jpTotalTempo, jpTituloTempo, jpCentroTempo;

	JFrame frameSeqTempo = new JFrame("Sequencia com tempo limitado");
	
	// construtor
	public SequenciaTempo() {
		super("Sequencia com tempo limitado");

		// configurando o frame
		frameSeqTempo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frameSeqTempo.setLocation(300, 200);
		frameSeqTempo.setSize(250, 360);
		frameSeqTempo.setResizable(false);
		frameSeqTempo.setVisible(true);

		// configurando layouts dos JPanels
		jpTotalTempo = new JPanel(new BorderLayout());
		jpTituloTempo = new JPanel(new FlowLayout());
		jpCentroTempo = new JPanel(new FlowLayout());
		
		// adicionando os JPanels
		frameSeqTempo.add(jpTotalTempo);
		jpTotalTempo.add(jpTituloTempo, BorderLayout.NORTH);
		jpTotalTempo.add(jpCentroTempo, BorderLayout.CENTER);

		jlSeqTempo = new JLabel("Escolha os segundos");
		jpTituloTempo.add(jlSeqTempo);

		// adicionando os botoes
		for (int cont = 1; cont < btTempo.length; cont++) {
			btTempo[cont] = new Botao();
			btTempo[cont].setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
			btTempo[cont].setPreferredSize(new Dimension(200, 50));
			jpCentroTempo.add(btTempo[cont]);
			btTempo[cont].addActionListener(this);
		}
		
		btTempo[5].setPreferredSize(new Dimension(80, 30));

		btTempo[1].setText("8 SEGUNDOS");
		btTempo[2].setText("14 SEGUNDOS");
		btTempo[3].setText("20 SEGUNDOS");
		btTempo[4].setText("31 SEGUNDOS");
		btTempo[5].setText("VOLTAR");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btTempo[1]) {
			// implementar new Jogo();
			//frameSeqTempo.dispose();
		}
		if (e.getSource() == btTempo[2]) {
			// implementar new Jogo();
			//frameSeqTempo.dispose();
		}
		if (e.getSource() == btTempo[3]) {
			// implementar new Jogo();
			//frameSeqTempo.dispose();
		}
		if (e.getSource() == btTempo[4]) {
			// implementar new Jogo();
			//frameSeqTempo.dispose();
		}
		if (e.getSource() == btTempo[5]){
			frameSeqTempo.dispose();
			new MenuModuloJogo();
		}
	}

}
