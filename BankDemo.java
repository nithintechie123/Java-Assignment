class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}

class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    public BankAccount(String accountHolderName,int accountNumber,double balance){
        this.accountHolderName=accountHolderName;
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited: "+ amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount>balance){
            throw new InsufficientFundsException("Insufficient funds!Withdrawal failed.");
        }
        balance-=amount;
        System.out.println("Withdrawn: "+amount);
    }

    public double getBalance(){
        return balance;
    }

    public void displayAccountDetails(){
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " +accountNumber);
        System.out.println("Balance: " + balance );
    }
}

public  class BankDemo{
    public static void main(String[] args) {
        BankAccount account=new BankAccount("Nithin Kumar",123456789,25000);
        account.displayAccountDetails();
        account.deposit(5000);
        account.displayAccountDetails();

        try {
            account.withdraw(5000);
            account.withdraw(3000);
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: "+e.getMessage());
        }
        System.out.println("Current Balance: "+account.getBalance());
    }
}
