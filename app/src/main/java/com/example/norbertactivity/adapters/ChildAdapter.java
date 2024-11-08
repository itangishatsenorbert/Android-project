package com.example.norbertactivity.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.norbertactivity.R;
import com.example.norbertactivity.model.Child;
import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    private List<Child> childList;
    private OnItemActionListener listener; // Listener for item actions

    public ChildAdapter(List<Child> childList, OnItemActionListener listener) {
        this.childList = childList;
        this.listener = listener; // Set the listener
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_list, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        Child child = childList.get(position);
        holder.nameTextView.setText("Name: " + child.getName());
        holder.ageTextView.setText("Age: " + child.getAge());
        holder.enrolledTextView.setText("Enrolled: " + (child.isEnrolled() ? "Yes" : "No"));

        // Set the update and delete button listeners
        holder.btnEdit.setOnClickListener(v -> listener.onEditClicked(child));
        holder.btnDelete.setOnClickListener(v -> listener.onDeleteClicked(child));
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView ageTextView;
        public TextView enrolledTextView;
        public Button btnEdit;    // Button for editing
        public Button btnDelete;  // Button for deleting

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            ageTextView = itemView.findViewById(R.id.ageTextView);
            enrolledTextView = itemView.findViewById(R.id.enrolledTextView);
            btnEdit = itemView.findViewById(R.id.btn_edit);      // Ensure this ID matches your layout
            btnDelete = itemView.findViewById(R.id.btn_delete);  // Ensure this ID matches your layout
        }
    }

    public interface OnItemActionListener {
        void onEditClicked(Child child);
        void onDeleteClicked(Child child);
    }
}
