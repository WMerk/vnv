vnvApp.controller(
    'PasswordCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doChangePassword',
        function ($scope, $location, userService, doChangePassword) {

            $scope.init = function () {
                userService.setNewUser(false);
                $scope.user = userService.getCurrentUser();
                $scope.authenticated = userService.getAuthenticated();
                $scope.template = 'navigation.html';
            };

            $scope.changePassword = function () {
                var response = doChangePassword.query();

                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, change Password successful

                    }else {
                        // error, change Password failed

                    }

                });

            };


        }]);