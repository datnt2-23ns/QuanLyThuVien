//import javax.swing.*;
//import java.awt.EventQueue;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JMenuBar;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
//import java.awt.Font;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.UIManager;
//import javax.swing.JButton;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.JScrollPane;
//
//public class LibraryManagement extends JFrame {
//
//    private static final long serialVersionUID = 1L;
//    private JPanel contentPane;
//    private JTextField tf_maSach;
//    private JTextField tf_tenSach;
//    private JTextField tf_tacGia;
//    private JTextField tf_theLoai;
//    private JTextField tf_soTrang;
//    private JTextField tf_nhaSX;
//    private JTextField tf_namXB;
//    private JTextField tf_giaSach;
//    private JTextField tf_soLuong;
//    private JTable table;
//
//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                    LibraryManagement frame = new LibraryManagement();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    /**
//     * Create the frame.
//     */
//    public LibraryManagement() {
//    	setTitle("Quản lý Thư viện");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 970, 486);
//
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("Quản lý");
//        menu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//
//        JMenuItem libraryManagement_Item = new JMenuItem("Thư viện");
//        libraryManagement_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(libraryManagement_Item);
//
//        JMenuItem readerManagement_Item = new JMenuItem("Độc giả");
//        readerManagement_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(readerManagement_Item);
//
//        JMenuItem managerBorrowsBooks_Item = new JMenuItem("Mượn trả");
//        managerBorrowsBooks_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(managerBorrowsBooks_Item);
//        
//        JMenuItem feedBack_Item = new JMenuItem("Phản hồi");
//        feedBack_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(feedBack_Item);
//        
//        // Xử lý sự kiện menuBar
//        libraryManagement_Item.addActionListener(e -> {
//        });
//        
//        readerManagement_Item.addActionListener(e -> {
//        	// Chuyển sang giao diện "Quản lý Độc giả"
//        	dispose(); // Đóng cửa số hiện tại
//        	new ReaderManagement().setVisible(true); // Mở cửa sổ "Quản lý Độc giả"
//        });
//        
//        managerBorrowsBooks_Item.addActionListener(e -> {
//        	// Chuyển sang giao diện "Quản lý Mượn trả"
//        	dispose(); // Đóng cửa sổ hiện tại
//        	new ManagerBorrowsBooks().setVisible(true); // Mở cửa sổ "Quản lý Mượn trả"
//        });
//        
//        feedBack_Item.addActionListener(e -> {
//        	// Chuyển sang giao diện "Phản hồi"
//        	dispose(); // Đóng cửa sổ hiện tại
//        	new Feedback().setVisible(true); // Mở cửa sổ "Phản hồi"
//        	
//        });
//
//        menuBar.add(menu);
//        setJMenuBar(menuBar);
//
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//        JPanel panel = new JPanel();
//        panel.setBounds(0, 0, 929, 197);
//        contentPane.add(panel);
//        panel.setLayout(null);
//
//        JLabel lb_maSach = new JLabel("Mã sách");
//        lb_maSach.setBounds(10, 10, 58, 16);
//        lb_maSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        panel.add(lb_maSach);
//
//        tf_maSach = new JTextField();
//        tf_maSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_maSach.setBounds(78, 10, 149, 19);
//        panel.add(tf_maSach);
//        tf_maSach.setColumns(10);
//
//        JLabel lb_tenSach = new JLabel("Tên sách");
//        lb_tenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_tenSach.setBounds(10, 49, 58, 13);
//        panel.add(lb_tenSach);
//
//        tf_tenSach = new JTextField();
//        tf_tenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_tenSach.setBounds(78, 48, 149, 19);
//        panel.add(tf_tenSach);
//        tf_tenSach.setColumns(10);
//
//        JLabel lb_tacGia = new JLabel("Tác giả");
//        lb_tacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_tacGia.setBounds(10, 88, 58, 13);
//        panel.add(lb_tacGia);
//
//        tf_tacGia = new JTextField();
//        tf_tacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_tacGia.setBounds(78, 87, 149, 19);
//        panel.add(tf_tacGia);
//        tf_tacGia.setColumns(10);
//
//        JLabel lb_theLoai = new JLabel("Thể loại");
//        lb_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_theLoai.setBounds(318, 14, 58, 13);
//        panel.add(lb_theLoai);
//
//        tf_theLoai = new JTextField();
//        tf_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_theLoai.setBounds(382, 11, 149, 19);
//        panel.add(tf_theLoai);
//        tf_theLoai.setColumns(10);
//
//        JLabel lb_soTrang = new JLabel("Số trang");
//        lb_soTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_soTrang.setBounds(318, 54, 58, 13);
//        panel.add(lb_soTrang);
//
//        tf_soTrang = new JTextField();
//        tf_soTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_soTrang.setBounds(382, 48, 149, 19);
//        panel.add(tf_soTrang);
//        tf_soTrang.setColumns(10);
//
//        JLabel lb_nhaSX = new JLabel("Nhà SX");
//        lb_nhaSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_nhaSX.setBounds(318, 90, 58, 13);
//        panel.add(lb_nhaSX);
//
//        tf_nhaSX = new JTextField();
//        tf_nhaSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_nhaSX.setBounds(382, 87, 149, 19);
//        panel.add(tf_nhaSX);
//        tf_nhaSX.setColumns(10);
//
//        JLabel lb_namXB = new JLabel("Năm xuất bản");
//        lb_namXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_namXB.setBounds(636, 14, 95, 13);
//        panel.add(lb_namXB);
//
//        tf_namXB = new JTextField();
//        tf_namXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_namXB.setBounds(741, 11, 149, 19);
//        panel.add(tf_namXB);
//        tf_namXB.setColumns(10);
//
//        JLabel lb_giaSach = new JLabel("Giá sách");
//        lb_giaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_giaSach.setBounds(636, 51, 65, 13);
//        panel.add(lb_giaSach);
//
//        tf_giaSach = new JTextField();
//        tf_giaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_giaSach.setBounds(741, 48, 149, 19);
//        panel.add(tf_giaSach);
//        tf_giaSach.setColumns(10);
//
//        JLabel lb_soLuong = new JLabel("Số lượng");
//        lb_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_soLuong.setBounds(637, 90, 64, 13);
//        panel.add(lb_soLuong);
//
//        tf_soLuong = new JTextField();
//        tf_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_soLuong.setBounds(741, 87, 149, 19);
//        panel.add(tf_soLuong);
//        tf_soLuong.setColumns(10);
//
//        JButton btn_themSach = new JButton("Thêm sách");
//        btn_themSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_themSach.setBounds(78, 139, 117, 21);
//        panel.add(btn_themSach);
//
//        JButton btn_suaThongTin = new JButton("Sửa thông tin");
//        btn_suaThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_suaThongTin.setBounds(285, 139, 126, 21);
//        panel.add(btn_suaThongTin);
//
//        JButton btn_xoaSach = new JButton("Xóa sách");
//        btn_xoaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_xoaSach.setBounds(571, 139, 107, 21);
//        panel.add(btn_xoaSach);
//
//        JButton btn_timKiem = new JButton("Tìm kiếm");
//        btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_timKiem.setBounds(794, 139, 96, 21);
//        panel.add(btn_timKiem);
//
//        // Tạo JScrollPane và thêm JTable vào JScrollPane
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBounds(10, 229, 929, 175);
//        contentPane.add(scrollPane);
//
//        table = new JTable();
//        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        table.setModel(new DefaultTableModel(
//            new Object[][] {
//                {null, null, null, null, null, null, null, null, null, null},
//            },
//            new String[] {
//                "STT", "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Số trang", "Nhà sản xuất", "Năm xuất bản", "Giá sách", "Số lượng"
//            }
//        ) {
//            Class[] columnTypes = new Class[] {
//                Integer.class, String.class, Object.class, Object.class, String.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class
//            };
//            public Class getColumnClass(int columnIndex) {
//                return columnTypes[columnIndex];
//            }
//        });
//        table.getColumnModel().getColumn(0).setPreferredWidth(33);
//
//        scrollPane.setViewportView(table);
//    }
//}

