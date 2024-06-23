package Controller;

import Model.Book;
import View.LibraryManagementView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LibraryManagementController {
 private LibraryManagementView view;
 private ExecutorService executorService = Executors.newCachedThreadPool();

 public LibraryManagementController(LibraryManagementView view) {
     this.view = view;
     this.view.setVisible(true);
     initController();
 }

 private void initController() {
     view.getTf_maSach().addActionListener(new AddBookAction());
     view.getTf_tenSach().addActionListener(new AddBookAction());
     view.getTf_tacGia().addActionListener(new AddBookAction());
     view.getTf_theLoai().addActionListener(new AddBookAction());
     view.getTf_soTrang().addActionListener(new AddBookAction());
     view.getTf_nhaSX().addActionListener(new AddBookAction());
     view.getTf_namXB().addActionListener(new AddBookAction());
     view.getTf_giaSach().addActionListener(new AddBookAction());
     view.getTf_soLuong().addActionListener(new AddBookAction());

     JButton btn_themSach = new JButton("Thêm sách");
     btn_themSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
     btn_themSach.addActionListener(new AddBookAction());
     view.add(btn_themSach);
 }

 private class AddBookAction implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent e) {
         String maSach = view.getTf_maSach().getText();
         String tenSach = view.getTf_tenSach().getText();
         String tacGia = view.getTf_tacGia().getText();
         String theLoai = view.getTf_theLoai().getText();
         int soTrang = Integer.parseInt(view.getTf_soTrang().getText());
         String nhaSX = view.getTf_nhaSX().getText();
         int namXB = Integer.parseInt(view.getTf_namXB().getText());
         int giaSach = Integer.parseInt(view.getTf_giaSach().getText());
         int soLuong = Integer.parseInt(view.getTf_soLuong().getText());

         Vector<Object> row = new Vector<>();
         row.add(view.getTableModel().getRowCount() + 1);
         row.add(maSach);
         row.add(tenSach);
         row.add(tacGia);
         row.add(theLoai);
         row.add(soTrang);
         row.add(nhaSX);
         row.add(namXB);
         row.add(giaSach);
         row.add(soLuong);
         view.getTableModel().addRow(row);

         view.getTf_maSach().setText("");
         view.getTf_tenSach().setText("");
         view.getTf_tacGia().setText("");
         view.getTf_theLoai().setText("");
         view.getTf_soTrang().setText("");
         view.getTf_nhaSX().setText("");
         view.getTf_namXB().setText("");
         view.getTf_giaSach().setText("");
         view.getTf_soLuong().setText("");
     }
 }
}
