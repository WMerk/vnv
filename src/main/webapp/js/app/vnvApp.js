var vnvApp = angular.module('vnvApp', [
    'ngResource', 'ngRoute', 'ngCookies', 'satellizer']);

vnvApp.config(['$routeProvider', '$locationProvider', '$authProvider', function ($routeProvider, $locationProvider, $authProvider) {

    $routeProvider.when('/', {
        templateUrl: '/html/login.html',
        controller: 'LoginCtl'
    }).when('/Register', {
        templateUrl: '/html/register.html',
        controller: 'RegistrationCtl'
    }).when('/Main', {
        templateUrl: '/html/main.html',
        controller: 'MainCtl'
    }).when('/Profile', {
        templateUrl: '/html/profile.html',
        controller: 'ProfileCtl'
    }).when('/Settings', {
        templateUrl: '/html/settings.html',
        controller: 'SettingsCtl'
    }).when('/Password', {
        templateUrl: '/html/password.html',
        controller: 'PasswordCtl'
    }).when('/DeleteUser', {
        templateUrl: '/html/deleteuser.html',
        controller: 'DeleteUserCtl'
    }).when('/CreateOffer', {
        templateUrl: '/html/createoffer.html',
        controller: 'CreateOfferCtl'
    }).when('/CreateRequest', {
        templateUrl: '/html/createrequest.html',
        controller: 'CreateRequestCtl'
    }).when('/AddFriends', {
        templateUrl: '/html/searchuser.html',
        controller: 'SearchUserCtl'
    }).when('/FriendRequests', {
        templateUrl: '/html/friendrequests.html',
        controller: 'FriendRequestCtl'
    }).when('/Friends', {
        templateUrl: '/html/friends.html',
        controller: 'FriendsCtl'
    }).when('/ListOffers', {
        templateUrl: '/html/listoffers.html',
        controller: 'ListOffersCtl'
    }).when('/ListRequests', {
        templateUrl: '/html/listrequests.html',
        controller: 'ListRequestsCtl'
    }).otherwise({
        redirectTo: '/'
    });

    $authProvider.google({
        clientId: '707063193538-lcm9405hr187ncpl3rcv4q5ts2po42tc.apps.googleusercontent.com',
        scope: "openid email profile https://www.googleapis.com/auth/contacts.readonly"
    });

    $authProvider.oauth2({
        name: 'foursquare',
        url: '/auth/foursquare',
        clientId: 'Foursquare Client ID',
        redirectUri: window.location.origin,
        authorizationEndpoint: 'https://foursquare.com/oauth2/authenticate',
    });

    //check browser support for html 5 mode (removes # from url)
    if (window.history && window.history.pushState) {
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
    }

}]);

vnvApp.filter('requestOrOfferFilter', function () {
    return function (items, filter) {

        var filtered = [];
        angular.forEach(items, function(item) {
            var valid = true;

            if(filter.category.name !== "Kategorie"){
                if(filter.category.id !== item.category.id){
                    valid = false;
                }
            }
            if(filter.status !== "Status"){
                if(filter.status !== item.status){
                    valid = false;
                }
            }
            if(filter.inseratart !== "Inseratart"){
                if(filter.inseratart === "Verschenken" && item.flavour !== "verschenken"){
                    valid = false;
                }
                if(filter.inseratart === "Verleih" && item.flavour !== "verleihen"){
                    valid = false;
                }
                if(filter.inseratart === "Dienstleistung" && item.flavour !== "Dienstleistung"){
                    valid = false;
                }
            }

            if(valid){
                filtered.push(item);
            }
        });

        return filtered;
    };
});