package Controller;

import Model.Management;
import Model.SalaryHistory;
import Model.SalaryStatus;
import Model.Worker;
import View.WorkerManagementView;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class WorkerManagementController {
    private final WorkerManagementView view;
    private final Management model;

    public WorkerManagementController(WorkerManagementView view, Management model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        while (true) {
            int option = view.displayMenuAndGetOption();

            switch (option) {
                case 1:
                    addWorker();
                    break;
                case 2:
                    adjustSalary(SalaryStatus.INCREASE);
                    break;
                case 3:
                    adjustSalary(SalaryStatus.DECREASE);
                    break;
                case 4:
                    showAdjustedSalaryWorkerInformation();
                    break;
                case 5:
                    view.displayMessage("Quitting program.");
                    return;
                default:
                    view.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    private void addWorker() {
        try {
            Worker worker = view.readWorkerDetailsFromUser();
            model.addWorker(worker);
            view.displayMessage("Worker added successfully.");
        } catch (Exception e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }

    private void adjustSalary(SalaryStatus status) {
        try {
            String id = view.readWorkerIdFromUser();
            double amount = view.readAmountFromUser();

            model.changeSalary(status, id, amount);
            String message = (status == SalaryStatus.INCREASE) ? "increased" : "decreased";
            view.displayMessage("Salary " + message + " successfully.");
        } catch (Exception e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }

    private void showAdjustedSalaryWorkerInformation() {
        view.displayMessage("Adjusted salary worker information:");
        List<SalaryHistory> salaryHistories = model.getInformationSalary();
        if (salaryHistories.isEmpty()) {
            view.displayMessage("No salary adjustments found.");
        } else {
            salaryHistories.forEach(history -> view.displayMessage(
                    history.getWorkerId() + " - Previous Salary: " + history.getPreviousSalary() +
                            ", Current Salary: " + history.getCurrentSalary() + ", Date: " + history.getDate())
            );
        }
    }
}
