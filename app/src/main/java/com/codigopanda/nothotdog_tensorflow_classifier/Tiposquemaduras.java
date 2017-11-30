package com.codigopanda.nothotdog_tensorflow_classifier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by edison on 14/11/2017.
 */

public class Tiposquemaduras extends AppCompatActivity {
    private Button t_electricidad,t_fuego,t_liquido,t_quimico,t_solido;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tipoquemadura);
        t_electricidad = (Button) findViewById(R.id.btnelectricidad);

        t_electricidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tiposquemaduras.this,T_electricidad.class);
                startActivity(i);
            }
        });

        t_fuego = (Button) findViewById(R.id.btnfuego);
        t_fuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tiposquemaduras.this,T_fuego.class);
                startActivity(i);
            }
        });
        t_liquido = (Button) findViewById(R.id.btnliquido);
        t_liquido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tiposquemaduras.this,T_liquido_caliente.class);
                startActivity(i);
            }
        });
        t_quimico = (Button) findViewById(R.id.btnquimico);
        t_quimico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tiposquemaduras.this,T_quimico.class);
                startActivity(i);
            }
        });

        t_solido = (Button) findViewById(R.id.btnsolido);
        t_solido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tiposquemaduras.this,T_solido_caliente.class);
                startActivity(i);
            }
        });

    }
}
