package modelo;

public class Ventas {

     int id;
    int idCliente;
    int id_empleado;
    String serie;
    String fecha;
    double monto;


    public Ventas() {
    }

    public Ventas(int id, String serie, String fecha, double monto, int id_empleado, int idCliente) {
        this.id = id;
        this.serie = serie;
        this.fecha = fecha;
        this.monto = monto;
        this.id_empleado = id_empleado;
        this.idCliente = idCliente;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    
}
