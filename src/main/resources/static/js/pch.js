/**
 * Created By Justin Zuniga Torres
 */

$( document ).ready(function() {

		
 $("#pchId").change(function(){
	 
	 
	 var pchId = $('#pchId option:selected').val();
	 
	 $.ajax({
		 
		    type: "GET",
		    cache: true,
		    url: "/admin/getOnePch",
		    data: { 
		        'pchId': pchId
		    }, // Adjuntar los campos del formulario enviado.

		    success: function(data)
		     {
		      //Actualiza valores por defecto
		       $("#qdf").val(data.qdf); 
		       $("#pchName").val(data.pchName);
		     }
	});
	 
	 
 });
 

});
