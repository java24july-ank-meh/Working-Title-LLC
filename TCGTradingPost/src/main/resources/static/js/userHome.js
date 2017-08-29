let routerApp = angular.module('routerApp', ['ui.router']);

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