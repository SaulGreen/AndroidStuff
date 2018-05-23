package com.example.srt.edaddeperro;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView answerText = (TextView) findViewById(R.id.answer_text);
        final EditText ageEdit = (EditText) findViewById((R.id.age_edit));

        Button myButton = (Button) findViewById(R.id.myBytton);

        //Log.d(TAG,"App creada");

        myButton.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                String ageString = ageEdit.getText().toString();

                try
                {
                    int ageInt = Integer.parseInt(ageString);

                    answerText.setText(String.format(getString(R.string.answer), (ageInt * 6)));
                    //answerText.setText(("Si fueras perro tu edad seria: " + (ageInt * 6)));
                    //Log.i(TAG,"Se inserto numero entero");
                }
                catch(NumberFormatException e)
                {
                    //answerText.setText(("Solo numeros!!"));
                    //Log.e(TAG, "No se inserto, usuario todo pendejo.");
                    Toast toast = Toast.makeText(MainActivity.this, R.string.error_message,Toast.LENGTH_LONG);
                    toast.show();

                }
            }
        });
        //answerText.setText("Si fueras perro tu edad seria de: ");

        //ImageView imageView = new ImageView(this);
        //imageView.setImageResource(R.drawable.dog);

        //ImageView dogImage = (ImageView) findViewById(R.id.dogImage);
        //dogImage.setImageResource(R.drawable.image);
        //dogImage.getSolidColor();
    }
}
