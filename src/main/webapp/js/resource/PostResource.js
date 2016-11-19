vnvApp.factory('doInsertNewPost', function ($resource) {
    return $resource('/post/',
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