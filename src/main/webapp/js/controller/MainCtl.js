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
                var response = doLogout.query(userService.getCurrentUser());

                response.$promise.then(function(data) {

                    if(data.error === undefined){
                        userService.setCurrentUser(null);
                        $location.path('/');
                    }else{

                    }


                });
            };

        } ]);