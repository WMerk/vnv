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
                $scope.templateNavigation = userService.getNavigationTemplate();
            };

            $scope.deleteUser = function () {

                var response = doDeleteUser.query(userService.getCurrentUser());

                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, delete User successful
                        userService.setAccountDeleted(true);
                        userService.clearData();
                        $location.path('/');
                    } else {
                        // error, delete failed
                    }

                });
            };

        }]);