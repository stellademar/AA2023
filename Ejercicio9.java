import java.util.Random;
import java.util.Arrays;

public class Ejercicio9 {
    public static void main(String[] args) {
        //Generamos dos arreglos de double en vez de enteros para trabajar mejor con los alg. de ordenamiento implementados.
    double[] arrA = generarArregloDesordenado(100);
    double[] arrB = generarArregloDesordenado(60);
    double[] arrC;
    
    // Imprimir el arreglo ordenado
    System.out.println("Arreglo A:");
    for (int i = 0; i < arrA.length; i++) {
        double num = arrA[i];
        System.out.print((int) num + " ");
    }

    //Imprimir el arreglo ordenado
    System.out.println("\nArreglo B:");
    for (int i = 0; i < arrB.length; i++) {
    double num = arrB[i];
    System.out.print((int) num + " ");
    }


    //arregla arreglo A, con algoritmo merge.
    MergeSort.mergesort(arrA);
    //arregla arreglo B, con quicksort.
    QuickSort.quicksort(arrB);
    //fusiona arreglos, reutilizando codigo de mergesort.
    arrC = MergeSort.fusionarArreglos(arrA,arrB);

    System.out.println("\nArreglo C:");
    for (int i = 0; i < arrC.length; i++) {
    double num = arrC[i];
    System.out.print((int) num + " ");
    }


    }
    public static double[] generarArregloDesordenado(int tamaño) {
        double[] arr = new double[tamaño];
        Random rand = new Random();
        
        for (int i = 0; i < tamaño; i++) {
            arr[i] = (double) rand.nextInt(1000); // Generar números aleatorios entre 0 y 999
        }
        
        return arr;
    }
}
