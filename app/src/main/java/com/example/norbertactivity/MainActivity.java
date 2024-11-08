package com.example.norbertactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private ImageView moreOptionsIcon;
    private TextView bookNowTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons and image view
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        moreOptionsIcon = findViewById(R.id.more_options_icon);
        bookNowTextView = findViewById(R.id.rightBottomTextView);

        // Set click listener for button1 to start FragmentsActivity
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentsActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for button2 to start TabbedActivity
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TabbedActivity.class);
                startActivity(intent);
            }
        });

        // Set up the PopupMenu for the ImageView
        moreOptionsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        // Set click listener for the BOOK Now TextView
        bookNowTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBookingDialog();
            }
        });
    }

    private void showPopupMenu(View view) {
        // Create a PopupMenu
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        // Show the popup menu
        popupMenu.show();
    }

    private void showBookingDialog() {
        // Inflate the dialog layout
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_booking, null);

        // Get references to the EditText in the dialog layout
        EditText editText = dialogView.findViewById(R.id.edit_text_booking_details);

        // Create an AlertDialog
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setPositiveButton("OK", (dialogInterface, i) -> {
                    String bookingDetails = editText.getText().toString();
                    Toast.makeText(MainActivity.this, "Booking Details: " + bookingDetails, Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss())
                .create();

        // Show the dialog
        dialog.show();
    }
}