package bao.facebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    List<News> list;
    Context context;

    public NewsAdapter(List<News> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, date;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            date = itemView.findViewById(R.id.txtDate);
            image = itemView.findViewById(R.id.imgNews);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = list.get(position);

        holder.title.setText(news.getTitle());
        holder.date.setText(news.getDate());
        Glide.with(context).load(news.getImage()).into(holder.image);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(news.getLink()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
