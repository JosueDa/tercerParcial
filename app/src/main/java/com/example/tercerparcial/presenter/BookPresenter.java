package com.example.tercerparcial.presenter;


import com.example.tercerparcial.bean.Book;
import com.example.tercerparcial.model.BookModel;
import com.example.tercerparcial.model.IBookModel;
import com.example.tercerparcial.view.IBookView;

import java.util.List;

public class BookPresenter implements IBookPresenter{

    IBookView bookView;
    IBookModel bookModel;
    public BookPresenter(IBookView view){
        this.bookModel=new BookModel(this);
        this.bookView=view;
    }

    @Override
    public void getBooks() {
        bookModel.getBook();
    }

    @Override
    public void onBooksSuccess(List<Book> books) {
        bookView.onBooksSuccess(books);
    }

    @Override
    public void onBooksFail(String msg) {
        bookView.onBooksFail(msg);
    }
}
