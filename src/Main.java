import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(10);
        CountDownLatch cdl2 = new CountDownLatch(10);
        Semaphore sem = new Semaphore(3);
        Uploader uploader = new Uploader(cdl);
        uploader.start();
        try {
            cdl.await();
            for (int i = 1; i <= 10; i++) {
                Downloader downloader = new Downloader(sem, cdl2, i);
                downloader.start();

            }
            cdl2.await();
            System.out.println("__________________________________");
            System.out.println("Загрузка невозможна так как файл удален с сервера");

        } catch (InterruptedException e) {

        }
    }
}
