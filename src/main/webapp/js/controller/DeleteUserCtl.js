vnvApp.controller(
    'DeleteUserCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doDeleteUser',
        function ($scope, $location, userService, doDeleteUser) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
                $scope.errorDeleteAccount = false;
            };

            $scope.deleteUser = function () {
                $scope.errorDeleteAccount = false;
                var response = doDeleteUser.query($scope.user);

                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, delete User successful
                        $('#modalDeleteAccount').modal('hide');
                        $('body').removeClass('modal-open');
                        $('.modal-backdrop').remove();

                        userService.setAccountDeleted(true);
                        userService.clearData();
                        $location.path('/');
                    } else {
                        // error, delete failed
                        $scope.errorDeleteAccount = true;
                    }

                });
            };

        }]);