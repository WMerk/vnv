vnvApp.factory('doRegisterResource', function($resource) {
     return $resource('/url',
        { },
        { query: { 	method:"POST",
            isArray:false,
            headers:{'Content-Type':'application/json; charset=utf-8'}
        }
        }
    );
});
