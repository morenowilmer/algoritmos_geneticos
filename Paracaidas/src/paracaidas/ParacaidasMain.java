package paracaidas;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import paracaidas.ventana.PanelParacaidista;

public class ParacaidasMain {

    public static void main(String[] args) {
//        Paracaidas paracaidas = new Paracaidas();
//        paracaidas.generarPoblacionInicial();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 600);
            frame.setLocationRelativeTo(null);
            PanelParacaidista panelParacaidista = new PanelParacaidista();
            frame.add(panelParacaidista);
            frame.setVisible(true);
        });
    }
}
