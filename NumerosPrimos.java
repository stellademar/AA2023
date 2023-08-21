
public class NumerosPrimos {

    public static void main(String[] args) {

        


        System.out.println("Ingrese un numero: ");

        int i = TecladoIn.readLineInt();

        System.out.println("Cantidad de numeros primos entre 1 y "+i+" es: "+contarPrimos(i));

    
    }

    public static boolean esPrimo(int num){

        boolean primo = true;

        // va de 1 a n, si es 0   o 1 no es primo
        if (num <= 1) {
            primo = false;
        }
        /**
         * Propiedad: si hasta la mitad de ese numero no hay divisor, entonces el numero es primo.
         *  */
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                primo =  false;
            }
        }
        return primo;
    }

    public static int contarPrimos(int numero){
        int cant = 0;
        for(int i = 0; i<= numero; i++){
            if(esPrimo(i)){
                cant++;
            }
        }
        return cant;
    }
}
