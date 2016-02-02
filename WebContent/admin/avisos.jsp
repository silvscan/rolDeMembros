<div id="divSucces" class="alert alert-success" role="alert" style="display: none">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<i class="fa fa-exclamation-triangle"></i>
  	<span id=msgSucces>${mensagemDeSucesso}</span>
</div>

<div id="divInfo" class="alert alert-info" role="alert" style="display: none">
   <button type="button" class="close" data-dismiss="alert" aria-label="Close">
   	   <span aria-hidden="true">&times;</span>
   </button>
   <i class="fa fa-exclamation-triangle"></i>
   <span id=msgInfo>${mensagemDeAviso}</span>
</div>

<div id="divDanger" class="alert alert-danger" role="alert" style="display: none">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<i class="fa fa-exclamation-triangle"></i>
	<span id=msgDanger>${mensagemDeErro}</span> 
</div>

<script>
	$(document).ready(function(){
		
		if ($('#msgSucces').html() !== ""){
			$('#divSucces').show();
		} 
		
		if ($('#msgInfo').html() !== ""){
			$('#divInfo').show();
		} 
		
		if ($('#msgDanger').html() !== ""){
			$('#divDanger').show();
		}
	});
</script>