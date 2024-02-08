package worker;

import java.time.LocalDate;

public class Pay {
    private float amount;
    private float sale;
    private LocalDate date;

    public Pay(float hours, float salary, LocalDate date) {// create a new pay
        this.amount = hours * salary;
        this.date = date;
        System.out.println("your pay is: " + amount);
    }

    public Pay(float hours, float salary, float sale, float commision, LocalDate date) { // create a new pay
        this.sale = sale;
        this.amount = hours * salary + sale * (commision / 100);
        this.date = date;
        System.out.println("your pay is: " + amount);
    }

    public void display() { // display the employee pay
        System.out.println("Date: " + date + " Gross Pay: " + amount);
    }

    public void displaysales() {
        System.out.println("Date: " + date + " Gross pay: " + amount + " Sales: " + sale);
    } // display the sale employee pay

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
