<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConvoCheck | Base Conversion</title>
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
		
       		String log = "";
       		if(session.getAttribute("username") != null)
       			log = "<a href='logout'><i class='bi bi-person-fill'></i> <b>Log-Out</b></a>";
       		else{
       			log = "<a href='loginpage'><i class='bi bi-person-fill'></i> <b>Log-In</b></a>";
       			response.sendRedirect("homepage");
       		}
	%>
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
            	
                    <%=log %>
            </li>
            <li>
                <div class="dropdown">
                    <button class="dropbtn"><b>Facilities</b> <i id="drop_icon" class="bi bi-caret-down-fill"></i></button>
                    <div class="dropdown-content">
                      <a href="equationConversion">Equation Conversion</a>
                      <a href="baseConversion" id="this_nav">Base Conversion</a>
                      <a href="codeConversion">Code Conversion</a>
                      <a href="evaluation">Expression Evaluation</a>
                    </div>
                </div>
            </li>
            <li>
                <a href="about"><i class="bi bi-file-earmark-fill"></i> <b>About</b></a>
            </li>
            <li>
                <a href="homepage"><i class="bi bi-house-fill"></i> <b>Home</b></a>
            </li>
            
        </ul>
    </nav>
    
    <!-- main elements -->
    
    <!-- <h1>body</h1> -->
    <div class="the_form">
        <form action="BaseConversionServlet" method="post">
            <label for="num">Enter Number: </label>
            <input type="text" id="num" name="input_number" placeholder="eg@abc123" value="${num }" required>
            
            <label for="from_base">From base:</label>
            <select id="from_base" class="form-control" name="fromBase" value="${fromBase }">
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">31</option>
                <option value="32">32</option>
                <option value="33">33</option>
                <option value="34">34</option>
                <option value="35">35</option>
                <option value="36">36</option>
            </select>
            
            <label for="to_base">To base:</label>
            <select id="to_base" class="form-control" name="toBase" value="${toBase }">
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">31</option>
                <option value="32">32</option>
                <option value="33">33</option>
                <option value="34">34</option>
                <option value="35">35</option>
                <option value="36">36</option>
            </select>
        
            <label for="output">Output:</label>
            <!-- here the out put will be displayed output -->
            <input type="text" class="output-box" value="${output }" readonly>
            <input type="submit" value="Submit">
      
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