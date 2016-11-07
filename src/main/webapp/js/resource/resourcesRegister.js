vnvApp.factory('doRegisterResource', function($resource) {
     return $resource('/users/register',
        { },
        { query: { 	method:"POST",
            isArray:false,
            headers:{'Content-Type':'application/json; charset=utf-8'}
        }
        }
    );
});
