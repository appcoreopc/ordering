var catalogApp = angular.module('catalogApp',[]).controller('catalogController', ['$scope', '$http', function($scope, $http) {

 $scope.catalog = null;
 var catalogUrl = '/catalog';

 $scope.init = function()
 {
    $http({
        url: catalogUrl,
        method: "GET"
     }).then(function(response){

        if (response)
        {
            $scope.catalog = response.data[0];
            console.log($scope.catalog);
        }
     }, function(errorResponse){

     });
 }
}]);

