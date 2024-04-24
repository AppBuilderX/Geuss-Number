package com.example.geussnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int result;
    static int getRandomNumber(int max, int min){
        return (int) ((Math.random()*(max-min)) + min);
    }

    public void makeToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void clickFunction(View view){
        int userGuessing ;
        EditText editText = findViewById(R.id.edit_text);
        userGuessing = Integer.parseInt(editText.getText().toString());

        if (userGuessing < result){
            Toast.makeText(this, "Think of higher number, try again", Toast.LENGTH_SHORT).show();
        } else if (userGuessing>result) {
            Toast.makeText(this, "Think of lower number, try again", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Congratulations, you got the number", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}