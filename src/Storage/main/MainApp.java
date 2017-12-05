import javaClass.StorageWorkersBinary;
import javaClass.Worker;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {

        ArrayList<Worker> workersList = new ArrayList<>();
        StorageWorkersBinary sw = new StorageWorkersBinary(workersList);

        sw.AddInfoWorker(new Worker(1, "Вася", "Хабибулин", 33, "Синэво", 10, 0));
        sw.AddInfoWorker(new Worker(2, "Рубик", "Габидзе", 46, "Синэво", 9, 0));
        sw.AddInfoWorker(new Worker(3, "Urka", "Gopstop", 22, "Синэво", 15, 0));

        sw.RemoveInfoWorker(3);
    }
}
