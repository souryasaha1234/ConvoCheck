<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ConvoCheck | Home</title>
        <!-- CSS only -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
        <link rel="icon" type="image/jpg" href="img/head_logo (2).png">
        <link rel="stylesheet" href="style.css">
        
    </head>
    <body>
    
    	<%
    		//Controlling the Back Button after Log_out
    		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//HTTP 1.1
			response.setHeader("Pragma", "no-cache"); //HTTP 1.0
			response.setHeader("Expires", "0"); //Proxies
    		
	    	String log = null,facilities = null,slideConvert123 = null,slideEvaluate23 = null;
			String slide4 = null,slideConvert567 = null;
			String card1 = null,card2 = null,card3 = null,card4 = null;
			String welcome = "";
			//If user is not Logged-In
    		if(session.getAttribute("username") == null){
    			//response.sendRedirect("beforelogin");
    			log = "<a href='loginpage'>"+"<i class='bi bi-person-fill'></i> <b>Log-In</b></a>";
    			facilities = "<a href='loginpage'>Equation Conversion</a>"
                        +"<a href='loginpage'>Base Conversion</a>"
                        +"<a href='loginpage'>Code Conversion</a>"
                        +"<a href='loginpage'>Expression Evaluation</a>";
				slideConvert123 = "<a href='loginpage'><h3>Click to convert</h3></a>";
				slideEvaluate23 = "<a href='loginpage'><h3>Click to evaluate</h3></a>";
				slide4 = "<a href='loginpage'><h3>Click to convert</h3></a>";
				slideConvert567 = "<a href='loginpage'><h3>Click to convert</h3></a>";
				card1 = "<a href='loginpage'><b>Proceed </b>"+"<i class='bi bi-arrow-right-circle-fill'></i></a>";
				card2 = "<a href='loginpage'><b>Proceed </b>"+"<i class='bi bi-arrow-right-circle-fill'></i></a>";;
				card3 = "<a href='loginpage'><b>Proceed </b>"+"<i class='bi bi-arrow-right-circle-fill'></i></a>";;
				card4 = "<a href='loginpage'><b>Proceed </b>"+"<i class='bi bi-arrow-right-circle-fill'></i></a>";;
    			
    		}
    		else{
    			log = "<a href='logout' style='color: white; background-color: red; border-radius: 30px;'><i class='bi bi-person-fill'></i> <b>Log-Out</b></a>";
    			facilities = "<a href='equationConversion'>Equation Conversion</a>"
                        +"<a href='baseConversion'>Base Conversion</a>"
                        +"<a href='codeConversion'>Code Conversion</a>"
                        +"<a href='evaluation'>Expression Evaluation</a>";
				slideConvert123 = "<a href='equationConversion'><h3>Click to convert</h3></a>";
				slideEvaluate23 = "<a href='evaluation'><h3>Click to evaluate</h3></a>";
				slide4 = "<a href='baseConversion'><h3>Click to convert</h3></a>";
				slideConvert567 = "<a href='codeConversion'><h3>Click to convert</h3></a>";
				card1 = "<a href='equationConversion'><b>Proceed </b>"+"<i class='bi bi-arrow-right-circle-fill'></i></a>";
				card2 = "<a href='baseConversion'><b>Proceed </b>"+"<i class='bi bi-arrow-right-circle-fill'></i></a>";;
				card3 = "<a href='codeConversion'><b>Proceed </b>"+"<i class='bi bi-arrow-right-circle-fill'></i></a>";;
				card4 = "<a href='evaluation'><b>Proceed </b>"+"<i class='bi bi-arrow-right-circle-fill'></i></a>";;
    			welcome = "<p class='welcome-message'>Welcome "+session.getAttribute("username")+" !</p>";
    		}
    	%>
        <!-- header -->
        <header>
        
            <%=welcome %>
        
         
            <a href="homepage"><img src="./img/Convo_Check_header_animation.gif" alt="ConvoCheck" height="150px"></a>
            <h2>-:A all purpose convertor for you:-</h2>
        </header>
        
        <!-- Navigation Bar -->
    <nav >
        <ul id="logo">
            <li>
                <a href="homepage"><img src="./img/LOGO_black_based.png" id="logo_navigation" height="40px"></a>
            </li>
        </ul>

        <ul id="navigations">
            <li>
            <!-- Change -->
                <%=log %>
            </li>
            <li>
                <div class="dropdown">
                    <button class="dropbtn"><b>Facilities</b> <i id="drop_icon" class="bi bi-caret-down-fill"></i></button>
                    <div class="dropdown-content">
                    <!-- Change -->
                      <%=facilities %>
                    </div>
                </div>
            </li>
            <li>
                <a href="about"><i class="bi bi-file-earmark-fill"></i> <b>About</b></a>
            </li>
            <li>
                <a href="homepage" id="this_nav"><i class="bi bi-house-fill"></i> <b>Home</b></a>
            </li>
            
        </ul>
    </nav>
    
    <!-- main elements -->

