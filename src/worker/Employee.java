package worker;

import java.time.LocalDate;
import java.util.ArrayList;

public class Employee implements IPayableObject {
    private int usedId;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private float salary;
    private ArrayList<Pay> myPays = new ArrayList<>();

    public Employee(int usedId, String firstName, String lastName, String address, String phone, String email, float salary){
        this.usedId = usedId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
    }

    @Override
    public float displayTotal() { // calculate the sum of all the pay of this employee
        float total = 0;
        for(Pay totalPay: myPays){
            total = total + totalPay.getAmount();
        }
        System.out.println("ID: " + usedId + " Name: " + firstName + " " + lastName + " Total amount: " + total);
        return (total);

    }
    public boolean checkDate(LocalDate testedDate){ // check if the date receive is already use for a pay
        for(Pay payCheckDate: myPays){
            if (testedDate.equals(payCheckDate.getDate())) {
                return false;
            }
        }
        return true;
    }
    public void givePay(float hours, LocalDate date){ // create a new pay
        Pay pay = new Pay(hours,salary, date);
        myPays.add(pay);
    }

    public void listPay(){ // display all the pay of this employee
        System.out.println("ID: " + usedId + " Name: " + firstName + " " + lastName);
        for(Pay myPay: myPays ){
            myPay.display();
        }
    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    public ArrayList<Pay> getMyPays() {
        return myPays;
    }

    public void setMyPays(ArrayList<Pay> myPays) {
        this.myPays = myPays;
    }
    public int getUsedId() {
        return usedId;
    }

    public void setUsedId(int usedId) {
        this.usedId = usedId;
    }

}
