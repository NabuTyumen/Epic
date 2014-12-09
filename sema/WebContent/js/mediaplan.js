function ObjectPositionById(id) {
	var obj = document.getElementById(id);
	return ObjectPosition(obj);
}
function ObjectPosition(obj) {	
	var curleft = 0;
	var curtop = 0;
	if (obj.offsetParent) {
		do {
			curleft += obj.offsetLeft;
			curtop += obj.offsetTop;
		} while (obj = obj.offsetParent);
	}
	return [curleft,curtop];
}
function addSit(){
		$.ajax({					
			type: "POST",
		    url: 'selSiteAction.do',
		    data: {action:"supports", resKey:resKey},
		    dataType: 'json',
		    error: function() { alert(errResearchsit); },
		    success: function(data) {
		    	$('<div>').prop({id:'newsit'}).css({border:'2px solid #AAAAAA',margin:'10px 0 0 5px'}).prependTo('#divPlacement');
		    	var tabS=$('<table>').prop({id:'tabS'}).addClass('sit').appendTo('#newsit');
		    	var tr = $('<tr>').appendTo(tabS);
		    	$('<th>').css({width:'80px'}).text('Site').appendTo(tr);
		    	$('<th>').css({width:'55px'}).text('Id DART').appendTo(tr);
				$('<th>').css({width:'255px'}).text('Name').appendTo(tr);
				tr = $('<tr>').appendTo(tabS);
				$('<td>').appendTo(tr);$('<td>').appendTo(tr);
				var td = $('<td>').appendTo(tr);									
		    	$('<input>').prop({type:"text", id:'dsitNm_0'}).addClass('dlb').css({width:'260px'}).appendTo(td);
		    	$('#dsitNm_0').typeWatch({		    		
	    			callback : function(){
	    				if($('#dsitNm_0').val()=="") {
			    			$('#sit_dfl_0').empty();$('#sit_dfl_0').hide();
			    		}else{
			    			var div; var sitLb;
			    			$.ajax({
		    					type: "POST",
		    					url: "selSiteAction.do",
		    					data: {action:"supports_search", search:$('#dsitNm_0').val(), resKey:resKey},
		    					dataType:"json",
		    					error: function() { alert(errResearchsit); },
		    					success: function(data){
		    						$('#sit_dfl_0').empty();
		    						$.each(data.supports,function(i,sit){
		    							div = $('<div>').addClass('sit_elt').css({width:'435px',height: '14px','padding-left':'3px'}).appendTo('#sit_dfl_0');
		    							sitLb=sit.id + " " + sit.name;
		    							$('<div>').prop({id:"sit_" + sit.id}).css({width:'335px','float':'left'}).text(sitLb).click(selSit).appendTo(div);
		    							if(sit.is==true){
		    								$('<div>').css({width:'100px','float':'right',color:'green'}).text(sit.inStream).appendTo(div);
		    							} else {
		    								$('<div>').css({width:'100px','float':'right',color:'red'}).text(sit.inStream).appendTo(div);
		    							}		    							
		    					    });
		    						$('#sit_list_0').show();
		    						$('#sit_dfl_0').show();		    						
		    					}
		    					})	;	
			    		}	    				
	    			},
	    			wait : 330,
	    			highlight : true,
	    			captureLength : 0
	    		});		    	
		    	$('<div>').prop({id:'sit_list_0'}).addClass('sit_list').appendTo('#newsit');
		    	$('<div>').prop({id:'sit_dfl_0'}).appendTo('#sit_list_0');	
		    	//scroller jusqu'� l'�l�ment
		    	 $('html,body').animate({scrollTop: $('#dsitNm_0').offset().top-100}, 300);		      
		    }
		});
	}

//declench�e par la s�lection dans la liste de recherche 	
function selSit(){
		$('#sit_list_0').empty();$('#sit_dfl_0').hide();
		var idS = $(this).prop('id').split('_')[1];
			
		$.ajax({
			type: "POST",
			url: "mpAction.do",
			data: {action:'apl', idS:idS},
			dataType:"json",
			error: function() { alert(errCreaPla); },
			success: function(data){
				upd_form(data.camSel);
			    } 
			})	;
	}

