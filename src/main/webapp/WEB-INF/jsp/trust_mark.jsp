<!DOCTYPE HTML>
<!--[if lt IE 8]><html class="no-js oldIE" lang="en-US"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9" lang="en-US"><![endif]-->
<!--[if IE 9]><html class="no-js ie9" lang="en-US"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en-US" class="no-js not-ie">
<!--<![endif]-->

<head>
<style>
  .btn-success{margin-left:38%;color:#fff;}
.btn-success > a{color:#fff;}
</style>    

</head>

<body>



<jsp:include page="header.jsp"></jsp:include>

    
    <div id="mainImageDiv" role="image slider for visual appeal">

        <div class="slickit">
            <div>
                <image src="${pageContext.request.contextPath}/static/Images/header.jpg" class="headImage" alt="header hands typing on keyboard" />
            </div>

        </div>


    </div>

    <!-- begin Main -->
    <main role="main" aria-label="main section" id="main-content">
        <!-- The example code below will create a two column grid with a medium breakpoint -->
        <div class="container bottomMargin50" role="header and benefits">
            <section id="page-title">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="center">Proud to be Inclusive? Put an eQuality TrustMark on your website.</h1>
                         <div class="col-md-offset-1 col-md-10 col-md-offset-1 " style="text-align: justify; letter-spacing: 1px; word-spacing: 3px;">
                        <p class="center">eQuality certification for your website increases the trust of the people with disabilities. The internet is very important in our daily lives, including the lives of people with visual,auditory,motor,neuro or other disabilities. They too check the news, weather, sports, social networks, do banking transaction, buy products or make travel plans just like all other people. Not every website, however is designed for use by people with disabilities</p>
                        <p class="center">The eQuality website trustmark program helps you become and remain compliant with the common standards for accessibility websites.</p>
                        
                        <hr/>
                    </div>
                    </div>
                </div>
            </section>

            <section id="boxes" role="features" class="">
                <div class="row">
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                                <img class="" alt="Project planning" src="${pageContext.request.contextPath}/static/Images/portfolio7.jpg">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-plane"></i></span><span class="sr-only">plane Icon</span>
                                </div>
                                <h3 class="half-panel-title">Free Forever</h3>
                                <p style="font-size: 2em;">$0 <sub>/year</sub></p>
                                <ul><li>Test upto 6 pages(URL's)</li>
                                    <li>Testing is automated</li>
                                 <li>WCAG A compliance(Partial)</li>
                                 <li>Detailed report in excel format</li>
                                 <li>Pages will be scanned once every 3 months </li>
                                 <li>Free Level 0 eQuality TrustMark</li>
                                <a href="${pageContext.request.contextPath}/test.html" ><button class="btn btn-success">Test</button></a>
                                </ul>
							   <%--  <button class="btn btn-success"><a href="${pageContext.request.contextPath}/test.html" >Test</a></button> --%>
                            </div> 
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                                <img class="" alt="Project planning" src="${pageContext.request.contextPath}/static/Images/portfolio3.jpg">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-user"></i></span><span class="sr-only">user Icon</span>
                                </div>
                                <h3 class="half-panel-title">For Individuals</h3>
                                 <p style="font-size: 2em;">$100 <sub>/year</sub></p>
                              <ul><li>Test upto 25 pages(URL's)</li>
                                    <li>Testing is automated + Manual</li>
                                 <li>WCAG AA compliance</li>
                                 <li>Detailed report in excel format</li>
                                 <li>Pages will be scanned once every 3 months </li>
                                 <li>Free Level 1 eQuality TrustMark</li>
           
                                 <a href="${pageContext.request.contextPath}/PaymentDetails?email=${emailId}&&userName=${username}"><button class="btn btn-success">Subscribe</button></a>
                                </ul>
                                <%-- <button class="btn btn-success"><a href="${pageContext.request.contextPath}/prousertest.html" class="button">prouserTest</a></button> --%>
								<%-- <button class="btn btn-success"><a href="${pageContext.request.contextPath}/PaymentDetails?email=${emailId}&&userName=${username}">Subscribe</a></button> --%>
								
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="half-panel" href="#">
                            <div class="half-panel-heading">
                                <img class="" alt="Project planning" src="${pageContext.request.contextPath}/static/Images/portfolio8.jpg">
                            </div>
                            <div class="half-panel-body">
                                <div class="half-panel-icon">
                                    <span aria-hidden="true"><i class="fa fa-cogs"></i></span><span class="sr-only">cogs Icon</span>
                                </div>
                                <h3 class="half-panel-title">For Business</h3>
                                <p style="font-size: 2em;">$250 <sub>/year</sub></p>
                              <ul><li>Test upto 50 pages(URL's)</li>
                                    <li>Testing is automated + Manual</li>
                                 <li>WCAG AA compliance</li>
                                 <li>Detailed report in excel format</li>
                                 <li>Pages will be scanned once every month </li>
                                 <li>Free Level 2 eQuality TrustMark</li>
                                </ul>
                                <a href="${pageContext.request.contextPath}/signup.html" class="button"><button class="btn btn-success">Sign Up</button></a></li>
								
                            </div>
                        </div>
                    </div>
                </div>

                <!--<div class="row">
                    <div class="col-md-3">
                        <div class="featured-box noborder">
                            <button class="btn buttonRound blue"><span aria-hidden="true"><i class="fa fa-wheelchair"></i></span><span class="sr-only">Wheelchair Icon</span></button>
                            <h4>Accessible Websites</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing metus elit. Lorem ipsum dolor sit amet, consectetur adipiscing metus elit.</p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="featured-box noborder">
                            <button class="btn buttonRound blue"><span aria-hidden="true"><i class="fa fa-desktop"></i></span><span class="sr-only">desktop Icon</span></button>
                            <h4>Responsive</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing metus elit. Lorem ipsum dolor sit amet, consectetur adipiscing metus elit.</p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="featured-box noborder">
                            <button class="btn buttonRound blue"><span aria-hidden="true"><i class="fa fa-user"></i></span><span class="sr-only">user Icon</span></button>
                            <h4>Free Support</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing metus elit. Lorem ipsum dolor sit amet, consectetur adipiscing metus elit.</p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="featured-box noborder">
                            <button class="btn buttonRound blue"><span aria-hidden="true"><i class="fa fa-cogs"></i></span><span class="sr-only">cogs Icon</span></button>
                            <h4>Free Updates</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing metus elit. Lorem ipsum dolor sit amet, consectetur adipiscing metus elit.</p>
                        </div>
                    </div>
                </div>-->
            </section>
        </div>

       


    </main>

    <jsp:include page="footer.jsp"></jsp:include>
   
   <div id="dialog" title="Basic dialog">
        <div id="dialogContent"></div>
    </div>
    <!-- build:js scripts/main.js -->
    <!--<script data-main="scripts/main" src="vendor/requirejs/require.js"></script>-->
    <!-- endbuild -->
    <script src="${pageContext.request.contextPath}/static/vendor/globalassets/scripts/assets.responsive.js"></script>

    <script src="${pageContext.request.contextPath}/static/vendor/share/4.0/js/sharewidget-4.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/slick-1.5.7/slick.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendor/portfolio/jquery.quicksand.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendor/back-to-top/main.js"></script>
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
