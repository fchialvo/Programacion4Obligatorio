import java.util.ArrayList;
public class Jugador extends Persona implements ABMInterface{

    private static ArrayList<Jugador> Jugadores = new ArrayList<Jugador>();

    private String Posicion;

    private String Equipo;

    private int MinutosJugados;

    public Jugador() {

    }
    public Jugador(int ced,String nom,String ape,String pos, String equip, int minutos,double sueldo){
        super(ced,nom,ape,sueldo);
        this.Posicion=pos;
        this.Equipo = equip;
        this.MinutosJugados=minutos;
    }

    @Override
    public void Add() {
        if(Jugadores.size()==14){
            System.out.println(Menu.red);
            System.out.println("Numero máximo de jugadores alcanzado");
            System.out.println(Menu.resetColor);
            return;
        }

        System.out.println(Menu.yellow);
        int cedula = Menu.RequestNumber("Ingrese Cédula ");
        Menu.Keyboard.nextLine();
        String nombre = Menu.RequestString("Ingrese Nombre ");
        String apellido = Menu.RequestString("Ingrese Apellido ");
        String posicion = Menu.RequestString("Ingrese Posición ");
        String equipo = Menu.RequestString("Ingrese Equipo ");
        int minutos = Menu.RequestNumber("Ingrese Minutos ");
        Menu.Keyboard.nextLine();
        double sueldo = Menu.RequestNumberDouble("Ingrese un Sueldo ");

        if(TeamFull(equipo)){
            System.out.println(Menu.red + "ESE EQUIPO YA TIENE 7 JUGADORES" + Menu.resetColor);
        }
        else {
            Jugador Agregar = new Jugador(cedula,nombre,apellido,posicion,equipo,minutos,sueldo);
            Jugadores.add(Agregar);
            if(TotalTeams()>2){
                Jugadores.remove(Agregar);
                System.out.println(Menu.red+"NO SE PERMITE AGREGAR MÁS DE 2 EQUIPOS DIFERENTES"+Menu.resetColor);
            }
        }
    }

    @Override
    public void Delete() {
        if(Jugadores.isEmpty()){
            System.out.println(Menu.red+"NO HAY JUGADORES QUE ELIMINAR"+Menu.resetColor);
        }else{
            ShowPlayers();
            System.out.println("Ingrese el número de jugador que desea eliminar:");

            int num = Menu.Keyboard.nextInt() -1;

            if(num<0 || num> Jugadores.size()-1){
                System.out.println(Menu.red);
                System.out.println("El valor no es válido");
                System.out.println(Menu.resetColor);
            }else{
                Jugadores.remove(Jugadores.get(num));
            }
        }
    }
    @Override
    public void Update() {
        if(Jugadores.isEmpty()){
            System.out.println(Menu.red + "No hay jugadores disponibles"+Menu.resetColor);
            return;
        }
        ListAll();
        int numero = Menu.RequestNumber("Elija el número del jugador que desea actualizar: ")-1;
        if(numero<0||numero>Jugadores.size()-1){
            System.out.println(Menu.red + "El número no es válido"+ Menu.resetColor);
            return;
        }

        Jugador datosViejos = Jugador.Jugadores.get(numero);
        Jugador Jugadorviejo = new Jugador(datosViejos.GetCedula(),datosViejos.GetNombre(),datosViejos.GetApellido(),datosViejos.Posicion,datosViejos.Equipo, datosViejos.MinutosJugados,datosViejos.GetSueldo());

        int cedula = Menu.RequestNumber("Ingrese Cédula ");
        Menu.Keyboard.nextLine();
        String nombre = Menu.RequestString("Ingrese Nombre ");
        String apellido = Menu.RequestString("Ingrese Apellido ");
        String posicion = Menu.RequestString("Ingrese Posición ");
        String equipo = Menu.RequestString("Ingrese Equipo ");
        int minutos = Menu.RequestNumber("Ingrese Minutos ");
        Menu.Keyboard.nextLine();
        double sueldo = Menu.RequestNumberDouble("Ingrese un Sueldo ");
        Jugador Actualizado = new Jugador(cedula,nombre,apellido,posicion,equipo,minutos,sueldo);
        Jugadores.remove(datosViejos);
        Jugadores.add(Actualizado);

        if(TotalTeams()>2){
            System.out.println(Menu.red + "No se permiten tener más de 2 equipos, cambios revertidos"+Menu.resetColor);
            Jugadores.remove(Actualizado);
            Jugadores.add(Jugadorviejo);
        }
    }

    public static void ShowPlayers(){
        if(Jugadores.isEmpty()){
            System.out.println(Menu.red + "No hay jugadores disponibles"+Menu.resetColor);
        }else{
            ListAll();
        }
    }


    private static int TotalTeams(){
        int totalTeams = 0;
        ArrayList<String> TeamsActuales = new ArrayList<String>();
        for(Jugador unjug:Jugadores){
            if(!TeamsActuales.contains(unjug.Equipo.toLowerCase())){
                totalTeams++;
                TeamsActuales.add(unjug.Equipo.toLowerCase());
            }
        }
        return totalTeams;
    }

    private static boolean TeamFull(String equipo){
        int total = 0;
        for (Jugador unjug:Jugadores) {
            if(unjug.Equipo.equalsIgnoreCase(equipo)){
                total++;
            }
        }
        return total == 7;
    }

    private static double CalcularSueldo(Jugador unjug){
        double sueldo = unjug.GetSueldo();
        return sueldo*(1.20);
    }

    private String ListItem(){
        return Menu.green +"CI: " +super.GetCedula() + " | " + "Nombre: "+ super.GetNombre() + " | " + "Apellido: "+super.GetApellido() +
                " | " + "Posición: "+ this.Posicion + " | " + "Equipo: "+ this.Equipo + " | " + " Minutos: "+ this.MinutosJugados + " | ";
    }

    private static void ListAll(){
        int num = 1;
        for (Jugador unjug:Jugadores){
            System.out.println(num + ". " + unjug.ListItem() + " $ "+CalcularSueldo(unjug) + Menu.resetColor);
            num++;
        }
    }







}

