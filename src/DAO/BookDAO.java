package DAO;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private List<Book> books = new ArrayList<>();

    public void addBook(String maSach, String tenSach, String tacGia, String theLoai, int soTrang, String nhaSX, int namXB, int giaSach, int soLuong) {
        Book book = new Book(maSach, tenSach, tacGia, theLoai, soTrang, nhaSX, namXB, giaSach, soLuong);
        books.add(book);
    }

    public void deleteBook(String maSach) {
        books.removeIf(book -> book.getMaSach().equals(maSach));
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
