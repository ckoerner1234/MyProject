/**
 * Carolyn Koerner  SWE632
 * homepage_script.js
 */
function done() { 
    document.getElementById("popup").style.display = "none";
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    
  
    
    //DO STUFF WITH PASSWORD HERE    
}


function showPopup(el) {
    //document.getElementById("popup").style.display = "block";
    $( "#myloginbox" ).dialog();

    el.disabled = true;
    if(el.value == 'Login'){
        document.getElementById("login").disabled = true;
        document.getElementById("logout").disabled = false;
    	alert("login has been pushed ");
	}
    else {
    	alert("logout has been pushed " + el.value);
    	session.setAttribute("session_username",null);
        document.getElementById("login").disabled = false;
        document.getElementById("logout").disabled = true;
    }

}


function popupwindow(url, title, w, h) {
	  var left = (screen.width/2)-(w/2);
	  var top = (screen.height/2)-(h/2);
	  return window.open(url, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
	} 


function disable_enable(el){
    el.disabled = true;
    if(el.value == 'login'){
		alert("in disable_enable " + el.value);
        document.getElementById("logout").disabled = false;
    	}
    else {
		alert("in disable_enable " + el.value);
    	session.setAttribute("session_username",null);
        document.getElementById("login").disabled = false;
    }
}

function login(){
	//document.getElementById('hello_user').innerHTML = "You are logged in";
}
function adminlogin(){
	//document.getElementById('hello_user').innerHTML = "You are logged in as Admin";
}

function openPage(){
	var obj = session.getAttribute("session_username");
	if (obj != null) {
		alert(obj);
	    document.getElementById("login").disabled = true;
        document.getElementById("logout").disabled = false;
	 } 
	if (obj == null) {
		alert(obj);
	    document.getElementById("login").disabled = false;
        document.getElementById("logout").disabled = true;
	 } 
	
function adminlogin(){
	var obj = session.getAttribute("session_username");
	if (obj != null) {
		alert(obj);
	    document.getElementById("login").disabled = true;
        document.getElementById("logout").disabled = false;
	 } 
	if (obj == null) {
		alert(obj);
	    document.getElementById("login").disabled = false;
        document.getElementById("logout").disabled = true;
	 } 
	
}	
	
}

