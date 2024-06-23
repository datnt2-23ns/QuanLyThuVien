import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.util.Comparator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReaderManagement extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tf_maDocGia;
    private JTextField tf_hoTen;
    private JTextField tf_soDT;
    private JTextField tf_email;
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
                ReaderManagement frame = new ReaderManagement();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public ReaderManagement() {
        setTitle("Quản lý Độc giả");
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
            // Hiện tại đang ở giao diện "Quản lý Độc giả"
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
        panel.setBounds(0, 0, 956, 173);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lb_maDocGia = new JLabel("Mã độc giả");
        lb_maDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_maDocGia.setBounds(10, 10, 69, 13);
        panel.add(lb_maDocGia);

        tf_maDocGia = new JTextField();
        tf_maDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_maDocGia.setBounds(90, 9, 149, 19);
        panel.add(tf_maDocGia);
        tf_maDocGia.setColumns(10);

        JLabel lb_hoTen = new JLabel("Họ và tên");
        lb_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_hoTen.setBounds(10, 58, 69, 13);
        panel.add(lb_hoTen);

        tf_hoTen = new JTextField();
        tf_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_hoTen.setBounds(90, 57, 149, 19);
        panel.add(tf_hoTen);
        tf_hoTen.setColumns(10);

        JLabel lb_soDT = new JLabel("Số ĐT");
        lb_soDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_soDT.setBounds(10, 107, 45, 13);
        panel.add(lb_soDT);

        tf_soDT = new JTextField();
        tf_soDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_soDT.setBounds(90, 106, 149, 19);
        panel.add(tf_soDT);
        tf_soDT.setColumns(10);

        JLabel lb_email = new JLabel("Email");
        lb_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_email.setBounds(328, 10, 45, 13);
        panel.add(lb_email);

        tf_email = new JTextField();
        tf_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_email.setBounds(394, 9, 149, 19);
        panel.add(tf_email);
        tf_email.setColumns(10);

        JLabel lb_gioiTinh = new JLabel("Giới tính");
        lb_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_gioiTinh.setBounds(328, 58, 53, 13);
        panel.add(lb_gioiTinh);

        JRadioButton rdBtn_nam = new JRadioButton("Nam");
        rdBtn_nam.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdBtn_nam.setBounds(394, 54, 62, 21);
        panel.add(rdBtn_nam);

        JRadioButton rdBtn_nu = new JRadioButton("Nữ");
        rdBtn_nu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdBtn_nu.setBounds(486, 54, 53, 21);
        panel.add(rdBtn_nu);

        JButton bt_them = new JButton("Thêm độc giả");
        bt_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_them.setBounds(89, 142, 125, 21);
        panel.add(bt_them);

        JButton bt_xoa = new JButton("Xóa độc giả");
        bt_xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_xoa.setBounds(249, 142, 114, 21);
        panel.add(bt_xoa);

        JButton bt_sua = new JButton("Sửa thông tin");
        bt_sua.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_sua.setBounds(420, 142, 125, 21);
        panel.add(bt_sua);

        JButton bt_timKiem = new JButton("Tìm kiếm");
        bt_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_timKiem.setBounds(608, 142, 100, 21);
        panel.add(bt_timKiem);

        JButton bt_lamMoi = new JButton("Làm mới");
        bt_lamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bt_lamMoi.setBounds(770, 142, 105, 21);
        panel.add(bt_lamMoi);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 201, 936, 212);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "STT", "Mã độc giả", "Họ và tên", "Số ĐT", "Email", "Giới tính"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    Integer.class, String.class, String.class, String.class, String.class, String.class
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
        bt_them.addActionListener(e -> {
            String maDocGia = tf_maDocGia.getText();
            String hoTen = tf_hoTen.getText();
            String soDT = tf_soDT.getText();
            String email = tf_email.getText();
            String gioiTinh = rdBtn_nam.isSelected() ? "Nam" : "Nữ";

            Vector<Object> row = new Vector<>();
            row.add(tableModel.getRowCount() + 1);
            row.add(maDocGia);
            row.add(hoTen);
            row.add(soDT);
            row.add(email);
            row.add(gioiTinh);
            tableModel.addRow(row);

            // Làm mới lại các textfield
            tf_maDocGia.setText("");
            tf_hoTen.setText("");
            tf_soDT.setText("");
            tf_email.setText("");
            rdBtn_nam.setSelected(false);
            rdBtn_nu.setSelected(false);
        });

        bt_sua.addActionListener(e -> {
            table.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Bây giờ bạn có thể chỉnh sửa dữ liệu trực tiếp trên bảng. Nhấn Enter để lưu thay đổi.");
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

        bt_lamMoi.addActionListener(e -> executorService.execute(() -> {
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