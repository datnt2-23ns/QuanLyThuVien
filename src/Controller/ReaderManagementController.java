//package Controller;
//
//import Model.ReaderManagementModel;
//import View.ReaderManagementView;
//import View.LoginView;
//import View.LibraryManagementView;
//import View.ManagerBorrowsBooksView;
//import View.FeedbackView;
//import View.FeedbackAdminView;
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Comparator;
//import java.util.Vector;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ReaderManagementController {
// private ReaderManagementModel model;
// private ReaderManagementView view;
// private ExecutorService executorService;
//
// public ReaderManagementController(ReaderManagementModel model, ReaderManagementView view) {
//     this.model = model;
//     this.view = view;
//     this.executorService = Executors.newCachedThreadPool();
//     initController();
// }
//
// private void initController() {
//     view.getBt_them().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             addReader();
//         }
//     });
//
//     view.getBt_sua().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             view.getTable().setEnabled(true);
//             JOptionPane.showMessageDialog(null, "Bây giờ bạn có thể chỉnh sửa dữ liệu trực tiếp trên bảng. Nhấn Enter để lưu thay đổi.");
//         }
//     });
//
//     view.getBt_xoa().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             executorService.execute(() -> removeReader());
//         }
//     });
//
//     view.getBt_timKiem().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             executorService.execute(() -> findReader());
//         }
//     });
//
//     view.getBt_lamMoi().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             executorService.execute(() -> refreshReaders());
//         }
//     });
//
//     view.getLibraryManagement_Item().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             view.dispose();
//             new LibraryManagementView().setVisible(true);
//         }
//     });
//
//     view.getReaderManagement_Item().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             // Current view
//         }
//     });
//
//     view.getManagerBorrowsBooks_Item().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             view.dispose();
//             new ManagerBorrowsBooksView().setVisible(true);
//         }
//     });
//
//     view.getFeedBack_Item().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             view.dispose();
//             new FeedbackView().setVisible(true);
//         }
//     });
//
//     view.getFeedBackAdmin_Item().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             view.dispose();
//             new FeedbackAdminView().setVisible(true);
//         }
//     });
//
//     view.getLogin_Item().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             view.dispose();
//             new LoginView().setVisible(true);
//         }
//     });
//
//     view.getExit_Item().addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             System.exit(0);
//         }
//     });
// }
//
// private void addReader() {
//     String maDocGia = view.getTf_maDocGia().getText();
//     String hoTen = view.getTf_hoTen().getText();
//     String soDT = view.getTf_soDT().getText();
//     String email = view.getTf_email().getText();
//     String gioiTinh = view.getRdBtn_nam().isSelected() ? "Nam" : "Nữ";
//
//     Vector<Object> row = new Vector<>();
//     row.add(model.getTableModel().getRowCount() + 1);
//     row.add(maDocGia);
//     row.add(hoTen);
//     row.add(soDT);
//     row.add(email);
//     row.add(gioiTinh);
//     model.addReader(row);
//
//     view.getTf_maDocGia().setText("");
//     view.getTf_hoTen().setText("");
//     view.getTf_soDT().setText("");
//     view.getTf_email().setText("");
//     view.getRdBtn_nam().setSelected(false);
//     view.getRdBtn_nu().setSelected(false);
// }
//
// private void removeReader() {
//     String maDocGia = JOptionPane.showInputDialog("Nhập mã độc giả cần xóa:");
//     if (maDocGia != null) {
//         model.removeReader(maDocGia);
//         JOptionPane.showMessageDialog(null, "Đã xóa độc giả có mã: " + maDocGia);
//     }
// }
//
// private void findReader() {
//     String maDocGia = JOptionPane.showInputDialog("Nhập mã độc giả cần tìm:");
//     if (maDocGia != null) {
//         int index = model.findReader(maDocGia);
//         if (index != -1) {
//             JOptionPane.showMessageDialog(null, "Độc giả có mã: " + maDocGia + " ở vị trí: " + (index + 1));
//         } else {
//             JOptionPane.showMessageDialog(null, "Độc giả không tồn tại");
//         }
//     }
// }
//
// private void refreshReaders() {
//     Vector<Vector<Object>> dataVector = new Vector<>();
//     for (int i = 0; i < model.getTableModel().getRowCount(); i++) {
//         Vector<Object> row = new Vector<>();
//         for (int j = 0; j < model.getTableModel().getColumnCount(); j++) {
//             row.add(model.getTableModel().getValueAt(i, j));
//         }
//         dataVector.add(row);
//     }
//     dataVector.sort(Comparator.comparing(v -> (String) v.get(2)));
//
//     model.refreshReaders(dataVector);
//
//     view.getTable().setEnabled(false);
// }
//}


