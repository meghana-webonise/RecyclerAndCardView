package com.weboniselab.meghana.android.app.recyclerandcardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by webonise on 9/10/15.
 */
public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ContactViewHolder> {


    DatabaseOperations databaseOperations;
    private List<Model> detailsList;
    Context context;

    public DetailsAdapter(Context context, List<Model> detailsList) {
        this.context=context;
        this.detailsList = detailsList;
        databaseOperations=new DatabaseOperations(context);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Model model=detailsList.get(position);
        holder.tName.setText(model.getName());
        holder.tAge.setText(model.getAge());
        Log.d("&&&&&&&&&&7", String.valueOf(model.getId()));

    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        protected TextView tName,tAge;

        public ContactViewHolder(View itemView) {
            super(itemView);
            tName=(TextView) itemView.findViewById(R.id.tName);
            tAge=(TextView) itemView.findViewById(R.id.tAge);
        }
    }
}
