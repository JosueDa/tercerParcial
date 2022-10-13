package com.example.tercerparcial.presenter;


import com.example.tercerparcial.bean.Book;

import java.util.List;

public interface IBookPresenter {
    void getBooks();
    void onBooksSuccess(List<Book> books);
    void onBooksFail(String msg);
}
