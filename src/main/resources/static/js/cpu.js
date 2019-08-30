/**
 * Created by Justin Zuniga Torres
 */


$( document ).ready(function() {

		
 $("#cpuId").change(function(){
	 
	 
	 var cpuId = $('#cpuId option:selected').val();
	 
	 $.ajax({
		 
		    type: "GET",
		    cache: false,
		    url: "/admin/getOneCpu",
		    data: { 
		        'cpuId': cpuId
		    }, // Adjuntar los campos del formulario enviado.

		    success: function(data)
		     {
		      //Actualiza valores por defecto
		       $("#qdf").val(data.qdf); 
		       $("#cpuName").val(data.cpuName);
		     }
	});
	 
	 
 });
 
 

});
