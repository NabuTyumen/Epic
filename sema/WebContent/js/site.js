function reloadSiteDFA(accountDfa){
		var process=true;var empty=false;var itv=0;
		$.ajax({
			type: "POST",
			url: "selSiteAction.do",
			data: { "action": "reload", "accountDfa":accountDfa },
			dataType:"json",
			error: function() { alert(errDfaRequest); },
			success: function(data){
				var x ="#rlo_"+data.accountDfa;
				$(x).find('img').prop('src','img/refresh.gif');
				 $.map(data.nbs,function(val,key){
					 var txt = "+"+val+newsites;
			        	$("#nb_"+key).text(txt);
			        });
				 process=false;
				 clearInterval(itv);
			  } 
			});
		
		$("#lst").css({height:"150px"}).show(100);
		
		itv = setInterval(function(){
			if(process){
				$.ajax({
					type: "POST",
					url: "selSiteAction.do",
					data: { "action": "counter"},
					dataType:"json",
					error: function() { alert(errCounterRequest); },
					success: function(data){
						if(data.inRequest==true && process){
							$("#nb_"+data.accountDfa).text(""+data.nbUploaded+ loadedsites);							
							$.each(data.lstsites,function(i,sit){
								$("#lst").prepend($("<p>").css({margin:"0 0 0 10px"}).text(sit.id+" "+sit.name));	
							});							
						}else if(process){
							if(data.inRequest==true && !empty){$("#lst").empty();empty=true;}
							$("#nb_"+data.accountDfa).text("" + eval(data.nbProcessed)+ "/"+eval(data.nbToProcess)+checkedsites);
							$.each(data.lstsites,function(i,sit){
								$("#lst").prepend($("<p>").css({margin:"0 0 0 10px"}).text(sit.id+" "+sit.name+" : "+sit.inStream ));		
							});
							
						}else{
							$("#lst").hide(300);	
							
						}														
					  } 
					});	
			}			
		},3000);

	}
//set les account dfa par défaut
function setdac(){
	var accountsDfa="";
	$('.accountsDfa').each(function(){
		if($(this).prop('checked')){
		accountsDfa += $(this).val() + ";";
		}
		});
		
		$.ajax({
			type: "POST",
		    url: 'selSiteAction.do',
		    data: {action:'setdac', accountsDfa:accountsDfa},
		    dataType: 'json',
		    error: function() { alert(errDfaRequest); },
		    success: function(data) {
		    	getdac();
		    }
		});
}

