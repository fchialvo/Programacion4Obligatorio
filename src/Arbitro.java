public class Arbitro extends Persona{

    private static Arbitro ArbitroActual = null;
    private int CantPartidosDirigidos;

    private int AniosArbitrando;

    public static void ShowReferee(){
        if(ArbitroActual==null){
            System.out.println(Menu.red + "NO HAY NINGUN ÁRBITRO"+Menu.resetColor);
        }else{
            System.out.println(Menu.green+"Nombre: "+ ArbitroActual.GetNombre() + " Apellido: "+ ArbitroActual.GetApellido() + " Cantidad de partidos dirigidos: "+ ArbitroActual.CantPartidosDirigidos+ " $ "+CalcularSueldo()+Menu.resetColor);
        }
    }

    public static void AddReferee(){
        int cedula = Menu.RequestNumber("Ingrese cedula ");
        Menu.Keyboard.nextLine();
        String nombre = Menu.RequestString("Ingrese Nombre ");
        String apellido = Menu.RequestString("Ingrese Apellido ");
        int cantPartidos = Menu.RequestNumber("Ingrese numero de partidos dirigidos ");
        Menu.Keyboard.nextLine();
        int aniosArbitrando = Menu.RequestNumber("Ingrese la cantidad de años que lleva arbitrando ");
        Menu.Keyboard.nextLine();
        int sueldo = Menu.RequestNumber("Ingrese su Sueldo ");
        Arbitro Agregar = new Arbitro(cedula,nombre,apellido,cantPartidos,aniosArbitrando,sueldo);
        ArbitroActual=Agregar;

    }


    private static double CalcularSueldo(){
        double sueldo = ArbitroActual.GetSueldo();
        if(ArbitroActual.AniosArbitrando<=5)return sueldo;

        int AniosPorEncimade5 = ArbitroActual.AniosArbitrando-5;
        double porcentaje = AniosPorEncimade5*0.03;
        return sueldo*(1+porcentaje);
    }

    public static void DeleteReferee(){
        ArbitroActual=null;
    }

    public Arbitro(int ced,String nom,String ape,int cantPartidos,int aniosArbitrando,double sueldo){
        super(ced,nom,ape,sueldo);
        this.CantPartidosDirigidos = cantPartidos;
        this.AniosArbitrando=aniosArbitrando;
    }


}
