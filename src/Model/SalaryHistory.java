/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author THANH TRUNG
 */
public class SalaryHistory {
    private String workerId;
    private double previousSalary;
    private double currentSalary;
    private Date date;

    public SalaryHistory(String workerId, double previousSalary, double currentSalary, Date date) {
        this.workerId = workerId;
        this.previousSalary = previousSalary;
        this.currentSalary = currentSalary;
        this.date = date;
    }
    

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public double getPreviousSalary() {
        return previousSalary;
    }

    public void setPreviousSalary(double previousSalary) {
        this.previousSalary = previousSalary;
    }

    public double getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(double currentSalary) {
        this.currentSalary = currentSalary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SalaryHistory{" + "workerId=" + workerId + ", previousSalary=" + previousSalary + ", currentSalary=" + currentSalary + ", date=" + date + '}';
    }
    
    
}
