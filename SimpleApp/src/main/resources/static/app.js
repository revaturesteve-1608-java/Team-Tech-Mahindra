/**
 * 
 */

var app = angular.module('mainApp', []);

app.controller("submitCtrl", function($scope, dataService){
	$scope.submit = function(firstName, lastName){
		var nameInfo = [firstName, lastName];
		dataService.submit(nameInfo)
	}
})

app.service("dataService", function($http){
	this.submit = function(nameInfo, callback){
		$http.post("/", nameInfo).then(callback)
	}
})
