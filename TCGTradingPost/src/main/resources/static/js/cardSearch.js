let searchResultsArr = [];

let xhrResultsArr = [];

let searchApp = angular.module("searchApp", []);
searchApp.controller("searchCtrl", function($scope) {
	$scope.apiSearchResults = searchResultsArr;
	$scope.buyBtnFunc = function() {
		
	}
	$scope.searchResultsFunc = function(xhrResponse) {
		console.log("searchResultsFunc");
		
		
	}
	$scope.onSubmitFunc = function() {
		
		console.log("onSubmit");
		
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			console.log("readystate: "+xhr.readyState+" status: "+xhr.status)
			if(xhr.readyState === 4 && xhr.status === 200) {
				
				$scope.searchResultsFunc(xhr.);
				
			}
		}
		xhr.open("POST", "/cardSearcher", true);
		xhr.send();
		
		
		
		/*
		console.log("onSubmit");
		let urlStr = "";
		
		if (document.getElementById("input_game_name").value === "Magic the Gathering") {
			urlStr = "https://api.magicthegathering.io/v1/cards?";
			if (document.getElementById("input_card_name").value !== "") {
				urlStr += "name="+document.getElementById("input_card_name").value+"&";
			}
			if (document.getElementById("input_set_name").value !== "") {
				urlStr += "setName="+document.getElementById("input_set_name").value+"&";
			}
			if (document.getElementById("input_price_range_min").value !== "" && document.getElementById("input_price_range_min").value !== null) {
				
			}
			if (document.getElementById("input_price_range_max").value !== "" && document.getElementById("input_price_range_max").value !== null) {
				
			}
			if (urlStr !== "https://api.magicthegathering.io/v1/cards?") {
				urlStr = urlStr.slice(0, -1);
			}
			
			
		} else if (document.getElementById("input_game_name").value === "Pokemon") {
			urlStr = "https://api.pokemontcg.io/v1/cards?";
			if (document.getElementById("input_card_name").value !== "") {
				urlStr += "name="+document.getElementById("input_card_name").value+"&";
			}
			if (document.getElementById("input_set_name").value !== "") {
				urlStr += "set="+document.getElementById("input_set_name").value+"&";
			}
			if (document.getElementById("input_price_range_min").value !== "" && document.getElementById("input_price_range_min").value !== null) {
				
			}
			if (document.getElementById("input_price_range_max").value !== "" && document.getElementById("input_price_range_max").value !== null) {
				
			}
			if (urlStr !== "https://api.pokemontcg.io/v1/cards?") {
				urlStr = urlStr.slice(0, -1);
			}
			
		} else if (document.getElementById("input_game_name").value === "Star Wars: Destiny") {
			
		}
		
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			console.log("readystate: "+xhr.readyState+" status: "+xhr.status)
			if(xhr.readyState === 4 && xhr.status === 200) {
				
				searchResultsArr = JSON.parse(xhr.responseText).cards;
				
				console.log(searchResultsArr);
				
				$scope.apiSearchResults = searchResultsArr;
				
				$scope.$apply();
				
			}
		}
		xhr.open("GET", urlStr, true);
		xhr.send();
		*/
	}
});
