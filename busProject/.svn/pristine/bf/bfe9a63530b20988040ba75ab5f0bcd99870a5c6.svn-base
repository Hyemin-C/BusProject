function openCity(evt, cityName) {
  // Declare all variables
  var i, tabcontent, tablinks;

  // Get all elements with class="tabcontent" and hide them
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }

  // Get all elements with class="tablinks" and remove the class "active"
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }

  // Show the current tab, and add an "active" class to the button that opened the tab
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
  
  mainformA.departO.value= "출발";
  mainformA.arrivalO.value= "도착";
  mainformB.departR.value= "출발";
  mainformB.arrivalR.value= "도착";
  
  var norm1 = document.getElementById("normal1");
  var supe1 = document.getElementById("superior1");
  var norm2 = document.getElementById("normal2");
  var supe2 = document.getElementById("superior2");
  supe1.style.color = "skyblue";
  supe1.style.borderColor = "skyblue";
  supe1.style.backgroundColor = "#ffffff";
  norm1.style.color = "skyblue";
  norm1.style.borderColor = "skyblue";
  norm1.style.backgroundColor = "#ffffff";
  supe2.style.color = "skyblue";
  supe2.style.borderColor = "skyblue";
  supe2.style.backgroundColor = "#ffffff";
  norm2.style.color = "skyblue";
  norm2.style.borderColor = "skyblue";
  norm2.style.backgroundColor = "#ffffff";
}

function selectA(){
  window.open("b_popUpA.jsp", "select", "width=500, height=350, left=500, top=250");
}

function cityA(selected){
  opener.mainformA.departO.value=selected;
  self.close();
  opener.mainformB.departR.value=selected;
  self.close();
}

function selectB(){
  window.open("b_popUpB.jsp", "select", "width=500, height=350, left=500, top=250");
}

function cityB(selected){
  opener.mainformA.arrivalO.value=selected;
  self.close();
  opener.mainformB.arrivalR.value=selected;
  self.close();
}

function cancel(){
  self.close();
}

function seatLevel1(){
  var norm1 = document.getElementById("normal1");
  var supe1 = document.getElementById("superior1");
  var norm2 = document.getElementById("normal2");
  var supe2 = document.getElementById("superior2");
  var level1 = document.getElementById("normal1").value;
  supe1.style.color = "rgba(135, 206, 250, 0.5)";
  supe1.style.borderColor = "rgba(135, 206, 250, 0.5)";
  supe1.style.backgroundColor = "#ffffff";
  norm1.style.color = "#fff";
  norm1.style.borderColor = "skyblue";
  norm1.style.backgroundColor = "skyblue";
  supe2.style.color = "rgba(135, 206, 250, 0.5)";
  supe2.style.borderColor = "rgba(135, 206, 250, 0.5)";
  supe2.style.backgroundColor = "#ffffff";
  norm2.style.color = "#fff";
  norm2.style.borderColor = "skyblue";
  norm2.style.backgroundColor = "skyblue";
  document.mainformA.levelO.value = level1;
  document.mainformB.levelR.value = level1;
}

function seatLevel2(){
  var norm1 = document.getElementById("normal1");
  var supe1 = document.getElementById("superior1");
  var norm2 = document.getElementById("normal2");
  var supe2 = document.getElementById("superior2");
  var level2 = document.getElementById("superior1").value;
  supe1.style.color = "#fff";
  supe1.style.borderColor = "skyblue";
  supe1.style.backgroundColor = "skyblue";
  norm1.style.color = "rgba(135, 206, 250, 0.5)";
  norm1.style.borderColor = "rgba(135, 206, 250, 0.5)";
  norm1.style.backgroundColor = "#ffffff";
  supe2.style.color = "#fff";
  supe2.style.borderColor = "skyblue";
  supe2.style.backgroundColor = "skyblue";
  norm2.style.color = "rgba(135, 206, 250, 0.5)";
  norm2.style.borderColor = "rgba(135, 206, 250, 0.5)";
  norm2.style.backgroundColor = "#ffffff";
  document.mainformA.levelO.value = level2;
  document.mainformB.levelR.value = level2;
}

function searchA(){
  var departO = document.getElementById("departO").value;
  var arrivalO = document.getElementById("arrivalO").value;
  var levelO= document.getElementById("levelO").value;
  if(departO == "출발"){
	alert("출발지를 선택하세요");
	return;
  }else if(arrivalO == "도착"){
	alert("도착지를 선택하세요");
	return;
  }else if(levelO == "1"){
	alert("등급을 선택하세요");
	return;
  }
  mainformA.submit();
}

function searchB(){
  var departR = document.getElementById("departR").value;
  var arrivalR = document.getElementById("arrivalR").value;
  var levelR= document.getElementById("levelR").value;
  if(departR == "출발"){
	alert("출발지를 선택하세요");
	return;
  }else if(arrivalR == "도착"){
	alert("도착지를 선택하세요");
	return;
  }else if(levelR == "1"){
	alert("등급을 선택하세요");
	return;
  }
  mainformB.submit();
}


