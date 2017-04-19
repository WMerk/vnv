vnvApp.controller(
    'CreateRequestCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLoadCategories',
        'doCreateNewPost',
        function ($scope, $location, userService, doLoadCategories, doCreateNewPost) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
                $scope.showTemplateLend();
                $scope.loadCategories();
            };

            $scope.resetRequest = function () {
                $scope.request = new Object();
                $scope.request.type = 'request';

                $scope.request.category = {
                    "name": "Bitte auswählen",
                    "id": 0,
                }

                $scope.errorSelectCategory = false;
                $scope.errorCreateRequest = false;
            };

            $scope.showTemplateLend = function () {
                $scope.resetRequest();
                $scope.request.flavour = 'verleihen';
                $scope.templateRequest = 'html/templates/createrequest/createlend.html';
            };

            $scope.showTemplateService = function () {
                $scope.resetRequest();
                $scope.request.flavour = 'Dienstleistung';
                $scope.templateRequest = 'html/templates/createrequest/createservice.html';
            };
            $scope.showTemplateDonate = function () {
                $scope.resetRequest();
                $scope.request.flavour = 'verschenken';
                $scope.templateRequest = 'html/templates/createrequest/createdonate.html';
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

            $scope.doCreateNewRequest = function () {
                if ($scope.request.category.id == 0) {
                    $scope.errorSelectCategory = true;
                    return;
                }
                $scope.request.user = userService.getCurrentUser();

                var response = doCreateNewPost.query($scope.request);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error
                        $scope.resetRequest();
                        userService.setRequestCreated(true);
                        $location.path('/Main');
                    } else {
                        // error
                        $scope.errorCreateRequest = true;
                    }
                });
            };

            $scope.selectCategory = function (category) {
                $scope.request.category = category;
                $scope.errorSelectCategory = false;
            };

    }]);
