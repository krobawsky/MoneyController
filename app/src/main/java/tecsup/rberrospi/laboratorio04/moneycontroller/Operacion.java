package tecsup.rberrospi.laboratorio04.moneycontroller;

public class Operacion {

    private Double monto;
    private String accion;
    private String cuenta;

    @Override
    public String toString() {
        return "Operacion{" +
                "monto=" + monto +
                "accion=" + accion +
                ", cuenta='" + cuenta + '\'' +
                '}';
    }

    public Operacion(Double monto, String accion, String cuenta) {
        this.monto = monto;
        this.accion = accion;
        this.cuenta = cuenta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

}
