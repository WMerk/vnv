vnvApp.controller(
    'UpdatePostCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLoadCategories',
        'doUpdatePost',
        function ($scope, $location, userService, doLoadCategories, doUpdatePost) {

            $scope.initSubScope = function () {
                $scope.user = userService.getCurrentUser();
                $scope.loadCategories();
                $scope.loadStatusSelection();
            };

            $scope.loadCategories = function () {
                var response = doLoadCategories.query();

                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.categories = response;
                    } else {
                        // error, query failed
                    }
                });
            };


            $scope.loadStatusSelection = function () {
                $scope.statusSelection = [
                    {name: "Verfügbar"}
                ]

                var secondStatus = {}
                var reserved = {name: "Reserviert"}
                if ($scope.update.post.flavour === 'verschenken') {
                    $scope.statusSelection.push(reserved);
                    secondStatus['name'] = 'Verschenkt';
                } else if ($scope.update.post.flavour === 'verleihen') {
                    $scope.statusSelection.push(reserved);
                    secondStatus['name'] = 'Verliehen';
                } else {
                    secondStatus['name'] = 'Nicht Verfügbar';
                }
                $scope.statusSelection.push(secondStatus);
            };

            $scope.doUpdatePost = function () {
                if ($scope.update.post.category.id === 0) {
                    $scope.errorSelectCategory = true;
                    return;
                }
                $scope.update.post.user = userService.getCurrentUser();

                var response = doUpdatePost.query($scope.update.post);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error
                        $scope.errorUpdatePost = false;
                        $scope.init();
                    } else {
                        // error
                        $scope.errorUpdatePost = true;
                    }
                });
            };

            $scope.doCancelUpdatePost = function () {
                $scope.update.editPost = false;
            };

            $scope.selectStatus = function (status) {
                $scope.update.post.status = status.name;
            };

            $scope.selectCategory = function (category) {
                $scope.update.post.category = category;
                $scope.errorSelectCategory = false;
            };

        }]);
