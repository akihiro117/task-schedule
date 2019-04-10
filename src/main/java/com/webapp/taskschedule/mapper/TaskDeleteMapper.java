package com.webapp.taskschedule.mapper;

/**
 * タスクの削除機能を提供する。
 *
 */
public interface TaskDeleteMapper {
    /**
     * タスクをdeleteする。
     * @param 削除するタスクのID。
     */
    public void deleteATask(int taskId);
}
