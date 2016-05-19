invoiceApp.controller('UserController', function ($scope, $http, $location) {
    //$scope.users = {
    //    username: '',
    //    password: '',
    //    name: '',
    //    fatherName: '',
    //    address: '',
    //    email: '',
    //    phone: '',
    //    gender: '',
    //    enabled: ''
    //};
    //
    //$scope.submit = function () {
    //
    //    $http({
    //        url: "http://localhost:8080/adduser",
    //        method: "GET",
    //        params: $scope.users
    //    }).then(
    //        function (success) {
    //            alert('successfully saved');
    //        },
    //        function (error) {
    //            alert('not success');
    //        });
    //    $scope.users = {
    //        username: '',
    //        password: '',
    //        name: '',
    //        fatherName: '',
    //        address: '',
    //        email: '',
    //        phone: '',
    //        gender: '',
    //        enabled: ''
    //    };
    //}






    $scope.users = {
        username: '',
        password: '',
        name: '',
        fatherName: '',
        address: '',
        email: '',
        phone: '',
        gender: '',
        enabled: '',
        userRoleEntity:{ "role":""}
    };


    $scope.submit = function () {

        $http({
            url: "http://localhost:8080/addusernew",
            method: "POST",
            data: $scope.users,
            headers : {'Content-Type': 'application/json' }
        }).then(
            function (success) {
                alert('successfully saved');
            },
            function (error) {
                alert('not success');
            });
        $scope.users = {
            username: '',
            password: '',
            name: '',
            fatherName: '',
            address: '',
            email: '',
            phone: '',
            gender: '',
            enabled: ''
        };
    }


});