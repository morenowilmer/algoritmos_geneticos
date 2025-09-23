package paracaidas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import paracaidas.dto.RegistroDto;

public class Paracaidas {
    
    private List<RegistroDto> poblacion;
    
    public void generarPoblacionInicial() {
        poblacion = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            RegistroDto registro = new RegistroDto();
            registro.setPeso(generarValorRandom(50, 140));
            registro.setAngulo(generarValorRandom(1, 90));
            registro.setVelocidadViento(generarValorRandom(20, 70));
            registro.setVelocidad(generarValorRandom(30, 80));
            calcularProbabilidad(registro);
            poblacion.add(registro);
        }
    }
    
    private int generarValorRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
    private void calcularProbabilidad(RegistroDto registro) {
        double probPeso = registro.getPeso() * 0.03;
        double probViento = registro.getVelocidadViento() * 0.03;
        double probVelocidad = registro.getVelocidad() * 0.02;
        double probAngulo = registro.getAngulo() * 0.02;
        
        double valor = probPeso + probViento + probVelocidad + probAngulo;
        registro.setProbabilidad(valor);
    }

    public List<RegistroDto> getPoblacion() {
        return poblacion;
    }
}
