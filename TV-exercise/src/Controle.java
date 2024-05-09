public class Controle {
    boolean estaLigada=true;
    int canal =1;
    int volume =25;
    
    public void mudarCanal(int novoCanal) { 
        canal = novoCanal;
    }

    public void aumentarVolume() {
        volume ++;
        
    }

    public void reduzirVolume() {
        volume--;
    }
    
}
