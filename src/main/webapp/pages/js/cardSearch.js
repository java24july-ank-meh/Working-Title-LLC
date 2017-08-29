let searchResultsArr = [];

let searchApp = angular.module("searchApp", []);
searchApp.controller("searchCtrl", function($scope) {
	$scope.records = searchResultsArr;
});

let onSubmitFunc = function() {
	if (document.getElementById("input_game_name").value === "Magic The Gathering") {
		let urlStr = "https://api.magicthegathering.io/v1/cards?";
		if (document.getElementById("input_card_name").value !== "") {
			
		}
		
	} else if (document.getElementById("input_game_name").value === "Pokemon") {
		
	} else if (document.getElementById("input_game_name").value === "Star Wars: Destiny") {
		
	}
}