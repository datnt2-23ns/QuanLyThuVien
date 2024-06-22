import java.awt.EventQueue;
import java.awt.Font;
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

public class ManagerBorrowsBooks extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tf_maDocGia;
    private JTextField tf_maSach;
    private JTextField tf_soLuong;
    private JTextField tf_ngayMuon;
    private JTextField tf_ngayHenTra;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    ManagerBorrowsBooks frame = new ManagerBorrowsBooks();
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
        
        // Xử lý sự kiện menuBar
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
        	// Chuyển sang giao diện "Quản lý Độc giả"
        	dispose(); // Đóng cửa số hiện tại
        	new ReaderManagement().setVisible(true); // Mở cửa sổ "Quản lý Độc giả"
        });
        
        managerBorrowsBooks_Item.addActionListener(e -> {
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
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"STT", "M\u00E3 \u0111\u1ED9c gi\u1EA3", "M\u00E3 s\u00E1ch", "Ng\u00E0y m\u01B0\u1EE3n", "Ng\u00E0y h\u1EB9n tr\u1EA3", "Ng\u00E0y tr\u1EA3", "Tr\u1EA1ng th\u00E1i"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		Integer.class, String.class, String.class, String.class, String.class, String.class, String.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        scrollPane.setViewportView(table);
    }
}
