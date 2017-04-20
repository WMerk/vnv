vnvApp.controller(
    'SearchUserCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLoadAllUsers',
        'doSendFriendRequest',
        function ($scope, $location, userService, doLoadAllUsers, doSendFriendRequest) {

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
                        $scope.users = response.users;
                    } else {
                        // error, query failed
                    }
                });
            };

            $scope.addFriend = function (user) {
                var index = $scope.users.indexOf(user);

                var params = {};
                params['user'] = $scope.user;
                params['friend'] = user.data;

                var response = doSendFriendRequest.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.users[index].request = response.request;
                    } else {
                        // error, query failed
                    }

                });
            }



        }]);