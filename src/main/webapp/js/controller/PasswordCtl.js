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
                $scope.authenticated = userService.getAuthenticated();
                $scope.template = userService.getNavigationTemplate();
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

function validatePw() {
    if (document.getElementById('form-newPW').value != document.getElementById('form-confirmNewPW').value) {
        $('#form-changePW').prop('disabled', true);
        $('#form-confirmNewPW').css("background-color", "rgba(206,132,131,0.58)");
        $('#form-confirmNewPW').css("color", "#fff");
    } else {
        $('#form-changePW').prop('disabled', false);
        $('#form-confirmNewPW').css("background-color", "#f8f8f8");
        $('#form-confirmNewPW').css("color", "#000");
    }
}