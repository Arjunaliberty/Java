package javaClass;

public interface IStorageWorkers {

    /**
     * Добавить информацию о работнике
     */
    void AddInfoWorker(Worker worker);

    /**
     * Удалить информацию о работнике
     */
    void RemoveInfoWorker(int id);

    /**
     * Изменить информацию о работнике
     */
    void ChangeInfoWorker();

    /**
     * Найти работника по фамилии
     */
    void SearchSurnameWorker();
}
