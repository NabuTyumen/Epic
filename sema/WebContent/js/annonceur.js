function dispcontact() {
			 if($(this).prop("checked")){
				 $.ajax({
						type: "POST",
					    url: 'selAction.do',
					    data: { action: "contacts", ancId:$("#ancId").val()},
					    dataType: 'json',
					    success: function(data) {
					    	//table des contacts associés à l'annonceur
							$("#divContactsDisplay").empty();
					    	var tb = $('<table>');
					    	tb.addClass('campaignT');
					    	tb.appendTo("#divContactsDisplay");
					    	
					        $('<tr>').addClass('campaignT').
					        append($('<td>').text("Id")).
					        append($('<td>').text("Nom")).
					        append($('<td>').text("Type")).
					        append($('<td>').text("Pôle")).
					        append($('<td>').text("Niv.alerte")).appendTo(tb);
					        $.each(data.contacts,function(i,row){
					            $('<tr>').
					          		append($('<td>').text(row.id00)).
					                append($('<td>').text(row.formatedName)).
					                append($('<td>').text(row.typeLong)).
					                append($('<td>').text(row.pole)).					                
					                append($('<td>').text(row.alertLb).addClass("alert" + row.alert)).appendTo(tb);
					        });	        		      
					    }
					});
			 } else {
				 $("#divContactsDisplay").empty();
			 }    	
		}

function searchDFA(){
		$.ajax({
			type: "POST",
		    url: 'selAction.do',
		    data: { action: "sD", search:$("#searchDFA").val()},
		    dataType: 'json',
		    success: function(data) {
		    	//table des campagnes disso avec cb pour asso DFA
				$("#tb_nssocDfa tr").remove();
				$('<tr>').addClass('campaignT').
		        append($('<td>').text("")).
		        append($('<td>').text("Id")).
		        append($('<td>').css({'width': '300px'}).text("Name")).
		        append($('<td>').text("Network")).
		        append($('<td>').text("approved")).appendTo('#tb_nssocDfa');
		       var color_value;var html="";var td;
		        $.each(data.nssocDfa,function(i,row){
		         	color_value = row.approved?"green":"red";
		        	html = '<input type="checkbox" id="aD_'+row.id+'" title="associer"/>';
		        	td = $('<td>').css({'width': '15px'});
		        	td.append($(html));
		            $('<tr>').append(td).
		          		append($('<td>').text(row.id)).
		                append($('<td>').text(row.name)).
		                append($('<td>').text(row.resKey)).
		                append($('<td>').css({color:color_value}).text(row.approved)).appendTo('#tb_nssocDfa');
		        });
		        
		        $("[id^=aD_]").click(function() {
		        	var action = ($(this).prop('checked')?"aD":"dD");
					adDfa(action, $("#ancId").val(), $(this).prop('id').split("_")[1]);
				});			        		      
		    }
		});
		
	}

