package com.pablovicente.batallanaval;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

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

        final TableLayout tableLayout = findViewById(R.id.tableLayout);

        TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
        TableRow.LayoutParams buttonParams = new TableRow.LayoutParams(0, 100, 1f);

        TableRow tableRow = new TableRow(this);
        TextView textView = new TextView(this);
        textView.setText("");
        tableRow.addView(textView);
        int num = 0;
        for (int i = 0; i < 10; i++) {
            textView = new TextView(this);
            textView.setText(String.valueOf(num));
            textView.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
            textView.setPadding(40,10,40,5);
            tableRow.setLayoutParams(params);
            tableRow.addView(textView);
            num++;
        }
        tableLayout.addView(tableRow);

        List<String> letters = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");

        for (int i = 0; i < 10; i++) {
            tableRow = new TableRow(this);
            TextView letter = new TextView(this);
            letter.setText(letters.get(i));
            letter.setPadding(20,10,20,10);
            tableRow.addView(letter);
            for (int e = 0; e < 10; e++) {
                Button button = new Button(this);
                button.setText("?");
                button.setLayoutParams(buttonParams);

                String tag = Integer.toString(e) + letters.get(i);
                button.setTag(tag);

                button.setOnClickListener(v -> {
                    String buttonTag = (String) button.getTag();

                    Toast.makeText(MainActivity.this, "Botón ID: " + buttonTag, Toast.LENGTH_SHORT).show();
                });

                tableRow.addView(button);

            }
            tableRow.setLayoutParams(params);
            tableLayout.addView(tableRow);
        }
    }
}