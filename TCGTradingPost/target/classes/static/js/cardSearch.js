let searchResultsArr = [];

let xhrResultsArr = [];

let searchApp = angular.module("searchApp", []);
searchApp.controller("searchCtrl", function($scope) {
	$scope.apiSearchResults = searchResultsArr;
	$scope.buyBtnFunc = function() {
		
	}
	$scope.searchResultsFunc = function(xhttpr) {
		console.log("searchResultsFunc");
		searchResultsArr = [];
		
		let jsonArr = JSON.parse(xhttpr.responseText);
		
		
		let cardLookup = function(cardID, game, stock, price) {
			let urlStr = "";
			
			if (game === "Magic the Gathering") {
				urlStr = "https://api.magicthegathering.io/v1/cards?multiverseid="+cardID;
			} else if (game === "Pokemon") {
				urlStr = "https://api.pokemontcg.io/v1/cards/"+cardID;
			} else if (game === "Star Wars: Destiny") {
			}
		
			let xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				console.log("readystate: "+xhr.readyState+" status: "+xhr.status)
				if(xhr.readyState === 4 && xhr.status === 200) {
					
					let arrayEntry = {};
					
					if (game === "Magic the Gathering") {
						let foundCard = JSON.parse(xhr.responseText).cards[0];
						console.log(foundCard);
						arrayEntry.cardName = foundCard.name;
						arrayEntry.setName = foundCard.setName;
						arrayEntry.imgUrl = foundCard.imageUrl;
					} else if (game === "Pokemon") {
						let foundCard = JSON.parse(xhr.responseText).card;
						console.log(foundCard);
						arrayEntry.cardName = foundCard.name;
						arrayEntry.setName = foundCard.set;
						arrayEntry.imgUrl = foundCard.imageUrlHiRes;
					} else if (game === "Star Wars: Destiny") {
					}
					
					arrayEntry.stock = stock;
					arrayEntry.price = price;
					
					searchResultsArr.push(arrayEntry);
					
					$scope.apiSearchResults = searchResultsArr;
					
					$scope.$apply();
					
				}
			}
			xhr.open("GET", urlStr, true);
			xhr.send();
		}
		
		
		for (let i=0; i<jsonArr.length; i++) {
			cardLookup(jsonArr[i].cardID, jsonArr[i].game, jsonArr[i].stock, jsonArr[i].price);
		}
		
		
		
	}
	$scope.onSubmitFunc = function() {
		
		console.log("onSubmit");
		
		let formCardName = document.getElementById("input_card_name").value;
		let formGameName = document.getElementById("input_game_name").value;
		let formSetName = document.getElementById("input_set_name").value;
		let formPriceMin = document.getElementById("input_price_range_min").value;
		let formPriceMax = document.getElementById("input_price_range_max").value;
		
		let formData = new FormData();
		formData.append("cardName", formCardName);
		formData.append("game", formGameName);
		formData.append("setName", formSetName);
		formData.append("PriceMin", formPriceMin);
		formData.append("PriceMax", formPriceMax);
		
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			console.log("readystate: "+xhr.readyState+" status: "+xhr.status)
			if(xhr.readyState === 4 && xhr.status === 200) {
				
				$scope.searchResultsFunc(xhr);
				
			}
		}
		xhr.open("POST", "/cardSearcher", true);
		xhr.send(formData);
		
		
		
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
