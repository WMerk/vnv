vnvApp.controller(
    'MainCtl',
    [
        '$scope',
        '$location',
        'userService',
        'doLogout',
        'doLoadFriendsRequests',
        'doLoadFriendsOffers',
        'doLoadCategories',
        function ($scope, $location, userService, doLogout, doLoadFriendsRequests, doLoadFriendsOffers, doLoadCategories) {

            $scope.init = function () {
                $scope.user = userService.getCurrentUser();
                if (userService.getNewUser()) {
                    $('#successfulRegistration').css("display", "block");
                    userService.setNewUser(false);
                }
                if (userService.getOfferCreated()) {
                    $('#successfulCreateOffer').css("display", "block");
                    userService.setOfferCreated(false);
                }
                if (userService.getRequestCreated()) {
                    $('#successfulCreateRequest').css("display", "block");
                    userService.setRequestCreated(false);
                }

                $scope.templateNavigation = userService.getNavigationTemplate();
                $scope.showTemplateSearchOffer();
                $scope.loadCategories();
                $scope.resetFilters();
            };

            $scope.doLogout = function () {
                var response = doLogout.query(userService.getCurrentUser());
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        userService.clearData();
                        $location.path('/');
                    } else {
                    }
                });
            };

            $scope.showTemplateSearchOffer = function () {
                $scope.templateSearchOfferOrRequest = 'html/templates/searchofferorrequest/searchoffer.html';
                $scope.loadFriendsOffers();
                $scope.resetFilters();
            };

            $scope.showTemplateSearchRequest = function () {
                $scope.templateSearchOfferOrRequest = 'html/templates/searchofferorrequest/searchrequest.html';
                $scope.loadFriendsRequests();
                $scope.resetFilters();
            };

            $scope.loadFriendsOffers = function () {
                var params = {};
                params['uid'] = $scope.user.uid;

                var response = doLoadFriendsOffers.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.offers = response.data;
                    } else {
                        // error, query failed
                    }
                });
            };

            $scope.loadFriendsRequests = function () {
                var params = {};
                params['uid'] = $scope.user.uid;

                var response = doLoadFriendsRequests.query(params);
                response.$promise.then(function (data) {
                    if (data.error === undefined) {
                        // no error, query successful
                        $scope.requests = response.data;
                    } else {
                        // error, query failed
                    }
                });
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

            $scope.selectCategory = function (category) {
                if(category === 'Kategorie'){
                    $scope.filters.category = {};
                    $scope.filters.category.name = "Kategorie";
                }else{
                    $scope.filters.category = category;
                }
            };

            $scope.selectStatus = function (status) {
                $scope.filters.status = status;
            };

            $scope.selectInseratart = function (inseratart) {
                $scope.filters.inseratart = inseratart;
            };

            $scope.resetFilters = function () {
                $scope.filters = {
                    category: {name: "Kategorie"},
                    status: "Status",
                    inseratart: "Inseratart"
                }
                $scope.filtername = '';
            };

        }]);