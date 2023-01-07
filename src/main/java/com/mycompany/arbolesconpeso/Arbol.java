
package com.mycompany.arbolesconpeso;

public class Arbol { // arbol binario
    
    Nodo raiz;  //raiz del arbol
    int pesoTot = 0; //peso total
    float pesoPromedio = 0; //peso promendio
    int nivel = 0;  //nivel del arbol
    int i = 0;  //cantidad de nodos
    
    public Arbol(){
        raiz=null;
    }
    
    public void insertar(int id, int peso){     //recibe la llave del nodo y el peso
        Nodo n = new Nodo(id);  //Creación de nuevo nodo
        n.peso = peso;
        
        if(raiz == null){ //si no hay nodo raíz, el nuevo nodo será la raíz
            raiz=n;
        }else{      // sino buscar en que dirección insertarlo
            Nodo aux = raiz;
            while(aux != null){
                n.padre = aux;
                if(n.llave >= aux.llave){   //si la llaven del nuevo nodo es mayor a el del padre quedará a la derecha
                    aux = aux.derecha;
                }else{
                    aux = aux.izquierda;    //si es menor quedará a la izquierda
                }
            }
            //enlazamos el nodo
            if(n.llave < n.padre.llave){        //si el la llave es menor que la del padre se enlaza a la izquierda
                n.padre.izquierda = n;
            }else{                              //si es mayor lo enlazamos a la derecha
                n.padre.derecha = n;        
            }
        }
        
    }
    
    //Método para recorrer el arbol inOrder
    public void recorrer (Nodo n){ 
        
        if(n != null){
            recorrer(n.izquierda);
            System.out.println("Id: " + n.llave
                                + "\n Peso: " + n.peso);
            recorrer(n.derecha);
            pesoTot += n.peso;
            i++;
        }
        System.out.println("Peso total del arbol: " + pesoTot);
    }
    
    //Metodo del promedio del peso del arbol
    public void promArbol(){
        pesoPromedio = pesoTot / i;
        System.out.println("El peso promedio del arbol es: " + pesoPromedio);
    }
    
    //Método para hallar el nivel
    private void nivel(Nodo n, int niv){
        if(n != null){
            nivel(n.izquierda, niv+1);
            if(niv > nivel){
                nivel = niv;
            }else{
                nivel(n.derecha, niv+1);
            }
        }
    }
    public int retornoNivel(){
        nivel(raiz, 1); // pasamos el nivel 1 ya que este sería la raíz
        return nivel;
    } 
    
    private class Nodo{
        public Nodo padre;
        //dirección donde se situa el nodo
        public Nodo derecha;
        public Nodo izquierda;
        public int llave; //id nodo
        public int peso;
        
        public Nodo(int indice){
            llave = indice;
            derecha = null;
            izquierda = null;
            padre = null;
            peso = 0;
        }
    }
    
}
