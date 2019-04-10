/**
 * タスク一覧画面に使用するjavascript
 */

function confirmDelete() {
    let result = window.confirm("タスクを削除します。よろしいですか。");

    // 削除ボタン要素。
    let taskElem = document.getElementById("del-btn");

    if (!result) {
        // キャンセルの場合、削除しない。

        taskElem.type = "button";
    } else {
        taskElem.type = "submit";
    }
}