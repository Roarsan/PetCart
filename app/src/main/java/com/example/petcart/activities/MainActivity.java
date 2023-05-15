package com.example.petcart.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petcart.R;
import com.example.petcart.adapters.CategoryAdapter;
import com.example.petcart.adapters.ProductAdapter;
import com.example.petcart.databinding.ActivityMainBinding;
import com.example.petcart.model.Category;
import com.example.petcart.model.Product;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;

    ProductAdapter productAdapter;
    ArrayList<Product> products;

    private ImageView imageView;
    private TextView nameTextView;
    private TextView phoneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initCategories();
        initProducts();
        initSlider();

    }

    private void initSlider() {
        binding.carousel.addData(new CarouselItem("https://www.therange.co.uk/media/6/5/1655452368_12_8182.jpg","No matter if they're large or small, we have just what you need to keep your pet happy and healthy."));
        binding.carousel.addData(new CarouselItem("https://cdn.media.amplience.net/i/petsathome/hp-sldr-tvbrandlaunch-dt_1?w=2100&",""));
    }

    void initCategories(){
        categories = new ArrayList<>();
        categories.add(new Category("Dogs","https://th.bing.com/th/id/OIP.bjQHKk6CRNn3MCCr0iQyOQHaHa?pid=ImgDet&rs=1","#4186ff","",1));
        categories.add(new Category("Cats","https://th.bing.com/th/id/R.975ddaa30793da918b0496781ac1060e?rik=9s%2beGTNWVNgbPA&riu=http%3a%2f%2fdesignlooter.com%2fimages%2fyellow-eyes-svg-10.png&ehk=ePpRBhFmJzogM7wKMx%2f9u%2bDdOLDDIP%2bnzBmiNIjApjg%3d&risl=&pid=ImgRaw&r=0","#18ab4e","Description",1));
        categories.add(new Category("Birds","https://th.bing.com/th/id/OIP.pagQ9G-A91mb5KActHz6SwHaHa?pid=ImgDet&rs=1","#fb0504","",1));
        categoryAdapter = new CategoryAdapter(this,categories);

        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        binding.categorieslist.setLayoutManager(layoutManager);
        binding.categorieslist.setAdapter(categoryAdapter);

    }

    void initProducts(){
        products = new ArrayList<>();
        products.add(new Product("Dog Bed","https://th.bing.com/th?id=OIF.ascwoFRaXsY39hXuN%2fHvhw&pid=ImgDet&rs=1",
                "",35,12,1, 1));
        products.add(new Product("Gravy Bones","https://th.bing.com/th/id/OIP.LIc8TtRrrH3w0dykquCrjQHaE8?pid=ImgDet&rs=1",
                "",13.99,2,1, 2));
        products.add(new Product("Cat Litter Tray","https://th.bing.com/th/id/OIP.Xgtx-rmCWaVCep1AlomXvgHaHa?pid=ImgDet&rs=1",
                "",10,3,1, 3));
        products.add(new Product("Flashing Dumbell","https://www.therange.co.uk/media/5/3/1660753995_12_6535.jpg",
                "",5,3,1, 4));
        products.add(new Product("Cat Bowl","https://www.therange.co.uk/media/6/7/1649771610_12_7652.jpg",
                "",12,6,1, 5));
        products.add(new Product("Toy Mouse","https://www.therange.co.uk/media/5/0/1465816698_803.jpg",
                "",14,4,1, 6));
        products.add(new Product("Metal Bird Cage","https://www.therange.co.uk/media/5/1/1614067005_12_5308.jpg",
                "",8,3,1, 7));
        products.add(new Product("Bird Budgie Food","https://www.therange.co.uk/media/5/1/1488361250_664.jpg",
                "",16,4,1, 8));
        products.add(new Product("Bird Hanging Toy","https://www.therange.co.uk/media/5/6/1462457335_594.jpg",
                "",13,3,1, 9));
        products.add(new Product("Cat Grooming Brush","https://www.therange.co.uk/media/4/7/1679988458_12_4658.jpg",
                "",20,5,1, 10));
        productAdapter = new ProductAdapter(this,products);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.productList.setLayoutManager(layoutManager);
        binding.productList.setAdapter(productAdapter);

    }
}