//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Comparator;
//import java.util.Vector;
//
//public class LibraryManagement extends JFrame {
//
//    private JPanel contentPane;
//    private JTextField tf_maSach;
//    private JTextField tf_tenSach;
//    private JTextField tf_tacGia;
//    private JTextField tf_theLoai;
//    private JTextField tf_soTrang;
//    private JTextField tf_nhaSX;
//    private JTextField tf_namXB;
//    private JTextField tf_giaSach;
//    private JTextField tf_soLuong;
//    private JTable table;
//    private DefaultTableModel tableModel;
//
//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                    LibraryManagement frame = new LibraryManagement();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    /**
//     * Create the frame.
//     */
//    public LibraryManagement() {
//        setTitle("Quản lý Thư viện");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 970, 486);
//
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("Quản lý");
//        menu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//
//        JMenuItem libraryManagement_Item = new JMenuItem("Thư viện");
//        libraryManagement_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(libraryManagement_Item);
//
//        JMenuItem readerManagement_Item = new JMenuItem("Độc giả");
//        readerManagement_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(readerManagement_Item);
//
//        JMenuItem managerBorrowsBooks_Item = new JMenuItem("Mượn trả");
//        managerBorrowsBooks_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(managerBorrowsBooks_Item);
//
//        JMenuItem feedBack_Item = new JMenuItem("Phản hồi");
//        feedBack_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(feedBack_Item);
//
//        // Xử lý sự kiện menuBar
//        libraryManagement_Item.addActionListener(e -> {
//            // Chuyển sang giao diện "Quản lý Thư viện"
//            dispose(); // Đóng cửa sổ hiện tại
//            new LibraryManagement().setVisible(true); // Mở cửa sổ "Quản lý Thư viện"
//        });
//
//        readerManagement_Item.addActionListener(e -> {
//            // Chuyển sang giao diện "Quản lý Độc giả"
//            dispose();
//            new ReaderManagement().setVisible(true);
//        });
//
//        managerBorrowsBooks_Item.addActionListener(e -> {
//            // Chuyển sang giao diện "Quản lý Mượn trả"
//            dispose(); // Đóng cửa sổ hiện tại
//            new ManagerBorrowsBooks().setVisible(true); // Mở cửa sổ "Quản lý Mượn trả"
//        });
//
//        feedBack_Item.addActionListener(e -> {
//            // Chuyển sang giao diện "Phản hồi"
//            dispose(); // Đóng cửa sổ hiện tại
//            new Feedback().setVisible(true); // Mở cửa sổ "Phản hồi"
//
//        });
//
//        menuBar.add(menu);
//        setJMenuBar(menuBar);
//
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//        JPanel panel = new JPanel();
//        panel.setBounds(0, 0, 929, 197);
//        contentPane.add(panel);
//        panel.setLayout(null);
//
//        JLabel lb_maSach = new JLabel("Mã sách");
//        lb_maSach.setBounds(10, 10, 58, 16);
//        lb_maSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        panel.add(lb_maSach);
//
//        tf_maSach = new JTextField();
//        tf_maSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_maSach.setBounds(78, 10, 149, 19);
//        panel.add(tf_maSach);
//        tf_maSach.setColumns(10);
//
//        JLabel lb_tenSach = new JLabel("Tên sách");
//        lb_tenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_tenSach.setBounds(10, 49, 58, 13);
//        panel.add(lb_tenSach);
//
//        tf_tenSach = new JTextField();
//        tf_tenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_tenSach.setBounds(78, 48, 149, 19);
//        panel.add(tf_tenSach);
//        tf_tenSach.setColumns(10);
//
//        JLabel lb_tacGia = new JLabel("Tác giả");
//        lb_tacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_tacGia.setBounds(10, 88, 58, 13);
//        panel.add(lb_tacGia);
//
//        tf_tacGia = new JTextField();
//        tf_tacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_tacGia.setBounds(78, 87, 149, 19);
//        panel.add(tf_tacGia);
//        tf_tacGia.setColumns(10);
//
//        JLabel lb_theLoai = new JLabel("Thể loại");
//        lb_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_theLoai.setBounds(318, 10, 58, 17);
//        panel.add(lb_theLoai);
//
//        tf_theLoai = new JTextField();
//        tf_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_theLoai.setBounds(382, 11, 149, 19);
//        panel.add(tf_theLoai);
//        tf_theLoai.setColumns(10);
//
//        JLabel lb_soTrang = new JLabel("Số trang");
//        lb_soTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_soTrang.setBounds(318, 54, 58, 13);
//        panel.add(lb_soTrang);
//
//        tf_soTrang = new JTextField();
//        tf_soTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_soTrang.setBounds(382, 48, 149, 19);
//        panel.add(tf_soTrang);
//        tf_soTrang.setColumns(10);
//
//        JLabel lb_nhaSX = new JLabel("Nhà SX");
//        lb_nhaSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_nhaSX.setBounds(318, 90, 58, 13);
//        panel.add(lb_nhaSX);
//
//        tf_nhaSX = new JTextField();
//        tf_nhaSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_nhaSX.setBounds(382, 87, 149, 19);
//        panel.add(tf_nhaSX);
//        tf_nhaSX.setColumns(10);
//
//        JLabel lb_namXB = new JLabel("Năm xuất bản");
//        lb_namXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_namXB.setBounds(636, 14, 95, 13);
//        panel.add(lb_namXB);
//
//        tf_namXB = new JTextField();
//        tf_namXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_namXB.setBounds(741, 11, 149, 19);
//        panel.add(tf_namXB);
//        tf_namXB.setColumns(10);
//
//        JLabel lb_giaSach = new JLabel("Giá sách");
//        lb_giaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_giaSach.setBounds(636, 54, 58, 13);
//        panel.add(lb_giaSach);
//
//        tf_giaSach = new JTextField();
//        tf_giaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_giaSach.setBounds(741, 48, 149, 19);
//        panel.add(tf_giaSach);
//        tf_giaSach.setColumns(10);
//
//        JLabel lb_soLuong = new JLabel("Số lượng");
//        lb_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_soLuong.setBounds(636, 88, 58, 17);
//        panel.add(lb_soLuong);
//
//        tf_soLuong = new JTextField();
//        tf_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_soLuong.setBounds(741, 87, 149, 19);
//        panel.add(tf_soLuong);
//        tf_soLuong.setColumns(10);
//
//        JButton btn_themSach = new JButton("Thêm sách");
//        btn_themSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_themSach.setBounds(304, 139, 117, 21);
//        panel.add(btn_themSach);
//
//        JButton btn_suaThongTin = new JButton("Sửa thông tin");
//        btn_suaThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_suaThongTin.setBounds(431, 139, 130, 21);
//        panel.add(btn_suaThongTin);
//
//        JButton btn_xoaSach = new JButton("Xóa sách");
//        btn_xoaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_xoaSach.setBounds(571, 139, 107, 21);
//        panel.add(btn_xoaSach);
//
//        JButton btn_timKiem = new JButton("Tìm kiếm");
//        btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_timKiem.setBounds(794, 139, 96, 21);
//        panel.add(btn_timKiem);
//
//        JButton btn_lamMoi = new JButton("Làm mới");
//        btn_lamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_lamMoi.setBounds(685, 139, 96, 21);
//        panel.add(btn_lamMoi);
//
//        // Tạo JScrollPane và thêm JTable vào JScrollPane
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBounds(10, 229, 929, 175);
//        contentPane.add(scrollPane);
//
//        table = new JTable();
//        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tableModel = new DefaultTableModel(
//                new Object[][]{},
//                new String[]{
//                        "STT", "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Số trang", "Nhà sản xuất", "Năm xuất bản", "Giá sách", "Số lượng"
//                }
//        ) {
//            Class[] columnTypes = new Class[]{
//                    Integer.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class
//            };
//
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                return columnTypes[columnIndex];
//            }
//
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return true; // Allow all cells to be editable
//            }
//        };
//        table.setModel(tableModel);
//        scrollPane.setViewportView(table);
//
//        // Xử lý sự kiện các nút
//        btn_themSach.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String maSach = tf_maSach.getText();
//                String tenSach = tf_tenSach.getText();
//                String tacGia = tf_tacGia.getText();
//                String theLoai = tf_theLoai.getText();
//                int soTrang = Integer.parseInt(tf_soTrang.getText());
//                String nhaSX = tf_nhaSX.getText();
//                int namXB = Integer.parseInt(tf_namXB.getText());
//                int giaSach = Integer.parseInt(tf_giaSach.getText());
//                int soLuong = Integer.parseInt(tf_soLuong.getText());
//
//                Vector<Object> row = new Vector<>();
//                row.add(tableModel.getRowCount() + 1);
//                row.add(maSach);
//                row.add(tenSach);
//                row.add(tacGia);
//                row.add(theLoai);
//                row.add(soTrang);
//                row.add(nhaSX);
//                row.add(namXB);
//                row.add(giaSach);
//                row.add(soLuong);
//                tableModel.addRow(row);
//
//                // Làm mới lại các textfield
//                tf_maSach.setText("");
//                tf_tenSach.setText("");
//                tf_tacGia.setText("");
//                tf_theLoai.setText("");
//                tf_soTrang.setText("");
//                tf_nhaSX.setText("");
//                tf_namXB.setText("");
//                tf_giaSach.setText("");
//                tf_soLuong.setText("");
//            }
//        });
//
//        btn_suaThongTin.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                table.setEnabled(true);
//
//                JOptionPane.showMessageDialog(null, "Bây giờ bạn có thể chỉnh sửa dữ liệu trực tiếp trên bảng. Nhấn Enter để lưu thay đổi.");
//            }
//        });
//
//        btn_xoaSach.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String maSach = JOptionPane.showInputDialog("Nhập mã sách cần xóa:");
//                if (maSach != null) {
//                    for (int i = 0; i < tableModel.getRowCount(); i++) {
//                        if (tableModel.getValueAt(i, 1).equals(maSach)) {
//                            tableModel.removeRow(i);
//                            JOptionPane.showMessageDialog(null, "Đã xóa sách có mã: " + maSach);
//                            return;
//                        }
//                    }
//                    JOptionPane.showMessageDialog(null, "Không tìm thấy sách có mã: " + maSach);
//                }
//            }
//        });
//
//        btn_timKiem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String maSach = JOptionPane.showInputDialog("Nhập mã sách cần tìm:");
//                if (maSach != null) {
//                    for (int i = 0; i < tableModel.getRowCount(); i++) {
//                        if (tableModel.getValueAt(i, 1).equals(maSach)) {
//                            JOptionPane.showMessageDialog(null, "Sách có mã: " + maSach + " ở vị trí: " + (i + 1));
//                            return;
//                        }
//                    }
//                    JOptionPane.showMessageDialog(null, "Sách không tồn tại");
//                }
//            }
//        });
//
//        btn_lamMoi.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                Vector<Vector<Object>> dataVector = new Vector<>();
//                for (int i = 0; i < tableModel.getRowCount(); i++) {
//                    Vector<Object> row = new Vector<>();
//                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
//                        row.add(tableModel.getValueAt(i, j));
//                    }
//                    dataVector.add(row);
//                }
//                dataVector.sort(new Comparator<Vector<Object>>() {
//                    @Override
//                    public int compare(Vector<Object> v1, Vector<Object> v2) {
//                        return ((String) v1.get(2)).compareToIgnoreCase((String) v2.get(2));
//                    }
//                });
//
//                // Clear current table data
//                tableModel.setRowCount(0);
//
//                // Add sorted data back to the table model
//                for (Vector<Object> row : dataVector) {
//                    tableModel.addRow(row);
//                }
//
//                // Reset STT column
//                for (int i = 0; i < tableModel.getRowCount(); i++) {
//                    tableModel.setValueAt(i + 1, i, 0);
//                }
//
//                // Disable table editing
//                table.setEnabled(false);
//            }
//        });
//    }
//}

