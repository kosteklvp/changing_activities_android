package pl.kosteklvp.lab4_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView first_numberTV = findViewById(R.id.first_number);
        TextView second_numberTV = findViewById(R.id.second_number);

        Button button_dodaj = findViewById(R.id.button_dodaj);
        Button button_odejmij = findViewById(R.id.button_odejmij);
        Button button_pomnoz = findViewById(R.id.button_pomnoz);
        Button button_podziel = findViewById(R.id.button_podziel);

        Intent intent = getIntent();
        final int first_number = intent.getIntExtra("firstNumber", 0);
        final int second_number = intent.getIntExtra("secondNumber", 0);

        first_numberTV.setText(String.valueOf(first_number));
        second_numberTV.setText(String.valueOf(second_number));

        button_dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent conn_Second_Main = new Intent(SecondActivity.this, MainActivity.class);
                conn_Second_Main.putExtra("result", first_number + second_number);
                conn_Second_Main.putExtra("isUsed", true);
                conn_Second_Main.putExtra("isDivide", false);
                startActivity(conn_Second_Main);
            }
        });

        button_odejmij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent conn_Second_Main = new Intent(SecondActivity.this, MainActivity.class);
                conn_Second_Main.putExtra("result", first_number - second_number);
                conn_Second_Main.putExtra("isUsed", true);
                conn_Second_Main.putExtra("isDivide", false);
                startActivity(conn_Second_Main);
            }
        });
        button_pomnoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent conn_Second_Main = new Intent(SecondActivity.this, MainActivity.class);
                conn_Second_Main.putExtra("result", first_number * second_number);
                conn_Second_Main.putExtra("isUsed", true);
                conn_Second_Main.putExtra("isDivide", false);
                startActivity(conn_Second_Main);
            }
        });
        button_podziel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent conn_Second_Main = new Intent(SecondActivity.this, MainActivity.class);
                conn_Second_Main.putExtra("result", Double.parseDouble(String.valueOf(first_number)) / Double.parseDouble(String.valueOf(second_number)));
                conn_Second_Main.putExtra("isUsed", true);
                conn_Second_Main.putExtra("isDivide", true);
                startActivity(conn_Second_Main);
            }
        });
    }
}
