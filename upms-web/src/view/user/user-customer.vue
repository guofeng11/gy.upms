<template>
	<div>
	<Tables :data="userData" :columns="userColumn" stripe="true">		
	</Tables>
	<div style="margin: 10px;overflow: hidden">		
	  <div style="float: right;">
	      <Page :total="100" :current="1" @on-change="changePage"></Page>
	  </div>
	</div>
	</div>
</template>

<script>
	import Tables from '_c/tables'
	export default {
		name: 'user_customer',
		components: {
			Tables
		},
		data: function() {
			return {
				userData : this.getData(),
				userColumn : [
					{ title : 'id' , key : 'id'},
					{ title : '用户名' , key : 'userName'},
					{ title : '性别' , key : 'sex'}
				]
			}
		},
		methods: {
			getData () {
				let data = []
				data.push({
					id : 1,
					userName : 'test',
					sex : 1
				})
			},
			changePage : function () {
				
			}
		}
	}
</script>

<style>
</style>
