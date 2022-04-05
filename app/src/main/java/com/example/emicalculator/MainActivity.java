package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.ETC1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText principal,intrest,time;
    Button reset,submit;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principal = findViewById(R.id.principal);
        intrest = findViewById(R.id.intrest);
        time = findViewById(R.id.time);
        reset = findViewById(R.id.reset);
        submit = findViewById(R.id.submit);
        result = findViewById(R.id.result);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float p = Float.parseFloat(principal.getText().toString());
                float r = Float.parseFloat(intrest.getText().toString());
                float n = Float.parseFloat(time.getText().toString());

                r = r/(12*100);

                float final_r = 1.0f;

                for (int i = 0; i < n*12; i++) {
                    final_r = final_r*(1+r);
                }

                float f_ans = p*r*(final_r/(final_r-1));

                result.setText("Your Payable Amount With Intrest : "+(f_ans+p)+"\n\n"+"Your Intrest is : "+f_ans);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                principal.setText("");
                intrest.setText("");
                time.setText("");
                result.setText("");
            }
        });

    }
}