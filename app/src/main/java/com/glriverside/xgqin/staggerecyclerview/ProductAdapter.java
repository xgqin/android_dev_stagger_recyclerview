package com.glriverside.xgqin.staggerecyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> mProductData;
    private Context mContext;
    private int resourceId;
    private Resources resources;
    public ProductAdapter(Context context, int resourceId, List<Product> data) {
        this.mContext = context;
        this.mProductData = data;
        this.resourceId = resourceId;
        resources = context.getResources();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(resourceId, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = mProductData.get(position);
        holder.tvDesc.setText(product.getDesc());
        holder.tvPrice.setText(Double.toString(product.getPrice()));
        holder.tvQuantityOfSale.setText(resources.getString(R.string.quantity_of_sale, product.getQuantity()));

        if (product.getImageId() != -1) {
            holder.ivImage.setImageResource(product.getImageId());
        }
    }

    @Override
    public int getItemCount() {
        return mProductData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDesc;
        TextView tvPrice;
        TextView tvQuantityOfSale;
        ImageView ivImage;

        public ViewHolder(View view) {
            super(view);

            tvDesc = view.findViewById(R.id.tv_desc);
            tvPrice = view.findViewById(R.id.tv_price);
            tvQuantityOfSale = view.findViewById(R.id.tv_quantity);
            ivImage = view.findViewById(R.id.iv_image);
        }
    }
}
