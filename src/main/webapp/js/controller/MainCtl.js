vnvApp.controller(
    'MainCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLogout',
        function ($scope, $location, userService, doLogout) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.authenticated = userService.getAuthenticated();
                if (userService.getNewUser()) {
                    $('#successfulRegistration').css("display", "block");
                }

                $scope.template = 'navigation.html';

            };

            $scope.doLogout = function () {
                var response = doLogout.query(userService.getCurrentUser());

                response.$promise.then(function (data) {

                    if (data.error === undefined) {
                        userService.setCurrentUser(null);
                        userService.setAuthenticated(false);
                        $location.path('/');
                    } else {

                    }


                });
            };

        }]);