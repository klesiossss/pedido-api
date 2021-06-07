;(function() {
    angular
        .module('app')
        .service('PedidoService', ['$http', function($http) {
            return {
                get: function() {
                    return $http.get('https://egf1amcv33.execute-api.us-east-1.amazonaws.com/dev/pedidos');
                },
                save: function(data) {
                    return $http.post('https://egf1amcv33.execute-api.us-east-1.amazonaws.com/dev/novo-pedido', data);
                }
            };
        }]);
})();
