package Controller;

import Model.FeedbackAdminModel;
import java.util.List;

public class FeedbackAdminController {
    private FeedbackAdminModel adminModel;

    public FeedbackAdminController(FeedbackAdminModel adminModel) {
        this.adminModel = adminModel;
    }

    public void addFeedback(String feedback) {
        adminModel.addFeedback(feedback);
    }

    public List<String> getFeedbackList() {
        return adminModel.getFeedbackList();
    }
}
