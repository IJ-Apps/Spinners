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
    //TUTORIAL 1: https://youtu.be/NJ6tywOAPDk
    //Playlist of tutorials on Spinners: https://www.youtube.com/playlist?list=PLLmkb5CTw5rTQ4bjWZdOQbrHPsZexcdef
    //TUTORIAL 5: https://youtu.be/hdB9XOJu8rY

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> states = Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
        final Spinner spinner = findViewById(R.id.spinner);

        // Our custom Adapter class that we created
        SpinnerAdapter adapter = new SpinnerAdapter(getApplicationContext(), states);
        adapter.setDropDownViewResource(R.layout.my_dropdown_item);

        spinner.setAdapter(adapter);

        // Make a Toast whenever the user selects something from the Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String newItem = states.get(i);
                Toast.makeText(getApplicationContext(), "You selected: " + newItem, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });


        // Button that displays currently selected item when clicked
        Button getText = findViewById(R.id.getText);
        getText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String state = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), state, Toast.LENGTH_SHORT).show();
            }
        });
    }
}