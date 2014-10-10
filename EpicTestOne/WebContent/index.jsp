<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>epic</title>
<link rel=stylesheet type="text/css" href="css/epic.css">
<link rel=stylesheet type="text/css" href="css/jquery-ui.css">
<script type="text/javascript" src="js/jquery-2.1.1.js"> </script>
<script type="text/javascript" src="js/jquery-ui.js"> </script>

<script>

$(function(){
	var btn=$("input[type=submit], a, button" ).button().click(load);
	var add=$('<img>').prop({src:'img/add.png'}).click(add);
	$("#uruk").append(btn);
	$("#uruk").append(add);
	
});
	
function load(){
	    	$.ajax({
				type: 'POST',
			    url: 'load',
			    data: { action: 'load'},
			    dataType: 'json',
			    success: function(data) {
					$("#uruk").empty();
					var table=$('<table>').prop({id:'taburuk'}).addClass('uruk');
					$("#uruk").append(table);
					var tr; var td;
					$.each(data.persons,function(i,p){
						tr=$('<tr>');
						tr.append($('<td>').text(p.id));
						tr.append($('<td>').append($('<input>').prop({id:'name_'+i}).val(p.name)));
						tr.append($('<td>').append($('<input>').prop({id:"_"+i,idp:p.id}).val(p.title)));
						tr.append($('<td>').append($('<img>').prop({src:'img/delete.png'}).click(del)));
						table.append(tr);
					});		      
			    }
			});
	}
	
	function del(){
		$.ajax({
			type: 'POST',
		    url: 'load',
		    data: { action: 'del',id:this.idp},
		    dataType: 'json',
		    success: function(data) {
				load;				        		      
		    }
		});
	}
	
	function add(){
		}
	
	function upd(){
		$.ajax({
			type: 'POST',
		    url: 'load',
		    data: { action: 'upd'},
		    dataType: 'json',
		    success: function(data) {
				load;				        		      
		    }
		});
	}
</script>

</head>
<body>
<div id="uruk">
<input type="submit" value="Edit characters">
</div>
<div id="epic"></div>
</body>
</html>