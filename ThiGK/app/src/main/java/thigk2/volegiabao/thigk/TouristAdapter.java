package thigk2.volegiabao.thigk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TouristAdapter extends ArrayAdapter<TouristAttraction> {
    private Context context;
    private int resource;
    private List<TouristAttraction> objects;

    public TouristAdapter(@NonNull Context context, int resource, @NonNull List<TouristAttraction> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        TouristAttraction attraction = objects.get(position);

        ImageView img = convertView.findViewById(R.id.imgAttraction);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvAddress = convertView.findViewById(R.id.tvAddress);

        img.setImageResource(attraction.getImageResId());
        tvName.setText(attraction.getName());
        tvAddress.setText(attraction.getAddress());

        return convertView;
    }
}