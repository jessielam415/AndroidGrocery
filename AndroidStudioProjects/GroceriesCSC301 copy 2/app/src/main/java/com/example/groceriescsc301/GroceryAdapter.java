package com.example.groceriescsc301;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * An adapter that handles clicks to items in the recycler view from MainActivity.
 */
public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {
    public static ArrayList<GroceryItem> mGroceryList;
    private OnItemClickListener mListener;

    /**
     * An interface that allows MainActivity to interact with GroceryViewHolder.
     */
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    /**
     * Sets GroceryAdapter's listener.
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    /**
     * View Holder for grocery items.
     */
    public static class GroceryViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImage;
        public TextView mPrice;
        public TextView mName;

        public GroceryViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImage = itemView.findViewById(R.id.grocery_image_display);
            mPrice = itemView.findViewById(R.id.grocery_price_display);
            mName = itemView.findViewById(R.id.grocery_name_display);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    /**
     * Constructs a new GroceryAdapter
     */
    public GroceryAdapter(ArrayList<GroceryItem> groceryList) {
        mGroceryList = groceryList;
    }
    @Override
    public GroceryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_display, parent, false);
        GroceryViewHolder gvh = new GroceryViewHolder(v, mListener);
        return gvh;
    }
    @Override
    public void onBindViewHolder(GroceryViewHolder holder, int position) {
        GroceryItem currentItem = mGroceryList.get(position);
        holder.mImage.setImageResource(currentItem.getImageDrawable());
        holder.mPrice.setText(Double.toString(currentItem.getPrice()));
        holder.mName.setText(currentItem.getGroceryName());
    }
    @Override
    public int getItemCount() {
        return mGroceryList.size();
    }
}


