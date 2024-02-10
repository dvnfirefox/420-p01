
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import worker.*;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        int choice;
        int id;
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Employee> employees = new HashMap<>();
        Map<Integer, Subcontractor> subcontrators = new HashMap<>();

        // Main loop
        while (!exit) {
            // main menu and selection
            System.out.println("Welcome to CleanCorp pay system");
            System.out.println("Select an option:\n");
            System.out.println("1- Add employee");
            System.out.println("2- Give employee pay");
            System.out.println("3- Add subcontractor");
            System.out.println("4- Pay subcontractor bill");
            System.out.println("5- List pays by employee");
            System.out.println("6- List bills by subcontractor");
            System.out.println("7- List all expense");
            System.out.println("8- Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume the unused line by the nextInt
            switch (choice) {
                // add employee
                case 1:


                    System.out.println("Add employee \nenter your employee id");
                    id = scanner.nextInt();
                    scanner.nextLine();// consume the unused line by the nextInt
                    while (id < 1 || id > 999 || employees.containsKey(id)) {
                        if (employees.containsKey(id)) {
                            System.out.println("The choosen id is already used please entre another one");
                        } else {
                            System.out.println("please enter an id between 1 and 999");
                        }
                        id = scanner.nextInt();
                        scanner.nextLine();// consume the unused line by the nextInt
                    }
                    System.out.println("enter your first name");
                    String firstName = scanner.nextLine();
                    System.out.println("enter your last name");
                    String lastName = scanner.nextLine();
                    System.out.println("enter your address");
                    String address = scanner.nextLine();
                    System.out.println("enter your phone number");
                    String phone = scanner.nextLine();
                    System.out.println("enter your email");
                    String email = scanner.nextLine();
                    float salary;
                    do {
                        System.out.println("enter your salary");
                        salary = scanner.nextInt();
                        scanner.nextLine(); // consume the unused line by the nextInt
                    } while (salary <= 0);

                    System.out.println("are you in sales ? y = yes");
                    String saleCheck = scanner.nextLine();
                    if (saleCheck.equals("y") || saleCheck.equals("Y")) {
                        float commision;
                        do {
                            System.out.println("enter your commision rate");
                            commision = scanner.nextInt();
                        } while (commision < 0 || commision > 25);

                        employees.put(id, new SaleEmployee(id, firstName, lastName, address, phone, email, salary, commision));
                    } else {
                        employees.put(id, new Employee(id, firstName, lastName, address, phone, email, salary));
                    }
                    System.out.println("Press any key to continue");
                    scanner.nextLine();

                    break;
                //Give employee pay
                case 2:
                    System.out.println("enter your id");
                    id = scanner.nextInt();
                    scanner.nextLine(); // consume the unused line by the nextInt
                    // check if the id already exist
                    if (employees.containsKey(id)) {
                        // check if the date is already used for a pay
                        LocalDate date;
                        String dateCheck;
                        do {
                            if (employees.get(id).checkDate(LocalDate.now())) {
                                System.out.println("enter Y to choose a ulterior date");
                                dateCheck = scanner.nextLine();
                            } else {
                                System.out.println("please enter the date of the pay");
                                dateCheck = "y";
                            }
                            if (dateCheck.equals("y") || dateCheck.equals("Y")) {
                                System.out.println("enter the day");
                                int day = scanner.nextInt();
                                scanner.nextLine(); // consume the unused line by the nextInt
                                System.out.println("enter the month number");
                                int month = scanner.nextInt();
                                scanner.nextLine(); // consume the unused line by the nextInt
                                System.out.println("enter the year");
                                int year = scanner.nextInt();
                                scanner.nextLine(); // consume the unused line by the nextInt
                                date = LocalDate.of(year, month, day);
                            } else {
                                date = LocalDate.now();
                            }
                        } while (!employees.get(id).checkDate(date));

                        System.out.println("enter number of hours worked");
                        float hours = scanner.nextFloat();
                        scanner.nextLine(); // consume the unused line by the nextInt
                        while (hours > 40) {
                            System.out.println("overtime not permitted please enter hours below 40h");
                            hours = scanner.nextFloat();
                            scanner.nextLine(); // consume the unused line by the nextInt
                        }
                        Employee currentEmployee = employees.get(id);
                        if (currentEmployee instanceof SaleEmployee) {
                            System.out.println("enter your sales");
                            float sale = scanner.nextFloat();
                            SaleEmployee currentSaleEmployee = (SaleEmployee) currentEmployee;
                            currentSaleEmployee.givePay(hours, sale, date);
                        } else {
                            employees.get(id).givePay(hours, date);
                        }
                    } else {
                        System.out.println("this employee id doesnt exist, please choose a existing id or create a new one");
                    }
                    System.out.println("Press any key to continue");
                    scanner.nextLine();

                    break;
                // add subcontractor
                case 3:
                    System.out.println("Add subcontractor \nenter your subcontractor id");
                    id = scanner.nextInt();
                    scanner.nextLine();// consume the unused line by the nextInt
                    while (id < 1 || id > 999 || subcontrators.containsKey(id)) {
                        if (subcontrators.containsKey(id)) {
                            System.out.println("The choosen id is already used please entre another one");
                        } else {
                            System.out.println("please enter an id between 1 and 999");
                        }
                        id = scanner.nextInt();
                        scanner.nextLine();// consume the unused line by the nextInt
                    }
                    System.out.println("enter name of subcontractor");
                    String Name = scanner.nextLine();
                    System.out.println("Enter description");
                    String description = scanner.nextLine();
                    System.out.println("enter your address");
                    String addressSubcontractor = scanner.nextLine();
                    System.out.println("enter your phone number");
                    String phoneSubcontractor = scanner.nextLine();
                    System.out.println("enter your email");
                    String emailSubcontractor = scanner.nextLine();
                    subcontrators.put(id, new Subcontractor(id, Name, description, addressSubcontractor, phoneSubcontractor, emailSubcontractor));
                    System.out.println("Press any key to continue");
                    scanner.nextLine();

                    break;
                //pay subcontractor bill
                case 4:
                    System.out.println("enter your id");
                    id = scanner.nextInt();
                    scanner.nextLine(); // consume the unused line by the nextInt
                    if (subcontrators.containsKey(id)) {
                        LocalDate date;
                        String dateCheck;
                        do {
                            if (subcontrators.get(id).checkDate(LocalDate.now())) {
                                System.out.println("enter Y to choose a ulterior date");
                                dateCheck = scanner.nextLine();
                            } else {
                                System.out.println("please enter the date of the pay");
                                dateCheck = "y";
                            }
                            if (dateCheck.equals("y") || dateCheck.equals("Y")) {
                                System.out.println("enter the day");
                                int day = scanner.nextInt();
                                scanner.nextLine(); // consume the unused line by the nextInt
                                System.out.println("enter the month number");
                                int month = scanner.nextInt();
                                scanner.nextLine(); // consume the unused line by the nextInt
                                System.out.println("enter the year");
                                int year = scanner.nextInt();
                                scanner.nextLine(); // consume the unused line by the nextInt
                                date = LocalDate.of(year, month, day);
                            } else {
                                date = LocalDate.now();
                            }
                        } while (!subcontrators.get(id).checkDate(date));
                        System.out.println("please enter bill amount");
                        float amount = scanner.nextFloat();
                        scanner.nextLine(); // consume the unused line by the nextInt
                        subcontrators.get(id).payBill(amount, date);
                    } else {
                        System.out.println("this employee id doesnt exist, please choose a existing id or create a new one");
                    }
                    System.out.println("Press any key to continue");
                    scanner.nextLine();
                    break;
                //list pays by employee
                case 5:
                    System.out.println("enter your id");
                    id = scanner.nextInt();
                    scanner.nextLine(); // consume the unused line by the nextInt
                    if (employees.containsKey(id)) {
                        employees.get(id).listPay();
                    } else {
                        System.out.println("this employee id doesnt exist, please choose a existing id or create a new one");
                    }
                    System.out.println("Press any key to continue");
                    scanner.nextLine();
                    break;
                //list bills by contractor
                case 6:
                    System.out.println("Enter your id");
                    id = scanner.nextInt();
                    scanner.nextLine(); // consume the unused line by the nextInt
                    if (subcontrators.containsKey(id)) {
                        subcontrators.get(id).listBill();
                    } else {
                        System.out.println("this subcontractor id doesnt exist, please choose a existing id or create a new one");
                    }
                    System.out.println("Press any key to continue");
                    scanner.nextLine();
                    break;
                //list all expense
                case 7:

                    System.out.println("allo");
                    float sumEmployee = 0;
                    float sumSubcontrator = 0;
                    float sumTotal;
                    for (Map.Entry<Integer, Employee> totalEmployee: employees.entrySet() ) {
                        // run throught all the employee to get their pay
                            sumEmployee = sumEmployee + totalEmployee.getValue().displayTotal();
                    }
                    System.out.println("--Sum employee " + sumEmployee);
                    for (Map.Entry<Integer, Subcontractor> totalContractor: subcontrators.entrySet() ) {
                        // run throught all the subcontrator to get their bill
                            sumSubcontrator = sumSubcontrator + totalContractor.getValue().displayTotal();
                    }
                    System.out.println("--Sum subcontractor " + sumSubcontrator);
                    sumTotal = sumEmployee + sumSubcontrator;
                    System.out.println("Total: " + sumTotal);
                    System.out.println("Press any key to continue");
                    scanner.nextLine();
                    break;
                //exit
                case 8:
                    exit = true;
                    break;

            }
        }
    }
}