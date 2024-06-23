package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LibraryManagementView extends JFrame {
    private JPanel contentPane;
    private JTextField tf_maSach;
    private JTextField tf_tenSach;
    private JTextField tf_tacGia;
    private JTextField tf_theLoai;
    private JTextField tf_soTrang;
    private JTextField tf_nhaSX;
    private JTextField tf_namXB;
    private JTextField tf_giaSach;
    private JTextField tf_soLuong;
    private JTable table;
    private DefaultTableModel tableModel;

    public LibraryManagementView() {
        setTitle("Quản lý Thư viện");
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
        panel.setBounds(0, 0, 929, 197);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lb_maSach = new JLabel("Mã sách");
        lb_maSach.setBounds(10, 10, 58, 16);
        lb_maSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(lb_maSach);

        tf_maSach = new JTextField();
        tf_maSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_maSach.setBounds(78, 10, 149, 19);
        panel.add(tf_maSach);
        tf_maSach.setColumns(10);

        JLabel lb_tenSach = new JLabel("Tên sách");
        lb_tenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_tenSach.setBounds(10, 49, 58, 13);
        panel.add(lb_tenSach);

        tf_tenSach = new JTextField();
        tf_tenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_tenSach.setBounds(78, 48, 149, 19);
        panel.add(tf_tenSach);
        tf_tenSach.setColumns(10);

        JLabel lb_tacGia = new JLabel("Tác giả");
        lb_tacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_tacGia.setBounds(10, 88, 58, 13);
        panel.add(lb_tacGia);

        tf_tacGia = new JTextField();
        tf_tacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_tacGia.setBounds(78, 87, 149, 19);
        panel.add(tf_tacGia);
        tf_tacGia.setColumns(10);

        JLabel lb_theLoai = new JLabel("Thể loại");
        lb_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_theLoai.setBounds(318, 10, 58, 17);
        panel.add(lb_theLoai);

        tf_theLoai = new JTextField();
        tf_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_theLoai.setBounds(382, 11, 149, 19);
        panel.add(tf_theLoai);
        tf_theLoai.setColumns(10);

        JLabel lb_soTrang = new JLabel("Số trang");
        lb_soTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_soTrang.setBounds(318, 54, 58, 13);
        panel.add(lb_soTrang);

        tf_soTrang = new JTextField();
        tf_soTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_soTrang.setBounds(382, 48, 149, 19);
        panel.add(tf_soTrang);
        tf_soTrang.setColumns(10);

        JLabel lb_nhaSX = new JLabel("Nhà SX");
        lb_nhaSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_nhaSX.setBounds(318, 90, 58, 13);
        panel.add(lb_nhaSX);

        tf_nhaSX = new JTextField();
        tf_nhaSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_nhaSX.setBounds(382, 87, 149, 19);
        panel.add(tf_nhaSX);
        tf_nhaSX.setColumns(10);

        JLabel lb_namXB = new JLabel("Năm xuất bản");
        lb_namXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_namXB.setBounds(636, 14, 95, 13);
        panel.add(lb_namXB);

        tf_namXB = new JTextField();
        tf_namXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_namXB.setBounds(741, 11, 149, 19);
        panel.add(tf_namXB);
        tf_namXB.setColumns(10);

        JLabel lb_giaSach = new JLabel("Giá sách");
        lb_giaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_giaSach.setBounds(636, 54, 58, 13);
        panel.add(lb_giaSach);

        tf_giaSach = new JTextField();
        tf_giaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_giaSach.setBounds(741, 48, 149, 19);
        panel.add(tf_giaSach);
        tf_giaSach.setColumns(10);

        JLabel lb_soLuong = new JLabel("Số lượng");
        lb_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_soLuong.setBounds(636, 88, 58, 17);
        panel.add(lb_soLuong);

        tf_soLuong = new JTextField();
        tf_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_soLuong.setBounds(741, 87, 149, 19);
        panel.add(tf_soLuong);
        tf_soLuong.setColumns(10);

        JButton btn_themSach = new JButton("Thêm sách");
        btn_themSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_themSach.setBounds(304, 139, 117, 21);
        panel.add(btn_themSach);

        JButton btn_suaThongTin = new JButton("Sửa thông tin");
        btn_suaThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_suaThongTin.setBounds(431, 139, 130, 21);
        panel.add(btn_suaThongTin);

        JButton btn_xoaSach = new JButton("Xóa sách");
        btn_xoaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_xoaSach.setBounds(571, 139, 107, 21);
        panel.add(btn_xoaSach);

        JButton btn_timKiem = new JButton("Tìm kiếm");
        btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_timKiem.setBounds(794, 139, 96, 21);
        panel.add(btn_timKiem);

        JButton btn_lamMoi = new JButton("Làm mới");
        btn_lamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_lamMoi.setBounds(685, 139, 96, 21);
        panel.add(btn_lamMoi);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 229, 929, 175);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "STT", "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Số trang", "Nhà sản xuất", "Năm xuất bản", "Giá sách", "Số lượng"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    Integer.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return true; 
            }
        };
        table.setModel(tableModel);
        scrollPane.setViewportView(table);
    }

    public JTextField getTf_maSach() { return tf_maSach; }
    public JTextField getTf_tenSach() { return tf_tenSach; }
    public JTextField getTf_tacGia() { return tf_tacGia; }
    public JTextField getTf_theLoai() { return tf_theLoai; }
    public JTextField getTf_soTrang() { return tf_soTrang; }
    public JTextField getTf_nhaSX() { return tf_nhaSX; }
    public JTextField getTf_namXB() { return tf_namXB; }
    public JTextField getTf_giaSach() { return tf_giaSach; }
    public JTextField getTf_soLuong() { return tf_soLuong; }
    public DefaultTableModel getTableModel() { return tableModel; }
    public JTable getTable() { return table; }
}
