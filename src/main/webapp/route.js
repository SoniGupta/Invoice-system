invoiceApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.



        when('/adduser', {
            templateUrl: 'Views/Users.html',
            controller: 'UserController',
            activetab: 'adduser'
        }).
        when('/userDetails', {
            templateUrl: ' Views/View_Users.html',
            controller: 'ViewController',
            activetab: 'userDetails'
        }).
        when('/addinvoice',{
            templateUrl: ' Views/Invoice.html',
            controller: 'InvoiceController',
            activetab: 'addinvoice'
        }).
        when('/invoiceDetails', {
            templateUrl: ' Views/View_Invoice.html',
            controller: 'InvoiceListController',
            activetab: 'invoiceDetails'
        }).
        when('/EditInvoice/:routeInvId', {
            templateUrl: ' Views/EditInvoice.html',
            controller: 'InvoiceEditController',
            activetab: 'Items'
        }).
        when('/dashboard', {
            templateUrl: ' Views/dashboard.html'
        }).


        otherwise({
            redirectTo: '/dashboard'
        });
}]);
