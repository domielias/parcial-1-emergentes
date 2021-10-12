package com.example.isc_581_t;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.isc_581_t.dummy.DummyContent.DummyItem;
import com.example.isc_581_t.placeholder.PlaceholderContent;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderContent.PlaceholderVersion> mValues;
    private final OnTouchListener<PlaceholderContent.PlaceholderVersion> mListener;

    public MyItemRecyclerViewAdapter(List<PlaceholderContent.PlaceholderVersion> items, OnTouchListener<PlaceholderContent.PlaceholderVersion> listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(holder.mItem.getName());
//        holder.mVersionNumberView.setText(holder.mItem.getVersionNumber());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mContentView;
//        public final TextView mVersionNumberView;
        public PlaceholderContent.PlaceholderVersion mItem;
        private OnTouchListener<PlaceholderContent.PlaceholderVersion> mListener;

        public ViewHolder(View view, OnTouchListener<PlaceholderContent.PlaceholderVersion> listener) {
            super(view);
            mContentView = (TextView) view.findViewById(R.id.content);
//            mVersionNumberView = (TextView) view.findViewById(R.id.versionNumber);
            mListener = listener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(mItem);
        }
    }
}