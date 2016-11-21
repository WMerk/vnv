vnvApp.controller(
    'CreateOfferCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLoadCategories',
        function ($scope, $location, userService, doLoadCategories) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
                $scope.templateOffer = 'html/templates/createlend.html';


                $scope.categories = doLoadCategories.query();
            };

            $scope.showTemplateLend = function () {
                $scope.templateOffer = 'html/templates/createlend.html';
            };
            $scope.showTemplateService = function () {
                $scope.templateOffer = 'html/templates/createservice.html';
            };
            $scope.showTemplateDonate = function () {
                $scope.templateOffer = 'html/templates/createdonate.html';
            };

            $scope.loadCategories = function () {



            };




        }]);