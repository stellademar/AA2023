
import java.util.*;

public class Ejercicio8 {
    public static void main(String[] args) {
        // Definir la matriz de calificaciones (5 alumnos x 5 asignaturas)
        // Cada columna representa una asignatura diferente, cada fila es un alumno.
        double[][] calificaciones = {
            {8.5, 7.0, 9.2, 6.8, 8.9},
            {7.2, 6.5, 8.0, 7.8, 7.5},
            {9.0, 8.8, 7.5, 8.2, 9.5},
            {6.8, 7.5, 6.0, 7.2, 6.5},
            {8.2, 9.5, 8.8, 9.0, 8.7}
        };
        
        // b. Calcular el promedio de calificaciones por asignatura
        double[] promediosAsignaturas = calcularPromediosAsignaturas(calificaciones);
        
        // a .Calcular el promedio de calificaciones por alumno
        double[] promediosAlumnos = calcularPromediosAlumnos(calificaciones);
        
        // Imprimir los promedios de calificaciones por asignatura
        System.out.println("Promedios de calificaciones por asignatura:");
        for (int j = 0; j < promediosAsignaturas.length; j++) {
            System.out.println("Asignatura " + (j+1) + ": " + promediosAsignaturas[j]);
        }
        
        // Imprimir los promedios de calificaciones por alumno
        System.out.println("\nPromedios de calificaciones por alumno:");
        for (int i = 0; i < promediosAlumnos.length; i++) {
            System.out.println("Alumno " +(i+1) +": "+ promediosAlumnos[i]);

        }

        // c. Imprimir promedio total de la clase.
        System.out.println("\nPromedio total de la clase: "+promedioDeLaClase(promediosAlumnos));

        //para no perder la estructura original, mantenemos una copia del promedio de alumnos.
        double [] copia = Arrays.copyOf(promediosAlumnos,promediosAlumnos.length);
        QuickSort.quicksort(copia); 
        System.out.print("Arreglo ordenado con quicksort: \n [" );
        double [] ordenadoDescendente = new double[copia.length];
        int j = 0;
        for (int it = copia.length - 1; it >= 0; it--) {
            ordenadoDescendente[j] = copia[it];
            System.out.print(ordenadoDescendente[j]+ ",");
            j++;
        }  
        System.out.println("]");
    }

    //c.
    public static double promedioDeLaClase(double[] promedio){
        double promedioTotal = 0.0;
        for (int i = 0; i < promedio.length; i++) {
            promedioTotal += promedio[i];
        }
        return promedioTotal;

    }

    //b.
    public static double[] calcularPromediosAsignaturas(double[][] calificaciones) {
        double[] promedios = new double[calificaciones[0].length];
        
        for (int j = 0; j < calificaciones[0].length; j++) {
            double suma = 0.0;
            for (int i = 0; i < calificaciones.length; i++) {
                suma += calificaciones[i][j];
            }
            promedios[j] = suma / calificaciones.length;
        }
        
        return promedios;
    }

    //a.
    public static double[] calcularPromediosAlumnos(double[][] calificaciones) {
        double[] promedios = new double[calificaciones.length];
        
        for (int i = 0; i < calificaciones.length; i++) {
            double suma = 0.0;
            for (int j = 0; j < calificaciones[i].length; j++) {
                suma += calificaciones[i][j];
            }
            promedios[i] = suma / calificaciones[i].length;
        }
        
        return promedios;
    }
}
