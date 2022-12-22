
package pilasjavaspoo;


public class Pila {
	private Nodo ultimo;
	int tamano;
	String lista = "";

	public Pila() {
		ultimo = null;
		tamano = 0;
	}
	// metodo para ver si la pila esta vacia

	public boolean pilaVacia() {
		return ultimo == null;
	}

	// inserta nodo
	public void insertarNodo(int nodo) {
		Nodo nuevond = new Nodo(nodo);
		nuevond.siguiente = ultimo;
		ultimo = nuevond;
		tamano++;
	}

	// eliminar nodo
	public int EliminarNodo() {
		int aux = ultimo.valor;
		ultimo = ultimo.siguiente;
		tamano--;
		return aux;
	}

	// saber el ultimo valor
	public int mostrarUltimo() {
		return ultimo.valor;
	}

	// tamaño
	public int tamano() {
		return tamano;
	}

	// vaciar pila
	public void vaciar() {
		while (!pilaVacia()) {
			EliminarNodo();
		}

	}

	// devolver el ultimo nodo
	public Nodo mostrarUltimoNodo() {
		return ultimo;
	}
	
	// mostrar contenido
	public String MostrarPila() {
		Nodo recorrido = ultimo;
		while (recorrido != null) {
			lista += recorrido.valor + "\n";
			recorrido = recorrido.siguiente;
		}
		return lista;
	}

	//Invertir Pila}
	public Pila invertirPila() {
		Nodo temp=ultimo;
		Pila cc = new Pila();
		while (!pilaVacia()) {
			cc.insertarNodo(ultimo.valor);
			ultimo = ultimo.siguiente;
		}
		ultimo = temp;
		return cc;
	}
	
}