<!-- Slideshow container -->
<br>
<div class="slideshow-container">
    
    <!-- Full-width images with number and caption text -->
    <div class="mySlides fade">
        <div class="numbertext">1 / 7</div>
        <img src="./Convocheck-slides/Slide1.JPG" style="width:100%">
        <div class="text">
            <div class="clickable">
            <!-- Change -->
                <%=slideConvert123 %>
            </div>
        </div>
    </div>
    
    <div class="mySlides fade">
        <div class="numbertext">2 / 7</div>
        <img src="Convocheck-slides/Slide2.JPG" style="width:100%">
        <div class="text">
            <div class="clickable">
            <!-- Change -->
                <%=slideConvert123 %>
            </div>
            <div class="clickable">
            <!-- Change -->
                <%=slideEvaluate23 %>
            </div>
        </div>
    </div>
    
    <div class="mySlides fade">
        <div class="numbertext">3 / 7</div>
        <img src="Convocheck-slides/Slide3.JPG" style="width:100%">
        <div class="text">
            <div class="clickable">
            <!-- Change -->
                <%=slideConvert123 %>
            </div>
            <div class="clickable">
            <!-- Change -->
                <%=slideEvaluate23 %>
            </div>
        </div>
    </div>
    <div class="mySlides fade">
        <div class="numbertext">4 / 7</div>
        <img src="Convocheck-slides/Slide4.JPG" style="width:100%">
        <div class="text">
            <div class="clickable">
            <!-- Change -->
                <%=slide4 %>
            </div>
        </div>
    </div>
    <div class="mySlides fade">
        <div class="numbertext">5 / 7</div>
        <img src="Convocheck-slides/Slide5.JPG" style="width:100%">
        <div class="text">
            <div class="clickable">
            <!-- Change -->
                <%=slideConvert567 %>
            </div>
        </div>
    </div>
    <div class="mySlides fade">
        <div class="numbertext">6 / 7</div>
        <img src="Convocheck-slides/Slide6.JPG" style="width:100%">
        <div class="text">
            <div class="clickable">
            <!-- Change -->
                <%=slideConvert567 %>
            </div>
        </div>
    </div>
    <div class="mySlides fade">
        <div class="numbertext">7 / 7</div>
        <img src="Convocheck-slides/Slide7.JPG" style="width:100%">
        <div class="text">
            <div class="clickable">
            <!-- Change -->
                <%=slideConvert567 %>
            </div>
        </div>
    </div>
  
    <!-- Next and previous buttons -->
    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
    <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br>

<!-- The dots/circles -->
<div style="text-align:center">
    <span class="dot" onclick="currentSlide(1)"></span>
    <span class="dot" onclick="currentSlide(2)"></span>
    <span class="dot" onclick="currentSlide(3)"></span>
    <span class="dot" onclick="currentSlide(4)"></span>
    <span class="dot" onclick="currentSlide(5)"></span>
    <span class="dot" onclick="currentSlide(6)"></span>
    <span class="dot" onclick="currentSlide(7)"></span>
