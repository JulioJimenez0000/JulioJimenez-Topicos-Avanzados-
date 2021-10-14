# <center> **COLECCIONES** </center>

Una colección representa un grupo de objetos. Estos objetos son conocidos como **elementos**. Cuando queremos trabajar con un conjunto de elementos, necesitamos un almacén donde poder guardarlos. En Java, se emplea la interfaz genérica **Collection** para este propósito.

Gracias a esta interfaz, podemos almacenar cualquier tipo de objeto y podemos usar una serie de métodos comunes, como pueden ser: 

- añadir 
- eliminar 
- obtener el tamaño de la colección 

Partiendo de la interfaz genérica Collection extienden otra serie de interfaces genéricas. Estas subinterfaces aportan distintas funcionalidades sobre la interfaz anterior.


## **Tipos de colecciones**
En este apartado, vamos a analizar los principales tipos de colecciones que se encuentran, por defecto, en la plataforma de Java.  

### **Set**
La interfaz Set define una colección que no puede contener elementos duplicados. Esta interfaz contiene únicamente los métodos heredados de Collection,añadiendo la restricción de que los elementos duplicados están prohibidos. Es importante destacar que, para comprobar si los elementos son elementos duplicados o no lo son, es necesario que dichos elementos tengan implementada, de forma correcta, los métodos **equals y hashCode.** Para comprobar si dos Set son iguales, se comprobarán si todos los elementos que los componen son iguales sin importar en el orden que ocupen dichos elementos.

Dentro de la interfaz Set existen varios tipos de implementaciones realizadas dentro de la plataforma Java. Vamos a analizar cada una de ellas:

**HashSet:** este implementación almacena los elementos en una tabla hash. Es la implementación con mejor rendimiento de todas pero no garantiza ningún orden a la hora de realizar iteraciones. Es la implementación más empleada debido a su rendimiento y a que, generalmente, no nos importa el orden que ocupen los elementos. Esta implementación proporciona tiempos constantes en las operaciones básicas siempre y cuando la función hash disperse de forma correcta los elementos dentro de la tabla hash. Es importante definir el tamaño inicial de la tabla ya que este tamaño marcará el rendimiento de esta implementación.

**TreeSet:** esta implementación almacena los elementos ordenándolos en función de sus valores. Es bastante más lento que HashSet. Los elementos almacenados deben implementar la interfaz Comparable. Esta implementación garantiza, siempre, un rendimiento de log(N) en las operaciones básicas, debido a la estructura de árbol empleada para almacenar los elementos.

**LinkedHashSet:** esta implementación almacena los elementos en función del orden de inserción. Es, simplemente, un poco más costosa que HashSet.

#  <center> **QUE ES EL "JAVA COLEECTION FRAMEWORK"??** </center>

**Java Collection Framework** es como se conoce a la librería de clases contenedoras de Java que podemos encontrar en el paquete estándar **java.util.** Estas clases sirven para almacenar colecciones de objetos, como listas, conjuntos, mapas, etc.

Todas estas clases permiten guardar en ellas referencias a objetos (no podemos usarlas a priori con tipos primitivos como int o double). Por ejemplo:

// Lista de enteros. Puede haber enteros repetidos en la lista:
List <"Integer"> lista_de_manzanas;  

// Conjunto de enteros. No puede haber enteros repetidos:
Set <"Integer"> conjunto_de_naranjas;

// Un mapa que asocia a una cadena un entero, como en una lista de notas de un examen:
//    [("Juan Goytisolo", 9.5), ("Pablo Iglesias", 5.0), ...]
Map<"String, Integer"> mapa_de_notas;

## **Listas**

Llamamos lista a cualquier colección de objetos ordenados por posición, como en un array. En una lista podemos añadir elementos, acceder a ellos por su posición en la lista, eliminar elementos de la lista y otras operaciones, como vaciar la lista, copiarla, etc. En una lista puede haber objetos repetidos, es decir, objetos que son iguales según el método equals() de su clase.

## **Crear una lista**
Vamos a crear una lista de objetos de tipo Integer:

List <"Integer"> lista_de_enteros = new ArrayList<"Integer">();
Porqué ‘new ArrayList’ y no ‘new List’ quedará claro cuando hablemos de polimorfismo e interfaces.

## **Añadir elementos a la lista**
El método add(·) añade una referencia a un objeto al final de la lista

lista_de_enteros.add(new Integer(4));  
lista_de_enteros.add(new Integer(5));  
lista_de_enteros.add(new Integer(7));  
lista_de_enteros.add(2,new Integer(6));  

//Lo añade en la posición 2, entre el 5 y el 7
## **Tamaño de una lista**
Usa size() para saber el tamaño de una lista:

lista_de_enteros.size();
devuelve 4: la lista contiene 4 elementos.

## **Obtener elementos de una lista**
El método get(int) sirve para acceder a cualquier elemento de la lista, por su posición:

