package paracaidas.ventana;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelParacaidista extends JPanel implements ActionListener{
    
    private DibujarParacaidista dibujarParacaidista;
    private Timer tiempo;
    
    private final int VELOCIDAD_CAIDAD = 5;
    private final int RETARDO = 20;
    
    public PanelParacaidista() {
        setBackground(Color.CYAN);
        dibujarParacaidista = new DibujarParacaidista(200,0,VELOCIDAD_CAIDAD);
        
        tiempo = new Timer(RETARDO, this);
        tiempo.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarParacaidista.dibujar(g);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        dibujarParacaidista.moverParacaidista();
//        
//        repaint();
        if (dibujarParacaidista.getY()+50 <= getHeight()) {
            dibujarParacaidista.moverParacaidista();
        }
        repaint();
    }
}
