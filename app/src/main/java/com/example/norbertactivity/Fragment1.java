package com.example.norbertactivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.norbertactivity.database.DatabaseHelper;

public class Fragment1 extends Fragment {
    private EditText nameEditText;
    private EditText ageEditText;
    private Button saveButton;
    private Button nextButton;
    private DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        // Initialize the UI elements
        nameEditText = view.findViewById(R.id.nameEditText);
        ageEditText = view.findViewById(R.id.ageEditText);
        saveButton = view.findViewById(R.id.saveButton);
        nextButton = view.findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new Fragment2())
                        .commit();
            }
        });
        // Initialize the DatabaseHelper
        databaseHelper = new DatabaseHelper(getActivity());

        // Set the button click listener to save data
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChildData();
            }
        });

        return view;
    }

    // Method to save child data into the database
    private void saveChildData() {
        String name = nameEditText.getText().toString().trim();
        String ageStr = ageEditText.getText().toString().trim();

        // Validate inputs
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getActivity(), "Please enter a name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(ageStr)) {
            Toast.makeText(getActivity(), "Please enter an age", Toast.LENGTH_SHORT).show();
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            Toast.makeText(getActivity(), "Age must be a number", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean enrolled = true; // For simplicity, set enrolled to true (can add a toggle in UI if needed)

        // Save the child data to the database
        databaseHelper.addChild(name, age, enrolled);
        Toast.makeText(getActivity(), "Child saved successfully", Toast.LENGTH_SHORT).show();

        // Navigate to Fragment3 to display the saved data
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new Fragment3())
                .commit();
    }
}
