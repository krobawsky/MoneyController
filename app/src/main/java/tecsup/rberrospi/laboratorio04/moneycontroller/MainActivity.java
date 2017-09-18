package tecsup.rberrospi.laboratorio04.moneycontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;

    private TextView Ahorro;
    private TextView Credito;
    private TextView Efectivo;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ahorro = (TextView) findViewById(R.id.ahorro);
        Credito = (TextView) findViewById(R.id.credito);
        Efectivo   = (TextView) findViewById(R.id.efectivo);
        progressbar = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void add(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        OperacionRepository operacionRepository = OperacionRepository.getInstance();
        List<Operacion> operacions = operacionRepository.getOperacions();

        double totalAhorro = 0;
        double totalCredito = 0;
        double totalEfectivo = 0;

        int progress;
        double total;

        for (Operacion operacion : operacions) {
            if (operacion.getCuenta().equals("Tarjeta de Crédito")) {
                if (operacion.getAccion() == "1") {
                    totalCredito = totalCredito + operacion.getMonto();
                } else  {
                    totalCredito = totalCredito - operacion.getMonto();
                }
                Credito.setText("S/." + totalCredito);
                total = (totalAhorro + totalCredito + totalEfectivo)/100;
                progress = (int) total;
                progressbar.setProgress(progress);

            } else if (operacion.getCuenta().equals("Ahorro")) {
                if (operacion.getAccion() == "1") {
                    totalAhorro = totalAhorro + operacion.getMonto();

                } else {
                    totalAhorro = totalAhorro - operacion.getMonto();
                }
                Ahorro.setText("S/." + totalAhorro);
                total = (totalAhorro + totalCredito + totalEfectivo)/100;
                progress = (int) total;
                progressbar.setProgress(progress);

            } else {
                if (operacion.getAccion() == "1") {
                    totalEfectivo = totalEfectivo + operacion.getMonto();
                } else {
                    totalEfectivo = totalEfectivo - operacion.getMonto();
                }
                Efectivo.setText("S/." + totalEfectivo);
                total = (totalAhorro + totalCredito + totalEfectivo)/100;
                progress = (int) total;
                progressbar.setProgress(progress);

            }
        }
    }
}