//(RE)CHARGEMENT DU FORMULAIRE CAMPAGNE + SITES + PLACEMENTS 
function upd_form(c){
	$("#camId").text(c.id);
	$("#cadId").text(c.cadId);

	 if(adsId==1){
	 $('#dfaAdvId').empty();
	 $('<option>').val("-1").text(selectDfaAdvertisers).appendTo('#dfaAdvId');
	 $.each(c.advsDfa,function(i,adv){
		$('<option>').val(adv.id).text(adv.name).appendTo('#dfaAdvId');
	 });
	 $("#dfaAdvId").val(c.dfaAdvId);
	 }
	$("#ancName").text(c.ancFormatedName);
	$("#name").val(c.name).prop('disabled', true);
	$("#namingRule").val(c.namingRule);		
	$("#camAdsName").val(c.camAdsName);
	if(c.namingRule == 'd'){
		$("#camAdsName").prop('disabled', false);	
	} else {
		$("#camAdsName").prop('disabled', true);
	}
	$("#billedZn").val(c.billedZn);
	$("#targetZn").val(c.targetZn);
	$("#customX").val(c.customX);
	$("#defaultUrl").val(c.defaultUrl);
	$("#ancId").val(c.ancId);
	$("#dateBeg").text(c.dateBeg);
	$("#dateEnd").text(c.dateEnd);	
	$("#dateBegA").val(c.dateBegA);
	$("#dateEndA").val(c.dateEndA);
	$("#product").val(c.product);
	$("#channelS").text(c.channelSNm);
	$("#channelA").empty();
	 $.each(c.cmatchA,function(i,row){ 
		 $('<option>').val(row.abvA).text(row.nameA).appendTo("#channelA");
     });
	 $("#channelA").val(c.channelA);
	 $("#objectiveS").text(c.objectiveSNm);
	 $("#objectiveA").empty();
	 $.each(c.omatchA,function(i,row){ 
		  $('<option>').val(row.abvA).text(row.nameA).appendTo("#objectiveA");
     });
	 $("#objectiveA").val(c.objectiveA);
	 $("#tdUrl").empty();
	 $.each(c.landingPages,function(i,lp){
		 var idTM = lp.idTM;
		 var tl = $('<table>').prop("id","divLp_"+idTM).css({'clear':'both','margin-top':'3px'}).appendTo("#tdUrl");
		 var tr=$('<tr>').appendTo(tl);
		 $('<td>').append($('<div>').prop({id:'lpIdTM_'+idTM}).addClass('input_f').css({width:'30px',height:'20px','margin-right':'3px'}).text(idTM)).appendTo(tr);
		 $('<td>').append($('<div>').prop({id:'lpId_'+idTM}).addClass('dln').css({width:'50px','margin-right':'3px','float':'left'}).text(lp.id)).appendTo(tr);
		 $('<td>').append($('<input/>').prop({type:'text',id:'lpName_'+idTM}).addClass('dpt').css({width:'100px','margin-right':'3px'}).val(lp.name)).appendTo(tr);
		 $('<td>').append($('<textarea/>').prop({id:'lpUrl_'+idTM,row:1}).addClass('box_url').css({width:'400px','height':'20px','margin-right':'3px','background-color': '#E7EFE7',color: '#5A9C5A'}).val(lp.url)).appendTo(tr);
		 $('<td>').append($('<a>').prop({id:'lpDel_'+idTM,title:lpRemove}).addClass('delp').click(delLp).append($('<img>').prop({src:'img/deletep.png', alt:'del'}).css("border","0"))).appendTo(tr);
		 
		 
		 $('#lpName_'+idTM).keydown(function (event) {
 			 var ipt = $('#lpName_'+idTM);
				if(event.keyCode == 13){ipt.css('color',colorDark);saveLp(idTM);
				}else {execute=false;ipt.css('color','#FF40000' );}
			});		 		 
 		 $('#lpUrl_'+idTM).keydown(function (event) {
 	 			 var ipt = $('#lpUrl_'+idTM);
				if(event.keyCode == 13){ipt.css('color',colorDark);saveLp(idTM);return false;
				}else {execute=false;ipt.css('color','#FF40000' );}
			});
		 });//fin lps
		 
	 $('#divPlacement').empty();
	 var idS=0;var divS;var tab; var tr; var tr2; var td; var dln='';
	 var m=0;var addPl;var adelS;
	 $.each(c.sites,function(i,sit){
		 
		 if(sit.havePlacement){
			 			 
			 idS = sit.idS;			 //vert DART : #5A9C5A
			 divS = $('<div>').prop({id:'divS_'+idS}).css({'border':'6px solid #DDDDDD','margin':'10px 0 0 5px'}).appendTo('#divPlacement');
			 tab= $('<table>').prop({id:'tabS_'+idS}).addClass('sit').appendTo(divS);		 
			 tr = $('<tr>').appendTo(tab);
			 			 			 
			 $('<th>').css({width:'80px'}).text(lbSite + ' ' + (i+1)).appendTo(tr);
			 //id site
			  if(sit.directorySiteId==0) dln = 'ier'; else dln='dln';		  
			  $('<th>').prop({id:'dirsId'+idS,title:'directorySiteId'}).addClass(dln).css({width:'60px',color:'#CCCCCC'}).text(sit.directorySiteId).appendTo(tr);
			  
			  if(sit.dfaSiteId==0) dln = 'ier'; else dln='dln';	
			  $('<th>').prop({id:'dsitId_'+idS,title:'dfaSiteId'}).addClass(dln).css({width:'60px'}).text(sit.dfaSiteId).appendTo(tr);
			 			 
			 //select site name
			 td=$('<th>').appendTo(tr);
			//CAS 1 pas de site spot avec liste dfa associ�
			 if(sit.haveDfaChoice==false){
				 var bcolor =(sit.dfaName==""?'#FD93A0':'#5A9C5A');
				 
				 $('<input>').prop({type:"text", id:'dsitNm_'+idS,title:sitNameNoDfaChoice}).addClass('inv').css({width:'170px','background-color':(sit.dfaSiteId=='0'?'#FD93A0':'#5A9C5A')}).val(sit.dfaName).click(addTypeWatch).appendTo(td); 
			 
		
			 //CAS 2 : 1 seul site associ�
			 }else if(sit.dfaChoice.length==1){
				 $('<div>').prop({id:'dsitNm_'+sit.dfaChoice[0].id,title:sitName1DfaChoice}).addClass('inv').css({width:'170px'}).text(sit.dfaChoice[0].name).appendTo(td);
			//CAS 3 : pls sites associ�s
			 }else if(sit.dfaChoice.length>1){
				 var selsit = $('<select>').prop({id:'dsitNm_'+idS,title:sitNameNDfaChoice}).addClass('inv').css({width:'170px'}).change(edisit).appendTo(td);
				 $.each(sit.dfaChoice,function(i,o){
						$('<option>').val(o.id).text(o.name).appendTo(selsit);
					 });	
				 selsit.val(sit.dfaSiteId);
			 }
			
			 //nom reduit
			 td=$('<th>').css({width:'170px'}).appendTo(tr);
			 $('<input>').prop({type:"text", id:'dsitNs_'+idS, title:sitNameShort}).addClass('inv2').css({width:'170px'}).val(sit.siteName).click(addTypeWatch).appendTo(td);
			 
			 //div de recherche
			  $('<div>').prop({id:'sit_list_'+idS}).addClass('sit_list').appendTo(divS);
		     $('<div>').prop({id:'sit_dfl_'+idS}).addClass('sit_dfl').appendTo('#sit_list_'+idS);
			 //instream
			 $('<th>').css({width:'118px'}).prop({title:libInStream}).text(sit.inStream).appendTo(tr);
			 
			 if(sit.haveSpot==true){
				 var ssitTitle = 'R�gie :\t\t'+sit.regieId+' '+sit.regieName+' \n Support :\t'+sit.supportId+' '+sit.supportName;
				 td=$('<th>').css({'background-color':'#004E98',color:'white'}).appendTo(tr);
		    	 $('<div>').prop({id:'ssitNm_'+idS,'title':ssitTitle}).css({width:'220px'}).addClass('ipn').text(sit.spotName).appendTo(td);
				 	 
			 }else{
				 $('<th>').css({width:'260px'}).appendTo(tr);
			 }
			 
			 td=$('<th>').css({width:'25px', 'background-color': '#FFFFFF'}).appendTo(tr);
			 
			 adelS=$('<a>').prop({id:'delS_'+idS,title:libSitRemove}).addClass('delp').click(delS).appendTo(td);			 
			 $('<img>').prop({src:'img/deletep.png'}).appendTo(adelS);				 
			
			 divP=$('<div>').prop({id:'divP_'+idS}).appendTo(divS);
		 }
		 	
	     
	 });//fin sites
	 
	 
	 $.each(c.placements,function(i,pl){
		 var idS = (pl.idS).split('_')[0];
		 pl.idS=idS;
		 $('<table>').prop({id:'tabP_'+pl.idP}).addClass('pla').appendTo('#divP_'+pl.idS);		 
		 upd_placement(pl);
	 });//fin placements
	 
}

