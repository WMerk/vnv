vnvApp.factory('doRegister', function($resource) {
     return $resource('/users/register',
        { },
        { query: { 	method:"POST",
            isArray:false,
            headers:{'Content-Type':'application/json; charset=utf-8'}
        }
        }
    );
});

vnvApp.factory('doLogin', function($resource) {
    return $resource('/users/login',
        { },
        { query: { 	method:"POST",
            isArray:false,
            headers:{'Content-Type':'application/json; charset=utf-8'}
        }
        }
    );
});
