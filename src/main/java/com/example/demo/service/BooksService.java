package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Books;
import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import com.example.demo.repository.BooksRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileStorageService fileStorageService;

    // Récupérer tous les livres (en DTO)
    public List<BookDTO> getAllBooks() {
        return booksRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Récupérer un livre par ID (en DTO)
    public Optional<BookDTO> getBookById(Long id) {
        return booksRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Créer un livre
    public Books createBook(String title, String author, Long categoryId, Long userId, MultipartFile file) throws IOException {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String filePath = null;
        if (file != null && !file.isEmpty()) {
            filePath = fileStorageService.saveFile(file);
        }

        Books book = new Books();
        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory(category);
        book.setUser(user);
        book.setPdfPath(filePath);

        return booksRepository.save(book);
    }

    // Mettre à jour un livre
    public Books updateBook(Long id, Books updatedBook) {
        return booksRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setCategory(updatedBook.getCategory());
                    book.setPdfPath(updatedBook.getPdfPath());
                    book.setUser(updatedBook.getUser());
                    return booksRepository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // Supprimer un livre
    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }

    // Convertir une entité Books en DTO
    private BookDTO convertToDTO(Books book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setUserName(book.getUser().getUsername());
        dto.setCategoryName(book.getCategory().getName());
        dto.setPublicationDate(book.getPublicationDate());
        dto.setPdfPath(book.getPdfPath());
        return dto;
    }
}
