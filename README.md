# Library Management System

Welcome to the **Library Management System**! This Java-based project allows users to manage a library by adding, searching, renting, and returning books. The system keeps track of books' availability and provides a simple console interface for interacting with the library.

## Features

- **Add a new book** to the library by providing the title, author, and ISBN.
- **Display all books** in the library, sorted by title.
- **Search for a book** by its title.
- **Rent a book** using its ISBN, and track if it’s rented or available.
- **Return a rented book** to make it available again.
- **Exit the system** once done.

## Technologies Used

- Java (Core features)
- Collections Framework (ArrayList)
- Comparator for sorting books
- Scanner for user input

## How to Run

1. Clone or download the repository to your local machine.

    ```bash
    git clone https://github.com/yourusername/library-management-system.git
    ```

2. Open the project in your IDE (such as IntelliJ IDEA, Eclipse, etc.), or use any text editor.

3. Compile and run the `LibraryMain.java` file to start the application.

4. Follow the on-screen instructions in the console to interact with the system.

## File Overview

### `Book.java`

This class represents a book object in the system. It contains the following fields:
- **author**: The author of the book.
- **bookTitle**: The title of the book.
- **isbn**: The ISBN number of the book.
- **Rented**: A boolean that indicates whether the book is rented or available.

The `Book` class includes getter and setter methods to access and modify these fields, as well as a `toString()` method to print the book's details.

### `Library.java`

This class represents the library that holds a collection of books. The key methods include:
- **addBooks(Book book)**: Adds a new book to the library.
- **getBooks()**: Returns the list of books in the library.
- **returnBook(Book bookToBeReturned)**: Marks a book as returned.
- **rentBook(Book bookToBeRented)**: Marks a book as rented.

### `LibraryMain.java`

This is the main class that runs the console-based user interface. It includes a simple menu system with the following options:
1. Add a new book
2. Display all books
3. Search for a book by title
4. Rent a book by ISBN
5. Return a book
6. Exit the library system

The program interacts with the user via the console using the `Scanner` class for input.

## Example Usage

Here is an example of how the system works:

1. **Adding a new book**:

    ```bash
    Enter Title : The Great Gatsby
    Enter Author : F. Scott Fitzgerald
    Enter ISBN no : 9780743273565
    Book added successfully!
    ```

2. **Displaying all books**:

    ```bash
    Books in the Library:
    ---------------------
    Title     : The Great Gatsby
    Author    : F. Scott Fitzgerald
    ISBN      : 9780743273565
    Available : Yes
    ---------------------
    ```

3. **Renting a book**:

    ```bash
    Enter book ISBN: 9780743273565
    You have successfully rented the book: The Great Gatsby
    ```

4. **Returning a book**:

    ```bash
    Please enter the ISBN of the book you want to return!
    9780743273565
    Book returned successfully!
    ```

## How to Contribute

1. Fork the repository on GitHub.
2. Create a new branch for your changes.
3. Make changes and commit them.
4. Submit a pull request with a clear explanation of your changes.

## License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).

---

**Enjoy using the Library Management System!**
