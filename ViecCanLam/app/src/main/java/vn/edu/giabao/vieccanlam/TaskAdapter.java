package vn.edu.giabao.vieccanlam;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<TASKS> taskList;

    public TaskAdapter(List<TASKS> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TASKS task = taskList.get(position);
        if (task == null) return;

        holder.tvName.setText(task.getName());
        holder.tvDate.setText(task.getDate());
        holder.tvMessage.setText(task.getMessage());
        holder.tvPriority.setText(task.getPriority());

        // Thay đổi màu sắc chữ dựa trên mức độ ưu tiên
        String priority = task.getPriority();
        if (priority != null) {
            switch (priority.toLowerCase()) {
                case "cao":
                case "high":
                    holder.tvPriority.setTextColor(Color.RED);
                    break;
                case "trung bình":
                case "medium":
                    holder.tvPriority.setTextColor(Color.parseColor("#FFA500")); // Orange
                    break;
                default:
                    holder.tvPriority.setTextColor(Color.BLUE);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return taskList != null ? taskList.size() : 0;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDate, tvMessage, tvPriority;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_task_name);
            tvDate = itemView.findViewById(R.id.tv_task_date);
            tvMessage = itemView.findViewById(R.id.tv_task_message);
            tvPriority = itemView.findViewById(R.id.tv_task_priority);
        }
    }
}
