import java.util.*;

public class Lists {
    static String currency;
    static int currency1;
    static double withdrawSum=0;
    static double depositSum=0;
    static double balance = 0;
    static int operationNumber;
    static int amount=0;
    static double money=1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> people = new ArrayList();
        ArrayList<String> password = new ArrayList();
        people.add("Tom");
        people.add("Alice");
        people.add("Kate");
        password.add("1111");
        password.add("2222");
        password.add("3333");
        System.out.println("Введите пользователя");
        String man = sc.next();
        int i;
        for(i=0;i<people.size();i++){
            boolean retVal1 = people.get(i).equals(man);
            if(retVal1==true) {
                break;
            }
        }
        while (true) {
            if(i==3){break;}
            System.out.println("Введите пин-код");
            String pinCode = sc.next();
            if(amount==3){
                System.out.println("Попытки закончились");
                break;
            }
            boolean retVal = password.get(i).equals(pinCode);
            if(retVal==true) {
                System.out.println("Пин-код введен правильно");
                break;
            }
            else {
                amount++;
            }
        }
        if(amount!=3) {
            System.out.println("Выберите валюту: 1 - USD, 2 - BYN");
            currency1 = sc.nextInt();
            switch (currency1){
                case 1:
                    currency="USD";
                    money=2.5;
                    break;
                case 2:
                    currency="BYN";
                    money=1;
                    break;
            }
            while (true) {
                System.out.println("");
                System.out.println("Выберите операцию: 1- пополнить баланс, 2- снять со счета, 3- посмотреть счет");
                operationNumber = sc.nextInt();
                if (businessLogic(sc) == 4) break;
            }
        }
    }


    private static int businessLogic(Scanner sc) {
        int operation;
        switch (operationNumber) {
            case 1:
                System.out.println("Введите сумму");
                depositSum = sc.nextInt();
                deposit(depositSum);
                System.out.println("Ваш баланс: " + balance + " " + currency);
                operation = 1;
                break;
            case 2:
                System.out.println("Введите сумму");
                withdrawSum = sc.nextInt();
                withdraw(withdrawSum);
                if(balance<0 || withdrawSum>balance){
                    System.out.println("Баланс=0 или введена неверная сумма");
                }
                else {
                    System.out.println("Ваш баланс: " + balance + " " + currency);
                    operation = 2;
                    break;}
            case 3:
                System.out.println("Ваш баланс: " + balance + " " + currency);
                operation = 3;
                break;
            default:
                operation = 4;
                break;
        }
        return operation;
    }

    public static void withdraw(double withdrawSum){
        if (balance<withdrawSum){

        }
        else {
            balance =balance-withdrawSum/money;
        }
    }
    public static void deposit(double depositSum) {
        balance = balance+ depositSum/money;
    }
}