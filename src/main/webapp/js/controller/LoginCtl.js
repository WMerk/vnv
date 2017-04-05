vnvApp.controller(
    'LoginCtl',
    [
        '$scope',
        '$location',
        '$auth',
        'userService',
        'doLogin',
        'doGoogleLogin',
        function ($scope, $location, $auth, userService, doLogin, doGoogleLogin) {

            $scope.init = function () {
                $scope.accountDeleted = userService.getAccountDeleted();
                userService.clearData();
            };

            $scope.doLogin = function () {

                var params = {};
                params['mail'] = $scope.login.mail;
                params['password'] = $scope.login.password;

                var response = doLogin.query(params);

                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, registration successful
                        userService.setCurrentUser(data);
                        userService.setNewUser(false);
                        $scope.login = '';
                        $('#errorLogin').css("display", "none");
                        $location.path('/Main');
                    } else {
                        // error, login failed
                        $('#errorLogin').css("display", "block");
                    }

                });

                userService.setAccountDeleted(false);

            };

            $scope.authenticate = function (provider) {
                var params = {};
                var response = doGoogleLogin.query(params);

                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, registration successful
                        $auth.authenticate(provider, response);
                    } else {
                        // error, login failed
                    }

                });

            };

            $auth.authenticate('google')
                .then(function (response) {
                    console.log("success: " + response);
                    // Signed in with Google.
                })
                .catch(function (response) {
                    console.log("error: " + response);
                    // Something went wrong.
                });

        }]);

function resetLoginError() {
    $('#errorLogin').css("display", "none");
}