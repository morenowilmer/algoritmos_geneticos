package paracaidas.ventana;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import paracaidas.dto.RegistroDto;

public class PanelParacaidista extends JPanel implements ActionListener{
    
    private DibujarParacaidista dibujarParacaidista;
    private Timer tiempo;
    private double velocidadCaida;
    private List<RegistroDto> registros;
    
    private final int RETARDO = 20;
    
    public PanelParacaidista() {
        registros = new ArrayList<>();
        setBackground(Color.CYAN);
        setSize(350, 550);//(, 390)
        dibujarParacaidista = new DibujarParacaidista(200, 0, 0);
        
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
        if (dibujarParacaidista.getY()+50 <= getHeight()) {
            if (dibujarParacaidista.getY()+50 >= getHeight()-20 && this.velocidadCaida > 5) {
                setBackground(Color.RED);
            }
            dibujarParacaidista.moverParacaidista();
        }
        repaint();
    }
    
    public void iniciar(Double velocidadCaida) {        
        this.velocidadCaida = velocidadCaida;
//        dibujarParacaidista = new DibujarParacaidista(200, 0, 0);
        dibujarParacaidista.reiniciar(200, 0, velocidadCaida.intValue());
        dibujarParacaidista.dibujar(this.getGraphics());
        dibujarParacaidista.moverParacaidista();
        
        tiempo = new Timer(RETARDO, this);
        tiempo.start();
    }

//    public void setRegistros(List<RegistroDto> registros) {
//        this.registros = registros;
//    }
}
