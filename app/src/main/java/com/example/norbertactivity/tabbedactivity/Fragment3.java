//package com.example.norbertactivity.tabbedactivity;
//
//import android.os.Bundle;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import com.example.norbertactivity.model.Child; // Import statement for Child
//import com.example.norbertactivity.R; // Correct import for R
//import java.util.ArrayList;
//import java.util.List;
//
//public class Fragment3 extends Fragment {
//    private List<Child> childObjects;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_3, container, false);
//
//        // Initialize the list of Child objects
//        childObjects = new ArrayList<>();
//        childObjects.add(new Child(10, "Sample 1", true, "5th Grade"));
//        childObjects.add(new Child(11, "Sample 2", false, "6th Grade"));
//
//        // Display child data in the layout
//        TextView childInfoTextView = view.findViewById(R.id.recycler_view);
//        StringBuilder childInfo = new StringBuilder();
//        for (Child child : childObjects) {
//            childInfo.append("Name: ").append(child.getName()).append("\n");
//            childInfo.append("Age: ").append(child.getAge()).append("\n");
//            childInfo.append("Grade: ").append(child.getGrade()).append("\n\n");
//        }
//        childInfoTextView.setText(childInfo.toString());
//
//        return view;
//    }
//}