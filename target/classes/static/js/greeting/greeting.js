jQuery(function($){

  $('#btn-search').click(function (event) {
    getGreeting();
  });
});

function getGreeting() {

  var formData = $('#user-detail-form').serializeArray();

  $.ajax({
    type : "POST",
    cache : false,
    url : '/greeting/search',
    data: '',
    dataType : 'text',
  }).done(function(data) {
	console.log(data);
    document.getElementById('greeting').innerHTML = JSON.parse(data).greeting
    document.getElementById('greetingImage').src = JSON.parse(data).imagePath
  }).fail(function(jqXHR, textStatus, errorThrown){
	console.log(jqXHR.status);
  });
}