	//construit le tableau des résusultats de la recherche de format IAB  et implémente les evenement ajax clic sur chaque élément
	function loadX(){
		var fmtId = 0;
		if($('#fmtId')!=null) fmtId=$('#fmtId').text();
		$.ajax({
			type: "POST",
		    url: 'selFormatAction.do',
		    data: {action:"sD", search: $('input[id="search"]').val(),fmtId:fmtId},
		    dataType: 'json',
		    success: function(data) {
		    	$('input[id="search"]').val(data.search);		    	
		    	nssoc(data,fmtId);
		    }
		});
	}
	
	function formX(){
		closeX();
		$('#table_X').after($('<table>').addClass('form').prop({id:'form_X'}).append($('<tr>').append($('<td>').append($('<input>').prop({'type':'text', id:'ipt_X_abv'}).addClass('box_input').css({width:'35px'}))).append($('<td>').append($('<input>').prop({'type':'text', id:'ipt_X_name'}).addClass('box_input').css({width:'240px'}))).append($('<td>').append($('<a>').prop({href:"#"}).click(addX).text(add))).append($('<td>').append($('<a>').prop({href:"#"}).click(closeX).text(close)))));
	}
	
	function closeX(){
		$(".form").remove();
	}
	function addX(){
		$.ajax({
			type: "POST",
		    url: 'selFormatAction.do',
		    data: {action:"addX", abva: $('input[id="ipt_X_abv"]').val(), namea: $('input[id="ipt_X_name"]').val()},
		    dataType: 'json',
		    success: function(data) {   
		    	nssoc(data,fmtId);
		    }
		});
	}
	function delX(){
		var abva = $(this).prop('id').split("_")[1];
		if(confirm(confirmDelFrmt + abva)){			
			$.ajax({
				type: "POST",
			    url: 'selFormatAction.do',
			    data: {action:"delX", abva: abva, fmtId:$('#fmtId').text()},
			    dataType: 'json',
			    success: function(data) {   
			    	nssoc(data,fmtId);
			    }
			});	
		}
		
	}
	//construit le tableau des résultats de la recherches de formats SPOT et implémente les evenement ajax clic sur chaque élément
	function loadSPOT(){			
			$.ajax({
				type: "POST",
			    url: 'selFormatAction.do',
			    data: {action:'search', search: $('input[id="search_ipt"]').val()},
			    dataType: 'json',
			    success: function(data) {
			    	$('input[id="search_ipt"]').val(data.search);			    	
			    	//bouton fermer
			    	$('#td_close').empty();
					$('<a>').addClass('aclose').prop('id','search_close').click(function(){$('#searsh_list').hide(300);}).append($('<img>').prop('src','img/close.png' ).addClass('imgclose')).appendTo('#td_close');
			    	//remplissage de la liste des résultats de la recherche site SPOT
			    	$('#searsh_list').empty();
			    	var dfl = $('<div>').prop('id','search_dflong').appendTo('#searsh_list');
			    	var acl='';var sri='';var elt;
			        $.each(data.fmtSpot,function(i,fmt){		        	
			        	elt = $('<div>').prop({'id':'fmt_'+fmt.id,'name':fmt.formatedName}).addClass('search_elt').click(se).appendTo(dfl);
			        	//class et image applicable au lien image des/exclude a
			        	if(fmt.excludeTypeChoice==true){
			        		acl='aiaxs';sri='img/iab_ex.png';			        		
			        	}else if(fmt.haveTypeCrea==true){
			        		acl='aiexs';sri='img/iab_ok.png';			        		
			        	} else{
			        		acl='aiexs';sri='img/iab_no.png';	
			        	}
			        	//lien image
			        	$('<div>').addClass('search_elt_txt').append($('<a>').prop({'id':'axs_'+fmt.id}).addClass(acl).click(xs).append($('<img>').prop({'src':sri}))).appendTo(elt);
			        	//libellé cliquable
			        	$('<div>').css({color:'#C0C0C0',width:'40px'}).addClass('search_elt_txt').text(fmt.id).appendTo(elt);
			        	$('<div>').addClass('search_elt_txt').text(fmt.famille).appendTo(elt);
			        	$('<div>').addClass('search_elt_txt').text(fmt.name).appendTo(elt);
			        	$('<div>').addClass('search_elt_txt').text(fmt.dimension).appendTo(elt);
			        	
			        });
			      
			      //événement au clic sur un site SPOT	: remplissage de la table des sites Dfa associés		      					
					$("#searsh_list").show(300);
			    }
			});		
	}
	//clic sur un élément de la liste des formats spot
	function se(){
		var fmtId = $(this).prop('id').split("_")[1];
		$('#fmtId').text(fmtId);
		$('input[id="search_ipt"]').val($(this).prop("name"));
		//remplissage de la liste asso IAB
					
		$.ajax({		
		type: "POST",
	    url: 'selFormatAction.do',
	    data: {action:'display', fmtId: fmtId},
	    dataType: 'json',
	    error: function() { alert(errSpotRequest); },
	    success: function(data) {
	    	$('input[id="search"]').val(data.search);
	    	assoc(data,fmtId);
	    	nssoc(data,fmtId);
	    	
	    	if(data.format.excludeTypeChoice==true){
        		acl='aiaxs';sri='img/iab_ex.png';			        		
        	}else if(data.format.haveTypeCrea==true){
        		acl='aiexs';sri='img/iab_ok.png';			        		
        	} else{
        		acl='aiexs';sri='img/iab_no.png';	
        	}
	    	 $('#axs_'+fmtId).attr('class',acl);
	    	 $('#axs_'+fmtId).find('img').prop('src',sri);
	    }
	});

	}
	//sucess du exclude / desexclude format
	function xs(){
		var axs = $(this);
		var fmtId = axs.prop('id').split("_")[1];
		var acl=axs.attr('class'); var sri='';		
		$.ajax({					
			type: "POST",
		    url: 'selFormatAction.do',
		    data: {action:acl, fmtId: fmtId},
		    dataType: 'json',
		    error: function() { alert(errSpotRequest); },
		    success: function(data) {
		    	
		    	if(data.format.excludeTypeChoice==true){
	        		acl='aiaxs';sri='img/iab_ex.png';			        		
	        	}else if(data.format.haveTypeCrea==true){
	        		acl='aiexs';sri='img/iab_ok.png';			        		
	        	} else{
	        		acl='aiexs';sri='img/iab_no.png';	
	        	}
		    	 	axs.attr('class',acl);
		    	 	axs.find('img').prop('src',sri);
		    	 	$('#sit_'+fmtId).click();
		    }
		});
	}
	//construction de la table des assoc avec croix pour disso IAB		
	function assoc(data,fmtId){				    	
    	$("#tb_assoc tr").remove();
        $('<tr>').addClass('campaignT').
        append($('<th>').text("")).
        append($('<th>').text("Abv")).
        append($('<th>').text("Nom")).appendTo('#tb_assoc');
        $.each(data.assoc,function(i,row){
        	if(!row.isEmpty){        		
        		var a = $('<a>').prop({id:'dD_'+row.abv,href:'#',title:'split'}).append($('<img>').addClass('delete').prop({src:'img/delete.png',alt:'split'}));
                $('<tr>').append($('<td>').css({'width': '15px'}).append(a)).
              		append($('<td>').text(row.abv)).
                    append($('<td>').text(row.name)).appendTo('#tb_assoc');	
        	}        	
        });
        //événement clic sur une croix
        $("[id^=dD_]").click(function() {	
			ad("dD", fmtId, $(this).prop('id').split("_")[1]);
		});		
	}
	
	//construction de la table des formats IAB non associés avec cb pour asso IA et delete cross
	function nssoc(data,fmtId){
		$("#tb_nssoc tr").remove();
		if(displayType=="a"){
			$('<tr>').addClass('campaignT').        
	        append($('<th>').text("Link")).
	        append($('<th>').text("Delete")).
	        append($('<th>').text("Abv")).
	        append($('<th>').text("Nom")).appendTo('#tb_nssoc');	
		}else{
			$('<tr>').addClass('campaignT').        
	        append($('<th>').text("Abv")).
	        append($('<th>').text("Nom")).appendTo('#tb_nssoc');	
		}
        
       
        $.each(data.nssoc,function(i,row){        	
        	if(displayType=="a"){
        		var ipt=$('<input>').prop({type:'checkbox',id:'aD_'+row.abv,title:'link'});
            	var a = $('<a>').prop({id:'delX_'+row.abv,href:'#',title:'Delete format IAB'}).append($('<img>').addClass('delete').prop({src:'img/delete.png',alt:'delete'}));
                $('<tr>').append($('<td>').css({'width': '15px'}).append(ipt)).
                append($('<td>').css({'width': '15px'}).append(a)).
              		append($('<td>').css({width:'35px'}).text(row.abv)).
                    append($('<td>').css({width:'245px'}).text(row.name)).appendTo('#tb_nssoc');		
        	}else{
        		 $('<tr>').append($('<td>').css({width:'35px'}).text(row.abv)).
                     append($('<td>').css({width:'255px'}).text(row.name)).appendTo('#tb_nssoc');	
        	}
        
        });
        
        //evenement clic sur une cb
        $("[id^=aD_]").click(function() {
        	var action = ($(this).prop('checked')?"aD":"dD");
			ad(action, fmtId, $(this).prop('id').split("_")[1]);
		});
        //clic sur un croix rouge (suppression d'un format IAB)
        $("[id^=delX_]").click(delX);
	}
		
	//action Ajax d'association ou dissociation d'un site Dfa à un site Spot
	function ad(action, fmtId, abva){
		if(displayType!="a"){
			 alert(notGranted);return;
		}

		$.ajax({
			type: "POST",
			url: "selFormatAction.do",
			data: { action: action, fmtId:fmtId, abva:abva,search: $('input[id="search"]').val()},
			dataType:"json",
			error: function() { alert(errRequestUpd); },
			success: function(data){	
				assoc(data, fmtId);							
				nssoc(data, fmtId);	
			  } 
			});
	}