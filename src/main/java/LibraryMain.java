import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("Welcome to Library Management System!");
        System.out.println();
        System.out.println("Please select an option:");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Library library = new Library();

        // Program çalıştığı sürece ana döngü
        while (running)  {

            // Menü seçeneklerini yazdırıyoruz
            printMenu();

            // Kullanıcının seçimini alıyoruz
            int choice = scanner.nextInt();
            scanner.nextLine();  // Yeni satır karakterini temizliyoruz

            // Kullanıcının seçimine göre işlemleri yapıyoruz
            switch (choice) {
                case 1:
                    addNewBook(scanner, library);  // Yeni kitap ekle
                    break;

                case 2:
                    displayAllBooks(library);  // Tüm kitapları görüntüle
                    break;

                case 3:
                    searchForBookByTitle(scanner, library);  // Kitap başlığına göre arama yap
                    break;

                case 4:
                    rentBook(library, scanner);  // Kitap kirala
                    break;

                case 5:
                    returnBook(scanner, library);  // Kitap iade et
                    break;

                case 6:
                    System.out.println("Thank you for using the Library Management System!");
                    running = false;  // Çıkış işlemi
                    break;

                default:
                    System.out.println("You entered wrong number!");  // Geçersiz giriş
            }
        }
    }

    // Menü seçeneklerini yazdıran metot
    public static void printMenu(){
        System.out.println("1. Add new book ");
        System.out.println("2. Display all books ");
        System.out.println("3. Search for a book by title ");
        System.out.println("4. Rent a book with ISBN ");
        System.out.println("5. Return a book ");
        System.out.println("6. Exit the library ");
        System.out.print("Enter your choice:");
    }

    // Yeni kitap ekleme metodu
    public static void addNewBook(Scanner scanner, Library library) {

        // Kullanıcıdan kitap bilgilerini alıyoruz
        System.out.print("Enter Title : ");
        String title = scanner.nextLine();

        System.out.print("Enter Author : ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN no :");
        String isbn = scanner.nextLine();

        // Yeni kitap nesnesi oluşturuyoruz ve bilgilerini ayarlıyoruz
        Book book = new Book();
        book.setBookTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);

        // Kitapları kütüphaneye ekliyoruz
        library.addBooks(book);
        System.out.println("Book added successfully! ");
    }

    // Tüm kitapları listeleyen metot
    private static void displayAllBooks(Library library) {
        List<Book> books = library.getBooks();

        // Kitaplar listesi boşsa uyarı veriyoruz
        if (books.isEmpty()){
            System.out.println("No Books available  in the library");
        } else {
            // Kitapları başlıklarına göre alfabetik sıralıyoruz
            Collections.sort(books, new Comparator<Book>() {
                @Override
                public int compare(Book book1, Book book2) {
                    return book1.getBookTitle().compareToIgnoreCase(book2.getBookTitle());
                }
            });
        }

        // Kitap bilgilerini yazdırıyoruz
        System.out.println("Books in the Library:");
        System.out.println("---------------------");

        // Kitapların detaylarını yazdırıyoruz
        for (Book book : books){
            System.out.println("Title     : " + book.getBookTitle());
            System.out.println("Author    : " + book.getAuthor());
            System.out.println("ISBN      : " + book.getIsbn());
            System.out.println("Available : " + (book.isRented() ? "No" : "Yes"));
            System.out.println("---------------------");
        }
    }

    // Kitap başlığına göre arama yapan metot
    private static void searchForBookByTitle(Scanner scanner, Library library) {

        // Kullanıcıdan aramak istediği kitap başlığını alıyoruz
        System.out.println("Enter book Title ");
        String enteredTitle = scanner.nextLine();

        List<Book> books = library.getBooks();
        boolean isFound = false;

        // Kitapları başlığa göre arıyoruz
        for (Book book : books) {
            if (book.getBookTitle().equalsIgnoreCase(enteredTitle)) {
                // Kitap bulunduysa bilgilerini yazdırıyoruz
                System.out.println("Book Found:");
                System.out.println("---------------------");
                System.out.println("Title     : " + book.getBookTitle());
                System.out.println("Author    : " + book.getAuthor());
                System.out.println("ISBN      : " + book.getIsbn());
                System.out.println("Available : " + (book.isRented() ? "No" : "Yes"));
                System.out.println("---------------------");
                isFound = true;
                break;
            }
        }

        // Eğer kitap bulunamazsa kullanıcıya mesaj gösteriyoruz
        if (!isFound){
            System.out.println("There is no book with this title!");
        }
    }

    // Kitap kiralama metodu
    private static void rentBook(Library library, Scanner scanner) {

        // Kullanıcıdan kiralamak istediği kitabın ISBN'sini alıyoruz
        System.out.print("Enter book ISBN:");
        String enteredISBN = scanner.nextLine();
        List<Book> books = library.getBooks();

        boolean foundBook = false;
        boolean rentedBook = false;

        // Kitapları ISBN'ye göre arıyoruz
        for (Book book : books) {
            if (enteredISBN.equalsIgnoreCase(book.getIsbn())) {
                foundBook = true;

                // Kitap bulunursa, kiralanıp kiralanmadığını kontrol ediyoruz
                if (!book.isRented()) {
                    book.setRented(true);  // Kitap kiralanmış olarak işaretleniyor
                    System.out.println("You have successfully rented the book: " + book.getBookTitle());
                    rentedBook = true;
                } else {
                    // Eğer kitap zaten kiralanmışsa
                    System.out.println("Sorry, the book is already rented!");
                }
                break;  // Kitap bulunduğunda, döngüden çıkıyoruz
            }
        }

        // Kitap bulunamazsa kullanıcıya uyarı veriyoruz
        if (!foundBook){
            System.out.println("Sorry, the book with ISBN " + "'" + enteredISBN + "'" + " was not found or is already rented!");
        }
    }

    // Kitap iade etme metodu
    public static void returnBook(Scanner scanner, Library library) {
        boolean isReturn = false;
        // Kullanıcıdan iade etmek istediği kitabın ISBN'sini alıyoruz
        System.out.println("Please enter the ISBN of the book you want to return!");
        String ISBN = scanner.nextLine();

        List <Book> books = library.getBooks();

        // Kitapları ISBN'ye göre arıyoruz
        for (Book book : books){
            if (book.getIsbn().equalsIgnoreCase(ISBN)){
                // Kitap bulunduysa, iade işlemini gerçekleştiriyoruz
                library.returnBook(book);
                System.out.println("Book returned successfully!");
                isReturn = true;
            }
        }

        // Kitap bulunamazsa kullanıcıya uyarı veriyoruz
        if (!isReturn){
            System.out.println("You entered the wrong ISBN!");
        }
    }
}
