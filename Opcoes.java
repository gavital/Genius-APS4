/**********************
 * Menu opções do jogo
 **********************/

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class Opcoes extends JFrame implements ActionListener {

	// declaração de variaveis
	private static final long serialVersionUID = 1L;
	private JPanel jpTotal, jpSalvar, jpQuadrantes, jpVolume, jpSliderVolume, jpNome;
	private JLabel jlVolume, jlSliderVolume, jlNome, jlOpcoes, jlStatus;
	private JTextField tfNome;
	private JSlider slider;
	private JRadioButton radonVol, radoffVol;
	private ButtonGroup groupVol;
	private JButton botao, btSalvar, btCancelar;

	JFrame frame = new JFrame("Opcoes");

	// construtor
	public Opcoes() {

		super("Tela de Opcoes");

		// configurando o frame
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 250);
		frame.setResizable(false);
		frame.setVisible(true);

		// configurando layouts dos JPanels
		jpTotal = new JPanel(new BorderLayout());
		jpQuadrantes = new JPanel(new GridLayout(2, 2, 3, 3));
		jpVolume = new JPanel(new GridLayout(3, 1));
		jpSliderVolume = new JPanel(new FlowLayout());
		jpNome = new JPanel(new GridLayout(3, 1));
		jpSalvar = new JPanel(new GridLayout(1, 2));

		// JPanel NORTH e SOUTH
		jlOpcoes = new JLabel("Opções do jogo");
		jlOpcoes.setHorizontalAlignment(SwingConstants.CENTER);
		btCancelar = new JButton("CANCELAR");
		btSalvar = new JButton("SALVAR E SAIR");
		btCancelar.addActionListener(this);

		// Nome
		botao = new JButton();
		botao.setText("ALTERAR NOME");
		jlNome = new JLabel("Nome do jogador : ");
		jlNome.setHorizontalAlignment(SwingConstants.CENTER);
		tfNome = new JTextField("");
		jpNome.add(jlNome);
		jpNome.add(tfNome);
		jpNome.add(botao);
		botao.addActionListener(this);

		// configuração volume
		jlVolume = new JLabel(" Som do jogo : ");
		radonVol = new JRadioButton("Ligado", true);
		radoffVol = new JRadioButton("Desligado");

		groupVol = new ButtonGroup();
		groupVol.add(radonVol);
		groupVol.add(radoffVol);
		jpVolume.add(jlVolume);
		jpVolume.add(radonVol);
		jpVolume.add(radoffVol);

		radonVol.addActionListener(this);
		radoffVol.addActionListener(this);

		jlVolume.setHorizontalAlignment(SwingConstants.CENTER);
		radonVol.setHorizontalAlignment(SwingConstants.CENTER);
		radoffVol.setHorizontalAlignment(SwingConstants.CENTER);

		// JSlider
		jlStatus = new JLabel("Volume : 50", JLabel.CENTER);
		jlSliderVolume = new JLabel("Volume : ");
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		jpSliderVolume.add(jlSliderVolume);
		jpSliderVolume.add(slider);
		jpSliderVolume.add(jlStatus);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jlStatus.setText("Volume : " + ((JSlider) e.getSource()).getValue());
			}
		});

		// adicionando os JPanels
		frame.add(jpTotal);
		jpTotal.add(jpQuadrantes, BorderLayout.CENTER);
		jpTotal.add(jlOpcoes, BorderLayout.NORTH);
		jpTotal.add(jpSalvar, BorderLayout.SOUTH);
		jpQuadrantes.add(jpNome);
		jpQuadrantes.add(jpVolume);
		jpQuadrantes.add(jpSliderVolume);
		jpSalvar.add(btSalvar);
		jpSalvar.add(btCancelar);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btCancelar) {
			frame.dispose();
			new Menu();
		}
		if (e.getSource() == botao) {
			jlNome.setText("NOME DO JOGADOR : " + tfNome.getText());
		}
		if (e.getSource() == radonVol) {
			jpSliderVolume.setVisible(true);
		}
		if (e.getSource() == radoffVol) {
			jpSliderVolume.setVisible(false);
		}

	}
}