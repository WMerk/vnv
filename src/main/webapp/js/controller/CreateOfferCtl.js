vnvApp.controller(
    'CreateOfferCtl',
    [
        '$scope',
        '$location',
        'userService',
        function ($scope, $location, userService) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                $scope.templateNavigation = userService.getNavigationTemplate();
            };

            $scope.showTemplateLend = function () {

            };
            $scope.showTemplateService = function () {

            };
            $scope.showTemplateDonate = function () {

            };




        }]);