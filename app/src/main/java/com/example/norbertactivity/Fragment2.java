package com.example.norbertactivity;

import com.example.norbertactivity.model.Child;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    private LinearLayout childListContainer;
    private List<Child> childList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        childListContainer = view.findViewById(R.id.child_list_container);

        // Create a list of Child objects
        childList = new ArrayList<>();
        childList.add(new Child(1, 6, "John", true, "1st Grade"));   // Updated to include ID
        childList.add(new Child(2, 7, "Emma", false, "2nd Grade"));  // Updated to include ID
        childList.add(new Child(3, 8, "Liam", true, "3rd Grade"));   // Updated to include ID
        childList.add(new Child(4, 12, "Bravo", true, "1st Grade")); // Updated to include ID
        childList.add(new Child(5, 18, "Aime", false, "4th Grade")); // Updated to include ID
        childList.add(new Child(6, 20, "Queen", true, "3rd Grade")); // Updated to include ID
        childList.add(new Child(7, 15, "Nobel", true, "1st Grade")); // Updated to include ID
        childList.add(new Child(8, 22, "Fidel", false, "4th Grade")); // Updated to include ID
        childList.add(new Child(9, 10, "King", true, "3rd Grade"));   // Updated to include ID
        childList.add(new Child(6, 20, "Queen", true, "3rd Grade")); // Updated to include ID
        childList.add(new Child(7, 22, "ANNA", true, "1st Grade")); // Updated to include ID
        childList.add(new Child(8, 12, "Kwizera", false, "4th Grade")); // Updated to include ID
        childList.add(new Child(9, 30, "Nobz", true, "3rd Grade"));   // Updated to include ID


        // Add more Child objects as needed...

        for (int i = 0; i < childList.size(); i++) {
            Child child = childList.get(i);
            TextView childTextView = new TextView(getContext());
            childTextView.setText((i + 1) + ". Name: " + child.getName() + "\nAge: " + child.getAge() + ", Enrolled: " + child.isEnrolled() + "\nGrade: " + child.getGrade());
            childTextView.setPadding(16, 16, 16, 16);
            childListContainer.addView(childTextView);
        }

        return view;
    }
}
