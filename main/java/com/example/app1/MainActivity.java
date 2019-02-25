package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //function display current time

        createRadioButtons();
        displaycurrenttime();
        setupprintselectedbutton();

        /*boton playa
        Button btn = findViewById(R.id.playa);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            count++;
                TextView textView = (TextView) findViewById(R.id.verplaya);
                textView.setText("has desobedecido este nª de veces: "+count);
                Toast.makeText(getApplicationContext(),"Me has pulsado!", Toast.LENGTH_SHORT)
                        .show(); //Asi aparece el texto temporal, con duracion corta
            }
        });*/
    }

    private void setupprintselectedbutton() { //Para que nos muestre el boton de radio elegido
        Button btn = (Button) findViewById(R.id.seleccionar);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count++;
                TextView textView = (TextView) findViewById(R.id.verplaya);
                textView.setText("Nº deonsultas realizadas: "+count);
                RadioGroup group = (RadioGroup) findViewById(R.id.radio_group);
                int idOfSelected = group.getCheckedRadioButtonId(); //Nos da el id del boton de radio seleccionado
                RadioButton radioButton = (RadioButton) findViewById(idOfSelected);
                String message = radioButton.getText().toString();

                //Segun el boton de radio que elijamos, nos mostrara una opción u otra.
                //Con el for, alargamos la duracion del mensaje toast, para que pueda ser leido.
                if (idOfSelected==1) {
                    for (int i=0; i < 2; i++) {
                        Toast.makeText(MainActivity.this, "Playa: Invierno suave y corto, verano calido y largo. Recomendacion: Valencia", Toast.LENGTH_LONG)
                                .show();
                    }
                }
                if (idOfSelected==2) {
                    for (int i=0; i < 2; i++) {
                        Toast.makeText(MainActivity.this, "Montaña: Invierno largo y frio, verano corto y suave. En invierno puedes esquiar, en verano puedes escapar del calor. Recomendacion: Huesca", Toast.LENGTH_LONG)
                                .show();
                    }
                }
                if (idOfSelected==3) {
                    for (int i=0; i < 3; i++) {
                        Toast.makeText(MainActivity.this, "Interior: Bonita arquitectura. Recomendación: Sevilla. Evitar visitar en verano!", Toast.LENGTH_LONG)
                                .show();
                    }
                }



                }

        });
    }

    private void createRadioButtons() { //Para crear los botones de radio dinamicamente, sin tener que ponerlos a mano unoa uno
        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group);
        //Accedemos a select.xml. Necesitamos el arrary "option"
       int[] num_opciones = getResources().getIntArray(R.array.option);

       //Creamos los botonoes de radio
        for (int i=0; i<num_opciones.length; i++) {
            final int numopciones= num_opciones[i];

            RadioButton button = new RadioButton(this);
            button.setText( getString(R.string.opcion_turistica)+ numopciones);
            //Ponemos un callback
          button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Toast.makeText(MainActivity.this, "Clic", Toast.LENGTH_SHORT)
                          .show();
              }
          });
            //Lo añadimos al grupo radio
            group.addView(button);
        }
    }

    private void displaycurrenttime() {
        Date currentTime = new Date(); //Uso la funcion de java date
        String text ="La hora actual es: "+ currentTime.toString();

        //Con findviewbyid hacemos que aparezca en la pantalla con el  id del recurso. En este caso el id es currentime
       TextView textView = (TextView) findViewById(R.id.currenttime);
       textView.setText(text);
    }
}
