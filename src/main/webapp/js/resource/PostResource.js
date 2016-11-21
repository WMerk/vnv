vnvApp.factory('doInsertNewPost', function ($resource) {
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

vnvApp.factory('doLoadCategories', function ($resource) {
    return $resource('/posts/categories',
        {},
        {
            query: {
                method: "GET",
                isArray: false,
            }
        }
    );
});
