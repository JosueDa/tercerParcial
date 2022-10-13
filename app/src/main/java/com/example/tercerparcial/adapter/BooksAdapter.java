package com.example.tercerparcial.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tercerparcial.R;
import com.example.tercerparcial.bean.Book;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<Book> mBooks;
    private Context context;

    public BooksAdapter(List<Book> mBooks) {
        this.mBooks = mBooks;
    }

    public void reloadData(List<Book> books) {
        this.mBooks = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(this.context);

        View contactView = inflater.inflate(R.layout.item_book, parent, false);
        ViewHolder viewHolder= new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
        Book book = mBooks.get(position);

        TextView bookName= holder.mBookName;
        bookName.setText(book.mTitle);
        TextView mBookAuthor= holder.mBookAuthor;
        mBookAuthor.setText(book.mAuthor);
        ImageView mBookImage= holder.mBookImage;
        Glide.with(this.context).load(book.mImageUrl).into(mBookImage);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mBookImage;
        private TextView mBookName;
        private TextView mBookAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mBookImage= (ImageView) itemView.findViewById(R.id.book_image);
            mBookName= (TextView) itemView.findViewById(R.id.book_name);
            mBookAuthor= (TextView) itemView.findViewById(R.id.book_author);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
