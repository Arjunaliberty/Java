package javaClass;

import java.util.ArrayList;

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
    void ChangeInfoWorker(Worker worker, Worker replace);

    /**
     * Найти работника по фамилии
     */
    ArrayList<Worker> SearchSurnameWorker(String surName);
}
