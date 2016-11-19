vnvApp.controller(
    'SettingsCtl',
    [
        '$scope',
        '$location',
        'userService',
        function ($scope, $location, userService) {

            $scope.init = function () {
                userService.setNewUser(false);
                $scope.user = userService.getCurrentUser();
                $scope.authenticated = userService.getAuthenticated();
                $scope.template = userService.getNavigationTemplate();
            };

        }]);