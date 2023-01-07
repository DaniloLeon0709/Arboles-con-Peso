
package com.mycompany.arbolesconpeso;

public class ArbolesconPeso {

    public static void main(String[] args) {
        
        Arbol arbol  = new Arbol();
        
        arbol.insertar(5, 4);
        arbol.insertar(2, 2);
        arbol.insertar(8, 1);
        arbol.insertar(1, 7);
        arbol.insertar(6, 12);
        
        arbol.recorrer(arbol.raiz);
        System.out.println("El nivel del arbol es: "+ arbol.retornoNivel());
        arbol.promArbol();
    }
}
