package javaClass;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;

/**
 * Класс - хранилище объктов типа Worker
 * в качестве базы данных использующий текстоый файл worker.xml
 */
public class StorageWorkersXML implements IStorageWorkers {

    private static final String separator = System.getProperty("file.separator");
    private static final String fileName = "worker.xml";
    private static final String directoryName = System.getProperty("user.dir") +
            separator + "src" + separator + "Storage" + separator +
            "main" + separator + "resourse" + separator;
    private ArrayList<Worker> workerList = null;

    /**
     * Конструктор без параметров
     */
    public StorageWorkersXML(){}

    /**
     * Конструктор
     * @param workerList Коллеуция типа ArrayList<Worker>
     */
    public StorageWorkersXML(ArrayList<Worker> workerList){
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

        try(FileReader file = new FileReader(directoryName + fileName)) {

            JAXBContext jaxb = JAXBContext.newInstance(Worker.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();

            //???
            //while (unmarshaller.){
                workerList.add((Worker)unmarshaller.unmarshal(file));
            //}
        }
        catch (JAXBException e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Загружает данные в файл из коллекции workerList
     */
    private void sendTo(){

        try(FileWriter file = new FileWriter(directoryName + fileName)){

            JAXBContext jaxb = JAXBContext.newInstance(Worker.class);
            Marshaller marshaller = jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //for (Worker worker : workerList) {
                marshaller.marshal(workerList, file);
            //}
        }
        catch (JAXBException e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
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

        StorageWorkersXML that = (StorageWorkersXML) o;

        return workerList != null ? workerList.equals(that.workerList) : that.workerList == null;
    }

    @Override
    public String toString() {
        return "StorageWorkersXML{" +
                "workerList=" + workerList +
                '}';
    }
}
