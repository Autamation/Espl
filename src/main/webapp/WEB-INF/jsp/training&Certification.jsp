<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>
<!--[if lt IE 8]><html class="no-js oldIE" lang="en-US"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9" lang="en-US"><![endif]-->
<!--[if IE 9]><html class="no-js ie9" lang="en-US"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en-US" class="no-js not-ie">
<!--<![endif]-->

<head>
    <style>
      #imgCont{position: absolute;margin-top: -160px;margin-left: 8%;}
      .btn-primary{margin-left:38%;}
    </style>
    
</head>

<body>
  <jsp:include page="header.jsp"></jsp:include>
    <div id="mainImageDiv" role="image slider for visual appeal">

        <div class="slickit">
            <div>
                <img src="${pageContext.request.contextPath}/static/Images/online-courses.jpg" id="headerImg" alt="header image man writing in notebook" height="500" width="1400" />
            </div>
            <!-- <div>
                <image src="images/header2.jpg" class="headImage" alt="header image man writing in notebook" />
            </div>
            <div>
                <image src="images/header3.jpg" class="headImage" alt="header image coffee earphones monitor" />
            </div> -->

        </div>
        <h1 id="imgCont">Tommorow's Skills Today.<br>Advance Your Career. Improve Your Life. </h1>


    </div>

    <!-- begin Main -->
    <main role="main" aria-label="main section" id="main-content">
        <!-- The example code below will create a two column grid with a medium breakpoint -->
        <div class="container bottomMargin50" role="header and benefits">
            <section id="page-title">
                <div class="row">
                    <div class="col-md-12">
                        <h2 style="padding: 2%; padding-left: 24%; color:#20d682">E-Quality Programs Starting Soon.. </h2>
                        <hr/>
                    </div>
                </div>
            </section>

            <section id="boxes" role="features" class="">
                <div class="row">
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                               <!--  <img class="" alt="Project planning" src="images/portfolio7.jpg"> -->
                                 <img class="card-img-top" src="${pageContext.request.contextPath}/static/Images/Elearning Tools.png" alt="Card image cap" height="220px;">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-plane"></i></span><span class="sr-only">plane Icon</span>
                                </div>
                                <h4 class="card-title">Microsoft Professional Program </h4>
                                <p class="card-text">Learn about the key aspects of business, from finance to marketing, to advance or start your career in the business world.</p>
                                <a href="https://www.edx.org/microsoft-professional-program-data-science" target="_self" class="btn btn-primary">Explore</a>
                               
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                               <!--  <img class="" alt="Project planning" src="images/portfolio3.jpg"> -->
                                <img class="card-img-top" src="${pageContext.request.contextPath}/static/Images/accessbility.jpg" alt="Card image cap" height="220px;">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-user"></i></span><span class="sr-only">user Icon</span>
                                </div>
                               <h4 class="card-title">Web Accessibility: Learn Best Practices, Tools & Techniques</h4>
                               <p class="card-text">Learn simple steps to ensure you aren’t alienating large groups of users due to poor accessibility.</p>
                               <a href="https://www.udemy.com/website-accessibility-course/" target="_self" class="btn btn-primary">Explore</a>
                               
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                                <!-- <img class="" alt="Project planning" src="images/portfolio8.jpg"> -->
                                <img class="card-img-top" src="${pageContext.request.contextPath}/static/Images/a1.jpg" alt="Card image cap" height="220px;">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-cogs"></i></span><span class="sr-only">cogs Icon</span>
                                </div>
                                 <h4 class="card-title">Designing Web Accessibility for a Beautiful Web</h4>
                                 <p class="card-text">Learn how to design accessible content as well as write accessible HTML and XHTML markup and CSS.</p>
                                 <a href="https://www.udemy.com/designing-web-accessibility-for-a-beautiful-web/" target="_self" class="btn btn-primary">Explore</a>
                                
                            </div>
                        </div>
                    </div>
                </div>
       
            </section>
            <section id="boxes" role="features" class="">
                <div class="row">
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                               <!--  <img class="" alt="Project planning" src="images/portfolio7.jpg"> -->
                                <img class="card-img-top" src="${pageContext.request.contextPath}/static/Images/js1.jpg" alt="Card image cap" height="220px;">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-plane"></i></span><span class="sr-only">plane Icon</span>
                                </div>
                               <h4 class="card-title">JavaScript Fundamentals core concepts </h4>
                             <p class="card-text">Learn the basics of JavaScript with code examples JavaScript is key to making web page...</p>
                             <a href="https://www.udemy.com/javascript-online/" class="btn btn-primary">Explore</a>
                               
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                               <!--  <img class="" alt="Project planning" src="images/portfolio3.jpg"> -->
                                <img class="card-img-top" src="${pageContext.request.contextPath}/static/Images/html1.jpg" alt="Card image cap" height="220px;">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-user"></i></span><span class="sr-only">user Icon</span>
                                </div>
                              <h4 class="card-title">Build Responsive Real World Websites with HTML5 and CSS3</h4>
                                <p class="card-text">The easiest way to learn modern web design, HTML5 and CSS3 step-by-step from scratch.</p>
                                <a href="https://www.udemy.com/design-and-develop-a-killer-website-with-html5-and-css3/" target="_self" class="btn btn-primary">Explore</a>
                               
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                                <!-- <img class="" alt="Project planning" src="images/portfolio8.jpg"> -->
                                <img class="card-img-top" src="${pageContext.request.contextPath}/static/Images/angular1.jpg" alt="Card image cap" height="220px;">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-cogs"></i></span><span class="sr-only">cogs Icon</span>
                                </div>
                                <h4 class="card-title">Learn and Understand AngularJS</h4>
                                <p class="card-text">Master AngularJS and the Javascript concepts behind it, design custom directives, and build a single page application.</p>
                                <a href="https://www.udemy.com/learn-angularjs/ " target="_self" class="btn btn-primary">Explore</a>
                                
                            </div>
                        </div>
                    </div>
                </div>
       
            </section>
            <section id="boxes" role="features" class="">
                <div class="row">
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                               <!--  <img class="" alt="Project planning" src="images/portfolio7.jpg"> -->
                                 <img class="card-img-top" src="${pageContext.request.contextPath}/static/Images/node1.jpg" alt="Card image cap" height="220px;">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-plane"></i></span><span class="sr-only">plane Icon</span>
                                </div>
                               <h4 class="card-title">Learn and Understand NodeJS</h4>
                    <p class="card-text">Dive deep under the hood of NodeJS. Learn V8, Express, the MEAN stack, core Javascript concepts, and Build, test...</p>
                    <a href="https://www.udemy.com/understand-nodejs/" class="btn btn-primary">Explore</a>
                               
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                               <!--  <img class="" alt="Project planning" src="images/portfolio3.jpg"> -->
                                <img class="card-img-top" src="${pageContext.request.contextPath}/static/Images/selenium1.jpg" alt="Card image cap" height="220px;">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-user"></i></span><span class="sr-only">user Icon</span>
                                </div>
                               <h4 class="card-title">Selenium WebDriver with Java - Basics to Advanced& Interview</h4>
                    <p class="card-text">Join with us-"Top Ranked Best Selenium course - 22000+ students..."</p>
                    <a href="https://www.udemy.com/selenium-real-time-examplesinterview-questions/" target="_self" class="btn btn-primary">Explore</a>
                               
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                                <!-- <img class="" alt="Project planning" src="images/portfolio8.jpg"> -->
                                <img class="card-img-top" src="${pageContext.request.contextPath}/static/Images/java1.jpg" alt="Card image cap" height="220px;">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-cogs"></i></span><span class="sr-only">cogs Icon</span>
                                </div>
                                 <h4 class="card-title">Complete Java Masterclass</h4>
                    <p class="card-text">Learn to master Java 8 and Java 9 core development step-by-step, and make your first unique, advanced program in 30 days.</p>
                    <a href="https://www.udemy.com/java-the-complete-java-developer-course/ " target="_self" class="btn btn-primary">Explore</a>
                                
                            </div>
                        </div>
                    </div>
                </div>
       
            </section>
           
            
        </div>

        <!--container-->
 
    </main>

   <jsp:include page="footer.jsp"></jsp:include>
    <div id="dialog" title="Basic dialog">
        <div id="dialogContent"></div>
    </div>
    <!-- build:js scripts/main.js -->
    <!--<script data-main="scripts/main" src="vendor/requirejs/require.js"></script>-->
    <!-- endbuild -->
    <script src="vendor/globalassets/scripts/assets.responsive.js"></script>

    <script src="vendor/share/4.0/js/sharewidget-4.0.js"></script>
    <script type="text/javascript" src="vendor/slick-1.5.7/slick.min.js"></script>
    <script src="vendor/portfolio/jquery.quicksand.js"></script>
    <script src="vendor/back-to-top/main.js"></script>
    <script type="text/javascript" src="http://shakedwebdesign.com/plugins/accessibility-menu/accessibilitymenu.js" data-language="eng" data-oemsource="accessible+" data-sign="classic"></script>
    <script>

        $(function() {
            $('#accordion-container').accordion();


            $('.slickit').slick({
                arrows: true,
                accessibility: true,
                dots: true,


            });


            $('.smallSlick').slick({
                arrows: true,
                accessibility: true,


            });


            $('.slider-portfolio').slick({
                slidesToShow: 3,
                accessibility: true,
                slidesToScroll: 3,
                dots: true,

                focusOnSelect: true,
                responsive: [{
                    breakpoint: 1000,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2
                    }
                }, {
                    breakpoint: 700,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        centerMode: true,
                    }
                }],

            });



        });

    </script>
</body>

</html>

