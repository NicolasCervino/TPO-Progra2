
package tpo;

public class Ejercicio3{
	

	public static void PasarClavesAPila(DiccionarioMultipleTDA dm, PilaTDA p1) { //Creamos metodo PasarClavesAPila. Pasando de un Diccionario Multiple DM a una Pila P1
	    ConjuntoTDA claves = dm.Claves(); //Creamos un conjunto llamado claves usando el metodo claves del Diccionario Multiple
	    while (!claves.ConjuntoVacio()) { //Mientras que el conjunto no este vacio se lleva a cabo lo siguiente.
	        int clave = claves.Elegir(); //Elegimos una clave
	        System.out.println("Clave: " + clave);  // Imprimimos la clave
	        p1.Apilar(clave);  // Apilamos la clave en P1
	        claves.Sacar(clave);  // Sacamos la clave del conjunto
	    }
	}
	
	public static void PasarMaximosValoresAPila(DiccionarioMultipleTDA dm, PilaTDA p2) { //Creamos metodo PasarMaximosValoresAPila. Pasando nuevamente de un Diccionario Multiple DM a una Pila P2
	    ConjuntoTDA claves = dm.Claves(); //Creamos un conjunto llamado claves usando el metodo claves del Diccionario Multiple
	    while (!claves.ConjuntoVacio()) { //Mientras que el conjunto no este vacio se lleva a cabo lo siguiente.
	        int clave = claves.Elegir(); //Elegimos una clave
	        ConjuntoTDA valores = dm.Recuperar(clave); //Creamos otro conjunto llamado valores, que utiliza Recuperar de un diccionario multiple para conseguir los valores de una clave.
	        int maximo = 0; // Creamos el int maximo para poder utilizarlo para guardar el valor maximo de la clave
	        
	        
	        while (!valores.ConjuntoVacio()) { // Vamos clave por clave encontrando en cada el valor máximo de la misma
	            int valor = valores.Elegir();
	            if (valor > maximo) {
	                maximo = valor;
	            }
	            valores.Sacar(valor); // Si el valor es el maximo, se guarda en maximo, y al finalizar se saca del conjunto de valores y se busca otro.
	        }

	     
	        System.out.println("Valor máximo en clave" + clave + " = " + maximo);    // Imprimimos la clave y su valor máximo
	        p2.Apilar(maximo);  // Apilamos el valor máximo en P2
	        claves.Sacar(clave);  // Continuamos con la siguiente clave
	    }
	}

  
    public static void ClaveConMayorCantidadDeValores(DiccionarioMultipleTDA dm) { //Creamos metodo ClaveConMayorCantidadDeValores.
        ConjuntoTDA claves = dm.Claves();
        int claveMax = 0; //Creamos una variable para guardar la clave con la maxima cantidad de valores
        int maxCantidadValores = 0; //Creamos otra variable para poder tener en cuenta cual es la cantidad maxima de valores

        while (!claves.ConjuntoVacio()) { //Va clave por clave eliminando sus valores uno por uno, y a su vez sumando al contador para ver su cantidad total de valores
            int clave = claves.Elegir();
            ConjuntoTDA valores = dm.Recuperar(clave);
            int cantidadValores = 0; // Contador para cantidad de valores
            while (!valores.ConjuntoVacio()) {
                valores.Sacar(valores.Elegir());
                cantidadValores++;
            }

            if (cantidadValores > maxCantidadValores) { //Si la clave tiene la mayor cantidad de valores, se guardan en las variables que introducimos al principio
                maxCantidadValores = cantidadValores;
                claveMax = clave;
            }

            claves.Sacar(clave);
        }
        System.out.println("Clave con más valores: " + claveMax);;
    }
    
    public static void main(String[] args) { // Ahora teniendo todo planteado, resolvemos el ejercicio con los datos del TPO
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
        
        PilaTDA p1 = new PilaTF();
        p1.InicializarPila();
        
        PilaTDA p2 = new PilaTF();
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
        PasarClavesAPila(dm, p1);

        // b) Pasamos máximos valores a P2
        PasarMaximosValoresAPila(dm, p2);

        // c) Devolveemos la clave con mayor cantidad de valores
        ClaveConMayorCantidadDeValores(dm);

    }
}
