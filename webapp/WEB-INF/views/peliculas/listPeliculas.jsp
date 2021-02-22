<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Peliculas</title>
    
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/peliculas/create" var="urlNueva"></spring:url>
    <spring:url value="/peliculas/edit" var="urlEdit"></spring:url>
    <spring:url value="/peliculas/delete" var="urlDelete"></spring:url>
    <spring:url value="/peliculas/indexPaginate" var="urlPeliculas"></spring:url>
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>

    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de Peliculas</h3>
      
      <c:if test="${mensaje!=null}">
      	<div class='alert alert-success' role="alert">${mensaje}</div>
      </c:if>
      
      
      <a href="${urlNueva}" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Titulo</th>
					<th>Genero</th>
					<th>Clasificacion</th>
					<th>Duracion</th>
					<th>Fecha Estreno</th>
					<th>Estatus</th>
					<th>Opciones</th>
				</tr>
				<c:forEach items="${peliculas}" var="listPelis">
					<tr>
						<td><c:out value="${listPelis.titulo}"/></td>
						<td><c:out value="${listPelis.genero}"/></td>
						<td><c:out value="${listPelis.clasificacion}" /></td>
						<td><c:out value="${listPelis.duracion}"/></td>
						<td><fmt:formatDate pattern="dd-MM-yyyy" value="${listPelis.fechaEstreno}" /></td>
						<td>
						  <c:choose >
						  	<c:when test="${listPelis.estatus eq 'Activa'}">
						  		<span class="label label-success">${listPelis.estatus }</span>
						  	</c:when>
						  	<c:otherwise>
						  		<span class="label label-danger">${listPelis.estatus }</span>
						  	</c:otherwise>
							
						  </c:choose>
						</td>
						<td><a href="${urlEdit}/${listPelis.id}" class="btn btn-success btn-sm" role="button"
							title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="${urlDelete}/${listPelis.id}" onclick='return confirm("¿Estas Seguro?")' class="btn btn-danger btn-sm" role="button"
							title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<nav aria-label="">
				<ul class="pager">
					<li><a
						href="${urlPeliculas}/indexPaginate?page=${listPelis.number - 1 }">Anterior</a></li>
					<li><a
						href="${urlPeliculas}/indexPaginate?page=${listPelis.number + 1 }">Siguiente</a></li>
				</ul>
			</nav>
		</div>
          
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>
