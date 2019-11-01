package com.glriverside.xgqin.staggerecyclerview;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String NEWS_ID = "news_id";
    private ProductAdapter productAdapter = null;

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;

    private String[] products = null;

    private List<Product> productList = new ArrayList<>();
    private TypedArray images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.lv_news_list);

        initData();

        productAdapter = new ProductAdapter(
                MainActivity.this,
                R.layout.list_item,
                productList
        );
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(sglm);
        recyclerView.setAdapter(productAdapter);
    }

    private void initData() {
        products = getResources().getStringArray(R.array.products);
        images = getResources().obtainTypedArray(R.array.images);

        Gson gson = new Gson();
        for (int i = 0; i < products.length; i++) {
            Product product = gson.fromJson(products[i], Product.class);
            product.setImageId(images.getResourceId(i, 0));
            productList.add(product);
        }
    }
}
