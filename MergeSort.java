import java.util.Arrays;

public class MergeSort {

    
    public static void mergesort(double[] A) {
        sort(A, 0, A.length - 1);
    }

        private static void sort(double[] A, int izq, int der) {
            if (izq < der) {
                int m = (izq + der) / 2;
                sort(A, izq, m); 
                sort(A, m + 1, der);
                merge(A, izq, m, der);
            }
        }

        public static double[] fusionarArreglos(double[] arreglo1, double[] arreglo2) {
            int n1 = arreglo1.length;
            int n2 = arreglo2.length;
            double[] arregloC = new double[n1 + n2];
        
            System.arraycopy(arreglo1, 0, arregloC, 0, n1);
            System.arraycopy(arreglo2, 0, arregloC, n1, n2);
        
            int izq = 0;
            int m = n1 - 1;
            int der = n1 + n2 - 1;
        
            merge(arregloC, izq, m, der);
        
            return arregloC;
        }
        

        private static void merge(double[] A, int izq, int m, int der) {
            int n1 = m - izq + 1; //tamanio primer arreglo
            int n2 = der - m; //tamanio segundo arreglo.

            double[] izquierda = new double[n1];
            double[] derecha = new double[n2];

            System.arraycopy(A, izq, izquierda, 0, n1);
            System.arraycopy(A, m + 1, derecha, 0, n2);
        
            int i = 0, j = 0, k = izq;
        
            while (i < n1 && j < n2) {
                if (izquierda[i] <= derecha[j]) {
                    A[k++] = izquierda[i++];
                } else {
                    A[k++] = derecha[j++];
                }
            }
        
            while (i < n1) {
                A[k++] = izquierda[i++];
            }
        
            while (j < n2) {
                A[k++] = derecha[j++];
            }
        }
    }