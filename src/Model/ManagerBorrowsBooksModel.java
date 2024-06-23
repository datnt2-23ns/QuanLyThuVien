package Model;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class ManagerBorrowsBooksModel {
    private DefaultTableModel tableModel;

    public ManagerBorrowsBooksModel() {
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "STT", "Mã độc giả", "Mã sách", "Số lượng", "Ngày mượn", "Ngày hẹn trả", "Ngày trả", "Trạng thái"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    Integer.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class
            };

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void addBorrowRecord(String maDocGia, String maSach, int soLuong, String ngayMuon, String ngayHenTra) {
        Object[] row = {
                tableModel.getRowCount() + 1, maDocGia, maSach, soLuong, ngayMuon, ngayHenTra, "", "Đang mượn"
        };
        tableModel.addRow(row);
    }

    public void updateBorrowRecord(int rowIndex, String returnDate) {
        tableModel.setValueAt(returnDate, rowIndex, 6);
        tableModel.setValueAt("Đã trả", rowIndex, 7);
    }

    public void removeBorrowRecord(String maDocGia) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 1).equals(maDocGia)) {
                tableModel.removeRow(i);
                break;
            }
        }
    }

    public int findBorrowRecord(String maDocGia) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 1).equals(maDocGia)) {
                return i;
            }
        }
        return -1;
    }
}
