invoiceApp.controller('HeaderController', function ($scope, $location, $http) {
    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };

    var url = "http://localhost:8080/user";
    $http.get(url).success(function (response) {
        $scope.user = response;

    });
});




