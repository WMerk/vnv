vnvApp.controller(
    'FriendRequestCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLoadReceivedFriendRequests',
        'doLoadSentFriendRequests',
        'doCancelRequest',
        'doDeclineRequest',
        'doAcceptRequest',
        function ($scope, $location, userService, doLoadReceivedFriendRequests, doLoadSentFriendRequests, doCancelRequest, doDeclineRequest, doAcceptRequest) {

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

            $scope.declineRequest = function (user) {
                var params = {};
                params['user'] = $scope.user;
                params['friend'] = user;

                var response = doDeclineRequest.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.loadReceivedFriendRequests();
                    } else {
                        // error, query failed
                    }
                });
            };

            $scope.cancelRequest = function (user) {
                var params = {};
                params['user'] = $scope.user;
                params['friend'] = user;

                var response = doCancelRequest.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.loadSentFriendRequests();
                    } else {
                        // error, query failed
                    }
                });
            };

            $scope.acceptRequest = function (user) {
                var index = $scope.receivedRequests.indexOf(user);

                var params = {};
                params['user'] = $scope.user;
                params['friend'] = user;

                var response = doAcceptRequest.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        if(response.request=="accepted"){
                            response.data.accepted = true;
                            $scope.receivedRequests[index] = response.data;
                        }
                    } else {
                        // error, query failed
                    }
                });
            };



        }]);