package Controller;

import Model.ManagerBorrowsBooksModel;
import View.ManagerBorrowsBooksView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ManagerBorrowsBooksController {
    private ManagerBorrowsBooksView view;
    private ManagerBorrowsBooksModel model;

    public ManagerBorrowsBooksController(ManagerBorrowsBooksView view, ManagerBorrowsBooksModel model) {
        this.view = view;
        this.model = model;

        view.addMuonSachListener(new MuonSachListener());
        view.addSuaThongTinListener(new SuaThongTinListener());
        view.addXoaListener(new XoaListener());
        view.addTraSachListener(new TraSachListener());
        view.addTimKiemListener(new TimKiemListener());
    }

    class MuonSachListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String maDocGia = view.getMaDocGia();
            String maSach = view.getMaSach();
            int soLuong = view.getSoLuong();
            String ngayMuon = view.getNgayMuon();
            String ngayHenTra = view.getNgayHenTra();

            if (maDocGia.isEmpty() || maSach.isEmpty() || soLuong <= 0 || ngayMuon.isEmpty() || ngayHenTra.isEmpty()) {
                view.showMessage("Vui lòng nhập đầy đủ thông tin mượn sách.");
                return;
            }

            model.addBorrowRecord(maDocGia, maSach, soLuong, ngayMuon, ngayHenTra);
            view.clearInputFields();
        }
    }

    class SuaThongTinListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showMessage("Bây giờ bạn có thể chỉnh sửa dữ liệu trực tiếp trên bảng. Nhấn Enter để lưu thay đổi.");
            // Enable table editing
        }
    }

    class XoaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String maDocGia = view.getSelectedMaDocGia();
            if (maDocGia != null) {
                model.removeBorrowRecord(maDocGia);
            } else {
                view.showMessage("Vui lòng chọn một bản ghi để xóa.");
            }
        }
    }

    class TraSachListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String maDocGia = view.getSelectedMaDocGia();
            if (maDocGia != null) {
                int rowIndex = model.findBorrowRecord(maDocGia);
                if (rowIndex != -1) {
                    LocalDate currentDate = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String formattedDate = currentDate.format(formatter);
                    model.updateBorrowRecord(rowIndex, formattedDate);
                } else {
                    view.showMessage("Không tìm thấy độc giả có mã: " + maDocGia);
                }
            } else {
                view.showMessage("Vui lòng chọn một bản ghi để trả sách.");
            }
        }
    }

    class TimKiemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String maDocGia = view.getMaDocGia();
            if (!maDocGia.isEmpty()) {
                int rowIndex = model.findBorrowRecord(maDocGia);
                if (rowIndex != -1) {
                    view.showMessage("Độc giả có mã: " + maDocGia + " ở vị trí: " + (rowIndex + 1));
                } else {
                    view.showMessage("Độc giả không tồn tại.");
                }
            } else {
                view.showMessage("Vui lòng nhập mã độc giả để tìm kiếm.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ManagerBorrowsBooksModel model = new ManagerBorrowsBooksModel();
            ManagerBorrowsBooksView view = new ManagerBorrowsBooksView(model.getTableModel());
            new ManagerBorrowsBooksController(view, model);
            view.setVisible(true);
        });
    }
}
