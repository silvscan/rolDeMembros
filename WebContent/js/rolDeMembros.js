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
	
	if ($('#ultimaAcao').val() == $('#checkConsultar').val()){
		$('#checkConsultar').prop('checked' , 'checked');
		$('#txtBotao').html("Consultar");
		removeObrigatoriedadeDoFormDadosCadastrais();
	} 
	else {
		$('#checkCadastrar').prop('checked' , 'checked');
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
	
	if ($('#unidadeSelecionadaHidden').val() != ""){
		$('#comboUnidade').val($('#unidadeSelecionadaHidden').val());
	}
	//###################
	
	if ($('#sexoHidden').val() != ""){
		$('#sexo').val($('#sexoHidden').val());
	}
	
	if ($('#tipoSanguineoHidden').val() != ""){
		$('#tipoSanguineo').val($('#tipoSanguineoHidden').val());
	}
	
	if ($('#escolaridadeHidden').val() != ""){
		$('#escolaridade').val($('#escolaridadeHidden').val());
	}
	
	if ($('#estadoCivilHidden').val() != ""){
		$('#estadoCivil').val($('#estadoCivilHidden').val());
	}
	
	//##############
	
	if ($('#liberarDemaisCadastros').val() == "true"){
		$('#divDemaisCadastrosLeft').show();
		$('#divDemaisCadastrosRight').show();
		bloquearDadosCadastrais(); 
	}
	
	if ($('#exibeResultadoConsulta').val() == "true"){
		$('#tabelaDeMembros').show();
	}
	
	$(document.getElementById("dataDeNascimento")).mask("99/99/9999");
	$(document.getElementById("dataDeCasamento")).mask("99/99/9999");
	$(document.getElementById("dataDeAtualizacao")).mask("99/99/9999");
	$(document.getElementById("dataDeCadastramento")).mask("99/99/9999");
	
})

function removeObrigatoriedadeDoFormDadosCadastrais(){
	$('#codigo').removeAttr('required');
	$('#nome').removeAttr('required');
	$('#comboCondicao').removeAttr('required');
	$('#comboUnidade').removeAttr('required');
}

function addObrigatoriedadeDoFormDadosCadastrais(){
	$('#codigo').attr('required','required');
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

$("#headerDadosCadastrais").click(
		function() {
				if ($("#panelDadosCadastrais")[0].style.display == "block" 
						|| $("#panelDadosCadastrais")[0].style.display == "") {
					$("#panelDadosCadastrais").slideUp(200);
					min_max(this, "hide");
				} else {
					$("#panelDadosCadastrais").slideDown(200);
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
	$('#checkCadastrar').prop('disabled', true );
	$('#checkConsultar').prop('disabled', true );
	$('#codigo').prop('readOnly', true );
	$('#nome').prop('readOnly', true );
	$('#comboCondicao').prop('disabled', true );
	$('#comboUnidade').prop('disabled', true );
	$('#btnGravaDadosCadastrais').prop('disabled', true);
}

function desbloquearDadosCadastrais(){
	$('#checkCadastrar').prop('disabled', false );
	$('#checkConsultar').prop('disabled', false );
	$('#codigo').prop('readOnly', false );
	$('#nome').prop('readOnly', false );
	$('#comboCondicao').prop('disabled', false );
	$('#comboUnidade').prop('disabled', false );
	$('#btnGravaDadosCadastrais').prop('disabled', false); 
}
function limparDadosCadastrais(){
	$('#codigo').val("");
	$('#nome').val("");
	$('#comboCondicao').val("");
	$('#dataDeCadastramento').val("");
	$('#comboUnidade').val("");
}

function inicializarTela(){
	$('#tabelaDeMembros').hide(); 
	$('#divDemaisCadastrosLeft').hide();
	$('#divDemaisCadastrosRight').hide();
	limparDadosCadastrais(); 
	desbloquearDadosCadastrais();
}