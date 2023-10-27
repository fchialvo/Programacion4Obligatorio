public class Arbitro extends Persona implements ABMInterface{

    private static Arbitro ArbitroActual = null;
    private int CantPartidosDirigidos;

    private int AniosArbitrando;

    public Arbitro() {

    }

    public Arbitro(int ced,String nom,String ape,int cantPartidos,int aniosArbitrando,double sueldo){
        super(ced,nom,ape,sueldo);
        this.CantPartidosDirigidos = cantPartidos;
        this.AniosArbitrando=aniosArbitrando;
    }

    public static void ShowReferee(){
        if(ArbitroActual==null){
            System.out.println(Menu.red + "NO HAY NINGÚN ÁRBITRO"+Menu.resetColor);
        }else{
            System.out.println(Menu.green+"Nombre: "+ ArbitroActual.GetNombre() + " | Apellido: "+ ArbitroActual.GetApellido() + " | Cantidad de partidos dirigidos: "+ ArbitroActual.CantPartidosDirigidos+ " | $ "+CalcularSueldo()+Menu.resetColor);
        }
    }

    @Override
    public void Add(){
        int cedula = Menu.RequestNumber("Ingrese Cédula ");
        Menu.Keyboard.nextLine();
        String nombre = Menu.RequestString("Ingrese Nombre ");
        String apellido = Menu.RequestString("Ingrese Apellido ");
        int cantPartidos = Menu.RequestNumber("Ingrese número de partidos dirigidos ");
        Menu.Keyboard.nextLine();
        int aniosArbitrando = Menu.RequestNumber("Ingrese la cantidad de años que lleva arbitrando ");
        Menu.Keyboard.nextLine();
        int sueldo = Menu.RequestNumber("Ingrese su sueldo ");
        Arbitro Agregar = new Arbitro(cedula,nombre,apellido,cantPartidos,aniosArbitrando,sueldo);
        ArbitroActual=Agregar;
    }

    @Override
    public void Delete(){
        ArbitroActual=null;
    }

    @Override
    public void Update() {

    }


    private static double CalcularSueldo(){
        double sueldo = ArbitroActual.GetSueldo();
        if(ArbitroActual.AniosArbitrando<=5)return sueldo;

        int AniosPorEncimade5 = ArbitroActual.AniosArbitrando-5;
        double porcentaje = AniosPorEncimade5*0.03;
        return sueldo*(1+porcentaje);
    }


}
