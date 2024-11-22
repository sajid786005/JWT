package com.Abbas.Jwt_Security.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookRepository  extends JpaRepository<Book, Integer> {
}
