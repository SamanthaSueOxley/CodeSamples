<!DOCTYPE HTML>
</head>
<title>Group 5 Final</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link href="../stylesheets/groupfinal.css" rel="stylesheet" type="text/css" />
	<script src="../javascript/gfinal.js"></script>
	<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
	<script src="../javascript/jquery.min.js"></script>
	<script src="../javascript/gfinal.js"></script>
	<script src="../javascript/modernizr.js"></script>
	<script type="text/javascript">
		 $(document).ready(function(){
			  
			  $("li:has(ul)").css('list-style-type', 'none');
			  
			  });
		 
	</script>
</head>
<body>
<div id="container">
	<div id="topnav">
		<div id="navcontainer">
		<!--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> !-->
		<script>window.jQuery || document.write('<script src="jquery-1.9.1.js"><\/script>')</script>
		<nav id="topNav">
			<ul>
				<li><a href="http://people.rit.edu/hmm5837/409/gfinal/index.php" title="Home">Home</a></li>
				<li><a href="#" title="Weekly Schedule">Weekly Schedule</a>
					<ul>
						<li><a href="week1.php">Week 1</a></li>
							<li><a href="week2.php">Week 2</a></li>
							<li><a href="week3.php">Week 3</a></li>
							<li><a href="week4.php">Week 4</a></li>
							<li><a href="week5.php">Week 5</a></li>
							<li><a href="week6.php">Week 6</a></li>
							<li><a href="week7.php">Week 7</a></li>
							<li><a href="week8.php">Week 8</a></li>
							<li><a href="week9.php">Week 9</a></li>
						<li class="last"><a href="week10.php" title="Week 10">Week 10</a></li>
					</ul></li>
				<li><a href="http://people.rit.edu/hmm5837/409/gfinal/projects.php" title="Projects">Projects</a>
				<li id="searchL" class="search">
					<form autocomplete="on">
						<label for="Search">Search: </label>
						<input type="text" id="searchTerm" list="searchlist">
						<datalist id="searchlist">
							<option value="course description">
							<option value="class roster">
							<option value="professor">
							<option value="projects">
							<option value="office hours">
							<option value="week 1">
							<option value="week 2">
							<option value="week 3">
							<option value="week 4">
							<option value="week 5">
							<option value="week 6">
							<option value="week 7">
							<option value="week 8">
							<option value="week 9">
							<option value="week 10">
							<option value="Individual Midterm Web Project">
							<option value="Group Midterm Site Design Document">
							<option value="Individual Final Web Project">
							<option value="Group Final Web Project">
						</datalist>
						<input id="searchButton" type="button" value="Go">
					</form>
				</li>
			</ul>
		</nav>
		<!--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> !-->
		<script>window.jQuery || document.write('<script src="jquery-1.9.1.js"><\/script>')</script>
		<script>
			(function($){
			//cache nav
			var nav = $("#topNav");
			//add indicators and hovers to submenu parents
			nav.find("li").each(function() {
			if ($(this).find("ul").length > 0) {
				$("<span>").text("^").appendTo(
				$(this).children(":first")
				);
			//show subnav on hover
			$(this).mouseenter(function() {
				$(this).find("ul").stop(true, true).slideDown();
				});
			//hide submenus on exit
			$(this).mouseleave(function() {
				$(this).find("ul").stop(true, true).slideUp();
				});
				}
				});
			})(jQuery);
		</script>
		</div>
	</div>
	<div id="header">
		<h1>409 Course Page </h1>
	</div>
	<div id="content">
		<div class="sidecontainer">
			<h1>Weekly Schedules</h1>
			<ul class="sidenav">
			  <li><a id="active" href="week1.php">Week 1</a></li>
			  <li><a href="week2.php">Week 2</a></li>
			  <li><a href="week3.php">Week 3</a></li>
			  <li><a href="week4.php">Week 4</a></li>
			  <li><a href="week5.php">Week 5</a></li>
			  <li><a href="week6.php">Week 6</a></li>
			  <li><a href="week7.php">Week 7</a></li>
			  <li><a href="week8.php">Week 8</a></li>
			  <li><a href="week9.php">Week 9</a></li>
			  <li><a href="week10.php">Week 10</a></li>
			</ul>	
		</div>		  
		<div id="weekly">	  
		<h1> Servers &amp; Forms</h1>
			<ul>
				<li>Forms</li>
				<li>Basic Forms and Validation</li>
				<li>Forms and PHP</li>
				<li>Forms Processing with CGI</li>
			</ul>
		<h2>Helpful Readings </h2>
			<ul>
				<li>Developing a <a href="people.rit.edu/smsshc/409/08/form.php" title="PHP and HTML forms walkthrough">comment form</a> with server-side file storage using PHP</li>
				<li>A simple <a href="people.rit.edu/smsshc/409/08/comment.php">email comment system</a> using forms and PHP</li>
				<li>N-tiered environments and <a href="08/db.php" title="visit database access example">database integration with PHP</a></li>
			</ul>

		<h2>Final Project Milestone due Monday!</h2>
		<p> Design document must be ready for in-class review</p>
			
		</div>
    </div>
    <div id="footer">
      <p>Copyright 2013</p>
    </div>
</div>
</body>
</html>