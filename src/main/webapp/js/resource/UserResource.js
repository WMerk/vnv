vnvApp.factory('doRegister', function ($resource) {
    return $resource('/users/register',
        {},
        {
            query: {
                method: "POST",
                isArray: false,
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});

vnvApp.factory('doLogin', function ($resource) {
    return $resource('/users/login',
        {},
        {
            query: {
                method: "POST",
                isArray: false,
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});

vnvApp.factory('doLogout', function ($resource) {
    return $resource('/users/logout',
        {},
        {
            query: {
                method: "POST",
                isArray: false,
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});

vnvApp.factory('doDeleteUser', function ($resource) {
    return $resource('/users/delete',
        {},
        {
            query: {
                method: "POST",
                isArray: false,
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});

vnvApp.factory('doUpdateUser', function ($resource) {
    return $resource('/users/update',
        {},
        {
            query: {
                method: "POST",
                isArray: false,
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});

vnvApp.factory('doChangePassword', function ($resource) {
    return $resource('/users/changePassword',
        {},
        {
            query: {
                method: "POST",
                isArray: false,
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});

vnvApp.factory('doLoadAllUsers', function ($resource) {
    return $resource('/users/all?uid=:uid',
        {},
        {
            query: {
                method: "GET",
                isArray: false,
                headers: {'Content-Type': 'application/json; charset=utf-8'},
                params: {uid : '@uid'}
            }
        }
    );
});