function getdac(){
	
		var accountsDfa="";
		$.ajax({
			type: "POST",
		    url: 'selSiteAction.do',
		    data: {action:'getdac'},
		    dataType: 'json',
		    error: function() { alert(errDfaRequest); },
		    success: function(data) {
	    		$('.accountsDfa').each(function(){
	    			$(this).prop('checked',false);		    		
	    		});	
	    		
		    	$.each(data.accountsDfa,function(i,a){		    		
		    		if(a.defaultChoice==true){
		    			$("#" + a.resKey).prop('checked',true);	
		    			accountsDfa += a.resKey + ";";
		    		}
		    		
		    		
				});
		    }
		});
		return accountsDfa;
}

	//construit le tableau des résultats de la recherche de site DFA  et implémente les evenement ajax clic sur chaque élément
	function loadX(){
		var action = "sD";
		var accountsDfa="";
		var rsId = 0;
		if($('#rsId')!=null) rsId=$('#rsId').text();
		
		$('.accountsDfa').each(function(){
			if($(this).prop('checked'))
			accountsDfa += $(this).val() + ";";
		});
		$.ajax({
			type: "POST",
		    url: 'selSiteAction.do',
		    data: {action:action, search: $('input[id="search"]').val(),accountsDfa:accountsDfa,rsId:rsId},
		    dataType: 'json',
		    success: function(data) {
		    	$('input[id="search"]').val(data.search);
		    	
		    	nssoc(data,rsId);
		    }
		});
	}
	//construit le tableau des résultats de la recherches de sites SPOT et implémente les evenement ajax clic sur chaque élément
	function loadSPOT(){	
		
			$.ajax({
				type: "POST",
			    url: 'selSiteAction.do',
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
			        $.each(data.supsSpot,function(i,sit){		        	
			        	elt = $('<div>').addClass('search_elt').appendTo(dfl);
			        	//class et image applicable au lien image des/exclude a
			        	if(sit.excludeDfaChoice==true){
			        		acl='adxs';sri='img/dart_ex.png';			        		
			        	}else if(sit.haveDfaChoice==true){
			        		acl='aexs';sri='img/dart_ok.png';			        		
			        	} else{
			        		acl='aexs';sri='img/dart_no.png';	
			        	}
			        	//lien image
			        	 $('<a>').prop({'id':'axs_'+sit.id}).addClass(acl).click(xs).append($('<img>').prop({'src':sri})).appendTo(elt);
			        	//libellé cliquable
			        	$('<span>').prop({'id':'sit_'+sit.id,'name':sit.formatedName}).addClass('search_elt_txt').click(se).text(sit.name).appendTo(elt);			        
			        });
			      
			      //événement au clic sur un site SPOT	: remplissage de la table des sites Dfa associés		      					
					$("#searsh_list").show(300);
			    }
			});		
	}
	//click sur un élément de la liste des support spot
	function se(){
		var rsId = $(this).prop('id').split("_")[1];
		
		$('#rsId').text(rsId);
		$('input[id="search_ipt"]').val($(this).prop("name"));
		//remplissage de la liste asso Dfa
		//recherche sur les comptes Dfa sélectionnés (si aucun : sites par défaut)
		var nb=0;var accountsDfa="";
		$('.accountsDfa').each(function(){
			if($(this).prop('checked')) {
				accountsDfa +=$(this).val() + ";";
				nb++;
			}
		});
		if(nb==0)  accountsDfa=getdac();
		$.ajax({
		type: "POST",
	    url: 'selSiteAction.do',
	    data: {action:'display', rsId: rsId,accountsDfa:accountsDfa},
	    dataType: 'json',
	    error: function() { alert(errDfaRequest); },
	    success: function(data) {
	    	$('input[id="search"]').val(data.search);
	    	assoc(data,rsId);
	    	nssoc(data,rsId);
	    	
	   	 if(data.support.excludeDfaChoice==true){
     		acl='adxs';sri='img/dart_ex.png';			        		
     	}else if(data.support.haveDfaChoice==true){
     		acl='aexs';sri='img/dart_ok.png';			        		
     	} else{
     		acl='aexs';sri='img/dart_no.png';	
     	}
	    	 $('#axs_'+rsId).attr('class',acl);
	    	 $('#axs_'+rsId).find('img').prop('src',sri);
	    }
	});

	}
	//sucess du exclude / desexclude site
	function xs(){
		var axs = $(this);
		var rsId=axs.prop('id').split("_")[1];
		var acl=axs.attr('class'); var sri=''; 
		$.ajax({					
			type: "POST",
		    url: 'selSiteAction.do',
		    data: {action:acl, rsId: rsId},
		    dataType: 'json',
		    error: function() { alert(errSpotRequest); },
		    success: function(data) {
		    	 if(data.supSpot.excludeDfaChoice==true){
	        		acl='adxs';sri='img/dart_ex.png';			        		
	        	}else if(data.supSpot.haveDfaChoice==true){
	        		acl='aexs';sri='img/dart_ok.png';			        		
	        	} else{
	        		acl='aexs';sri='img/dart_no.png';	
	        	}
		    	 	axs.attr('class',acl);
		    	 	axs.find('img').prop('src',sri);
		    	 	$('#sit_'+rsId).click();
		    }
		});
	}
	//construction de la table des assoc avec croix pour disso DFA		
	function assoc(data,rsId){				    	
    	$("#tb_assoc tr").remove();
        $('<tr>').addClass('campaignT').
        append($('<th>').text("")).
        append($('<th>').text("Id")).
        append($('<th>').text("Nom")).
        append($('<th>').text("Pays")).
        append($('<th>').text("Réseau")).
        append($('<th>').text("in-Stream")).appendTo('#tb_assoc');
        $.each(data.assoc,function(i,row){
        	var html = '<a href="#" id="dD_'+row.id+'" title="split"><img class="delete" alt="split" src="img/delete.png"/> </a>';
        	var td = $('<td>').css({'width': '15px'});
        	td.append($(html));
            $('<tr>').append(td).
          		append($('<td>').text(row.id)).
          		append($('<td>').text(row.name)).
          		append($('<td>').text(row.znAbv)).
          		append($('<td>').text(row.resKey)).
                append($('<td>').text(row.is)).appendTo('#tb_assoc');
        });
        //événement clic sur une croix
        $("[id^=dD_]").click(function() {	
			ad("dD", rsId, $(this).prop('id').split("_")[1]);
		});		
	}
	
	//construction de la table des campagnes disso avec cb pour asso DFA	
	function nssoc(data,rsId){
		$("#tb_nssoc tr").remove();
        $('<tr>').addClass('campaignT').
        append($('<th>').text("")).
        append($('<th>').text(siteId)).
        append($('<th>').text(siteName)).
        append($('<th>').text(country)).
        append($('<th>').text(network)).
        append($('<th>').text(siteIs)).appendTo('#tb_nssoc');
       
        $.each(data.nssoc,function(i,row){
        	var html = '<input type="checkbox" id="aD_'+row.id+'" title="link"/>';
        	var td = $('<td>').css({'width': '15px'});
        	td.append($(html));
            $('<tr>').append(td).
          		append($('<td>').text(row.id)).
                append($('<td>').text(row.name)).
                append($('<td>').text(row.znAbv)).
                append($('<td>').text(row.resKey)).
                append($('<td>').text(row.is)).appendTo('#tb_nssoc');
        });
        
        //evenement clic sur une cb
        $("[id^=aD_]").click(function() {
        	var action = ($(this).prop('checked')?"aD":"dD");
			ad(action, rsId, $(this).prop('id').split("_")[1]);
		});
	  
	}
		
	//action Ajax d'association ou dissociation d'un site Dfa à un site Spot
	function ad(action, rsId, dfaId){
		if(displayType!="a"){
			 alert(siteNotGranted);return;
		}
		var accountsDfa="";
		$('.accountsDfa').each(function(){
			if($(this).prop('checked'))
			accountsDfa += $(this).val() + ";";
		});

		$.ajax({
			type: "POST",
			url: "selSiteAction.do",
			data: { action: action, rsId:rsId, dfaId:dfaId,search: $('input[id="search"]').val(),accountsDfa:accountsDfa},
			dataType:"json",
			error: function() { alert(errDfaRequest); },
			success: function(data){	
				assoc(data, rsId);							
				nssoc(data, rsId);	
			  } 
			});
	}