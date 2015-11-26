package geniusGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.crypto.AEADBadTagException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

// não deixa a aplicação criar exceptions do tipo "serial"
@SuppressWarnings("serial")
public class TelaJogo extends JFrame implements ActionListener, MouseListener {

    public static TelaJogo telaJogo;

    public static Opcoes opcoes;

    public Renderer renderer;

    public static final int WIDTH = 800, HEIGHT = 800;

    //public String RIGHT = "", WRONG = "";

    public int flashed = 0, dark, ticks, indexPattern, trys, rights, wrongs;

    public boolean creatingPattern = true;

    public ArrayList<Integer> pattern;

    public Random random;

    private boolean gameOver;

    private Sound sound;

    JFrame frame = new JFrame("TelaJogo");

    public TelaJogo() {

        // Timer com delay de 2 segundos
        Timer timer = new Timer(20, this);

        renderer = new Renderer();
        sound = new Sound();

        // tamanho do frame: 808x830
        frame.setSize(WIDTH + 8, HEIGHT + 30);
        // a tela está visivel
        frame.setVisible(true);
        // adiciona o componente que "escuta" o mouse
        frame.addMouseListener(this);
        // não deixa a tela reenderizar
        frame.setResizable(false);
        // adiciona o componente que vai "pintar" a aplicação na tela
        frame.add(renderer);
        // operação padrão de sair
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Opcoes.radonVol.setSelected(true);

        // inicializa as variaveis do sistema tudo de uma vez
        start();

        // inicializa o timer
        timer.start();

        /*if (opcoes.radonVol.isSelected()) {
            RIGHT = "beep-08";
            WRONG = "beep-10";
        }*/

    }

    // inicializa as variaveis do sistema
    public void start() {
        // gerador de numeros aleatorios
        random = new Random();
        // Lista dos botões da tela
        pattern = new ArrayList<Integer>();
        // Identificador do botão
        indexPattern = 0;
        // apaga
        dark = 2;
        // acende
        flashed = 0;
        ticks = 0;
        // Tentativas
        trys = 0;
        // Acertos
        rights = 0;
        // Erros
        wrongs = 0;

    }

    public static void main(String[] args) {
        telaJogo = new TelaJogo();
    }

    // executa as ações da aplicação
    public void actionPerformed(ActionEvent e) {
        ticks++;

        if (ticks % 20 == 0) {
            // não acende nenhum
            flashed = 0;

            if (dark >= 0) {
                dark--;
            }
        }

        // verifica se é para criar o visual
        if (creatingPattern) {
            // verifica se escuro for menor ou igual a zero
            if (dark <= 0) {
                // verifica se o index do botão é maior ou igual ao tamanho da
                // lista de botões
                if (indexPattern >= pattern.size()) {
                    // acende recebe um numero aleatorio de 0 a 3
                    flashed = random.nextInt(40) % 4 + 1;
                    // lista adiciona qual botão deve acender
                    pattern.add(flashed);
                    // zera o index
                    indexPattern = 0;
                    // e não cria o visual
                    creatingPattern = false;
                } else {
                    // senão acende recebe o valor da lista que tem a posição
                    // index
                    flashed = pattern.get(indexPattern);
                    indexPattern++;
                }
                // apaga todos
                dark = 2;
            }
            // senão se index for igual ao tamanho da lista
        } else if (indexPattern == pattern.size()) {
            // cria um visual
            creatingPattern = true;
            // zera o index
            indexPattern = 0;
            // e apaga todos
            dark = 2;
        }

        renderer.repaint();
    }

