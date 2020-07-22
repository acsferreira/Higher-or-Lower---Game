package com.example.and.higherorlower;

import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String randStr;
    int rand_int1;
    Random rand = new Random();
    String message;

    public void newRandomNumber(){
        rand_int1 = rand.nextInt(20)+1;
        randStr= String.valueOf(rand_int1);
    }

    public void guessFunction(View view){
        Log.i("My number", randStr);

        EditText guessedN = (EditText) findViewById(R.id.guessedNumber);
        if (! guessedN.getText().toString().matches("")) {
            int guessedNint = Integer.parseInt(guessedN.getText().toString());
            if (guessedNint == rand_int1) {
                message="Acertô miserávi! O número é " + rand_int1 + ". Tente de novo.";
                newRandomNumber();
                guessedN.setText("");

            } else if (guessedNint > 20) {
                message="O número deve ser menor que 20.";
                guessedN.setText("");
            } else if (guessedNint < 1) {
                message="O número deve ser maior que 0.";
                guessedN.setText("");
            } else if (guessedNint < rand_int1) {
                message="Tente um número maior.";
                guessedN.setText("");
            } else if (guessedNint > rand_int1) {
                message="Tente um número menor.";
                guessedN.setText("");
            }
        } else {
            message="Digite um número entre 1 e 20.";
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newRandomNumber();
    }
}
