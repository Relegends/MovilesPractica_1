package com.example.movilespractica_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ScoreViewHolder extends RecyclerView.ViewHolder {

    private final TextView scoreItemView;

    private ScoreViewHolder (View itemView) {
        super(itemView);
        scoreItemView = itemView.findViewById(R.id.textNumberQuestions);
    }

    public void bind(String text) {
        scoreItemView.setText(text);
    }

    static ScoreViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ScoreViewHolder(view);
    }
}
