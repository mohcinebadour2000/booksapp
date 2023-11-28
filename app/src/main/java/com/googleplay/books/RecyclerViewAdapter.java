package com.googleplay.books;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Book> mData;

    public RecyclerViewAdapter(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view  = layoutInflater.inflate(R.layout.cardview_item_book,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.itemView.setOnClickListener(view -> {
            Context context = view.getContext();
            Intent intent = new Intent(context, ReadBook.class); // Replace "TargetActivity" with the name of your target activity
            String bookTitle = mData.get(position).getTitle();
            String description = mData.get(position).getDescription();
            int bookCover = mData.get(position).getThumbnail();
            intent.putExtra("title", bookTitle);
            intent.putExtra("cover", bookCover);
            intent.putExtra("description", description);
            context.startActivity(intent);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img_book_thumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_book_thumbnail = itemView.findViewById(R.id.book_img_id);

        }
    }
}
