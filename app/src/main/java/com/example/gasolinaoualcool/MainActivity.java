package com.example.gasolinaoualcool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText valorGasolina, valorAlcool;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorGasolina = findViewById(R.id.gasolina);
        valorAlcool = findViewById(R.id.alcool);
        texto   = findViewById(R.id.resultado);
    }

    public void calcularPreco(View view){
        //Recupera valores digitados
        String precoAlcool= valorAlcool.getText().toString();
        String precoGasolina= valorGasolina.getText().toString();

        //Validar os campos digitados
        // parametros
        Boolean Resultados = validarCampos(precoAlcool,precoGasolina);

        if(Resultados){
            //ele converte o valor String da variavel precoAlcool para Double
           Double ValorAlcool = Double.parseDouble(precoAlcool);
           Double ValorGasolina = Double.parseDouble(precoGasolina);

           //Ideia do Calculo (ValorAlcool/ValorGasolina)>= 0.7
           Double ResultadoCalculo = (ValorAlcool /ValorGasolina);


                   if(ResultadoCalculo >= 0.7){
                      texto.setText("É melhor usar gasolina");
                   }else{
                       texto.setText("É melhor usar Alcool");
                   }


        }else{
            Toast.makeText(this, "Preencha os Precos Primeiro !!!", Toast.LENGTH_SHORT).show();
        }
    }

    public Boolean validarCampos(String PAlcool,String PGasosa){
        //Validacao dos campos
        Boolean Resultados = true;
        if(PAlcool == null || PAlcool.equals("")){ // equals- voce ce se ele e igual a alguma coisa

          Resultados = false;
        }else if(PGasosa == null || PGasosa.equals("")){

           Resultados = false;
        }
        return Resultados;
    }
}


