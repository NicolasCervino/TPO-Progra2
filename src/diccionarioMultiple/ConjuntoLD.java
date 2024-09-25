package diccionarioMultiple;

public class ConjuntoLD implements ConjuntoTDA {
	int[] a;
	int cant;

	@Override
	public void InicializarConjunto() {
		a = new int[100];
		cant = 0;
	}

	@Override
	public void Agregar(int x) {
		if (!this.Pertenece(x)) {
			a[cant] = x;
			cant++;
		}
	}

	@Override
	public int Elegir() {
		return a[cant - 1];
	}

	@Override
	public boolean ConjuntoVacio() {
		return cant == 0;
	}

	@Override
	public void Sacar(int x) {
	    int i = 0;
	    // Busco el índice del elemento 'x'
	    while (i < cant && a[i] != x) {
	        i++;
	    }
	    // Si se encontró el elemento 'x'
	    if (i < cant) {
	        a[i] = a[cant - 1]; // Reemplaza 'x' por el último elemento
	        cant--; // Reduce la cantidad de elementos
	    }
	}

	@Override
	public boolean Pertenece(int x) {
		int i = 0;
		while (i < cant && a[i] != x) {
			i++;
		}
		return (i < cant);
	}
}
