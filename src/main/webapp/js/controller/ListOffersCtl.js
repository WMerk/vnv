vnvApp.controller(
    'ListOffersCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLoadOffers',
        function ($scope, $location, userService, doLoadOffers) {

            $scope.update = {
                editPost : false
            }

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
                $scope.loadOffers();
                $scope.update.editPost = false;
            };

            $scope.loadOffers = function () {
                var params = {};
                params['uid'] = $scope.user.uid;

                var response = doLoadOffers.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.offers = response.data;
                    } else {
                        // error, query failed
                    }
                });
            };

            $scope.editSelectedPost = function (post) {
                $scope.update.editPost = true;
                $scope.update.post = angular.copy(post);
            };


        }]);