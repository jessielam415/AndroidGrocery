package com.example.groceriescsc301;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * An adapter that handles clicks to items in the recycler view from CartActivity.
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private OnItemClickListener mListener;

    /**
     * An interface that allows CartActivity to interact with CartViewHolder.
     */
    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    /**
     * View Holder for cart items.
     */
    public static class CartViewHolder extends RecyclerView.ViewHolder {
        public ImageView myImage;
        public TextView myPrice;
        public TextView myName;
        public TextView myQuantity;
        public ImageView mDeleteImage;

        public CartViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            myImage = itemView.findViewById(R.id.cartImage);
            myPrice = itemView.findViewById(R.id.itemPrice);
            myName = itemView.findViewById(R.id.itemGroceryName);
            myQuantity = itemView.findViewById(R.id.itemQuantity);
            mDeleteImage = itemView.findViewById(R.id.delete);
            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    /**
     * Constructs a new CartAdapter
     */
    public CartAdapter() {
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        CartAdapter.CartViewHolder cvh = new CartAdapter.CartViewHolder(v, mListener);
        return cvh;
    }
    @Override
    public void onBindViewHolder(CartAdapter.CartViewHolder holder, int position) {
        CartItem currentItem = Cart.getCart().get(position);
        holder.myImage.setImageResource(currentItem.getImageDrawable());
        holder.myPrice.setText(Double.toString(currentItem.getPrice()));
        holder.myName.setText(currentItem.getGroceryName());
        holder.myQuantity.setText(Integer.toString(currentItem.getQuantity()));

    }

    @Override
    public int getItemCount() {
        return Cart.getCart().size();
    }
}
