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

vnvApp.factory('doLoadReceivedFriendRequests', function ($resource) {
    return $resource('/users/friends/received?uid=:uid',
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

vnvApp.factory('doLoadSentFriendRequests', function ($resource) {
    return $resource('/users/friends/sent?uid=:uid',
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

vnvApp.factory('doLoadFriends', function ($resource) {
    return $resource('/users/friends?uid=:uid',
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

vnvApp.factory('doSendFriendRequest', function ($resource) {
    return $resource('/users/friend/request',
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

vnvApp.factory('doDeleteFriend', function ($resource) {
    return $resource('/users/friend/delete',
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

vnvApp.factory('doCancelRequest', function ($resource) {
    return $resource('/users/friend/revoke',
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

vnvApp.factory('doDeclineRequest', function ($resource) {
    return $resource('/users/friend/decline',
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

