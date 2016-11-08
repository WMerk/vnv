var vnvApp = angular.module('vnvApp', [
    'ngResource', 'ngRoute']);

vnvApp.config([ '$routeProvider', function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl : 'login.html',
        controller : 'MainCtl'
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