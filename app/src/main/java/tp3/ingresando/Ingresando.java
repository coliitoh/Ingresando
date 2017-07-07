package tp3.ingresando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import layout.detalles.Detalle_de_usuario;


public class Ingresando extends AppCompatActivity {
     private Button ingresar;
     EditText login;
     EditText password;

    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresando);
        password = (EditText)findViewById(R.id.Textpassword);
        ingresar = (Button)findViewById(R.id.btnIngresar);
        login = (EditText)findViewById(R.id.TextUsuario);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                String usuario = login.getText().toString();
                String contrasena = password.getText().toString();

                if(contrasena.equals("1234") && (usuario.equals("ites")||usuario.equals("ITES")) ) {

                    Toast.makeText(getApplicationContext(), "Datos Correctos", Toast.LENGTH_SHORT).show();
                    Intent ingresar = new Intent(Ingresando.this, Detalle_de_usuario.class);
                    ingresar.putExtra("direccion", login.getText().toString());
                    startActivity(ingresar);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Datos Incorrecto",Toast.LENGTH_SHORT).show();
                  login.setText("");
                  password.setText("");
                }
            }
        });
    }


}
