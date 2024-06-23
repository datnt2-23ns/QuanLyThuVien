package Controller;

import Model.RegisterModel;
import View.RegisterView;
import View.LoginView;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RegisterController {

    private RegisterModel model;
    private RegisterView view;

    public RegisterController(RegisterModel model, RegisterView view) {
        this.model = model;
        this.view = view;
        this.view.getBtn_dangKy().addActionListener(new RegisterListener());
        this.view.getBtn_dangNhap().addActionListener(new LoginListener());
        this.view.getBtn_thoat().addActionListener(e -> System.exit(0));
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Thread(() -> {
                String username = view.getTf_taiKhoan().getText();
                String password = new String(view.getPf_matKhau().getPassword());
                model.register(username, password);
                JOptionPane.showMessageDialog(null, "Chúc mừng bạn đã đăng ký thành công!");
            }).start();
        }
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EventQueue.invokeLater(() -> {
                new LoginView().setVisible(true);
                view.dispose();
            });
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RegisterModel model = new RegisterModel();
                RegisterView view = new RegisterView();
                RegisterController controller = new RegisterController(model, view);
                view.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
