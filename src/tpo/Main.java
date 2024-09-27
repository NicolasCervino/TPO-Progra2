package tpo;

public class Main {
	public static void main(String[] args) {
		DiccionarioMultipleTDA dm = new DiccionarioMultiple();
		dm.InicializarDiccionario();
		
		dm.Agregar(3, 1);
		dm.Agregar(3, 3);
		dm.Agregar(3, 5);
		dm.Agregar(3, 7);
		dm.Agregar(5, 3);
		dm.Agregar(1, 4);
		dm.Agregar(1, 2);
		dm.Agregar(7, 4);
		dm.Agregar(7, 5);
		
		PilaTDA p1 = new Pila();
		p1.InicializarPila();
		
		PilaTDA p2 = new Pila();
		p2.InicializarPila();
		
		// Agregamos valores al diccionario
		dm.Agregar(2, 6);
		dm.Agregar(2, 4);
		dm.Agregar(2, 2);
		dm.Agregar(2, 25);
		dm.Agregar(1, 9);
		dm.Agregar(6, 2);
		dm.Agregar(6, 25);
        
		// a) Pasamos claves a P1
		Ejercicio3.PasarClavesAPila(dm, p1);
		
		// b) Pasamos máximos valores a P2
		Ejercicio3.PasarMaximosValoresAPila(dm, p2);
		
		// c) Devolveemos la clave con mayor cantidad de valores
		Ejercicio3.ClaveConMayorCantidadDeValores(dm);
	}
}
