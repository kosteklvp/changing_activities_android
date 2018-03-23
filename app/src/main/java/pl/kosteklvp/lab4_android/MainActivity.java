package pl.kosteklvp.lab4_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText first_editText = findViewById(R.id.first_editText);
        final EditText second_editText = findViewById(R.id.second_editText);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);

        final int result_int;
        final double result_double;
        boolean isUsed;

        Intent intent = getIntent();
        if(intent.getBooleanExtra("isDivide", false) == true) {
            result_double = intent.getDoubleExtra("result", 0.0);
            isUsed = intent.getBooleanExtra("isUsed", false);

            if (isUsed == true) {
                textView.setText(String.valueOf(result_double));
            }
        } else {
            result_int = intent.getIntExtra("result", 0);
            isUsed = intent.getBooleanExtra("isUsed", false);

            if (isUsed == true) {
                textView.setText(String.valueOf(result_int));
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first_editText.getText().toString().equals("") && second_editText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Wypełnij obydwa pola", Toast.LENGTH_SHORT).show();
                } else
                    if(second_editText.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Wypełnij pole #2", Toast.LENGTH_SHORT).show();
                } else
                    if(first_editText.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Wypełnij pole #1", Toast.LENGTH_SHORT).show();
                } else {
                    int firstNumber = Integer.parseInt(String.valueOf(first_editText.getText()));
                    int secondNumber = Integer.parseInt(String.valueOf(second_editText.getText()));

                    Intent conn_Main_Second = new Intent(MainActivity.this, SecondActivity.class);
                    conn_Main_Second.putExtra("firstNumber", firstNumber);
                    conn_Main_Second.putExtra("secondNumber", secondNumber);
                    startActivity(conn_Main_Second);
                }
            }
        });

    }
}
