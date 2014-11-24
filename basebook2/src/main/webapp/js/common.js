//삭제 버튼 클릭시

$(".btn_delete").click(function() {
	var a1 = $(this).attr("id").substr(1, 2);
	var i1 = $('#i' + a1).html().trim();
	$('#formid').val('No.' + a1 + ' id:' + i1);

	var u1 = $('#u' + a1).attr('src');

	$('#formurl').val(u1);

	var p1 = $('#p' + a1).html().trim();
	$('#formarea').val(p1);

	$('#formdata').attr('action', 'delete');

	$('#form_btn1').text('Delete');

	$('#formid').attr('readonly', true);
	$('#formarea').attr('readonly', true);
	$('#formurl').attr('readonly', true);

	var type = $('#formdata').attr('action');

	console.log(type);

})

$(".btn_update").click(function() {

	var a1 = $(this).attr("id").substr(1, 2);
	var i1 = $('#i' + a1).html().trim();
	$('#formid').val('No.' + a1 + ' id:' + i1);

	var u1 = $('#u' + a1).attr('src');
	$('#formurl').val(u1);

	var p1 = $('#p' + a1).html().trim();
	$('#formarea').val(p1);

	$('#formdata').attr('action', 'update');
	var type = $('#formdata').attr('action');

	$('#formdata').attr('action', 'update');

	$('#form_btn1').text('Update');

	$('#formid').attr('readonly', true);
	$('#formarea').attr('readonly', false);
	$('#formurl').attr('readonly', false);
})

$("#form_btn2").click(function() {

	$('#formdata').attr('action', 'add');
	$('#form_btn1').text('Write');
	$('#formid').attr('readonly', false);
	$('#formarea').attr('readonly', false);
	$('#formurl').attr('readonly', false);
	// $('#form_id').removeAttr('readonly');

})

$("#form_btn1").click(function() {

	if ($('#formarea').val().length == 0) {
		alert('내용을 입력해주세요!.');
		return false;
	}

	if ($('#formid').val().length == 0) {
		alert('아이디를 입력해주세요!');
		return false;
	}

	if ($('#formpassword').val().length == 0) {
		alert('비밀번호를 입력하세요!');
		return false;
	}

	if ($('#formdata').attr('action') == 'delete') {

		var num = $('#formid').val().substr(3, 3).trim();
		var password = $('#t' + num).attr('class');
		var inputpassword = $('#formpassword').val().trim();

		if (password != inputpassword) {
			alert('비밀번호가 틀렸습니다!');
			return false;
		}

	}

	if ($('#formdata').attr('action') == 'update') {
		var num = $('#formid').val().substr(3, 3).trim();
		var password = $('#t' + num).attr('class');
		var inputpassword = $('#formpassword').val().trim();

		if (password != inputpassword) {
			alert('비밀번호가 틀렸습니다!');
			return false;
		}
	}

})

$(".btn_like").click(function(){
    $.post("/",
    {
      name:"Donald Duck",
      city:"Duckburg"
    },
    function(data,status){
      alert("Data: " + data + "\nStatus: " + status);
    });
  });


/*
 * $('#btnAdd').click(function(){ if ( $('#name').val().length == 0) {
 * alert('제품명은 필수 입력 항목입니다.'); return false; }
 * 
 * if ( $('#qty').val().length == 0) { alert('수량은 필수 입력 항목입니다.'); return false; }
 * 
 * if ( $('#mkno').val().length == 0) { alert('제조사 번호는 필수 입력 항목입니다.'); return
 * false; }
 */

// i1= 아이디
// u1= url
// p1=내용
// t1=테이블..class 비번
