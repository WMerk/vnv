var vnvApp = angular.module('vnvApp', [
    'ngResource', 'ngRoute']);

vnvApp.config([ '$routeProvider', function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl : 'login.html',
        controller : 'LoginCtl'
    }).when('/Register', {
        templateUrl : 'register.html',
        controller : 'RegistrationCtl'
    }).when('/Main', {
        templateUrl : 'main.html',
        controller : 'MainCtl'
    }).otherwise({
        redirectTo : '/'
    });
} ]);