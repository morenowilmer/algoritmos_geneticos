package paracaidas.ventana;

import java.awt.Color;
import java.awt.Graphics;

public class DibujarParacaidista {
    
    private int x;
    private int y;
    private int velocidadY;

    public DibujarParacaidista(int x, int y, int velocidadY) {
        this.x = x;
        this.y = y;
        this.velocidadY = velocidadY;
    }
    
    public void dibujar(Graphics g) {
        //Paracaidas
        g.setColor(Color.BLACK);
        g.fillOval(x-30, y-50, 60, 40);
        
        //Cuerdas
        g.setColor(Color.BLACK);
        g.drawLine(x-20, y-10, x-10, y+10);
        g.drawLine(x+20, y-10, x+10, y+10);
        
        //Cabeza
        g.setColor(Color.BLACK);
        g.fillOval(x-5, y, 10, 10);
        
        //Cuerpo
        g.setColor(Color.BLACK);
        g.fillRect(x-5, y+10, 10, 20);
    }
    
    public void moverParacaidista() {
        this.y += this.velocidadY;
    }

    public int getY() {
        return y;
    }
}
