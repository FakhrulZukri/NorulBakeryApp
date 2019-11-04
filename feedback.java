package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hsalf.smilerating.SmileRating;

public class feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        SmileRating smileRating = (SmileRating) findViewById(R.id.smile_rating);
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener()); {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {

                switch (smiley){
                case SmileRating.BAD:
                    Toast.makeText(feedback.this, "BAD", Toast.LENGTH_SHORT).show();
                    break;
                case SmileRating.GOOD:
                    Toast.makeText(feedback.this, "GOOD", Toast.LENGTH_SHORT).show();
                    break;
                case SmileRating.GREAT:
                    Toast.makeText(feedback.this, "GREAT", Toast.LENGTH_SHORT).show();
                    break;
                case SmileRating.OKAY:
                    Toast.makeText(feedback.this, "OKAY", Toast.LENGTH_SHORT).show();
                    break;
                case SmileRating.TERRIBLE:
                    Toast.makeText(feedback.this, "TERRIBLE", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        smileRating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener()){
            @Override
            public void onRatingSelected(int level,boolean reselected); {

                Toast.makeText(feedback.this, "Selected rating " + level, Toast.LENGTH_SHORT).show();
        }

    }
}
