vnvApp.service('userService', function() {
    var currentUser;

    return {
        getCurrentUser: function () {
            return currentUser;
        },
        setCurrentUser: function(value) {
            currentUser = value;
        }
    };

});