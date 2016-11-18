vnvApp.controller(
    'SettingsCtl',
    [
        '$scope',
        '$location',
        'userService',
        function ($scope, $location, userService) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.authenticated = userService.getAuthenticated();
                $scope.template = 'navigation.html';
            };

        }]);
