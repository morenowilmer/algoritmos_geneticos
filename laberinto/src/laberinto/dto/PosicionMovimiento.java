package laberinto.dto;

public class PosicionMovimiento {
    private int posX;
    private int posY;
    private boolean mueveArriba;
    private boolean mueveAbajo;
    private boolean mueveIzquierda;
    private boolean mueveDerecha;
    private int numCaminos;

    public PosicionMovimiento(int posX, int posY, int numCaminos) {
        this.posX = posX;
        this.posY = posY;
        this.numCaminos = numCaminos;
    }

    public PosicionMovimiento() {
        this.numCaminos = 0;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getNumCaminos() {
        return numCaminos;
    }

    public void setNumCaminos(int numCaminos) {
        this.numCaminos = numCaminos;
    }

    public boolean isMueveArriba() {
        return mueveArriba;
    }

    public void setMueveArriba(boolean mueveArriba) {
        this.mueveArriba = mueveArriba;
    }

    public boolean isMueveAbajo() {
        return mueveAbajo;
    }

    public void setMueveAbajo(boolean mueveAbajo) {
        this.mueveAbajo = mueveAbajo;
    }

    public boolean isMueveIzquierda() {
        return mueveIzquierda;
    }

    public void setMueveIzquierda(boolean mueveIzquierda) {
        this.mueveIzquierda = mueveIzquierda;
    }

    public boolean isMueveDerecha() {
        return mueveDerecha;
    }

    public void setMueveDerecha(boolean mueveDerecha) {
        this.mueveDerecha = mueveDerecha;
    }
}
