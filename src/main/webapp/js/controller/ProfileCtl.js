vnvApp.controller(
    'ProfileCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doUpdateUser',
        function ($scope, $location, userService, doUpdateUser) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
                $scope.successUpdateUser = false;
                $scope.errorUpdateUser = false;
            };

            $scope.updateUser = function () {
                var response = doUpdateUser.query($scope.user);

                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.user = response;
                        $scope.successUpdateUser = true;
                    } else {
                        // error, query failed
                        $scope.user = response;
                        $scope.errorUpdateUser = true;
                    }

                });
            }

        }]);
