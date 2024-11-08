//package com.example.norbertactivity.adapters;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import com.example.norbertactivity.R;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import com.example.norbertactivity.model.Child;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.List;
//
//public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
//    private List<Child> objects;
//
//    public RecyclerViewAdapter(List<Child> objects) {
//        this.objects = objects;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_list, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Child object = objects.get(position);
//        holder.textView.setText(object.getName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return objects.size();
//    }
//
//    static class ViewHolder extends RecyclerView.ViewHolder {
//        TextView textView;
//
//        ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.text_view);
//        }
//    }
//}