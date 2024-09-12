<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{margin-top: 50px}
.row{margin: 0px auto; width:600px;}
#chatArea{height: 500px; overflow: auto;/* �ڵ���ũ�� */ border: 1px solid black;}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<script type="text/javascript">
let websocket;
let name;
function connection(){
	name=$('#name').val()
	if(name.trim()===""){
		alert("�̸��� �Է��ϼ���")
		$('#name').focus()
		return
	}
	websocket=new Websocket("wd://localhost:8080/web/chat/chat-ws")
	websocket.onopen=onOpen
	websocket.onclose=onClose
	websocket.onmessage=onMassage
	
}	
function onOpen(event){
	alert("ä�� ������ ����Ǿ����ϴ�")
}
function onClose(event){
	alert("ä�� ������ ������ ���ᰡ �Ǿ����ϴ�")	
}
function onMessage(event){
	let data=event.data;
	if(data.substring(0,4)==="msg:"){
		appendMessage(data.substring(4))
	}
}
function appendMessage(msg){
	$('#recvMsg').append(msg+"<br>")
	let ch=$('#chatArea').height()
	let m=$('#recvMsg').height()-ch
	$('#chatArea').scrollTop(m)
}
function send(){
	let msg=$('#sendMsg').val()
	if(msg.trim()===""){
		$('#sendMsg').focus()
		return
	}
	websocket.send('msg:['+name+']'+msg)
	$('#sendMsg').val("")
	$('#sendMsg').focus()
}

$(function(){
	$('#inputBtn').click(function(){
		connection();
	})
	$('#outputBtn').click(function(){
		websocket.clost();
	})
	$('#sendBtn').click(function(){
		send()
	})
})
</script>
</head>
<body>
	<div class="container">
		<h1 class="text-center">�ǽð� ������ ä��</h1>
		<div class="row">
			<table class="table">
			<tr>
				<td>
					<input type=text id="name" size="20" class="input-sm">
					<input type=button value="����" class="btn btn-sm btn-primary" id="inputBtn">
					<input type=button value="����" class="btn btn-sm btn-primary" id="outputBtn">
				</td>
			</tr>
			<tr>
				<td>
					<div id="charArea">
						<div id="recvMsg">#</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="sendMsg" size="75" class="input-sm">
					<input type=button value="����" class="btn btn-sm btn-primary" id="sendBtns">
				</td>
			</tr>
			</table>
		</div>
	</div>
</body>
</html>
