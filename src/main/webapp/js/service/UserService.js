vnvApp.service('userService', function() {
    var authenticated;
    var currentUser;
    var newUser = false;

    return {
        getCurrentUser: function () {
            return currentUser;
        },
        setCurrentUser: function(value) {
            currentUser = value;
        },
        getNewUser: function () {
            return newUser;
        },
        setNewUser: function(value) {
            newUser = value;
        },
        getAuthenticated: function(){
            return authenticated;
        },
        setAuthenticated: function (value) {
            authenticated = value
        }
    };

});