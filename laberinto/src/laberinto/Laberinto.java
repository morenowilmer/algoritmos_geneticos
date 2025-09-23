package laberinto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import laberinto.dto.MovimientoLaberinto;
import laberinto.dto.PosicionMovimiento;

public class Laberinto {
    
    private int iteraciones;
    
    private int[][] mapaLaberinto;
    private int posInicialX;
    private int posInicialY;
    private int posFinalX;
    private int posFinalY;
    private List<MovimientoLaberinto> poblacion;
    
    public Laberinto(int iteraciones) {
        this.iteraciones = iteraciones;
        posInicialX = 1;
        posInicialY = 1;
        
        mapaLaberinto = new int[][] {
            {1,1,1,1,1,1,1,1,1,1},
            {1,0,0,1,1,0,0,0,0,1},
            {1,0,1,0,1,1,1,1,0,1},
            {1,0,1,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1}
        };
        
        posFinalX = mapaLaberinto.length-2;
        posFinalY = mapaLaberinto[0].length-2;
        
        poblacion = new ArrayList<>();
        PosicionMovimiento posicion = new PosicionMovimiento();
        posicion.setPosX(posInicialX);
        posicion.setPosY(posInicialY);
        MovimientoLaberinto movimientoInicial = new MovimientoLaberinto();
        movimientoInicial.agregarMovimiento(posicion);
        evaluarNumeroCaminos(movimientoInicial);
        poblacion.add(movimientoInicial);
        try {
            resolverLaberinto();
        } catch (Exception e) {
            System.err.println("Error resolviendo laberinto");
            System.err.println(e);
        }        
    }
    
    public void resolverLaberinto() throws Exception{
        int contador = 1;
        
        while(contador < this.iteraciones) {
            List<MovimientoLaberinto> mejoresSoluciones = obtenerSoluconesPosibles();
//            MovimientoLaberinto nuevaIteracion = (MovimientoLaberinto) mejoresSoluciones.get(0).clone();
            MovimientoLaberinto nuevaIteracion = mejoresSoluciones.get(0);
            PosicionMovimiento siguienteMovimiento = realizarMovimiento(nuevaIteracion.getMovimientos().getLast());
            nuevaIteracion.agregarMovimiento(siguienteMovimiento);
            evaluarNumeroCaminos(nuevaIteracion);
            
//            poblacion.add(nuevaIteracion);
            
            if ((siguienteMovimiento.getPosX() == posFinalX) && (siguienteMovimiento.getPosY() == posFinalY)) {
                contador = iteraciones;
                System.out.println("Finalizo el juego");
                llenarMatriz(nuevaIteracion);
            }
            contador++;
        }
        List<MovimientoLaberinto> mejoresSoluciones = obtenerMejoresSolucones();
        llenarMatriz(mejoresSoluciones.get(0));
    }
    
    public void llenarMatriz(MovimientoLaberinto movimientoLaberinto) {
        List<PosicionMovimiento> posiciones = movimientoLaberinto.getMovimientos();
        
        for (PosicionMovimiento pos : posiciones) {
            mapaLaberinto[pos.getPosX()][pos.getPosY()] = 2;
        }
        
        for (int i = 0; i < mapaLaberinto.length; i++) {
            for (int j = 0; j < mapaLaberinto[0].length; j++) {
                System.err.print(mapaLaberinto[i][j]);
            }
            System.err.println("");
        }
    }
    
    public PosicionMovimiento realizarMovimiento(PosicionMovimiento ultimoMovimiento) {        
        List<PosicionMovimiento> posiciones = new ArrayList<>();
        if (ultimoMovimiento.isMueveAbajo()) {
            posiciones.add(new PosicionMovimiento(ultimoMovimiento.getPosX()+1, ultimoMovimiento.getPosY(), 0));
        }
        if (ultimoMovimiento.isMueveArriba()) {
            posiciones.add(new PosicionMovimiento(ultimoMovimiento.getPosX()-1, ultimoMovimiento.getPosY(), 0));
        }
        if (ultimoMovimiento.isMueveDerecha()) {
            posiciones.add(new PosicionMovimiento(ultimoMovimiento.getPosX(), ultimoMovimiento.getPosY()+1, 0));
        }
        if (ultimoMovimiento.isMueveIzquierda()) {
            posiciones.add(new PosicionMovimiento(ultimoMovimiento.getPosX(), ultimoMovimiento.getPosY()-1, 0));
        }
        
        Random random = new Random();
        int posMovimiento = random.nextInt(posiciones.size()) + 1;
        return posiciones.get(posMovimiento-1);
    }
    
