package br.com.aula.calculodeimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edpeso, edaaltura, edres;
    Button calcular, limpar;
    double peso, altura, res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edpeso = findViewById(R.id.edpeso);
        edaaltura = findViewById(R.id.edaltura);
        edres = findViewById(R.id.edres);
        calcular = findViewById(R.id.calcular);
        limpar = findViewById(R.id.limpar);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.calcular) {
                    peso = Double.parseDouble(edpeso.getText().toString());
                    altura = Double.parseDouble(edaaltura.getText().toString());
                    res = peso / (altura * altura);

                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("ÍNDICE DE MASSA COPÓREA (IMC):");
                    dialogo.setMessage(String.format("RESULTADO = %.2f", res));
                    dialogo.setPositiveButton("OK", null);
                    dialogo.show();
                }
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {

          @Override
            public void onClick(View v) {
              if (v.getId() == R.id.limpar) {
                  edpeso.setText("");
                  edaaltura.setText("");
                  edres.setText("");
                  edpeso.requestFocus();

                  Toast.makeText(MainActivity.this, "Os dados foram apagados com sucesso!", Toast.LENGTH_LONG).show();
              }
          }
        });
    }
}
