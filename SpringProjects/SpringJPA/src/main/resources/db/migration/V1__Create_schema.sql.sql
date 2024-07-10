CREATE SCHEMA IF NOT EXISTS library;

CREATE TABLE IF NOT EXISTS library.authors (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS library.books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES library.authors(author_id)
);