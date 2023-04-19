package es.ieslavereda.comunicacinactividades;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    public static final int ACTIVITY_CODE = 73;
    private Button bVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nombreET = findViewById(R.id.nombreEditText);
        bVerificar = findViewById(R.id.verificarButton);
        TextView resulText = findViewById(R.id.resultadoTextView);


        // Nuevo metodo
        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    // No es necesario identificar la actividad que envia resultados
                    if(result.getResultCode() == RESULT_CANCELED)
                        Toast.makeText(this, "Cancelado por el usuario", Toast.LENGTH_LONG).show();
                    else if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String resultado = data.getExtras().getString("resultado");
                        resulText.setText(resultado);
                    }
                });

        bVerificar.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),CondicionesActivity.class);
            intent.putExtra("nombre",nombreET.getText().toString());
            someActivityResultLauncher.launch(intent);
        });


        //ESTA PARTE LA DEJO, PERO ESTÁ DEPRECATED
//        bVerificar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                lanzarVerificar(null);
//            }
//        });



    }



    //ESTA PARTE LA DEJO, PERO ESTÁ DEPRECATED
//    public void lanzarVerificar(View view){
//        TextView textView = findViewById(R.id.nombre);
//        Intent i = new Intent(this, CondicionesActivity.class);
//        i.putExtra("nombre",textView.getText().toString());
//        startActivityForResult(i, ACTIVITY_CODE);
//
//    }
//
//    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == ACTIVITY_CODE && (resultCode == RESULT_OK || resultCode == RESULT_CANCELED)) {
//            EditText resul = findViewById(R.id.resultado);
//            resul.setText(data.getExtras().getString("resultado"));
//        }
//
//    }

}