<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConvoCheck | Login</title>
    <!-- CSS only -->
    <!-- CSS only -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link rel="icon" type="image/jpg" href="img/head_logo (2).png">
    <link rel="stylesheet" href="style.css">
    <style>
    	.loginclass{
    		  position: absolute;
			  height: 100%;
			  width: 50%;
			  left: 0;
			  z-index: 0;
			  border-radius: 15px;
			  background: -webkit-linear-gradient(left, #003366, #004080, #0059b3, #0073e6);
    	}
    	#login{
    		  height: 100%;
			  width: 100%;
			  color: #fff;
			  font-size: 18px;
			  font-weight: 500;
			  text-align: center;
			  line-height: 48px;
			  cursor: pointer;
			  z-index: 1;
			  background: transparent;
			  border-radius: 15px;
    	}
    	.signupclass{
    		  position: relative;
			  height: 100%;
			  width: 50%;
			  border-radius: 15px;
			  /*background: -webkit-linear-gradient(left, #003366, #004080, #0059b3, #0073e6);*/
    	}
    	#signup{
    		  height: 100%;
			  width: 100%;
			  color: black;
			  font-size: 18px;
			  font-weight: 500;
			  text-align: center;
			  line-height: 48px;
			  cursor: pointer;
			  margin-left: 160px;
			  background: transparent;
			  border-radius: 15px;
    	}
    	#togglePassword{
    		position: absolute;
    		margin-top: 10px;
    		margin-left: -35px;
    		cursor: pointer;
    	}
    </style>
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
                			log = "Log-Out";
                			facility = "<a href='equationConversion'>Equation Conversion</a>"
                                    +"<a href='baseConversion'>Base Conversion</a>"
                                    +"<a href='codeConversion'>Code Conversion</a>"
                                    +"<a href='evaluation'>Expression Evaluation</a>";
                		}
                		else{
                			log = "Log-In";
                			facility = "<a href='loginpage'>Equation Conversion</a>"
                                    +"<a href='loginpage'>Base Conversion</a>"
                                    +"<a href='loginpage'>Code Conversion</a>"
                                    +"<a href='loginpage'>Expression Evaluation</a>";
                		}
                	%>
                <a href="loginpage" id="this_nav"><i class="bi bi-person-fill"></i> <b><%=log %></b></a>
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
                <a href="about"><i class="bi bi-file-earmark-fill"></i> <b>About</b></a>
            </li>
            <li>
                <a href="homepage"><i class="bi bi-house-fill"></i> <b>Home</b></a>
            </li>
            
        </ul>
    </nav>
    
<!-- main elements -->
<div class="wrapper">
    <div class="title-text">
      <div class="title login">Login Here</div>
      
    </div>
    <div class="form-container">
      <div class="slide-controls">
        <a href="loginpage" class="loginclass"><button type="button" name="slide" id="login">Login</button></a>
        <a href="signuppage" class="signupclass"><button type="button" name="slide" id="signup">Signup</button></a>
      </div>
      <div class="form-inner">
        <form action="login" class="login" method="post">
        	<div class="field" style="margin: 0px; margin-bottom: -25px">
        		<p style = "height: fit-content; text-align: center; color: red">${message }</p> 
        	</div>
        	<!-- 
        	 <div>${messageSign }</div>
        	 -->
        	<div class="field">
            	<input type="text" placeholder="User-name" name="username" required>
          	</div>
          <div class="field">
            <input type="email" placeholder="Email Address" name="email" required>
          </div>
          <div class="field">
          <div class="field">
	          <p style = "height: inherit;">
	            <input type="password" placeholder="Password" name="password" id="password" required>
                <i class="bi bi-eye-slash" id="togglePassword"></i>
	          </p>
          </div>
          </div>
          <div class="pass-link"><a href="#">Forgot password?</a></div>
          <div class="field btn">
            <div class="btn-layer"></div>
            <input type="submit" value="Login">
          </div>
          <div class="signup-link">Not a member? <a href="signuppage">Signup now</a></div>
        </form>
      </div>
    </div>
</div>
<script>
      const togglePassword = document.querySelector('#togglePassword');
      const password = document.querySelector('#password');
      togglePassword.addEventListener('click', function (e) {
    	    // toggle the type attribute
    	    const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
    	    password.setAttribute('type', type);
    	    // toggle the eye / eye slash icon
    	    this.classList.toggle('bi-eye');
    	});
</script>

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