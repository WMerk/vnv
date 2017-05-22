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
                if (userService.getNewUser()) {
                    $('#successfulRegistration').css("display", "block");
                    userService.setNewUser(false);
                }
                if (userService.getOfferCreated()) {
                    $('#successfulCreateOffer').css("display", "block");
                    userService.setOfferCreated(false);
                }
                if (userService.getRequestCreated()) {
                    $('#successfulCreateRequest').css("display", "block");
                    userService.setRequestCreated(false);
                }

                $scope.templateNavigation = userService.getNavigationTemplate();

            };

            $scope.doLogout = function () {
                var response = doLogout.query(userService.getCurrentUser());
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        userService.clearData();
                        $location.path('/');
                    } else {
                    }
                });
            };

        }]);