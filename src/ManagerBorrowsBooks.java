import java.awt.EventQueue;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ManagerBorrowsBooks extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tf_maDocGia;
    private JTextField tf_maSach;
    private JTextField tf_soLuong;
    private JTextField tf_ngayMuon;
    private JTextField tf_ngayHenTra;
    private JTable table;
    private DefaultTableModel tableModel;
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private boolean isEditable = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                ManagerBorrowsBooks frame = new ManagerBorrowsBooks();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public ManagerBorrowsBooks() {
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

        libraryManagement_Item.addActionListener(e -> {
            dispose();
            new LibraryManagement().setVisible(true);
        });

        readerManagement_Item.addActionListener(e -> {
            dispose();
            new ReaderManagement().setVisible(true);
        });

        managerBorrowsBooks_Item.addActionListener(e -> {
            // Currently on this screen
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

        JButton bt_muonSach = new JButton("Mượn sách");
        bt_muonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_muonSach.setBounds(89, 113, 101, 21);
        panel.add(bt_muonSach);

        JButton bt_timKiem = new JButton("Tìm kiếm");
        bt_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_timKiem.setBounds(776, 115, 92, 21);
        panel.add(bt_timKiem);

        JButton bt_suaThongTin = new JButton("Sửa thông tin");
        bt_suaThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_suaThongTin.setBounds(254, 115, 119, 21);
        panel.add(bt_suaThongTin);

        JButton bt_traSach = new JButton("Trả sách");
        bt_traSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_traSach.setBounds(453, 115, 92, 21);
        panel.add(bt_traSach);

        JButton bt_xoa = new JButton("Xóa");
        bt_xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_xoa.setBounds(616, 115, 85, 21);
        panel.add(bt_xoa);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 195, 936, 218);
        contentPane.add(scrollPane);

        table = new JTable();
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
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return isEditable;
            }
        };
        table.setModel(tableModel);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        scrollPane.setViewportView(table);

        bt_muonSach.addActionListener(e -> {
            executorService.execute(() -> {
                String maDocGia = tf_maDocGia.getText();
                String maSach = tf_maSach.getText();
                int soLuong = Integer.parseInt(tf_soLuong.getText());
                String ngayMuon = tf_ngayMuon.getText();
                String ngayHenTra = tf_ngayHenTra.getText();

                // Add row to the table
                Object[] row = {
                        tableModel.getRowCount() + 1, maDocGia, maSach, soLuong, ngayMuon, ngayHenTra, "", "Đang mượn"
                };
                tableModel.addRow(row);

                // Clear text fields
                tf_maDocGia.setText("");
                tf_maSach.setText("");
                tf_soLuong.setText("");
                tf_ngayMuon.setText("");
                tf_ngayHenTra.setText("");
            });
        });

        bt_suaThongTin.addActionListener(e -> {
            isEditable = true;
            JOptionPane.showMessageDialog(null, "Bây giờ bạn có thể chỉnh sửa dữ liệu trực tiếp trên bảng. Nhấn Enter để lưu thay đổi.");
        });

        table.getModel().addTableModelListener(e -> {
            if (isEditable) {
                isEditable = false;
                JOptionPane.showMessageDialog(null, "Thông tin đã được cập nhật. Bảng sẽ bị khóa lại.");
            }
        });

        bt_xoa.addActionListener(e -> {
            executorService.execute(() -> {
                String maDocGia = JOptionPane.showInputDialog("Nhập mã độc giả cần xóa:");
                if (maDocGia != null) {
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        if (tableModel.getValueAt(i, 1).equals(maDocGia)) {
                            tableModel.removeRow(i);
                            JOptionPane.showMessageDialog(null, "Đã xóa độc giả có mã: " + maDocGia);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Không tìm thấy độc giả có mã: " + maDocGia);
                }
            });
        });

        bt_timKiem.addActionListener(e -> {
            executorService.execute(() -> {
                String maDocGia = JOptionPane.showInputDialog("Nhập mã độc giả cần tìm:");
                if (maDocGia != null) {
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        if (tableModel.getValueAt(i, 1).equals(maDocGia)) {
                            JOptionPane.showMessageDialog(null, "Độc giả có mã: " + maDocGia + " ở vị trí: " + (i + 1));
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Độc giả không tồn tại");
                }
            });
        });

        bt_traSach.addActionListener(e -> {
            executorService.execute(() -> {
                String maDocGia = JOptionPane.showInputDialog("Nhập mã độc giả trả sách:");
                if (maDocGia != null) {
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        if (tableModel.getValueAt(i, 1).equals(maDocGia)) {
                            LocalDate currentDate = LocalDate.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            String formattedDate = currentDate.format(formatter);
                            tableModel.setValueAt(formattedDate, i, 6);
                            tableModel.setValueAt("Đã trả", i, 7);
                            JOptionPane.showMessageDialog(null, "Đã cập nhật trạng thái trả sách cho độc giả có mã: " + maDocGia);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Không tìm thấy độc giả có mã: " + maDocGia);
                }
            });
        });
    }
}