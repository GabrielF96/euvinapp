
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
    
  
  document.getElementById('mostrarHora1').innerHTML =
  h + ":" + m + ":" + s;
  var t = setTimeout(startTime, 500);  
    
  document.getElementById('mostrarHora2').innerHTML =
  h + ":" + m + ":" + s;
  var t = setTimeout(startTime, 500); 
    
  document.getElementById('mostrarHora3').innerHTML =
  h + ":" + m + ":" + s;
  var t = setTimeout(startTime, 500); 
    
  document.getElementById('mostrarHora4').innerHTML =
  h + ":" + m + ":" + s;
  var t = setTimeout(startTime, 500); 
  

}


function checkTime(i) {
  if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
  return i;
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







