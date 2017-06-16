<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" charset="UTF-8" src="../js/jquery-3.2.1.js"></script>
<script>
	var getuser = function(userid){
		console.log(userid);
		$.get('./getuserbyid',{"fid":userid},function(data){
			console.log(data);
			$("#userlist tbody").empty();
			data.forEach(function(row,i){
				$("#userlist tbody").append("<tr><td>"+(i+1)+"</td><td>"+row.fid+"</td><td>"+(row.fname==null)+"</td><td>"+row.fage+"</td><td>"+row.fgender+"</td><td>"+row.fbirthday+"</td><td>"+row.fcreatetime+"</td></tr>");
			});
		});
		
	}
	
	function myclick(b){
		getuser($(b).prev().value);
		getuser($(this).prev().value)
	}

</script>
</head>
<body>
	<div>
		<input id="userid" name="userid"/>
		<button onclick="getuser($(this).prev().val())">获取用户信息</button>
		<table id="userlist" border="1" style="width: 100%;">
			<thead style="font-size: 16px;font-weight: bold;">
				<tr>
					<td>seq</td>
					<td>id</td>
					<td>name</td>
					<td>age</td>
					<td>gender</td>
					<td>birthday</td>
					<td>createtime</td>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
		
	</div>
</body>
</html>