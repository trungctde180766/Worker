
package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Management {
    private Map<String, Worker> workers;
    private List<SalaryHistory> salaryHistories;

    public Management() {
        workers = new HashMap<>();
        salaryHistories = new ArrayList<>();
    }

    public boolean addWorker(Worker worker) throws Exception {
        if (worker == null || workers.containsKey(worker.getId())) {
            throw new Exception("Invalid worker or worker with the same id already exists.");
        }

        if (worker.getAge() < 18 || worker.getAge() > 50 || worker.getSalary() <= 0) {
            throw new Exception("Invalid worker data: age must be between 18 and 50, salary must be greater than 0.");
        }

        workers.put(worker.getId(), worker);
        return true;
    }

    public boolean changeSalary(SalaryStatus status, String id, double amount) throws Exception {
        if (!workers.containsKey(id) || amount <= 0) {
            throw new Exception("Invalid worker ID or amount.");
        }

        Worker worker = workers.get(id);
        double previousSalary = worker.getSalary();
        double currentSalary;

        if (status == SalaryStatus.INCREASE) {
            currentSalary = previousSalary + amount;
        } else {
            currentSalary = previousSalary - amount;
        }

        worker.setSalary(currentSalary);
        salaryHistories.add(new SalaryHistory(id, previousSalary, currentSalary, new Date()));

        return true;
    }

    public List<SalaryHistory> getInformationSalary() {
        // Sort by worker id
        salaryHistories.sort(Comparator.comparing(SalaryHistory::getWorkerId));
        return salaryHistories;
    }
}