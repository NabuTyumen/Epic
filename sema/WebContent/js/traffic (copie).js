
function changeMouseOver(pThis) {
	if (pThis.className!="selectrow") pThis.className="rollrow";
}

function changeMouseOut(pThis, pClassName) {
	if (pThis.className!="selectrow") pThis.className=pClassName;
}

function changeMouseClick(pThis,pClassName) {
	if (pThis.className!="selectrow") {
		if (lastSelectRow==null) {
			lastSelectRow={row:pThis,classname:pClassName};
		} else {
			lastSelectRow.row.className=lastSelectRow.classname;
			lastSelectRow.row=pThis;
			lastSelectRow.classname=pClassName;
		}
		pThis.className="selectrow";
		displayCampaign(pThis.id.substring(6));
	}
}

function activateRows(camId){
//	id de la campagne en cours
//	traitement de la table campaign
	var table = document.getElementById("campaign");
	if(table == null) return;
	var body;
	if (table.childNodes[3] == null)
		body = table.childNodes[1];
	else
		body = table.childNodes[3];
	for(var i=0;i<(body.rows.length);i++) {
		var row  = body.rows[i];
		if(i%2 == 0) {
			row.onmouseout=function(){changeMouseOut(this,"odd");};
			row.onclick=function(){changeMouseClick(this,"odd");};
		}
		else {
			row.onmouseout=function(){changeMouseOut(this,"even");};
			row.onclick=function(){changeMouseClick(this,"even");};
		}
		row.onmouseover=function(){changeMouseOver(this);};
		var firstCol;
		if(row.childNodes[0].nodeType == 3)
			firstCol =row.childNodes[1];
		else
			firstCol =row.childNodes[0];
		var inputFirstCol;
		if(firstCol.childNodes[0].nodeType == 3)
			inputFirstCol=firstCol.childNodes[1];
		else
			inputFirstCol=firstCol.childNodes[0];
		row.id="row"+inputFirstCol.id;
	}
	if(camId>0 && document.getElementById("rownum"+camId)!=null){
		document.getElementById("rownum"+camId).className="selectrow";
	}
}

function popUp(URL, h, w){
	eval("window.open('" + URL + "', '', 'toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=1,width=" + w +",height=" + h + ",left = 50,top = 50');");
}

function getScrollTop() {
	var scrOfY = 0;
	if( typeof( window.pageYOffset ) == 'number' ) {
		//Netscape compliant
		scrOfY = window.pageYOffset;
	} else if( document.body && ( document.body.scrollLeft || document.body.scrollTop ) ) {
		//DOM compliant
		scrOfY = document.body.scrollTop;
	} else if( document.documentElement && ( document.documentElement.scrollLeft || document.documentElement.scrollTop ) ) {
		//IE6 standards compliant mode
		scrOfY = document.documentElement.scrollTop;
	}
	return scrOfY ;
}

function setScrollTop(s) {
	if( typeof( window.pageYOffset ) == 'number' ) {
		//Netscape compliant
		window.pageYOffset = s;
	} else if( document.body && ( document.body.scrollLeft || document.body.scrollTop ) ) {
		//DOM compliant
		document.body.scrollTop = s;
	} else if( document.documentElement && ( document.documentElement.scrollLeft || document.documentElement.scrollTop ) ) {
		//IE6 standards compliant mode
		document.documentElement.scrollTop =s;
	}
}

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
//Fonction permettant de connaître la position d'un objet
//par rapport au bord gauche de la page.
//Cet objet peut être à l'intérieur d'un autre objet.

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

/*Vérification du format des dates*/
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


//enregistrer l'état d'affichage
function getDisp(){
	var recorDisp="";
	var q="divLeftT,style.display;divLeftC,style.display;divLeftCtc,style.display;divRightCtc,style.display;divCampaignDisplay,style.display;imgDispTE,src;divCreaRmqCard,style.display;tabTDisplay,className;tabCDisplay,className;tabCtc,style.display";
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
			}    	  
		}
	}
	return recorDisp;
}

//appliquer l'état d'affichage
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

