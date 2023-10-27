import java.util.ArrayList;

public class Tecnico extends Persona{

    private static ArrayList<Tecnico> Tecnicos = new ArrayList<Tecnico>();

    private String Equipo;

    private int TotalPartidosGanados;

    public Tecnico(int ced,String nom,String ape, String equipo,double sueldo,int totalPartidosGanados){
        super(ced,nom,ape,sueldo);
        this.Equipo = equipo;
        this.TotalPartidosGanados = totalPartidosGanados;
    }

    public static boolean ShowCoach(){
        if(Tecnicos.isEmpty()){
            System.out.println(Menu.red+"No hay Técnicos"+Menu.resetColor);
            return false;
        }
        byte cont = 1;
        for (Tecnico untec:Tecnicos
             ) {
            System.out.println(Menu.green + cont + ". nombre: "+untec.GetNombre() + " apellido: "+untec.GetApellido() + " Equipo: "+ untec.Equipo+ " $"+ CalcularSueldo(untec)+ Menu.resetColor);
            cont++;
        }
        return true;
    }


    public static void AddCoach(){
        if(TooManyCoaches()){
            return;
        }
        int cedula = Menu.RequestNumber("Ingrese cedula ");
        Menu.Keyboard.nextLine();
        String nombre = Menu.RequestString("Ingrese Nombre ");
        String apellido = Menu.RequestString("Ingrese Apellido ");
        String equipo = Menu.RequestString("Ingrese un Equipo ");
        double sueldo = Menu.RequestNumberDouble("Ingrese un Sueldo ");
        Menu.Keyboard.nextLine();
        int totalPartidosGanados = Menu.RequestNumber("Ingrese el total de partidos ganados ");
        if(RepeatedTeam(equipo)){
            System.out.println(Menu.red + "El equipo ingresado ya tiene un técnico"+Menu.resetColor);
        }else{
            Tecnico untec = new Tecnico(cedula,nombre,apellido,equipo,sueldo,totalPartidosGanados);
            Tecnicos.add(untec);
        }
    }

    public static void DeleteCoach(){
        if(!ShowCoach()){
            return;
        }
        int num = Menu.RequestNumber("Ingrese el numero del técnico a eliminar")-1;
        if(num<0||num>Tecnicos.size()-1){
            System.out.println(Menu.red + "Número no válido"+ Menu.resetColor);
        }else{
            Tecnicos.remove(Tecnicos.get(num));
        }
    }
    public static void UpdateCoach(){
        if(!ShowCoach()){
            return;
        }
        int num = Menu.RequestNumber("Ingrese el numero del técnico a Actualizar")-1;
        if(num<0 || num>Tecnicos.size()-1){
            System.out.println(Menu.red +"Número no válido"+Menu.resetColor);
            return;
        }
        Tecnico datosViejos = Tecnicos.get(num);
        Tecnico TecnicoViejo = new Tecnico(datosViejos.GetCedula(),datosViejos.GetNombre(),datosViejos.GetApellido(),datosViejos.Equipo,datosViejos.GetSueldo(),datosViejos.TotalPartidosGanados);

        int cedula = Menu.RequestNumber("Ingrese cedula ");
        Menu.Keyboard.nextLine();
        String nombre = Menu.RequestString("Ingrese Nombre ");
        String apellido = Menu.RequestString("Ingrese Apellido ");
        String equipo = Menu.RequestString("Ingrese un Equipo ");
        double sueldo = Menu.RequestNumberDouble("Ingrese un Sueldo ");
        Menu.Keyboard.nextLine();
        int totalPartidosGanados = Menu.RequestNumber("Ingrese el total de partidos ganados ");
        Tecnico untec = new Tecnico(cedula,nombre,apellido,equipo,sueldo,totalPartidosGanados);
        Tecnicos.remove(num);
        Tecnicos.add(untec);

        if(RepeatedTeam()){
            System.out.println(Menu.red + "no se pueden tener dos técnicos en un mismo equipo, cambios revertidos"+Menu.resetColor);
            Tecnicos.remove(untec);
            Tecnicos.add(TecnicoViejo);
        }


    }
    public static boolean TooManyCoaches(){
        if(Tecnicos.size()>=2){
            System.out.println(Menu.red+"Solo se permiten tener 2 técnicos en total, uno por equipo");
            return true;
        }return false;
    }

    //Use this if you want to check repeated team BEFORE adding the object
    public static boolean RepeatedTeam(String equipo){
        for (Tecnico untec:Tecnicos ) {
            if(untec.Equipo.equalsIgnoreCase(equipo)){
                return true;
            }
        }
        return false;
    }
    //Use this if you want to check AFTER adding the object
    public static boolean RepeatedTeam(){
        if(Tecnicos.size()>1){
            return Tecnicos.get(0).Equipo.equalsIgnoreCase(Tecnicos.get(1).Equipo);
        }
        return false;
    }

    public static double CalcularSueldo(Tecnico untec){
        if(untec.TotalPartidosGanados>=3)return untec.GetSueldo()*1.10;
        return untec.GetSueldo();
    }

}
