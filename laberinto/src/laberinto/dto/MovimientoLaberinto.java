package laberinto.dto;

import java.util.ArrayList;
import java.util.List;

public class MovimientoLaberinto implements Cloneable {
    
    private List<PosicionMovimiento> movimientos;
    private int numMovimientos;
    private boolean sinSolucion;

    public MovimientoLaberinto() {
        this.movimientos = new ArrayList<>();
    }

    public List<PosicionMovimiento> getMovimientos() {
        return movimientos;
    }

    public void agregarMovimiento(PosicionMovimiento movimiento) {
        this.movimientos.add(movimiento);
        this.numMovimientos = numMovimientos+1;
    }

    public int getNumMovimientos() {
        return numMovimientos;
    }

    public boolean isSinSolucion() {
        return sinSolucion;
    }

    public void setSinSolucion(boolean sinSolucion) {
        this.sinSolucion = sinSolucion;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
