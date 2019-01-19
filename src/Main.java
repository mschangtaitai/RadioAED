import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        int selection,a;
        a=0;
        RadioInterface radio = new Radio();
        Scanner scan = new Scanner (System.in);
        System.out.print ("Bienvenido al menu de la radio \n Aqui podra tener varios accesos a ciertos modos y estaciones. \n Tendra que escribir el numero que corresponde a la actividad que le interese. ");
        System.out.print ("1. cambiar modo FM a AM \n 2.Cambiar estacion \n 3. Guardar estacion actual\n 4.cambiar frecuencia\n 5.Apagar radio");
        selection = scan.nextInt();
        while (a!=1){

            switch (selection){
                case 1:
                    radio.changeFrequency();
                    System.out.println ("Se ha cambiado efectivamente!");
                    break;
                case 2:
                    System.out.println ("Desea subir o bajar de estacion? \n 1. subir \n 2. bajar");
                    selection = scan.nextInt();
                    if (selection == 1){
                        radio.changeStation(true);
                    } else if (selection == 2){
                        radio.changeStation(false);
                    }
                    break;
                case 3:
                    System.out.println ("En donde desea guardarlo?(1-12)");
                    selection = scan.nextInt();
                    radio.saveStation(selection);
                    System.out.println ("Se ha guardado exitosamente!");
                    break;
                case 4:
                    System.out.println ("Que estacion desea escuchar?(1-12)");
                    selection = scan.nextInt();
                    radio.changeStationButton(selection);
                    System.out.println ("Cambiado! (Mostrar siguiente estacion)");
                    break;
                case 5:
                    radio.toggle();
                    a = 1;
                    break;
                default:
                    System.out.println ("Escriba un numero de los que se muestran en las instrucciones");
            }
        }

    }
}