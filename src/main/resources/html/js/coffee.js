var coffeeApp = angular.module('coffeeApp', []);

 coffeeApp.controller('OrderController', function($scope) {
 	$scope.types = [
 		{name: 'Americano', family: 'Coffee'},
 		{name: 'Latte', family: 'Coffee'},
 		{name: 'Tea', family: 'Other'},
 		{name: 'Cappuccino', family: 'Coffee'}
 	];
 	$scope.sizes['Small', 'Medium', 'Large'];
 });