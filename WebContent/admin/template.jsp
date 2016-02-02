<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.png">
	
    <title>Admin IPJC</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    
    <link href="${pageContext.request.contextPath}/css/bootstrap-theme.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style-responsive.css" rel="stylesheet" />
    <style type="text/css">
    	form{
    		margin-bottom: 0em;
    	}
    </style>
	
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
      <script src="../js/html5shiv.js"></script>
      <script src="../js/respond.min.js"></script>
      <script src="../js/lte-ie7.js"></script>
    <![endif]-->

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrollTo.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.nicescroll.js" type="text/javascript"></script><!--custome script for all page-->
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.maskedinput.js"></script>
    
</head>


      <header class="header dark-bg">
            <div class="toggle-nav">
                <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"></div>
            </div>
            <a href="" class="logo">IPJC <span class="lite">Admin</span></a>
      </header>      
     
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu">                
                  <li>
                      <a href="${pageContext.request.contextPath}/admin/index.jsp">
                          <i class="icon_house_alt"></i>
                          <span>Home</span>
                      </a>
                  </li>
				  <li class="sub-menu">
                      <a href="#" >
                          <i class="icon_document_alt"></i>
                          <span>Cadastros</span>
                          <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; & Consultas</span>
                          
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                      	  <form method="post" action="${pageContext.request.contextPath}/Controller">
	                          <input type=hidden name=tipoDeCarregamento value=parcial>
	                      	  <input type=hidden name=tarefa value=PreparaDadosDosCombosDoRolDeMembros>
	                          <li>
	                              <a href="#" onclick="$(this).closest('form').submit();">Rol de Membros</a></li>
	  	                      </li>                          
	                      </form>
                          <li><a  href="">Cargos</a></li>
                          <li><a  href="">Formas de Admiss�o</a></li>
                          <li><a  href="">Condi��es</a></li>
                          <li><a  href="">Motivos de exclus�o</a></li>
                          <li><a  href="">Endere�os</a></li>
                          <li><a  href="">Grupo Familiar</a></li>
                          <li><a  href="">Localiza��o</a></li>
                          <li><a  href="">Profiss�es</a></li>
                          <li><a  href="">Sociedades</a></li>
                          <li><a  href="">Usu�rios</a></li>
                      </ul>
                  </li>       
                  
                  <li class="sub-menu ">
                      <a href="javascript:;" class="">
                          <i class="icon_documents_alt"></i>
                          <span>Relat�rios</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">                          
                          <li><a class="" href="">Anivers�riantes</a></li>
                      </ul>
                  </li>
                  
                  <li>                     
                      <a class="" href="">
                          <i class="icon_piechart"></i>
                          <span>Gr�ficos</span>
                          
                      </a>
                                         
                  </li>
                             
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_table"></i>
                          <span>Tabelas</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="">Basic Table</a></li>
                      </ul>
                  </li>
              </ul>
          </div>
      </aside>
