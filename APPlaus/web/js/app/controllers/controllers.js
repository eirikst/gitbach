angular.module('employeeApp.controllers', [])

/*
 * Trengs ikke per nå, mulig senere
 */
.controller('HeaderCtrl', function($scope, $location) {
    $scope.isActive = function(viewLocation) {
        return viewLocation === $location.path();
    };
})

.controller('UserFrontCtrl', function($scope, $location, $http) {
    //Carousel related
    $scope.weekPoints = 5;
    $scope.monthPoints = 10;
    $scope.yearPoints = 60;
    
    $scope.slideInterval = 5000;
    var slides = $scope.slides = [];
    slides.push({image:'http://placehold.it/800x320', text:'Antall poeng samlet denne uka', points:$scope.weekPoints});
    slides.push({image:'http://placehold.it/800x320', text:'Antall poeng samlet denne måned', points:$scope.monthPoints});
    slides.push({image:'http://placehold.it/800x320', text:'Antall poeng samlet i år', points:$scope.yearPoints});
    
    
    //Goal related
    
    $scope.goal;
    
    
    //Ideabank related
    
    
    
    
    //News related
    $scope.news = [{title:'Konkurranse ferdig!', text:'Konkurransen "APPlaus 2.0" er ferdig. Dette er dummytekst laget av Eirik.'},
    {title:'Hvordan går det?', text:'Bruker du APPlaus nok? Snart kommer det en ny konkurranse som vil motivere til bruk av APPlaus blablabla.'},
    {title:'Heia', text:'Dette er dummytekst laget av Eirik.'},
    {title:'Registrer mål for uka!', text:'Dette er dummytekst laget av Eirik.'}];


    $scope.changeView = function(view) {
        $scope.weekPoints = 599;
        $location.path(view); // path not hash
    };

    $scope.dropdown = false;
    $scope.drop = function() {
        $scope.dropdown = !$scope.dropdown;
    };
    
    
    $scope.returnValue = "";
    
    $http({
        url: 'MongoConnection',
        method: "POST",
        data: "value=Hei",
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
    }).success(function(data, status, headers, config) {
        $scope.returnValue = data;//sets assignment table with info from DB
    }).error(function(data, status, headers, config) {
        $scope.returnValue = "En feil har oppstått. Prøv å laste siden på nytt.";
    });
    
})



.controller('TestCtrl', function($scope, $location) {
    $scope.changeView = function(view) {
        $location.path(view); // path not hash
    };
    
    
})


.controller('TestCtrl2', function($scope, $location) {
    $scope.changeView = function(view) {
        $location.path(view); // path not hash
    };
    
    $scope.assignments = [
        {name:"Red note", text:"Skriv en red note", points:5},
        {name:"Yellow note", text:"Skriv en red note", points:15},
        {name:"Blue note", text:"Skriv en red note", points:45}
    ];
    
    //Assignment related
    $scope.selectedOption = $scope.assignments[0];
    
    
});