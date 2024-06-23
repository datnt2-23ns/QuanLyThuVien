import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;

public class Feedback extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tf_maDocGia;
    private JTextField tf_tenDocGia;
    private JTextArea ta_noiDung;
    private JTextArea ta_feedbackList;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Feedback frame = new Feedback();
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
    public Feedback() {
        setTitle("Phản hồi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 970, 600);

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
        panel.setBounds(10, 0, 936, 560);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lb_maDocGia = new JLabel("Mã Độc Giả");
        lb_maDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_maDocGia.setBounds(10, 10, 80, 16);
        panel.add(lb_maDocGia);

        tf_maDocGia = new JTextField();
        tf_maDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_maDocGia.setBounds(100, 10, 149, 19);
        panel.add(tf_maDocGia);
        tf_maDocGia.setColumns(10);

        JLabel lb_tenDocGia = new JLabel("Tên Độc Giả");
        lb_tenDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_tenDocGia.setBounds(10, 49, 80, 16);
        panel.add(lb_tenDocGia);

        tf_tenDocGia = new JTextField();
        tf_tenDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_tenDocGia.setBounds(100, 48, 149, 19);
        panel.add(tf_tenDocGia);
        tf_tenDocGia.setColumns(10);

        JLabel lb_noiDung = new JLabel("Nội dung");
        lb_noiDung.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_noiDung.setBounds(10, 88, 58, 16);
        panel.add(lb_noiDung);

        ta_noiDung = new JTextArea();
        ta_noiDung.setFont(new Font("Tahoma", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(ta_noiDung);
        scrollPane.setBounds(100, 87, 300, 150);
        panel.add(scrollPane);

        JButton btn_gui = new JButton("Gửi");
        btn_gui.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_gui.setBounds(209, 254, 85, 21);
        panel.add(btn_gui);

        // Add text area for feedback list
        ta_feedbackList = new JTextArea();
        ta_feedbackList.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ta_feedbackList.setEditable(false);
        JScrollPane feedbackScrollPane = new JScrollPane(ta_feedbackList);
        feedbackScrollPane.setBounds(450, 10, 450, 400);
        panel.add(feedbackScrollPane);

        btn_gui.addActionListener(e -> sendFeedback());
    }

    private void sendFeedback() {
        String maDocGia = tf_maDocGia.getText();
        String tenDocGia = tf_tenDocGia.getText();
        String noiDung = ta_noiDung.getText();

        // Update to use a thread to avoid blocking the GUI
        new Thread(() -> {
            String response = FeedbackClient.sendFeedback(maDocGia, tenDocGia, noiDung);
            
            // Display both maDocGia and noiDung in the feedback list
            ta_feedbackList.append(maDocGia + ": " + noiDung + "\n");
        }).start();
    }
}