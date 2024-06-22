import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Test extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tf_maDocGia;
    private JTextField tf_hoTen;
    private JTextField tf_soDT;
    private JTextField tf_email;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Test frame = new Test();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Test() {
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

        JMenuItem feedBack_Item = new JMenuItem("Phản hồi");
        feedBack_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menu.add(feedBack_Item);
        
        // Xử lý sự kiện menuBar
        libraryManagement_Item.addActionListener(e -> {
        	// Chuyển sang giao diện "Quản lý Thư viện"
        	dispose(); // Đóng cửa số hiện tại
        	new LibraryManagement().setVisible(true); // Mở cửa sổ "Quản lý Thư viện"
        });
        
        readerManagement_Item.addActionListener(e -> {

        });
        
        managerBorrowsBooks_Item.addActionListener(e -> {
        	// Chuyển sang giao diện "Quản lý Mượn trả"
        	dispose(); // Đóng cửa sổ hiện tại
        	new ManagerBorrowsBooks().setVisible(true); // Mở cửa sổ "Quản lý Mượn trả"
        });
        
        feedBack_Item.addActionListener(e -> {
        	// Chuyển sang giao diện "Phản hồi"
        	dispose(); // Đóng cửa sổ hiện tại
        	new Feedback().setVisible(true); // Mở cửa sổ "Phản hồi"
        	
        });

        menuBar.add(menu);
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
        tf_soDT.setBounds(90, 106, 149, 19);
        panel.add(tf_soDT);
        tf_soDT.setColumns(10);

        JLabel lb_email = new JLabel("Email");
        lb_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_email.setBounds(328, 10, 45, 13);
        panel.add(lb_email);

        tf_email = new JTextField();
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
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null, null},
            },
            new String[] {
                "STT", "Mã độc giả", "Họ và tên", "Số ĐT", "Email", "Giới tính"
            }
        ) {
            Class[] columnTypes = new Class[] {
                String.class, Integer.class, String.class, Integer.class, String.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(36);
        table.getColumnModel().getColumn(2).setPreferredWidth(124);
        table.getColumnModel().getColumn(3).setPreferredWidth(93);
        table.getColumnModel().getColumn(4).setPreferredWidth(115);
        scrollPane.setViewportView(table);
    }
}
