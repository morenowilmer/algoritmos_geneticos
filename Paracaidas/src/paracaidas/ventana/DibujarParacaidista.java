package paracaidas.ventana;

import java.awt.Color;
import java.awt.Graphics;

public class DibujarParacaidista {
    
    private int x;
    private int y;
    private int velocidadY;
    private Color colorParacaidista;

    public DibujarParacaidista(int x, int y, int velocidadY) {
        this.x = x;
        this.y = y;
        this.velocidadY = velocidadY;
        this.colorParacaidista = Color.BLACK;
    }
    
    public void dibujar(Graphics g) {
        //Paracaidas
        g.setColor(colorParacaidista);
        g.fillOval(x-30, y-50, 60, 40);
        
        //Cuerdas
        g.setColor(colorParacaidista);
        g.drawLine(x-20, y-10, x-10, y+10);
        g.drawLine(x+20, y-10, x+10, y+10);
        
        //Cabeza
        g.setColor(colorParacaidista);
        g.fillOval(x-5, y, 10, 10);
        
        //Cuerpo
        g.setColor(colorParacaidista);
        g.fillRect(x-5, y+10, 10, 20);
    }
    
    public void moverParacaidista() {
        this.y += this.velocidadY;
    }

    public int getY() {
        return y;
    }

    public void setColorParacaidista(Color colorParacaidista) {
        this.colorParacaidista = colorParacaidista;
    }
    
    public void reiniciar(int x, int y, int velocidadY) {
        this.x = x;
        this.y = y;
        this.velocidadY = velocidadY;
        this.colorParacaidista = Color.BLACK;
    }
}
