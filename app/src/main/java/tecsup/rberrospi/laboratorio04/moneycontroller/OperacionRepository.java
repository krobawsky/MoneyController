package tecsup.rberrospi.laboratorio04.moneycontroller;

import java.util.ArrayList;
import java.util.List;

public class OperacionRepository {

    private static OperacionRepository _INSTANCE = null;

    private OperacionRepository(){}

    public static OperacionRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new OperacionRepository();
        return _INSTANCE;
    }

    private List<Operacion> operacions = new ArrayList<>();

    public List<Operacion> getOperacions() {
        return this.operacions;
    }

    public void agregarOperacion(Operacion operacion) {
        this.operacions.add(operacion);
    }
}
