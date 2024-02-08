package worker;

import java.time.LocalDate;
import java.util.ArrayList;

public class Subcontractor implements IPayableObject {
    private int id;
    private String name;
    private String description;
    private String address;
    private String phone;
    private String email;
    private float amount;
    private LocalDate date;
    private boolean newDate = true;
    private ArrayList<Bill> myBills = new ArrayList<>();

    public Subcontractor(int id, String name, String description, String address, String phone, String email){ // create a new subcontrator
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public void payBill(float amount, LocalDate date){ // create a new bill
        Bill bill = new Bill(amount, date);
        myBills.add(bill);
    }
    public void listBill(){ // display all the bill for this subcontrator
        for(Bill listBill: myBills){
            listBill.display();
        }
    }
    @Override
    public float displayTotal() { // calculate the sum of the pay for this subcontractor
        float total = 0;
        for(Bill totalBill: myBills){
            total = totalBill.getAmount() + total;
        }
        System.out.println("ID: " + id + " Name: " + name + " description: " + description + " Total amount: " + total);

        return total;
    }
    public boolean checkDate(LocalDate testedDate){ // check if the date receive is already used for a bill
        for(Bill payCheckDate: myBills){
            if (testedDate.equals(payCheckDate.getDate())) {
                return false;
            }
        }
        return true;
    }
}
