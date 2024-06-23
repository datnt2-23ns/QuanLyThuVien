import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tf_taiKhoan;
    private JPasswordField pf_matKhau;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 436, 263);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lb_dangNhap = new JLabel("Đăng nhập");
        lb_dangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb_dangNhap.setBounds(174, 27, 78, 27);
        panel.add(lb_dangNhap);

        JLabel lb_taiKhoan = new JLabel("Tài khoản");
        lb_taiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_taiKhoan.setBounds(26, 82, 62, 17);
        panel.add(lb_taiKhoan);

        tf_taiKhoan = new JTextField();
        tf_taiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_taiKhoan.setBounds(119, 83, 269, 19);
        panel.add(tf_taiKhoan);
        tf_taiKhoan.setColumns(10);

        JLabel lb_matKhau = new JLabel("Mật khẩu");
        lb_matKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_matKhau.setBounds(26, 145, 62, 17);
        panel.add(lb_matKhau);

        pf_matKhau = new JPasswordField();
        pf_matKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pf_matKhau.setBounds(119, 146, 269, 19);
        panel.add(pf_matKhau);

        JButton btn_dangNhap = new JButton("Đăng nhập");
        btn_dangNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_dangNhap.setBounds(29, 212, 116, 21);
        panel.add(btn_dangNhap);

        JButton btn_dangKy = new JButton("Đăng ký");
        btn_dangKy.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_dangKy.setBounds(174, 212, 97, 21);
        panel.add(btn_dangKy);

        JButton btn_thoat = new JButton("Thoát");
        btn_thoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_thoat.setBounds(303, 214, 85, 21);
        panel.add(btn_thoat);

        btn_dangNhap.addActionListener(e -> new Thread(() -> {
            String username = tf_taiKhoan.getText();
            String password = new String(pf_matKhau.getPassword());
            String encryptedPassword = encryptPassword(password);

            if (username.equals("admin") && encryptedPassword.equals(encryptPassword("admin"))) {
                JOptionPane.showMessageDialog(null, "Chúc mừng bạn đã đăng nhập thành công!");
                EventQueue.invokeLater(() -> {
                    new LibraryManagement().setVisible(true);
                    dispose();
                });
            } else {
                JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu");
            }
        }).start());

        btn_dangKy.addActionListener(e -> EventQueue.invokeLater(() -> {
            new Register().setVisible(true);
            dispose();
        }));

        btn_thoat.addActionListener(e -> System.exit(0));
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(Integer.toHexString(0xff & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}