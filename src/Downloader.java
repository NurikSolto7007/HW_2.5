import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloader extends Thread {
    Semaphore sm;
    CountDownLatch cdl2;
    int id;
    int dataSize=500;
    int downloadSpeed=100;

    public Downloader(Semaphore sm, CountDownLatch cdl2, int id) {
        this.sm = sm;
        this.id = id;
        this.cdl2 = cdl2;
    }
    @Override
    public void run() {
        try {
            sm.acquire();
        } catch (InterruptedException e) { }
        System.out.print(System.lineSeparator());
        System.out.println("Пользователь № " + id + " начал загрузку ");
        try {
            sleep(dataSize/downloadSpeed*1000);
        } catch (InterruptedException e) {

        }
        System.out.println("Пользователь № " + id + "  уже загрузил файл ");
        try {
            sleep(dataSize/downloadSpeed*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sm.release();
        cdl2.countDown();
        super.run();
    }
}
