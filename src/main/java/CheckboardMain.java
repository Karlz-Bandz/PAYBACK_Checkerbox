import interfaces.Tester;

public class CheckboardMain {
    public static void main(String[] args) {


        Tester tester = new Tester();
        tester.latee();
        tester.asynce();

        int[]myArr = tester.arr;

        for (int i = 0; i < 10; i++){
            System.out.println(myArr[i]);
        }
    }
}
