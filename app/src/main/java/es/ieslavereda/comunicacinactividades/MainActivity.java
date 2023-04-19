package es.ieslavereda.comunicacinactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bVerificar = findViewById(R.id.verificar);
        bVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarVerificar(null);
            }
        });



    }

    public void lanzarVerificar(View view){
        TextView textView = findViewById(R.id.nombre);
        Intent i = new Intent(this, CondicionesActivity.class);
        i.putExtra("nombre",textView.getText().toString());
        startActivityForResult(i,73);

    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 73 && (resultCode == RESULT_OK || resultCode == RESULT_CANCELED)) {
            EditText resul = findViewById(R.id.resultado);
            resul.setText(data.getExtras().getString("resultado"));
        }

    }

}