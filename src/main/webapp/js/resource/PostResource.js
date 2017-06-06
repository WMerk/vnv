vnvApp.factory('doCreateNewPost', function ($resource) {
    return $resource('/posts/insert',
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

vnvApp.factory('doUpdatePost', function ($resource) {
    return $resource('/posts/update',
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

vnvApp.factory('doLoadCategories', function ($resource) {
    return $resource('/posts/categories',
        {},
        {
            query: {
                method: "GET",
                isArray: true,
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});

vnvApp.factory('doLoadOffers', function ($resource) {
    return $resource('/posts/own/offers',
        {},
        {
            query: {
                method: "GET",
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});

vnvApp.factory('doLoadRequests', function ($resource) {
    return $resource('/posts/own/requests',
        {},
        {
            query: {
                method: "GET",
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});

vnvApp.factory('doLoadFriendsOffers', function ($resource) {
    return $resource('/posts/friends/offers',
        {},
        {
            query: {
                method: "GET",
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});

vnvApp.factory('doLoadFriendsRequests', function ($resource) {
    return $resource('/posts/friends/requests',
        {},
        {
            query: {
                method: "GET",
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});