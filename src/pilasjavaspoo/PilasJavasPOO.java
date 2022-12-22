
package pilasjavaspoo;

import javax.swing.JOptionPane;

public class PilasJavasPOO {

	public static void main(String[] args) {
		int opcion = 0, nodo = 0;
		Pila pila1 = new Pila();
		Pila pila2 = new Pila();
		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese:\n" + "1. Insertar Nodo\n"
						+ "2. Eliminar Nodo\n" 
						+ "3. Pila Vacia?\n" 
						+ "4. Consultar ultimo valor\n"
						+ "5. Consultar tamaño\n" 
						+ "6. vaciar pila 1\n" 
						+ "7. vaciar pila 2\n" 
						+ "8. Pasar pila 1 a pila 2 metodo 1\n"
						+ "9. Pasar pila 1 a pila 2 metodo 2 \n"
						+ "10. Mostrar contenido pila 1\n"
						+ "11. Mostrar contenido pila 2\n" 
						+ "12. Salir"));

				switch (opcion) {
				case 1:
					nodo = Integer.parseInt(JOptionPane.showInputDialog("ingrese valor de nodo"));
					pila1.insertarNodo(nodo);
					break;
					
				case 2:
					if (!pila1.pilaVacia()) {
						JOptionPane.showMessageDialog(null,
								"se ha eliminado el nodo con el valor " + pila1.EliminarNodo());
					} else {
						JOptionPane.showMessageDialog(null, "la pila esta vacia");
					}
					break;
					
				case 3:
					if (pila1.pilaVacia()) {
						JOptionPane.showMessageDialog(null, "La pila esta vacia.");
					} else {
						JOptionPane.showMessageDialog(null, "La pila no esta vacia.");
					}
					break;
					
				case 4:
					if (!pila1.pilaVacia()) {
						JOptionPane.showMessageDialog(null, "El ultimo valor de la pila es: " + pila1.mostrarUltimo());
					}
					break;
					
				case 5:
					JOptionPane.showMessageDialog(null, "La pila contiene " + pila1.tamano() + " nodos");
					break;
					
				case 6:
					if (!pila1.pilaVacia()) {
						pila1.vaciar();
						JOptionPane.showMessageDialog(null, "Su pila se ha vaciado correctamente.");
					} else {
						JOptionPane.showMessageDialog(null, "La pila 1 esta vacia.");
					}
					break;
					
				case 7:
					if (!pila2.pilaVacia()) {
						pila2.vaciar();
						JOptionPane.showMessageDialog(null, "Su pila se vaciado correctamente.");
					} else {
						JOptionPane.showMessageDialog(null, "La pila 2 esta vacia.");
					}
					break;
					
				case 8:
					//Pasar pila 1 a pila 2 metodo 1
					pila2.vaciar();
					if (!pila1.pilaVacia()) {
						pasarNodos(pila1, pila2);
					} else {
						JOptionPane.showMessageDialog(null, "La pila 1 esta vacia.");
					}
					break;
				case 9:
					//Pasar pila 1 a pila 2 metodo 2
					pila2.vaciar();
					if (!pila1.pilaVacia()) {
						pila1=pila1.invertirPila();
						pasarNodos(pila1, pila2);
					} else {
						JOptionPane.showMessageDialog(null, "La pila 1 esta vacia");
					}					
					break;	
					
				case 10:
					JOptionPane.showMessageDialog(null, pila1.MostrarPila());
					pila1.lista="";
					break;
					
				case 11:
					JOptionPane.showMessageDialog(null, pila2.MostrarPila());
					pila2.lista="";
					break;
					
				case 12:
					opcion = 12;
					break;
				default:

				}

			}

			catch (NumberFormatException e) {
			}

		} while (opcion != 12);

	}

	public static void pasarNodos(Pila pila1, Pila pila2) {
		Nodo ultimo = pila1.mostrarUltimoNodo();
		Nodo recorrido = ultimo;
		while (recorrido != null) {
			pila2.insertarNodo(recorrido.valor);
			recorrido = recorrido.siguiente;
		}
	}
}
