public class Main {
    static class ListNode { //Clase estatica que representa un nodo de la lista enlazada
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static class LinkedListOperations { //Clase que contiene las operaciones sobre la lista enlazada
        public static ListNode invertirLista(ListNode cabeza) { //Método para invertir la lista enlazada en su lugar
            ListNode prev = null;
            ListNode current = cabeza;
            ListNode siguiente = null;
            while (current != null) { //Iteración sobre la lista
                siguiente = current.next;
                current.next = prev;
                prev = current;
                current = siguiente;
            }
            cabeza = prev; //La nueva cabeza de la lista es el ultimo nodo
            return cabeza;
        }
        public static ListNode encontrarElementoDelMedio(ListNode cabeza) { //Metodo para encontrar el Elemento del Medio
            if (cabeza == null || cabeza.next == null) { //Caso base, es decir, lista vacia o con un solo nodo
                return cabeza;
            }
            ListNode rapido = cabeza; //Mueve dos nodos a la vez
            ListNode lento = cabeza; //Mueve un nodo a la vez
            while (rapido != null && rapido.next != null) { //Se itera sobre la lista, el nodo lento estara en el medio al final
                rapido = rapido.next.next;
                lento = lento.next;
            }
            return lento;
        }
        public static void eliminarDuplicados(ListNode cabeza) { //Metodo para eliminar Duplicados
                ListNode actual = cabeza;
                while (actual != null && actual.next != null) { //Se itera sobre la lista
                    if (actual.next.val == actual.val) { //Si se encuentran nodos duplicados, eliminamos el siguiente nodo
                        actual.next = actual.next.next;
                    } else {
                        actual = actual.next; //Avanzamos al siguiente nodo si no hay duplicados
                    }
                }
            }
        }
        public static void imprimirLista(ListNode cabeza) { // Método para imprimir la lista enlazada
            ListNode actual = cabeza;
            while (actual != null) {
                System.out.print(actual.val + " ");
                actual = actual.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            ListNode cabeza = new ListNode(1); // Crear una lista enlazada de ejemplo: 1 -> 2 -> 3 -> 2 -> 4 -> 5
            cabeza.next = new ListNode(2);
            cabeza.next.next = new ListNode(3);
            cabeza.next.next.next = new ListNode(2);
            cabeza.next.next.next.next = new ListNode(4);
            cabeza.next.next.next.next.next = new ListNode(5);

            cabeza = LinkedListOperations.invertirLista(cabeza); // Invertir la lista enlazada
            System.out.println("Lista invertida:");
            imprimirLista(cabeza);

            ListNode medio = LinkedListOperations.encontrarElementoDelMedio(cabeza); // Encontrar el elemento del medio
            System.out.println("Elemento del medio: " + medio.val);

            LinkedListOperations.eliminarDuplicados(cabeza); // Eliminar duplicados
            System.out.println("Lista después de eliminar duplicados:");
            imprimirLista(cabeza);
        }
    }

