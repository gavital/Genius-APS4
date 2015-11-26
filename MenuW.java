import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextArea;

public class MenuW extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel telaMenuW;
	
	Panel moduloJogo, panelOpcoes;
	JButton btnJogar, btnOpes, btnRanking, btnAjuda, btnSair,
			btnRepitaASequncia, btnCrieSuaSequncia, btnSequnciaComTempo;
	private JTextField nomeJogador;
	private JButton btnVoltar;
	private Panel panelAjuda;
	private JPanel panel, modo1, modo2, modo3;
	private JLabel lbImgGenius;
	private JTabbedPane tPModos;
	private JButton btnVoltar_3;
	private JTable tabela1, tabela2, tabela3;
	private JPanel panelSeqTempoOp;
	private JButton btn8Seg;
	private JButton btn14Seg;
	private JButton btn20Seg;
	private JButton btn31Seg;
	private JButton btnVoltar_4;

	/**
	 * Criando o Frame
	 */
	public MenuW() {
		setTitle("GeniusGame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 355);
		telaMenuW = new JPanel();
		telaMenuW.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaMenuW);
		telaMenuW.setLayout(null);

		JLabel lblGeniusGame = new JLabel("Genius Game");
		lblGeniusGame.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		lblGeniusGame.setBounds(109, 11, 158, 34);
		telaMenuW.add(lblGeniusGame);
		
		
		// criando os botões do menu
		btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			// adicionando evento
			public void actionPerformed(ActionEvent e) {
				// ao clicar no botão JOGAR ele desativa os outros botões deixando ativo apenas o menu selecionado e a opção sair
				btnOpes.setEnabled(false);
				btnRanking.setEnabled(false);
				btnAjuda.setEnabled(false);
				
				// adiciona um novo JPanel com as funções do menu selecionado
				moduloJogo = new Panel();
				moduloJogo.setBounds(121, 75, 172, 160);
				telaMenuW.add(moduloJogo);
				moduloJogo.setLayout(null);
				
				// botões para selecionar módulo jogo
				btnRepitaASequncia = new JButton("Repita a Sequência");
				btnRepitaASequncia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				btnRepitaASequncia.setBounds(10, 11, 152, 23);
				moduloJogo.add(btnRepitaASequncia);

				btnCrieSuaSequncia = new JButton("Crie sua Sequência");
				btnCrieSuaSequncia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				btnCrieSuaSequncia.setBounds(10, 45, 152, 23);
				moduloJogo.add(btnCrieSuaSequncia);

				btnSequnciaComTempo = new JButton("Sequência com Tempo");
				/***********************************************************************
				 * pensar como tirar o panel com os módulos de jogo
				 * *********************************************************************
				btnSequnciaComTempo.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						panelSeqTempoOp = new JPanel();
						panelSeqTempoOp.setBounds(121, 64, 130, 211);
						telaMenuW.add(panelSeqTempoOp);
						panelSeqTempoOp.setLayout(null);
						
						btn8Seg = new JButton("8 Segundos");
						btn8Seg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
						btn8Seg.setBounds(10, 11, 105, 23);
						panelSeqTempoOp.add(btn8Seg);
						
						btn14Seg = new JButton("14 Segundos");
						btn14Seg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
						btn14Seg.setBounds(10, 45, 105, 23);
						panelSeqTempoOp.add(btn14Seg);
						
						btn20Seg = new JButton("20 Segundos");
						btn20Seg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
						btn20Seg.setBounds(10, 79, 105, 23);
						panelSeqTempoOp.add(btn20Seg);
						
						btn31Seg = new JButton("31 Segundos");
						btn31Seg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
						btn31Seg.setBounds(10, 113, 105, 23);
						panelSeqTempoOp.add(btn31Seg);
						
						btnVoltar_4 = new JButton("Voltar");
						btnVoltar_4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
							}
						});
						btnVoltar_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
						btnVoltar_4.setBounds(20, 160, 89, 23);
						panelSeqTempoOp.add(btnVoltar_4);
					}

					
				});
				************************************************************************/
				btnSequnciaComTempo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				btnSequnciaComTempo.setBounds(10, 79, 152, 23);
				moduloJogo.add(btnSequnciaComTempo);
				
				// botão para remover JPanel e ativar os botões desativados anteriormente
				btnVoltar = new JButton("Voltar");
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnOpes.setEnabled(true);
						btnRanking.setEnabled(true);
						btnAjuda.setEnabled(true);
						telaMenuW.remove(moduloJogo);
					}
				});
				btnVoltar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				btnVoltar.setBounds(40, 126, 89, 23);
				moduloJogo.add(btnVoltar);
			}
		});
		btnJogar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		btnJogar.setBounds(10, 76, 89, 23);
		telaMenuW.add(btnJogar);
		
		// botão para criar JPanel de opções
		btnOpes = new JButton("Opções");
		btnOpes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// desativa os outros botões
				btnJogar.setEnabled(false);
				btnRanking.setEnabled(false);
				btnAjuda.setEnabled(false);
				
				// adiciona JPanel de opções
				panelOpcoes = new Panel();
				panelOpcoes.setBounds(121, 75, 235, 194);
				telaMenuW.add(panelOpcoes);
				panelOpcoes.setLayout(null);
				
				// mudar nome do jogador
				JLabel lblPlayer = new JLabel("Player:");
				lblPlayer.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				lblPlayer.setBounds(10, 11, 40, 14);
				panelOpcoes.add(lblPlayer);
				
				nomeJogador = new JTextField();
				nomeJogador.setBounds(48, 8, 138, 20);
				panelOpcoes.add(nomeJogador);
				nomeJogador.setColumns(10);
				
				// ligar/desligar e mudar volume dos sons
				JLabel lblMsica = new JLabel("Sons");
				lblMsica.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				lblMsica.setBounds(10, 44, 40, 14);
				panelOpcoes.add(lblMsica);
				
				final JToggleButton tglbtnSom = new JToggleButton("Ligado");
				tglbtnSom.setSelected(true);
				tglbtnSom.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglbtnSom.isSelected()){
							tglbtnSom.setBackground(Color.lightGray);
							tglbtnSom.setForeground(Color.black);
							tglbtnSom.setText("Ligado");
						}else{
							tglbtnSom.setBackground(Color.darkGray);
							tglbtnSom.setForeground(Color.white);
							tglbtnSom.setText("Desligado");
						}
					}
				});
				tglbtnSom.setBounds(40, 57, 121, 23);
				panelOpcoes.add(tglbtnSom);
				
				JSlider slider = new JSlider();
				slider.setBounds(56, 103, 169, 14);
				panelOpcoes.add(slider);
				
				JLabel lblVolume = new JLabel("Volume");
				lblVolume.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				lblVolume.setBounds(10, 99, 46, 14);
				panelOpcoes.add(lblVolume);
				
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btnSalvar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				btnSalvar.setBounds(10, 143, 104, 23);
				panelOpcoes.add(btnSalvar);
				
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(8, 36, 220, 2);
				panelOpcoes.add(separator_1);
				
				JSeparator separator_2 = new JSeparator();
				separator_2.setBounds(8, 87, 220, 2);
				panelOpcoes.add(separator_2);
				
				JSeparator separator_3 = new JSeparator();
				separator_3.setBounds(8, 130, 220, 2);
				panelOpcoes.add(separator_3);
				
				// botão para remover JPanel e ativar os botões desativados anteriormente
				JButton btnVoltar_1 = new JButton("Voltar");				
				btnVoltar_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnJogar.setEnabled(true);
						btnRanking.setEnabled(true);
						btnAjuda.setEnabled(true);
						telaMenuW.remove(panelOpcoes);
					}
				});
				btnVoltar_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				btnVoltar_1.setBounds(136, 143, 89, 23);
				panelOpcoes.add(btnVoltar_1);
			}
		});
		btnOpes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		btnOpes.setBounds(10, 110, 89, 23);
		telaMenuW.add(btnOpes);
		
		// JPanel para ranking
		btnRanking = new JButton("Ranking");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// desativa os outros botões
				btnJogar.setEnabled(false);
				btnAjuda.setEnabled(false);
				btnOpes.setEnabled(false);
				
				// adiciona JPanel de ranking
				final JPanel panelRanking = new JPanel();
				panelRanking.setBounds(121, 56, 244, 259);
				telaMenuW.add(panelRanking);
				panelRanking.setLayout(null);
				
				// titulo
				JLabel lblRanking = new JLabel("Ranking");
				lblRanking.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
				lblRanking.setBounds(1, 1, 55, 14);
				panelRanking.add(lblRanking);
				
				// label para indicar tipo do jogo
				JLabel lblTipoDoJogo = new JLabel("Tipo do jogo");
				lblTipoDoJogo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				lblTipoDoJogo.setBounds(41, 26, 62, 14);
				panelRanking.add(lblTipoDoJogo);
				
				// alterar nome aqui conforme o modulo selecionado
				JLabel lblNomeTipoJogoMuda = new JLabel("TipoJogoNome");
				lblNomeTipoJogoMuda.setForeground(new Color(0, 0, 255));
				lblNomeTipoJogoMuda.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
				lblNomeTipoJogoMuda.setBounds(120, 26, 93, 14);
				panelRanking.add(lblNomeTipoJogoMuda);
				
				// separando as informações com uma linha
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(8, 45, 227, 2);
				panelRanking.add(separator_1);
				
				// label Jogador
				JLabel lblJogador = new JLabel("Jogador");
				lblJogador.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				lblJogador.setBounds(32, 62, 46, 14);
				panelRanking.add(lblJogador);
				
				// campo para exibir nome jogador
				JTextArea txtrJogador = new JTextArea();
				txtrJogador.setEditable(false);
				txtrJogador.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
				txtrJogador.setText("-----------");
				txtrJogador.setBounds(20, 79, 106, 19);
				panelRanking.add(txtrJogador);
				
				// labl pontuação
				JLabel lblPontuao = new JLabel("Pontuação");
				lblPontuao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				lblPontuao.setBounds(140, 62, 57, 14);
				panelRanking.add(lblPontuao);
				
				// campo para exibir pontuação do jogador
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setText("-------------");
				textArea_1.setEditable(false);
				textArea_1.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
				textArea_1.setBounds(137, 79, 76, 19);
				panelRanking.add(textArea_1);
				
				// label para exibir total tentativas
				JLabel lblTentativas = new JLabel("Total Tentativas");
				lblTentativas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				lblTentativas.setBounds(8, 109, 81, 14);
				panelRanking.add(lblTentativas);
				
				// campo para exibir total tentativas
				JTextArea txtNroTotTenta = new JTextArea();
				txtNroTotTenta.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
				txtNroTotTenta.setEditable(false);
				txtNroTotTenta.setText("---------------");
				txtNroTotTenta.setBounds(99, 104, 114, 19);
				panelRanking.add(txtNroTotTenta);
				
				// label para tentativas corretas
				JLabel lblCorretas = new JLabel("Corretas");
				lblCorretas.setForeground(new Color(0, 128, 0));
				lblCorretas.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
				lblCorretas.setBounds(64, 134, 54, 14);
				panelRanking.add(lblCorretas);
				
				// campo para exibir tentativas corretas
				JTextArea txtrNroTentaC = new JTextArea();
				txtrNroTentaC.setEditable(false);
				txtrNroTentaC.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
				txtrNroTentaC.setText("---------------");
				txtrNroTentaC.setBounds(120, 130, 114, 19);
				panelRanking.add(txtrNroTentaC);
				
				// label para tentativas erradas
				JLabel lblErradas = new JLabel("Erradas");
				lblErradas.setForeground(new Color(220, 20, 60));
				lblErradas.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
				lblErradas.setBounds(68, 159, 46, 14);
				panelRanking.add(lblErradas);
				
				// campo para exibir tentativas erradas
				JTextArea txtrNrotentae = new JTextArea();
				txtrNrotentae.setEditable(false);
				txtrNrotentae.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
				txtrNrotentae.setText("---------------");
				txtrNrotentae.setBounds(120, 155, 114, 19);
				panelRanking.add(txtrNrotentae);
				
				// botão para exibir resultado de outro jogador cadastrado
				JButton btnTrocarJogador = new JButton("Trocar Jogador");
				btnTrocarJogador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//se nao existe nenhum jogador cadastrado avisar que nao existe nenhum resultado ainda
						
					}
				});
				btnTrocarJogador.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				btnTrocarJogador.setBounds(11, 191, 108, 23);
				panelRanking.add(btnTrocarJogador);
				
				// alterar tipo do jogo pra ver o resultado especifico
				JButton btnMdulos = new JButton("Tipo Jogo");
				btnMdulos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				btnMdulos.setBounds(124, 191, 89, 23);
				panelRanking.add(btnMdulos);
				
				// botão para remover JPanel e ativar os botões desativados anteriormente
				btnVoltar_3 = new JButton("Voltar");
				btnVoltar_3.setBounds(88, 225, 69, 23);
				panelRanking.add(btnVoltar_3);
				btnVoltar_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnJogar.setEnabled(true);
						btnAjuda.setEnabled(true);
						btnOpes.setEnabled(true);
						telaMenuW.remove(panelRanking);
					}
				});
				btnVoltar_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				
				
				/************************************************************************
				 * lixo que nao funciona.
				 * **********************************************************************
				final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBounds(117, 51, 200, 184);
				telaMenuW.add(tabbedPane);
				tabela1 = new JTable();
				tabela2 = new JTable();
				tabela3 = new JTable();
				
				JPanel pnModo1 = new JPanel();
				pnModo1.setLayout(null);
				pnModo1.add(tabela1);
				
				JPanel pnModo2 = new JPanel();
				pnModo2.setLayout(null);
				pnModo2.add(tabela2);
				
				JPanel pnModo3 = new JPanel();
				pnModo3.setLayout(null);
				pnModo3.add(tabela3);		
				
				tabbedPane.addTab("Modo 1", pnModo1);		
				tabbedPane.addTab("Modo 2", pnModo2);		
				tabbedPane.addTab("Modo 3", pnModo3);
				**************************************************************************/
			}
		});
		btnRanking.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		btnRanking.setBounds(10, 144, 89, 23);
		telaMenuW.add(btnRanking);
		
		// JPanel para ajuda
		btnAjuda = new JButton("Ajuda");
		btnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// desativa os outros botões
				btnJogar.setEnabled(false);
				btnRanking.setEnabled(false);
				btnOpes.setEnabled(false);
				
				// adiciona JPanel de ajuda
				panelAjuda = new Panel();
				panelAjuda.setBounds(117, 76, 238, 230);
				telaMenuW.add(panelAjuda);
				panelAjuda.setLayout(null);
				
				// texto para ajuda
				JTextPane textoAjuda = new JTextPane();
				textoAjuda.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				textoAjuda.setBackground(UIManager.getColor("Panel.background"));
				textoAjuda.setText("O objetivo no jogo é acompanhar e usando o mouse, repetir sem errar a sequência de luzes e sons durante o tempo que puder... Se você puder, é claro... :)");
				textoAjuda.setBounds(0, 0, 238, 62);
				panelAjuda.add(textoAjuda);
				
				JTextPane txtpnRepitaASeq = new JTextPane();
				txtpnRepitaASeq.setBackground(UIManager.getColor("Panel.background"));
				txtpnRepitaASeq.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
				txtpnRepitaASeq.setText("Repita a sequência");
				txtpnRepitaASeq.setBounds(0, 65, 116, 20);
				panelAjuda.add(txtpnRepitaASeq);
				
				JTextPane txtpnRepSeqExplicacao = new JTextPane();
				txtpnRepSeqExplicacao.setBackground(UIManager.getColor("Panel.background"));
				txtpnRepSeqExplicacao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				txtpnRepSeqExplicacao.setText("Tente repetir a sequência criada pelo jogo");
				txtpnRepSeqExplicacao.setBounds(10, 80, 218, 20);
				panelAjuda.add(txtpnRepSeqExplicacao);
				
				JTextPane txtpnCrieSuaSeq = new JTextPane();
				txtpnCrieSuaSeq.setText("Crie sua sequência");
				txtpnCrieSuaSeq.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
				txtpnCrieSuaSeq.setBackground(SystemColor.menu);
				txtpnCrieSuaSeq.setBounds(0, 108, 128, 20);
				panelAjuda.add(txtpnCrieSuaSeq);
				
				JTextPane txtpnCrieSeqExplicacao = new JTextPane();
				txtpnCrieSeqExplicacao.setText("Crie uma sequência e tente repeti-la");
				txtpnCrieSeqExplicacao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				txtpnCrieSeqExplicacao.setBackground(SystemColor.menu);
				txtpnCrieSeqExplicacao.setBounds(10, 123, 218, 20);
				panelAjuda.add(txtpnCrieSeqExplicacao);
				
				JTextPane txtpnSeqComTempo = new JTextPane();
				txtpnSeqComTempo.setText("Sequência com Tempo");
				txtpnSeqComTempo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
				txtpnSeqComTempo.setBackground(SystemColor.menu);
				txtpnSeqComTempo.setBounds(0, 150, 134, 20);
				panelAjuda.add(txtpnSeqComTempo);
				
				JTextPane txtpnSeqTempExplicacao = new JTextPane();
				txtpnSeqTempExplicacao.setText("Pense rápido pois você tem um tempo para jogar.");
				txtpnSeqTempExplicacao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				txtpnSeqTempExplicacao.setBackground(SystemColor.menu);
				txtpnSeqTempExplicacao.setBounds(10, 167, 218, 34);
				panelAjuda.add(txtpnSeqTempExplicacao);
				
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(39, 104, 141, 2);
				panelAjuda.add(separator_1);
				
				JSeparator separator_2 = new JSeparator();
				separator_2.setBounds(39, 146, 141, 2);
				panelAjuda.add(separator_2);
				
				// botão para remover JPanel e ativar os botões desativados anteriormente
				JButton btnVoltar_2 = new JButton("Voltar");
				btnVoltar_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnJogar.setEnabled(true);
						btnRanking.setEnabled(true);
						btnOpes.setEnabled(true);
						telaMenuW.remove(panelAjuda);
					}
				});
				btnVoltar_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
				btnVoltar_2.setBounds(120, 200, 89, 23);
				panelAjuda.add(btnVoltar_2);
			}
		});
		btnAjuda.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		btnAjuda.setBounds(10, 178, 89, 23);
		telaMenuW.add(btnAjuda);
		
		// botao para fechar o frame e sair
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// fechando a aplicação
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		btnSair.setBounds(10, 212, 89, 23);
		telaMenuW.add(btnSair);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(109, 70, 2, 205);
		telaMenuW.add(separator);
	}
	
	/**
	 * Iniciando a aplicação
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuW frame = new MenuW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
