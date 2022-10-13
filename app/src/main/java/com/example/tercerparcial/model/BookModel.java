package com.example.tercerparcial.model;


import com.example.tercerparcial.api.ApiClient;
import com.example.tercerparcial.api.BooksApi;
import com.example.tercerparcial.bean.Book;
import com.example.tercerparcial.presenter.IBookPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookModel implements IBookModel {

    IBookPresenter presenter;
    BooksApi booksApi;

    public BookModel(IBookPresenter presenter){
        this.presenter=presenter;
        booksApi= ApiClient.getBookInstance().create(BooksApi.class);
    }

    @Override
    public void getBook() {
        Call<List<Book>> bookCall = booksApi.getBooks();
        bookCall.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                List<Book> bookList=response.body();
                presenter.onBooksSuccess(bookList);
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                presenter.onBooksFail(t.getMessage());
            }
        });
    }
}
