package com.example.srt.filmcatalogue;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.filmImage);

        Button firstBtn = (Button) findViewById(R.id.firstBtn);
        Button secondBtn = (Button) findViewById(R.id.secondBtn);
        Button thirdBtn = (Button) findViewById(R.id.thirdBtn);
        Button fourthBtn = (Button) findViewById(R.id.fourthBtn);
        Button fifthBtn = (Button) findViewById(R.id.fifthBtn);
        Button sixthBtn = (Button) findViewById(R.id.sixthBtn);

        firstBtn.setOnClickListener(this);
        secondBtn.setOnClickListener(this);
        thirdBtn.setOnClickListener(this);
        fourthBtn.setOnClickListener(this);
        fifthBtn.setOnClickListener(this);
        sixthBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View buttonView) {

        int btnId = buttonView.getId();
        int imageId = 0;

        switch(btnId)
        {
            case R.id.firstBtn:
                img.setImageResource(R.drawable.ironman);
                break;
            case R.id.secondBtn:
                img.setImageResource(R.drawable.logan);
                break;
            case R.id.thirdBtn:
                img.setImageResource(R.drawable.batman);
                break;
            case R.id.fourthBtn:
                img.setImageResource(R.drawable.vader);
                break;
            case R.id.fifthBtn:
                img.setImageResource(R.drawable.inception);
                break;
            case R.id.sixthBtn:
                img.setImageResource(R.drawable.interestellar);
                break;
            default:
                imageId = 0;
        }

        if(imageId != 0)
            img.setImageDrawable(ContextCompat.getDrawable(this,imageId));
    }
}
