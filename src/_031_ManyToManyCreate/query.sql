-- Write your code here:
/*
Write an SQL script that will do:

Create a table called author_book.
Adding a column author_id with type INT; its values cannot be null.
Adding a book_id column with type INT; the values in it cannot be null either.
*/
CREATE TABLE `author_book` (
  `author_id` INT NOT NULL,
  `book_id` INT NOT NULL
);
