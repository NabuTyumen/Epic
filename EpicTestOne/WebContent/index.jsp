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
	$("#uruk").append($("input[type=submit], a, button" ).button().click(load));
});
	
function load(){
	    	$.ajax({
				type: 'GET',
			    url: 'load.html',
			    data: { action: 'load'},
			    dataType: 'json',
			    error: function(jqXHR, textStatus, errorThrown) {
			    	  console.log(textStatus, errorThrown);
			    	},
			    success: function(data) {
					$("#uruk").empty();
					var lst = data.persons;
					$("#uruk").append($('<table>').prop({id:'taburuk'}).addClass('uruk'));
					$('#taburuk').append($('<th>').text('Id')).append($('<th>').text('Name')).append($('<th>').text('Title')).append($('<th>').text('M/I')).append($('<th>').text('Gender'));
					if(lst.length == 0){
						add();
					}else{
						$.each(data.persons,function(i,p){
							buildLine(p.id,p.name,p.title,p.mortal,p.gender,lst);
						});	
						$("#uruk").append($('<img>').prop({src:'img/add.png'}).click(add));
					}
	
					
			    }
			});
	}
	
	function buildLine(id,name,title,mortal,gender,lst){
		var tr=$('<tr>');
		tr.append($('<td>').text(id));
		//name
		tr.append($('<td>').append($('<input>').addClass('uruk').prop({id:'name_'+id}).val(name).keydown(function (event){save(event);})));
		//title
		tr.append($('<td>').append($('<input>').addClass('uruk').prop({id:"title_"+id}).val(title).keydown(function (event){save(event);})));
		//mortal
		var select= $('<select>').addClass('uruk').prop({id:"mortal_"+id}).change(sel);
		select.append($('<option>').val('F').text('immortal'));
		select.append($('<option>').val('T').text('mortal'));
		select.val(mortal?'T':'F');
		tr.append($('<td>').append(select));
		//gender
		select= $('<select>').addClass('uruk').prop({id:"gender_"+id}).change(sel);
		select.append($('<option>').val('M').text('male'));
		select.append($('<option>').val('F').text('female'));
		select.val(gender);
		tr.append($('<td>').append(select));
		//parents
	
		
		tr.append($('<td>').append($('<img>').prop({id:"del_"+id,src:'img/delete.png'}).click(del)));
		$('#taburuk').append(tr);
	}
	
	function add(){
		buildLine(0,'','','F','M');
	}
	function sel(){
		upd(this.id)
	}
	function save(event){
		var fieldid=event.target.id
		if(event.keyCode == 13 || event.keyCode == 9){ 
			$('#'+fieldid).css('color','#0000FF');
			upd(fieldid)
		}else {
			$('#'+fieldid).css('color','#FF4000' );
		}
	}
	function upd(fieldid){
		if(fieldid==null) return false;

		var is= fieldid.split("_");
		var field=is[0];
		var id=is[1];
		var value = $('#'+fieldid).val();
		
		$.ajax({
			type: 'GET',
		    url: 'load.html',
		    data: {action:'upd',id:id,field:field,value:value},
		    dataType: 'json',
		    error: function(jqXHR, textStatus, errorThrown) {
		    	  console.log(textStatus, errorThrown);
		    	},
		    success: function(data) {
				load();				        		      
		    }
		});
	}
	
	function del(){
		$.ajax({
			type: 'GET',
		    url: 'load.html',	
		    data: {action:'del',id:this.id.split("_")[1]},
		    dataType: 'json',
		    error: function(jqXHR, textStatus, errorThrown) {
		    	  console.log(textStatus, errorThrown);
		    	},
		    success: function(data) {
		    	console.log('del ' + data.id);
				load();				        		      
		    }
		});
	}
	
	

</script>

</head>
<body>
<div id="uruk" class="tech">
<input type="submit" value="Edit characters">
</div>
<div id="epic">
<jsp:include page="epic.html"></jsp:include>
</div>
</body>
</html>