function upd_placement(pl){
	var dln=''; if(pl.dfaId==0) dln = 'ier'; else dln='dln';
	var idP=pl.idP; 		
	var tab = $('#tabP_'+idP);
	var tr;
	if(!pl.ghost){
		$('<tr>').appendTo(tab)
		 .append($('<td>').css({width:'95px'}))
		 .append($('<td>').css({width:'12px'}))		 
		 .append($('<td>').css({width:'135px'}).append($('<div>').prop({id:'adsId_'+idP}).addClass(dln).css({width:'70px'}).click(editx).text(pl.dfaId)))
		 .append($('<th>').css({width:'12px'}))
		 .append($('<th>').css({width:'435px'}).attr({'colspan':5}).append($('<span>').css({color:colorDark,'margin-right':'10px'}).text('DART')).append($('<span>').text(plNamingRule)).append($('<label />').html(' Traffic  ').prepend($('<input>').prop({id:'setNT_'+idP,type:'checkbox'}).click(editcb))).append($('<label />').html(' ARTEMIS').prepend($('<input>').prop({id:'setNA_'+idP,type:'checkbox'}).click(editcb))))
		 .append($('<th>').css({width:'12px'}))
		 .append($('<th>').css({width:'95px'}).text(plCreativeDimension))
		 .append($('<th>').css({width:'12px'}))
		 .append($('<th>').css({width:'95px'}).text(plCustomX))
		 .append($('<th>').css({width:'12px'}).append($('<a>').prop({id:'delP_'+idP,title:plRemove}).addClass('delp').click(delP).append( $('<img>').prop({src:'img/deletep.png'}))))
		 ;
				
		var color_name="#4D4D4D"; if(pl.diffName) color_name="red";
		var color_tfk ="#2152A3"; if(pl.diffTfk) color_tfk="red";
		if(pl.idF>0){
			$('<tr>').appendTo(tab)
			 .append($('<th>').addClass('ttl').text(plDfaName).css({color:color_name}))
			 .append($('<td>').append($('<img>').prop({id:'dplNm_'+idP+"_i",src:'img/o.png'})))
			 .append($('<td>').attr({'colspan':7}).append($('<div>').prop({id:'dplNm_'+idP}).addClass('dpt').css({width:'590px','font-size':'13px','font-weight': 'bold'}).text(pl.dfaName).click(editx)))
			 .append($('<td>').css({'text-align':'right'}).append($('<img>').prop({id:'plDm_'+idP+"_i",src:'img/o.png'})))		 
			 .append($('<td>').append($('<div>').prop({id:'plDm_'+idP}).css({width:'135px'})))
			 .append($('<th>').css({width:'12px'}))			 
			 .append($('<td>').append($('<div>').prop({id:'aplNc_'+idP}).addClass('ips').css({width:'95px'}).text(pl.customX).click(editx)))
			 ;	
			
		}else{
			$('<tr>').appendTo(tab)
			 .append($('<th>').addClass('ttl').text(plName))
			 .append($('<td>').append($('<img>').prop({id:'tplNm_'+idP+"_i",src:'img/o.png'})))
			 .append($('<td>').append($('<div>').prop({id:'tplNm_'+idP}).addClass('ips').css({width:'135px','font-size':'13px','font-weight': 'bold'}).text(pl.name).click(editx)))
			 .append($('<td>').append($('<img>').prop({id:'dplNm_'+idP+"_i",src:'img/o.png'})))
			 .append($('<td>').attr({'colspan':5}).append($('<div>').prop({id:'dplNm_'+idP}).addClass('dln').css({width:'443px','font-size':'13px','font-weight': 'bold'}).text(pl.dfaName).click(editx)))
			 .append($('<td>').css({'text-align':'right'}).append($('<img>').prop({id:'plDm_'+idP+"_i",src:'img/o.png'})))		 
			 .append($('<td>').append($('<div>').prop({id:'plDm_'+idP}).css({width:'135px'})))
			 .append($('<th>').css({width:'12px'}))			 
			 .append($('<td>').append($('<div>').prop({id:'aplNc_'+idP}).addClass('ips').css({width:'95px'}).text(pl.customX).click(editx)))
			 ;	
		}
		 
		 $('<div>').prop({id:'aplDm_'+idP}).attr('title','ARTEMIS').css({'float':'left', width:'65px','padding':'5px 0px 5px 0px','background-color': '#E4EBF0','cursor':'pointer'}).text(pl.artSizLb).click(edisl).appendTo('#plDm_'+idP);
		 $('<div>').attr('title','DART').css({'float':'left', width:'65px','padding':'5px 0px 5px 3px','border-left':'1px solid #5A9C5A','background-color':'#E7EFE7',color: '#5A9C5A'}).text(pl.dfaSizLb).appendTo('#plDm_'+idP);
			 
		 $('<tr>').appendTo(tab)
		 .append($('<th>').css({'border-top':'1px solid #CCC'}))
		 .append($('<th>'))
		 .append($('<th>').text(plPlacementType))
		 .append($('<th>'))
		 .append($('<th>').text(plCostStructure))			 
		 .append($('<th>').css({width:'12px'}))
		 .append($('<th>').text(plCreativeType))
		 .append($('<th>').css({width:'12px'}))
		 .append($('<th>').text(plTrafficType).css({color:color_tfk}))
		 .append($('<th>').css({width:'12px'}))
		 .append($('<th>').text(plRetargeting))
		 .append($('<th>').css({width:'12px'}))
		 .append($('<th>').css({'text-align':'right',color:'#99ccff'}).text(idP))
		 ;
		 
		  tr = $('<tr>').appendTo(tab)
		 .append($('<th>').addClass('ttl').text(plType))			 
		 .append($('<td>').css({'text-align':'right'}).append($('<img>').prop({id:'dplTy_'+idP+"_i",src:'img/o.png'})))		 
		 .append($('<td>').append($('<div>').prop({id:'dplTy_'+idP}).addClass('dln').css({width:'133px'}).text(pl.dfaTypPlaLb).click(edisl)))
		 .append($('<td>').css({'text-align':'right'}).append($('<img>').prop({id:'aplTa_'+idP+"_i",src:'img/o.png'})))
		 .append($('<td>').append($('<div>').prop({id:'aplTa_'+idP}).addClass('ips').css({width:'135px'}).text(pl.artTypALb).click(edisl)))			 
		 .append($('<td>').css({'text-align':'right'}).append($('<img>').prop({id:'aplTy_'+idP+"_i",src:'img/o.png'})))
		 .append($('<td>').append($('<div>').prop({id:'aplTy_'+idP}).addClass('ips').css({width:'125px'}).text(pl.artTypCreLb).click(edisl)))
		 .append($('<td>').css({'text-align':'right'}).append($('<img>').prop({id:'aplTf_'+idP+"_i",src:'img/o.png'})))
		 .append($('<td>').append($('<div>').prop({id:'aplTf_'+idP}).addClass('ips').css({width:'125px'}).text(pl.artTypTfkLb).click(edisl)))
		 .append($('<td>').css({'text-align':'right'}).append($('<img>').prop({id:'aplRt_'+idP+"_i",src:'img/o.png'})))
		 .append($('<td>').append($('<div>').prop({id:'aplRt_'+idP}).addClass('ips').css({width:'125px'}).text(pl.artTypRtgLb).click(edisl)))
		 .append($('<th>').css({width:'12px'}));
		 if(pl.idF>0){
			 //tr.append($('<th>').css({'text-align':'right'}).append($('<span>').prop({id:'idF_'+pl.idP,'title':'id placement SPOT- Cliquez pour afficher le contenu du placement'}).css({width:'95px','background-color':'#004E98',color:'#FFFFFF','padding':'1px 3px 1px 3px','cursor':'pointer'}).text(pl.idF).click(dispot))) ;
			 tr.append($('<th>').append($('<table>').append($('<tr>')						 
					 .append($('<td>').append($('<input>').prop({id:'ncopy_'+idP,title:plNumberOfCopies}).addClass('ipl')))
					 .append($('<td>').append($('<a>').prop({id:'acopy_'+idP,title:plCopy}).addClass('acopy').append( $('<img>').prop({src:'img/copy.png'})).click(acopy)))
					 .append($('<td>').css({'text-align':'right'}).append($('<span>').prop({id:'idF_'+pl.idP,title:plPlacementSpot}).css({width:'95px','background-color':'#004E98',color:'#FFFFFF','padding':'1px 3px 1px 3px','cursor':'pointer'}).text(pl.idF).click(dispot))))));
		 } else {						 
			 tr.append($('<th>').append($('<table>').append($('<tr>')
					 .append($('<td>').append($('<input>').prop({id:'ncopy_'+idP,title:plNumberOfCopies}).addClass('ips').css({width:'16px'})))
					 .append($('<td>').append($('<a>').prop({id:'acopy_'+idP,title:plCopy}).addClass('acopy').append( $('<img>').prop({src:'img/copy.png'})).click(acopy))))));
		 }
		 
		 if(pl.namingRule == '0')
			 $('#setNT_'+idP).prop("checked", true);
		 if(pl.namingRule == 'a')
			 $('#setNA_'+idP).prop("checked", true);
		 
	}
	 		
}
function delS(){
	if(!confirm(msgDelPlaSit)) return false;
	var idS = $(this).prop('id').split('_')[1];	
	$.ajax({
		type: "POST",
		url: "mpAction.do",
		data: {action:'delsit', idS:idS},
		dataType:"json",
		error: function() { alert(errDelPlaSit); },
		success: function(data){
			$('#divS_'+idS).remove();
		    } 
		})	;
	return true;
}

