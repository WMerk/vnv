vnvApp.controller(
    'DeleteUserCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doDeleteUser',
        function ($scope, $location, userService, doDeleteUser) {

            $scope.init = function () {
                userService.setNewUser(false);
                $scope.user = userService.getCurrentUser();
                $scope.authenticated = userService.getAuthenticated();
                $scope.template = 'navigation.html';
            };

            $scope.deleteUser = function () {
                alert("delete User");

                var response = doDeleteUser.query(userService.getCurrentUser());

                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, registration successful

                        userService.setCurrentUser(null);
                        userService.setAuthenticated(false);
                        $location.path('/');


                    }else {
                        // error, delete failed

                    }

                });
            };

        }]);