vnvApp.service('userService',
    [
        '$cookies',
        function ($cookies) {
            var currentUser = null;
            var newUser = false;
            var offerCreated = false;
            var requestCreated = false;
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
                getOfferCreated: function () {
                    return offerCreated;
                },
                setOfferCreated: function (value) {
                    offerCreated = value;
                },
                getRequestCreated: function () {
                    return requestCreated;
                },
                setRequestCreated: function (value) {
                    requestCreated = value;
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