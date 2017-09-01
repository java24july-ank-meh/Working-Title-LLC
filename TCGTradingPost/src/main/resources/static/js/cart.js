let cartObj = [];

let cartApp = angular.module("cartApp", []);
cartApp.controller("cartControl", function($scope) {
	$scope.cart = [];
	$scope.cartLoader = function() {
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			console.log("readystate: "+xhr.readyState+" status: "+xhr.status)
			if(xhr.readyState === 4 && xhr.status === 200) {
				
				cartObj = JSON.parse(xhr.responseText);
				$scope.cart = cartObj;
				$scope.$apply();
				
			}
		}
		xhr.open("GET", "/getCart", true);
		xhr.send();
	}
	$scope.checkoutFunc = function(address) {
		
		let formData = new FormData();
		formData.append("address", document.getElementById("shippingAddressInput").value);
		
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			console.log("readystate: "+xhr.readyState+" status: "+xhr.status)
			if(xhr.readyState === 4 && xhr.status === 200) {
				
				
				
			}
		}
		xhr.open("POST", "/checkout", true);
		xhr.send(formData);
		
	}
});