vnvApp.controller(
    'RegistrationCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doRegister',
        function($scope, $location, userService, doRegister) {

            $scope.doRegister = function() {

                var params = {};
                params['firstName'] = $scope.registration.firstName;
                params['lastName'] = $scope.registration.lastName;
                params['mail'] = $scope.registration.mail;
                params['hashedPw'] = $scope.registration.confirmPw;

                var response = doRegister.query(params);

                response.$promise.then(function(data){
                   if(data.error === undefined){
                       // no error, registration successful
                       userService.setCurrentUser(data);
                       userService.setNewUser(true);
                       $scope.registration = '';
                       $location.path('/Main');
                   }else{
                       // error, registration failed
                       $('#errorAlreadyRegistered').css("display", "block");
                       $('#form-email').css("background-color", "rgba(206,132,131,0.58)");
                       $('#form-email').css("color", "#fff");
                   }

                });
            };

} ]);