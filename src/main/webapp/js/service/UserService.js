vnvApp.service('userService',
    [
        '$cookies',
        function ($cookies) {
            var currentUser = null;
            var newUser = false;

            var navigationTemplate = 'html/templates/navigation.html';

            return {
                getCurrentUser: function () {
                    if(currentUser == null){
                        currentUser = $cookies.getObject('currentUser');
                    }
                    return currentUser;
                },
                setCurrentUser: function (value) {
                    $cookies.putObject('currentUser', value);
                    currentUser = value;
                },
                getNewUser: function () {
                    return newUser;
                },
                setNewUser: function (value) {
                    newUser = value;
                },
                getNavigationTemplate: function () {
                    return navigationTemplate;
                },
                clearData: function () {
                    this.setCurrentUser(null);
                },
            };

        }]);