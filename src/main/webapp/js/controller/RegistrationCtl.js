vnvApp.controller(
    'RegistrationCtl',
    [
        '$scope',
        '$location',
        'doRegisterResource',
        function($scope, $location, doRegisterResource) {

            $scope.doRegister = function() {

                var params = {};
                params['firstName'] = $scope.user.firstName;
                params['lastName'] = $scope.user.lastName;
                params['mail'] = $scope.user.mail;
                params['hashedPw'] = $scope.user.confirmPw;

                $scope.user = doRegisterResource.query(params);
                $scope.user = '';

                $location.path('/Main');
            };

} ]);