package com.techiesandeep.mvp.repos;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.techiesandeep.mvp.R;
import com.techiesandeep.mvp.models.GitRepository;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  Created by Sandeep Tiwari on 8/6/16.
 */
public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {

    private List<GitRepository> items;
    private Context context;

    public RepositoryAdapter(Context context, List<GitRepository> items) {
        this.items = items;
        this.context = context;
    }


    @Override
    public RepositoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_repo, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RepositoryAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        GitRepository repo = items.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(repo.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        @BindView(R.id.txt_repo)
        public TextView nameTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
