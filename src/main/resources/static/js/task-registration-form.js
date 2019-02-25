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


