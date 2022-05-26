package com.example.hoply.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoply.R;
import com.example.hoply.database.Posts;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private List<Posts> posts = new ArrayList<>();

    @NonNull
    @Override
    public PostAdapter.PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items,parent,false);
        return new PostHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostHolder holder, int position) {
        Posts currentPost = posts.get(position);
        holder.name.setText(currentPost.user_id);
        holder.content.setText(currentPost.content);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Posts> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    class PostHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView content;

        public PostHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            content = itemView.findViewById(R.id.content);
        }
    }
}