//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Comparator;
//import java.util.Vector;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class LibraryManagement extends JFrame {
//
//    private JPanel contentPane;
//    private JTextField tf_maSach;
//    private JTextField tf_tenSach;
//    private JTextField tf_tacGia;
//    private JTextField tf_theLoai;
//    private JTextField tf_soTrang;
//    private JTextField tf_nhaSX;
//    private JTextField tf_namXB;
//    private JTextField tf_giaSach;
//    private JTextField tf_soLuong;
//    private JTable table;
//    private DefaultTableModel tableModel;
//    private ExecutorService executorService = Executors.newCachedThreadPool();
//
//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            try {
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                LibraryManagement frame = new LibraryManagement();
//                frame.setVisible(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
//
//    /**
//     * Create the frame.
//     */
//    public LibraryManagement() {
//        setTitle("Quản lý Thư viện");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 970, 486);
//
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("Quản lý");
//        menu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//
//        JMenuItem libraryManagement_Item = new JMenuItem("Thư viện");
//        libraryManagement_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(libraryManagement_Item);
//
//        JMenuItem readerManagement_Item = new JMenuItem("Độc giả");
//        readerManagement_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(readerManagement_Item);
//
//        JMenuItem managerBorrowsBooks_Item = new JMenuItem("Mượn trả");
//        managerBorrowsBooks_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(managerBorrowsBooks_Item);
//
//        JMenuItem feedBack_Item = new JMenuItem("Phản hồi");
//        feedBack_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        menu.add(feedBack_Item);
//
//        // Xử lý sự kiện menuBar
//        libraryManagement_Item.addActionListener(e -> {
//            dispose();
//            new LibraryManagement().setVisible(true);
//        });
//
//        readerManagement_Item.addActionListener(e -> {
//            dispose();
//            new ReaderManagement().setVisible(true);
//        });
//
//        managerBorrowsBooks_Item.addActionListener(e -> {
//            dispose();
//            new ManagerBorrowsBooks().setVisible(true);
//        });
//
//        feedBack_Item.addActionListener(e -> {
//            dispose();
//            new Feedback().setVisible(true);
//        });
//
//        menuBar.add(menu);
//        setJMenuBar(menuBar);
//
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//        JPanel panel = new JPanel();
//        panel.setBounds(0, 0, 929, 197);
//        contentPane.add(panel);
//        panel.setLayout(null);
//
//        JLabel lb_maSach = new JLabel("Mã sách");
//        lb_maSach.setBounds(10, 10, 58, 16);
//        lb_maSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        panel.add(lb_maSach);
//
//        tf_maSach = new JTextField();
//        tf_maSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_maSach.setBounds(78, 10, 149, 19);
//        panel.add(tf_maSach);
//        tf_maSach.setColumns(10);
//
//        JLabel lb_tenSach = new JLabel("Tên sách");
//        lb_tenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_tenSach.setBounds(10, 49, 58, 13);
//        panel.add(lb_tenSach);
//
//        tf_tenSach = new JTextField();
//        tf_tenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_tenSach.setBounds(78, 48, 149, 19);
//        panel.add(tf_tenSach);
//        tf_tenSach.setColumns(10);
//
//        JLabel lb_tacGia = new JLabel("Tác giả");
//        lb_tacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_tacGia.setBounds(10, 88, 58, 13);
//        panel.add(lb_tacGia);
//
//        tf_tacGia = new JTextField();
//        tf_tacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_tacGia.setBounds(78, 87, 149, 19);
//        panel.add(tf_tacGia);
//        tf_tacGia.setColumns(10);
//
//        JLabel lb_theLoai = new JLabel("Thể loại");
//        lb_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_theLoai.setBounds(318, 10, 58, 17);
//        panel.add(lb_theLoai);
//
//        tf_theLoai = new JTextField();
//        tf_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_theLoai.setBounds(382, 11, 149, 19);
//        panel.add(tf_theLoai);
//        tf_theLoai.setColumns(10);
//
//        JLabel lb_soTrang = new JLabel("Số trang");
//        lb_soTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_soTrang.setBounds(318, 54, 58, 13);
//        panel.add(lb_soTrang);
//
//        tf_soTrang = new JTextField();
//        tf_soTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_soTrang.setBounds(382, 48, 149, 19);
//        panel.add(tf_soTrang);
//        tf_soTrang.setColumns(10);
//
//        JLabel lb_nhaSX = new JLabel("Nhà SX");
//        lb_nhaSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_nhaSX.setBounds(318, 90, 58, 13);
//        panel.add(lb_nhaSX);
//
//        tf_nhaSX = new JTextField();
//        tf_nhaSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_nhaSX.setBounds(382, 87, 149, 19);
//        panel.add(tf_nhaSX);
//        tf_nhaSX.setColumns(10);
//
//        JLabel lb_namXB = new JLabel("Năm xuất bản");
//        lb_namXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_namXB.setBounds(636, 14, 95, 13);
//        panel.add(lb_namXB);
//
//        tf_namXB = new JTextField();
//        tf_namXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_namXB.setBounds(741, 11, 149, 19);
//        panel.add(tf_namXB);
//        tf_namXB.setColumns(10);
//
//        JLabel lb_giaSach = new JLabel("Giá sách");
//        lb_giaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_giaSach.setBounds(636, 54, 58, 13);
//        panel.add(lb_giaSach);
//
//        tf_giaSach = new JTextField();
//        tf_giaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_giaSach.setBounds(741, 48, 149, 19);
//        panel.add(tf_giaSach);
//        tf_giaSach.setColumns(10);
//
//        JLabel lb_soLuong = new JLabel("Số lượng");
//        lb_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lb_soLuong.setBounds(636, 88, 58, 17);
//        panel.add(lb_soLuong);
//
//        tf_soLuong = new JTextField();
//        tf_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tf_soLuong.setBounds(741, 87, 149, 19);
//        panel.add(tf_soLuong);
//        tf_soLuong.setColumns(10);
//
//        JButton btn_themSach = new JButton("Thêm sách");
//        btn_themSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_themSach.setBounds(304, 139, 117, 21);
//        panel.add(btn_themSach);
//
//        JButton btn_suaThongTin = new JButton("Sửa thông tin");
//        btn_suaThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_suaThongTin.setBounds(431, 139, 130, 21);
//        panel.add(btn_suaThongTin);
//
//        JButton btn_xoaSach = new JButton("Xóa sách");
//        btn_xoaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_xoaSach.setBounds(571, 139, 107, 21);
//        panel.add(btn_xoaSach);
//
//        JButton btn_timKiem = new JButton("Tìm kiếm");
//        btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_timKiem.setBounds(794, 139, 96, 21);
//        panel.add(btn_timKiem);
//
//        JButton btn_lamMoi = new JButton("Làm mới");
//        btn_lamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        btn_lamMoi.setBounds(685, 139, 96, 21);
//        panel.add(btn_lamMoi);
//
//        // Tạo JScrollPane và thêm JTable vào JScrollPane
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBounds(10, 229, 929, 175);
//        contentPane.add(scrollPane);
//
//        table = new JTable();
//        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        tableModel = new DefaultTableModel(
//                new Object[][]{},
//                new String[]{
//                        "STT", "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Số trang", "Nhà sản xuất", "Năm xuất bản", "Giá sách", "Số lượng"
//                }
//        ) {
//            Class[] columnTypes = new Class[]{
//                    Integer.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class
//            };
//
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                return columnTypes[columnIndex];
//            }
//
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return true; // Allow all cells to be editable
//            }
//        };
//        table.setModel(tableModel);
//        scrollPane.setViewportView(table);
//
//        // Xử lý sự kiện các nút
//        btn_themSach.addActionListener(e -> {
//            String maSach = tf_maSach.getText();
//            String tenSach = tf_tenSach.getText();
//            String tacGia = tf_tacGia.getText();
//            String theLoai = tf_theLoai.getText();
//            int soTrang = Integer.parseInt(tf_soTrang.getText());
//            String nhaSX = tf_nhaSX.getText();
//            int namXB = Integer.parseInt(tf_namXB.getText());
//            int giaSach = Integer.parseInt(tf_giaSach.getText());
//            int soLuong = Integer.parseInt(tf_soLuong.getText());
//
//            Vector<Object> row = new Vector<>();
//            row.add(tableModel.getRowCount() + 1);
//            row.add(maSach);
//            row.add(tenSach);
//            row.add(tacGia);
//            row.add(theLoai);
//            row.add(soTrang);
//            row.add(nhaSX);
//            row.add(namXB);
//            row.add(giaSach);
//            row.add(soLuong);
//            tableModel.addRow(row);
//
//            // Làm mới lại các textfield
//            tf_maSach.setText("");
//            tf_tenSach.setText("");
//            tf_tacGia.setText("");
//            tf_theLoai.setText("");
//            tf_soTrang.setText("");
//            tf_nhaSX.setText("");
//            tf_namXB.setText("");
//            tf_giaSach.setText("");
//            tf_soLuong.setText("");
//        });
//
//        btn_suaThongTin.addActionListener(e -> {
//            table.setEnabled(true);
//            JOptionPane.showMessageDialog(null, "Bây giờ bạn có thể chỉnh sửa dữ liệu trực tiếp trên bảng. Nhấn Enter để lưu thay đổi.");
//        });
//
//        btn_xoaSach.addActionListener(e -> {
//            executorService.execute(() -> {
//                String maSach = JOptionPane.showInputDialog("Nhập mã sách cần xóa:");
//                if (maSach != null) {
//                    for (int i = 0; i < tableModel.getRowCount(); i++) {
//                        if (tableModel.getValueAt(i, 1).equals(maSach)) {
//                            tableModel.removeRow(i);
//                            JOptionPane.showMessageDialog(null, "Đã xóa sách có mã: " + maSach);
//                            return;
//                        }
//                    }
//                    JOptionPane.showMessageDialog(null, "Không tìm thấy sách có mã: " + maSach);
//                }
//            });
//        });
//
//        btn_timKiem.addActionListener(e -> {
//            executorService.execute(() -> {
//                String maSach = JOptionPane.showInputDialog("Nhập mã sách cần tìm:");
//                if (maSach != null) {
//                    for (int i = 0; i < tableModel.getRowCount(); i++) {
//                        if (tableModel.getValueAt(i, 1).equals(maSach)) {
//                            JOptionPane.showMessageDialog(null, "Sách có mã: " + maSach + " ở vị trí: " + (i + 1));
//                            return;
//                        }
//                    }
//                    JOptionPane.showMessageDialog(null, "Sách không tồn tại");
//                }
//            });
//        });
//
//        btn_lamMoi.addActionListener(e -> executorService.execute(() -> {
//            Vector<Vector<Object>> dataVector = new Vector<>();
//            for (int i = 0; i < tableModel.getRowCount(); i++) {
//                Vector<Object> row = new Vector<>();
//                for (int j = 0; j < tableModel.getColumnCount(); j++) {
//                    row.add(tableModel.getValueAt(i, j));
//                }
//                dataVector.add(row);
//            }
//            dataVector.sort(Comparator.comparing(v -> (String) v.get(2)));
//
//            // Clear current table data
//            tableModel.setRowCount(0);
//
//            // Add sorted data back to the table model
//            for (Vector<Object> row : dataVector) {
//                tableModel.addRow(row);
//            }
//
//            // Reset STT column
//            for (int i = 0; i < tableModel.getRowCount(); i++) {
//                tableModel.setValueAt(i + 1, i, 0);
//            }
//
//            // Disable table editing
//            table.setEnabled(false);
//        }));
//    }
//}


