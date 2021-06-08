;(function() {
    angular
        .module('app')
        .service('PedidoService', ['$http', function($http) {
            return {
                get: function() {
                    return $http.get('http://localhost:8080/api/produtos/todosPedidos');
                },
                save: function(data) {
                    return $http.post('http://localhost:8080/api/produtos/pedidos', data);
                }
            };
        }]);
})();
