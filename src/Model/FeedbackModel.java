package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeedbackModel {
    private List<String> feedbackList;

    public FeedbackModel() {
        this.feedbackList = new ArrayList<>();
    }

    public void addFeedback(String feedback) {
        feedbackList.add(feedback);
    }

    public List<String> getFeedbackList() {
        return Collections.unmodifiableList(feedbackList);
    }
}
