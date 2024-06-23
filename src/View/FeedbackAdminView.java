package View;

import Model.FeedbackAdminModel;
import Controller.FeedbackAdminController;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FeedbackAdminView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel displayLabel;
    private FeedbackAdminController adminController;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FeedbackAdminModel adminModel = new FeedbackAdminModel();
                FeedbackAdminController adminController = new FeedbackAdminController(adminModel);
                FeedbackAdminView frame = new FeedbackAdminView(adminController);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FeedbackAdminView(FeedbackAdminController adminController) {
        this.adminController = adminController;

        setTitle("Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Create a label to display the information
        displayLabel = new JLabel("");
        displayLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        displayLabel.setBounds(10, 10, 414, 150);
        contentPane.add(displayLabel);

        // Create a text field for user input
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField.setBounds(10, 180, 300, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        // Create a button to send the input
        JButton sendButton = new JButton("Gửi");
        sendButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        sendButton.setBounds(320, 180, 100, 30);
        contentPane.add(sendButton);

        // Add an action listener to the button
        sendButton.addActionListener((ActionEvent e) -> {
            String inputText = textField.getText();
            adminController.addFeedback(inputText);
            updateDisplay();
            textField.setText("");
        });
    }

    private void updateDisplay() {
        StringBuilder displayText = new StringBuilder("<html>");
        for (String feedback : adminController.getFeedbackList()) {
            displayText.append(feedback).append("<br>");
        }
        displayText.append("</html>");
        displayLabel.setText(displayText.toString());
    }
}
