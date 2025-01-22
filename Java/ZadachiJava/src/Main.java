import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input_ = new Scanner(System.in);

//        zadacha1(input_);
//        zadacha2(input_);
//        zadacha3(input_);
//        zadacha4(input_);
//        zadacha5(input_);
//        zadacha6(input_);
//        zadacha7(input_);
//        zadacha8(input_);
//        zadacha9(input_);
//        zadacha10(input_);
//        zadacha11(input_);
//        zadacha12(input_);
//        zadacha13(input_);
//        zadacha14(input_);
//        zadacha15(input_);
//        zadacha16(input_);
//        zadacha17(input_);
//        zadacha18(input_);
//        zadacha19(input_);
//        zadacha20(input_);
    }
    public static void zadacha1(Scanner input_) {
        System.out.print("Введите число: ");
        int n;
        n = input_.nextInt();
        if(n%2==0){
            System.out.println("Чётное число");
        }
        else{
            System.out.println("Нечётное число");
        }
    }
    public static void zadacha2(Scanner input_) {
        System.out.print("Введите числа: ");
        int num1=input_.nextInt();
        int num2=input_.nextInt();
        int num3=input_.nextInt();
        int min=Math.min(Math.min(num1,num2),num3);
        System.out.println("Минимальное число: "+min);
    }
    public static void zadacha3(Scanner input_) {
        for(int i=1;i<=10;i++){
            int number=i*5;
            System.out.println(number);
        }
    }
    public static void zadacha4(Scanner input_) {
        System.out.print("Введите число N: ");
        int summa=0;
        int N=input_.nextInt();
        for(int i=1;i<=N;i++){
            summa+=i;
        }
        System.out.println(summa);
    }
    public static void zadacha5(Scanner input_) {
        System.out.print("Введите число N: ");
        int first=0;
        int second=1;
        int N=input_.nextInt();
        System.out.println("Первые "+ N +" чисел Фибоначчи ");
        System.out.println(first+"\n"+ second);
        for(int i=2;i<N;i++){
            int next=first+second;
            first=second;
            second=next;
            System.out.println(next);
        }
    }
    public static void zadacha6(Scanner input_) {
        System.out.print("Введите число: ");
        int n;
        boolean flag=true;
        n = input_.nextInt();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                flag=false;
                break;
            }
        }
        if(!flag){
            System.out.println("Число "+n+" - не простое");
        }
        else{
            System.out.println("Число "+n+" -  простое");
        }
    }
    public static void zadacha7(Scanner input_) {
        System.out.print("Введите число N: ");
        int N=input_.nextInt();
        for(int i=N;i>=1;i--){
            System.out.println(i);
        }
    }
    public static void zadacha8(Scanner input_) {
        System.out.print("Введите число A и B: ");
        int summa=0;
        int A=input_.nextInt();
        int B=input_.nextInt();
        for(int i=A;i<=B;i++){
            if(i%2==0){
                summa+=i;
            }
        }
        System.out.println(summa);
    }
    public static void zadacha9(Scanner input_) {
        System.out.print("Введите слово: ");
        String str=input_.nextLine();
        System.out.println(new StringBuilder(str).reverse().toString());
    }
    public static void zadacha10(Scanner input_) {
        System.out.print("Введите число: ");
        int num=input_.nextInt();
        int count=1;
        while(num/10 > 0){
            count++;
            num=num/10;
        }
        System.out.print(count);
    }
    public static void zadacha11(Scanner input_) {
        System.out.print("Введите число: ");
        int num=input_.nextInt();
        int faktorial=1;
        for(int j=1;j<=num;j++){
            faktorial= faktorial * j;
        }
        System.out.print(faktorial);
    }
    public static void zadacha12(Scanner input_) {
        System.out.print("Введите число: ");
        int num=input_.nextInt();
        int summa=0;
        while(num > 0){
            summa += num%10;
            num/=10;
        }
        System.out.print(summa);
    }
    public static void zadacha13(Scanner input_) {
        System.out.print("Введите слово: ");
        String str=input_.nextLine();
        if(str.equals(new StringBuilder(str).reverse().toString())){
            System.out.print("Слово является палиднромом");
        }
        else{
            System.out.print("Слово не является палиднромом");
        }
    }
    public static void zadacha14(Scanner input_) {
        System.out.print("Введите размер массива: ");
        int N=input_.nextInt();
        int[] arr = new int[N];
        int max=0;
        System.out.print("Введите эл-ты массива: ");
        for(int i=0;i<N;i++){
            arr[i]=input_.nextInt();
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.print("Максимальный эл-т массива: "+ max);
    }
    public static void zadacha15(Scanner input_) {
        System.out.print("Введите размер массива: ");
        int N=input_.nextInt();
        int[] arr = new int[N];
        int summa=0;
        System.out.print("Введите эл-ты массива: ");
        for(int i=0;i<N;i++){
            arr[i]=input_.nextInt();
            summa+=arr[i];
        }
        System.out.print("Сумма эл-ов массива: "+ summa);
    }
    public static void zadacha16(Scanner input_) {
        System.out.print("Введите размер массива: ");
        int N=input_.nextInt();
        int[] arr = new int[N];
        int summa_Pol=0;
        int summa_Otr=0;
        System.out.print("Введите эл-ты массива: ");
        for(int i=0;i<N;i++){
            arr[i]=input_.nextInt();
            if(arr[i]>=0){
                summa_Pol+=arr[i];
            }
            else{
                summa_Otr+=arr[i];
            }
        }
        System.out.print("Сумма положительных эл-ов массива: "+ summa_Pol + "\n");
        System.out.print("Сумма отрицательных эл-ов массива: "+ summa_Otr);
    }
    public static void zadacha17(Scanner input_) {
        System.out.print("Введите число A и B: ");
        int A=input_.nextInt();
        int B=input_.nextInt();

        for (int i = A; i <= B; i++) {
            if (Prostoe(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static boolean Prostoe(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void zadacha18(Scanner input_){
        System.out.print("Введите слово: ");
        String str = input_.next();
        String lowerCaseInput = str.toLowerCase();

        int glasnieCount = 0;
        int soglasnieCount = 0;

        for (char c : lowerCaseInput.toCharArray()) {
            if (Glasnaya(c)) {
                glasnieCount++;
            } else if (Soglasnaya(c)) {
                soglasnieCount++;
            }
        }

        System.out.println("Количество гласных: " + glasnieCount);
        System.out.println("Количество согласных: " + soglasnieCount);
    }

    public static boolean Glasnaya(char c) {
        return "аеёиоуыэюя".indexOf(c) != -1;
    }

    public static boolean Soglasnaya(char c) {
        return "бвгджзйклмнпрстфхцчшщ".indexOf(c) != -1;
    }
    public static void zadacha19(Scanner input_){
        System.out.print("Введите слова: ");
        String str = input_.nextLine();
        String[] words = str.split(" ");
        System.out.print("Слова в обратном порядке: ");
        for(int i=words.length-1;i>=0;i--){
            System.out.print(words[i]+ " ");
        }
    }
    public static void zadacha20(Scanner input_){
        System.out.print("Введите число: ");
        int number = input_.nextInt();

        if (isArmstrong(number)) {
            System.out.println(number + " является числом Армстронга.");
        } else {
            System.out.println(number + " не является числом Армстронга.");
        }
    }
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int numberOfDigits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            number /= 10;
        }

        return sum == originalNumber;
    }
}