    // comandos para pintar a tela
    public void paint(Graphics2D g) {
        // Define o valor de uma única preferência para os algoritmos de
        // processamento.
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // verifica se é para acender o botão 1
        if (flashed == 1) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.GREEN.darker());

        }

        // preenche o primeiro desenho especificado
        // que no caso é a cor verde escuro
        g.fillRect(0, 0, WIDTH / 2, HEIGHT / 2);

        // verifica se é para acender o botão 2
        if (flashed == 2) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.RED.darker());
        }

        // preenche o segundo desenho especificado
        // que no caso é a cor vermelho escuro
        g.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT / 2);

        // verifica se é para acender o botão 3
        if (flashed == 3) {
            g.setColor(Color.ORANGE);
        } else {
            g.setColor(Color.ORANGE.darker());
        }

        // preenche o terceiro desenho especificado
        // que no caso é a cor amarelo escuro
        g.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

        // verifica se é para acender o botão 4
        if (flashed == 4) {
            g.setColor(Color.BLUE);
        } else {
            g.setColor(Color.BLUE.darker());
        }

        // preenche o quarto desenho especificado
        // que no caso é a cor azul escuro
        g.fillRect(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

        g.setColor(Color.BLACK);
        // Preenche o retângulo de cantos arredondados especificado com a cor
        // atual (preto).
        g.fillRoundRect(220, 220, 350, 350, 300, 300);
        g.fillRect(WIDTH / 2 - WIDTH / 12, 0, WIDTH / 7, HEIGHT);
        g.fillRect(0, WIDTH / 2 - WIDTH / 12, WIDTH, HEIGHT / 7);

        g.setColor(Color.GRAY);
        g.setStroke(new BasicStroke(200));
        // Desenha o contorno de um oval com a cor atual (cinza)
        g.drawOval(-100, -100, WIDTH + 200, HEIGHT + 200);

        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(10));
        g.drawOval(0, 0, WIDTH, HEIGHT);

        // Setam cor e fonte (Branco e arial)
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", 1, 120));

        // se for fim de jogo
        if (gameOver) {
            // ele desenha a string "Wrong" nas coodernadas dadas.
            g.drawString("Wrong!", WIDTH / 2 - 200, HEIGHT / 2 + 42);
        } else {
            // senão ele desenha
            // "quantos botoes foram clicados / quantos botões tem que clicar"
            g.drawString(indexPattern + "/" + pattern.size(), WIDTH / 2 - 100, HEIGHT / 2 + 42);
        }

        /*
         * g.setColor(Color.WHITE); g.setFont(new Font("Arial", 1, 90));
         * g.drawString("Tentativas: " + trys, WIDTH / 2 - 201, HEIGHT / 2 +
         * 200); g.drawString("Acertos: " + rights, WIDTH / 2 - 202, HEIGHT / 2
         * + 200); g.drawString("Erros: " + wrongs, WIDTH / 2 - 203, HEIGHT / 2
         * + 200);
         */
        
        /*g.setColor(Color.WHITE);
        g.fillRect(WIDTH - 90, HEIGHT - 130, WIDTH/6, HEIGHT/6);*/
    }


    // Ao click do mouse
    public void mousePressed(MouseEvent e) {
        // x recebe a posição x do click do mouse na tela
        int x = e.getX();
        // y recebe a posição y do click do mouse na tela
        int y = e.getY();

        try {
        // se não for pra criar visual e não for fim de jogo
        if (!creatingPattern && !gameOver) {
            // se x for maior que zero e for menor que metade da largura
            // e y for maior que zero e for menor que metade da altura
            if (x > 0 && x < WIDTH / 2 && y > 0 && y < HEIGHT / 2) {
                // acende a luz do botão 1
                flashed = 1;
                ticks = 1;
                sound.play("beep-08");
            } else if (x > WIDTH / 2 && x < WIDTH && y > 0 && y < HEIGHT / 2) {
                // acende a luz do botão 2
                flashed = 2;
                ticks = 1;
                sound.play("beep-08");
            } else if (x > 0 && x < WIDTH / 2 && y > HEIGHT / 2 && y < HEIGHT) {
                // acende a luz do botão 3
                flashed = 3;
                ticks = 1;
                sound.play("beep-08");
            } else if (x > WIDTH / 2 && x < WIDTH && y > HEIGHT / 2 && y < HEIGHT) {
                // acende a luz do botão 4
                flashed = 4;
                ticks = 1;
                sound.play("beep-08");
            }

            // se for diferente de zero
            if (flashed != 0) {
                // lista na posição do index for igual a acende
                if (pattern.get(indexPattern) == flashed) {
                    indexPattern++;
                } else {
                    // senão fim de jogo
                    gameOver = true;
                    sound.play("beep-10");
                }
            }
            // se for fim de jogo
        } else if (gameOver) {
            // inicialisa as variaveis
            start();
            gameOver = false;
        }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Erro: " + exception.toString());
        }

    }

    public void mouseClicked(MouseEvent event) {
    	
    }

    public void mouseEntered(MouseEvent event) {
    	
    }

    public void mouseExited(MouseEvent arg0) {

    }

    public void mouseReleased(MouseEvent event) {
    	
    	/*int x = event.getX();
    	int y = event.getY();
    	
    	if(x > 0 && x < WIDTH - 90 && y > 0 && y < HEIGHT - 110){
    		Panico panico = new Panico();
    	}*/

    }

}
