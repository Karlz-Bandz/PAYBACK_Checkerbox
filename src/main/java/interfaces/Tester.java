package interfaces;

public class Tester {
    public int[] arr = new int[10];



    public synchronized void latee(){
        for (int i = 0; i < 10; i++)
        {
            if(i%2 == 0)
                arr[i] = 1;
        }
    }
    public synchronized void asynce(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                {
                    arr[i] = i;
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                {
                    if(i%2 == 0)
                        arr[i] = 2;
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);

        thread2.start();
        thread1.start();
    }
}
