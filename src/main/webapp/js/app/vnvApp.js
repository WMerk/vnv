var vnvApp = angular.module('vnvApp', [
    'ngResource', 'ngRoute']);

vnvApp.config([ '$routeProvider', function($routeProvider) {
    $routeProvider.when('/Register', {
        templateUrl : 'register.html',
        controller : 'RegistrationCtl'
    }).otherwise({
        redirectTo : '/'
    });
} ]);