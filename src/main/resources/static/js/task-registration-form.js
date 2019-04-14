/**
 *
 */

//登録フォームを出力する際の初期処理。
function init() {

    //datepickerを作成。
    $( function() {
        $("#date1").datepicker({
            dateFormat: "yy/mm/dd"
        });
      } );

      $( function() {
            $("#date2").datepicker({
                dateFormat: "yy/mm/dd"
            });
      } );
}

//ボタンクリック時にフォームを追加。
function addScheduleForm() {
    //datepickerを使うフォームのIDの連番。
    //既に2まで使用しているため、初期値は2。
    var idCount = 2;

    $('#add-form').click(function() {
        //idの連番をインクリメント。
        idCount++;

        //formを追加するボタンの要素を取得。
        var scheduleForm = document.getElementById("schedule-form");

        //最後の子要素を取得。
        var lastElement = scheduleForm.lastElementChild;

        var clone = lastElement.cloneNode(true);

        //各フォームの値をリセット。
        clone.childNodes[1].value = "";
        clone.childNodes[5].value = "";
        clone.childNodes[9].value = "";

        //新IDを作成。
        var newId = "date" + idCount;
        clone.childNodes[1].id = newId;

        scheduleForm.append(clone);

        //datepickerを再作成。
        //これをやらないとdatepickerが有効にならない。
        $('#' + newId).removeClass('hasDatepicker');
        $('#' + newId).datepicker({
            dateFormat: "yy/mm/dd"
        });
    });
}

// 締切日のバリデーション。
// 入力した締切日が今日より前の場合、NGとする。
function validateDeadLine() {
    // 締切日の要素。
    var deadLineElVal = document.getElementById('date1').value;

    // 締切日をDate型でインスタンス化する。
    var inputedDate = new Date(Number(deadLineElVal.substr(0, 4)),
            Number(deadLineElVal.substr(5, 2) - 1),
            Number(deadLineElVal.substr(8, 2)));

    // 今日の日時。
    var today = new Date();
    // 時刻を00:00:00にするために再度インスタンス化して時刻を設定し直す。
    var formattedToday = new Date(today.getFullYear(), today.getMonth(), today.getDate());

    // 登録ボタン
    var registerBtn = document.getElementById('register-task');

    if (inputedDate < formattedToday) {
        // 入力日付が今日より前の場合。
        window.alert('締切日には今日以降の日付を設定してください。');
        registerBtn.type = 'button';
    } else {
        registerBtn.type = 'submit';
    }
}


