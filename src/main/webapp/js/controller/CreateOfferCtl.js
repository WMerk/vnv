vnvApp.controller(
    'CreateOfferCtl',
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

            $scope.resetOffer = function () {
                $scope.offer = new Object();
                $scope.offer.type = 'offer';

                $scope.offer.category = {
                    "name": "Bitte auswählen",
                    "id": 0,
                }

                $scope.errorSelectCategory = false;
                $scope.errorCreateOffer = false;
            };

            $scope.showTemplateLend = function () {
                $scope.resetOffer();
                $scope.offer.flavour = 'verleihen';
                $scope.templateOffer = 'html/templates/createoffer/createlend.html';
            };

            $scope.showTemplateService = function () {
                $scope.resetOffer();
                $scope.offer.flavour = 'Dienstleistung';
                $scope.templateOffer = 'html/templates/createoffer/createservice.html';
            };
            $scope.showTemplateDonate = function () {
                $scope.resetOffer();
                $scope.offer.flavour = 'verschenken';
                $scope.templateOffer = 'html/templates/createoffer/createdonate.html';
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

            $scope.doCreateNewOffer = function () {
                if ($scope.offer.category.id == 0) {
                    $scope.errorSelectCategory = true;
                    return;
                }
                $scope.offer.user = userService.getCurrentUser();

                var response = doCreateNewPost.query($scope.offer);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error
                        $scope.resetOffer();
                        userService.setOfferCreated(true);
                        $location.path('/Main');
                    } else {
                        // error
                        $scope.errorCreateOffer = true;

                    }
                });
            };

            $scope.selectCategory = function (category) {
                $scope.offer.category = category;
                $scope.errorSelectCategory = false;
            };

    }]);