import DAO.BookDAO;
import DAO.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LibraryManagement extends JFrame {

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
	private ExecutorService executorService = Executors.newCachedThreadPool();
	private BookDAO bookDAO = new BookDAO();

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				LibraryManagement frame = new LibraryManagement();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public LibraryManagement() {
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

        JMenuItem feedBack_Item = new JMenuItem("Phản hồi");
        feedBack_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menu.add(feedBack_Item);

        libraryManagement_Item.addActionListener(e -> {
            dispose();
            new LibraryManagement().setVisible(true);
        });

        readerManagement_Item.addActionListener(e -> {
            dispose();
            new ReaderManagement().setVisible(true);
        });

        managerBorrowsBooks_Item.addActionListener(e -> {
            dispose();
            new ManagerBorrowsBooks().setVisible(true);
        });

        feedBack_Item.addActionListener(e -> {
            dispose();
            new Feedback().setVisible(true);
        });

        menuBar.add(menu);
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
        lb_theLoai.setBounds(10, 127, 58, 13);
        panel.add(lb_theLoai);

        tf_theLoai = new JTextField();
        tf_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_theLoai.setBounds(78, 126, 149, 19);
        panel.add(tf_theLoai);
        tf_theLoai.setColumns(10);

        JLabel lb_soTrang = new JLabel("Số trang");
        lb_soTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_soTrang.setBounds(10, 166, 58, 13);
        panel.add(lb_soTrang);

        tf_soTrang = new JTextField();
        tf_soTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_soTrang.setBounds(78, 165, 149, 19);
        panel.add(tf_soTrang);
        tf_soTrang.setColumns(10);

        JLabel lb_nhaSX = new JLabel("Nhà sản xuất");
        lb_nhaSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_nhaSX.setBounds(277, 10, 85, 13);
        panel.add(lb_nhaSX);

        tf_nhaSX = new JTextField();
        tf_nhaSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_nhaSX.setBounds(372, 9, 149, 19);
        panel.add(tf_nhaSX);
        tf_nhaSX.setColumns(10);

        JLabel lb_namXB = new JLabel("Năm xuất bản");
        lb_namXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_namXB.setBounds(277, 49, 96, 13);
        panel.add(lb_namXB);

        tf_namXB = new JTextField();
        tf_namXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_namXB.setBounds(372, 48, 149, 19);
        panel.add(tf_namXB);
        tf_namXB.setColumns(10);

        JLabel lb_giaSach = new JLabel("Giá sách");
        lb_giaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_giaSach.setBounds(277, 88, 58, 13);
        panel.add(lb_giaSach);

        tf_giaSach = new JTextField();
        tf_giaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_giaSach.setBounds(372, 87, 149, 19);
        panel.add(tf_giaSach);
        tf_giaSach.setColumns(10);

        JLabel lb_soLuong = new JLabel("Số lượng");
        lb_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_soLuong.setBounds(277, 127, 58, 13);
        panel.add(lb_soLuong);

        tf_soLuong = new JTextField();
        tf_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_soLuong.setBounds(372, 126, 149, 19);
        panel.add(tf_soLuong);
        tf_soLuong.setColumns(10);

        JButton btn_themSach = new JButton("Thêm sách");
        btn_themSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_themSach.setBounds(571, 10, 107, 21);
        panel.add(btn_themSach);

        JButton btn_suaThongTin = new JButton("Sửa thông tin");
        btn_suaThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_suaThongTin.setBounds(571, 49, 107, 21);
        panel.add(btn_suaThongTin);

        JButton btn_xoaSach = new JButton("Xóa sách");
        btn_xoaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_xoaSach.setBounds(571, 88, 107, 21);
        panel.add(btn_xoaSach);

        JButton btn_timKiem = new JButton("Tìm kiếm");
        btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_timKiem.setBounds(794, 139, 96, 21);
        panel.add(btn_timKiem);

        JButton btn_lamMoi = new JButton("Làm mới");
        btn_lamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_lamMoi.setBounds(685, 139, 96, 21);
        panel.add(btn_lamMoi);

        // Tạo JScrollPane và thêm JTable vào JScrollPane
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
                return true; // Allow all cells to be editable
            }
        };
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        // Xử lý sự kiện các nút
        btn_themSach.addActionListener(e -> {
            String maSach = tf_maSach.getText();
            String tenSach = tf_tenSach.getText();
            String tacGia = tf_tacGia.getText();
            String theLoai = tf_theLoai.getText();
            int soTrang = Integer.parseInt(tf_soTrang.getText());
            String nhaSX = tf_nhaSX.getText();
            int namXB = Integer.parseInt(tf_namXB.getText());
            int giaSach = Integer.parseInt(tf_giaSach.getText());
            int soLuong = Integer.parseInt(tf_soLuong.getText());

            // Thêm vào table
            Vector<Object> row = new Vector<>();
            row.add(tableModel.getRowCount() + 1);
            row.add(maSach);
            row.add(tenSach);
            row.add(tacGia);
            row.add(theLoai);
            row.add(soTrang);
            row.add(nhaSX);
            row.add(namXB);
            row.add(giaSach);
            row.add(soLuong);
            tableModel.addRow(row);

            // Thêm vào cơ sở dữ liệu
            bookDAO.addBook(maSach, tenSach, tacGia, theLoai, soTrang, nhaSX, namXB, giaSach, soLuong);

            // Làm mới lại các textfield
            clearTextFields();
        });

        btn_suaThongTin.addActionListener(e -> {
            // Hiện thông báo cho phép chỉnh sửa
            JOptionPane.showMessageDialog(null, "Bây giờ bạn có thể chỉnh sửa dữ liệu trực tiếp trên bảng. Nhấn Enter để lưu thay đổi.");
        });

        btn_xoaSach.addActionListener(e -> {
            executorService.execute(() -> {
                String maSach = JOptionPane.showInputDialog("Nhập mã sách cần xóa:");
                if (maSach != null) {
                    // Xóa trên table
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        if (tableModel.getValueAt(i, 1).equals(maSach)) {
                            tableModel.removeRow(i);
                            JOptionPane.showMessageDialog(null, "Đã xóa sách có mã: " + maSach);

                            // Xóa trong cơ sở dữ liệu
                            bookDAO.deleteBook(maSach);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Không tìm thấy sách có mã: " + maSach);
                }
            });
        });

        btn_timKiem.addActionListener(e -> {
            executorService.execute(() -> {
                String maSach = JOptionPane.showInputDialog("Nhập mã sách cần tìm:");
                if (maSach != null) {
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        if (tableModel.getValueAt(i, 1).equals(maSach)) {
                            JOptionPane.showMessageDialog(null, "Sách có mã: " + maSach + " ở vị trí: " + (i + 1));
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Sách không tồn tại");
                }
            });
        });

        btn_lamMoi.addActionListener(e -> executorService.execute(() -> {
            // Làm mới lại table từ cơ sở dữ liệu
            refreshTableFromDatabase();
        }));
    }

	// Refresh table data from database
	private void refreshTableFromDatabase() {
		// Clear current table data
		tableModel.setRowCount(0);

		// Retrieve all books from the database
		List<Book> books = bookDAO.getAllBooks();

		// Populate table with retrieved data
		for (Book book : books) {
			Vector<Object> row = new Vector<>();
			row.add(tableModel.getRowCount() + 1);
			row.add(book.getMaSach());
			row.add(book.getTenSach());
			row.add(book.getTacGia());
			row.add(book.getTheLoai());
			row.add(book.getSoTrang());
			row.add(book.getNhaSX());
			row.add(book.getNamXB());
			row.add(book.getGiaSach());
			row.add(book.getSoLuong());
			tableModel.addRow(row);
		}
	}

	// Clear all text fields
	private void clearTextFields() {
		tf_maSach.setText("");
		tf_tenSach.setText("");
		tf_tacGia.setText("");
		tf_theLoai.setText("");
		tf_soTrang.setText("");
		tf_nhaSX.setText("");
		tf_namXB.setText("");
		tf_giaSach.setText("");
		tf_soLuong.setText("");
	}
}
