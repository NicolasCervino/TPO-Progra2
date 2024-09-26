package tpo;

public class PilaTF implements PilaTDA {

    int[] a; 
    int indice;
    public void InicializarPila() {
        a = new int[100];
        indice = 0;
    }
    public void Apilar(int x) {
        a[indice] = x;
        indice++;
    }
    public void Desapilar() {
        indice--;
    }
    public boolean PilaVacia() {
        return (indice == 0);
    }
    public int Tope() {
        return a[indice - 1];
    }
}

