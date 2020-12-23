package com.example.groceriescsc301;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NUMBER = "com.example.groceriescsc301.EXTRA_NUMBER";
    private RecyclerView mRecyclerView;
    private GroceryAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<GroceryItem> myGroceryList;
    private ImageView cartImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createGroceryList();
        buildRecyclerView();
        cartImage = (ImageView) findViewById(R.id.imageView);
        cartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCartActivity();
            }
        });
    }


    /**
     * Sets up the recycler view.
     */
    public void buildRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 1);
        mAdapter = new GroceryAdapter(myGroceryList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new GroceryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                openAddToCartActivity(position);
            }
        });
    }

    /**
     * Directs the user to the cart activity.
     */
    public void openCartActivity() {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    /**
     * Directs the user to the add to cart activity.
     */
    public void openAddToCartActivity(int position) {
        Intent intent = new Intent(this, AddToCartActivity.class);
        intent.putExtra(EXTRA_NUMBER, position);
        startActivity(intent);
    }

    /**
     * Creates 12 GroceryItems and adds them to arrayList myGroceryList.
     */
    public void createGroceryList() {
        myGroceryList = new ArrayList<>();
        myGroceryList.add(new GroceryItem("Dairy", "Ice Cream", 7.0, R.drawable.ice_cream));
        myGroceryList.add(new GroceryItem("Dairy", "Milk", 5.0, R.drawable.milk));
        myGroceryList.add(new GroceryItem("Dairy", "Yogurt Drink", 2.0, R.drawable.yogurt_drink));
        myGroceryList.add(new GroceryItem("Fruit", "Apple", 0.5, R.drawable.apple));
        myGroceryList.add(new GroceryItem("Fruit", "Bunch Of Bananas", 2.0, R.drawable.bananas));
        myGroceryList.add(new GroceryItem("Fruit", "Peach", 1.0, R.drawable.peach));
        myGroceryList.add(new GroceryItem("Fruit", "Pear", 0.6, R.drawable.pear));
        myGroceryList.add(new GroceryItem("Meat", "Chicken Thigh Value Pack", 8.0, R.drawable.chicken_thigh_value_pack));
        myGroceryList.add(new GroceryItem("Meat", "Ground Pork Value Pack", 7.0, R.drawable.ground_pork_value_pack));
        myGroceryList.add(new GroceryItem("Meat", "Lean Ground Beef Value Pack", 10.0, R.drawable.lean_ground_beef_value_pack));
        myGroceryList.add(new GroceryItem("Vegetables", "Cabbage", 2.0, R.drawable.cabbage));
        myGroceryList.add(new GroceryItem("Vegetables", "Carrot", 2.0, R.drawable.carrot));
    }
}