//creation d'un nouveau placement dans le site
function addP(){
	var idS = $(this).prop('id').split('_')[1];	
	$.ajax({
		type: "POST",
		url: "mpAction.do",
		data: {action:'apl', idS:idS},
		dataType:"json",
		error: function() { alert(errCreaPla); },
		success: function(data){
			upd_form(data.camSel);
			 $('html,body').animate({scrollTop: $('#tabP_'+data.placement.idP).offset().top-100}, 300);
		    } 
		})	;
}

//copy en N exemplaires d'un placement
function acopy(){
	var idP = $(this).prop('id').split('_')[1];	
	$.ajax({
		type: "POST",
		url: "mpAction.do",
		data: {action:'cpl',idP:idP,nb:$('#ncopy_'+idP).val()},
		dataType:"json",
		error: function() { alert(errCopyPla); },
		success: function(data){
			upd_form(data.camSel);
		    } 
		})	;
}

//suppression d'un placement
function delP(){
	if(!confirm(msgDelPla)) return false;
	var idP = $(this).prop('id').split('_')[1];	
	$.ajax({
		type: "POST",
		url: "mpAction.do",
		data: {action:'dpl', idP:idP},
		dataType:"json",
		error: function() { alert(errDelPla); },
		success: function(data){
			$('#tabP_' + idP).remove();
			
		    } 
		})	;
	return true;
}

