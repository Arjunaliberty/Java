import javaClass.StorageWorkersBinary;
import javaClass.Worker;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {

        ArrayList<Worker> workersList = new ArrayList<>();
        ArrayList<Worker> searchworker = null;
        StorageWorkersBinary sw = new StorageWorkersBinary(workersList);

        sw.AddInfoWorker(new Worker(1, "Вася", "Хабибулин", 33, "Синэво", 10, 0));
        sw.AddInfoWorker(new Worker(2, "Рубик", "Габидзе", 46, "Синэво", 9, 0));
        sw.AddInfoWorker(new Worker(3, "Urka", "Gopstop", 22, "Синэво", 15, 0));

        Worker replaceWorker = sw.getWorkerList().get(2);

        sw.ChangeInfoWorker(replaceWorker, new Worker(3, "Kolya", "Gopstop", 18, "Синэво", 15, 0));





        //sw.RemoveInfoWorker(3);

        workersList = sw.getWorkerList();

        for (Worker worker : workersList) {
            System.out.println(worker.toString());
        }

        searchworker = sw.SearchSurnameWorker("Габидзе");
        for (Worker worker : searchworker) {
            if (!searchworker.isEmpty()) {
                System.out.println(worker.toString());
            }
        }
        if (searchworker.isEmpty()) System.out.println("В базе рабочих с такой фамилией нет.");
    }
}
