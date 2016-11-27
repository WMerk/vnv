vnvApp.controller(
    'CreateOfferCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLoadCategories',
        'doCreateNewOffer',
        function ($scope, $location, userService, doLoadCategories, doCreateNewOffer) {

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
                $scope.templateOffer = 'html/templates/createlend.html';
                $scope.resetOffer();
                $scope.offer.flavour = 'verleihen';
            };

            $scope.showTemplateService = function () {
                $scope.templateOffer = 'html/templates/createservice.html';
                $scope.resetOffer();
                $scope.offer.flavour = 'Dienstleistung';
            };
            $scope.showTemplateDonate = function () {
                $scope.templateOffer = 'html/templates/createdonate.html';
                $scope.resetOffer();
                $scope.offer.flavour = 'verschenken';
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

                var response = doCreateNewOffer.query($scope.offer);

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
