package Controller;

import Model.FeedbackServerModel;

public class FeedbackServerController {
    private FeedbackServerModel serverModel;

    public FeedbackServerController(FeedbackServerModel serverModel) {
        this.serverModel = serverModel;
    }

    public void startServer() {
        serverModel.startServer();
    }

    public static void main(String[] args) {
        FeedbackServerModel serverModel = new FeedbackServerModel();
        FeedbackServerController serverController = new FeedbackServerController(serverModel);
        serverController.startServer();
    }
}
