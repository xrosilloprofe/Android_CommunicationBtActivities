package es.ieslavereda.comunicacinactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CondicionesActivity extends AppCompatActivity {

    private Button bAceptar;
    private Button bCancelar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condiciones);
        Bundle extras = getIntent().getExtras();
        String s = extras.getString("nombre");
        EditText cTexto = findViewById(R.id.condicionesTexto);
        cTexto.setText("Hola " + s + " " + (String) cTexto.getTag());

        bAceptar = findViewById(R.id.aceptar);
        bAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("resultado","aceptar");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        bCancelar = findViewById(R.id.rechazar);
        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("resultado","cancelar");
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });


    }
}
