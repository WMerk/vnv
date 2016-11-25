vnvApp.controller(
    'PasswordCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doChangePassword',
        function ($scope, $location, userService, doChangePassword) {

            $scope.init = function () {
                userService.setNewUser(false);
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
            };

            $scope.changePassword = function () {
                var response = doChangePassword.query();

                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, change Password successful

                    }else {
                        // error, change Password failed

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