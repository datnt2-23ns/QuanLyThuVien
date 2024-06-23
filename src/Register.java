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
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tf_taiKhoan;
    private JPasswordField pf_matKhau;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Register frame = new Register();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Register() {
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

        JLabel lb_dangKy = new JLabel("Đăng ký");
        lb_dangKy.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb_dangKy.setBounds(194, 10, 68, 36);
        panel.add(lb_dangKy);

        JLabel lb_taiKhoan = new JLabel("Tài khoản");
        lb_taiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_taiKhoan.setBounds(10, 68, 68, 13);
        panel.add(lb_taiKhoan);

        tf_taiKhoan = new JTextField();
        tf_taiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tf_taiKhoan.setBounds(88, 67, 309, 19);
        panel.add(tf_taiKhoan);
        tf_taiKhoan.setColumns(10);

        JLabel lb_matKhau = new JLabel("Mật khẩu");
        lb_matKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lb_matKhau.setBounds(10, 133, 68, 19);
        panel.add(lb_matKhau);

        pf_matKhau = new JPasswordField();
        pf_matKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pf_matKhau.setBounds(88, 135, 309, 19);
        panel.add(pf_matKhau);

        JButton btn_dangKy = new JButton("Đăng ký");
        btn_dangKy.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_dangKy.setBounds(33, 206, 103, 21);
        panel.add(btn_dangKy);

        JButton btn_dangNhap = new JButton("Đăng nhập");
        btn_dangNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_dangNhap.setBounds(162, 206, 113, 21);
        panel.add(btn_dangNhap);

        JButton btn_thoat = new JButton("Thoát");
        btn_thoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_thoat.setBounds(312, 208, 85, 21);
        panel.add(btn_thoat);

        btn_dangKy.addActionListener(e -> new Thread(() -> {
            String username = tf_taiKhoan.getText();
            String password = new String(pf_matKhau.getPassword());
            String encryptedPassword = encryptPassword(password);

            // For demonstration purposes, we consider registration successful
            // In real applications, you would save the user credentials to a database
            JOptionPane.showMessageDialog(null, "Chúc mừng bạn đã đăng ký thành công!");
        }).start());

        btn_dangNhap.addActionListener(e -> EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
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