//fonction d�clench�e par le clic sur l'id spot
function dispot(){
	if($(this).text()=='0') return false;
	var idP = $(this).prop('id').split('_')[1];
	var div=$("#divspot_"+idP);			
	if(div.length>0 ) {
		div.dialog("close");
		//div.remove();
		return false;
	}
	
		var itabP = 'tabP_'+idP;
		var tabP = $('#'+itabP); 
		var w = tabP.css("width");
		var o = ObjectPositionById(itabP);
		var t = ''+eval(o[1]-70)+'px';
		var l = ''+o[0]+'px';
		
		div = $('<div>').prop({id:'divspot_'+idP});
		div.dialog({
	    	position:{my:'left top',at:'left bottom',of:tabP},
	    	autoOpen: false,
	        resizable: true,
	        width:951,
	        stack: true,
	        modal: false,
	        show: 'drop',
	        hide: 'drop',
	        title: lbPlacement +' SPOT ' + $(this).text(),
	        close: function(event, ui){		      
	        	 $( this ).dialog("close");
	        	 $( this ).remove();
	        }		        			        
	    });
		
		
		//div.css({top:t,left:l, width:w,heigth:'100px','background-color':'#FFFFFF','border':'1px solid #004E98'});
		//div.css({'background-color':'#FFFFFF'});
		$.ajax({
			type: "POST",
			url: "mpAction.do",
			data: {action:'dsp', idP:idP},
			dataType:"json",
			error: function() { alert(errDispot); },
			success: function(data){
				var p = data.placement;				
				var table = $('<table>').css({'border-collapse':'collapse'}).appendTo(div);
				var tr = $('<tr>').appendTo(table);
				$('<td>').css({width:'125px'}).text(lbPlacement).addClass('tspot').appendTo(tr);
				$('<td>').css({width:'500px'}).prop('id','emplacement').text(p.emplacement).appendTo(tr);
				$('<td>').css({width:'15px'}).prop('id','i_emplacement').appendTo(tr);
				
				$('<td>').css({width:'125px'}).text(lbBuying).addClass('tspot').appendTo(tr);				
				$('<td>').css({width:'125px'}).prop('id','modeAchat').text(p.modeAchat).appendTo(tr);
				$('<td>').css({width:'15px'}).prop('id','i_modeAchat').appendTo(tr);
				
				tr = $('<tr>').css({'background-color':'#E4EBF0'}).appendTo(table);
				$('<td>').text(lbLibelle).addClass('tspot').appendTo(tr);
				$('<td>').prop('id','intitule').text(p.intitule).appendTo(tr);
				$('<td>').prop('id','i_intitule').appendTo(tr);
				
				$('<td>').text(lbQuantity).addClass('tspot').appendTo(tr);
				$('<td>').prop('id','quantite').text(p.quantite).appendTo(tr);
				$('<td>').prop('id','i_quantite').appendTo(tr);
				
				tr = $('<tr>').appendTo(table);
				$('<td>').text(lbFormat).addClass('tspot').appendTo(tr);
				$('<td>').prop('id','formatName').text(p.format).appendTo(tr);
				$('<td>').prop('id','i_formatName').appendTo(tr);
				
				$('<td>').text(lbAmount).addClass('tspot').appendTo(tr);
				$('<td>').prop('id','netEspace').text(p.netEspace).appendTo(tr);
				$('<td>').prop('id','i_netEspace').appendTo(tr);
				
				tr = $('<tr>').css({'background-color':'#E4EBF0'}).appendTo(table);
				$('<td>').text(lbDimension).addClass('tspot').appendTo(tr);
				$('<td>').prop('id','formatDimension').text(p.dimension).appendTo(tr);
				$('<td>').prop('id','i_formatDimension').appendTo(tr);
				
				$('<td>').text(lbStartDate).addClass('tspot').appendTo(tr);
				$('<td>').prop('id','startDate').text(p.startDate).appendTo(tr);
				$('<td>').prop('id','i_startDate').css('width','16px').appendTo(tr);
				
				tr = $('<tr>').appendTo(table);
				$('<td>').text(lbTracking).addClass('tspot').appendTo(tr);				
				$('<td>').prop('id','tracking').text(p.tracking).appendTo(tr);
				$('<td>').prop('id','i_tracking').css('width','16px').appendTo(tr);
				
				$('<td>').text(lbEndDate).addClass('tspot').appendTo(tr);
				$('<td>').prop('id','endDate').text(p.endDate).appendTo(tr);
				$('<td>').prop('id','i_endDate').appendTo(tr);

				tr = $('<tr>').appendTo(table);
				$('<td>').attr({'colspan':6}).append($('<textarea>').addClass('box_input').css({width:'890px',height:'40px'}).val(p.commentaire)).appendTo(tr);
									
				tr = $('<tr>').appendTo(table);
				$('<td>').text(lbInsertionId).addClass('tspot').appendTo(tr);
				$('<td>').prop('id','insertionId').text(p.insertionId).appendTo(tr);
				$('<td>').prop('id','i_insertionId').css('width','16px').appendTo(tr);
				
				$('<td>').text(lbFormatId).addClass('tspot').appendTo(tr);
				$('<td>').prop('id','formatId').text(p.formatId).appendTo(tr);
				$('<td>').prop('id','i_formatId').css('width','16px').appendTo(tr);
				
				
				 $.each(p.diff,function(i,d){ 					 
						var ds=d.split("_");												
						var tdi=$('#i_'+ds[2]);
						var imx=$('<img>').prop({id:'imx_'+ds[2],src:'img/previous.png','title':ds[3]}).appendTo(tdi);
						var tdx=$('#'+ds[2]);
						var spx=$('<span>').prop({id:'spx_'+ds[2]}).css({color:'red', 'padding-left':'10px'}).text(lbOldvalue+' : '+ds[3]).appendTo(tdx);
						
					 });//fin diff
					 div.dialog('open');
				 	
			    }//fin success 
			})	;
		//div.show();	
}
//fonction d�clench�e par le focus sur les 2 input texte du site
//dsitNs : modification du nom court du site
//dsitNm : modification du site
function addTypeWatch(){
	var val = $(this).val();
	var field = $(this).prop('id').split('_')[0];
	var idS = $(this).prop('id').split('_')[1];
	if(field == 'dsitNs'){
		$(this).keydown(function (event) {
			if(event.keyCode == 13){
				$.ajax({
					type: "POST",
					url: "mpAction.do",
					data: {action:'updsin', idS:idS, field:field,value: $(this).val()},
					dataType:"json",
					error: function() { alert(errUpdsit); },
					success: function(data){var cam = data.camSel;upd_form(cam);} 
					})	;	
			}		
		});
	} else if(field == 'dsitNm'){
		var parent =$(this).parent(); 
		parent.empty();
		
		$('<input>').prop({type:"text", id:'dsitNm_'+idS}).addClass('dlb').css({width:'200px'}).val(val).typeWatch({
			callback : function(){					
					var lib; var is;
					$.ajax({
						type: "POST",
						url: "selSiteAction.do",
						data: {action:"supports_search", search:$('#dsitNm_'+idS).val(), resKey:resKey},
						dataType:"json",
						error: function() { alert(errResearchsit); },
						success: function(data){
							$('#sit_dfl_'+idS).empty();
							
							$.each(data.supports,function(i,sit){							
								lib=$('<div>').css({display:'inline',width:'200px'}).text(sit.id + ' ' +sit.name);
								if(sit.is)
									is=$('<div>').css({display:'inline','float':'right',width:'100px',color:'green'}).text(sit.inStream);
								else
									is=$('<div>').css({display:'inline','float':'right',width:'100px',color:'red'}).text(sit.inStream);
								$('<div>').addClass('sit_elt').prop({id:"sit_" + sit.id}).append(lib).append(is).click(function(){
									$('#sit_list_'+idS).empty();
									$.ajax({
										type: "POST",
										url: "mpAction.do",
										data: {action:'updsit', oldS:idS, idS:sit.id},
										dataType:"json",
										error: function() {alert(errUpdsit);},
										success: function(data){upd_form(data.camSel);}
										})	;
									
								}).appendTo('#sit_dfl_'+idS);
						    });
							$('#sit_list_'+idS).show();
							$('#sit_dfl_'+idS).show();
						}
					})	;				
				},
			wait : 330,
			highlight : true,
			captureLength : 0
		}).appendTo(parent).focus();	
	}		
}
//edition du site
function edisit(){
	var ide = $(this).prop("id");
	var idS = ide.split("_")[1];
	$.ajax({
		type: "POST",
		url: "mpAction.do",
		data: {action:'updsit', oldS:idS, idS:$(this).val()},
		dataType:"json",
		error: function() { alert(errUpdsit); },
		success: function(data){
			upd_form(data.camSel);
		    } 
		})	;
}

