// script.js

// create the module and name it scotchApp
// also include ngRoute for all our routing needs

var scotchApp = angular.module('scotchApp', ['ngRoute', 'ngResource']);

scotchApp.factory('MemoItems',function($resource){
    return $resource('/memoItems/:id');
});

scotchApp.controller('mainController',['$scope','MemoItems','$http', function($scope, MemoItems, $http) {
	var memoItemList = null;
	
	var conditionVO = $scope.conditionVO = {status: '1'}
	
	search();
	
	$scope.batchDel = function() {
		var delData = [];
		for (var i=0; i<memoItemList.length; i++){
			if(memoItemList[i].checked) {
				delData.push(memoItemList[i]);
			}
		}
		
		$http.post('/batch_memoItems/', delData).then(function(response){
			search();
		});
	}
	function search() {
		$http({
		    url: '/memoItems/search', 
		    method: "GET",
		    params: conditionVO
		 }).then(function(response){
			memoItemList = $scope.memoItemList = response.data;
		});
		
	}
	
	$scope.fmtStatus = function(status) {
		if(status == null || status == 0) {
			return '未开始';
		}else if(status == 1) {
			return '进行中';
		}else if(status == 2) {
			return '已完成';
		}else if(status == 3) {
			return '放弃';
		}else {
			return status;
		}
	}

	$scope.searchStatus = function(status) {
		conditionVO.status = status;
		search();
	}
}]);

scotchApp.controller('memoItemEditController',['$scope','$routeParams', '$http', '$location', function($scope,$routeParams, $http, $location){
	
	$http.get('/memoItems/' + $routeParams.id).then(function(response){
		$scope.memoItem=response.data;
		
		$scope.memoItem.planStartTime = $scope.memoItem.planStartTime ? new Date($scope.memoItem.planStartTime) : null;
		$scope.memoItem.planEndTime = $scope.memoItem.planEndTime ? new Date($scope.memoItem.planEndTime): null;
		$scope.memoItem.startTime = $scope.memoItem.startTime ? new Date($scope.memoItem.startTime) : null;
		$scope.memoItem.endTime = $scope.memoItem.endTime ? new Date($scope.memoItem.endTime) : null;
	});
	
	$scope.save = function() {
//		MemoItems.save($scope.memoItem);
		$http.post('/memoItems', $scope.memoItem).then(function(response){
			$location.path('#/');
		});
		
	}
	
	$scope.del = function() {
		$http.delete('/memoItems/' + $routeParams.id).then(function(response){
			$location.path('#/');
		});
	}
}]);

// configure our routes
scotchApp.config(function($routeProvider, $locationProvider) {
	$routeProvider.when('/', {
			templateUrl : 'memo/memoItemList.html',
			controller  : 'mainController'
		})
		.when('/memoItem/:id', {
			templateUrl : 'memo/memoItemEdit.html',
			controller  : 'memoItemEditController'
		})
		.when('/memoItem', {
			templateUrl : 'memo/memoItemEdit.html',
			controller  : 'memoItemEditController'
		})
	    .otherwise({
        	redirectTo: '/'
    	});
	// $locationProvider.html5Mode(true);
});
