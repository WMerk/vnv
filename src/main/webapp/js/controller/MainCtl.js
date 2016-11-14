vnvApp.controller(
    'MainCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLogout',
        function($scope, $location, userService, doLogout) {

            $scope.init = function() {
                $scope.user = userService.getCurrentUser();
                if(userService.getNewUser()){
                    $('#successfulRegistration').css("display", "block");
                }
            };

            $scope.doLogout = function() {
                doLogout.query(userService.getCurrentUser());



                $location.path('/');
            };

        } ]);