    public List<MovimientoLaberinto> obtenerSoluconesPosibles() {
        return poblacion.stream().filter(m -> !m.isSinSolucion())
                .sorted(Comparator.comparingInt(MovimientoLaberinto::getNumMovimientos).reversed())
                .toList();
    }
    
    public List<MovimientoLaberinto> obtenerMejoresSolucones() {
        return poblacion.stream()
                .sorted(Comparator.comparingInt(MovimientoLaberinto::getNumMovimientos).reversed())
                .toList();
    }
    
    private void evaluarNumeroCaminos(MovimientoLaberinto movimiento) {
        int numeroCaminos = 0;
        PosicionMovimiento movimientoAnt = (movimiento.getMovimientos().size() > 1) ? 
                movimiento.getMovimientos().get(movimiento.getMovimientos().size()-2) :
                new PosicionMovimiento(0, 0, 0);
        PosicionMovimiento ultMovimiento = movimiento.getMovimientos().get(movimiento.getMovimientos().size()-1);
        
        //validar arriba        
        if(mapaLaberinto[ultMovimiento.getPosX()-1][ultMovimiento.getPosY()] == 0) {
            if ((movimientoAnt.getPosX() != ultMovimiento.getPosX()-1) || (movimientoAnt.getPosY() != ultMovimiento.getPosY())) {
                numeroCaminos = numeroCaminos+1;
                ultMovimiento.setMueveArriba(true);
            }
        }
        
        //validar abajo        
        if(mapaLaberinto[ultMovimiento.getPosX()+1][ultMovimiento.getPosY()] == 0) {
            if ((movimientoAnt.getPosX() != ultMovimiento.getPosX()+1) || (movimientoAnt.getPosY() != ultMovimiento.getPosY())) {
                numeroCaminos = numeroCaminos+1;
                ultMovimiento.setMueveAbajo(true);
            }
        }
        
        //validar derecha        
        if(mapaLaberinto[ultMovimiento.getPosX()][ultMovimiento.getPosY()+1] == 0) {
            if ((movimientoAnt.getPosX() != ultMovimiento.getPosX()) || (movimientoAnt.getPosY() != ultMovimiento.getPosY()+1)) {
                numeroCaminos = numeroCaminos+1;
                ultMovimiento.setMueveDerecha(true);
            }
        }
        
        //validar izquierda        
        if(mapaLaberinto[ultMovimiento.getPosX()][ultMovimiento.getPosY()-1] == 0) {
            if ((movimientoAnt.getPosX() != ultMovimiento.getPosX()) || (movimientoAnt.getPosY() != ultMovimiento.getPosY()-1)) {
                numeroCaminos = numeroCaminos+1;
                ultMovimiento.setMueveIzquierda(true);
            }
        }
        ultMovimiento.setNumCaminos(numeroCaminos);
        
        if (numeroCaminos == 0) {
            movimiento.setSinSolucion(true);
            for (int i = movimiento.getMovimientos().size()-1; i >= 0; i--) {
                PosicionMovimiento posicionMov = movimiento.getMovimientos().get(i);
                if (posicionMov.getNumCaminos() > 1) {
                    MovimientoLaberinto nuevoMovimiento = new MovimientoLaberinto();
                    
                    for(int j = 0; j <= i; j++) {
                        nuevoMovimiento.agregarMovimiento(movimiento.getMovimientos().get(j));
                    }
                    
                    poblacion.add(nuevoMovimiento);
                    return;
                }
            }
        }
    }
}
