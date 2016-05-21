invoiceApp.controller('UserController', function ($scope, $http, $location) {
      $scope.users = {
        username: '',
        password: '',
        name: 'soni',
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
            url: "/addusernew",
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