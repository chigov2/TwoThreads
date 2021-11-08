package techmarket.uno.thread.thread;

public class TwoThreads {
    static  boolean vin = false;
    public static void main(String[] args) {
        int random = (int) (Math.random() * 1000000000);
        System.out.println(random);
             // создаем первый поток
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    while(!vin){
                        System.out.println(i);
                        i++;
                       Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // создаем второй поток, который будет пытаться угадать число
        Thread player = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!vin) {
                    int guessNumber = (int) (Math.random() * 1000000000);
                    if (guessNumber == random)
                    {
                        vin = true;
                        System.out.println(guessNumber);
                    }
                }
            }
        });
        timer.start();
        player.start();
    }
}
