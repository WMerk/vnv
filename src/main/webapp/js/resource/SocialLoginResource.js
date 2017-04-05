vnvApp.factory('doGoogleLogin', function ($resource) {
    return $resource('/gconfig',
        {},
        {
            query: {
                method: "GET",
                isArray: false,
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        }
    );
});