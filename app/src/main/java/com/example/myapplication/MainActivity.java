package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button Dalej;
    private Button Wstecz;
    private Button Zero;
    private Button Polub;
    private TextView textView1;

    private ImageView imageView1;
    private View layout;

    private final int[] imageArray = new int[]
            {
                    R.drawable.obraz1,
                    R.drawable.obraz2,
                    R.drawable.obraz3
            };

    private int IndexObraz = 0;
    private int polubienia = 0;



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


        Dalej = findViewById(R.id.buttonDalej);
        Polub = findViewById(R.id.buttonPolub);
        Zero = findViewById(R.id.buttonZero);
        Wstecz = findViewById(R.id.buttonWstecz);
        layout = findViewById(R.id.main);
        textView1 = findViewById(R.id.textView1);

        if (savedInstanceState != null)
        {
            polubienia = savedInstanceState.getInt("POLUBIENIA" , 0);
        };
        textView1.setText(String.valueOf(polubienia));
        if (savedInstanceState != null)
        {
            IndexObraz = savedInstanceState.getInt("OBRAZ", 0);
        }
        imageView1.setImageResource(imageArray[IndexObraz]);




        Polub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        polubienia++;
                        textView1.setText(polubienia + "");
                        textView1.setText(String.valueOf(polubienia));
                        textView1.setText(Integer.toString(polubienia));
                    }
                }
        );

        Zero.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        polubienia = 0;
                        textView1.setText(polubienia + "");
                        textView1.setText(String.valueOf(polubienia));
                        textView1.setText(Integer.toString(polubienia));
                    }
                }
        );

    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("POLUBIENIA" , polubienia);
    }
}