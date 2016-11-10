vnvApp.controller(
    'MainCtl',
    [
        '$scope',
        '$location',
        'userService',
        function($scope, $location, userService) {

            $scope.init = function() {

                $scope.user = userService.getCurrentUser();
                if(userService.getNewUser()){
                    $('#successfulRegistration').css("display", "block");
                }

            };

        } ]);