<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConvoCheck | About</title>
    <!-- CSS only -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link rel="icon" type="image/jpg" href="img/head_logo (2).png">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <!-- header -->
    <header>
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
            	<%
            	//Controlling the Back Button after Log_out
        		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        		response.setHeader("Pragma", "no-cache");//Http 1.0
        		response.setHeader("Expires", "0");
        		
                		String log = "";
            			String facility = "";
                		if(session.getAttribute("username") != null){
                			log = "<a href='logout' style='color: white; background-color: red; border-radius: 30px;'><i class='bi bi-person-fill'></i><b>Log-Out</b></a>";
                			facility = "<a href='equationConversion'>Equation Conversion</a>"
                                    +"<a href='baseConversion'>Base Conversion</a>"
                                    +"<a href='codeConversion'>Code Conversion</a>"
                                    +"<a href='evaluation'>Expression Evaluation</a>";
                		}
                		else{
                			log = "<a href='loginpage'><i class='bi bi-person-fill'></i><b>Log-In</b></a>";
                			facility = "<a href='loginpage'>Equation Conversion</a>"
                                    +"<a href='loginpage'>Base Conversion</a>"
                                    +"<a href='loginpage'>Code Conversion</a>"
                                    +"<a href='loginpage'>Expression Evaluation</a>";
                		}
                	%>
                <%=log %>
            </li>
            <li>
                <div class="dropdown">
                    <button class="dropbtn"><b>Facilities</b> <i id="drop_icon" class="bi bi-caret-down-fill"></i></button>
                    <div class="dropdown-content">
                    <%=facility %> 
                    </div>
                </div>
            </li>
            <li>
                <a href="about" id="this_nav"><i class="bi bi-file-earmark-fill"></i> <b>About</b></a>
            </li>
            <li>
                <a href="homepage"><i class="bi bi-house-fill"></i> <b>Home</b></a>
            </li>
            
        </ul>
    </nav>
    
    <!-- main elements -->
    <div id="aboutUs">
        <div class="pointer"></div>
        <div class="about_inside " style="margin-right: 500px;">
            <h1>The Facilities</h1>
            <p>Our website focuses on different types of conversions which are: -</p>
            <ol>
                <li>Infix-Postfix-Prefix conversion: Using this you can change “Infix to Postfix”, ”Infix to Prefix”, “Postfix to Infix”, or “Prefix to Infix”.</li>
                <li>Base Conversion: Using this you can change any number of a base x to its equivalent number in base y.</li>
                <li>Code Conversion: Using this you can change “Binary to GRAY”, “GRAY to Binary”, “Decimal to BCD conversion”, “BCD to Binary Conversion”, “Binary to Excess-3 code conversion”, “Excess-3 to Binary”, “GRAY to Excess-3”, “Excess-3 to GRAY”.</li>
            </ol>
            <p>Equation Evaluation: Using this you can evaluate Postfix and Prefix equations.</p>
        </div>
        <div class="about_inside" style="margin-left: 500px;">
            <h1>Our Goal</h1>
            <p>As Engineering students, we know how important these conversions can be for us. This website can be helpful for these conversions.</p>
            <br>
            <p>In the future, we will try to solve more problems like these which could be helpful for us if we got this before.</p>
        </div>
        <div class="about_inside" style="margin-right: 500px;">
            <h1>Social media</h1>
            <p>Connect with us: </p>
            <h2>
                <a href="#facebook"><i class="bi bi-facebook"></i></a>
                <a href="#instagram"><i class="bi bi-instagram"></i></a>
                <a href="#twitter"><i class="bi bi-twitter"></i></a>
                <a href="#linkedin"><i class="bi bi-linkedin"></i></a>
                <a href="#google"><i class="bi bi-google"></i></a>
                <a href="#github"><i class="bi bi-github"></i></a>
            </h2>
        </div>
    </div>
    <div class="card-body">
        <h2>Write to us</h2>
        <form>
          <div><input type="text" placeholder="Your Name" required="required" /></div>
          <div><input type="email" placeholder="Email" required="required" /></div>
          <div><textarea rows="8" placeholder="Enter your descriptions here..." required="required"></textarea></div>
          <input type="Submit" value="Send now">
        </form>
    </div>

    <!-- footer elements -->
    <footer>
        <!-- logo in the place of # -->
        <a href="homepage"><img src="./img/LOGO_black_based.png" id="logo_footer" height="100px"></a>
        <h1>
            <a href="#facebook"><i class="bi bi-facebook"></i></a>
            <a href="#instagram"><i class="bi bi-instagram"></i></a>
            <a href="#twitter"><i class="bi bi-twitter"></i></a>
            <a href="#linkedin"><i class="bi bi-linkedin"></i></a>
            <a href="#google"><i class="bi bi-google"></i></a>
            <a href="#github"><i class="bi bi-github"></i></a>
        </h1>
        <p>Copyright &copy 2022 ConvoCheck India</p>
        <p>All rights are reserved</p>
        <p>Developed & Maintained by-</p>
        <a href="https://github.com/SumonaDutta23" target="_blank">@Sumona Dutta</a>
        <a href="https://github.com/souryasaha1234" target="_blank">@Sourya Saha</a>
        <a href="https://github.com/SouvikRay96" target="_blank">@Souvik Ray</a>
        <a href="https://github.com/Rajdeep-1508" target="_blank">@Rajdeep Maulik</a>
        <br>
    </footer>
</body>
</html>