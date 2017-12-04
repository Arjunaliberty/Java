package java;

public interface IStorageWorkers {

    /**
     * Добавить информацию о работнике
     */
    void AddInfoWorker();

    /**
     * Удалить информацию о работнике
     */
    void RemoveInfoWorker();

    /**
     * Изменить информацию о работнике
     */
    void ChangeInfoWorker();

    /**
     * Найти работника по фамилии
     */
    void SearchSurnameWorker();
}
