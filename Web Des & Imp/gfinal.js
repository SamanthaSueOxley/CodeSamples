$(document).ready(function(){
	// THE CODE FOR THE SHOW/HIDE FUNCTION FOR WEEKLY PAGES BY SAMANTHA 
	$("input.show").click(function(){
		$("#showmore").show("slow");
		$("input.show").prop('disabled', true);
		$("input.hide").prop('disabled', false);
	});
	$("input.hide").click(function(){
		$("#showmore").hide("slow");
		$("input.hide").prop('disabled', true);
		$("input.show").prop('disabled', false);
	});
	$("input.hide").prop('disabled', true);
	$("#showmore").hide();
	// CODE FOR THE SEARCH BAR BY HAYDEN
	if(window.location == 'http://people.rit.edu/hmm5837/409/gfinal/index.php' || window.location == 'http://people.rit.edu/hmm5837/409/gfinal/')
		{
			if(localStorage.link != null && localStorage.link != ''){
				loadChunk(localStorage.link);
				localStorage.link= '';
			}
		}
		else if(window.location == 'http://people.rit.edu/hmm5837/409/gfinal/projects.php'){
			if(localStorage.link != null && localStorage.link != ''){
				loadChunk(localStorage.link);
				localStorage.link= '';
			}
			
		}
			
		$("#searchButton").click(
		function()
		{
			var searchedCommand = $("#searchTerm").val();
			var commands = $("option").val();
			
			if (jQuery.inArray(searchedCommand, commands))
			{
				var cd = searchedCommand.localeCompare("course description");
				var cr = searchedCommand.localeCompare("class roster");
				var pf = searchedCommand.localeCompare("professor");
				var pj =  searchedCommand.localeCompare("projects");
				var oh = searchedCommand.localeCompare("office hours");
				var imwp = searchedCommand.localeCompare("Individual Midterm Web Project");
				var gms = searchedCommand.localeCompare("Group Midterm Site Design Document");
				var ifw = searchedCommand.localeCompare("Individual Final Web Project");
				var gfw = searchedCommand.localeCompare("Group Final Web Project");
				
				if(cd == 0){
				callPage("index.php", '');	
				}
				else if(cr == 0){
					callPage("index.php", 'secondChunk');
				}
				else if(pf == 0){
					callPage("index.php", 'fourthChunk');
				}
				else if(oh == 0){
					callPage("index.php", 'thirdChunk');
				}
				else if(pj == 0){
					callPage("projects.php", '');	
				}
				else if(imwp == 0){
					callPage("projects.php", 'firstChunk');	
				}

				else if(gms == 0){
					callPage("projects.php", 'secondChunk');	
				}

				else if(ifw == 0){
					callPage("projects.php", 'thirdChunk');	
				}

				else if(gfw == 0){
					callPage("projects.php", 'fourthChunk');	
				}
			}
		});
	function makeChunkVisible( whatId ) {
  
	  $.each( $('.chunky'), function(){
		  if( $(this).css('display') == 'block' )
		  {
			  $(this).fadeOut('slow').promise().done(function(){
				  $('#'+ whatId).fadeIn('slow'); 
				});;
		  }
		});
	}

	function hoverOn( which ) {
	  which.style.background = "#ffff00";
	}

	function hoverOff( which ) {
	  which.style.background = "#ffffff";
	}

	function callPage(page, chunk)
	{
	  window.location.href = page;
	  if(window.localStorage)
	  {
		localStorage.link = chunk;
	  }
	}

	function loadChunk( whatId )
	{
		$.each( $('.chunky'), function(){
		  if( $(this).css('display') == 'block' )
		  {
			  $(this).css('display', 'none').promise().done(function(){
				  $('#'+ whatId).css('display','block'); 
				});;
		  }
		});
	}
});
