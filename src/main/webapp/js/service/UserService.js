vnvApp.service('userService',
    [
        '$cookies',
        function ($cookies) {
            var currentUser = null;
            var newUser = false;
            var accountDeleted = false;

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
                setAccountDeleted: function (value) {
                    accountDeleted = value;
                },
                getAccountDeleted: function () {
                    return accountDeleted;
                },
                clearData: function () {
                    this.setCurrentUser(null);
                },
            };

        }]);