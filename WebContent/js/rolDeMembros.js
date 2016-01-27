$(document).ready(function(){
	
	if ($('#ultimaAcao').val() == $('#checkConsultar').val()){
		$('#checkConsultar').prop('checked' , 'checked');
		$('#txtBotao').html("Consultar");
		removeObrigatoriedadeDoFormDadosCadastrais();
	}
	
	$('#checkCadastrar').click(function(){
		$('#txtBotao').html("Cadastrar");
		addObrigatoriedadeDoFormDadosCadastrais();
	})
	
	$('#checkConsultar').click(function(){
		$('#txtBotao').html("Consultar");
		removeObrigatoriedadeDoFormDadosCadastrais();
	})
	
	
	if ($('#condicaoSelecionadaHidden').val() != ""){
		$('#comboCondicao').val($('#condicaoSelecionadaHidden').val());
	}
	
	if ($('#liberarDemaisCadastros').val() == "true"){
		$('#divDemaisCadastros').show();
		bloquearDadosCadastrais();
	}
	
	if ($('#exibeResultadoConsulta').val() == "true"){
		$('#tabelaDeMembros').show();
	}
	
})

function removeObrigatoriedadeDoFormDadosCadastrais(){
	$('#codigoDeMembro').removeAttr('required');
	$('#nome').removeAttr('required');
	$('#comboCondicao').removeAttr('required');
	$('#comboUnidade').removeAttr('required');
}

function addObrigatoriedadeDoFormDadosCadastrais(){
	$('#codigoDeMembro').attr('required','required');
	$('#nome').attr('required','required');
	$('#comboCondicao').attr('required','required');
	$('#comboUnidade').attr('required','required');
}

$("#HDadosP").click(
		function() {
			if ($("#panelDadosP")[0].style.display == "block"
					|| $("#panelDadosP")[0].style.display == "") {
				$("#panelDadosP").slideUp(200);
				min_max(this, "hide");
			} else {
				$("#panelDadosP").slideDown(200);
				min_max(this, "show");

			}
		});

$("#HideHoriFrm").click(
		function() {
			if ($("#panelHoriFrm")[0].style.display == "block"
					|| $("#panelHoriFrm")[0].style.display == "") {
				$("#panelHoriFrm").slideUp(200);
				min_max(this, "hide");
			} else {
				$("#panelHoriFrm").slideDown(200);
				min_max(this, "show");
			}
		});

$("#hideDadosEcle").click(
		function() {
			if ($("#panelDadosEcle")[0].style.display == "block"
					|| $("#panelDadosEcle")[0].style.display == "") {
				$("#panelDadosEcle").slideUp(200);
				min_max(this, "hide");
			} else {
				$("#panelDadosEcle").slideDown(200);
				min_max(this, "show");
			}
		});

$("#hideSituacao").click(
	function() {
		if ($("#panelSituacao")[0].style.display == "block"
				|| $("#panelSituacao")[0].style.display == "") {
			$("#panelSituacao").slideUp(200);
			min_max(this, "hide");
		} else {
			$("#panelSituacao").slideDown(200);
			min_max(this, "show");
		}
	});

function min_max(panel, acao) {
	if (acao == "show") {
		$(panel).children().removeClass();
		$(panel).children().addClass("arrow_carrot-up_alt2");
	} else if (acao == "hide") {
		$(panel).children().removeClass();
		$(panel).children().addClass("arrow_carrot-down_alt2");
	}
}

function bloquearDadosCadastrais(){
	$('#codigoDeMembro').prop('readOnly', true );
	$('#nome').prop('readOnly', true );
	$('#comboCondicao').prop('disabled', true );
	$('#comboUnidade').prop('disabled', true );
}

function desbloquearDadosCadastrais(){
	$('#codigoDeMembro').prop('readOnly', false );
	$('#nome').prop('readOnly', false );
	$('#comboCondicao').prop('disabled', false );
	$('#comboUnidade').prop('disabled', false );
}
function limparDadosCadastrais(){
	$('#codigoDeMembro').val("");
	$('#nome').val("");
	$('#comboCondicao').val("");
	$('#dataInclusao').val("");
	$('#comboUnidade').val("");
}

function inicializarTela(){
	$('#tabelaDeMembros').hide(); 
	$('#divDemaisCadastros').hide();
	limparDadosCadastrais(); 
	desbloquearDadosCadastrais();
}