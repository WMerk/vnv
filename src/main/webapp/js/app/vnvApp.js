var vnvApp = angular.module('vnvApp', [
    'ngResource', 'ngRoute', 'ngCookies']);

vnvApp.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {

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
    }).when('/AddFriends', {
        templateUrl: '/html/searchuser.html',
        controller: 'SearchUserCtl'
    }).otherwise({
        redirectTo: '/'
    });


    //check browser support for html 5 mode (removes # from url)
    if(window.history && window.history.pushState){
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
    }

}])
;

