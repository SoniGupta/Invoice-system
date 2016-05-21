invoiceApp.controller('InvoiceController', function ($scope, $http, $location) {

    $scope.clear = function() {
        var url = '/lastinvoice';
        $http.get(url).success(function (response) {
            $scope.invoiceNumber = response.invoiceNo + 1;
            $scope.invoice = {
                invoiceNo: $scope.invoiceNumber,
                invoiceDate: '',
                customerPhone: '',
                customerName: '',
                customerAddress: '',
                customerEmail: '',
                items: [
                    {
                        "itemDetail": "",
                        "quantity": 0,
                        "unitPrice": 0
                    }
                ],
                tax: 14
            };
        });


    };

    $scope.clear();

    $scope.doSearch= function(){
        $http({
                    url: "/searchcustomer",
                    method: "GET",
                    params: {phone:$scope.invoice.customerPhone}
                }).then(
                    function (success) {
                        $scope.invoice.customerName=success.data.name;
                        $scope.invoice.customerAddress=success.data.address;
                        $scope.invoice.customerEmail=success.data.email;

                    },
                    function (error) {
                        alert('not success');
                    });


    };

    $scope.submit = function () {

        $http({
            url: "/addinvoice",
            method: "POST",
            data: $scope.invoice,
            headers: {'Content-Type': 'application/json'}
        }).then(
            function (success) {
                alert('successfully saved');
                $scope.clear();
            },
            function (error) {
                alert('not success');
            });
    };
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
    $scope.addItem = function () {
        $scope.invoice.items.push({itemDetail: '', quantity: 0, unitPrice: 0});
    };
    $scope.invoiceSubTotal = function () {
        var total = 0.00;
        angular.forEach($scope.invoice.items, function (item) {
            total += (item.quantity * item.unitPrice);
        });
        return total;
    };

    $scope.calculateTax = function () {
        return (($scope.invoice.tax * $scope.invoiceSubTotal()) / 100);
    };

    // Calculates the grand total of the invoice
    $scope.calculateGrandTotal = function () {

        return $scope.calculateTax() + $scope.invoiceSubTotal();
    };

    $scope.removeItem = function (item) {
        $scope.invoice.items.splice($scope.invoice.items.indexOf(item), 1);
    };

    $scope.printMode   = false;



        });
