<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>ConvoCheck | Code Conversion</title>
        <!-- CSS only -->
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css"
        />
        <link rel="icon" type="image/jpg" href="img/head_logo (2).png" />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <!-- header -->
        <%
			//Controlling the Back Button after Log_out
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
			response.setHeader("Pragma", "no-cache");//Http 1.0
			response.setHeader("Expires", "0");
		
		%>
        <header>
            <a href="homepage"
                ><img
                    src="./img/Convo_Check_header_animation.gif"
                    alt="ConvoCheck"
                    height="150px"
            /></a>
            <h2>-:A all purpose convertor for you:-</h2>
        </header>

        <!-- Navigation Bar -->
        <nav>
            <ul id="logo">
                <li>
                    <a href="homepage"
                        ><img
                            src="./img/LOGO_black_based.png"
                            id="logo_navigation"
                            height="40px"
                    /></a>
                </li>
            </ul>

            <ul id="navigations">
                <li>
                	<%
                		String log = "";
                		if(session.getAttribute("username") != null)
                			log = "<a href='logout' style='color: white; background-color: red; border-radius: 30px;'><i class='bi bi-person-fill'></i> <b>Log-Out</b></a>";
                		else{
                			log = "<a href='loginpage'><i class='bi bi-person-fill'></i> <b>Log-In</b></a>";
                			response.sendRedirect("homepage");
                		}
                	%>
                    <%=log %>
                </li>
                <li>
                    <div class="dropdown">
                        <button class="dropbtn">
                            <b>Facilities</b>
                            <i id="drop_icon" class="bi bi-caret-down-fill"></i>
                        </button>
                        <div class="dropdown-content">
                            <a href="equationConversion"
                                >Equation Conversion</a
                            >
                            <a href="baseConversion">Base Conversion</a>
                            <a href="codeConversion" id="this_nav"
                                >Code Conversion</a
                            >
                            <a href="evaluation"
                                >Expression Evaluation</a
                            >
                        </div>
                    </div>
                </li>
                <li>
                    <a href="about"
                        ><i class="bi bi-file-earmark-fill"></i> <b>About</b></a
                    >
                </li>
                <li>
                    <a href="homepage"
                        ><i class="bi bi-house-fill"></i> <b>Home</b></a
                    >
                </li>
            </ul>
        </nav>

        <!-- main elements -->

        <div class="the_form">
            <form action="CodeConversionServlet" method="post">
                <label for="from_base">Choose the conversion:</label>
                <select id="from_base" class="form-control" name="conversion" value="${conversion }">
                    <option value="binaryToGray">Binary To Gray</option>
                    <option value="GrayTobinary">Gray To Binary</option>
                    <option value="decimalToBCD">Decimal To BCD</option>
                    <option value="BCDTobinary">BCD To Binary</option>
                    <option value="binaryToExcess3">Binary To Excess-3</option>
                    <option value="Excess3Tobinary">Excess-3 To Binary</option>
                    <option value="grayToExcess3">Gray To Excess-3</option>
                    <option value="Excess3Togray">Excess-3 To Gray</option>
                </select>

                <label for="num">Enter valid Input: </label>
                <input
                    type="text"
                    id="num"
                    name="input_number"
                    value="${number }"
                    placeholder="eg@123"
                    required
                />

                <label for="output">Output:</label>
                <!-- here the out put will be displayed output -->
                <input type="text" class="output-box" value="${output }" readonly />
                <input type="submit" value="Submit" />
            </form>
        </div>

        <!-- footer elements -->
        <footer>
            <!-- logo in the place of # -->
            <a href="homepage"
                ><img
                    src="./img/LOGO_black_based.png"
                    id="logo_footer"
                    height="100px"
            /></a>
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
            <a href="https://github.com/SumonaDutta23" target="_blank"
                >@Sumona Dutta</a
            >
            <a href="https://github.com/souryasaha1234" target="_blank"
                >@Sourya Saha</a
            >
            <a href="https://github.com/SouvikRay96" target="_blank"
                >@Souvik Ray</a
            >
            <a href="https://github.com/Rajdeep-1508" target="_blank"
                >@Rajdeep Maulik</a
            >
            <br />
        </footer>
    </body>
</html>
