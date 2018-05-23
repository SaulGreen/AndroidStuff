package com.example.srt.superheroact;

import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.graphics.Bitmap;

public class MainActivity extends AppCompatActivity {


    public static final String SUPER_HERO = "hero";
    private static final int CAMERA_REQUEST_CODE = 1000;
    ImageView heroImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button registerButton = (Button) findViewById(R.id.register_button);

        final EditText nameEdit = (EditText) findViewById(R.id.name_edit);
        final EditText lastNameEdit = (EditText) findViewById(R.id.last_name_edit);
        final EditText heroNameEdit = (EditText) findViewById(R.id.hero_name_edit);
        final EditText ageEdit = (EditText) findViewById(R.id.age_edit);
        final EditText addressEdit = (EditText) findViewById(R.id.address_edit);
        final EditText cityEdit = (EditText) findViewById(R.id.city_edit);

        heroImage = (ImageView) findViewById(R.id.hero_image);

        heroImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent detailsIntent = new Intent(MainActivity.this,DetailActivity.class);

                final SuperHeroe ironMan = new SuperHeroe(
                        nameEdit.getText().toString(),
                        lastNameEdit.getText().toString(),
                        heroNameEdit.getText().toString(),
                        ageEdit.getText().toString(),
                        addressEdit.getText().toString(),
                        cityEdit.getText().toString()
                );

                detailsIntent.putExtra(SUPER_HERO, ironMan);

                startActivity(detailsIntent);
            }
        });
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == CAMERA_REQUEST_CODE){
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");

            heroImage.setImageBitmap(bitmap);
        }
    }
}
