package app.ij.spinners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> states = Arrays.asList("TX", "CA", "WA", "NY", "NJ");

        final Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.my_selected_item, states);
        adapter.setDropDownViewResource(R.layout.my_dropdown_item);

        spinner.setAdapter(adapter);























        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String newItem = states.get(i);
                Toast.makeText(getApplicationContext(), "You selected: " + newItem, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
















     /*   Button getText = findViewById(R.id.getText);
        getText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String state = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), state, Toast.LENGTH_SHORT).show();
            }
        });*/


    }
}