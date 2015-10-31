<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.cmli.correctivesystem.domain.Customer"%>
<%@page import="com.cmli.correctivesystem.file.FileNameId"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>article choice</title>
	<script type="text/javascript" src='js/jquery-1.11.3.min.js'></script>
</head>
<style>

	html,body{
		height: 100%;
		padding-top: 20px;
		background-color: #0A64A4;
		color: white;
	}
	.title{
		width: 50%;
		padding-top: 0px;
		font-weight: bold;
		margin: 0 auto;
		margin-bottom: 20px;
		border-radius: 5px;
		height: 80px;
		overflow: hidden;
	}
	.upload_div{
		width: 50%;
		padding-top: 0px;
		margin: 0 auto;
		margin-bottom: 5px;
		border-radius: 5px;
		overflow: hidden;
		
		height: 50px;
		
	}
	.upload_div span{
		background-color: #54407A;
		display: inline-block;
		height: 40px;
		/*border: 1px white solid;*/
		margin-top: 0px;
		float: left;
		line-height: 40px;
		text-align: center;
		margin-top: 5px;
		border-radius: 5px;
	}
	#fileNamePoi{
		//margin-left: 50px;
		width: 100px;
	}
	#fileName{
		margin-left: 10px;
		width: 500px;
	}
	#confirm{
		margin-left: 10px;
		width: 100px;
		cursor:pointer;
		float: right;
	}
	#uploadButton{
		margin-left: 10px;
		width: 200px;
		cursor:pointer;
	}

	#title-table{
		width: 100%;
		height: 100%;
		padding: 0px;
		border-collapse: collapse;
	}
	#title-table th{
		background-color: #D35400;
		font-size: 25px;
	}
	#title-table tr:first-child{
		height: 60%;
		width: 100%;
	}
	#title-table tr:last-child{
		height: 40%;
		width: 100%;
	}
	#title-table td,#title-table th{
		padding-top: 5px;
	}
	#title-table .space{
		padding: 0px;
		background-color: #D35400;
		width: 100%;
		height: 100%;
		display: inline-block;
		border-bottom-right-radius:5px;
	}
	#title-table tr:last-child td:last-child{
		background-color: #D35400;
		border-top:3px #0A64A4 solid;
		border-left:3px #0A64A4 solid;
		text-align: center;
		cursor: pointer;
	}
	
	#content{
		width: 50%;
		height: auto;
		margin: 0 auto;
		background-color: #398439;
		border-radius: 5px;
		margin-bottom: 20px;
	}
	#content th{
		font-size: 20px;
		padding: 5px 0;
		font-family:Microsoft YaHei;
		border-bottom:1px white solid;
	}
	#content tr {
		border:1px white solid;
	}
	#content td{
		cursor: pointer;
		padding: 5px 0;
		padding-left: 30px;
		font-family: 'Microsoft YaHei';
		width: 50%;
	}
	#content tr td:last-child{
		text-align: right;
		padding-right: 10px;
		font-size: 12px;
	}
	#content td:hover a{
		color: #0A64A4;
		font-size: 20px;
	}
	#content td a{
		color:white;
		text-decoration:none;
	}
	#hidden_table{
		width: 100%;
		height: 100%;
		display: hidden;
		float: left;
		z-index: 10;
	}
	#title-table span{
		border-bottom: 1px white solid;
	}
</style>
<body>
	<div class='title'>
		<table id="title-table">
			<tr> <th colspan='2'><span></span>----------------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择要进行操作的文章&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----------------</th></tr>
			<tr> <td width='70%' class='space'><span></span></td> <td width='20%' id='homePage'>返回主页</td></tr>
		</table>
	</div>
	<div class='upload_div'>
		<span id='fileNamePoi'>文件名：</span>
		<span id='fileName'></span>
		
		<span id='uploadButton'>上传txt文件</span>
		<span id='confirm'>确认</span>
		<form action="uploadFile.jsp?action=<%=request.getParameter("action")%>" method='post' id='upload_form' onsubmit='checkFile()' style='display:none' enctype="multipart/form-data">
			<input type="file" name='uploadFile' id='uploadFile'>
			<button id='submit'>提交</button>
		</form>
		<script>
		function checkFile(){

		}
		$('#homePage').click(function(){
			window.location.href="http://localhost:8080/correctivesystem/index.html";
		});
		$('#uploadButton').click(function(){
			$('#uploadFile').click();
		});
		$('#upload_form').change(function(){
			var fileName=$('#uploadFile').val();
			var stringLen=fileName.length;
			var fileType=fileName.substr(stringLen-4);
			if (fileType=='.txt') {
				$('#fileName').text($('#uploadFile').val());
			}else{
				alert('请上传txt文件');
			}
		});
		$('#confirm').click(function(){
			var fileName=$('#uploadFile').val();
			var stringLen=fileName.length;
			var fileType=fileName.substr(stringLen-4);
			if (fileType=='.txt') {
				$('#submit').click();
			}else{
				alert('请上传txt文件');
			}
			
		});
	</script>
	</div>
	<form action="" method='post'>
	<table id='content'>
		<tr style='border-bottom:1px white solid'>
			<th colspan='2'>文章列表</th>
		</tr>
		<%
			List<FileNameId> filesNameAndIds = (List<FileNameId>) request.getAttribute("filesNameAndIds");
				if (filesNameAndIds != null && filesNameAndIds.size() > 0) {
		%>
		<%
			int wordsNumber = 0;
			String action=request.getParameter("action");
			String hrefFile,hrefFileDownload;
			for (FileNameId nameAndId : filesNameAndIds) {
				String fileName = nameAndId.getFile_name();
				int fileId=nameAndId.getId();
				hrefFile=action+"?fileId="+fileId+"&fileName="+fileName;
				hrefFileDownload="download.do?fileName="+fileName+"&fileId="+fileId;
		%>
		<tr>
			<td><a href="<%=hrefFile%>"><%=fileName%></a></td>
			<td><a href="<%=hrefFileDownload%>" >下载</a></td>
		</tr>
		<%}
}%>
		<tr>
			<td></td>
		</tr>
	</table>
	</form>
</body>
</html>