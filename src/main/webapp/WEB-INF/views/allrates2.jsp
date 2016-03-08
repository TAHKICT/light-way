<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="<c:url value="resources/css/styles.css" />" rel="stylesheet">
<link href="<c:url value="resources/css/mystyle.css" />" rel="stylesheet">
<link href="<c:url value="resources/js/jquery-1.11.1.min.js" />" rel="stylesheet">
<script src="<c:url value="resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="resources/js/jquery-1.11.1.min.js" />"></script>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf8">
  <title><spring:message code="label.title" /></title>
</head>
<body>
<div class="wrapper container">
  <header>
    <a href="/"><img src="<c:url value="resources/images/logo.png"/>" ></a>
    <form name="search" action="#" method="get" class="form-inline form-search pull-right">
      <div class="input-group">
        <label class="sr-only" for="searchInput">Поиск</label>
        <input class="form-control" id="searchInput" type="text" name="search" placeholder="поиск">
        <div class="input-group-btn">
          <button type="submit" class="btn btn-primary">GO</button>
        </div>
      </div>
    </form>
  </header>
  <nav class="navbar navbar-default">
    <ul class="nav navbar-nav">
      <li><a href="/main.html">Главная</a></li>
      <li ><a href="/about.html">О сервисе</a></li>
      <li><a href="/rates">Текущий курс</a></li>
      <li ><a href="/ukrbanks.html">Банки Украины</a></li>
      <li><a href="/author.html">Об авторе</a></li>
      <li><a href="/connect.html">Связь с автором</a></li>
    </ul>
  </nav>
  <div class="heading">
    <h1>CURRENT EXCHANGE RATE</h1>
  </div>
  <div class="row">

    <section class="col-md-24">
      <div class="jumbotron">
        <blockquote>
          <p>
            &ldquo;Люди считают, что программирование — это наука избранных, но в реальности все наоборот — просто много людей создают программы, которые используют чужие программы, как-будто строя стену из маленьких кирпичиков.&rdquo;
          </p>
          <small>Donald Knuth</small>
        </blockquote>
      </div>
      <div class = "text-success">
        <c:if test="${!empty allRates2}">
          <table id="currency-table" class="table table-hover table-bordered" >
            <thead>
            <tr>
              <th><spring:message code="label.TTime" /></th>
              <th><spring:message code="label.USDbuy" /></th>
              <th><spring:message code="label.USDsell" /></th>
              <th><spring:message code="label.EURbuy" /></th>
              <th><spring:message code="label.EURsell" /></th>
              <th>&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allRates2}" var="rate">
            <tr>
              <td>${rate.TTime}</td>
              <td>${rate.USDbuy}</td>
              <td>${rate.USDsell}</td>
              <td>${rate.EURbuy}</td>
              <td>${rate.EURsell}</td>
            </tr>
            </c:forEach>
            <tbody>
          </table>
        </c:if>

      </div>

      <h2>USED TECHNOLOGIES</h2>
      <div class="team">
        <div class="row">
          <div class="col col-md-4">
            <img src="<c:url value="resources/images/technologies/developer.jpg"/>" alt="John Doe" class="thumbnail">
            <div class="caption">
              <h3>Roman Mykhailenko</h3>
              <p>developer</p>
            </div>
          </div>
          <div class="col col-md-4 col-md-offset-1">
            <img src="<c:url value="resources/images/technologies/hibernate.jpg"/>" class="thumbnail">
            <div class="caption">
              <h3>Hibernate</h3>
              <p>technology</p>
            </div>
          </div>
          <div class="col col-md-4 col-md-offset-1">
            <img src="<c:url value="resources/images/technologies/bootstrap.jpg"/>" class="thumbnail">
            <div class="caption">
              <h3>Bootstrap</h3>
              <p>framework</p>
            </div>
          </div>
          <div class="col col-md-4 col-md-offset-1">
            <img src="<c:url value="resources/images/technologies/spring.jpg"/>" class="thumbnail">
            <div class="caption">
              <h3>Spring</h3>
              <p>framework</p>
            </div>
          </div>
          <div class="col col-md-4 col-md-offset-1">
            <img src="<c:url value="resources/images/technologies/idea.jpg"/>" class="thumbnail">
            <div class="caption">
              <h3>Intelij IDEA</h3>
              <p>ide</p>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col col-md-4">
            <img src="<c:url value="resources/images/technologies/tomcat.jpg"/>" class="thumbnail">
            <div class="caption">
              <h3>Tomcat</h3>
              <p>apache</p>
            </div>
          </div>
          <div class="col col-md-4 col-md-offset-1">
            <img src="<c:url value="resources/images/technologies/sublime.jpg"/>" class="thumbnail">
            <div class="caption">
              <h3>Sublime Text</h3>
              <p>text redactor</p>
            </div>
          </div>
          <div class="col col-md-4 col-md-offset-1">
            <img src="<c:url value="resources/images/technologies/mysql.jpg"/>" class="thumbnail">
            <div class="caption">
              <h3>MySQL</h3>
              <p>database</p>
            </div>
          </div>
          <div class="col col-md-4 col-md-offset-1">
            <img src="<c:url value="resources/images/technologies/html5.jpg"/>" class="thumbnail">
            <div class="caption">
              <h3>html5</h3>
              <p>HyperText Markup Language</p>
            </div>
          </div>
          <div class="col col-md-4 col-md-offset-1">
            <img src="<c:url value="resources/images/technologies/css.jpg"/>" class="thumbnail">
            <div class="caption">
              <h3>CSS3</h3>
              <p>lCascading Style Sheets</p>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</div>
<footer>
  <div class="container">
    <div class="row">
      <div class="col-md-8 twitter">
        <h3>Twitter feed</h3>
        <time datetime="2012-10-23"><a href="#">23 oct</a></time>
        <p>
          In ultricies pellentesque massa a porta. Aliquam ipsum enim, hendrerit ut porta nec, ullamcorper et nulla. In eget mi dui, sit amet scelerisque nunc. Aenean aug
        </p>
      </div>
      <div class="col-md-4 sitemap">
        <h3>Sitemap</h3>
        <div class="row">
          <div class="col-md-12">
            <a href="../static/about.html">Home</a>
            <a href="../static/about.html">About</a>
            <a href="currency.jsp">Currency</a>
          </div>
          <div class="col-md-12">
            <a href="../static/ukrbanks.html">Banks</a>
            <a href="../static/author.html">Author</a>
            <a href="../static/connect.html">Contact</a>
          </div>
        </div>
      </div>
      <div class="col-md-4 social">
        <h3>Social networks</h3>
        <a href="http://twitter.com/" class="social-icon twitter"></a>
        <a href="http://facebook.com/" class="social-icon facebook"></a>
        <a href="http://plus.google.com/" class="social-icon google-plus"></a>
        <a href="http://vimeo.com/" class="social-icon-small vimeo"></a>
        <a href="http://youtube.com/" class="social-icon-small youtube"></a>
        <a href="http://flickr.com/" class="social-icon-small flickr"></a>
        <a href="http://instagram.com/" class="social-icon-small instagram"></a>
        <a href="/rss/" class="social-icon-small rss"></a>
      </div>
      <div class="col-md-8 footer-logo">
        <a href="/"><img src="<c:url value="resources/images/footer-logo.png"/>" class="thumbnail"></a>
        <p>
          Copyright &copy; 2012 Whitesquare. A
          <a href="http://pcklab.com">pcklab</a> creation
        </p>
      </div>
    </div>
  </div>
</footer>






</body>
</html>
