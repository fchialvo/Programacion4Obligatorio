public class Persona {
    private int Cedula;

    private String Nombre;

    private String Apellido;

    private double Sueldo;

    public Persona(int ced,String nom,String ape,double suel){
        this.Cedula=ced;
        this.Nombre=nom;
        this.Apellido=ape;
        this.Sueldo=suel;
    }

    public Persona() {

    }

    protected int GetCedula(){
        return this.Cedula;
    }
    protected String GetNombre(){
        return this.Nombre;
    }
    protected String GetApellido(){
        return this.Apellido;
    }
    protected double GetSueldo(){return this.Sueldo;}

}
