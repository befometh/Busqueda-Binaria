import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
 
public class BusquedaBinaria {
 
    private static int[] array;
    private static Random rnd = new Random();  
 
    public static void crearArray(int tam) {
        array = new int[tam];
 
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(90);
        }
         Arrays.sort(array);
    }
 
    public static String arrayToString() {
 
        String resultado = "";
        for (int i = 0; i < array.length; i++) {
            resultado += array[i] + " ";
        }
        return resultado;
    }
 
    public static int buscar(int valor) {
 
        int valorBuscar = valor;
        int inicio = 0;
        int fin = array.length - 1;
        int posicion;
 
        while (inicio <= fin) {
            posicion = (inicio + fin) / 2;
 
            if (array[posicion] == valorBuscar) {
                return posicion;
            } else if (valorBuscar > array[posicion]) {
                inicio = posicion + 1;
            } else {
                fin = posicion - 1;
            }
        }
        return -1;
    }
 
    public static void main(String[] args) {
 
        Scanner entrada = new Scanner(System.in);
        int tamArray;
        int enteroaBuscar=0;
        int resultado;      
 
        System.out.println("Escribe un valor para el tamaño del array: ");
        tamArray = entrada.nextInt();
        BusquedaBinaria.crearArray(tamArray);
        System.out.println("Array creado");
        System.out.println(BusquedaBinaria.arrayToString());
 
        while (enteroaBuscar != -1) {
            System.out.println("Introduce un número a buscar(-1 para salir):");
            enteroaBuscar = entrada.nextInt();
            resultado = BusquedaBinaria.buscar(enteroaBuscar);
 
            if (resultado == -1) {
                System.out.println("El entero " + enteroaBuscar + " no se encontro");
            } else {
                
                System.out.println("El entero " + enteroaBuscar + " se encontro en la posición " + resultado);
            }          
        }
    }

}