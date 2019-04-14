/**
 * 複数画面で共通に使用するjavascriptファイル。
 */

function initHeader(navId) {
    var navElHome = document.getElementById('nav-home');
    var navElTask = document.getElementById('nav-task');
    var navElRegister = document.getElementById('nav-register');

    // 全ての要素を非アクティブにする。
    navElHome.classList.remove('active');
    navElTask.classList.remove('active');
    navElRegister.classList.remove('active');

    var navEl = document.getElementById(navId);
    // 指定された要素をアクティブにする。
    navEl.classList.add('active');

}