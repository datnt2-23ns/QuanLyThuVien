package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ManagerBorrowsBooksView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tf_maDocGia;
    private JTextField tf_maSach;
    private JTextField tf_soLuong;
    private JTextField tf_ngayMuon;
    private JTextField tf_ngayHenTra;
    private JTable table;
    private JButton bt_muonSach;
    private JButton bt_timKiem;
    private JButton bt_suaThongTin;
    private JButton bt_traSach;
    private JButton bt_xoa;
    private DefaultTableModel tableModel;

    public ManagerBorrowsBooksView(DefaultTableModel tableModel) {
    	this.tableModel = tableModel;
        setTitle("Quản lý Mượn trả");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 970, 486);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Quản lý");
        menu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JMenuItem libraryManagement_Item = new JMenuItem("Thư viện");
        libraryManagement_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menu.add(libraryManagement_Item);

        JMenuItem readerManagement_Item = new JMenuItem("Độc giả");
        readerManagement_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menu.add(readerManagement_Item);

        JMenuItem managerBorrowsBooks_Item = new JMenuItem("Mượn trả");
        managerBorrowsBooks_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menu.add(managerBorrowsBooks_Item);

        JMenu menu2 = new JMenu("Phản hồi");
        menu2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
		JMenuItem feedBack_Item = new JMenuItem("Độc giả");
		feedBack_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu2.add(feedBack_Item);
		
		JMenuItem feedBackAdmin_Item = new JMenuItem("Admin");
		feedBackAdmin_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu2.add(feedBackAdmin_Item);
		
        JMenu menu3 = new JMenu("Đăng nhập & Thoát");
        menu3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        JMenuItem login_Item = new JMenuItem("Đăng nhập");
        login_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menu3.add(login_Item);
        
        JMenuItem exit_Item = new JMenuItem("Thoát");
        exit_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menu3.add(exit_Item);

        menuBar.add(menu);
        menuBar.add(menu2);
        menuBar.add(menu3);
        setJMenuBar(menuBar);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 956, 181);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lb_maDocGia = new JLabel("Mã độc giả");
        lb_maDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_maDocGia.setBounds(10, 10, 69, 17);
        panel.add(lb_maDocGia);

        tf_maDocGia = new JTextField();
        tf_maDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_maDocGia.setBounds(89, 11, 149, 19);
        panel.add(tf_maDocGia);
        tf_maDocGia.setColumns(10);

        JLabel lb_maSach = new JLabel("Mã sách");
        lb_maSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_maSach.setBounds(10, 59, 69, 13);
        panel.add(lb_maSach);

        tf_maSach = new JTextField();
        tf_maSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_maSach.setBounds(89, 58, 149, 19);
        panel.add(tf_maSach);
        tf_maSach.setColumns(10);

        JLabel lb_soLuong = new JLabel("Số lượng");
        lb_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_soLuong.setBounds(342, 10, 69, 17);
        panel.add(lb_soLuong);

        tf_soLuong = new JTextField();
        tf_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_soLuong.setBounds(423, 11, 149, 19);
        panel.add(tf_soLuong);
        tf_soLuong.setColumns(10);

        JLabel lb_ngayMuon = new JLabel("Ngày mượn");
        lb_ngayMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_ngayMuon.setBounds(342, 57, 80, 16);
        panel.add(lb_ngayMuon);

        tf_ngayMuon = new JTextField();
        tf_ngayMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_ngayMuon.setBounds(423, 58, 149, 19);
        panel.add(tf_ngayMuon);
        tf_ngayMuon.setColumns(10);

        JLabel lb_ngayHenTra = new JLabel("Ngày hẹn trả");
        lb_ngayHenTra.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_ngayHenTra.setBounds(665, 10, 92, 17);
        panel.add(lb_ngayHenTra);

        tf_ngayHenTra = new JTextField();
        tf_ngayHenTra.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_ngayHenTra.setBounds(764, 11, 149, 19);
        panel.add(tf_ngayHenTra);
        tf_ngayHenTra.setColumns(10);

        bt_muonSach = new JButton("Mượn sách");
        bt_muonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_muonSach.setBounds(89, 113, 101, 21);
        panel.add(bt_muonSach);

        bt_timKiem = new JButton("Tìm kiếm");
        bt_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_timKiem.setBounds(776, 115, 92, 21);
        panel.add(bt_timKiem);

        bt_suaThongTin = new JButton("Sửa thông tin");
        bt_suaThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_suaThongTin.setBounds(254, 115, 119,         21);
        panel.add(bt_suaThongTin);

        bt_traSach = new JButton("Trả sách");
        bt_traSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_traSach.setBounds(453, 115, 92, 21);
        panel.add(bt_traSach);

        bt_xoa = new JButton("Xóa");
        bt_xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_xoa.setBounds(616, 115, 85, 21);
        panel.add(bt_xoa);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 195, 936, 218);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(tableModel);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        scrollPane.setViewportView(table);
    }

    public void addMuonSachListener(ActionListener listener) {
        bt_muonSach.addActionListener(listener);
    }

    public void addTimKiemListener(ActionListener listener) {
        bt_timKiem.addActionListener(listener);
    }

    public void addSuaThongTinListener(ActionListener listener) {
        bt_suaThongTin.addActionListener(listener);
    }

    public void addTraSachListener(ActionListener listener) {
        bt_traSach.addActionListener(listener);
    }

    public void addXoaListener(ActionListener listener) {
        bt_xoa.addActionListener(listener);
    }

    public String getMaDocGia() {
        return tf_maDocGia.getText().trim();
    }

    public String getMaSach() {
        return tf_maSach.getText().trim();
    }

    public int getSoLuong() {
        try {
            return Integer.parseInt(tf_soLuong.getText().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String getNgayMuon() {
        return tf_ngayMuon.getText().trim();
    }

    public String getNgayHenTra() {
        return tf_ngayHenTra.getText().trim();
    }

    public void clearInputFields() {
        tf_maDocGia.setText("");
        tf_maSach.setText("");
        tf_soLuong.setText("");
        tf_ngayMuon.setText("");
        tf_ngayHenTra.setText("");
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public int getSelectedTableRowIndex() {
        return table.getSelectedRow();
    }

    public String getSelectedMaDocGia() {
        int rowIndex = table.getSelectedRow();
        if (rowIndex != -1) {
            return (String) tableModel.getValueAt(rowIndex, 1);
        }
        return null;
    }
}