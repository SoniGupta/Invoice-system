invoiceApp.controller('InvoiceEditController', function ($scope, $http, $location, $routeParams) {
    $scope.invId = $routeParams.routeInvId;

    $scope.invoiceEntity = {
        invoiceId:0,
        invoiceNo: '',
        invoiceDate: '',
        customerEntity: {
            phone: " ",
            name: " ",
            address: " ",
            email: " "
        },
        itemsEntities: []


    };



    $http({
        url: "/invoicedetails",
        method: "GET",
        params: {invoice_id: $scope.invId}
    }).then(
        function (success) {
            console.log(success);
            $scope.invoiceEntity.invoiceId = success.data.invoiceId;
            $scope.invoiceEntity.invoiceNo = success.data.invoiceNo;
            $scope.invoiceEntity.invoiceDate=success.data.invoiceDate;
            $scope.invoiceEntity.customerEntity.phone=success.data.customerEntity.phone;
            $scope.invoiceEntity.customerEntity.name=success.data.customerEntity.name;
            $scope.invoiceEntity.customerEntity.address=success.data.customerEntity.address;
            $scope.invoiceEntity.customerEntity.email=success.data.customerEntity.email;


            angular.forEach(success.data.itemsEntities, function(item) {
                $scope.invoiceEntity.itemsEntities.push(item);
            });
        },
        function (error) {
            alert('not success');
        });

    $scope.printMode   = true;
    $scope.availableCurrencies = [
        {
            name: 'Canadian Dollar ($)',
            symbol: 'CAD $ '
        },
        {
            name: 'Euro (€)',
            symbol: '€'
        },
        {
            name: 'Indian Rupee (₹)',
            symbol: '₹'
        },
        {
            name: 'Norwegian krone (kr)',
            symbol: 'kr '
        },
        {
            name: 'US Dollar ($)',
            symbol: '$'
        }
    ];
    $scope.currencySymbol = "$";


    //$scope.invoice = {
    //    invoiceNo: '',
    //    invoiceDate: '',
    //    customerPhone: '',
    //    customerName: '',
    //    customerAddress: '',
    //    customerEmail: '',
    //    items: [
    //        {
    //            "itemDetail": "",
    //            "quantity": 0,
    //            "unitPrice": 0
    //        }
    //    ],
    //    tax: 14
    //};
//    $scope.save = function () {
//
//        $http({
//            url: "http://localhost:8080/addinvoice",
//            method: "POST",
//            data: $scope.invoice,
//            headers: {'Content-Type': 'application/json'}
//        }).then(
//            function (success) {
//                alert('successfully saved');
//                $scope.invoice = {
//                    invoiceNo: '',
//                    invoiceDate: '',
//                    customerPhone: '',
//                    customerName: '',
//                    customerAddress: '',
//                    customerEmail: '',
//                    items: [
//                        {
//                            "itemDetail": "",
//                            "quantity": 0,
//                            "unitPrice": 0
//                        }
//                    ]
//                }
//            },
//            function (error) {
//                alert('not success');
//            });
//    };
//

    $scope.invoiceSubTotal = function () {
        var total = 0.00;
        angular.forEach($scope.invoiceEntity.itemsEntities, function (item) {
            total += (item.quantity * item.unitPrice);
        });
        return total;
    };
//
    $scope.tax = 14;
    $scope.calculateTax = function () {
        return (($scope.tax * $scope.invoiceSubTotal()) / 100);
    };

// Calculates the grand total of the invoice
    $scope.calculateGrandTotal = function () {

        return $scope.calculateTax() + $scope.invoiceSubTotal();
    };



});