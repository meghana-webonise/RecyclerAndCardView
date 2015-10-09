package com.weboniselab.meghana.android.app.recyclerandcardview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by webonise on 9/10/15.
 */
public class RecyclerView extends Activity {
    private DetailsAdapter adapter;
    DatabaseOperations databaseOperations=new DatabaseOperations(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        android.support.v7.widget.RecyclerView recyclerView=(android.support.v7.widget.RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        adapter=new DetailsAdapter(RecyclerView.this,databaseOperations.getAllDetails());
        recyclerView.setAdapter(adapter);
    }
}
