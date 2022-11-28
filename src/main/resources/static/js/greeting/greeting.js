jQuery(function($){

  $('#btn-search').click(function (event) {
    getGreeting();
  });
});

function getGreeting() {
	
  $.ajax({
    type : "POST",
    cache : false,
    url : '/greeting/search',
    data: {
	  'id':document.getElementById('greetingId').innerHTML
	},
    dataType : 'text',
  }).done(function(data) {
	console.log(data);
	document.getElementById('greetingId').innerHTML = JSON.parse(data).greetingId
    document.getElementById('greeting').innerHTML = JSON.parse(data).greeting
    document.getElementById('greetingImage').src = JSON.parse(data).imagePath
  }).fail(function(jqXHR, textStatus, errorThrown){
	console.log(jqXHR.status);
  });
}