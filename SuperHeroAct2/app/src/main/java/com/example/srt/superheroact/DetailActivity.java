package com.example.srt.superheroact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();

        SuperHeroe heroe = extras.getParcelable(MainActivity.SUPER_HERO);

        TextView heroData = (TextView) findViewById(R.id.hero_data);

        if(heroe != null)
            heroData.setText(
                    heroe.getName() + ", " + heroe.getLastName() + ", " +
                    heroe.getHeroName() + ", " + heroe.getAge() + ", " +
                    heroe.getAddress() + ", " + heroe.getCity()
            );
    }
}
