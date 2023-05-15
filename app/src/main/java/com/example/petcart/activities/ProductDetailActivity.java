package com.example.petcart.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.petcart.R;
import com.example.petcart.databinding.ActivityProductDetailBinding;
import com.example.petcart.model.Product;
import com.example.petcart.utils.Constants;
import com.hishd.tinycart.model.Cart;
import com.hishd.tinycart.util.TinyCartHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductDetailActivity extends AppCompatActivity {


    ActivityProductDetailBinding binding;
    private ImageView productImage;
    private TextView nameTextView;
    private TextView phoneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name = getIntent().getStringExtra("name");
        String image = getIntent().getStringExtra("image");
        int id = getIntent().getIntExtra("id", 0);
        double price = getIntent().getDoubleExtra("price", 0);

        productImage = binding.productImage;
        nameTextView = binding.nameTextView;
        phoneTextView = binding.phoneTextView;

        // Generate random name and phone number
        String randomName = generateRandomName();
        String randomPhoneNumber = generateRandomPhoneNumber();

        // Set the generated values to the TextViews
        nameTextView.setText(randomName);
        phoneTextView.setText(randomPhoneNumber);

        Glide.with(this)
                .load(image)
                .into(binding.productImage);



        getSupportActionBar().setTitle(name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Cart cart = TinyCartHelper.getCart();




    }
    private String generateRandomName() {
        String[] names = {
                "John", "Emily", "Michael", "Sophia", "Daniel", "Olivia", "Matthew", "Ava", "David", "Emma"
        };

        int index = (int) (Math.random() * names.length);

        return names[index];
    }

    private String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder();

        // Generate 10-digit random phone number
        for (int i = 0; i < 10; i++) {
            int digit = (int) (Math.random() * 10);
            phoneNumber.append(digit);
        }

        return phoneNumber.toString();
    }
}