// Fragment3.java

package com.example.norbertactivity;

import com.example.norbertactivity.adapters.ChildAdapter;
import com.example.norbertactivity.database.DatabaseHelper;
import android.content.Intent; // Import this to handle intents
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import android.util.Log;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.norbertactivity.model.Child;

import java.util.ArrayList;
import java.util.List;

public class Fragment3 extends Fragment implements ChildAdapter.OnItemActionListener {

    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private ChildAdapter childAdapter;
    private List<Child> childList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        // Initialize the database and RecyclerView
        databaseHelper = new DatabaseHelper(getActivity());
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Load data from the database
        childList = new ArrayList<>();
        loadChildrenFromDatabase();

        // Set up the adapter
        childAdapter = new ChildAdapter(childList, this);
        recyclerView.setAdapter(childAdapter);

        // Initialize the FloatingActionButton
        FloatingActionButton fab = view.findViewById(R.id.fab_add);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FragmentsActivity.class);
            intent.putExtra("fragment_to_load", "Fragment1");
            startActivity(intent);
        });

        return view;
    }

    private void loadChildrenFromDatabase() {
        Cursor cursor = databaseHelper.getAllChildren();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                int age = cursor.getInt(cursor.getColumnIndex("age"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                boolean enrolled = cursor.getInt(cursor.getColumnIndex("enrolled")) == 1;

                childList.add(new Child(id, age, name, enrolled, "Unknown"));
            } while (cursor.moveToNext());
        }
        cursor.close();

        // Debug: Log the size of childList
        Log.d("Fragment3", "Child list size: " + childList.size());
    }

    @Override
    public void onEditClicked(Child child) {
        showUpdateDialog(child);
    }

    @Override
    public void onDeleteClicked(Child child) {
        databaseHelper.deleteChild(child.getId());
        childList.remove(child);
        childAdapter.notifyDataSetChanged();
    }

    private void showUpdateDialog(Child child) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.update_dialog, null);
        builder.setView(dialogView);

        EditText editTextName = dialogView.findViewById(R.id.editTextName);
        EditText editTextAge = dialogView.findViewById(R.id.editTextAge);
        CheckBox checkBoxEnrolled = dialogView.findViewById(R.id.checkBoxEnrolled);
        Button buttonUpdate = dialogView.findViewById(R.id.buttonUpdate);

        editTextName.setText(child.getName());
        editTextAge.setText(String.valueOf(child.getAge()));
        checkBoxEnrolled.setChecked(child.isEnrolled());

        AlertDialog dialog = builder.create();
        dialog.show();

        buttonUpdate.setOnClickListener(v -> {
            String updatedName = editTextName.getText().toString();
            int updatedAge = Integer.parseInt(editTextAge.getText().toString());
            boolean updatedEnrolled = checkBoxEnrolled.isChecked();

            databaseHelper.updateChild(child.getId(), updatedName, updatedAge, updatedEnrolled);

            child.setName(updatedName);
            child.setAge(updatedAge);
            child.setEnrolled(updatedEnrolled);

            childAdapter.notifyDataSetChanged();
            dialog.dismiss();
        });
    }
}