//edition d'une date
function edidt(){
	var ide = $(this).prop("id");
	var idP = ide.split("_")[1];
	var field= ide.split("_")[0];
	var parent = $(this).parent();
	
	var ipt= $('<input>').prop({id:'ipt_'+ide, type:'text'}).addClass('dln').css({width:'75px'}).val($(this).text()).datepicker().change(
			function(){
				$.ajax({
					type: "POST",
					url: "mpAction.do",
					data: {action:"upl", idP: idP, field:field, value:$(this).val()},
					dataType:"json",
					error: function() { alert(errUplDate ); },
					success: function(data){							
						var p = data.placement;
 						idP = p.idP;
 						
 						$('#tabP_'+idP).empty();
 						upd_placement(p);
 						
 						$("#"+ide+"_i").prop('src','img/ok.png' ).fadeOut(500); 

					    } 
					})	;	
			}
			);

	$(this).remove();
	parent.append(ipt);
	ipt.focus();
	
	
	
}
//edition champs texte
function editx(){
	var ide =$(this).prop("id"); 
	var ipt =$("#"+ide+"_i").prop('src','img/o.png' );
	var idP = ide.split("_")[1];
	var field = ide.split("_")[0];
	//cas de l'�dition du nom DART : uniquement s'il n'y a pas de r�gle de nomagee
	if(adsId==1 && field == 'dplNm' && ($('#setNT_'+idP).prop('checked') || $('#setNA_'+idP).prop('checked')) ){			
			$.ajax({
				type: "POST",
				url: "mpAction.do",
				data: {action:"upl", idP: idP, field:'setND', value:'d'},
				dataType:"json",
				error: function() { alert(errSetND); },
				success: function(data){
					$('#setNT_'+idP).prop('checked',false);
					$('#setNA_'+idP).prop('checked',false);	
				    } 
				})	;					
	}
	
	var o=ObjectPositionById($(this).prop('id'));
	var div = $('<div>').prop({id:'dipt_'+ide}).addClass('div_input');
	var l = o[0] ; var w=330; 
	if(field == 'dplNm') {l = o[0] ; w=875; }
	if(field == 'tplNm') {l = o[0] ; w=875; }
	div.css({left:l+'px',top:(o[1])+'px',width:w+'px'}).appendTo("#contentTable");
	var tab = $('<table>').appendTo(div);
	var tr = $('<tr>').appendTo(tab);
	var td1 =  $('<td>').appendTo(tr); 
	var td2 =  $('<td>').appendTo(tr);
	
	//bouton fermer
	var a = $('<a>').addClass('aclose').prop("id","close_"+ide).appendTo(td2).click(function(){div.hide(200);});
	$('<img>').prop('src','img/close.png' ).addClass('imgclose').appendTo(a);	
	
	//input text
	var ipt = $('<input>').prop({id:'ajx_'+ide, type:'text'}).addClass('indiv_input').css({width:(w-40)+'px'}).val($(this).text()).focus().appendTo(td1);
	ipt.keydown(function (event) {
		if(event.keyCode == 13){
			//edition du l'id DFA placement
			var action='';
			if(field=='adsId'){action='upadid';} else {action='upl';}				
				$.ajax({
					type: "POST",
					url: "mpAction.do",
					data: {action:action, idP: idP, field:field, value:ipt.val()},
					dataType:"json",
					error: function() { alert(errUpl); },
					success: function(data){
						div.hide(200);
						var p = data.placement;
 						idP = p.idP;
 						
 						$('#tabP_'+idP).empty();
 						upd_placement(p);
 						
 						$("#"+ide+"_i").prop('src','img/ok.png' ).fadeOut(500); 

					    } 
					})	;	
		} 			
	});
	ipt.focus();
	div.show();
}
//edition de la regle de nommage placement
function editcb(){
	var ide = $(this).prop("id"); 		
	var idP = ide.split("_")[1];
	var field = ide.split("_")[0];	
	
	
	if($(this).prop('checked'))
	$('#'+(field == 'setNT'?'setNA':'setNT')+"_"+idP).prop('checked', !$(this).prop('checked'));		
	var value = $('#setNT_'+idP).prop('checked')?'0':($('#setNA_'+idP).prop('checked')?'a':'d');
	$.ajax({
		type: "POST",
		url: "mpAction.do",
		data: {action:"upl", idP: idP, field:field, value:value},
		dataType:"json",
		error: function() { alert(errSetN); },
		success: function(data){
			if(idP==0){
				upd_form(data.camSel);
			}else{
				var p = data.placement;
				idP = p.idP;
				
				$('#tabP_'+idP).empty();
				upd_placement(p);			
			}		
		    } 
		})	;					
}