Integer primero = lista_de_enteros.get(0);
devuelve el objeto en la posición 0, es decir, el primero de los que añadí.

Integer ultimo = lista_de_enteros.get(lista_de_enteros.size()-1);
me devuelve el último elemento de la lista.

## **Saber si un elemento está en la lista**
Usa el método contains(·) para preguntarle a la lista si contiene el objeto dado:

lista_de_enteros.contains(new Integer(7));  
// me devolverá 'true'  
lista_de_enteros.contains(new Integer(8));  
// me devolverá 'false'  

## **Obtener la posición de un objeto en la lista**  
El método indexOf(·) me indica la posición de la primera ocurrencia del objeto en la lista (recuerda que un mismo objeto puede estar repetido en diferentes posiciones):

lista_de_enteros.indexOf(new Integer(6));   
// devuelve 2  
lista_de_enteros.indexOf(new Integer(10));   
// devuelve -1  

## **Recorrer los elementos de la lista**
Podemos usar un bucle convencional:

for (int i=0; i < lista_de_enteros.size(); i++)  
{  
  System.out.println(lista_de_enteros.get(i));  
}  

el cual nos permitiría recorrer sólo una parte de la lista si nos interesa (p. ej., los cuatro primeros elementos).

Con un bucle for como éste:

for (Integer entero : lista_de_enteros)  
{  
  System.out.println(entero);  
}  

donde la variable ‘entero’ de tipo Integer va tomando el valor del siguiente elemento de la lista ‘lista_de_enteros’ en cada iteración, recorremos TODOS los elementos de la lista, imprimiendo uno en cada línea.

Una forma algo más sofisticada, pero más flexible de hacer esto es usar iteradores:

Iterator<Integer> iterador = lista_de_enteros.iterator(); 
while (iterador.hasNext()) {
  Integer entero = iterador.next();
  System.out.println(entero); // imprime un elemento
}
Fíjate que en el ‘while’ podríamos añadir más condiciones para detener el bucle donde nos interese, lo cual no podemos hacer con el ‘for’ anterior.

## **Eliminar un objeto de la lista**
Para esto usamos el método remove(·) de dos formas:

boolean quitado = lista_de_enteros.remove(new Integer(7));
quita la primera aparicíon del 7 en la lista y devuelve ‘true’. Si no hay ningún 7 devolvería ‘false’.

Integer unEntero = lista_de_enteros.remove(1);
quita el segundo elemento (el 5).

## **Saber si una lista está vacía o vaciarla**
Esto es fácil:

boolean estaVacia = lista_de_enteros.isEmpty(); // devolverá 'false'
lista_de_enteros.clear(); // ahora sí que está vacía

## **Conjuntos**
Llamamos conjunto a cualquier colección de objetos de la misma clase sin ningún orden en particular. Además, cada elemento sólo aparece una vez, al contrario que en una lista, donde podían repetirse.

## **Crear un conjunto**
Vamos a crear un conjunto de objetos de tipo Integer:

Set<"Integer"> conjunto_de_enteros = new HashSet<"Integer">();
Porqué ‘new HashSet’ y no ‘new Set’ quedará claro cuando hablemos de polimorfismo e interfaces.

## **Añadir elementos al conjunto**
El método add(·) añade una referencia a un objeto al conjunto.

conjunto_de_enteros.add(new Integer(4));  
conjunto_de_enteros.add(new Integer(5));  
conjunto_de_enteros.add(new Integer(7));  
boolean repe = conjunto_de_enteros.add(new Integer(4)));  

// no añade el 4 porque ya está en el conjunto y además devuelve 'false'

## **Tamaño de un conjunto**  
conjunto_de_enteros.size();
me devuelve 3: el conjunto contiene 3 elementos.

## **Saber si un elemento está en la lista**
conjunto_de_enteros.contains(new Integer(7));  
 // me devolverá 'true'  
conjunto_de_enteros.contains(new Integer(8));   
// me devolverá 'false'  

Un Set no tiene los métodos get(·) e indexOf(·), los elementos no están en ninguna posición en particular. Básicamente, con un conjunto lo que podemos hacer es añadir elementos, eliminarlos y preguntar si un elemento pertenece al conjunto.

## **Recorrer todos los elementos del conjunto**
Con un bucle for como éste:

for (Integer entero : conjunto_de_enteros)  
{  
  System.out.println(entero);  
}  

Este bucle imprime todos los enteros del conjunto, uno en cada línea. El problema es que no recorre el conjunto en ningún orden en particular. No hay ningún orden definido en el conjunto.

## **Eliminar un objeto del conjunto**
boolean quitado = conjunto_de_enteros.remove(new Integer(7));
devuelve ‘true’. Si no hay ningún 7 devolvería ‘false’.

## **Saber si un conjunto está vacío o vaciarlo**
boolean estaVacio = conjunto_de_enteros.isEmpty();  
// devolverá 'false'  

conjunto_de_enteros.clear();  
// ahora sí que está vacío