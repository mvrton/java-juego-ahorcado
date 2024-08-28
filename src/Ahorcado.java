import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        
        Scanner scan = new Scanner(System.in);

        //Declaraciones
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        //Array
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        //Estructura de control
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while(!palabraAdivinada && intentos < intentosMaximos){
                                                        //Esta es una palabra de chars
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");

            System.out.println("Introduce una letra, por favor");

            char letra = Character.toLowerCase(scan.next().charAt(0));

            boolean letraYaAdivinada = false;
            for (int i = 0; i < letrasAdivinadas.length; i++) {
                if (letrasAdivinadas[i] == letra) {
                    letraYaAdivinada = true;
                    break;
                }
            }

            if (letraYaAdivinada) {
                System.out.println("Ya la habias dicho, estate atento tronco. Te quedan " + (intentosMaximos - intentos) + " intentos");
                intentos++;
                continue; 
            }
            boolean letraCorrecta = false;
            for(int i = 0; i < palabraSecreta.length(); i++){
                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if(!letraCorrecta){
                intentos++;
                System.out.println("Incorrecto, te quedan " + (intentosMaximos - intentos) + " intentos");
            }

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("Enhorabuena! La palabra era: " +palabraSecreta);
            }

        }
        
            if(!palabraAdivinada){
                System.out.println("Game Over colega");
        }

        scan.close();
    }
}
