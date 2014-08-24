<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" type="text/css" href="<s:url value='/page/static/js/flexigrid/flexigrid.pack.css' />" /> 
<script type="text/javascript" src="<s:url value="/page/static/js/flexigrid/flexigrid.pack.js"/>"></script>
<table class="flexme3" style="display: none"></table>
<script type="text/javascript">
$("#flex1").flexigrid({
	url: "<s:url value='/user/ajaxQueryUserList' />",
	dataType: 'json',
	colModel : [
		{display: 'ISO', name : 'iso', width : 40, sortable : true, align: 'center'},
		{display: 'Name', name : 'name', width : 180, sortable : true, align: 'left'},
		{display: 'Printable Name', name : 'printable_name', width : 120, sortable : true, align: 'left'},
		{display: 'ISO3', name : 'iso3', width : 130, sortable : true, align: 'left', hide: true},
		{display: 'Number Code', name : 'numcode', width : 80, sortable : true, align: 'right'}
		],
	buttons : [
		{name: 'Add', bclass: 'add', onpress : test},
		{name: 'Delete', bclass: 'delete', onpress : test},
		{separator: true}
		],
	searchitems : [
		{display: 'ISO', name : 'iso'},
		{display: 'Name', name : 'name', isdefault: true}
		],
	sortname: "iso",
	sortorder: "asc",
	usepager: true,
	title: 'Countries',
	useRp: true,
	rp: 15,
	showTableToggleBtn: true,
	width: 700,
	height: 200
});   

function test(com, grid) {
	if (com == 'Delete') {
		confirm('Delete ' + $('.trSelected', grid).length + ' items?')
	} else if (com == 'Add') {
		alert('Add New Item');
	}
}
</script>