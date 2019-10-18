angular.module('angularApp')
  .service('unidadeFederativaService', ['$http', '$q', function ($http, $q) {
    var http = $http;

    return {
      getAll: function(){
        return http.get('unidadeFederativa/uf').then(function (response) {
            return response.data;
        },function (error){
            alert(error.data.message);
        });
      },
      save: function(uf){
        var deferred = $q.defer();
          $http({
              method: 'post',
              data: uf, 
              url: 'unidadeFederativa/uf/salvar'
          }).then(function (response) {
              deferred.resolve();
              return deferred.promise;
          },function (error){
              alert(error.data.message);
              return deferred.promise;
          });
          return deferred.promise;
      }
    };

  }]);