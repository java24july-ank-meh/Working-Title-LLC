let searchResultsArr = [];

let searchApp = angular.module("searchApp", []);
searchApp.controller("searchCtrl", function($scope)) {
	$scope.searchResults = searchResultsArr;
});

let onSubmitFunc = function() {
	if (document.getElementById("input_game_name").value === "Magic The Gathering") {
		let urlStr = "https://api.magicthegathering.io/v1/cards?";
		if (document.getElementById("input_card_name").value !== "") {
			
		}
		if (document.getElementById("input_set_name").value !== "") {
				
		}
		if (document.getElementById("input_price_range_min").value !== "" && document.getElementById("input_price_range_min").value !== null) {
			
		}
		if (document.getElementById("input_price_range_max").value !== "" && document.getElementById("input_price_range_max").value !== null) {
			
		}
		
	} else if (document.getElementById("input_game_name").value === "Pokemon") {
		
	} else if (document.getElementById("input_game_name").value === "Star Wars: Destiny") {
		
	}
}