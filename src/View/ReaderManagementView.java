package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ReaderManagementView extends JFrame {
	private JPanel contentPane;
	private JTextField tf_maDocGia;
	private JTextField tf_hoTen;
	private JTextField tf_soDT;
	private JTextField tf_email;
	private JTable table;
	private JRadioButton rdBtn_nam;
	private JRadioButton rdBtn_nu;
	private JButton bt_them;
	private JButton bt_xoa;
	private JButton bt_sua;
	private JButton bt_timKiem;
	private JButton bt_lamMoi;
	private JMenuItem libraryManagement_Item;
	private JMenuItem readerManagement_Item;
	private JMenuItem managerBorrowsBooks_Item;
	private JMenuItem feedBack_Item;
	private JMenuItem feedBackAdmin_Item;
	private JMenuItem login_Item;
	private JMenuItem exit_Item;

	public ReaderManagementView(DefaultTableModel tableModel) {
		setTitle("Quản lý Độc giả");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 486);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Quản lý");
		menu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		libraryManagement_Item = new JMenuItem("Thư viện");
		libraryManagement_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu.add(libraryManagement_Item);

		readerManagement_Item = new JMenuItem("Độc giả");
		readerManagement_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu.add(readerManagement_Item);

		managerBorrowsBooks_Item = new JMenuItem("Mượn trả");
		managerBorrowsBooks_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu.add(managerBorrowsBooks_Item);

		JMenu menu2 = new JMenu("Phản hồi");
		menu2.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		feedBack_Item = new JMenuItem("Độc giả");
		feedBack_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu2.add(feedBack_Item);

		feedBackAdmin_Item = new JMenuItem("Admin");
		feedBackAdmin_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu2.add(feedBackAdmin_Item);

		JMenu menu3 = new JMenu("Đăng nhập & Thoát");
		menu3.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		login_Item = new JMenuItem("Đăng nhập");
		login_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu3.add(login_Item);

		exit_Item = new JMenuItem("Thoát");
		exit_Item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu3.add(exit_Item);

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

		rdBtn_nam = new JRadioButton("Nam");
		rdBtn_nam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtn_nam.setBounds(394, 54, 62, 21);
		panel.add(rdBtn_nam);

		rdBtn_nu = new JRadioButton("Nữ");
		rdBtn_nu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtn_nu.setBounds(486, 54, 53, 21);
		panel.add(rdBtn_nu);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdBtn_nam);
		genderGroup.add(rdBtn_nu);

		bt_them = new JButton("Thêm độc giả");
		bt_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_them.setBounds(89, 142, 125, 21);
		panel.add(bt_them);

		bt_xoa = new JButton("Xóa độc giả");
		bt_xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_xoa.setBounds(249, 142, 114, 21);
		panel.add(bt_xoa);

		bt_sua = new JButton("Sửa thông tin");
		bt_sua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_sua.setBounds(420, 142, 125, 21);
		panel.add(bt_sua);

		bt_timKiem = new JButton("Tìm kiếm");
		bt_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_timKiem.setBounds(608, 142, 100, 21);
		panel.add(bt_timKiem);

		bt_lamMoi = new JButton("Làm mới");
		bt_lamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_lamMoi.setBounds(770, 142, 105, 21);
		panel.add(bt_lamMoi);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 201, 936, 212);
		contentPane.add(scrollPane);

		table = new JTable(tableModel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
	}

	public JTextField getTf_maDocGia() {
		return tf_maDocGia;
	}

	public JTextField getTf_hoTen() {
		return tf_hoTen;
	}

	public JTextField getTf_soDT() {
		return tf_soDT;
	}

	public JTextField getTf_email() {
		return tf_email;
	}

	public JRadioButton getRdBtn_nam() {
		return rdBtn_nam;
	}

	public JRadioButton getRdBtn_nu() {
		return rdBtn_nu;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBt_them() {
		return bt_them;
	}

	public JButton getBt_xoa() {
		return bt_xoa;
	}

	public JButton getBt_sua() {
		return bt_sua;
	}

	public JButton getBt_timKiem() {
		return bt_timKiem;
	}

	public JButton getBt_lamMoi() {
		return bt_lamMoi;
	}

	public JMenuItem getLibraryManagement_Item() {
		return libraryManagement_Item;
	}

	public JMenuItem getReaderManagement_Item() {
		return readerManagement_Item;
	}

	public JMenuItem getManagerBorrowsBooks_Item() {
		return managerBorrowsBooks_Item;
	}

	public JMenuItem getFeedBack_Item() {
		return feedBack_Item;
	}

	public JMenuItem getFeedBackAdmin_Item() {
		return feedBackAdmin_Item;
	}

	public JMenuItem getLogin_Item() {
		return login_Item;
	}

	public JMenuItem getExit_Item() {
		return exit_Item;
	}
}
