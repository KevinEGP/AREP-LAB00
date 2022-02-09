function convertTo(degrees_type) {
  let port = 443;
  let endpoint = `http://localhost/`;
  let degrees =  $(`#${degrees_type}`).val();
  $(`#${degrees_type}_result`).text();
  $.ajax({
    url: `${endpoint}to-${degrees_type}?degrees=${degrees}`,
    headers: {
    'Access-Control-Allow-Origin': '*',
    'Content-Type':'application/json'
    },
    method: 'GET',
    contentType: "application/json",
    dataType: 'json',
    success: function(result){
      $(`#${degrees_type}_result`).text(`El resultado es: ${result.degrees}`);
    },
    error: function(error) {
      $(`#${degrees_type}_result`).text('Error al calcular');
    }
  })
}