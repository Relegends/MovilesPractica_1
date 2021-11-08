package com.example.movilespractica_1;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class ScoreListAdapter extends ListAdapter<Score, ScoreViewHolder> {

    public ScoreListAdapter(@NonNull DiffUtil.ItemCallback<Score> diffCallback) {
        super(diffCallback);
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ScoreViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {
        Score current = getItem(position);
        holder.bind(current.getUserName() + " " + current.getPoints());
    }

    static class ScoreDiff extends DiffUtil.ItemCallback<Score> {

        @Override
        public boolean areItemsTheSame(@NonNull Score oldItem, @NonNull Score newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Score oldItem, @NonNull Score newItem) {
            return oldItem.getId() == (newItem.getId());
        }
    }

}
