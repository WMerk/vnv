vnvApp.controller(
    'SearchUserCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLoadAllUsers',
        function ($scope, $location, userService, doLoadAllUsers) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
                $scope.loadAllUsers();
            };

            $scope.loadAllUsers = function () {
                var params = {};
                params['uid'] = $scope.user.uid;
                var response = doLoadAllUsers.query(params);

                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.users = response;
                        console.log($scope.users);
                    } else {
                        // error, query failed
                    }

                });


            };


        }]);