function zearchDFA (){
	 if($(this).prop("id")=="zlo_adv")  $("#zlo_adv_cb").prop('checked',true );
	 
	 if($("#zlo_adv_cb").prop('checked')) {
		 $("#zlo_adv").find('img').prop('src','img/refresh_anim.gif');
	 }
	 $.ajax({
			type: "POST",
		    url: 'selAction.do',
		    data: { action: "zD", "resKey":$("#resKey_DFA_sel").val(),search:$("#zearchDFA").val(),"refresh":$("#zlo_adv_cb").prop('checked')},
		    dataType: 'json',
		    success: function(data) {
		    	 $("#zlo_adv").find('img').prop('src','img/refresh.gif');
		    	//table des campagnes disso sans cb pour asso DFA
				$("#tb_zssocDfa tr").remove();
		        $('<tr>').addClass('campaignT').
		        append($('<td>').text("Id")).
		        append($('<td>').text("Nom")).
		        append($('<td>').text("Réseau")).
		        append($('<td>').text("approved")).appendTo('#tb_zssocDfa');
		       
		        $.each(data.zssocDfa,function(i,row){
		            $('<tr>').append($('<td>').text(row.id)).
		                append($('<td>').text(row.name)).
		                append($('<td>').text(row.resKey)).
		                append($('<td>').text(row.approved)).appendTo('#tb_zssocDfa');
		        });	        		      
		    }
		});
	 }
	 
	function searchSPOT(){
		$.ajax({
			type: "POST",
		    url: 'selAction.do',
		    data: { action: "sS", search:$("#searchSPOT").val()},
		    dataType: 'json',
		    success: function(data) {
		    	
		    	//table des campagnes disso avec cb pour asso SPOT
				$("#tb_nssocSpot tr").remove();
		        $('<tr>').addClass('campaignT').
		        append($('<td>').text("")).
		        append($('<td>').text("Id")).
		        append($('<td>').text("Nom")).appendTo('#tb_nssocSpot');
		       
		        $.each(data.nssocSpot,function(i,row){
		        	var html = '<input type="checkbox" id="aS_'+row.id+'" title="associer"/>';
		        	var td = $('<td>').css({'width': '15px'});
		        	td.append($(html));
		            $('<tr>').append(td).
		          		append($('<td>').text(row.id)).
		                append($('<td>').text(row.name)).appendTo('#tb_nssocSpot');
		        });
		        
		        $("[id^=aS_]").click(function() {	
		        	var action = ($(this).prop('checked')?"aS":"dS");
		        	adSpot(action, $("#ancId").val(), $(this).prop('id').split("_")[1]);
				});

		    }
		});
	}
	
	function searchPB(){
		$.ajax({
			type: "POST",
		    url: 'selAction.do',
		    data: { action: "sP", search:$("#searchPB").val()},
		    dataType: 'json',
		    success: function(data) {
		    	
		    	//table des campagnes disso avec cb pour asso PB
				$("#tb_nssocPB tr").remove();
		        $('<tr>').addClass('campaignT').
		        append($('<td>').text("")).
		        append($('<td>').text("Id")).
		        append($('<td>').text("Nom")).appendTo('#tb_nssocPB');
		       
		        $.each(data.nssocPB,function(i,row){
		        	var html = '<input type="checkbox" id="aP_'+row.id+'" title="associer"/>';
		        	var td = $('<td>').css({'width': '15px'});
		        	td.append($(html));
		            $('<tr>').append(td).
		          		append($('<td>').text(row.id)).
		                append($('<td>').text(row.formatedName)).appendTo('#tb_nssocPB');
		        });
		        
		        $("[id^=aP_]").click(function() {	
		        	var action = ($(this).prop('checked')?"aP":"dP");
		        	adPB(action, $("#ancId").val(), $(this).prop('id').split("_")[1]);
				});

		    }
		});
	}
	function zearchSPOT(){
		$.ajax({
			type: "POST",
		    url: 'selAction.do',
		    data: { action: "zS", search:$("#zearchSPOT").val()},
		    dataType: 'json',
		    success: function(data) {		    	
		    	$("#tb_zssocSpot tr").remove();
		        $('<tr>').addClass('campaignT').
		        append($('<td>').text("")).
		        append($('<td>').text("Id")).
		        append($('<td>').text("Nom")).appendTo('#tb_zssocSpot');
		       
		        $.each(data.zssocSpot,function(i,row){
		            $('<tr>').append($('<td>').text(row.id)).append($('<td>').text(row.name)).appendTo('#tb_zssocSpot');
		        });
		    }
		});
	}
	
	function assocDfa(data,ancId){
		//table des assoc avec croix pour disso DFA				    	
    	$("#tb_assocDfa tr").remove();
        $('<tr>').addClass('campaignT').
        append($('<td>').text("")).
        append($('<td>').text("Id")).
        append($('<td>').css({'width': '150px'}).text("Nom")).
        append($('<td>').text("Client")).
        append($('<td>').text("Network")).
        append($('<td>').text("approved")).appendTo('#tb_assocDfa');
        var color_value="";
        $.each(data.assocDfa,function(i,row){
        	color_value = row.approved?"green":"red";
        	var html = '<a href="#" id="dD_'+row.id+'" title="dissocier"><img class="delete" alt="dissocier" src="img/delete.png"/></a>';
        	var td = $('<td>').css({'width': '15px'});        	
        	td.append($(html));
            $('<tr>').append(td).
          		append($('<td>').text(row.id)).
          		append($('<td>').text(row.name)).
          		append($('<td>').prop('id',"tcn_"+row.id)).
          		append($('<td>').text(row.resKey)).
                append($('<td>').css({color:color_value}).text(row.approved)).appendTo('#tb_assocDfa');
            var ipt = $('<input>').prop({type:'text',id:'cn_'+row.id}).addClass('box_input').css({'width':'150px'}).val(row.clientName);
            ipt.appendTo("#tcn_"+row.id);            
            ipt.keydown(function (event) {
   				if(event.keyCode == 13){
   				$.ajax({
   					type: "POST",
   					url: "selAction.do",
   					data: { action: "updcn", dfaId:row.id,value:ipt.val(),ancId:$("#ancId").val() },
   					dataType:"json",
   					error: function() { alert("<bean:message key='traffic.annonceur.errUpd'/>"); },
   					success: function(){ipt.css("color","#2152A3");} 
   					});
   				}else {$(this).css('color','red');}
   			});	
        });
        $("[id^=dD_]").click(function() {	
			adDfa("dD", ancId, $(this).prop('id').split("_")[1]);
		});
		
	}
	
	function nssocDfa(data,ancId){
		//table des campagnes disso avec cb pour asso DFA
		$("#tb_nssocDfa tr").remove();
		$('<tr>').addClass('campaignT').
        append($('<td>').text("")).
        append($('<td>').text("Id")).
        append($('<td>').css({'width': '300px'}).text("Name")).
        append($('<td>').text("Network")).
        append($('<td>').text("approved")).appendTo('#tb_nssocDfa');
       var color_value="";
        $.each(data.nssocDfa,function(i,row){
        	color_value = row.approved?"green":"red";
        	var html = '<input type="checkbox" id="aD_'+row.id+'" title="associer"/>';
        	var td = $('<td>').css({'width': '15px'});
        	td.append($(html));
            $('<tr>').append(td).
          		append($('<td>').text(row.id)).
                append($('<td>').text(row.name)).
                append($('<td>').text(row.resKey)).
                append($('<td>').css({color:color_value}).text(row.approved)).appendTo('#tb_nssocDfa');
        });
        
        $("[id^=aD_]").click(function() {
        	var action = ($(this).prop('checked')?"aD":"dD");
			adDfa(action, ancId, $(this).prop('id').split("_")[1]);
		});
	  
	}
	
	//REQUETE AJAX DFA
	function adDfa(action, ancId, dfaId){
	
		if(displayType=="a"){
			$.ajax({
				type: "POST",
				url: "selAction.do",
				data: { action: action, ancId:ancId, "dfaId":dfaId,search:$("#searchDFA").val() },
				dataType:"json",
				error: function() { alert(errDfa); },
				success: function(data){	
					assocDfa(data, ancId);							
					nssocDfa(data, ancId);	
				  } 
				});	
		}else{
			alert(notAllowed);	
		}
		 
		
	}
	
	
	function assocSpot(data,ancId){
		//table des assoc avec croix pour disso SPOT				    	
    	$("#tb_assocSpot tr").remove();
        $('<tr>').addClass('campaignT').
        append($('<td>').text("")).
        append($('<td>').text("Id")).
        append($('<td>').text("Nom")).appendTo('#tb_assocSpot');
        $.each(data.assocSpot,function(i,row){
        	var html = '<a href="#tb_assocSpot" id="dS_'+row.id+'" title="split"><img class="delete" alt="dissocier" src="img/delete.png"/></a>';
        	var td = $('<td>').css({'width': '15px'});
        	td.append($(html));
            $('<tr>').append(td).
          		append($('<td>').text(row.id)).
                append($('<td>').text(row.name)).appendTo('#tb_assocSpot');
        });
        
        $("[id^=dS_]").click(function() {	
        	adSpot("dS", ancId, $(this).prop('id').split("_")[1]);
		});
	}
	
	function nssocSpot(data,ancId){
		//table des campagnes disso avec cb pour asso SPOT
		$("#tb_nssocSpot tr").remove();
        $('<tr>').addClass('campaignT').
        append($('<td>').text("")).
        append($('<td>').text("Id")).
        append($('<td>').text("Nom")).appendTo('#tb_nssocSpot');
         $.each(data.nssocSpot,function(i,row){
        	var html = '<input type="checkbox" id="aS_'+row.id+'" title="link"/>';
        	var td = $('<td>').css({'width': '15px'});
        	td.append($(html));
            $('<tr>').append(td).
          		append($('<td>').text(row.id)).
                append($('<td>').text(row.name)).appendTo('#tb_nssocSpot');
        });
        
        $("[id^=aS_]").click(function() {	
        	var action = ($(this).prop('checked')?"aS":"dS");
			adSpot(action, ancId, $(this).prop('id').split("_")[1]);
		});
	}				
		
	//REQUETE AJAX SPOT
	function adSpot(action, ancId, spotId){
		if(displayType=="a"){
			$.ajax({
				type: "POST",
				url: "selAction.do",
				data: {action: action,ancId:ancId,"spotId":spotId,search:$("#searchSPOT").val() },
				dataType:"json",
				error: function() { alert("<bean:message key='traffic.annonceur.errorSPOTRequest'/>"); },
				success: function(data){	
					assocSpot(data,ancId);
					nssocSpot(data,ancId);
					
				    } 
				})	;
		}else{
			alert(notGranted);
		}
		 
	}
	
	function assocPB(data,ancId){
		//table des assoc avec croix pour disso PB				    	
    	$("#tb_assocPB tr").remove();
        $('<tr>').addClass('campaignT').
        append($('<td>').text("")).
        append($('<td>').text("Id")).
        append($('<td>').text("Nom")).appendTo('#tb_assocPB');
        $.each(data.assocPB,function(i,row){
        	var html = '<a href="#tb_assocPB" id="dP_'+row.id+'" title="split"><img class="delete" alt="dissocier" src="img/delete.png"/></a>';
        	var td = $('<td>').css({'width': '15px'});
        	td.append($(html));
            $('<tr>').append(td).
          		append($('<td>').text(row.id)).
                append($('<td>').text(row.name)).appendTo('#tb_assocPB');
        });
        
        $("[id^=dP_]").click(function() {	
        	adPB("dP", ancId, $(this).prop('id').split("_")[1]);
		});
	}
	
	function nssocPB(data,ancId){
		//table des campagnes disso avec cb pour asso PB
		$("#tb_nssocPB tr").remove();
        $('<tr>').addClass('campaignT').
        append($('<td>').text("")).
        append($('<td>').text("Id")).
        append($('<td>').text("Name")).appendTo('#tb_nssocPB');
         $.each(data.nssocPB,function(i,row){
        	var html = '<input type="checkbox" id="aP_'+row.id+'" title="link"/>';
        	var td = $('<td>').css({'width': '15px'});
        	td.append($(html));
            $('<tr>').append(td).
          		append($('<td>').text(row.id)).
                append($('<td>').text(row.formatedName)).appendTo('#tb_nssocPB');
        });
        
        $("[id^=aP_]").click(function() {	
        	var action = ($(this).prop('checked')?"aP":"dP");
			adPB(action, ancId, $(this).prop('id').split("_")[1]);
		});
	}
	
		//REQUETE AJAX PB
	function adPB(action, ancId, advId){
		if(displayType=="a"){
			$.ajax({
				type: "POST",
				url: "selAction.do",
				data: {action: action,ancId:ancId,advId:advId,search:$("#searchPB").val() },
				dataType:"json",
				error: function() { alert(errorRequest); },
				success: function(data){	
					assocPB(data,ancId);
					nssocPB(data,ancId);					
				    } 
				})	;	
		}else{
			alert(notGranted);	
		}
		 
	}
	
	function ancId() {
		$("#divContactsDisplay").empty();$("#display_contacts_cb").prop("checked",false);
		$("#display_campaigns_cb").prop("checked",false);
		$("#divCampaignDisplay").hide();
		var ancId =  $(this).val();	

		var action="display";
	 $.ajax({
			type: "POST",
			url: "selAction.do",
			data: { action: action, ancId:ancId},
			dataType:"json",
			error: function() { alert(errorRequest); },
			success: function(data){
				$("#ancName").val(data.annonceur.ancNameMAJ);
				$("#actif").val(data.annonceur.actif);
				$("#adsId").val(data.annonceur.adsId);
				$("#resKey").val(data.annonceur.resKey);
				
				$("#entityId").val(data.annonceur.entityId);
				$("#namingRule").val(data.annonceur.namingRule);
				$("#deadlineAlertJ").val(data.annonceur.deadlineAlertJ);
				$("#znAbvs").val(data.annonceur.znAbvs);
				
				$("#dtn100").prop('checked',(data.annonceur.dtn100=='100'));
				$("#dtn110").prop('checked',(data.annonceur.dtn110=='110'));
				$("#dtn120").prop('checked',(data.annonceur.dtn120=='120'));
				$("#dtn200").prop('checked',(data.annonceur.dtn200=='200'));
				if($("#adsId").val()==1){
					$("#trNetwork").show(100);	
				} else {
					$("#trNetwork").hide(100);
				}
				if(data.annonceur.adsId == 1){
					$("#divAdvertiserDfa").show();
					$("#searchDFA").val(data.search);
					assocDfa(data,ancId);
					nssocDfa(data,ancId);
				}
					
				else 
					$("#divAdvertiserDfa").hide();

				
				$("#divAnnonceurSpot").show();
				$("#searchSPOT").val(data.search);
				assocSpot(data,ancId);
				nssocSpot(data,ancId);
				
				$("#divAdvertiserPB").show();
				$("#searchPB").val(data.search);
				assocPB(data,ancId);
				nssocPB(data,ancId);
				
			  } 
			});
		
	}
		