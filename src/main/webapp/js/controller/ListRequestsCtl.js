vnvApp.controller(
    'ListRequestsCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLoadRequests',
        function ($scope, $location, userService, doLoadRequests) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
                $scope.loadRequests();
            };

            $scope.loadRequests = function () {
                var params = {};
                params['uid'] = $scope.user.uid;

                var response = doLoadRequests.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.requests = response.data;
                    } else {
                        // error, query failed
                    }
                });
            };


        }]);