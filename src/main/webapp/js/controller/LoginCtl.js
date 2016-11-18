vnvApp.controller(
    'LoginCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLogin',
        function($scope, $location, userService, doLogin) {

            $scope.doLogin = function() {

                var params = {};
                params['mail'] = $scope.login.mail;
                params['hashedPw'] = $scope.login.pw;

                var response = doLogin.query(params);

                response.$promise.then(function(data){
                    if(data.error === undefined){
                        // no error, registration successful
                        userService.setCurrentUser(data);
                        userService.setNewUser(false);
                        userService.setAuthenticated(true);
                        $scope.login = '';
                        $('#errorLogin').css("display", "none");
                        $location.path('/Main');
                    }else{
                        // error, login failed
                        $('#errorLogin').css("display", "block");
                    }

                });



            };

        } ]);

function resetLoginError() {
    $('#errorLogin').css("display", "none");
}