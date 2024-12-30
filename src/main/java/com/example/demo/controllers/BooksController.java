package com.example.demo.controllers;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Books;
import com.example.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    // Récupérer tous les livres
    @GetMapping
    public List<BookDTO> getAllBooks() {
        return booksService.getAllBooks();
    }

    // Récupérer un livre par ID
    @GetMapping("/{id}")
    public Optional<BookDTO> getBookById(@PathVariable Long id) {
        return booksService.getBookById(id);
    }

    // Créer un livre
    @PostMapping(consumes = {"multipart/form-data"})
    public Books createBook(
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("userId") Long userId,
            @RequestParam(value = "file", required = false) MultipartFile file
    ) throws IOException {
        return booksService.createBook(title, author, categoryId, userId, file);
    }

    // Mettre à jour un livre
    @PutMapping("/{id}")
    public Books updateBook(@PathVariable Long id, @RequestBody Books updatedBook) {
        return booksService.updateBook(id, updatedBook);
    }

    // Supprimer un livre
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        booksService.deleteBook(id);
    }
}
