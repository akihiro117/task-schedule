/**
 *
 */

function addScheduleForm() {
	//formを追加するボタンの要素を取得。
	var buttonElem = document.getElementById("add-form");
	buttonElem.addEventListener("click", function() {
		var scheduleForm = document.getElementById("schedule-form");

		var lastElement = scheduleForm.lastElementChild; 
		
		var clone = lastElement.cloneNode(true);

		scheduleForm.append(clone);

    });

}
