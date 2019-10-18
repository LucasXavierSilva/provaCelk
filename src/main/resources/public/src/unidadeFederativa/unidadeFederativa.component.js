var unidadeFederativa = {
  bindings: {
    unidadeFederativa: '<',
    onSelect: '&'
  },
  templateUrl: './unidadeFederativa.html',
  controller: 'UnidadeFederativaController'
};

angular
  .module('angularApp')
  .component('unidadeFederativa', unidadeFederativa);
