vnvApp.controller(
    'FriendsCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLoadFriends',
        'doDeleteFriend',
        function ($scope, $location, userService, doLoadFriends, doDeleteFriend) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
                $scope.loadFriends();
            };

            $scope.loadFriends = function () {
                var params = {};
                params['uid'] = $scope.user.uid;

                var response = doLoadFriends.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.friends = response.data;
                    } else {
                        // error, query failed
                    }
                });
            };

            $scope.deleteFriend = function (user) {
                var params = {};
                params['user'] = $scope.user;
                params['friend'] = user;

                var response = doDeleteFriend.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.loadFriends();
                    } else {
                        // error, query failed
                    }
                });
            };

        }]);