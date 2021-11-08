package techmarket.uno.thread.thread;

public class Main0 {
    static boolean isFive = false;

    public static void main(String[] args) {

        Thread timer = new Thread(new Runnable() {
            @Override//timer.start();
            public void run() {
                try {
                    int i = 0;
                    while (true) {
                        if (i == 5){
                            isFive = true;
                        }
                        System.out.println(i);
                        Thread.sleep(1000);
                        i++;
                    }
                } catch (Exception e) {
                }
            }
        });
        timer.start();

        Thread timer2 = new Thread(new Runnable() {
            @Override//timer.start();
            public void run() {
                try {
                    int i = 0;
                    while (!isFive) {
                        System.out.println(i);
                        Thread.sleep(1000);
                        i++;
                    }
                } catch (Exception e) {
                }
            }
        });
        timer2.start();
    }
}
