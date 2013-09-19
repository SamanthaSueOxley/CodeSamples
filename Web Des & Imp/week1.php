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
			<h1>Introduction & Project Overview</h1>
			<h2>Tasks of the day:</h2>
			<ul><li>Groups for Midterm & Final project assigned.</li>
				<li>Indivual Course Web Page due Wednesday of Week 1 at 11:59PM.</li></ul>
			<h2>Helpful Readings</h2>	
			<ul><li><a href="www.webstandards.org">WebStandards.org</a></li>
				<li>Usability article:<a href="http://www.useit.com/alertbox/20010204.html">Are Users Stupid?</a> by Jakob Nielsen</li>
				<li>Interaction Design article: <a href="http://www.useit.com/alertbox/progressive-disclosure.html">Progressive Disclosure</a> by Jakob Nielsen</li>
			</ul>
			<p>.</p>
			<input type="submit" class="show" value="Show Me The Daily Assignment"/> | 
			<input type="submit" class="hide" value="Daily Assignment Completed"/>
			<div id="showmore">
				<p>You <em>absolutely need</em> to make sure you are "up to speed" on
					<a href="http://en.wikipedia.org/wiki/HTML" title="visit wiikipedia article on HTML">HTML</a>
					before you go any further in this class. This is a <em>concentration-level</em> class, so we expect
					you to build on your prior knowledge and to get <em>good</em> at this stuff.</p>
				<p>
					You cannot make any sense of <a href="http://en.wikipedia.org/wiki/Cascading_Style_Sheets"
					title="visit wikipedia article on CSS">CSS</a> (Cascading Style Sheets) if you do not understand HTML,
					so start out the Quarter right and review these materials right away please. These are selected
					lecture notes and study guides from the current version of one of the prerequisite classes for
					this class, <a href="http://www.ist.rit.edu/~jxs/classes/archive/2010_Fall/320/#weekly" title="visit Prof. Sonstein's site for 320">320</a> (also known as "Introduction to Multimedia").</p>
				<p>
					In <a href="http://www.ist.rit.edu/~jxs/classes/archive/2010_Fall/320/#weekly" title="visit Prof. Sonstein's site for 320">320</a> you learned things like basic filesystems and permissions, the use of
					both command-line and GUI editors, common UNIX commands, and a wealth of other
					topics. <strong>We assume you already know these things because we assume that you
					took the prerequisite courses leading up to 409.</strong>
				</p>
				<a href="http://www.ist.rit.edu/~jxs/classes/archive/2010_Fall/320/week_02/BasicHTML.html" title="basic HTML review">Materials on basic HTML: background, structure, and tools</a>
				<h1> Excercise: </h1>
				<p>
					You will begin to construct <a href="http://people.rit.edu/smsshc/409/01/coursepage.php" title="access assignment details page">your
					course webpage</a> today. You should already know how to build something this simple. I want to see
					you building it in front of me in class over the Quarter, so I can come to some realistic assessment
					of who has strong or weak HTML skills.</p>
				<p>Keep this webpage simple to start with. Remember the <a href="http://en.wikipedia.org/wiki/KISS_principle" title="visit wikipedia article on the KISS principle">KISS principle</a>.</p>
		</div>
    </div>
    <div id="footer">
      <p>Copyright 2013</p>
    </div>
</div>
</body>
</html>