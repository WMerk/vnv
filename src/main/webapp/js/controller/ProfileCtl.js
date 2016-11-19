vnvApp.controller(
    'ProfileCtl',
    [
        '$scope',
        '$location',
        'userService',
        function ($scope, $location, userService) {

            $scope.init = function () {
                userService.setNewUser(false);
                $scope.user = userService.getCurrentUser();
                $scope.template = userService.getNavigationTemplate();
            };

        }]);
