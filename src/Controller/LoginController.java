package Controller;

import Model.LoginModel;
import View.LoginView;
import View.RegisterView;
import View.LibraryManagementView;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController {

    private LoginModel model;
    private LoginView view;

    public LoginController(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;
        this.view.getBtn_dangNhap().addActionListener(new LoginListener());
        this.view.getBtn_dangKy().addActionListener(new RegisterListener());
        this.view.getBtn_thoat().addActionListener(e -> System.exit(0));
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Thread(() -> {
                String username = view.getTf_taiKhoan().getText();
                String password = new String(view.getPf_matKhau().getPassword());

                if (model.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(null, "Chúc mừng bạn đã đăng nhập thành công!");
                    EventQueue.invokeLater(() -> {
                        new LibraryManagementView().setVisible(true);
                        view.dispose();
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu");
                }
            }).start();
        }
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EventQueue.invokeLater(() -> {
                new RegisterView().setVisible(true);
                view.dispose();
            });
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginModel model = new LoginModel();
                LoginView view = new LoginView();
                LoginController controller = new LoginController(model, view);
                view.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
