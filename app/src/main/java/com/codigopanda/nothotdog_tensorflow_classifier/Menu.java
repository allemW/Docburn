package com.codigopanda.nothotdog_tensorflow_classifier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by edison on 21/11/2017.
 */

public class Menu extends AppCompatActivity {
    private Button btn_quemadura, btn_diagnostico, btn_tratamiento;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        btn_quemadura = (Button) findViewById(R.id.btnquemadura);

        btn_quemadura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Quemadura.class);
                startActivity(i);
            }
        });

        btn_diagnostico = (Button) findViewById(R.id.btndiagnostico);
        btn_diagnostico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, MainActivity.class);
                startActivity(i);
            }
        });
        btn_tratamiento = (Button) findViewById(R.id.btntratamiento);
        btn_tratamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Tiposquemaduras.class);
                startActivity(i);
            }
        });

    }
}
