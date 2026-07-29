import java.util.Scanner;

class Employee {
    int empId;
    String empName, address, mailId, mobile;
    double basicPay;

    void setDetails(int id, String name, String addr, String mail, String mob, double bp) {
        empId = id;
        empName = name;
        address = addr;
        mailId = mail;
        mobile = mob;
        basicPay = bp;
    }

    void calculateSalary(double daPer, double hraPer, double pfPer, double staffPer, String designation) {

        double DA = basicPay * daPer / 100;
        double HRA = basicPay * hraPer / 100;
        double PF = basicPay * pfPer / 100;
        double staffClub = basicPay * staffPer / 100;

        double grossSalary = basicPay + DA + HRA;
        double netSalary = grossSalary - PF - staffClub;

        System.out.println("\n========== Salary Details ==========");

        System.out.println("Employee Name : " + empName);
        System.out.println("Employee ID   : " + empId);
        System.out.println("Address       : " + address);
        System.out.println("Mail ID       : " + mailId);
        System.out.println("Mobile No.    : " + mobile);
        System.out.println("Designation   : " + designation);
        System.out.println("Basic Pay     : " + (int) basicPay);

        System.out.println("DA            = " + (int) DA);
        System.out.println("HRA           = " + (int) HRA);
        System.out.println("PF            = " + (int) PF);
        System.out.println("Staff Club    = " + (int) staffClub);
        System.out.println("Gross Salary  = " + (int) grossSalary);
        System.out.println("Net Salary    = " + (int) netSalary);
    }
}

class Programmer extends Employee {
    void salary() {
        calculateSalary(97, 10, 12, 1, "Programmer");
    }
}

class AssistantProfessor extends Employee {
    void salary() {
        calculateSalary(110, 20, 12, 5, "Assistant Professor");
    }
}

class AssociateProfessor extends Employee {
    void salary() {
        calculateSalary(130, 30, 12, 10, "Associate Professor");
    }
}

class Professor extends Employee {
    void salary() {
        calculateSalary(140, 40, 12, 15, "Professor");
    }
}

public class Ex3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n========== Employee Payroll System ==========");
            System.out.println("1. Programmer");
            System.out.println("2. Assistant Professor");
            System.out.println("3. Associate Professor");
            System.out.println("4. Professor");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 5) {
                System.out.println("Thank you! Exiting Program...");
                break;
            }

            System.out.print("Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("Mail ID: ");
            String mail = sc.nextLine();

            System.out.print("Mobile No.: ");
            String mobile = sc.nextLine();

            System.out.print("Basic Pay: ");
            double basicPay = sc.nextDouble();

            switch (ch) {

                case 1:
                    if (basicPay >= 15000 && basicPay <= 20000) {
                        Programmer p = new Programmer();
                        p.setDetails(id, name, address, mail, mobile, basicPay);
                        p.salary();
                    } else {
                        System.out.println("Invalid Basic Pay!");
                        System.out.println("Programmer Basic Pay should be between 15000 and 20000.");
                    }
                    break;

                case 2:
                    if (basicPay >= 20001 && basicPay <= 30000) {
                        AssistantProfessor ap = new AssistantProfessor();
                        ap.setDetails(id, name, address, mail, mobile, basicPay);
                        ap.salary();
                    } else {
                        System.out.println("Invalid Basic Pay!");
                        System.out.println("Assistant Professor Basic Pay should be between 20001 and 30000.");
                    }
                    break;

                case 3:
                    if (basicPay >= 30001 && basicPay <= 40000) {
                        AssociateProfessor asp = new AssociateProfessor();
                        asp.setDetails(id, name, address, mail, mobile, basicPay);
                        asp.salary();
                    } else {
                        System.out.println("Invalid Basic Pay!");
                        System.out.println("Associate Professor Basic Pay should be between 30001 and 40000.");
                    }
                    break;

                case 4:
                    if (basicPay > 40000) {
                        Professor prof = new Professor();
                        prof.setDetails(id, name, address, mail, mobile, basicPay);
                        prof.salary();
                    } else {
                        System.out.println("Invalid Basic Pay!");
                        System.out.println("Professor Basic Pay should be greater than 40000.");
                    }
                    break;

                default:
                    System.out.println("Invalid Choice! Please enter a number between 1 and 5.");
            }
        }

        sc.close();
    }
}