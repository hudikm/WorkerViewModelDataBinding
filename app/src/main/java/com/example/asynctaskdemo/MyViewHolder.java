package com.example.asynctaskdemo;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

public class MyViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    private final ViewDataBinding binding;

    public MyViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void bind(Object obj) {
        binding.setVariable(BR.data,obj);
        binding.executePendingBindings();
    }
}

