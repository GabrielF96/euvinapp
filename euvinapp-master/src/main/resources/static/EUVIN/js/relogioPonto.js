window.onload = function() {
	startTime();
	validaValorLabel();
};

function startTime() {
  var today = new Date();
  var day = today.getDate();
  var month = today.getMonth() + 1;
  var year = today.getFullYear();
  var h = today.getHours();
  var m = today.getMinutes();
  var s = today.getSeconds();
  m = checkTime(m);
  s = checkTime(s);
  month = checkTime(month);
    
  document.getElementById('relogioDinamico').innerHTML =
  "Data de Abertura: " + 
  day + "/" + month + "/" + year
  + " " + 
  h + ":" + m + ":" + s;
  var t = setTimeout(startTime, 500);
    
    
 
  
//  //se o boato 1 já foi tickado
//  if(1 == 1)
//  //if(document.getElementById('btn1').disabled == false)
//  {
//      //Deixa o horario correndo da label 1
//      document.getElementById('mostrarHora1').innerHTML =
//      h + ":" + m + ":" + s;
//      var t = setTimeout(startTime, 500);  
//      
//      
//      document.getElementById('btn2').class("btn btn-third");
//      document.getElementById('btn2').disabled = false;
//      
//      document.getElementById('btn1').class("btn btn-third-disabled");
//      document.getElementById('btn1').disabled = true;
//      //remove o disabled do botao 2 e coloca no 1
//  }
//    //se o boato 2 já foi tickado
//  else if (2 == 0)
//  {
//      //Deixa o horario correndo da label 2
//      document.getElementById('mostrarHora2').innerHTML =
//      h + ":" + m + ":" + s;
//      var t = setTimeout(startTime, 500); 
//      
//      //remove o disabled do botao 3 e coloca no 2
//  }
//    //se o boato 2 já foi tickado
//  else if (3 == 0)
//  {
//      //Deixa o horario correndo da label 3
//      document.getElementById('mostrarHora3').innerHTML =
//      h + ":" + m + ":" + s;
//      var t = setTimeout(startTime, 500);
//      
//      
//      document.getElementById('mostrarHora2').innerHTML =
//      h + ":" + m + ":" + s;
//      var t = setTimeout(startTime, 500); 
//      
//      //remove o disabled do botao 3 e coloca no 2
//  }
//    //se o boato 2 já foi tickado
//  else if (4 == 0)
//  {
//      //Deixa o horario correndo da label 4
//      document.getElementById('mostrarHora4').innerHTML =
//      h + ":" + m + ":" + s;
//      var t = setTimeout(startTime, 500);
//      
//      document.getElementById('mostrarHora2').innerHTML =
//      h + ":" + m + ":" + s;
//      var t = setTimeout(startTime, 500); 
//      
//      //remove o disabled do botao 3 e coloca no 2
//  }
}


function checkTime(i) {
  if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
  return i;
}

function validaValorLabel(){
	if(document.getElementById('mostrarHora1').innerHTML == "--:--:--"){
		document.getElementById('btn1').disabled = false;
		return;
	}
	if(document.getElementById('mostrarHora2').innerHTML == "--:--:--"){
		document.getElementById('btn2').disabled = false;
		return;
	}
	if(document.getElementById('mostrarHora3').innerHTML == "--:--:--"){
		document.getElementById('btn3').disabled = false;
		return;
	}
	if(document.getElementById('mostrarHora4').innerHTML == "--:--:--"){
		document.getElementById('btn4').disabled = false;
		return;
	}
}

/* Funcao para travar a hora ao clicar no botao

function TravarHora() {
  $("#mostrarHora1").on('click', function(event) {
    event.preventDefault();
    var hora = document.getElementById("#mostrarHora1").val();
    alert(hora);
  });
}

*/







