package Main;

import Model.ReaderManagementModel;
import View.ReaderManagementView;
import Controller.ReaderManagementController;
import java.awt.EventQueue;

import javax.swing.UIManager;

public class ReaderManagement {
 public static void main(String[] args) {
     EventQueue.invokeLater(() -> {
         try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             ReaderManagementModel model = new ReaderManagementModel();
             ReaderManagementView view = new ReaderManagementView(model.getTableModel());
             new ReaderManagementController(model, view);
             view.setVisible(true);
         } catch (Exception e) {
             e.printStackTrace();
         }
     });
 }
}
