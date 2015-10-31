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
		padding-left:20px;
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

.font-color {
	color: red;
}

.modify {
	font-size: 13px;
	color: purple;
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
			String fileName=request.getParameter("fileName");//将要显示的文件的名称
		//}
		%>


	<%
				int wordsNumber = 0;
			for (Customer customer : customers) {
				String sentence = customer.getMinwen();
				String[] word_lables =  sentence.split(" ");
		%>
	<div id='<%=customer.getId()%>' class='sentence'>
		<span class='sentenceSeq'>SentNO.<%=customer.getSentence_no()%>:&nbsp;&nbsp;</span>
		<%
				//for(String word_lable : word_lables){	
					//String word =null;
					//String lable= null;
					//if(word_lable.indexOf("/") != -1){
						//word = word_lable.split("/")[0];
						//lable = word_lable.split("/")[1];
					//}else{
						//continue;
					//}
					for(String word_lable : word_lables){	
					String word =null;
					String lable= null;
					if(word_lable.length()>0){
						if(word_lable.indexOf("/") != -1){
							word = word_lable.split("/")[0];
							lable = word_lable.split("/")[1];
						}else{
							word=word_lable;
							lable="";
							//continue;
						}
					}else{
						continue;
					}
					
		%>

		<span seq='<%=wordsNumber%>' class='seq'><span class='word'><%=word%></span>&nbsp;<span
			class='label'><%=lable%></span></span>

		<% 
			wordsNumber++;
			}
		%>
		<div class='modify' style='display: none'>
			<!-- <span class='input'>修改/添加标注：<input name='label' style='width: 100px' class='label-content'></span> -->
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span  class='input'>错词修改：<input name='wrong-return' style='width:100px' class='content'></span>
			&nbsp;&nbsp;
			<!-- <button sentenceNum='<%=customer.getId()%>' class='save'>save</button> -->
			<button sentenceNum='<%=customer.getId()%>' hanwen='<%=customer.getHanwen() %>' shuxone='<%=customer.getShuxone() %>' shuxtwo='<%=customer.getShuxtwo() %>' fileId='<%=customer.getFile_id() %>'sentence_no='<%=customer.getSentence_no() %>' class='save'>save</button>
		</div>
		</div>
	<%
		wordsNumber = 0;
	 }
	}
	%>
	<!-- <div><button class='submit'>save</button></div> -->
			<script type="text/javascript">
				$('.word').click(function() {
					$('.modify').css('display', 'none');
					$(this).parent('span').siblings().show();
					$('.word').removeClass('font-color');
					$(this).addClass('font-color');
					$('.label').removeClass('label-choosen');
					$(this).siblings('.label').addClass('label-choosen');
					$('.sentenceSeq').removeClass('sentenceSeqColor');
					$(this).parent().siblings('.sentenceSeq').addClass('sentenceSeqColor');
				});
				$('.content').keydown(function(event) {
					if (event.which == 13) {
						var input = $(this).val();
						$('.font-color').text(input);
					}
					;
				});
				$('.label-content').keydown(function(event) {
					if (event.which == 13) {
						var labelContent = $(this).val();
						$('.label-choosen').text(labelContent);
					}
					;
				});
				$('.save').click(function(){
					var sentenceNum=$(this).attr('sentenceNum');
					var sentences=$(this).parent().siblings('.seq');
					var shuxone=$(this).attr('shuxone');
					var shuxtwo=$(this).attr('shuxtwo');
					var hanwen=$(this).attr('hanwen');
					var file_id=$(this).attr('fileId');
					//var sentence;
					var finalSentence='';
					for (var i = 0; i < sentences.length; i++) {
						sentence=sentences[i];
						if(sentence.children[1].innerHTML==""){
							finalSentence+=sentence.children[0].innerHTML+' ';
						}else{
							finalSentence+=sentence.children[0].innerHTML+'/'+sentence.children[1].innerHTML+' ';
						}
					};
					//alert(finalSentence);
					finalSentence=encodeURI(encodeURI($.trim(finalSentence)));
					$.ajax({
						type:"POST",
						url:'add.do',
						data:{id:sentenceNum,minwen:finalSentence,hanwen:hanwen,shuxone:shuxone,shuxtwo:shuxtwo,sentence_no:sentence_no,file_id:file_id}
					});
				});
			</script>
			
</body>
</html>
