package com.example.tercerparcial.view;


import com.example.tercerparcial.bean.Book;

import java.util.List;

public interface IBookView {
    void onBooksSuccess(List<Book> books);
    void onBooksFail(String msg);
}
