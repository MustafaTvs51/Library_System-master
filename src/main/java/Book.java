public class Book {

    // Kitabın yazarını tutan değişken
    private String author;

    // Kitabın başlığını tutan değişken
    private String bookTitle;

    // Kitabın ISBN numarasını tutan değişken
    private String isbn;

    // Kitabın kiralanıp kiralanmadığını belirten değişken
    private boolean Rented;

    // Kitabın kiralanıp kiralanmadığını döndüren metod
    public boolean isRented() {
        return Rented;
    }

    // Kitabın kiralanma durumunu ayarlayan metod
    public void setRented(boolean rented) {
        Rented = rented;
    }

    // Kitabın yazarını döndüren metod
    public String getAuthor() {
        return author;
    }

    // Kitabın yazarını ayarlayan metod
    public void setAuthor(String author) {
        this.author = author;
    }

    // Kitabın başlığını döndüren metod
    public String getBookTitle() {
        return bookTitle;
    }

    // Kitabın başlığını ayarlayan metod
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    // Kitabın ISBN numarasını döndüren metod
    public String getIsbn() {
        return isbn;
    }

    // Kitabın ISBN numarasını ayarlayan metod
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Kitabın bilgilerini string formatında döndüren metod (toString)
    @Override
    public String toString() {
        return " Found Books : \n " +
                "------------------- \n" +
                "author='" + author + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
