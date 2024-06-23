package Model;

import java.util.ArrayList;
import java.util.List;

public class FeedbackAdminModel {
    private List<String> feedbackList;

    public FeedbackAdminModel() {
        feedbackList = new ArrayList<>();
    }

    public void addFeedback(String feedback) {
        feedbackList.add(feedback);
    }

    public List<String> getFeedbackList() {
        return feedbackList;
    }
}
