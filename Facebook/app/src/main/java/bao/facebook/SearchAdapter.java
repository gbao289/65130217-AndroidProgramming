package bao.facebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    ArrayList<Search> list;
    Context context;

    public SearchAdapter(ArrayList<Search> list, Context context) {
        this.list = list;
        this.context = context;
    }
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivIcon);
            name = itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Code o day
            int viTriDuocClick = getAdapterPosition();
            Search phanTuDuocClick =  list.get(viTriDuocClick);
            //Lay thong tin
            String ten = phanTuDuocClick.getName();
            String tenFile = phanTuDuocClick.getImageName();
            //Toast
            String chuoiThongBao = "Ban vua click vao : " + ten;
            Toast.makeText(v.getContext(),chuoiThongBao,Toast.LENGTH_SHORT).show();
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Search search = list.get(position);

        holder.image.setImageResource(holder.itemView.getResources().getIdentifier(search.getImageName(),"drawable", holder.itemView.getContext().getPackageName()));
        holder.name.setText(search.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
