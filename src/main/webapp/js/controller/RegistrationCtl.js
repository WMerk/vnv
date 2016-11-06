vnvApp.controller(
    'RegistrationCtl',
    [
        '$scope',
        'doRegisterResource',
        function($scope, doRegisterResource) {

            $scope.doRegister = function() {
                var params = {};
                params['firstName'] = $scope.user.firstName;
                params['lastName'] = $scope.user.lastName;
                params['mail'] = $scope.user.mail;
                params['confirmPw'] = $scope.user.hashedPw;

                $scope.user = doRegisterResource.query(params);
                $scope.user = '';
            };

} ]);