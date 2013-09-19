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
			<h1>Interaction Design</h1>
			<ul>
				<li>Navigation</li>
				<li>Storyboards and Flowcharts</li>
				<li>Usability</li>
				<li>Intro to <a href="http://people.rit.edu/smsshc/409/03/javascript.php">Javascript </a></li>
			<h2>Helpful Readings</h2>
				<li><a href="http://www.build-a-website.net/making-a-website-outline/">Making a Website Online</a></li>
				<li><a href="http://www.bene.be/blog/comments/a_webdesign_brief_document_for_every_website/">A Web Design Brief Ddocument for Every Website</a></li>
			<p>.</p>
			<input type="submit" class="show" value="Show Me The Daily Assignment"/> | 
			<input type="submit" class="hide" value="Daily Assignment Completed"/>
			<div id="showmore">
				<h2> Day 1 </h2>
				<ol>
					<li>Review:
						<ul>
							<li><a href="http://people.rit.edu/smsshc/409/03/positioningTest.html" title="visit CSS positioning example">Demo of absolute and relative positioning using CSS</a></li>
							<li><a href="http://people.rit.edu/smsshc/409/03/interaction.php" title="visit materials on interaction design">Materials on Interaction</a></li>
						</ul>
					</li>
					<li>Discuss: <a href="http://www.spingroup.com/htmdocs/resources/" title="Usable Design articles">links to sites about effective and usable design</a></li>
					<li>Supporting Materials: <a href="http://people.rit.edu/smsshc/409/03/storyboard.pdf" title="storyboarding template PDF">storyboard template</a></li>
					<li>Group Task: group project website lab time</li>
				</ol>

				<h2> Day 2 </h2>
				<ol>
					<li>Discuss: expectations for Group Midterm Project (min/max length, depth in various parts, etc)</li>
					<li>Review: <a href="http://people.rit.edu/smsshc/409/03/javascript.php" title="access intro materials about Javascript">Introductory materials on Javascript</a></li>
					<li>Demo: converting <a href="http://www.it.rit.edu/~jxs/services/htmlize.html" title="Characters to Entities service">Characters to Character Entities</a></li>
					<li>Demo: <a href="http://people.rit.edu/smsshc/409/03/iframes/iframeDemo.html" title="access intro to iframes materials">iFrames</a></li>
					<li>Demo: <a href="http://people.rit.edu/smsshc/409/03/javascriptEmail.php" title="access ECMAScript email materials">ECMAScript email anchor replacement</a></li>
					<li>Class Exercises:
						<ol>
							<li>class website tutorials:
								<ul>
									<li>Questions: how do we make Javascript tutorials materials blend in with the rest of the site better? can we describe a look and feel for tutorials here, in general? (hint: compare the <em>iFrames</em> and the <em>ECMAScript email</em> pages)</li>
									<li>Class Activity: begin to build a mockup in class together, using HTML and CSS and Javascript</li>
								</ul>
							</li>
							<li>group cookbook project:
								<ul>
									<li>Questions: what sort of informational chunks best fit our data to the cognitive map(s) a modern audience has of cookbooks?</li>
									<li>Class Activity: separate two or three recipies from the whole and try out various markup schemes to add structural information.</li>
									<li>Groups Activity: examine your work so far in determining your audience and your goals and objectives for your Group Design Project. begin to decide on a standard markup scheme to add the structure your group needs to the data. talk to the instructor about your initial ideas for a data organization scheme, and post about that to your group website.</li>
								</ul>
							</li>
						</ol>
					</li>
				</ol>

			</div> 
		</div>
    </div>
    <div id="footer">
      <p>Copyright 2013</p>
    </div>
</div>
</body>
</html>