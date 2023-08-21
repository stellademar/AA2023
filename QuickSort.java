public class QuickSort {

    public static void quicksort(double[] arreglo) {
        quicksort(arreglo, 0, arreglo.length - 1);
    }

    public static void quicksort(double[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particionar(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indicePivote - 1);
            quicksort(arreglo, indicePivote + 1, derecha);
        }
    }

    private static int particionar(double[] arreglo, int izquierda, int derecha) {
        double pivote = arreglo[derecha];
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                intercambiar(arreglo, i, j);
            }
        }

        intercambiar(arreglo, i + 1, derecha);
        return i + 1;
    }

    private static void intercambiar(double[] arreglo, int i, int j) {
        double temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }
}