function keydownfn(e) {
	if (e.keyCode == 13) {
		submitCampaign('upl');
	}
	return true;
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

function displayCampaign(camId){
	var dosubmit = true;
	var cf = document.getElementById("campaignForm");
	cf.id.value = camId;
	cf.actionPerformed.value = "display";
	cf.scrollTop.value =getScrollTop();
	cf.recorDisp.value=getDisp();
	cf.submit();
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
	if(action=='sendemail')
		wysiwygCtc.instanceById('niceEditAreaCtc').saveContent();  
	f.submit();
}
function activeContact(){
	var f = document.getElementById("ctcForm");
	f.actionPerformed.value="active";
	f.scrollTop.value = getScrollTop();
	f.submit();
}

//sélection to/cc/bcc
function selEmail(to,id){
	var check = document.getElementById(to+id).checked?1:0;	  
	document.getElementById("to"+id).checked=0;
	document.getElementById(to+id).checked=check;
	getDocChecked(true);
}

//méthode déclenchée au onchange des checkbox
//examine tous les éléments cochés sd+id et affiche
//divSendByEmail si au moins 1 est coché  
function getDocChecked(hide){
	if(hide) $("#tabCtc").hide(100);
	var ids=new Array("0");
	var selStr="";
	var li="";
	var nbc=0;
	//nombre de contacts sélectionnés
	$("input[name='selTo']:checked").each(function() {
		nbc++;selStr+=";T"+$(this).prop('value');
	});
	document.getElementById("ctcForm").selStr.value=selStr;


	//nombre de documents sélectionnés
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
	var txtRmq = wysiwygCtc.instanceById('niceEditAreaCtc').getContent();
	txtRmq += getLinkTxt();
	wysiwygCtc.instanceById('niceEditAreaCtc').setContent(txtRmq);
}

function hideDiv(divName){
	document.getElementById(divName).style.display='none';
}
function fcbx(cbxName){
	var df = document.getElementById('documentForm');
	if(cbxName == 'docPM' && df.docPM.checked){
		df.docNoAlert.checked = false;
	} else if(cbxName == 'docAlert' && df.docAlert.checked){
		df.docNoAlert.checked = false;
		df.docAlib.disabled = false;
		df.docAlib.focus();
	} else if(cbxName == 'docAlert' && !df.docAlert.checked){
		df.docNoAlert.checked = false;
		df.docAlib.disabled = true;
	} else if(cbxName == 'docNoAlert' && df.docNoAlert.checked){
		df.docPM.checked = false;
		df.docAlert.checked = false;
		df.docAlib.disabled = true;
	}
	df.docPM.value = df.docPM.checked *1;
	df.docAlert.value = df.docAlert.checked *1;
	df.docNoAlert.value = df.docNoAlert.checked *1;
}
//masque et réaffiche le tableau des campagnes
function dispTE(action){
	var obj =document.getElementById('imgDispTE');
	var img = obj.src.substr(obj.src.lastIndexOf("/img/")+5);

	if(action=='down'){
		if(img == "tab0.png"){flipTE('tab1.png','none');}
		if(img == "tab1.png"){flipTE('tab0.png','block');}
	}
}
function flipTE(i, dsp){
	//document.getElementById('imgDispTE').src = "img/"+i;
	$('#imgDispTE').prop({src:"img/"+i});
	switch(dsp){
	case 'none':$('#divCampaignDisplay').hide( "blind", { direction: "up" }, "slow" );return false;
	case 'block':$('#divCampaignDisplay').show( "blind", { direction: "up" }, "slow" );return false;
	}
	
}
//chargement du logbook
function camdif_(){	
	$.ajax({
		type: "POST",
	    url: 'camdifAction.do',
	    data: {action:"camdif"},
	    dataType: 'json',
	    error: function() { alert(errorRequest); },
	    success: function(data) {
	    	$("#tablog").empty();
	    	var tablog=$('<table>').addClass('userstm').appendTo("#tablog");
	    	var tr=$('<tr>').appendTo(tablog);
    		$('<th>').text("#").appendTo(tr);
    		$('<th>').text(tablogid).appendTo(tr);
    		$('<th>').text(tablogdate).appendTo(tr);
    		$('<th>').text(tabloguser).appendTo(tr);
    		$('<th>').text(tablogope).appendTo(tr);
    		$('<th>').text(tablogdocid).appendTo(tr);
    		$('<th>').text(tablogdocument).appendTo(tr); 
		    $.each(data.opes,function(i,o){
	    		tr=$('<tr>').appendTo(tablog);
	    		$('<td>').text(i).appendTo(tr);
	    		$('<td>').text(o.id).appendTo(tr);						    		
	    		$('<td>').text(o.formatedDate).appendTo(tr);
	    		$('<td>').text(o.user.formatedName).appendTo(tr);
	    		$('<td>').text(o.opeLib).appendTo(tr);
	    		$('<td>').text(o.docId).appendTo(tr);
	    		$('<td>').text(o.docName).appendTo(tr); 
	        });
	    }
	});
}

function camsdif(){
 	  $.ajax({
 		type: 'POST',
 			url: 'camdifAction.do',
 			data: {action:'camsdif'},
 			dataType: 'json',
 			error: function() { alert(errorRequest); },
 			success: function(data) {
 				$("span.dif").empty();
 				$.each(data.camsdif,function(j,c){
 					$('#rownum'+c +" td.modif").css({'font-weight':'bold'});
 					$('<a>').prop({id:'adif_'+c,href:"#",title:'Cliquez pour afficher la liste \n des modifications apport�es \n � la campagne depuis la derni�re fois \n que vous l\'avez consult�e.'}).addClass('info').click(camdif).append($('<img>').prop({src:'img/info.png',alt:'dif'})).appendTo('#dif'+c);
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
						console.log(aid);
						var tablog=$('<table>').addClass('userstm').appendTo(div);
				    	var tr=$('<tr>').appendTo(tablog);
			    		$('<th>').text("#").appendTo(tr);
			    		$('<th>').text(tablogid).appendTo(tr);
			    		$('<th>').text(tablogdate).appendTo(tr);
			    		$('<th>').text(tabloguser).appendTo(tr);
			    		$('<th>').text(tablogope).appendTo(tr);
			    		$('<th>').text(tablogdocid).appendTo(tr);
			    		$('<th>').text(tablogdocument).appendTo(tr); 
					    $.each(data.opes,function(i,o){
					    	console.log(i + " " + o.isDif + " " + o.user.formatedName + " " + o.opeLib);
					    	if(o.isDif){
					    		tr=$('<tr>').appendTo(tablog);
					    		$('<td>').text(i).appendTo(tr);
					    		$('<td>').text(o.id).appendTo(tr);						    		
					    		$('<td>').text(o.formatedDate).appendTo(tr);
					    		$('<td>').text(o.user.formatedName).appendTo(tr);
					    		$('<td>').text(o.opeLib).appendTo(tr);
					    		$('<td>').text(o.docId).appendTo(tr);
					    		$('<td>').text(o.docName).appendTo(tr); 						    		
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
//charge les issues Redmine
function loadRedmine(){
	$('#redmine').empty();
	$('#redmine').append($('<div>').css({width:'600px',height:'200px','text-align': 'center'}).append($('<img>').prop({src:'img/466.GIF'}).css({'margin-top':'68px',height:'64px', width:'64px'} )));
	$.ajax({
		type: "POST",
		url: 'redAction.do',
		data: {action:"display"},
		dataType: 'json',
		error: function() { $('#redmine').empty();},
		success: function(data) {			
			$('#redtitle').empty();
			$('#redtimg').empty();
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
						data: {action:'cam',camId:camId},
						dataType: 'json',
						error: function() { alert(errorRequest); },
						success: function(data) {
							var x='_newtab';x+=+Math.random();
							var myW= window.open(data.url, x,"width=1000,height=900");
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
				//distinction : issue crée manuellement sur redmine (noJournal=true) ou auto 
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
				
				
				//deuxième ligne
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
							data: {action:'issue',camId:camId,iId:o.id},
							dataType: 'json',
							error: function() { alert(errorRequest); },
							success: function(data) {
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
		}
	});
}
//charge le tableau des annonceurs et implémente les evenement ajax clic
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
			//affichage des non sélectionnés
			$.each(data.rows,function(i,row){
				var elt = $('<div>');
				elt.addClass('search_elt');			        	
				elt.prop("id","anc_" + row.ancId);
				elt.prop("ancnamemaj", row.ancNameMAJ);
				elt.html( row.formatedName);
				elt.appendTo(dfl);			        	
			});

			//clic sur un élement			      
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

//reconstruit les select de filtres délais
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
	window.open('http://traffic.fr.havasmedia.com/documentation/standard_display.html', 'abc','width=1080');
}

function pblink(access){
	window.open("piggyBackingAction.do?displaypb="+access, "","width=1080,height=900");
}
