package com.example.and.higherorlower;

import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    int rand_int1 = rand.nextInt(20);
    String randStr= String.valueOf(rand_int1);


    public void guessFunction(View view){
        Log.i("My number", randStr);
        EditText guessedN = (EditText) findViewById(R.id.guessedNumber);
        if (! guessedN.getText().toString().matches("")) {
            int guessedNint = Integer.parseInt(guessedN.getText().toString());
            if (guessedNint == rand_int1) {
                Toast.makeText(this, "Acertô miserávi! O número é " + rand_int1 + ".", Toast.LENGTH_LONG).show();
            } else if (guessedNint > 20) {
                Toast.makeText(this, "O número deve ser menor que 20.", Toast.LENGTH_LONG).show();
                guessedN.setText("");
            } else if (guessedNint < 1) {
                Toast.makeText(this, "O número deve ser maior que 0.", Toast.LENGTH_LONG).show();
                guessedN.setText("");
            } else if (guessedNint < rand_int1) {
                Toast.makeText(this, "Tente um número maior.", Toast.LENGTH_LONG).show();
                guessedN.setText("");
            } else if (guessedNint > rand_int1) {
                Toast.makeText(this, "Tente um número menor.", Toast.LENGTH_LONG).show();
                guessedN.setText("");
            }
        } else {
            Toast.makeText(this, "Digite um número entre 1 e 20.", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
