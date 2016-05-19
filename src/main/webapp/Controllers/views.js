invoiceApp.controller('ViewController', function ($scope, $http) {
    var url = 'http://localhost:8080/allusers';
    $http.get(url).success(function (response) {
        $scope.userList = response;
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
        enabled: '',
        role: ''
    };

    $scope.editclicked = function (e) {
        $scope.users.username = e.username;
        $scope.users.password = e.password;
        $scope.users.name = e.name;
        $scope.users.fatherName = e.fatherName;
        $scope.users.address = e.address;
        $scope.users.email = e.email;
        $scope.users.phone = e.phone;
        $scope.users.gender = e.gender;
        $scope.users.enabled = e.enabled;
        $scope.users.role = e.userRoleEntity.role;

    }


    $scope.save = function () {

        $http({
            url: "http://localhost:8080/adduser",
            method: "GET",
            params: $scope.users
        }).then(
            function (success) {
                var url = 'http://localhost:8080/allusers';
                $http.get(url).success(function (response) {
                    $scope.userList = response;
                });
            },
            function (error) {
                alert('not success');
            });

    };

//to get updated data in view
    var url = 'http://localhost:8080/allusers';
    $http.get(url).success(function (response) {
        $scope.userList = response;
    });

    $scope.delete = function (e) {
        $http({
            url: "http://localhost:8080/delete",
            method: 'GET',
            params: {userid: e.userid}
        }).then(function (success) {

                alert('successfully deleted');
            },
            function (error) {
                var url = 'http://localhost:8080/allusers';
                $http.get(url).success(function (response) {
                    $scope.userList = response;
                });

            });
    }


});
