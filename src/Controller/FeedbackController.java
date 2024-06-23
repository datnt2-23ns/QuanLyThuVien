package Controller;

import Model.FeedbackModel;
import View.FeedbackView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FeedbackController {
    private FeedbackView view;
    private FeedbackModel model;

    public FeedbackController(FeedbackView view, FeedbackModel model) {
        this.view = view;
        this.model = model;

        view.addSendFeedbackListener(new SendFeedbackListener());
    }

    public void start() {
        view.setVisible(true);
    }

    private class SendFeedbackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String maDocGia = view.getMaDocGia();
            String tenDocGia = view.getTenDocGia();
            String noiDung = view.getNoiDung();

            // Add feedback to the model
            String feedback = maDocGia + ": " + noiDung;
            model.addFeedback(feedback);

            // Clear input fields
            view.clearFields();

            // Update feedback list in the view
            updateFeedbackList();
        }

        private void updateFeedbackList() {
            List<String> feedbackList = model.getFeedbackList();
            view.displayFeedbackList(feedbackList);
        }
    }
}
