package Main;

//LibraryManagementApp.java
import Model.Book;
import View.LibraryManagementView;
import Controller.LibraryManagementController;
import javax.swing.*;

public class LibraryManagementApp {
 public static void main(String[] args) {
     SwingUtilities.invokeLater(() -> {
         try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             LibraryManagementView view = new LibraryManagementView();
             new LibraryManagementController(view);
         } catch (Exception e) {
             e.printStackTrace();
         }
     });
 }
}
