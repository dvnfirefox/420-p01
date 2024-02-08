package worker;

import java.time.LocalDate;
import java.util.ArrayList;

public class SaleEmployee extends Employee {
    final private float commision;
    final private ArrayList<Pay> myPays = super.getMyPays();

    public SaleEmployee(int usedId, String firstName, String lastName, String adress, String phone, String email, float salary, float commision) { // create a new sale employee
        super(usedId, firstName, lastName, adress, phone, email, salary);
        this.commision = commision;
    }
    public void givePay(float hours, float sale, LocalDate date) { // create a sale employee pay
        float salary = super.getSalary();
        Pay pay = new Pay(hours,salary,sale,commision,date);
        myPays.add(pay);

    }
    @Override
    public void listPay() { // list all this employee pay
        System.out.println("ID: " + super.getUsedId() + " Name: " + super.getFirstName() + " " + super.getLastName());
        for (Pay myPay : super.getMyPays()) {
            myPay.displaysales();

        }
    }
}
