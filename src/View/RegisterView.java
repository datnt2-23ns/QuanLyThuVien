package View;

import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RegisterView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tf_taiKhoan;
    private JPasswordField pf_matKhau;
    private JButton btn_dangKy;
    private JButton btn_dangNhap;
    private JButton btn_thoat;

    public RegisterView() {
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

        btn_dangKy = new JButton("Đăng ký");
        btn_dangKy.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_dangKy.setBounds(33, 206, 103, 21);
        panel.add(btn_dangKy);

        btn_dangNhap = new JButton("Đăng nhập");
        btn_dangNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_dangNhap.setBounds(162, 206, 113, 21);
        panel.add(btn_dangNhap);

        btn_thoat = new JButton("Thoát");
        btn_thoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_thoat.setBounds(312, 208, 85, 21);
        panel.add(btn_thoat);
    }

    public JTextField getTf_taiKhoan() {
        return tf_taiKhoan;
    }

    public JPasswordField getPf_matKhau() {
        return pf_matKhau;
    }

    public JButton getBtn_dangKy() {
        return btn_dangKy;
    }

    public JButton getBtn_dangNhap() {
        return btn_dangNhap;
    }

    public JButton getBtn_thoat() {
        return btn_thoat;
    }
}
