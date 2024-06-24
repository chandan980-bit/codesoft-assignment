import java.util.Scanner;

interface IUser {
    void withdraw(double amount);
    void deposit(double amount);
    void checkBalance();
}

class UserAccount {
    private double amount;
    private String accNo;

    public UserAccount(double amount, String accNo) {
        amount = this.amount;
        accNo = this.accNo;
    }
    double getAmount() {
        return amount;
    }
    void setAmount(double amount) {
        this.amount = amount;
    }
    String getAccNo() {
        return this.accNo;
    }
    void setAccNo(String accNo) {
        this.accNo = accNo;
    }
}

class ATMMachine implements IUser {
    private UserAccount acc;
    public ATMMachine(UserAccount acc) {
        this.acc = acc;
    }

    public void withdraw(double amount) {
        double newAmount = acc.getAmount() - amount;
        acc.setAmount(newAmount);
        System.out.println("Amount is successfully withdrawn");
    }

    public void deposit(double amount) {
        double newAmount = acc.getAmount() + amount;
        acc.setAmount(newAmount);
        System.out.println("Amount is successfully deposited");
    }

    public void checkBalance() {
        System.out.println("Current account balance: " + acc.getAmount());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account number");
        String accNo = sc.nextLine();
        System.out.println("Enter current account balance");
        double accBal = sc.nextDouble();
        UserAccount ua = new UserAccount(accBal, accNo);
        ATMMachine atm = new ATMMachine(ua);

        while(true) {
            System.out.println("\n");
            System.out.println("1. Withdaw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Quit");
            System.out.print("Enter Input: ");
            int input = sc.nextInt();

            if(input == 1) {
                // Withdraw
                System.out.print("Enter an amount: ");
                double withdrawAmt = sc.nextDouble();
                atm.withdraw(withdrawAmt);
            } else if(input == 2) {
                // Deposit
                System.out.print("Enter an amount: ");
                double depositAmt = sc.nextDouble();
                atm.deposit(depositAmt);
            } else if(input == 3) {
                // Check balance
                atm.checkBalance();
            } else if(input == 4) {
                break;
            }
        }

        sc.close();
    }
}
