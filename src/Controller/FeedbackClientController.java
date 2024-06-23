package Controller;

import Model.FeedbackClientModel;

public class FeedbackClientController {
    private FeedbackClientModel clientModel;

    public FeedbackClientController(FeedbackClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public String sendFeedback(String maDocGia, String tenDocGia, String noiDung) {
        return clientModel.sendFeedback(maDocGia, tenDocGia, noiDung);
    }

    public static void main(String[] args) {
        FeedbackClientModel clientModel = new FeedbackClientModel();
        FeedbackClientController clientController = new FeedbackClientController(clientModel);

        // Example usage
        String maDocGia = "123";
        String tenDocGia = "John Doe";
        String noiDung = "This is a sample feedback.";

        String response = clientController.sendFeedback(maDocGia, tenDocGia, noiDung);
        System.out.println("Server response: " + response);
    }
}
