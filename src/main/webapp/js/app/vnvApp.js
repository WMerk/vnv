var vnvApp = angular.module('vnvApp', [
    'ngResource', 'ngRoute']);

vnvApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'login.html',
        controller: 'LoginCtl'
    }).when('/Register', {
        templateUrl: 'register.html',
        controller: 'RegistrationCtl'
    }).when('/Main', {
        templateUrl: 'main.html',
        controller: 'MainCtl'
    }).when('/Profile', {
        templateUrl: 'profile.html',
        controller: 'ProfileCtl'
    }).when('/Settings', {
        templateUrl: 'settings.html',
        controller: 'SettingsCtl'
    }).when('/Password', {
        templateUrl: 'password.html',
        controller: 'PasswordCtl'
    }).when('/DeleteUser', {
        templateUrl: 'deleteuser.html',
        controller: 'DeleteUserCtl'
    }).otherwise({
        redirectTo: '/'
    });
}]);

