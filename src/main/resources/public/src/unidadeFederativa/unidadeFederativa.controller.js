function UnidadeFederativaController(unidadeFederativaService, $scope) {
	$scope.unidadesFederativas = [];
	unidadeFederativaService.getAll().then(function(data) {
		$scope.unidadesFederativas = data;
	});
	var initUf = function() {
		$scope.uf = {};
	}
	var initUfs = function() {
		unidadeFederativaService.getAll().then(function(data) {
			$scope.unidadesFederativas = data;
		});
	}
	$scope.save = function(uf) {
		unidadeFederativaService.save(uf).then(function(result) {
			initUf();
			initUfs();
		});
	}
}

angular.module('angularApp').controller('unidadeFederativaController',
		[ "unidadeFederativaService", "$scope", UnidadeFederativaController ]);
