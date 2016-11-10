vnvApp.controller(
    'RegistrationCtl',
    [
        '$scope',
        '$location',
        'doRegisterResource',
        'userService',
        function($scope, $location, doRegisterResource, userService) {

            $scope.doRegister = function() {

                var params = {};
                params['firstName'] = $scope.registration.firstName;
                params['lastName'] = $scope.registration.lastName;
                params['mail'] = $scope.registration.mail;
                params['hashedPw'] = $scope.registration.confirmPw;

                var response = doRegisterResource.query(params);

                response.$promise.then(function(data){
                   if(data.error === undefined){
                       // no error, registration successful
                       userService.setCurrentUser(data);
                       $scope.registration = '';
                       $location.path('/Main');
                   }else{
                       // error, registration not successful
                       $('#errorAlreadyRegistered').css("display", "block");
                       $('#form-email').css("background-color", "rgba(206,132,131,0.58)");
                       $('#form-email').css("color", "#fff");
                   }

                });
            };

} ]);