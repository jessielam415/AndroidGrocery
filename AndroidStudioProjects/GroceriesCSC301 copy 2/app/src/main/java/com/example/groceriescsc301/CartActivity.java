package com.example.groceriescsc301;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CartActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CartAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private EditText discountPercentage;
    private Button clearAll;
    private Button applyDiscount;
    private TextView priceBeforeTax;
    private TextView priceWithTax;
    private TextView priceWithTaxDiscount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        buildRecyclerView();
        setTextViews();
        discountPercentage = findViewById(R.id.enter_discount);
        setButtons();
        generateInitialPriceValues();

    }

    /**
     * Sets up the recycler view.
     */
    public void buildRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.cart_recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CartAdapter();
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new CartAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    /**
     * Removes the cart item at position.
     */
    public void removeItem(int position) {
        Cart.getCart().remove(position);
        regeneratePriceAfterRemove();
        mAdapter.notifyItemRemoved(position);
    }

    /**
     * Regenerates the total price, total price with tax, and total price with tax and discount
     * after removing an item.
     */
    public void regeneratePriceAfterRemove() {
        double totalPriceBeforeTax = 0.0;
        for (int counter = 0; counter < (Cart.getCart()).size(); counter++) {
            totalPriceBeforeTax += (Cart.getCart().get(counter)).getPrice();
        }
        double discount = 0.0;
        try { String text = discountPercentage.getText().toString();
            discount = Double.parseDouble(text);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        priceBeforeTax.setText(String.format("%.2f", totalPriceBeforeTax));
        double totalPriceWithTax = totalPriceBeforeTax * 1.13;
        priceWithTax.setText(String.format("%.2f", totalPriceWithTax));
        double priceWithTaxAndDiscount = totalPriceBeforeTax + totalPriceBeforeTax * 0.13 - totalPriceBeforeTax * (discount * 0.01) ;
        priceWithTaxDiscount.setText(String.format("%.2f",priceWithTaxAndDiscount));
    }

    /**
     * Regenerates the total price, total price with tax, and total price with tax and discount
     * after applying a discount.
     */
    public void regneratePriceAfterDiscount() {
        boolean valid = true;
        double discount = 0;
        try { String text = discountPercentage.getText().toString();
            discount = Double.parseDouble(text);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if (discount < 0.0 || discount > 100.0) {
            Toast.makeText(CartActivity.this, "Please enter a discount percentage between 0 and 100!", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if (valid) {
            double beforeTaxPrice = Double.parseDouble(priceBeforeTax.getText().toString());
            double priceWithTaxAndDiscount = beforeTaxPrice * (1 - discount * 0.01) * 1.13;
            priceWithTaxDiscount.setText(String.format("%.2f", priceWithTaxAndDiscount));
        }
    }

    /**
     * Generates the total price, total price with tax, and total price with tax and discount.
     */
    public void generateInitialPriceValues() {
        double totalPriceBeforeTax = 0.0;
        for (int counter = 0; counter < (Cart.getCart()).size(); counter++) {
            int quantity = (Cart.getCart().get(counter)).getQuantity();
            totalPriceBeforeTax += ((double) quantity) * (Cart.getCart().get(counter)).getPrice();
        }
        priceBeforeTax.setText(String.format("%.2f", totalPriceBeforeTax));
        double totalPriceWithTax = totalPriceBeforeTax * 1.13;
        priceWithTax.setText(String.format("%.2f", totalPriceWithTax));
        priceWithTaxDiscount.setText(String.format("%.2f", totalPriceWithTax));
    }

    /**
     * Checks and returns whether an edit text is empty.
     */
    private boolean editTextIsEmpty(EditText myEditText) {
        if (myEditText.getText().toString().trim().length() > 0) {
            return false;
        }
        return true;
    }

    /**
     * Set up the TextViews in this activity.
     */
    public void setTextViews() {
        priceBeforeTax = findViewById(R.id.before_tax_real);
        priceWithTax = findViewById(R.id.price_with_tax_real);
        priceWithTaxDiscount = findViewById(R.id.total_price_with_discount_real);
    }

    /**
     * Set the price of the total price, total price with tax, and total price with tax and discount
     * to 0.
     */
    public void setToEmptyCartPrice() {
        priceBeforeTax.setText(Double.toString(0.00));
        priceWithTax.setText(Double.toString(0.00));
        priceWithTaxDiscount.setText(Double.toString(0.00));
    }

    /**
     * Set up the Buttons in this activity
     */
    public void setButtons() {
        clearAll = (Button) findViewById(R.id.clear_all);
        applyDiscount = (Button) findViewById(R.id.apply_discount);
        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalItems = Cart.getCart().size();
                Cart.getCart().clear();
                setToEmptyCartPrice();
                for (int counter = 0; counter < (Cart.getCart()).size(); counter++) {
                    Cart.getCart().remove(0);
                }
                mAdapter.notifyDataSetChanged();
            }
        });
        applyDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextIsEmpty(discountPercentage)) {
                    Toast.makeText(CartActivity.this, "Please enter a discount percentage!", Toast.LENGTH_SHORT).show();
                } else {
                    regneratePriceAfterDiscount();
                }
            }
        });
    }
}
