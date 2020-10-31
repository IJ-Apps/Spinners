package app.ij.spinners;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

class SpinnerAdapter extends ArrayAdapter<String> {

    Context context;
    List<String> statesList;

    // Constructor accepts Context (from MainActivity) and a list of state abbreviations
    public SpinnerAdapter(Context context, List<String> states) {
        super(context, R.layout.my_selected_item, states);
        this.context = context;
        this.statesList = states;
    }

    // Override these methods and instead return our custom view (with image and text)
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // Function to return our custom View (View with an image and text)
    public View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.my_dropdown_item, parent, false);

        // Image and TextViews
        TextView state = row.findViewById(R.id.text);
        ImageView flag = row.findViewById(R.id.img);

        // Get flag image from drawables folder
        Resources res = context.getResources();
        String drawableName = statesList.get(position).toLowerCase(); // tx
        int resId = res.getIdentifier(drawableName, "drawable", context.getPackageName());
        Drawable drawable = res.getDrawable(resId);

        //Set state abbreviation and state flag
        state.setText(statesList.get(position));
        flag.setImageDrawable(drawable);

        return row;
    }

}
