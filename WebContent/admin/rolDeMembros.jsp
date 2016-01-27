<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="c" uri="/tags/c" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>

<body>
	<section id="container" class=""> 
	<jsp:include page="template.jsp" /> 
	<section id="main-content"> 
	<section class="wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">
				<i class="fa fa-file-text-o"></i>Cadastros
			</h3>
			<ol class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="index.jsp">Início</a></li>
				<li><i class="icon_document_alt"></i>Cadastros</li>
				<li><i class="fa fa-file-text-o"></i>Rol de Membros</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<section class="panel"> 
			<header class="panel-heading">
				Dados cadastrais 
			</header>
			<div class="panel-body">
				<form class="form" id="frmDadosCadastrais" method="post" action="Controller">
					<input type="hidden" id="ultimaAcao" value="${ultimaAcao}">
					<input type="hidden" id="liberarDemaisCadastros" value="${liberarDemaisCadastros}">
					<input type="hidden" id="exibeResultadoConsulta" value="${exibeResultadoConsulta}">
					
					<div class="col-lg-12">
						<input type="radio" id="checkCadastrar" required="required" name="tarefa" value="GravaDadosCadastrais" >&nbsp;Cadastrar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="checkConsultar" required="required" name="tarefa" value="ConsultaInformacoesMembro" >&nbsp;Consultar
					</div>
					<div class="col-lg-12"><br/></div>
					<div class="col-lg-4">
						<labelcontrol-label">Código:</label> 
						<input type="text" 
							   required="required" 
							   autofocus="autofocus"
							   class="form-control" 
							   id="codigoDeMembro" 
							   name="codigo" 
							   placeholder="Código" 
							   value="${codigo}"
						>
					</div>
					<div class="col-lg-8">
						<labelcontrol-label">Nome:</label> 
						<input type="text" required="" class="form-control" name="nome" id="nome" placeholder="Nome" value="${nome}">
					</div>
					<br />
					<div class="col-lg-8">
						<labelcontrol-label">Condição:</label> 
						<input type="hidden" id="condicaoSelecionadaHidden" value="${condicao}">
						<select required="required" class="form-control m-bot15" name="condicao" id="comboCondicao">
							<option value="">Selecione</option>
							<c:forEach var="condicao" items="${listaCondicoes}">
								<option value="${condicao.codigo}">${condicao.descricao}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-lg-4">
						<labelcontrol-label">Data de Inclusão:</label> 
						<input type="text" class="form-control" id="dataInclusao" placeholder="Data Inclusão" name="dataInclusao" readOnly>
					</div>
					<br />
					<div class="col-lg-6">
						<labelcontrol-label">Unidade Frequentada:</label> 
						<input type="hidden" id="unidadeSelecionadaHidden" value="${unidade}">
						<select required="required" class="form-control m-bot15" name="unidade" id="comboUnidade">
							<option value="">Selecione</option>
							<c:forEach var="unidade" items="${listaUnidades}">
								<option value="${unidade.codigo}">${unidade.descricao}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-lg-6">
						<labelcontrol-label">Última Atualização:</label> <input
							type="text" class="form-control" readOnly
							placeholder="Última Atualização">
					</div>
					<br/>
					<div class="col-lg-10"></div>
					<div class="col-lg-2">
						<button type="submit" class="btn btn-primary"><span id="txtBotao">Cadastrar</span></button>
						<a onclick="javascript: inicializarTela();" class="btn btn-warning"><span id="txtBotao">Limpar</span></a>
					</div>

				</form>
			</div>
			</section>
		</div>
		
		<div id="tabelaDeMembros" style="display: none;">
			<div class="col-lg-12">
				<section class="panel"> 
					<header class="panel-heading">
						Resultado da Pesquisa 
					</header>
					<div class="panel-body">
						<c:choose>
							<c:when test="${requestScope.listaMembros eq null}">
								Nenhum resultado.
							</c:when>
							<c:when test="${empty requestScope.listaMembros}">
								Nenhum resultado.
							</c:when>
							<c:otherwise>
								<table border="1" class="table table-striped table-bordered table-hover table-condensed">
								    <thead>
								      	<tr>
								      		<th>Código</th>
								      		<th>Nome</th>
								      		<th>Data Nasc</th>
								      		<th>Condição</th>
								      		<th>Endereço</th>
								      		<th>Bairro</th>
								      		<th>Cidade</th>
								      		<th>Tel Residencial</th>
								      		<th>Ação</th>
								    	</tr>
								  	</thead>
								  	<tbody>
								    	<c:forEach var="membro" items="${requestScope.listaMembros}">    
											<tr>    
											    <td>${membro.id}</td>
									      		<td>${membro.nome}</td>
									      		<td>${membro.dataNascimento}</td>
									      		<td>${membro.condicao.descricao}</td>
									      		<td>${membro.endereco.endereco}</td>
									      		<td>${membro.endereco.bairro}</td>
									      		<td>${membro.endereco.cidade}</td>
									      		<td>${membro.endereco.telefoneRes}</td>
									      		<td width="50px;">
									      			<a href="#"><h4 style="float: left">  <i class="fa fa-pencil-square-o"></i></h4></a>
									      			<a href="#"><h4 style="float: right;"><i class="fa fa-trash-o"></i></h4></a>
									      		</td>
											</tr>        
										</c:forEach>
								  	</tbody>
								</table>
							</c:otherwise>
						</c:choose>
					</div>
				</section>			
			</div>
		</div>
		<div id="divDemaisCadastros" style="display: none">
			<div class="col-lg-6">
				<section class="panel"> 
				
				<header class="panel-heading" id="HDadosP"> 
					Dados Pessoais &nbsp;&nbsp; 
					<i class="arrow_carrot-up_alt2"></i> 
				</header>
				
				<div class="panel-body" id="panelDadosP">
					<form role="form" method="post" action="${pageContext.request.contextPath}/dadosPessoaisServlet">
						<div class="form-group">
							<label for="exampleInputEmail1">Data de nascimento:</label> 
							<input type="text" class="form-control" name=dataNascimento id=dataNascimento>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Naturalidade:</label> 
							<input type="text" class="form-control" name=naturalidade id=naturalidade>
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Nacionalidade:</label> 
							<input type="text" class="form-control" name=nacionalidade id=nacionalidade>
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Sexo:</label> 
							<select class="form-control m-bot15" name=sexo id=sexo>
								<option>Selecione</option>
								<option value="1">Masculino</option>
								<option value="2">Feminino</option>
							</select>
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Tipo Sanguíneo:</label> 
							<select class="form-control m-bot15" name=tipoSanguineo id=tipoSanguineo>
								<option>Selecione</option>
								<option value="A+ ">A+</option>
								<option value="A- ">A-</option>
								<option value="B+ ">B+</option>
								<option value="B- ">B-</option>
								<option value="AB+">AB+</option>
								<option value="AB-">AB-</option>
								<option value="O+ ">O+</option>
								<option value="O- ">O-</option>
							</select>
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Escolaridade:</label> 
							<select class="form-control m-bot15" name=escolaridade id=escolaridade>
								<option>Selecione</option>
								<option value="Primário">Primário</option>
								<option value="Ginásio">Ginásio</option>
								<option value="Primeiro Grau">Primeiro Grau</option>
								<option value="Segundo Grau">Segundo Grau</option>
								<option value="Técnico">Técnico</option>
								<option value="Superior Completo">Superior Completo</option>
								<option value="Superior Incompleto">Superior Incompleto</option>
								<option value="Lê e escreve">Lê e escreve</option>
								<option value="Analfabeto">Analfabeto</option>
							</select>
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Pai:</label> 
							<input type="text" class="form-control" name=pai id=pai>
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Mãe:</label> 
							<input type="text" class="form-control" name=mae id=mae>
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Estado Civil:</label> 
							<select class="form-control m-bot15" name=estadoCivil id=estadoCivil>
								<option value="Selecione    ">Selecione</option>
								<option value="Solteiro(a)  ">Solteiro(a)</option>
								<option value="Casado(a)	  ">Casado(a)</option>
								<option value="Viúvo(a)     ">Viúvo(a)</option>
								<option value="Divorciado(a)">Divorciado(a)</option>
								<option value="Desquitado(a)">Desquitado(a)</option>
								<option value="Separado(a)  ">Separado(a)</option>
							</select>
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Data de casamento:</label> 
							<input type="text" class="form-control" name=dataDeCasamento id=dataDeCasamento>
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Cônjugue:</label> 
							<input type="text" class="form-control" name=conjugue id=conjugue>
						</div>

						<div class="form-group col-lg-offset-10">
							<button type="submit" class="btn btn-primary">Cadastrar</button>
						</div>
					</form>
				</div>
				</section>
			</div>
			<div class="col-lg-6">
				<section class="panel"> <header class="panel-heading"
					id="HideHoriFrm"> Endereço &nbsp;&nbsp; <i
					class="arrow_carrot-up_alt2"></i> </header>

				<div class="panel-body" id="panelHoriFrm">
					<form role="form">

						<div class="form-group">
							<label for="exampleInputEmail1">Código:</label> <input
								type="text" class="form-control">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Telefone Residêncial:</label>
							<input type="text" class="form-control">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Telefone Comercial:</label> <input
								type="text" class="form-control">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Celular:</label> <input
								type="text" class="form-control">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Endereço:</label> <input
								type="text" class="form-control">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Bairro:</label> <input
								type="text" class="form-control">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Cidade:</label> <input
								type="text" class="form-control">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">UF:</label> <input type="text"
								class="form-control">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">CEP:</label> <input
								type="text" class="form-control">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Grupo Familiar:</label> <input
								type="text" class="form-control">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Profissão:</label> <select
								class="form-control m-bot15">
								<option>Selecione</option>
								<c:forEach var="profissao" items="${requestScope.listaProfissoes}">
									<option value="${profissao.codigo}">${profissao.profissao}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">Local de Trabalho:</label> <input
								type="text" class="form-control">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">E-mail:</label> <input
								type="text" class="form-control">
						</div>

						<div class="form-group col-lg-offset-10">
							<button type="submit" class="btn btn-primary">Cadastrar</button>
						</div>
					</form>
				</div>
				</section>
			</div>
			<div class="row">
				<div class="col-lg-12">

					<div class="row">
						<div class="col-lg-6">
							<section class="panel"> <header class="panel-heading"
								id="hideDadosEcle"> Dados Eclesiásticos &nbsp;&nbsp; <i
								class="arrow_carrot-up_alt2"></i> </header>
							<div class="panel-body" id="panelDadosEcle">
								<form action="#">
									<div class="form-group">
										<label for="exampleInputEmail1">Admitido em:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Admitido por:</label> <select
											class="form-control m-bot15">
											<option>Selecione</option>
											<c:forEach var="admissao" items="${requestScope.listaAdmissoes}">
												<option value="${admissao.codigo}">${admissao.texto}</option>
											</c:forEach>
										</select>
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Livro:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Página:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Igreja de Origem:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Ata número:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Eliminado em:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Eliminado por:</label> <select
											class="form-control m-bot15">
											<option>Selecione</option>
											<c:forEach var="eliminacao" items="${listaEliminacoes}">
												<option value="${eliminacao.codigo}">${eliminacao.texto}</option>
											</c:forEach>
										</select>
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Livro:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Página:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Igreja de Destino:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Ata número:</label> <input
											type="text" class="form-control">
									</div>


									<div class="form-group">
										<label for="exampleInputEmail1">Igreja de Batismo:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Pastor:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Data:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Igreja da Profissão de
											Fé:</label> <input type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Pastor:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">Data:</label> <input
											type="text" class="form-control">
									</div>

									<div class="form-group col-lg-offset-10">
										<button type="submit" class="btn btn-primary">Cadastrar</button>
									</div>
								</form>
							</div>
							</section>
						</div>
						<div class="col-lg-6">
							<section class="panel"> 
							<header class="panel-heading" id="hideSituacao"> Situação &nbsp;&nbsp; 
								<i class="arrow_carrot-up_alt2"></i> 
							</header>
							<div class="panel-body" id="panelSituacao">
								<form action="#" method="get" accept-charset="utf-8">
									<div class="form-group">
										<label for="exampleInputEmail1">Sociedade a que
											pertence:</label> <select class="form-control m-bot15">
											<option>Selecione</option>
											<c:forEach var="sociedade" items="${listaSociedades}">
												<option value="${sociedade.codigo}">${sociedade.sociedade}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Talentos:</label>
										<textarea rows="10" cols="10" class="form-control"></textarea>
									</div>
									<div class="form-group col-lg-offset-10">
										<button type="submit" class="btn btn-primary">Cadastrar</button>
									</div>
								</form>
							</div>
							</section>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section> 
	</section> 
	</section>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/rolDeMembros.js"></script>
</body>
</html>
