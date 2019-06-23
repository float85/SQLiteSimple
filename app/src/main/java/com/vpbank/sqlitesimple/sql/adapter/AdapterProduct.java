package com.vpbank.sqlitesimple.sql.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpbank.sqlitesimple.R;
import com.vpbank.sqlitesimple.sql.Product;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.Viewhoder> {
    onClickProduct onClickProduct;
    List<Product> productList;
    Context context;

    public AdapterProduct(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    public void setOnClickProduct(onClickProduct onClickProduct) {
        this.onClickProduct = onClickProduct;

    }

    @NonNull
    @Override
    public AdapterProduct.Viewhoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_product, viewGroup, false);
        Viewhoder viewhoder = new Viewhoder(view);
        return viewhoder;

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduct.Viewhoder vh, int i) {
        final Product product = productList.get(i);
        vh.tvID.setText(product.getId());
        vh.tvName.setText(product.getName());
        vh.tvQuantity.setText(product.getQuantity());

        vh.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickProduct.onClick(product);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        TextView tvID, tvName, tvQuantity;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvName);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
        }
    }
}
