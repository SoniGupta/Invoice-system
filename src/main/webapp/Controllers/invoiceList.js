invoiceApp.controller('InvoiceListController', function ($scope, $http, $location) {

    var url = 'http://localhost:8080/invoices';
    $http.get(url).success(function (response) {
        $scope.allinvoices = response;
    });
    $scope.editclicked = function (i) {
        $location.path('/EditInvoice/' + i.invoiceId);
    };


    $scope.selectedphone = "";

    $scope.phoneFilter=function(i){
        if($scope.selectedphone == "")
        {
            return true;
        }


        if (i.customerEntity.phone === $scope.selectedphone) {
            return true;
        }
        else
        {
            return false;
        }
    };



$scope.deleteinvoice = function (i) {
    $http({
        url: "http://localhost:8080/deleteinvoice",
        method: 'GET',
        params: {invoiceId: i.invoiceId}
    }).then(function (success) {

            alert('successfully deleted');
        },
        function (error) {
            var url = 'http://localhost:8080/invoices';
            $http.get(url).success(function (response) {
                $scope.allinvoices = response;
            });

        });
};
});

