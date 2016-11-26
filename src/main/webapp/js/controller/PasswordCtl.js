vnvApp.controller(
    'PasswordCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doChangePassword',
        function ($scope, $location, userService, doChangePassword) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
                $scope.successChangePassword = false;
                $scope.errorChangePassword = false;
            };

            $scope.changePassword = function () {
                var params = {};
                params['uid'] = $scope.user.uid;
                params['password'] = $scope.oldPassword;
                params['newPassword'] = $scope.newPassword;

                var response = doChangePassword.query(params);

                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, change Password successful
                        $scope.user = response;
                        $scope.successChangePassword = true;
                    }else {
                        // error, change Password failed
                        $scope.user = response;
                        $scope.errorChangePassword = true;

                    }

                });

            };


        }]);

function validateChangePw() {
    if (document.getElementById('passwordInputNewPw').value != document.getElementById('passwordInputConfirmPw').value) {
        $('#passwordButtonChangePw').prop('disabled', true);
        $('#passwordInputConfirmPw').css("background-color", "rgba(206,132,131,0.58)");
        $('#passwordInputConfirmPw').css("color", "#fff");
    } else {
        $('#passwordButtonChangePw').prop('disabled', false);
        $('#passwordInputConfirmPw').css("background-color", "#f8f8f8");
        $('#passwordInputConfirmPw').css("color", "#000");
    }
}