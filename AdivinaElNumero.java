import java.util.Random;

public class AdivinaElNumero {

    public static void main(String[] args) {
        //random entre 1 y 100
        Random random = new Random();
        int numRandom = random.nextInt(100) + 1;
        int i ;

        System.out.println(numRandom);
        do{
            System.out.println("Ingrese un numero: ");
            i = TecladoIn.readLineInt();
            System.out.println(adivina(i, numRandom));

        }while(i != numRandom);    
        
        System.out.println("Excelente, el numero es: " + numRandom);

    
    }


    public static String adivina(int num, int random){

        String res = "\nEl numero es menor";
        if(random > num){
            res = "\nEl numero es mayor";
        }

        return res;
    }
    
}
