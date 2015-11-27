package geniusGame;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Renderer extends JPanel {

    // componente que pinta tela de uma vez...
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);

        if (TelaJogo.telaJogo != null) {
        	TelaJogo.telaJogo.paint((Graphics2D) g);
        }
    }

}
