package com.example.utatuasinventoryapp;

import android.os.Bundle;
import android.content.Intent;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.fragment.NavHostFragment;
import androidx.cardview.widget.CardView;
import android.graphics.Color;

import com.example.utatuasinventoryapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button browseButton = findViewById(R.id.browse_button);
        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BrowseActivity.class);
                startActivity(intent);
            }
        });
//        GridLayout gridLayout = findViewById(R.id.grid_layout);
//
//        for (int i = 1; i <= 8; i++) {
//            // Create a new CardView
//            CardView cardView = new CardView(this);
//
//            // Set layout parameters for CardView
//            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
//            layoutParams.width = 0;
//            layoutParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
//            layoutParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
//            layoutParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
//            layoutParams.setMargins(10, 10, 10, 10);
//            cardView.setLayoutParams(layoutParams);
//
//            // Set CardView properties
//            cardView.setCardBackgroundColor(getResources().getColor(android.R.color.darker_gray));
//            cardView.setRadius(20);
//            cardView.setCardElevation(10);
//            cardView.setMaxCardElevation(12);
//            cardView.setPreventCornerOverlap(true);
//            cardView.setUseCompatPadding(true);
//
//            // Create a TextView
//            TextView textView = new TextView(this);
//            textView.setLayoutParams(new GridLayout.LayoutParams());
//            textView.setPadding(20, 20, 20, 20);
//            textView.setText("Category 1");
//            textView.setTextSize(20);
////            textView.setTextStyle(TextView.BOLD);
//            textView.setTextColor(Color.BLACK);
//            textView.setGravity(android.view.Gravity.CENTER);
//
//            // Add TextView to CardView
//            cardView.addView(textView);
//
//            // Add CardView to GridLayout
//            gridLayout.addView(cardView);
//        }
    }

    // Method to handle CardView click events
    public void onCardClick(View view) {
        if (view instanceof CardView) {
            CardView cardView = (CardView) view;
            TextView textView = (TextView) cardView.getChildAt(0);
            String category = textView.getText().toString();

            // Display a toast message
            Toast.makeText(this, "Clicked on " + category, Toast.LENGTH_SHORT).show();

            // Example: Start a new activity based on the category
            // Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
            // intent.putExtra("category", category);
            // startActivity(intent);
        }
    }

//    public void openSubcategory(View view) {
//        Intent intent = new Intent(this, SubcategoryActivity.class);
//        intent.putExtra("category", "Communication");
//        startActivity(intent);
//    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.nav_host_fragment);
//        NavController navController = navHostFragment.getNavController();
//        return navController.navigateUp() || super.onSupportNavigateUp();
//    }
}