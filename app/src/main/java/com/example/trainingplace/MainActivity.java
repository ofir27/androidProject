package com.example.trainingplace;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputEditText;
public class MainActivity extends AppCompatActivity {

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
        TextInputEditText etHeight = findViewById(R.id.et_height);
        TextInputEditText etWeight = findViewById(R.id.et_weight);
        Button btnCalculate = findViewById(R.id.btn_calculate);
        TextView result = findViewById(R.id.result);
            btnCalculate.setOnClickListener(v -> {
            String heightStr = etHeight.getText().toString();
            String weightStr = etWeight.getText().toString();
                double height = Double.parseDouble(heightStr)/100 ;
                double weight = Double.parseDouble(weightStr);
                double bmi = weight / (height * height);
                result.setText(String.format(" BMI: %.1f",bmi));
        });



    }

}


