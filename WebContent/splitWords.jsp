<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.cmli.correctivesystem.domain.Customer"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<script type="text/javascript" src='js/jquery-1.11.3.min.js'></script>
</head>
<body>
<style type="text/css">
	body{
		padding-top:20px;
	}
.seq {
	display: inline-block;
	//border: 1px red solid;
	cursor: pointer;
	margin: 2px;
}

.label {
	//border: 1px blue solid;
	font-size: 10px;
	color: blue;
}

.word {
	//border: 1px purple solid;
	border-bottom: :1px blue dotted;
}


.choosen{}
.modify {
	font-size: 13px;
	color: purple;
}
.sentence{
	cursor: pointer;
	display:inline-block;
	height:20px;
	overflow:hidden;
	width:90%
}
.content{
	width:80%;
}
.content-block{
	display:none;
	color:#E55F5F;
}
.sentence-block{
	margin-left:20px;
	margin-top:10px;
}
.sentenceSeq{
	font-size:20px;
	display:inline-block;
	height:20px;
	color:#3399FF;
}
.font-color,.sentenceSeqColor {
	color: #E55F5F;
}
.sentenceSeqColor{
	font-size:25px;
}
</style>
	<%
		List<Customer> customers = (List<Customer>) request.getAttribute("customers");
		if (customers != null && customers.size() > 0) {
		%>


	<%
				int wordsNumber = 0;
			for (Customer customer : customers) {
				String sentence = customer.getMinwen();
				String[] word_lables =  sentence.split(" ");
		%>
	<div id='<%=customer.getId()%>' class='sentence-block'>
		<span class='sentenceSeq'>SentNO.<%=customer.getId()%>:&nbsp;&nbsp;</span></span><span class='sentence'><%=sentence%></span>
		<div class='content-block'>
			&nbsp;&nbsp;&nbsp;&nbsp;正确的分词：<input type="text" name='content' class='content'>
			<button sentenceNum='<%=customer.getId()%>' hanwen='<%=customer.getHanwen() %>' shuxone='<%=customer.getShuxone() %>' shuxtwo='<%=customer.getShuxtwo() %>' class='save'>save</button>

		</div>
	</div>
	<%
	 }
	}
	%>
	<!-- <div><button class='submit'>save</button></div> -->
			<script type="text/javascript">
				$('.sentence').click(function() {
					$('.sentence').removeClass('font-color');
					$(this).addClass('font-color');
					$('.sentenceSeq').removeClass('sentenceSeqColor');
					$(this).siblings('.sentenceSeq').addClass('sentenceSeqColor');
					$('.content-block').css('display','none');
					$(this).siblings('.content-block').show();
					var rawSentence=$(this).text();
					$(this).siblings('.content-block').children('.content').val(rawSentence);
				});
				$('.content').keydown(function(event) {
					if (event.which == 13) {
						var input = $(this).val();
						$('.font-color').text(input);
						//alert($('.font-color').text());
					}
					;
				});
				$('.save').click(function(){
					var finalSentence=$('.font-color').text();
					var sentenceNum=$(this).attr('sentenceNum');
					var shuxone=$(this).attr('shuxone');
					var shuxtwo=$(this).attr('shuxtwo');
					var hanwen=$(this).attr('hanwen');
					finalSentence=encodeURI(encodeURI($.trim(finalSentence)));
					//alert(finalSentence);
					 $.ajax({
					 	type:"POST",
					 	url:'add.do',
					 	data:{id:sentenceNum,minwen:finalSentence,hanwen:hanwen,shuxone:shuxone,shuxtwo:shuxtwo}
					 });
				});
			</script>
			
</body>
</html>