</div>

    <!-- Cards -->
    <div id="cards">
        <div class="container d-flex align-items-center justify-content-center flex-wrap">
            
            <div class="box">
                <div class="body">
                    <div class="imgContainer">
                        <hr>
                        <h1>Equation Conversion</h1>
                        <hr>
                    </div>
                    <div class="content d-flex flex-column align-items-center justify-content-center">
                        <div>
                            <h3 class="text-white fs-5">&#9679 Infix </h3>
                            <h3 class="text-white fs-5">&#9679 Postfix </h3>
                            <h3 class="text-white fs-5">&#9679 Prefix </h3>
                            <h3 class="text-white fs-5">Conversion </h3>
                            <br>
                            <br>
                            <div class="procedButton">
                            <!-- Change -->
                                <%=card1 %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="box">
                <div class="body">
                    <div class="imgContainer">
                        <hr>
                        <h1>Base Conversion</h1>
                        <hr>
                    </div>
                    <div class="content d-flex flex-column align-items-center justify-content-center">
                        <div>
                            <h3 class="text-white fs-5">From </h3>
                            <h3 class="text-white fs-5">&#9679 Base 2</h3>
                            <h3 class="text-white fs-5">to</h3>
                            <h3 class="text-white fs-5">&#9679base 36</h3>
                            <h3 class="text-white fs-5">Conversion </h3>
                            <br>
                            <div class="procedButton">
                            <!-- Change -->
                                <%=card2 %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="box">
                <div class="body">
                    <div class="imgContainer">
                        <hr>
                        <h1>Code Conversion</h1>
                        <hr>
                    </div>
                    <div class="content d-flex flex-column align-items-center justify-content-center">
                        <div>
                            <h3 class="text-white fs-5">&#9679 BCD </h3>
                            <h3 class="text-white fs-5">&#9679 Gray </h3>
                            <h3 class="text-white fs-5">&#9679 Excess-3 </h3>
                            <h3 class="text-white fs-5">Conversion </h3>
                            <br>
                            <br>
                            <div class="procedButton">
                            <!-- Change -->
                                <%=card3 %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="box">
                <div class="body">
                    <div class="imgContainer">
                        <hr>
                        <h1>Expression Evaluation</h1>
                        <hr>
                    </div>
                    <div class="content d-flex flex-column align-items-center justify-content-center">
                        <div>
                            <h3 class="text-white fs-5">&#9679 Infix </h3>
                            <h3 class="text-white fs-5">&#9679 Post-fix </h3>
                            <h3 class="text-white fs-5">&#9679 Prefix </h3>
                            <h3 class="text-white fs-5">Evaluation </h3>
                            <br>
                            <br>
                            <div class="procedButton">
                            <!-- Change -->
                                <%=card4 %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    
    <!-- footer elements -->
    <footer>
        <!-- logo in the place of # -->
        <a href="homepage"><img src="./img/LOGO_black_based.png" id="logo_footer" height="100px"></a>
        <p>Copyright &copy 2022 ConvoCheck India</p>
        <h1>
            <a href="#facebook"><i class="bi bi-facebook"></i></a>
            <a href="#instagram"><i class="bi bi-instagram"></i></a>
            <a href="#twitter"><i class="bi bi-twitter"></i></a>
            <a href="#linkedin"><i class="bi bi-linkedin"></i></a>
            <a href="#google"><i class="bi bi-google"></i></a>
            <a href="#github"><i class="bi bi-github"></i></a>
        </h1>
        <p>All rights are reserved</p>
        <p>Developed & Maintained by-</p>
        <a href="https://github.com/SumonaDutta23" target="_blank">@Sumona Dutta</a>
        <a href="https://github.com/souryasaha1234" target="_blank">@Sourya Saha</a>
        <a href="https://github.com/SouvikRay96" target="_blank">@Souvik Ray</a>
        <a href="https://github.com/Rajdeep-1508" target="_blank">@Rajdeep Maulik</a>
        <br>
    </footer>
    <script src="script.js"></script>
</body>
</html>