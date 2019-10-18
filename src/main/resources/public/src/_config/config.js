/**
 * Created by semianchuk on 08.10.16.
 */
angular.module('angularApp')
    .config(['$locationProvider','$stateProvider', function($locationProvider,$stateProvider) {
        $locationProvider.html5Mode(true);

        $stateProvider
            .state('unidadeFederativa', {
                url         : '/',
                templateUrl : 'src/unidadeFederativa/unidadeFederativa.html',
                controller  : 'unidadeFederativaController'
            })
    }]);