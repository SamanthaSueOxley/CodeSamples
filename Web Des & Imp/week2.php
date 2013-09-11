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
					<h1>Information Architecture & Visual Organization</h1>
		<li><a href="http://people.rit.edu/smsshc/409/02/introCSS.php" title="CSS review materials">Cascading Style Sheets (CSS)</a></li>
		<li><a href="http://people.rit.edu/smsshc/409/02/theglasswall_bbc_design.pdf" title="large BBC redesign document">(Large) Example Design Document</a></li></ul>
		<h2>Helpful Readings</h2>	
		<ul>
			<li><a href="http://www.webstyleguide.com/index.html?/sites/site_design.html">Yale Style Guide - Site Design</a></li>
			<li><a href="http://www.webmonkey.com/2010/02/information_architecture_tutorial/">Information Architecture Tutorial - Webmonkey</a></li>
			<li><a href="http://oreilly.com/catalog/navigation/chapter/ch05.html">Designing the User Experience - Jennifer Fleming</a></li>
			<li><a href="http://zing.ncsl.nist.gov/hfweb/proceedings/tiller-green/">Web Navigation - Tiller and Green</a></li>
			<li><a href="http://www.jjg.net/ia/visvocab/">A Visual Vocabulary - J.J.Garrett</a></li>
			<li><a href="http://www.useit.com/alertbox/20000514.html">Eye Tracking Study of Web Users - Jakob Nielsen</a></li>
		</ul>
		<p>.</p>
		<input type="submit" class="show" value="Show Me The Daily Assignment"/> | 
		<input type="submit" class="hide" value="Daily Assignment Completed"/>
		<div id="showmore">
			<ol>
				<li>Review: <a href="http://people.rit.edu/smsshc/409/02/infoArchBasics.php" title="slides on Info Architecture">materials on information architecture</a></li>
				<li>Discuss: Grouping Things Visually
					<ul>
						<li><strong>C</strong>ontrast</li>
						<li><strong>R</strong>epetition</li>
						<li><strong>A</strong>lignment</li>
						<li><strong>P</strong>roximity</li>
					</ul>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;and what's that spell?
				</li>
				<li>Lecture: <a href="http://people.rit.edu/smsshc/409/02/organization.php" title="lecture on organizing things">Organizing Things</a></li>
				<li>Task:
					<ul>
						<li>post group webpage listing membership</li>
						<li>post link to group webpage on your course webpage</li>
					</ul>
				</li>
				<li>Task: <a href="http://people.rit.edu/smsshc/409/02/assetInventory.pdf" title="materials for assets inventory">Asset Inventory Exercise</a>
					<ul>
						<li>create group exercise answer page for last section</li>
						<li>post link on your group webpage</li>
					</ul>
				</li>
				<li>Lecture: <a href="http://people.rit.edu/smsshc/409/02/introCSS.php" title="intro to CSS lecture materials">Intro to CSS</a></li>
				<li>Walk-through: <a href="http://people.rit.edu/smsshc/409/02/example_00.html" title="walk through adding style to webpage">Adding Style: A Step-By-Step Walk-Through and In-Class Exercise</a></li>
			</ol>
		</div>
    </div>
    <div id="footer">
      <p>Copyright 2013</p>
    </div>
</div>
</body>
</html>