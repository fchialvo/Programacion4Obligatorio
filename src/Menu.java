
import java.util.Scanner;

public class Menu {
    public static Scanner Keyboard = new Scanner(System.in);


    public static String resetColor = "\u001B[0m"; // Reset text color
    public static String red = "\u001B[31m";   // Red text
    public static String green = "\u001B[32m"; // Green text
    public static String yellow = "\u001B[33m"; // Yellow text
    public static String blue = "\u001B[34m";   // Blue text


    public static void ShowMenu(){
        ClearScreen();
        boolean salir = false;

        while(!salir){
            System.out.println(blue);
            System.out.println("MENÚ PRINCIPAL:");
            System.out.println("1. Menú Jugadores");
            System.out.println("2. Menú Técnicos");
            System.out.println("3. Menú Árbitro");
            System.out.println("0. Salir");
            System.out.println(resetColor);

            int num = RequestNumber("Elija una opción: ");
                switch (num) {
                    case 1 -> MenuJugadores();
                    case 2 -> MenuTecnicos();
                    case 3 -> MenuArbitros();
                    case 0 -> salir = true;
                    default -> System.out.println(Menu.red+"No es un numero válido"+Menu.resetColor);
                }
        }
    }

    private static void MenuJugadores(){
        boolean salir = false;
        Jugador jugador = new Jugador();

        while(!salir) {
            ClearScreen();
            System.out.println(Menu.blue);
            System.out.println("MENÚ JUGADORES");
            System.out.println("1. Mostrar Jugadores");
            System.out.println("2. Agregar Jugador");
            System.out.println("3. Eliminar Jugador");
            System.out.println("4. Actualizar un jugador");
            System.out.println("0 . Atrás");

            System.out.println(Menu.resetColor);

            int num = RequestNumber("Elija una opción: ");

            switch (num) {
                case 1 -> Jugador.ShowPlayers();
                case 2 -> jugador.Add();
                case 3 -> jugador.Delete();
                case 4 -> jugador.Update();
                case 0 -> salir=true;
                default -> System.out.println(Menu.red+"No es un número válido"+Menu.resetColor);
            }
        }
    }

    private static void MenuArbitros(){
        boolean salir = false;
        Arbitro arbitro = new Arbitro();

        while(!salir) {
            ClearScreen();
            System.out.println(Menu.blue);
            System.out.println("MENU ÁRBITROS");
            System.out.println("1. Mostrar Árbitro");
            System.out.println("2. Agregar/Actualizar Árbitro");
            System.out.println("3. Eliminar Árbitro");
            System.out.println("0 . Atrás");



            System.out.println(Menu.resetColor);

            int num = RequestNumber("Elija una opción: ");

            switch (num) {
                case 1 -> Arbitro.ShowReferee();
                case 2 -> arbitro.Add();
                case 3 -> arbitro.Delete();
                case 0 ->{
                    salir=true;
                }
                default -> {
                    System.out.println(Menu.red+"No es un número válido"+Menu.resetColor);
                }
            }
        }
    }
    private static void MenuTecnicos(){
        boolean salir = false;
        Tecnico tecnico = new Tecnico();

        while(!salir) {
            ClearScreen();
            System.out.println(Menu.blue);
            System.out.println("MENÚ TÉCNICOS");
            System.out.println("1. Mostrar Técnicos");
            System.out.println("2. Agregar Técnicos");
            System.out.println("3. Eliminar Técnicos");
            System.out.println("4. Actualizar Técnicos");
            System.out.println("0 . Atrás");
            System.out.println(Menu.resetColor);

            int num = RequestNumber("Elija una opción: ");

            switch (num) {
                case 1 -> Tecnico.ShowCoach();
                case 2 -> tecnico.Add();
                case 3 -> tecnico.Delete();
                case 4 -> tecnico.Update();
                case 0 -> salir=true;
                default -> System.out.println(Menu.red+"No es un número válido"+Menu.resetColor);
            }
        }
    }

    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static String RequestString(String msg){
        System.out.print(Menu.yellow + msg + Menu.resetColor);
        return Menu.Keyboard.nextLine();
    }
    public static int RequestNumber(String msg){
        int number = 0;
        System.out.print(Menu.yellow + msg+ Menu.resetColor);
        while (true){
            if(Menu.Keyboard.hasNextInt()){
                number = Menu.Keyboard.nextInt();
                break;
            }else{
                System.out.println(Menu.red +"Error: Debe ingresar un número válido. Intente nuevamente." + Menu.resetColor);
                Menu.Keyboard.next();
            }
        }

        return number;
    }
    public static double RequestNumberDouble(String msg){
        double number = 0;
        System.out.print(Menu.yellow + msg+ Menu.resetColor);
        while (true){
            if(Menu.Keyboard.hasNextDouble()){
                number = Menu.Keyboard.nextDouble();
                break;
            }else{
                System.out.println(Menu.red +"Error: Debe ingresar un número válido. Intente nuevamente." + Menu.resetColor);
                Menu.Keyboard.next();
            }
        }

        return number;
    }
}