//Chargement des options pour un placement et un champ donn�
function edisl(){
	var ide = $(this).prop("id"); 
	$("#"+ide+"_i").prop('src','img/o.png' );
	var idP = ide.split("_")[1];
	var field = ide.split("_")[0];
	//cas du Placement Type immutable apr�s cr�ation dans DFA
	if(field=='dplTy' && $('#adsId_'+idP).text()>0){
		alert(cantEditDplTy);
		return false;
	}
	
	var o=ObjectPositionById($(this).prop('id'));
	var div = $('<div>').prop({id:'dipt_'+ide}).addClass('div_input').css({left:(o[0])+'px',top:(o[1])+'px',width:'330px'});
	var tab = $('<table>').appendTo(div);
	var tr = $('<tr>').appendTo(tab);
	var td1 =  $('<td>').appendTo(tr); 
	var td2 =  $('<td>').appendTo(tr);
	var lst = $('<div>').addClass('sel_list').css({left:(o[0])+'px',top:(o[1]+45)+'px',width:'330px'});
	//bouton fermerletter numeric 
	var a = $('<a>').addClass('aclose').prop("id","close_"+ide).appendTo(td2).click(function(){lst.hide(200);div.hide(200);});
	$('<img>').prop('src','img/close.png' ).addClass('imgclose').appendTo(a);	
	
	var ipt = $('<input>').prop({id:'ajx_'+ide, type:'text'}).addClass('box_input').css({width:'290px'}).appendTo(td1);

	ipt.keydown(function (e) {
		if(e.which == 13){
			$(".search_elt").each(function(){
					$(this).show();
			});
		}else {
			var code = eval(e.which);
			var ipv=ipt.val().toUpperCase();
			if(ipv.length>0 && code==8)
				ipv=ipv.substring(0,ipv.length-1);
			if((code>95 && code<106))
				code-= 48;
			if((code>47 && code<58) || (code>64 && code<91))
				ipv+=String.fromCharCode(code).toUpperCase();
				
			$(".search_elt").each(function(){
				if($(this).text().toUpperCase().indexOf(ipv)!=-1){
					$(this).show();
				} else {
					$(this).hide();
				}
			});
			}
		
	});
	
	var dfl = $('<div>');dfl.prop("id","search_dfl"); dfl.appendTo(lst);
	$.ajax({
		type: "POST",
		url: "mpAction.do",
		data: {action:'edisl', idP: idP, field:field},
		dataType:"json",
		error: function() { alert(errEdisl); },
		success: function(data){
			$.each(data.options,function(i,o){				
			 	$('<div>').addClass('search_elt').prop({id:'elt_' + o.value}).html( o.libelle).click(
			 			function(){
			 				ipt.val(o.libelle);
			 				$.ajax({
			 					type: "POST",
			 					url: "mpAction.do",
			 					data: {action:'upl', idP: idP, field:field, value:o.value},
			 					dataType:"json",
			 					error: function() { alert(errUpl); },
			 					success: function(data){
			 						lst.hide(200);div.hide(200);
			 						var p = data.placement;
			 						idP = p.idP;
			 						
			 						$('#tabP_'+idP).empty();
			 						upd_placement(p);
			 						
			 						$("#"+ide+"_i").prop('src','img/ok.png' ).fadeOut(500);
			 					}			 						
			 					});
						}).appendTo(dfl);
			});
		    } 
		})	;	
	div.appendTo("#contentTable");
	lst.appendTo("#contentTable");
	ipt.focus();
}


