<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="row" id="boardApp">
		<h3 class="text-center">Front �Խ���</h3>
			<table class="table">
			<tr>
				<td>
					<a href="../board/insert.do" class="btn btn-sm btn-primary">�� ��</a>
				</td>
			</tr>
			<tr>
				<td>
					<input type=text size=20 class="input-sm" v-model="message">
				</td>
			</tr>
			<tr>
				<td>
					<span>{{message}}</span>
				</td>
			</tr>
			</table>
			<table class="table">
			<tr>
				<th width="10%" class="text-center">��ȣ</th>
				<th width="45%" class="text-center">����</th>
				<th width="15%" class="text-center">�̸�</th>
				<th width="20%" class="text-center">�ۼ���</th>
				<th width="10%" class="text-center">��ȸ��</th>
			</tr>
			<tr v-for="vo in board_list">
				<td width="10%" class="text-center" v-text="vo.no"></td>
				<td width="45%" v-text="vo.subject"></td>
				<td width="15%" class="text-center" v-text="vo.name"></td>
				<td width="20%" class="text-center" v-text="vo.dbday"></td>
				<td width="10%" class="text-center" v-text="vo.hit"></td>
			</tr>
			<tr>
				<td colspan="5" class="text-center">
					<input type=button class="btn-sm btn-warning" value="����">
						{{curpage}} page / {{totalpage}} pages
					<input type=button class="btn-sm btn-warning" value="����">
				</td>
			</tr>
			</table>
	</div>
	<script>
		let boardApp=Vue.createApp({
			//�������
			data(){
				return{
					board_all:{},
					board_list:[],
					curpage:1,
					totalpage:0,
					message:''
				}
			},
			/*
				1. created() : Vue��ü ����
				2. mounted() : ������� �ʱ�ȭ
				3. updated() : ��������� �����Ͱ� ����
				4. destoryed() : ȭ���̵�/�޸� ����
			*/
			mounted(){
				//������ ����, ���� 
				axios.get('../board/list_vue.do',{
					params:{
						page:this.curpage
					}
				}).then(response=>{	
					//return�� ����
					console.log(response.data)
					this.board_all=response.data
					this.board_list=response.data.list
					this.curpage=response.data.curpage
					this.totalpage=response.data.totalpage
				})
			}
		}).mount('#boardApp')
	</script>
</body>
</html>