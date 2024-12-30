package com.example.demo.repository;

import com.example.demo.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
    // Méthodes par défaut de JpaRepository suffisent pour CRUD
}
