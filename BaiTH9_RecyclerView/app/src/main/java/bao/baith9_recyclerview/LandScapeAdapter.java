package bao.baith9_recyclerview;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.itemLandHolder> {

    Context content;
    ArrayList<LandScape> lstData;

    public LandScapeAdapter(Context content, ArrayList<LandScape> lstData) {
        this.content = content;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public itemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(content);
        View vItem = cai_bom.inflate(R.layout.item_land,parent, false);
        itemLandHolder viewHolderCreated = new itemLandHolder(vItem);

        return viewHolderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull itemLandHolder holder, int position) {
        //Lay doi tuong hien thi
        LandScape landScapeHienThi = lstData.get(position);
        //Trich thong tin
        String caption = landScapeHienThi.getLandscapeName();
        String tenAnh = landScapeHienThi.getLandscapeImage();
        //Dat vao cac truong thong tin cua holder
        holder.tvCaption.setText(caption);
        String packageName = holder.itemView.getContext().getPackageName();
        //Lay id cho anh thong qua ten
        int imageID = holder.itemView.getResources().getIdentifier(tenAnh,"mipmap",packageName);
        holder.ivLandscape.setImageResource(imageID);

    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class itemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCaption;
        ImageView ivLandscape;

        public itemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewName);
            ivLandscape = itemView.findViewById(R.id.imagevViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Code o day
            int viTriDuocClick = getAdapterPosition();
            LandScape phanTuDuocClick =  lstData.get(viTriDuocClick);
            //Lay thong tin
            String ten = phanTuDuocClick.getLandscapeName();
            String tenFile = phanTuDuocClick.getLandscapeImage();
            //Toast
            String chuoiThongBao = "Ban vua click vap : " + ten;
            Toast.makeText(v.getContext(),chuoiThongBao,Toast.LENGTH_SHORT).show();

        }
    }

}
