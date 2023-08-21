import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class EjerciciosInOut {

    //Ejercicio1.1
    /**
     * Consigna: 
     * Utilizando un archivo de entrada que contenga un texto con varias palabras y varias líneas de texto
     * y uno o más espacios en blanco entre ellas, generar `sinEspacios.txt con el mismo texto pero 
     * eliminando todos los espacios en blanco.
     * Mejora para este ejercicio: 
     * - Volcar toda la informacion del buffer de lectura en una estructura intermedia.
     * - Trabajar la informacion, evitando accesos al buffer.
     * - Al finaliar el procesamiento de TODA LA INFORMACION, volcarla en un buffer de escritura.
     * @param fileIn nombre archivo entrada
     * @param fileOut nombre archivo salida
     */
    public static void sinEspacios(String fileIn, String fileOut) {
        String linea = null;
        try {
        FileReader lectorArchivo = new FileReader(fileIn);
        FileWriter escritorArchivo = new FileWriter(fileOut);
        BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
        BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
        while ((linea = bufferLectura.readLine()) != null) {
                if (linea != ""){
                    int longitudLinea = linea.length();
                    for (int i = 0; i<longitudLinea; i++) {
                        char caracter = linea.charAt(i);
                        if(caracter !=' ') {
                            bufferEscritura.write(caracter);
                        }
                    }
                }
            }
            bufferLectura.close();
            bufferEscritura.close();
    }  catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
    }
    }
    //ejercicio1.2
    /**
     * Consigna:
     * Con el mismo archivo de entrada, generar el archivo lineasImpares.txt con solo las lıneas impares del texto
     * Mejora para este ejercicio:
     * Volcar toda la informacion del buffer de lectura en una estructura intermedia.
     * Luego, solo accedera a las posiciones impares en esa estructura, sumando a partir de n + 2, con n = 1.
     * Generar una estructura con las lineas impares y finalmente volcarlo en un buffer.
     * @param fileIn
     * @param fileOut
     */
    public static void lineasImpares(String fileIn,String fileOut) {
    String linea = null;
    int numLinea = 0;
        try {
        FileReader lectorArchivo = new FileReader(fileIn);
        FileWriter escritorArchivo = new FileWriter(fileOut);
        BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
        BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
        while ((linea = bufferLectura.readLine()) != null) {
                if (numLinea%2 != 0){
                    bufferEscritura.write(linea +"\n");
                }
                numLinea++; 
            }
            bufferLectura.close();
            bufferEscritura.close();
    }  catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
    }
}
    //ejercicio1.3
    /**
     * Consigna:
     * Generar un archivo de texto que contenga 100 números reales (double o float) generados aleatoriamente con valores entre -100 y 100.
     * Mejora:
     * Generar todos los numeros, colocarlos en una estructura, finalmente, generar el buffer.
     * @param fileOut archivo de escritura.
     */ 
    public static void generarDouble(String fileOut) {
        int cantnum = 100 ;
        int maxval = 100;
        int minval = -100;
        try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(fileOut));
    		Random generador = new Random();
    		for (int i = 0; i < cantnum ; i++){
    			double num = generador.nextDouble(minval,maxval);
    			buff.write( num +"\n");
    		}
    		buff.close();
    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
    //ejercicio1.4
    /**
     * Consigna:
     * Generar un archivo de texto con cadenas aleatorias de 10 caracteres alfanuméricos (0-9, a-z,A-Z).
     * Otra solucion: tener el rango de la tabla ASCII de los caracteres, transformar el valor ASCII a un char.
     * Mejora: usar estructura intermedia con las cadenas correspondientes, finalmente, volcarla en un buffer.
     * @param fileOut archivo escritura.
     */
    public static void generarAlfanum(String fileOut) {
        int cantcad = 10 ;
        int cantcar = 10;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String cadena = "";
        int maxval = characters.length();
        int minval = 0;
        try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(fileOut));
    		Random generador = new Random();
    		for (int i = 0; i < cantcad ; i++){
                //recorre cadena
                for (int j = 0; j< cantcar; j++) {
                    int pos = generador.nextInt(minval,maxval);
                    char randomChar = characters.charAt(pos);
    			    cadena+=randomChar;
                }
                buff.write( cadena +"\n");
                cadena = "";
    		}
    		buff.close();
    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
    //ejercicio1.5
    /**
     * Consigna:
     * Generar un archivo con números aleatorios de los números del 1 al 1000 sin que los elementos se repitan.
     * Mejora: generar los numeros y colocarlos de forma ordenada, para evitar consultas repetidas.
     * Usar estructura intermedia y acceder al buffer al final, cuando ya se tiene toda la estructura de numeros armada.
     * @param fileOut archivo escritura.
     */
    public static void noRepetir(String fileOut) {
        int maxValue = 1000;
        int minValue = 0;
        int cantidadNum = 20;
        int i = 0;
        ArrayList<Integer> arreglo = new ArrayList<Integer>();
        try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(fileOut));
    		Random generador = new Random();
    		while( i <= cantidadNum){
                    int randomInt = generador.nextInt(minValue,maxValue);
                    if(!arreglo.contains(randomInt)){
                        arreglo.add(randomInt);
                        buff.write(randomInt+ "\n");
                        i++;
                    }
                }
                buff.close();
    	} catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static void main(String[] args) {
        String nombreArchivoEntrada = "./entradaU.txt";
        String nombreArchivoS1 = "./sinEspacios.txt";
        String nombreArchivoS2 = "./lineasImpares.txt";
        String nombreArchivoS3 = "./aleatorioDouble.txt";
        String nombreArchivosS4 = "./aleatorioCadena.txt";
        String nombreArchivoS5 = "./noRepetidos.txt";
        //sinEspacios(nombreArchivoEntrada, nombreArchivoS1);
        //lineasImpares(nombreArchivoEntrada, nombreArchivoS2);
        //generarDouble(nombreArchivoS3);
        //generarAlfanum(nombreArchivosS4);
        //noRepetir(nombreArchivoS5);
    }
}
