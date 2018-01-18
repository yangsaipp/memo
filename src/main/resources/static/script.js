// script.js

// create the module and name it scotchApp
// also include ngRoute for all our routing needs

var scotchApp = angular.module('scotchApp', ['ngRoute', 'ngResource']);

scotchApp.factory('MemoItems',function($resource){
    return $resource('/memoItems');
});

scotchApp.controller('mainController',['$scope','MemoItems', function($scope, MemoItems) {
	$scope.memoItemList = MemoItems.query();
}]);
// configure our routes
scotchApp.config(function($routeProvider, $locationProvider) {
	$routeProvider.when('/', {
			templateUrl : 'memo/memoItemList.html',
			controller  : 'mainController'
		})
	    .otherwise({
        	redirectTo: '/'
    	});
	// $locationProvider.html5Mode(true);
});
