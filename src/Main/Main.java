package Main;

import Controller.WorkerManagementController;
import Model.Management;
import View.WorkerManagementView;

public class Main {
    public static void main(String[] args) {
        WorkerManagementView view = new WorkerManagementView();
        Management model = new Management();
        WorkerManagementController controller = new WorkerManagementController(view, model);

        controller.start();
    }
}
