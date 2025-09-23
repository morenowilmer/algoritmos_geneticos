package laberinto.ventana;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelLaberinto extends JPanel {
    
    private int[][] matrizResultante;
        
    public PanelLaberinto(int[][] matrizResultante) {
        setBackground(Color.CYAN);
        setSize(600, 450);
        this.matrizResultante = matrizResultante;
    }

    public PanelLaberinto() {
        setBackground(Color.CYAN);
        setSize(600, 450);
        matrizResultante = new int[][] {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1},
            {1,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,1},
            {1,0,0,0,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
            {1,0,1,1,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,1,0,0,0,0,0,1,0,1,1,1,0,0,0,1},
            {1,0,1,0,0,0,0,0,1,0,1,1,1,0,1,0,1,0,0,0,1,0,1},
            {1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1},
            {1,0,1,0,1,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1},
            {1,0,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1},
            {1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,3},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
    }

    public void setMatrizResultante(int[][] matrizResultante) {
        this.matrizResultante = matrizResultante;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int cellSize = 20;
        for (int y = 0; y < matrizResultante.length; y++) {
            for (int x = 0; x < matrizResultante[0].length; x++) {
                if (matrizResultante[y][x] == 1) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                } else if (matrizResultante[y][x] == 2) {
                    g.setColor(Color.RED);
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                } else if (matrizResultante[y][x] == 3) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                }
            }
        }
        repaint();
    }
}
