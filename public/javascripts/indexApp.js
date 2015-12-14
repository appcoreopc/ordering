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
 };

 $scope.addToCart = function(productId, qty)
 {
   console.log(productId +  " " + qty);
   $http({
           url: '/cart/add',
           method: "POST",
           data : JSON.stringify({ id : 1,  productId : productId, qty : qty })
        }).then(function(response){
           console.log(response);
           if (response)
           {
           }
        }, function(errorResponse){

        });
 };

$scope.checkOutCart = function()
{
    console.log('test');

      $http({
                url: '/cart/checkout',
                method: "POST"
             }).then(function(response){
                console.log(response);
                if (response)
                {
                }
             }, function(errorResponse){

             });
};

}]);

