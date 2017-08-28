package com.johnduran.p1figurasgeometricas;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double Area=0, Perimetro=0, Volumen=0, elado=0, eradio=0, eladoA=0, eladoB=0, eladoC=0,Semiperimetro=0;
    private EditText eLado, eRadio,eLadoA, eLadoB, eLadoC;
    private RadioButton rCuadro, rCirculo, rTriangulo, rCubo;
    private TextView tResultado,tLadoA,tLadoB,tLadoC,tLado,tRadio;
    private RadioGroup rRadioGrupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eLado = (EditText) findViewById(R.id.eLado);
        eRadio = (EditText) findViewById(R.id.eRadio);
        eLadoA = (EditText) findViewById(R.id.eLadoA);
        eLadoB = (EditText) findViewById(R.id.eLadoB);
        eLadoC = (EditText) findViewById(R.id.eLadoC);
        rCuadro = (RadioButton) findViewById(R.id.rCuadro);
        rCirculo = (RadioButton) findViewById(R.id.rCirculo);
        rTriangulo = (RadioButton) findViewById(R.id.rTriangulo);
        rCubo = (RadioButton) findViewById(R.id.rCubo);
        tResultado = (TextView) findViewById(R.id.tResultado);
        rRadioGrupo= (RadioGroup) findViewById(R.id.rRadioGrupo);
        tLadoA= (TextView) findViewById(R.id.tLadoA);
        tLadoB= (TextView) findViewById(R.id.tLadoB);
        tLadoC= (TextView) findViewById(R.id.tLadoC);
        tLado= (TextView) findViewById(R.id.tLado);
        tRadio= (TextView) findViewById(R.id.tRadio);
        OpcionesCuadroCubo();
        rRadioGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
               OpcionesCuadroCubo();
                tResultado.setText("");
                if (rCirculo.isChecked()){
                    tRadio.setVisibility(View.VISIBLE);
                    eRadio.setVisibility(View.VISIBLE);
                    tLado.setVisibility(View.GONE);
                    tLadoA.setVisibility(View.GONE);
                    tLadoB.setVisibility(View.GONE);
                    tLadoC.setVisibility(View.GONE);
                    eLadoA.setVisibility(View.GONE);
                    eLadoB.setVisibility(View.GONE);
                    eLadoC.setVisibility(View.GONE);
                    eLado.setVisibility(View.GONE);
                }
                if (rTriangulo.isChecked()){
                    tLado.setVisibility(View.GONE);
                    eLado.setVisibility(View.GONE);
                    tRadio.setVisibility(View.GONE);
                    eRadio.setVisibility(View.GONE);
                    tLadoA.setVisibility(View.VISIBLE);
                    tLadoB.setVisibility(View.VISIBLE);
                    tLadoC.setVisibility(View.VISIBLE);
                    eLadoA.setVisibility(View.VISIBLE);
                    eLadoB.setVisibility(View.VISIBLE);
                    eLadoC.setVisibility(View.VISIBLE);
                }

            }
        });

    }
    public void OpcionesCuadroCubo(){
        if (rCubo.isChecked() || rCuadro.isChecked()){
            tLado.setVisibility(View.VISIBLE);
            eLado.setVisibility(View.VISIBLE);
            tRadio.setVisibility(View.GONE);
            tLadoA.setVisibility(View.GONE);
            tLadoB.setVisibility(View.GONE);
            tLadoC.setVisibility(View.GONE);
            eRadio.setVisibility(View.GONE);
            eLadoA.setVisibility(View.GONE);
            eLadoB.setVisibility(View.GONE);
            eLadoC.setVisibility(View.GONE);
        }
    }
    public void fCalcular(View view) {

        if(rCuadro.isChecked()){
            elado = Integer.parseInt(eLado.getText().toString());
            Perimetro=4*elado;
            Area=elado*elado;
            tResultado.setText("Perímetro: "+Perimetro+" cm"+"\nÁrea: "+Area+" cms cuadrados");
        }
        if(rCirculo.isChecked()){
            eradio = Integer.parseInt(eRadio.getText().toString());
            Perimetro= 2*Math.PI*eradio;
            Area= Math.PI*eradio*eradio;
            tResultado.setText("Perímetro: "+Perimetro+" cm"+"\nÁrea: "+Area+" cms cuadrados ");
        }
        if(rTriangulo.isChecked()){
            eladoA = Integer.parseInt(eLadoA.getText().toString());
            eladoB = Integer.parseInt(eLadoB.getText().toString());
            eladoC = Integer.parseInt(eLadoC.getText().toString());
            Perimetro= eladoA+eladoB+eladoC;
            Semiperimetro = Perimetro/2;
            Area= Semiperimetro*(Semiperimetro-eladoA)*(Semiperimetro-eladoB)*(Semiperimetro-eladoC);
            Area= Math.sqrt(Area);
            tResultado.setText("Perímetro: "+Perimetro+" cm"+"\nÁrea: "+Area+" cms cuadrados");
        }
        if(rCubo.isChecked()){
            elado = Integer.parseInt(eLado.getText().toString());
            Area = 6*elado*elado;
            Volumen = elado*elado*elado;
            tResultado.setText("Área: "+Area+" cm"+"\nVolumen: "+Volumen+" cms cúbicos ");
        }
    }
}
