package com.materialuiux.databindingexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.materialuiux.databindingexample.databinding.ItemPostViewBinding;

import java.util.List;

public class Ad_Recycler_View extends RecyclerView.Adapter<Ad_Recycler_View.ViewHolder> implements IClick {

    private List<Post> data;
    private Context mContext;
    private LayoutInflater layoutInflater;

    Ad_Recycler_View(List<Post> dummyData, Context context) {
        this.data = dummyData;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemPostViewBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_post_view, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(data.get(position));
        holder.binding.setIclick(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemPostViewBinding binding;

        ViewHolder(final ItemPostViewBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }

        void setData(Post post) {
            binding.setPost(post);
            binding.executePendingBindings();
        }
    }

    public void onClicked(Post post) {
        Toast.makeText(mContext, "You clicked " + post.getBody(), Toast.LENGTH_LONG).show();
    }
}
