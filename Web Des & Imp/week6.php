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
		<h1> Deeper Into Scripting</h1>
		<ul>
			<li>Client-side Scripting: Javascript</li>
			<li>MVC: The Document Object Model</li>
			<li>Javascript: Review the Basics</li>
			<li>JavaScript: Enhancing Interactivity</li>
			<li><a href="http://people.rit.edu/smsshc/409/06/index.php" title="materials on prototype JavaScript library">JavaScript Libraries and AJAX</a></li>
		</ul>
		<h2>Helpful Readings </h2>
		<ul>
			<li>Webmaster in a Nutshell Chpt 12, 14</li>
			<li><a href="http://www.perl.com/pub/a/2000/10/begperl1.html">PERL Tutorial</a></li>
			<li><a href="http://www.perlquiz.co.uk/">Take the PERL Quiz</a></li>
			<li><a href="http://www.cpan.org/">Comprehensive Perl Archive Network</a></li>
			<li>Webmaster in a Nutshell, Chpt 13</li>
			<li><a href="http://httpd.apache.org/docs/1.3/howto/ssi.html">SSI Tutorial from Apache</a></li>
			<li><a href="http://www.apache.org/">Apache Software Foundation</a></li>
			<li><a href="http://www.w3.org/WAI/">The Web Accessibility Initiative</a></li>
			<li>Framework example: the <span class="stress">prototype</span> <a href="http://www.prototypejs.org/" title="read about it, download it">JavaScript and AJAX framework</a></li>
		</ul>

		<p>.</p>
		<h2><a href="http://people.rit.edu/hmm5837/409/gfinal/projects.php">Group Midterm</a> due Wednesday by 11:59pm</h2>
    </div>
    <div id="footer">
      <p>Copyright 2013</p>
    </div>
</div>
</body>
</html>