import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
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

    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     */
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

        // Xử lý sự kiện menuBar
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
        
        feedBackAdmin_Item.addActionListener(e -> {
        	dispose();
        	new Feedback_Admin().setVisible(true);
        });
        
        login_Item.addActionListener(e -> {
        	dispose();
        	new Login().setVisible(true);
        });
        
        exit_Item.addActionListener(e -> System.exit(0));

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

            // Làm mới lại các textfield
            tf_maSach.setText("");
            tf_tenSach.setText("");
            tf_tacGia.setText("");
            tf_theLoai.setText("");
            tf_soTrang.setText("");
            tf_nhaSX.setText("");
            tf_namXB.setText("");
            tf_giaSach.setText("");
            tf_soLuong.setText("");
        });

        btn_suaThongTin.addActionListener(e -> {
            table.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Bây giờ bạn có thể chỉnh sửa dữ liệu trực tiếp trên bảng. Nhấn Enter để lưu thay đổi.");
        });

        btn_xoaSach.addActionListener(e -> {
            executorService.execute(() -> {
                String maSach = JOptionPane.showInputDialog("Nhập mã sách cần xóa:");
                if (maSach != null) {
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        if (tableModel.getValueAt(i, 1).equals(maSach)) {
                            tableModel.removeRow(i);
                            JOptionPane.showMessageDialog(null, "Đã xóa sách có mã: " + maSach);
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
            Vector<Vector<Object>> dataVector = new Vector<>();
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                Vector<Object> row = new Vector<>();
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    row.add(tableModel.getValueAt(i, j));
                }
                dataVector.add(row);
            }
            dataVector.sort(Comparator.comparing(v -> (String) v.get(2)));

            // Clear current table data
            tableModel.setRowCount(0);

            // Add sorted data back to the table model
            for (Vector<Object> row : dataVector) {
                tableModel.addRow(row);
            }

            // Reset STT column
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                tableModel.setValueAt(i + 1, i, 0);
            }

            // Disable table editing
            table.setEnabled(false);
        }));
    }
}