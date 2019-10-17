package com.app.mode.demo.decorator.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder implements BaseHolder {
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
