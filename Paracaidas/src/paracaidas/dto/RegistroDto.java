package paracaidas.dto;

public class RegistroDto {
    
    private int velocidad;
    private int peso;
    private int velocidadViento;
    private int angulo;
    private double probabilidad;

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getVelocidadViento() {
        return velocidadViento;
    }

    public void setVelocidadViento(int velocidadViento) {
        this.velocidadViento = velocidadViento;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public double getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(double probabilidad) {
        this.probabilidad = probabilidad;
    }

    @Override
    public String toString() {
        return "RegistroDto{" + "velocidad=" + velocidad + ", peso=" + peso + ", velocidadViento=" + velocidadViento + ", angulo=" + angulo + ", probabilidad=" + probabilidad + '}';
    }
    
    
}
