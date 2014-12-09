
function popUp(URL, h, w){
	eval("window.open('" + URL + "', '', 'toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=1,width=" + w +",height=" + h + ",left = 50,top = 50');");
}

function getScrollTop(){
    if(typeof pageYOffset!= 'undefined'){
        //most browsers except IE before #9
        return pageYOffset;
    }
    else{
        var B= document.body; //IE 'quirks'
        var D= document.documentElement; //IE with doctype
        D= (D.clientHeight)? D: B;
        return D.scrollTop;
    }
}

function setScrollTop(s) {	
	$('body').scrollTop( s );
}

function ObjectPositionById(id) {
	var obj = document.getElementById(id);
	return ObjectPosition(obj);
}
function ObjectPosition(obj) {
	if(obj==null) return [0,0];
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
//Fonction permettant de connaître la position d'un objet
//par rapport au bord gauche de la page.
//Cet objet peut être à l'interieur d'un autre objet.

function getLeft(MyObject){
	if (MyObject.offsetParent)
		return (MyObject.offsetLeft + getLeft(MyObject.offsetParent));
	else
		return (MyObject.offsetLeft);
}
function getTop(MyObject){
	//idem rapport au bord haut de la page.
	if (MyObject.offsetParent)
		return (MyObject.offsetTop + getTop(MyObject.offsetParent));
	else
		return (MyObject.offsetTop);
}



/*init de la barre de recherche*/
function initSearch(str){
	var strs = str.split(" ");
	for(var i=0;i<strs.length;i++){
		if(strs[i].indexOf("tfk:")!=-1){
			var oHandler = $('#selTfk').msDropDown({mainCSS:'dd2'}).data("dd");				
			if(oHandler) {
				var idx = getIdx("#selTfk",strs[i].substr(4));
				oHandler.set("selectedIndex", idx);
				oHandler.set('value',strs[i].substr(4));
			}
		}
		else if(strs[i].indexOf("sta:")!=-1){
			var oHandler = $('#selSta').msDropDown({mainCSS:'dd2'}).data("dd");				
			if(oHandler) {
				var idx = getIdx("#selSta",strs[i].substr(4));
				oHandler.set("selectedIndex", idx);
				oHandler.set('value',strs[i].substr(4));
			}
		}	else if(strs[i].indexOf("alj:")!=-1){
			var oHandler = $('#selAlj').msDropDown({mainCSS:'dd2'}).data("dd");				
			if(oHandler) {
				var idx = getIdx("#selAlj",strs[i].substr(4));
				oHandler.set("selectedIndex", idx);
				oHandler.set('value',strs[i].substr(4));
			}
		}
	}	
}
/*clic sur le Sonic*/
function sonic(ab){
	if(ab == 'a'){
		$('#search_ipt').val("sta:20 tfk:none");
	} 
	$('#search').submit();
}  

/*Verification du format des dates*/
function checkDate(date){
	var ok = true;
	var separateur = "-";
	var ymd=date.split(separateur);
	var j = ymd[2];
	var m = ymd[1];
	var a = ymd[0];


	if ( ((isNaN(j)) || (j < 1) || (j > 31)) )      {
		alert("Le jour du champ Date n'est pas correct.");
		ok = false;
	}      else if ( ((isNaN(m)) || (m < 1) || (m > 12)) )  {
		alert("Le mois du champ Date n'est pas correct.");
		ok = false;
	}      else if ( (isNaN(a)) || a.length != 4 )      {
		alert("L'ann�e n'est pas correcte.");
		ok = false;
	} 
	return ok;
}

//positionner les div des calendriers c en se callant sur l'image i
function offset(i, c, left, top){
	var img = document.getElementById(i);
	var ctn = document.getElementById(c);
	if(img != null && ctn!=null){
		o = ObjectPosition(img);
		ctn.style.marginLeft = eval(o[0] + left) + "px";
		ctn.style.marginTop = eval(o[1] + top) + "px";
		//pour IE, pr�ciser la largeur
		ctn.style.width=190;
	}
}

function checkDatesValue(debut, fin ,aftertime){
	var today =new Date();
	var ddebut =new Date(0);
	ddebut.setFullYear(debut.substring(6));
	ddebut.setMonth(debut.substring(3,5)-1);
	ddebut.setDate(debut.substring(0,2));
	var dfin =new Date();
	dfin.setFullYear(fin.substring(6));
	dfin.setMonth(fin.substring(3,5)-1);
	dfin.setDate(fin.substring(0,2));
	if(ddebut > dfin) return 'inversion';
	var ecart = (today - dfin)/86400000;
	if(ecart > aftertime) return 'archivage';
	if(ecart > 0) return 'beforetoday';
	else return 'ok';
}

function checkDatesRequestValue(debut, fin){
	var today =new Date();
	var ddebut =new Date();
	ddebut.setDate(debut.substring(0,2));
	ddebut.setMonth(debut.substring(3,5)-1);
	ddebut.setFullYear(debut.substring(6));
	var dfin =new Date();
	dfin.setDate(fin.substring(0,2));
	dfin.setMonth(fin.substring(3,5)-1);
	dfin.setFullYear(fin.substring(6));
	if(ddebut > dfin) return 'inversion';
	else return 'ok';
}


//enregistrer l'etat d'affichage
function getDisp(){
	var recorDisp="";
	var q="divLeftT,style.display;divLeftC,style.display;divLeftCtc,style.display;divRightCtc,style.display;divCampaignDisplay,style.display;dispTE,textContent;dispTE,title;dispTE,className;divCreaRmqCard,style.display;tabTDisplay,className;tabCDisplay,className;tabCtc,style.display";
	var r=q.split(";");
	for(var i=0;i<r.length;i++){
		var rs=r[i].split(",");
		if(document.getElementById(rs[0])!=null){
			if(rs[1]  == 'style.display') {              
				recorDisp+= rs[0] + "," + rs[1] + "," + document.getElementById(rs[0]).style.display+";";
			}  else if(rs[1] == 'className') {
				recorDisp+= rs[0] + "," + rs[1] + "," + document.getElementById(rs[0]).className+";";
			} else if(rs[1] == 'src') {
				recorDisp+= rs[0] + "," + rs[1] + "," + document.getElementById(rs[0]).src+";";
			}else if(rs[1] == 'textContent') {
				recorDisp+= rs[0] + "," + rs[1] + "," + document.getElementById(rs[0]).textContent+";";
			}else if(rs[1] == 'title') {
				recorDisp+= rs[0] + "," + rs[1] + "," + document.getElementById(rs[0]).title+";";
			}    	  
		}
	}
	return recorDisp;
}

//appliquer l'etat d'affichage
function setDisp(recorDisp){

	var r=recorDisp.split(";");
	for(var i=0;i<r.length;i++){
		var rs=r[i].split(",");
		if(document.getElementById(rs[0])!=null){
			if(rs[1]  == 'style.display') {
				document.getElementById(rs[0]).style.display=rs[2];
			} else if(rs[1] == 'className') {
				document.getElementById(rs[0]).className=rs[2];
			} else if(rs[1] == 'src') {
				document.getElementById(rs[0]).src=rs[2];
			}else if(rs[1] == 'textContent') {
				document.getElementById(rs[0]).textContent=rs[2];
			} else if(rs[1] == 'title') {
				document.getElementById(rs[0]).title=rs[2];				
			}  else if(rs[1] == 'textContentE') {
				document.getElementById(rs[0]).textContent=eval(rs[2]);
			} else if(rs[1] == 'titleE') {
				document.getElementById(rs[0]).title=eval(rs[2]);
			}    	  
		}
	}    
}

function dispbut(elt){
	var leftT = document.getElementById("divLeftT");
	var leftC = document.getElementById("divLeftC");
	var leftCtc = document.getElementById("divLeftCtc");
	var rightCtc = document.getElementById("divRightCtc");
	var tabT = document.getElementById("tabTDisplay");
	var tabC = document.getElementById("tabCDisplay");
	var tabCtc = document.getElementById("tabCtcDisplay");
	var creaRmq=document.getElementById("divCreaRmqCard");
	if(elt == "DocumentTDisplay") {
		leftT.style.display='block';tabT.className = 'open';
		leftC.style.display='none';tabC.className = 'close';creaRmq.style.display='none';
		leftCtc.style.display='none';rightCtc.style.display='none';tabCtc.className = 'close';
	} else if(elt == "DocumentCDisplay") {
		leftT.style.display='none';tabT.className = 'close';
		leftC.style.display='block';tabC.className = 'open';creaRmq.style.display='block';
		leftCtc.style.display='none';rightCtc.style.display='none';tabCtc.className = 'close';
	} else if(elt == "CtcDisplay") {
		getDocChecked(true);
		leftT.style.display='none';tabT.className = 'close';
		leftC.style.display='none';tabC.className = 'close';creaRmq.style.display='none';
		leftCtc.style.display='block';rightCtc.style.display='block'; tabCtc.className = 'open';
		$("#tabCtc").hide();
	}
}

function upl(e) {
	if (e.keyCode == 13) {
		submitCampaign('upl');
	}
	return true;
}

function displayCampaign(camId){
	var dosubmit = true;
	var cf = document.getElementById("campaignForm");
	//dispTE("cam");	
	//if($('input[name="search"]').val()==""){			
		//dispTE("wait");	
		//$("#divCampaignDisplay").css("display","none");
		// $("#dispTE").removeClass("tab0").prop({'title':camDisplayYTitle}).text(camDisplayY);
	//}
	cf.id.value = camId;
	cf.actionPerformed.value="display";		
	cf.scrollTop.value =getScrollTop();
	cf.recorDisp.value=getDisp();
	cf.submit();
}

function submitCampaign(actionPerformed){
    var cf = document.getElementById("campaignForm");
    cf.actionPerformed.value = actionPerformed;
    cf.scrollTop.value = getScrollTop();
  	
    if(actionPerformed=='upl'){    	
      cf.submit();      return;
    }
    if($('#camType').prop("checked")){
    	cf.camType.value="2";
    	$('input[name="camType"]').val("2");
    } else $('input[name="camType"]').val("1");
    
    var debut = cf.formatedDateBegin.value;
    var fin = cf.formatedDateEnd.value;
    cf.recorDisp.value=getDisp();
    if(actionPerformed=="new"){
    isSubmited = 1;
     cf.submit();    return;
    }
    
    if(isSpotLink && cf.ptmId.value == "")  {
        alert (fillebuyingv); return;
    }

    if(cf.ancId.value == "-1")  {
        alert (fillAdvertiser); return;
      } else if(cf.name.value == "")  {
        alert (fillCampaign); return;
      } else if(!checkDate(debut))  {
    	  if(!confirm(fillDate)) return;
      } else if(!checkDate(fin))  {
    	  if(!confirm(fillDate)) return;
      }
      var verif = checkDatesValue(debut,fin,180);
      if(verif=='inversion'){
        alert (dateInversion); return;
      } else if(verif=='archivage'){
    	  if(!archivate){if(!confirm (dateArchivage))  return;}
      } else if(verif=='beforetoday'){
    	  if(!ended){if(!confirm (dateBeforeToday)) return;}
      }
         
    cf.scrollTop.value = getScrollTop();
    isSubmited = 1;   
    cf.submit();
  }
    	  
//validation/invalidation/desinvalidation d'un document
function validate(idDoc,actionPerformed){
	var cf = document.getElementById("campaignForm");
	cf.actionPerformed.value = actionPerformed;
	if(actionPerformed=='validate'){
		cf.stValidate.value=1;cf.idValidate.value = idDoc;
	}else if(actionPerformed=='invalidate'){
		cf.stValidate.value=-1;cf.idValidate.value = idDoc;
	}else if(actionPerformed=='novalidate'){
		cf.stValidate.value=0;cf.idValidate.value = idDoc;
	}else if(actionPerformed=='chk_validate'){
		cf.stControlate.value=1;cf.idControlate.value = idDoc;
	}else if(actionPerformed=='chk_invalidate'){
		cf.stControlate.value=-1;cf.idControlate.value = idDoc;
	}else if(actionPerformed=='chk_novalidate'){
		cf.stControlate.value=0;cf.idControlate.value = idDoc;
	}
	cf.scrollTop.value = getScrollTop();
	cf.recorDisp.value=getDisp();
	
	cf.submit();
}

//validation/invalidation/desinvalidation d'un type document multiple
function suvalidate(id,actionPerformed){

	var cf = document.getElementById("campaignForm");
	cf.actionPerformed.value = actionPerformed;
	if(actionPerformed=='suvalidate'){
		cf.suValidate.value=1; cf.dtValidate.value = id;
	}else if(actionPerformed=='suinvalidate'){
		cf.suValidate.value=-1; cf.dtValidate.value = id;
	} else if(actionPerformed=='sunovalidate'){
		cf.suValidate.value=0; cf.dtValidate.value = id;
	} else if(actionPerformed=='chk_suvalidate'){
		cf.suControlate.value=1; cf.dtControlate.value = id;
	} else if(actionPerformed=='chk_suinvalidate'){
		cf.suControlate.value=-1;cf.dtControlate.value = id;
	} else if(actionPerformed=='chk_sunovalidate'){
		cf.suControlate.value=0;cf.dtControlate.value = id;
	}

	cf.scrollTop.value = getScrollTop();
	cf.recorDisp.value=getDisp();
	cf.submit();
}

function newAccess(actionPerformed){
	var cf = document.getElementById("campaignForm");
	var msg;
	if(actionPerformed=="newAccessPw") msg=newAccessPw;
	if(actionPerformed=="newAccessLink") msg=newAccessLink;
	if (confirm(msg))    {
		cf.actionPerformed.value = actionPerformed;
		cf.scrollTop.value = getScrollTop();
		cf.recorDisp.value=getDisp();
		cf.submit();
	}
}

function deleteCampaign(){
	var cf = document.getElementById("campaignForm");
	if (confirm(confirmDeleteCampaign))    {
		cf.actionPerformed.value = "delete";
		cf.scrollTop.value = getScrollTop();
		cf.recorDisp.value=getDisp();
		cf.submit();
	}
}

function enableFile(supertype){
	var df = document.getElementById("documentForm");	
	if(df == null) return false;
	if(supertype=='T'){
		if(df.docfileT.value == '') {
			df.docTypeIdT.value=-1;
			return false;
		}
		if(df.docTypeIdT.value == -1) return false;
		document.getElementById("btnDocFile"+supertype).style.display='block';			
	}
	else return false;
}
function insertFile(supertype){	  
	var df = document.getElementById("documentForm");
	df.supertype.value=supertype;
	df.currentPage.value = "index";
	df.actionPerformed.value = "insert";
	var fileUploaded=null; var td; var tdi;
	if(supertype=="T"){
		td = document.getElementById("tdFileT");
		tdi = '<input type="file" name="docfileT" class="box_input" value=""/>';
		fileUploaded = df.docfileT.value ;
	}else if(supertype=="C"){
		td = document.getElementById("tdFileC");
		// tdi = '<input type="file" name="docfileC" class="box_input" value=""/>';
		fileUploaded = df.docfileC.value ;
	}
	var e = fileUploaded.substring(fileUploaded.lastIndexOf('.'),fileUploaded.length).toLowerCase();

	if(e.length == 0)    {
		alert(emptyFile);
		if(td!=null){
			td.innerHTML = "";td.innerHTML = tdi;	
		}		
		return false;
	} else if(supertype=='C' && (e != ".zip" && e != ".rar" && e != ".7z" && e != ".tar" && e != ".tgz")) {
		alert(zipFile);
		if(td!=null){
			td.innerHTML = "";	
		}		
		return false;      
	}
	df.camId.value = camId;
	df.authorId.value = usrId;
	df.scrollTop.value =  getScrollTop();
	df.recorDisp.value = getDisp();
	df.submit();
}
function deleteFile(id){
	if(!confirm (confirmDeleteFile))  return;
	var df = document.getElementById("documentForm");
	df.currentPage.value = "index";
	df.actionPerformed.value = "delete";
	df.camId.value =camId;
	df.id.value = id;
	df.scrollTop.value = getScrollTop();
	df.recorDisp.value = getDisp();
	df.submit();
}
function finish(typeId){
	var df = document.getElementById("documentForm");
	df.currentPage.value = "index";
	df.actionPerformed.value = "finish";
	df.camId.value = camId;
	df.scrollTop.value = getScrollTop();
	df.recorDisp.value = getDisp();
	df.submit();
}
function dispAuthor(formatedAuthor){
	var t=formatedAuthor.split("¤");
	document.getElementById("nomCreaCard").value = unescape(t[1]);
	document.getElementById("prenomCreaCard").value = unescape(t[2]);
	document.getElementById("steCreaCard").value = unescape(t[4]);
	document.getElementById("telCreaCard").value = unescape(t[5]);
	var rmq = unescape(t[6]);
	document.getElementById("taRmqCreaCard").value = rmq.replace(/<br>/g,"\n");
}
function switchDisp(divToDisplay,divToHide){
	document.getElementById(divToDisplay).style.display="block";
	document.getElementById('col'+divToDisplay).setAttribute("class", "openb");
	document.getElementById(divToHide).style.display="none";
	document.getElementById('col'+divToHide).setAttribute("class", "closeb");
}

function submitContact(action, usrId, camId){
	getDocChecked(false);//liste des documents joints
	var f = document.getElementById("ctcForm");
	if(action=='close'){
		$("#tabCtc").hide(100); 
		return;
	} 

	if(action=='delete'){
		if(!confirm (confirmContactDelete))  return;
	}
	if(action == 'new' || action == 'edit' || action == 'update' )
		$("#tabCtc").show(100);
	else
		$("#tabCtc").hide(100);

	f.usrId.value=usrId;
	f.camId.value=camId;
	f.actionPerformed.value=action;
	f.scrollTop.value = getScrollTop();
	f.recorDisp.value=getDisp();
	//if(action=='sendemail')
	//	wysiwygCtc.instanceById('niceEditAreaCtc').saveContent();  
	f.submit();
}
function activeContact(){
	var f = document.getElementById("ctcForm");
	f.actionPerformed.value="active";
	f.scrollTop.value = getScrollTop();
	f.submit();
}

//selection to/cc/bcc
function selEmail(to,id){
	var check = document.getElementById(to+id).checked?1:0;	  
	document.getElementById("to"+id).checked=0;
	document.getElementById(to+id).checked=check;
	getDocChecked(true);
}

//methode declenchee au onchange des checkbox
//examine tous les elements coches sd+id et affiche
//divSendByEmail si au moins 1 est coche  
function getDocChecked(hide){
	if(hide) $("#tabCtc").hide(100);
	var ids=new Array("0");
	var selStr="";
	var li="";
	var nbc=0;
	//nombre de contacts selectionnes
	$("input[name='selTo']:checked").each(function() {
		nbc++;selStr+=";T"+$(this).prop('value');
	});
	document.getElementById("ctcForm").selStr.value=selStr;


	//nombre de documents selectionnes
	$("input[id^='sd']").each(function() {
		if($(this).is(':checked')){
			var id=$(this).prop('id').replace('sd','');
			ids.push(id);
			$("a[href='downloadAction.do?docId="+id+"']").each(function() {
				li+= "<li>"+$(this).text() + "</li>";					 
			});
		}
	});
	var nbc_=''+ nbc + selectedCtc;
	$("#msgsend").html(nbc_);
	if(nbc>0) $("#asend").show();
	else  $("#asend").hide();

	$("#pj").html("<ul>" + li + "</ul>");
	if(ids.length>1) $("#apj").show();
	else  $("#apj").hide();

	document.getElementById("ctcForm").selDoc.value=ids;
}

String.prototype.trim = function(){return this.replace(/\s*/g,"")};

function getLinkTxt(){        
	return txt;
}

function addLink(){
	//var txtRmq = wysiwygCtc.instanceById('niceEditAreaCtc').getContent();
	//txtRmq += getLinkTxt();
	//wysiwygCtc.instanceById('niceEditAreaCtc').setContent(txtRmq);
}

function hideDiv(divName){
	document.getElementById(divName).style.display='none';
}


//masque et reaffiche le tableau des campagnes
function dispTE(action){
	switch(action){
	case 'wait':
		$("#divCampaignDisplay").css("display","none");
		 $("#dispTE").removeClass("tab0").prop({'title':camDisplayYTitle}).text(camDisplayY);
		$("#divCampaign").hide("blind", { direction: "up", complete:function(){		
		$('#divCampaignDisplay').hide( "blind", { direction: "up", complete:function(){			
			$('#footer').append($('<div>').css({width:'600px',height:'200px','text-align': 'center'}).append($('<img>').prop({src:'img/466.GIF'}).css({'margin-top':'68px',height:'64px', width:'64px'} )));			
		},duration:50 });
	} , duration:550} );
	
	case 'cam':
		$("#divCampaign").hide("blind", { direction: "up", duration:200} );
		
	case 'down':  if ( $("#dispTE").hasClass("tab0") ) {
		$("#dispTE").removeClass("tab0").prop({title:camDisplayYTitle}).text(camDisplayY);
		  $('#divCampaignDisplay').hide( "blind", { direction: "up" }, "slow" );
		  $("#divCampaignDisplay").css("display","none");
	  } else {
		  $("#dispTE").addClass("tab0").prop({title:camDisplayNTitle}).text(camDisplayN);
		  $('#divCampaignDisplay').show( "blind", { direction: "up" }, "slow" );
		  $("#divCampaignDisplay").css("display","block");
	  }
	}
}




//chargement du logbook
function camlog(){	
	
	var div = $('#tablog');		
	if(div.css("display") == "none"){
		$.ajax({
			type: "POST",
		    url: 'camdifAction.do',
		    data: {action:"camlog"},
		    dataType: 'json',
		    error: function() { alert(errorRequest); },
		    success: function(data) {
		    	div.empty();
		    	var tablog=$('<table>').addClass('userstm').appendTo("#tablog");
		    	var tr=$('<tr>').appendTo(tablog);
	    		$('<th>').text("#").appendTo(tr);
	    		$('<th>').text(tablogid).appendTo(tr);
	    		$('<th>').text(tablogdate).appendTo(tr);
	    		$('<th>').text(tabloguser).appendTo(tr);
	    		$('<th>').text(tablogope).appendTo(tr);
	    		$('<th>').text(tablogdocid).appendTo(tr);
			    $.each(data.opes,function(i,o){
		    		tr=$('<tr>').appendTo(tablog);
		    		$('<td>').text(i).appendTo(tr);
		    		$('<td>').text(o.id).appendTo(tr);						    		
		    		$('<td>').text(o.formatedDate).appendTo(tr);
		    		$('<td>').text(o.user.formatedName).appendTo(tr);
		    		$('<td>').text(o.opeLib).appendTo(tr);
		    		$('<td>').text(o.docId).appendTo(tr);
		        });
		    }
		});
		div.show(200);	
	}else{
		div.hide(500);
	} 	
}
function state(){
	var div = $('#difMsg');		
	var aid=$(this).prop('id');
	if(div.css("display") == "none"){
		state_reset('state',null);
		var o = ObjectPositionById(aid);
		div.css("left",(o[0]+11)+"px");
		div.css("top",(o[1]-5)+"px");
		div.show(200);	
	}else{
		div.hide(500);
	} 
	
}
function reset(){
	var coll = eval($(this).prop('id').split("_")[1]);	
	state_reset('reset',coll);
}
function state_reset(action, coll){
	var div = $('#difMsg');	div.empty();		
		$.ajax({
			type: 'POST',
   			url: 'stateAction.do',
   			data: {action:action, coll:coll},
			dataType: 'json',
			error: function() { alert(errorRequest); },
			success: function(data) {	
				
				var tablog=$('<table>').addClass('camdif').appendTo(div);
		    	var tr=$('<tr>').appendTo(tablog);
	    		$('<th>').text("#").appendTo(tr);
	    		$('<th>').text('Collection').appendTo(tr);
	    		$('<th>').text('Size/State').appendTo(tr);
	    		$('<th>').text('Reset').appendTo(tr);
			    $.each(data.cc.states,function(i,o){
			    		tr=$('<tr>').appendTo(tablog);
			    		if(i%2==0) tr.css({"background-color": "#FEE2E5"});
			    		$('<td>').text(i+1).appendTo(tr);
			    		$('<td>').text(o.libelle).appendTo(tr);
			    		$('<td>').text(o.value).css({"text-align":"right"}).appendTo(tr);
			    		 if(o.rank==data.cc.dbrank && !data.cc.dbswitch){
			    			 $('<td>').appendTo(tr);
						    }else{
						    	$('<td>').append($("<a>").prop({id:'areset_'+o.rank}).addClass('reset').append($('<img>').prop('src','img/reset.png')).click(reset)).appendTo(tr);	
						    }
			    		
			    	
		        });
			    $('<div>').css({margin:'25px'}).append($("<a>").prop({id:'areset_0'}).addClass('reset').append($('<img>').prop('src','img/reset.png')).click(reset)).appendTo(div);
			    if(action == 'reset' && (coll == 0 || coll == data.cc.dbrank)) {window.location.reload();}
			}
		});				
}

function camsdif(){
 	  $.ajax({
 		type: 'POST',
 			url: 'camdifAction.do',
 			data: {action:'camsdif'},
 			dataType: 'json',
 			error: function() { },
 			success: function(data) {
 				$("span.dif").empty();
 				$.each(data.camsdif,function(j,c){
 					$('#rownum'+c +" td.modif").css({'font-weight':'bold'});
 					$('<a>').prop({id:'adif_'+c,href:"#",title:tcamsdif}).addClass('infw').click(camdif).append($('<img>').prop({src:'img/infw.png',alt:'last update'})).appendTo('#dif'+c);
 				});
 				
 				$.each(data.camsnif,function(j,c){
 					$('#rownum'+c +" td.modif").css({'font-weight':'normal'});
 					$('<a>').prop({id:'adif_'+c,href:"#",title:tcamsnodif}).addClass('info').click(camdif).append($('<img>').prop({src:'img/infn.png',alt:'last update'})).appendTo('#dif'+c);
 				});
 			}
 		});
 	  
 	
   }
	function camdif(){
			var div = $('#difMsg');	div.empty();
			var aid=$(this).prop('id');				
			if(div.css("display") == "none"){				
				$.ajax({
					type: 'POST',
		   			url: 'camdifAction.do',
		   			data: {action:'camdif',camId:aid.split('_')[1]},
					dataType: 'json',
					error: function() { alert(errorRequest); },
					success: function(data) {
						
						var d=$('<div>').text("["+data.cam.id + "] " + data.cam.ancNameMAJ+ " - " + data.cam.name).appendTo(div);
						var a=$('<a>').prop("id","close_camdif").addClass('aclose').click(function(){div.hide(500);}).append($('<img>').prop('src','img/close.png' ).addClass('imgclose'));
						var tablog=$('<table>').css({width:'100%'}).appendTo(div);
						tr=$('<tr>').appendTo(tablog);
    					$('<td>').append(d).appendTo(tr);	
    					$('<td>').css({width:'30px'}).append(a).appendTo(tr);
    					
						tablog=$('<table>').addClass('camdif').appendTo(div);
				    	var tr=$('<tr>').appendTo(tablog);
			    		$('<th>').text("#").appendTo(tr);
			    		$('<th>').text(tablogdate).appendTo(tr);
			    		$('<th>').text(tabloguser).appendTo(tr);
			    		$('<th>').text(tablogope).appendTo(tr);
			    		$('<th>').text(tablogdocument).appendTo(tr); 

			    		
			    		$.each(data.opes,function(i,o){
			    			if(o.isOpeDif){
			    				if(o.isDif){									 								
			    					tr=$('<tr>').prop({'id':'tr_'+o.id}).appendTo(tablog);
			    					$('<td>').text(i).appendTo(tr);				    		
				    				$('<td>').text(o.formatedDate).css({'color':'#9E0215'}).appendTo(tr);
				    				$('<td>').text(o.user.formatedName).css({'font-weight':'bold','color':'#9E0215'}).appendTo(tr);
				    				$('<td>').text(o.opeLib).css({'font-weight':'bold','color':'#9E0215'}).appendTo(tr);
			    				}else{
			    					tr=$('<tr>').prop({'id':'tr_'+o.id}).appendTo(tablog);
			    					$('<td>').text(i).appendTo(tr);				    		
				    				$('<td>').text(o.formatedDate).appendTo(tr);
				    				$('<td>').text(o.user.formatedName).appendTo(tr);
				    				$('<td>').text(o.opeLib).appendTo(tr);			    								    				
			    				}
			    				if(o.docId>0){
			    					var a = $('<a>').prop({'href':'downloadAction.do?docId='+o.docId}).text(o.docName);
			    					$('<td>').append(a).appendTo(tr);	
			    				}else{
			    					$('<td>').text(o.docName).appendTo(tr); 
			    				}
			    			}

			    		});					    
						var o = ObjectPositionById(aid);
						div.css("left",(o[0]+11)+"px");
						div.css("top",(o[1]-5)+"px");
						div.show(200);
					}
				});

			}else{
				div.hide(500);
			} 
			
	}
//gestion des boutons ghost du tableau des plan traffic manager SPOT
function ghostable_hover(){
	var img=$(this).find('img').hide();
	var idP=eval($(this).prop('id').split('_')[1]);
	var cb=$('<input>').prop({id:"cb_"+idP, type:'checkbox',title:img.prop('title'),checked:!eval(img.attr("ghost"))}).click(function(){
		var cf = document.getElementById("campaignForm");							
		cf.actionPerformed.value = "ghost";	
		cf.ghost.value=!cb.prop('checked');							
		cf.idP.value=idP;
		cf.scrollTop.value = getScrollTop();
		cf.submit();
	}).appendTo($(this));
}

function ghostable_out(){
	$(this).find('input').remove();
	$(this).find('img').show();						
}

function allGhost(){
	var thisCheck = $(this);
	
	if ( thisCheck.is(':checked') ) {
		var cf = document.getElementById("campaignForm");							
		cf.actionPerformed.value = "setAllGhost";
		cf.ghost.value=true;
		cf.submit();
	  }
	else{		
		var cf = document.getElementById("campaignForm");							
		cf.actionPerformed.value = "setAllGhost";
		cf.ghost.value=false;
		cf.submit();
	}
	
}

function makeDialogRedmine(){
	var divlm=document.createElement("div");
	divlm.id='lmessage';
	//divlm.title=popupLoadRedTitle;
	divlm.innerHTML='<p>'+popupLoadRedBody+'</p>';
	divlm.style.display = 'none';
	document.getElementById('divCampaignEdit').appendChild(divlm);
}

//charge les issues Redmine
function loadRedmine(){
	$('#redmine').empty();
	$('#redmine').append($('<div>').css({width:'600px',height:'200px','text-align': 'center'}).append($('<img>').prop({src:'img/466.GIF'}).css({'margin-top':'68px',height:'64px', width:'64px'} )));
	
	makeDialogRedmine();
	
	$.ajax({
		type: "POST",
		url: 'redAction.do',
		data: {action:"display"},
		dataType: 'json',
		error: function() { $('#redmine').empty();},
		success: function(data) {			
			$('#redtitle').empty();
			$('#redimg').empty();
			$('#redmine').empty();
			if(data==null) return false;
			if(data.no_user) return false;
			if(data.no_campaign) return false;
			if(data.connected==false){
				$('#redtitle').text(redidxnoconnect);
				return false;
			}
			if(data.haveThisUser){
					$('#redtitle').text(data.displayType=='a'?subtitlea:subtitleb);
					var a=$('<a>').prop({href:'#campaignEditTable'}).addClass(data.displayType=='a'?'redlink_a':'redlink_b').click(function(){
					$.ajax({
						type: "POST",
						url: 'redAction.do',
						data: {action:'cam'},
						dataType: 'json',
						error: function() {  },
						beforeSend: function(){							
							$("#lmessage").dialog({position: {my: "center", at: "center", of: "#divCampaignEdit"},dialogClass: 'myTitleClass'});
						},
						success: function(data) {
							$("#lmessage").dialog("close");
							var x='_newtab';x+=+Math.random();
							var myW= window.open(data.url, x,"width=1000,height=900,scrollbars=yes");
							
						}
					});
				}).appendTo('#redimg');
			} 
			if(data.issues==null || data.issues.length==0){
				$('#redmine').empty();
				$('#redmine').append($('<p>').text(noissue));
				return false;
			}
			$('#redmine').empty();
			var div,table,tr,td;						    	
			var alldiv=$('<div>').addClass('box_html').css({width:'600px',height:'200px'}).appendTo('#redmine');

			$.each(data.issues,function(i,o){
				div=$('<div>').prop({id:"red_"+o.id}).css({'margin':'0 0 5px 0'}).appendTo(alldiv);
				table=$('<table>').addClass('userstm').css({width:'600px','border':'1px solid Silver','border-collapse':'collapse'}).appendTo(div);	
				//première ligne
				tr=$('<tr>').appendTo(table);
				td=$('<td>').css({width:'60px'}).appendTo(tr);						    								    		
				$('<div>').prop({title:redidxstatus+o.status}).css({width:'60px'}).addClass(o.statusClass).text(o.status).appendTo(td);
				td=$('<td>').css({width:'60px'}).appendTo(tr);
				$('<div>').prop({title:redidxpriority+o.priority}).css({width:'60px'}).addClass(o.priorityClass).text(o.priority).appendTo(td);
				//distinction : issue cree manuellement sur redmine (noJournal=true) ou auto 
				if(o.noJournal){
					td=$('<td>').css({width:'40px','border-left':'1px solid Silver'}).appendTo(tr);
					$('<div>').addClass('box_oneline').css({width:'40px',height:'15px','text-decoration':'underline'}).text(redidxsubject).appendTo(td);
					td=$('<td>').css({width:'10px'}).text(':').appendTo(tr);
					td=$('<td>').css({width:'100px'}).appendTo(tr);
					$('<div>').addClass('box_oneline').css({width:'100px',height:'15px'}).prop({title:o.subject}).text(o.subject).appendTo(td);
					td=$('<td>').prop({'rowspan':3}).css({'vertical-align':'top','border-left':'1px solid Silver'}).appendTo(tr);
					$('<div>').addClass('box_html').css({width:'280px',height:'58px'}).text(o.description).appendTo(td);
				} else {
					td=$('<td>').prop({'rowspan':3}).css({'vertical-align':'top','border-left':'1px solid Silver'}).appendTo(tr);
					div=$('<div>').addClass('box_html').css({width:'443px',height:'58px'}).appendTo(td);
					var ul= $('<ul>').addClass('notes').appendTo(div);
					$.each(o.journals,function(i,j){
						$('<li>').html(j.createdOn + " : " + j.notes).appendTo(ul);
					});
				}
				
				
				//deuxieme ligne
				tr=$('<tr>').appendTo(table);
				td=$('<td>').prop({'colspan':2}).appendTo(tr);
				$('<div>').addClass('box_oneline').css({width:'100px',height:'15px'}).prop({title:o.tracker}).text(o.tracker).appendTo(td);
				if(o.noJournal){
				td=$('<td>').css({'border-left':'1px solid Silver'}).appendTo(tr);
				$('<div>').addClass('box_oneline').css({width:'40px',height:'15px','text-decoration':'underline'}).text(redidxauthor).appendTo(td);
				td=$('<td>').css({width:'10px'}).text(':').appendTo(tr);
				td=$('<td>').appendTo(tr);
				$('<div>').addClass('box_oneline').css({width:'80px',height:'15px'}).prop({title:o.author}).text(o.author).appendTo(td);
				}
				//troisième ligne
				tr=$('<tr>').appendTo(table);
				td=$('<td>').prop({'colspan':2}).appendTo(tr);
				
				
				if(data.haveThisUser){
					$('<a>').prop({href:"#campaignEditTable",title:linkTitle}).text(demand+o.id).click(function() {						  
						$.ajax({
							type: "POST",
							url: 'redAction.do',
							data: {action:'issue',iId:o.id},
							dataType: 'json',
							error: function() {  },
							beforeSend: function(){
								
								$("#lmessage").dialog({position: {my: "center", at: "center", of: "#divCampaignEdit"},dialogClass: 'myTitleClass'});
							},
							success: function(data) {
								$("#lmessage").dialog("close");
								var x='_newtab';x+=+Math.random();
								window.open(data.url, x);
							}
						});
					}).appendTo(td);	
				}

				if(o.noJournal){
				td=$('<td>').css({'border-left':'1px solid Silver'}).appendTo(tr);						    		
				$('<div>').addClass('box_oneline').css({width:'40px',height:'15px','text-decoration':'underline'}).text(redidxdate).appendTo(td);
				td=$('<td>').css({width:'10px'}).text(':').appendTo(tr);
				td=$('<td>').text(o.update).appendTo(tr);
				}
			});
			$('#redmine').resizable();
		}
		
	});
}
//save un chat
function addChat(txt,camId,usrId){
	$.ajax({
		type: "POST",
		url: 'chatAction.do',
		data: {action:"chat_add", camId:camId, usrId:usrId, txt:txt},
		dataType: 'json',
		error: function() { },
		success: function(data) {	
			loadChat();
		}
		
	});
}
//charge les chat
function loadChat(){
	$.ajax({
		type: "POST",
		url: 'chatAction.do',
		data: {action:"chat_dsp", camId:camId},
		dataType: 'json',
		error: function() { $('#chat_dsp').empty();},
		success: function(data) {	
			$('#chat_dsp').empty();
			$('#chat_add').val("");	
			if(data==null) return false;
			
			var li;						    	
			var ul=$('<ul>').addClass("notes").appendTo('#chat_dsp');

			$.each(data.chats,function(i,o){
				li=$('<li>').prop({id:"chat_"+o.id}).css({margin:'0 0 5px 0'}).appendTo(ul);
				$('<span>').text(o.formatedDate).css({color:'#AAAAAA'}).appendTo(li);
				$('<span>').text(" - ").appendTo(li);
				$('<span>').text(o.user.formatedName).css({'font-weight':'bold',color:'#AAAAAA'}).appendTo(li);
				$('<span>').text(" : ").appendTo(li);
				$('<span>').text(o.txt).appendTo(li);
				console.log(o.txt);
			});
			
			$('#chat_dsp').scrollTop($('#chat_dsp').prop("scrollHeight"));
			$('#chat_dsp').resizable();
		}
		
	});
}
//charge le tableau des annonceurs et implemente les evenement ajax clic
function loadAnnonceur(){        	
	var action = "search_extend";
	if($('#search_extend_cb').prop('checked')==false)
		action = "search";
	$.ajax({
		type: "POST",
		url: 'searchAnnonceurAction.do',
		data: {"action":action, "search": $('input[id="anc_search_ipt"]').val()},
		dataType: 'json',
		error: function() { alert(errorRequest); },
		success: function(data) {
			$('input[id="anc_search_ipt"]').val(data.search);			    	
			$("#search_list").empty();			    				 		    

			var dtx = $('<div>'); dtx.prop("id","search_txt");
			dtx.appendTo("#search_list");			    	
			var tb = $('<table>'); tb.appendTo(dtx);
			var tr  = $('<tr>');tr.appendTo(tb);
			var td = $('<td>');	td.appendTo(tr);			    	
			var cb = $('<input>').prop({type:'checkbox',id:'search_extend_cb',checked:true});td.append(cb);
			td = $('<td>');	td.appendTo(tr);
			td.append(annonceurextend);

			td = $('<td>').appendTo(tr);
			var a = $('<a>').prop("id","search_close").addClass('aclose').append($('<img>').prop('src','img/close.png' ).addClass('imgclose')).appendTo(td);
		    	
			if(data.action == "search_extend") $('#search_extend_cb').prop('checked', true);
			if(data.action == "search") $('#search_extend_cb').prop('checked', false);

			$('input[id="search_extend_cb"]').click(loadAnnonceur);
			$('#search_close').click(function(){$('#search_list').hide(300);});
			var dfl = $('<div>');dfl.prop("id","search_dfl"); dfl.appendTo(dtx);
			//affichage des non selectionnes
			$.each(data.rows,function(i,row){
				var elt = $('<div>');
				elt.addClass('search_elt');			        	
				elt.prop("id","anc_" + row.ancId);
				elt.prop("ancnamemaj", row.ancNameMAJ);
				elt.html( row.formatedName);
				elt.appendTo(dfl);			        	
			});

			//clic sur un element			      
			$('.search_elt').click(function(){				
				var cf = document.getElementById("campaignForm");
				cf.ancId.value = $(this).prop("id").substr(4);						
				$('input[id="anc_search_ipt"]').val($(this).prop("ancnamemaj"));
				$("#search_list").empty();
				$("#search_list").hide(300);												
			});	

			$("#search_list").show(300);
		}
	});

}

//reconstruit les select de filtres delais
function rebuiltAlj(sta,alj){
	$('#selAlj').empty();
	var o = $('#selAlj').msDropDown({mainCSS:'dd2'}).data("dd");
	var o0={value:'0', text:err_ok, title:'img/err_ok.png'};
	var o1={value:'1', text:err_toolate, title:'img/err_toolate.png'};
	var o2={value:'2',text:err_caution, title:'img/err_caution.png'};
	var o3={value:'3', text:err_error, title:'img/err_error.png'};


	if(sta=='1' || sta=='5' ||sta=='10' || sta=='20'){
		o.add(o2,1);o.add(o3,2);	
	} else if(sta=='50'){
		o.add(o0,1);o.add(o1,2);	
	} else {
		o.add(o0,1);o.add(o1,2);o.add(o2,3);o.add(o3,4);
	}

	if(o) {
		var idx = getIdx("#selAlj",alj);
		o.set("selectedIndex", idx);
		o.set('value',alj);
	}
}

//reconstruit les select de filtres status
function rebuiltSta(sta,alj){
	$('#selSta').empty();
	var o = $('#selSta').msDropDown({mainCSS:'dd2'}).data("dd");
	//o.remove(7);o.remove(6);o.remove(5);o.remove(4);o.remove(3);o.remove(2);o.remove(1);
	var oactif={value:'actif', text:allStatusActive };
	var oall={value:'all', text:allStatusActive};
	var oavd={value:'avd', text:allStatus};
	var oapd={value:'apd', text:started};
	var o1={value:'1', text:status1, title:'img/status1.png'};
	var o5={value:'5', text:status5, title:'img/status5.png'};
	var o10={value:'10', text:status10, title:'img/status10.png'};
	var o20={value:'20', text:status20, title:'img/status20.png'};
	var o50={value:'50',text:status50, title:'img/status50.png'};
	var o60={value:'60', text:status60, title:'img/status60.png'};
	var o200={value:'200', text:status200, title:'img/status200.png'};
	var o300={value:'300', text:status300, title:'img/status300.png'};


	if(alj=='all'){
		o.add(oactif,1);o.add(oall,2);o.add(oavd,3);o.add(oapd,4);
		o.add(o1,5);o.add(o5,6);o.add(o10,7);o.add(o20,8);o.add(o50,9);o.add(o60,10);o.add(o200,11);o.add(o300,12);
	}else if(alj=='0' || alj=='1'){
		o.add(o50,1);o.add(o60,2);o.add(o200,3);o.add(o300,4);	
	} else if(alj=='2' || alj=='3'){
		o.add(o5,1);o.add(o10,2);o.add(o20,3);o.add(o60,4);o.add(o200,5);o.add(o300,6);	
	} 		
	if(o) {
		var idx = getIdx("#selSta",sta);
		o.set("selectedIndex", idx);
		o.set('value',sta);
	}
}

function getIdx(name, val){
	var res=0, idx = 0;
	var options = $(name).prop('options');

	$.each( options, function() {
		var test = ($(this).val()==val.toString() );
		if($(this).val() ==val.toString()){
			res= idx;				 
		} else idx++;
	});
	return res;
}

function spetech(){
	window.open('spetech/documentation/standard_display.html', 'helpme','width=1080');
}

function pblink(access){
	window.open("pb.do?advLink="+access+"&currentLanguage=EN", "","width=1080,height=900");
}

function popUp(URL, h, w){
	eval("window.open('" + URL + "', '', 'toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=1,width=" + w +",height=" + h + ",left = 50,top = 50');");
	}

function openPop(accessLink){
	var link = "pb.do?display1=" + accessLink;
	popUp(link,600,800);
	}

function dSearch(){
	var c = $('#searchMsg');
	var o = ObjectPositionById("ainfo");
	c.css("left",(o[0]+11)+"px");
	c.css("top",(o[1]-5)+"px");
	if(c.css("display") == "none")
		c.show(200);
	else 
		c.hide(500);
}
function selSearch(){
	var s = "tfk:"; var n=0; var sta='all';var alj='all';
	$('#selTfk option:selected').each(function() {
		s+= $(this).val() + (n++>0?",":"");
	});	
	s += " sta:"; n=0;
	$('#selSta option:selected').each(function() {
		s+= $(this).val()  + (n++>0?",":"");
		sta=$(this).val();
	});
	s += " alj:"; n=0;
	$('#selAlj option:selected').each(function() {
		s+= $(this).val()  + (n++>0?",":"");
		alj=$(this).val() ;
	});
	$('#search_ipt').val(s);	
	rebuiltAlj(sta, alj);
	rebuiltSta(sta, alj);
}