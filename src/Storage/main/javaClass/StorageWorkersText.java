package javaClass;

import java.util.regex.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Класс - хранилище объктов типа Worker
 * в качестве базы данных использующий текстоый файл worker.txt
 */
public class StorageWorkersText implements IStorageWorkers {

    private static final String separator = System.getProperty("file.separator");
    private static final String fileName = "worker.txt";
    private static final String directoryName = System.getProperty("user.dir") +
            separator + "src" + separator + "Storage" + separator +
            "main" + separator + "resourse" + separator;
    private ArrayList<Worker> workerList = null;

    /**
     * Конструктор
     * @param workerList Коллеуция типа ArrayList<Worker>
     */
    public StorageWorkersText(ArrayList<Worker> workerList){
        this.workerList = workerList;
    }

    /**
     * Проверяет существования файла в директории
     * и если его не существует, то создает
     */
    private void fileExist(){
        File file = new File(directoryName + fileName);

        try {
            if(!file.exists()) {
                file.createNewFile();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Загружает данные из файла в коллекцию workerList
     */
    private void loadFrom(){
        workerList = new ArrayList<>();

        try(FileReader fileReader = new FileReader(directoryName + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String stringBuffer = null;
            String[] parseArray = new String[7];

            while ((stringBuffer = bufferedReader.readLine()) != null){

                Pattern pattern = Pattern.compile("[^#]+");
                Matcher matcher = pattern.matcher(stringBuffer);
                int count = 0;

                while (matcher.find()){
                    parseArray[count] = matcher.group();
                   count++;
                    }
                workerList.add(new Worker(Integer.parseInt(parseArray[0]), parseArray[1], parseArray[2],
                                          Integer.parseInt(parseArray[3]), parseArray[4],
                                          Double.parseDouble(parseArray[5]),Double.parseDouble(parseArray[6])));
            }
        }
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Загружает данные в файл из коллекции workerList
     */
    private void sendTo(){

        try (FileWriter fileWriter = new FileWriter(directoryName + fileName)){
            for (Worker worker : workerList ) {
                fileWriter.write("#" + Integer.toString(worker.getId()));
                fileWriter.write("#" + worker.getName());
                fileWriter.write("#" + worker.getSurName());
                fileWriter.write("#" + Integer.toString(worker.getAge()));
                fileWriter.write("#" + worker.getDepartments());
                fileWriter.write("#" + Double.toString(worker.getSalary()));
                fileWriter.write("#" + Double.toString(worker.getPremium()));
                fileWriter.append('\n');
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Возвращает коллектцию типа List<Worker>
     * @return Коллекция типа List<Worker>
     */
    public ArrayList<Worker> getWorkerList() {
        return workerList;
    }

    /**
     * Добавляет нового рабочего в колеекцию workerList
     * @param worker Параметр типа Worker
     */
    @Override
    public void AddInfoWorker(Worker worker) {
        fileExist();
        workerList.add(worker);
        sendTo();
    }

    /**
     * Удаляет рабочего из колеекции workerList
     * @param id Идентификатор работника
     */
    @Override
    public void RemoveInfoWorker(int id) {
        // Удаляемый объект
        Worker delWorker = null;

        fileExist();
        loadFrom();
        for (Worker worker : workerList) {
            if(worker.getId() == id){
                delWorker = worker;
            }
        }
        if (delWorker != null) workerList.remove(delWorker);
        sendTo();
    }

    /**
     * Изменяет информацию о рабочем в коллекции workerList
     * @param initial Исходный объект типа Worker
     * @param replace Объект типа Worker на который необходимо заменить
     */
    @Override
    public void ChangeInfoWorker(Worker initial, Worker replace) {
        Worker replaceWorker = null;

        fileExist();
        loadFrom();
        for (Worker worker : workerList) {
            if (worker.equals(initial)) {
                replaceWorker = worker;
            }
        }
        if (replaceWorker != null){
            workerList.set(workerList.indexOf(replaceWorker), replace);
        }
        sendTo();
    }

    /**
     * Ищет в колеекции workerList работника по фамилии
     * @param findSurName Объек типа String с искомой фамилией
     * @return Список типа ArrayList<Worker> со всеми найденными совпадениями
     */
    @Override
    public ArrayList<Worker> SearchSurnameWorker(String findSurName) {
        // Коллекция для храннения найденных по фамилии рабочих
        ArrayList<Worker> searchWorker = new ArrayList<>();

        fileExist();
        loadFrom();

        for (Worker worker : workerList) {
            if (findSurName.equals(worker.getSurName())) {
                searchWorker.add(worker);
            }
        }

        return searchWorker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorageWorkersText that = (StorageWorkersText) o;

        return workerList != null ? workerList.equals(that.workerList) : that.workerList == null;
    }

    @Override
    public String toString() {
        return "StorageWorkersText{" +
                "workerList=" + workerList +
                '}';
    }
}
