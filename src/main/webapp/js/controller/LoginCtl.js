vnvApp.controller(
    'LoginCtl',
    [
        '$scope',
        '$location',
        '$auth',
        'userService',
        'doLogin',
        function ($scope, $location, $auth, userService, doLogin) {

            $scope.init = function () {
                $scope.accountDeleted = userService.getAccountDeleted();
                userService.clearData();
            };

            $scope.doLogin = function () {
                var params = {};
                params['mail'] = $scope.login.mail;
                params['password'] = $scope.login.password;

                userService.setGoogleLogin(false);

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
                }).catch(function (response) {
                    // error, login failed with 400/401
                    $('#errorLogin').css("display", "block");
                });
                userService.setAccountDeleted(false);
            };

            $scope.authenticate = function (provider) {
                userService.setGoogleLogin(true);
                $auth.authenticate(provider).then(function (response) {
                    if (response.error === undefined) {
                        // no error, login successful
                        console.log(response);
                        userService.setCurrentUser(response.data);
                        userService.setNewUser(false);
                        userService.setAccountDeleted(false);
                        $scope.login = '';
                        $('#errorLogin').css("display", "none");
                        $location.path('/Main');
                    }
                }).catch(function (response) {
                    // error, login failed
                    $('#errorLogin').css("display", "block");
                });
            };


        }]);

function resetLoginError() {
    $('#errorLogin').css("display", "none");
}