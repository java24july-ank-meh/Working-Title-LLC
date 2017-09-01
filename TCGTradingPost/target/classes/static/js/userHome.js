let accountInfoObj = [];


let routerApp = angular.module('routerApp', ['ui.router']);

routerApp.controller("Ctrllr", function($scope) {
	$scope.accountInfoScope = [];
	$scope.accountInfoLoader = function() {
		$scope.accountInfoScope = accountInfoObj;
		$scope.$apply();
	}
});

routerApp.config(function($stateProvider, $urlRouterProvider) {
  
  $urlRouterProvider.otherwise('/accountInfo');
  
  $stateProvider
  
	.state('accountInfo', {
		url: '/accountInfo',
		templateUrl: 'partial_UserHome_accountInfo.html'
	})
	
	.state('cart', {
		url: '/cart',
		templateUrl: 'partial_UserHome_cart.html'
	})
	
	.state('orderHistory', {
		url: '/orderHistory',
		templateUrl: 'partial_UserHome_orderHistory.html'
	});
  
  
});

let orderHistoryLoad = function() {
	console.log("orderHistoryLoad");
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("readystate: "+xhr.readyState+" status: "+xhr.status)
		if(xhr.readyState === 4 && xhr.status === 200) {
			
			console.log("orderHistory done!");
			
		}
	}
	xhr.open("GET", "/orderHistoryLoad", true);
	xhr.send();
}


let getUserData = function() {
	console.log("getUserData");
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("readystate: "+xhr.readyState+" status: "+xhr.status)
		if(xhr.readyState === 4 && xhr.status === 200) {
			
			accountInfoObj = JSON.parse(xhr.responseText);
			
		}
	}
	xhr.open("GET", "/accountInfoLoad", true);
	xhr.send();
}

window.onload = (function() {
	getUserData();
})();
