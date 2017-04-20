vnvApp.controller(
    'FriendRequestCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLoadReceivedFriendRequests',
        'doLoadSentFriendRequests',
        function ($scope, $location, userService, doLoadReceivedFriendRequests, doLoadSentFriendRequests) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
                $scope.showTemplateReceivedRequests();
            };

            $scope.showTemplateReceivedRequests = function () {
                $scope.loadReceivedFriendRequests();
                $scope.templateFriendRequests = "/html/templates/friendrequests/receivedfriendrequests.html";
            };

            $scope.showTemplateSentRequests = function () {
                $scope.loadSentFriendRequests();
                $scope.templateFriendRequests = "/html/templates/friendrequests/sentfriendrequests.html";
            };

            $scope.loadReceivedFriendRequests = function () {
                var params = {};
                params['uid'] = $scope.user.uid;

                var response = doLoadReceivedFriendRequests.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.receivedRequests = response.data;
                    } else {
                        // error, query failed
                    }
                });
            };

            $scope.loadSentFriendRequests = function () {
                var params = {};
                params['uid'] = $scope.user.uid;

                var response = doLoadSentFriendRequests.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.sentRequests = response.data;
                    } else {
                        // error, query failed
                    }
                });
            };

            $scope.acceptRequest = function (user) {
                alert("acceptRequest");
            };

            $scope.deleteRequest = function (user) {
                alert("deleteRequest");
            };

            $scope.cancelRequest = function (user) {
                alert("cancelRequest");
            };

        }]);