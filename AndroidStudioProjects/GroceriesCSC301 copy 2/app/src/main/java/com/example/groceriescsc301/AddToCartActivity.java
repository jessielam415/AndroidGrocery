package com.example.groceriescsc301;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class AddToCartActivity extends AppCompatActivity {
    public ImageView myGroceryImage;
    public TextView myGroceryName;
    private TextView myGroceryPrice;
    private int initialQuantity;
    private TextView myQuantity;
    private Button buttonIncrease;
    private Button buttonDecrease;
    private Button buttonAdd;
    private GroceryItem targetItem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_to_add);
        Intent intent = getIntent();
        int number = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);
        myGroceryPrice = (TextView) findViewById(R.id.price_to_add);
        myGroceryName = (TextView) findViewById(R.id.grocery_name_to_add);
        myQuantity = (TextView) findViewById(R.id.itemQuantity);
        myGroceryImage = (ImageView) findViewById(R.id.grocery_image_to_add);
        buttonIncrease = (Button) findViewById(R.id.button_increase);
        buttonDecrease = (Button) findViewById(R.id.button_decrease);
        buttonAdd = (Button) findViewById(R.id.button_add);
        targetItem = GroceryAdapter.mGroceryList.get(number);

        myGroceryImage.setImageResource(targetItem.getImageDrawable());
        myQuantity.setText(Integer.toString(initialQuantity));
        myGroceryPrice.setText(Double.toString(targetItem.getPrice()));
        myGroceryName.setText(targetItem.getGroceryName());

        // Setting up the buttons
        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                increase();
            }
        });
        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }

    /**
     * Increases the quantity of the cart item.
     */
    public void increase(){
        initialQuantity++;
        myQuantity.setText(String.valueOf(initialQuantity));
    }

    /**
     * Decreases the quantity of the cart item.
     */
    public void decrease(){
        if (initialQuantity > 0) {
            initialQuantity--;
            myQuantity.setText(String.valueOf(initialQuantity));
        }
    }

    /**
     * Decreases the quantity of the cart item.
     */
    public void addItem() {
        if (Integer.parseInt(myQuantity.getText().toString()) > 0) {
            Cart.getCart().add(new CartItem(targetItem.getGroceryName(), targetItem.getPrice(),
                    Integer.parseInt(myQuantity.getText().toString()), targetItem.getImageDrawable()));
        } else {
            Toast.makeText(this, "Can't add 0 items to cart!", Toast.LENGTH_SHORT).show();
        }

    }
}