function upd(){
	var o = selector==""?$(this):$(selector);	
	if(o.prop("type")!='text') execute=true;
	var id=o.prop("id");
	
	var value ;
	if(o.attr("ancid")!=null) {value = o.attr("ancid");id="ancId";}
	else 
	value=o.val();	
	
	$('td[id$="_i"]').each(function(){
		$(this).empty();
	});
	if(execute){
		$.ajax({
			type: "POST",
			url: "mpAction.do",
			data: {action:"upd", camId: camId, field:id, value:value},
			dataType:"json",
			error: function() { alert(errUpd); selector="";},
			success: function(data){
				upd_form(data.camSel);
				var i =$("#"+id+"_i"); 
				i.html("");
				var img = $('<img>').prop('src','img/ok.png' ).css('margin-left','5px' ).appendTo(i);
				img.fadeOut(500);
				selector="";
			    } 
			})	;		
	}
}


//ajout d'un landing page
function addLp(){	
	$.ajax({
		type: "POST",
		url: "mpAction.do",
		data: {action:"alp", "idTM":0, camId: camId},
		dataType:"json",
		error: function() { alert(errAddLp); },
		success: function(data){
			upd_form(data.camSel);
		    } 
		});
}
//sauvegarde landing page
function saveLp(idTM){
	//var idTM = $(this).prop('id').split('_')[1];
		$.ajax({
			type: "POST",
			url: "mpAction.do",
			data: {action:"ulp","idTM":idTM,camId: camId, "lpName":$('#lpName_'+idTM).val(), "lpUrl":$('#lpUrl_'+idTM).val()},
			dataType:"json",
			error: function() { alert(errUpl);},
			success: function(data){upd_form(data.camSel);} 
			})	;		
}
//suppression landing page
function delLp(){
	var idTM = $(this).prop('id').split('_')[1];
	$.ajax({
		type: "POST",
		url: "mpAction.do",
		data: {action:"dlp","idTM":idTM, camId:camId},
		dataType:"json",
		error: function() { alert(errDlp); },
		success: function(data){
			upd_form(data.camSel);
		    } 
		})	;
}

function deldfa(){		
	dfa("deldfa");

}
function loadfa(){		
	dfa("loadfa");
}
function upldfa(){	
	if(adsId!=1) return;
	dfa("upldfa");
}

function dfa(action){
	if(action=="deldfa"){
		if(!confirm(msgDelCam)) return false;
	}
		
		var itv=0;
		var div=$('#loadDFA');
		var object=$('#oloadDFA');
		var w=$(document).width();
		var h=$(document).height();
		div.width(w);
		div.height(h);		
		div.show();
		$("#loadDFA").empty();$("#submsg").empty();$("#msg").empty();
		$("html, body").animate({ scrollTop: 0 }, "slow");		
		$('<div>').addClass("objDFA").append(object).appendTo(div);
		$('<div>').prop({id:"submsg"}).addClass("msgDFA").appendTo(div);
		var a = $('<a>').addClass('aclose').prop("id","search_close").appendTo("#submsg");
    	$('<img>').prop('src','img/close.png' ).addClass('imgclose').appendTo(a);			    	
    	$('#search_close').click(function(){$("#loadDFA").hide();});
		$('<div>').prop({id:"msg"}).appendTo("#submsg");
		
		
		$.ajax({
			type: "POST",
			url: "mpAction.do",
			data: {"action":action,camId:camId},
			dataType:"json",
			error: function() { alert(errDelCam); },
			success: function(data){
				upd_form(data.camSel);
				object.appendTo("#divhidden");
				clearInterval(itv);
			    } 
			})	;	
		
		itv=setInterval(function(){
			$.ajax({
				type: "POST",
				url: "mpAction.do",
				data: { action: "counter"},
				dataType:"json",
				error: function() { alert("Error counter request."); },
				success: function(data){
					$.each(data.msg,function(i,m){
							$("#msg").append($("<p>").css({color:m.color}).text(m.msg));		
						});													
				  } 
				});					
	},1000);
		
}

	function removeOk() {
		$("camName_i").remove('.ok');
	}