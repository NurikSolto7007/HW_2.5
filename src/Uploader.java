import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread {
    CountDownLatch cdl;
    public Uploader(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        System.out.println("Загрузка файла на сервер");
        for (int i = 1; i <= 10; i++) {
            System.out.print(".");
            try {
                sleep(1000);

            } catch (InterruptedException e) {
                System.out.print(System.lineSeparator());
                e.printStackTrace();
            }try {
                sleep(1000);
                cdl.countDown();

            } catch (InterruptedException e) {
            }
        }
        System.out.println(" Загрузка завершенна ");
        super.run();


    }
}
