package javaClass;

import java.io.*;
import java.util.ArrayList;

public class StorageWorkersBinary implements IStorageWorkers {

    private static final String  separator = System.getProperty("file.separator");
    private static final String fileName = "worker.bin";
    private static final String directoryName = System.getProperty("user.dir") +
                                                separator + "src" + separator + "Storage" + separator +
                                                "main" + separator + "resourse" + separator;
    private static File directory = null;
    private ArrayList<Worker> workerList = null;

    /**
     * Конструктор
     */
    public StorageWorkersBinary(ArrayList<Worker> workerList){
        this.workerList = workerList;
    }

    public ArrayList<Worker> getWorkerList() {
        return workerList;
    }

    /**
     * Загружает данные из файла в коллекцию workerList
     */
    private void loadList(){
        workerList = new ArrayList<Worker>();

        try (FileInputStream fis = new FileInputStream(directoryName + fileName)){
            ObjectInputStream ois = new ObjectInputStream(fis);
             while (fis.available() > 0){
                 workerList.add((Worker)ois.readObject());
             }
            ois.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Занружает данные в файл из коллекции workerList
     */
    private void sendList(){

        try(FileOutputStream fos = new FileOutputStream(directoryName + fileName)) {

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Worker worker: workerList) {
                oos.writeObject(worker);
                oos.flush();
            }
            oos.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Проверяет существования файла в директории
     * и если его не существует, то создает
     */
    private void isFile(){
        directory = new File(directoryName + fileName);

        try {
            if (!directory.isFile()){
                directory.createNewFile();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Добавляет нового рабочего в колеекцию workerList
     */
    @Override
    public void AddInfoWorker(Worker worker) {
        isFile();
        workerList.add(worker);
        sendList();
    }

    /**
     * Удаляет рабочего из колеекции workerList
     */
    @Override
    public void RemoveInfoWorker(int id) {
        loadList();
        for (Worker worker : workerList) {
            if(worker.getId() == id){
                workerList.remove(worker);
            }
        }
        sendList();
    }

    /**
     * Изменяет информацию о рабочем в колеекции workerList
     */
    @Override
    public void ChangeInfoWorker() {

    }

    /**
     * Ищет в колеекции workerList работника по фамилии
     */
    @Override
    public void SearchSurnameWorker() {

    }
}