package Controller;

import Model.ReaderManagementModel;
import View.ReaderManagementView;
import View.LoginView;
import View.LibraryManagementView;
import View.ManagerBorrowsBooksView;
import View.FeedbackView;
import View.FeedbackAdminView;
import Model.FeedbackAdminModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReaderManagementController {
    private ReaderManagementModel model;
    private ReaderManagementView view;
    private ExecutorService executorService;

    public ReaderManagementController(ReaderManagementModel model, ReaderManagementView view) {
        this.model = model;
        this.view = view;
        this.executorService = Executors.newCachedThreadPool();
        initController();
    }

    private void initController() {
        view.getBt_them().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addReader();
            }
        });

        view.getBt_sua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getTable().setEnabled(true);
                JOptionPane.showMessageDialog(null, "Bây giờ bạn có thể chỉnh sửa dữ liệu trực tiếp trên bảng. Nhấn Enter để lưu thay đổi.");
            }
        });

        view.getBt_xoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executorService.execute(() -> removeReader());
            }
        });

        view.getBt_timKiem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executorService.execute(() -> findReader());
            }
        });

        view.getBt_lamMoi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executorService.execute(() -> refreshReaders());
            }
        });

        view.getLibraryManagement_Item().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                new LibraryManagementView().setVisible(true);
            }
        });

        view.getReaderManagement_Item().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do nothing or handle as needed
            }
        });

        view.getManagerBorrowsBooks_Item().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                DefaultTableModel tableModel = model.getTableModel(); // Assuming you have a method to get the table model
                new ManagerBorrowsBooksView(tableModel).setVisible(true);
            }
        });

        view.getFeedBack_Item().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                new FeedbackView().setVisible(true);
            }
        });

        view.getFeedBackAdmin_Item().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                FeedbackAdminModel adminModel = new FeedbackAdminModel(); // Create an instance of FeedbackAdminModel
                FeedbackAdminController adminController = new FeedbackAdminController(adminModel); // Create an instance of FeedbackAdminController
                FeedbackAdminView feedbackAdminView = new FeedbackAdminView(adminController); // Instantiate FeedbackAdminView with FeedbackAdminController
                feedbackAdminView.setVisible(true); // Set the view visible
            }
        });


        view.getLogin_Item().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                new LoginView().setVisible(true);
            }
        });

        view.getExit_Item().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void addReader() {
        String maDocGia = view.getTf_maDocGia().getText();
        String hoTen = view.getTf_hoTen().getText();
        String soDT = view.getTf_soDT().getText();
        String email = view.getTf_email().getText();
        String gioiTinh = view.getRdBtn_nam().isSelected() ? "Nam" : "Nữ";

        Vector<Object> row = new Vector<>();
        row.add(model.getTableModel().getRowCount() + 1);
        row.add(maDocGia);
        row.add(hoTen);
        row.add(soDT);
        row.add(email);
        row.add(gioiTinh);
        model.addReader(row);

        view.getTf_maDocGia().setText("");
        view.getTf_hoTen().setText("");
        view.getTf_soDT().setText("");
        view.getTf_email().setText("");
        view.getRdBtn_nam().setSelected(false);
        view.getRdBtn_nu().setSelected(false);
    }

    private void removeReader() {
        String maDocGia = JOptionPane.showInputDialog("Nhập mã độc giả cần xóa:");
        if (maDocGia != null) {
            model.removeReader(maDocGia);
            JOptionPane.showMessageDialog(null, "Đã xóa độc giả có mã: " + maDocGia);
        }
    }

    private void findReader() {
        String maDocGia = JOptionPane.showInputDialog("Nhập mã độc giả cần tìm:");
        if (maDocGia != null) {
            int index = model.findReader(maDocGia);
            if (index != -1) {
                JOptionPane.showMessageDialog(null, "Độc giả có mã: " + maDocGia + " ở vị trí: " + (index + 1));
            } else {
                JOptionPane.showMessageDialog(null, "Độc giả không tồn tại");
            }
        }
    }

    private void refreshReaders() {
        Vector<Vector<Object>> dataVector = new Vector<>();
        for (int i = 0; i < model.getTableModel().getRowCount(); i++) {
            Vector<Object> row = new Vector<>();
            for (int j = 0; j < model.getTableModel().getColumnCount(); j++) {
                row.add(model.getTableModel().getValueAt(i, j));
            }
            dataVector.add(row);
        }
        dataVector.sort(Comparator.comparing(v -> (String) v.get(2)));

        model.refreshReaders(dataVector);

        view.getTable().setEnabled(false);
    }
}
