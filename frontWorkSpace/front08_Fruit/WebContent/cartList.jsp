<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과일 장바구니....</title>
<link rel="stylesheet" type="text/css" href="css/basic.css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
	.poster{
		width: 200px;
		height: 150px;
	}
	input::-webkit-outer-spin-button,
	input::-webkit-inner-spin-button {
	  -webkit-appearance: none;
	  margin: 0;
	}
</style>
<script>
$(function() {
	
	refreshPage(); 
	
	$('#checked').bind('click', deleteCartStroage);
	
	
	$(document).on('click','#plus',function(){
		var key = $(this).parent().parent().children().eq(0).html(); // -> 이게 key
		key = '#'+key
		var newEa = parseInt($(key).val()) + 1
		$(key).val(newEa);
		
		var totalPrice =   parseInt($(price).html())  + parseInt($(this).parent().parent().children().eq(3).html())
		$('#price').html(totalPrice);
		
	});
	
	$(document).on('click','#minus',function(){
		var key = $(this).parent().parent().children().eq(0).html();
		key = '#'+key
		
		if($(key).val()=="1") return;
		
		var newEa = parseInt($(key).val()) - 1
		$(key).val(newEa);
		
		var totalPrice =   parseInt($(price).html())  - parseInt($(this).parent().parent().children().eq(3).html())
		$('#price').html(totalPrice);
	});
});

function minusPrice(){}


function calPrice(){
	refreshPage();
	
}

function refreshPage() {
	var html='';
	var html2='';
	var totalPrice = 0;
	
	//localStorage에서 저장된 모든 내용을 받아와서...아랫부분에 있는 table안에 적절한 위치에 출력...
	for(var key in localStorage){
		if(key=="length") break;
		
		var data = localStorage.getItem(key).split(",");
		
		html2 += '<tr><td>'+key+'</td><td><img class=poster src='+data[0]+'></td><td>'+
				data[1]+'</td><td>'+data[2]+'</td><td><input type="number" id="'+key+'" value="1" min = "1"><button id="plus">+</button><button id="minus">-</button></td><td><input type="checkbox" value='+key+'></td>';
		
		totalPrice += parseInt(data[2]);
		
		}	
		$('#content').html(html2);
		$('#price').html(totalPrice);
	}//

function deleteCartStroage(){
	var allCheck = $('input[type=checkbox]:checked') //.prop('checked');
	var flag = confirm("정말 삭제 하시겠습니까...?");
	
	if(flag){
		$.each(allCheck,(index,item)=>{
				localStorage.removeItem(item.value);
		});
	}
	refreshPage();
}

</script>
</head>
<body>
<div class="container">
    <div class="jumbotron  text-center">
		<h1>과일이 장바구니에 담겼어요~</h1>
	</div>
		<table class="table">
		    <thead class="thead-dark">
		      <tr id="tr">
		        <th>번호</th>
		        <th>상품이미지</th>
		        <th>상품명</th>
		        <th>상품가격</th>
		        <th>수량</th>
		        <th><button id="checked">삭제</button></th>
		      </tr>
		    </thead>
		    <tbody id="content">

		    </tbody>
		    <tfoot>
		    	<span>총 주문 가격:</span><span id="price"></span>
		    </tfoot>
		  </table>
		</div>
		
		
		<section class="link">
			<table   align="center">
			<tr><td align="center">
				<a href="itemList.do">쇼핑 계속하기</a> 
			</td></tr>
			</table>
		</section>
		</article>
</body>
</html>