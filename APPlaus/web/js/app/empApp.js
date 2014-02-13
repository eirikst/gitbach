var employeeApp = angular.module('employeeApp', 
['employeeApp.controllers', 
'ngRoute',
'ngTouch',
'ngAnimate',
'ui.bootstrap'
])

        //The route provider manages routing of views
.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/view1', {templateUrl: 'partials/registerAssignment.html', controller: 'TestCtrl2'});
    $routeProvider.when('/view2', {templateUrl: 'partials/competitions.html', controller: 'TestCtrl'});
    $routeProvider.when('/userFront', {templateUrl: 'partials/userFront.html', controller: 'UserFrontCtrl'});
    $routeProvider.otherwise({redirectTo: '/userFront'});
}]);