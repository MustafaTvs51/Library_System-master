import java.util.ArrayList;
import java.util.List;

public class Library {
    // Kitapları tutacak olan ArrayList
    private ArrayList<Book> books;

    // Yapıcı metot, kitapları tutacak bir ArrayList oluşturuyor
    public Library() {
        books = new ArrayList<>();
    }

    // Kitap ekleme metodu
    // Bu metot, parametre olarak alınan 'book' nesnesini 'books' listesine ekler
    public void addBooks(Book book) {
        books.add(book);  // Kitapları ArrayList'e ekliyoruz
    }

    // Kitapları listeleme metodu
    // Bu metot, mevcut kitapları içeren 'books' listesini döner
    public ArrayList<Book> getBooks() {
        return books;  // Kitap listesini döndürüyoruz
    }

    // Kitap geri iade etme metodu
    // Bu metot, verilen 'bookToBeReturned' kitabını kiralanmayan duruma getirir
    public void returnBook(Book bookToBeReturned) {
        // Geri iade edilecek kitabın ISBN'sini alıyoruz
        String ISBN = bookToBeReturned.getIsbn();

        // Kitap listesinde döngü başlatıyoruz
        for (Book book : books) {
            // Kitap listesinde eşleşen ISBN'yi buluyoruz
            if (book.getIsbn().equalsIgnoreCase(ISBN)) {
                // Kitap geri iade edildiği için 'Rented' durumunu false yapıyoruz
                book.setRented(false);
            }
        }
    }

    // Kitap kiralama metodu
    // Bu metot, verilen 'bookToBeRented' kitabını kiralanmış olarak işaretler
    public void rentBook(Book bookToBeRented) {
        // Kiralanacak kitabın ISBN'sini alıyoruz
        String ISBN = bookToBeRented.getIsbn();

        // Kitap listesinde döngü başlatıyoruz
        for (Book book : books) {
            // Kitap listesinde eşleşen ISBN'yi buluyoruz
            if (book.getIsbn().equalsIgnoreCase(ISBN)) {
                // Kitap kiralandığı için 'Rented' durumunu true yapıyoruz
                book.setRented(true);
            }
        }
    }
}
