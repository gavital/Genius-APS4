/*******************************************************
 * Tela de ajuda explicando como se joga
 * 
 * - PRECISA IMPLEMENTAR TEXTO COM EXPLICAÇÃO
 *******************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaAjuda extends JFrame implements ActionListener {
	JButton voltar = new JButton();

	public TelaAjuda() {
		super("Ajuda");

		JFrame frameModuloJogo = new JFrame();
		frameModuloJogo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frameModuloJogo.setLocation(300, 200);
		frameModuloJogo.setSize(350, 350);
		frameModuloJogo.setResizable(false);
		frameModuloJogo.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {

	}

}
