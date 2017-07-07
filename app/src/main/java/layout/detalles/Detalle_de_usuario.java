package layout.detalles;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;

import tp3.ingresando.Ingresando;
import tp3.ingresando.R;

public class Detalle_de_usuario extends AppCompatActivity {
    TextView usuario;
    EditText telefono;
    Button marcar, finalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_usuario);

        finalizar = (Button) findViewById(R.id.btnfinalizar);
        marcar = (Button) findViewById(R.id.btnmarcar);
        telefono = (EditText) findViewById(R.id.EditTelefono);
        usuario = (TextView) findViewById(R.id.editusuario);

        Bundle bundle = getIntent().getExtras();
        usuario.setText("Bienvenido " + bundle.getString("direccion"));

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(Detalle_de_usuario.this, Ingresando.class);
                Toast.makeText(getApplicationContext(), "INGRESE SU USUARIO Y CONTRASEÑA", Toast.LENGTH_LONG).show();
                startActivity(volver);

            }
        });

        marcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String tel = telefono.getText().toString();
                if(!TextUtils.isEmpty(tel)) {
                    String numero = "tel:" + tel;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(numero)));
                }else {
                    Toast.makeText(Detalle_de_usuario.this, "INGRESE UN NUMERO DE TELEFONO", Toast.LENGTH_SHORT).show();
                }
            }
        });

        }


    }




