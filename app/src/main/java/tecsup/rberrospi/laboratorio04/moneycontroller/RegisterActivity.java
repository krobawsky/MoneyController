package tecsup.rberrospi.laboratorio04.moneycontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private RadioGroup radioGroupAccion;
    private Spinner spinnerCategoria;

    private EditText Monto;
    private String categoria;
    private String accion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        radioGroupAccion =  (RadioGroup) findViewById(R.id.radioGroup);
        spinnerCategoria = (Spinner) findViewById(R.id.spinner);
        Monto = (EditText) findViewById(R.id.editText);

        spinnerCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                categoria = parent.getItemAtPosition(pos).toString();
                Toast.makeText(parent.getContext(),
                        "Haz seleccionado: " + categoria,
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }

    public void radioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // This check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    accion = "1";
                Toast.makeText(getApplicationContext(), "Ingreso.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radioButton2:
                accion = "2";
                Toast.makeText(getApplicationContext(), "Egreso.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void Registrar(View view){
        int radioButtonId = radioGroupAccion.getCheckedRadioButtonId();
        String monto = Monto.getText().toString();


        if(monto.isEmpty()){
            Toast.makeText(this, "Tienes que ingresar el monto.", Toast.LENGTH_SHORT).show();
            return;
        } else if (radioButtonId == -1){
            Toast.makeText(this, "Seleccione la acción.", Toast.LENGTH_LONG).show();
        }else {
            Operacion operacion = new Operacion(Double.parseDouble(monto), accion, categoria);
            OperacionRepository operacionRepository = OperacionRepository.getInstance();
            operacionRepository.agregarOperacion(operacion);
            finish();

        }
    }
}
