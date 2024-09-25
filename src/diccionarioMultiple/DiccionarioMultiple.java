package diccionarioMultiple;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {
	Elemento[] elementos;
	int cantClaves;
	
	@Override
	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		cantClaves = 0;
	}

	@Override
	public void Agregar(int clave, int valor) {
		int posC = Clave2Indice(clave);
        if (posC == -1) { // Si la clave no existe, la agregamos
            posC = cantClaves;
            elementos[posC] = new Elemento();
            elementos[posC].clave = clave;
            elementos[posC].valores = new int[100];
            elementos[posC].cantValores = 0;
            cantClaves++;
        }

        Elemento e = elementos[posC];
        int posV = Valor2Indice(e, valor);
        if (posV == -1) { // Si el valor no existe, lo agregamos
            e.valores[e.cantValores] = valor;
            e.cantValores++;
        }
	}
	
	@Override
	public void Eliminar(int clave) {
		int pos = Clave2Indice(clave);
        if (pos != -1) {
            elementos[pos] = elementos[cantClaves - 1];
            cantClaves--;
        }
	}

	@Override
	public void EliminarValor(int clave, int valor) {
		int posC = Clave2Indice(clave);
        if (posC != -1) {
            Elemento e = elementos[posC];
            int posV = Valor2Indice(e, valor);
            if (posV != -1) { // Si el valor existe, lo eliminamos
                e.valores[posV] = e.valores[e.cantValores - 1]; // Reemplazamos por el último valor
                e.cantValores--;
                if (e.cantValores == 0) {
                    Eliminar(clave); // Si no quedan valores, eliminamos la clave
                }
            }
        }
	}
	
	public ConjuntoTDA Recuperar(int clave) {
        ConjuntoTDA c = new ConjuntoLD(); // Supongamos que existe una clase ConjuntoLD
        c.InicializarConjunto();
        int pos = Clave2Indice(clave);
        if (pos != -1) {
            Elemento e = elementos[pos];
            for (int i = 0; i < e.cantValores; i++) {
                c.Agregar(e.valores[i]);
            }
        }
        return c;
    }

    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();
        for (int i = 0; i < cantClaves; i++) {
            c.Agregar(elementos[i].clave);
        }
        return c;
    }

	
	private int Clave2Indice(int clave) {
		int i = cantClaves - 1;
		while (i >= 0 && elementos[i].clave != clave) {
			i --;
		}
		return i;
	}
	
	private int Valor2Indice(Elemento e, int valor) {
        int i = e.cantValores - 1;
        while (i >= 0 && e.valores[i] != valor) {
            i--;
        }
        return i;
    }

}
